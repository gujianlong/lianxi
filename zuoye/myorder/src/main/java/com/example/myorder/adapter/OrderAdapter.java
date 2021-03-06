package com.example.myorder.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/12
 *@Time:16:53
 *@Description:
 * */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myorder.R;
import com.example.myorder.bean.OrderBean;
import com.example.myorder.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OneViewHolder> {


    private final List<OrderBean.OrderListBean> list;
    private final Context context;

    public OrderAdapter(List<OrderBean.OrderListBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_order, parent, false);
        return new OneViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OneViewHolder holder, int position) {
        OrderBean.OrderListBean orderListBean = list.get(position);
        holder.oneId.setText(orderListBean.getOrderId());
        int orderStatus = orderListBean.getOrderStatus();
        if (orderStatus == 1) {
            holder.oneTime.setVisibility(View.GONE);
            holder.oneButton.setVisibility(View.VISIBLE);
            holder.oneButton.setText("去支付");
        } else if (orderStatus == 2) {
            holder.oneTime.setVisibility(View.GONE);
            holder.oneButton.setVisibility(View.VISIBLE);
            holder.oneButton.setText("确认收货");
        } else if (orderStatus == 3) {
            holder.oneTime.setText(orderListBean.getOrderTime() + "");
            holder.oneButton.setVisibility(View.GONE);
        } else if (orderStatus == 9) {
            holder.oneTime.setText(orderListBean.getOrderTime() + "");
            holder.oneButton.setVisibility(View.GONE);
        }
        TwoOrderAdapter twoOrderAdapter = new TwoOrderAdapter(list.get(position).getDetailList(), context);
        holder.oneRv.setAdapter(twoOrderAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.one_id)
        TextView oneId;
        @BindView(R.id.one_rv)
        RecyclerView oneRv;
        @BindView(R.id.one_time)
        TextView oneTime;
        @BindView(R.id.one_button)
        Button oneButton;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            oneRv.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    class TwoOrderAdapter extends RecyclerView.Adapter<TwoOrderAdapter.TwoHolder> {
        private List<OrderBean.OrderListBean.DetailListBean> list;
        private Context context;

        public TwoOrderAdapter(List<OrderBean.OrderListBean.DetailListBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public TwoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two_order, parent, false);
            return new TwoHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull TwoHolder holder, int position) {
            holder.twoName.setText(list.get(position).getCommodityName());
            holder.twoPrice.setText(list.get(position).getCommodityPrice()+"");
            OrderBean.OrderListBean.DetailListBean detailListBean = list.get(position);
            String commodityPic = detailListBean.getCommodityPic();
            String[] split = commodityPic.split(",");
            GlideUtils.loadImage(split[0], holder.twoImage);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class TwoHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.two_image)
            ImageView twoImage;
            @BindView(R.id.two_name)
            TextView twoName;
            @BindView(R.id.two_price)
            TextView twoPrice;

            public TwoHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

    }

}
