package com.xsinwa.scaleunit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.db.DrcResultInfo;

import java.util.List;

/**
 * Created by Xsinwa on 2017/10/2.
 */

public class DrcResultAdapter extends RecyclerView.Adapter<DrcResultAdapter.ViewHodler> {
    private Context context;
    private List<DrcResultInfo> drcResultInfoList;

    public DrcResultAdapter(Context context, List<DrcResultInfo> drcResultInfoList) {
        this.context = context;
        this.drcResultInfoList = drcResultInfoList;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item,parent,false);
        DrcResultAdapter.ViewHodler hodler = new ViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {
        DrcResultInfo drcResultInfo = drcResultInfoList.get(position);
        holder.Result.setText(drcResultInfo.getResult());
        holder.mDate.setText(drcResultInfo.getDate());
    }

    @Override
    public int getItemCount() {
        return drcResultInfoList.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder{
        private TextView Result;
        private TextView mDate;

        public ViewHodler(View itemView) {
            super(itemView);

            Result = (TextView) itemView.findViewById(R.id.result);
            mDate = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
