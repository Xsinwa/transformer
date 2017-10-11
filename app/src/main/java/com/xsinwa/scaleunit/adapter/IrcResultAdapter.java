package com.xsinwa.scaleunit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.db.IrcResultInfo;

import java.util.List;

/**
 * Created by Xsinwa on 2017/10/3.
 */
public class IrcResultAdapter extends RecyclerView.Adapter<IrcResultAdapter.ViewHolder>{
    private Context context;
    private List<IrcResultInfo> IrcResultList;

    public IrcResultAdapter(Context context, List<IrcResultInfo> ircResultList) {
        this.context = context;
        IrcResultList = ircResultList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        IrcResultInfo ircResultInfo = IrcResultList.get(position);
        holder.Result.setText(ircResultInfo.getResults());
        holder.mDate.setText(ircResultInfo.getDate());
    }

    @Override
    public int getItemCount() {
        return IrcResultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Result;
        private TextView mDate;

        public ViewHolder(View itemView) {
            super(itemView);

            Result = (TextView) itemView.findViewById(R.id.result);
            mDate = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
