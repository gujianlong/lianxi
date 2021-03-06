package com.bawei.zhangsan20191224.api;
/*
 *@auther:谷建龙
 *@Date: 2019/12/24
 *@Time:14:03
 *@Description:
 * */


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> getInfoNoParams(@Url String url);

    @POST
    Observable<ResponseBody> postInfoParams(@Url String url, @QueryMap Map<String, Object> map);
}
