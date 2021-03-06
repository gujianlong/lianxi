package com.example.zuoye3.base;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:15:32
 *@Description:
 * */


import com.example.zuoye3.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends Contract.IView> implements Contract.IPresenter{
    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
    protected void onAttch(V v){
        mWeak=new WeakReference<>(v);
    }
    protected void onDeAttch(){
        if (mWeak != null) {
            mWeak.clear();
            mWeak=null;
        }
    }
    protected V getView(){
        return mWeak.get();
    }
}
