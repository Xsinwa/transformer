package com.xsinwa.scaleunit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.db.ResultInfo;

import java.util.List;

/**
 * Created by Xsinwa on 2017/10/2.
 */

public class ResultDisplayAdapter extends RecyclerView.Adapter <ResultDisplayAdapter.ViewHolder>{
    private Context context;
    private List<ResultInfo> ResultList;

    public ResultDisplayAdapter(Context context, List<ResultInfo> resultList) {
        this.context = context;
        ResultList = resultList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        final  ViewHolder hodler = new ViewHolder(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultInfo resultInfo = ResultList.get(position);
        holder.Result.setText(resultInfo.getResult());
        holder.mDate.setText(resultInfo.getDate());
    }


    @Override
    public int getItemCount() {
        return ResultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Result;
        private TextView mDate;

        public ViewHolder(View view) {
            super(view);
            Result = (TextView) view.findViewById(R.id.result);
            mDate = (TextView) view.findViewById(R.id.date);
        }
    }
}
