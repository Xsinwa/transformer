package com.xsinwa.scaleunit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xsinwa.scaleunit.R;

import java.util.List;

/**
 * Created by Xsinwa on 2017/10/3.
 */
public class BbrcTransAdapter extends RecyclerView.Adapter <BbrcTransAdapter.ViewHolder>{
    private List<String> outputList;

    public BbrcTransAdapter(List<String> outputList) {
        this.outputList = outputList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bbrctrans, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position != 0){
            holder.Header.setVisibility(View.GONE);
        }
        holder.Number.setText("" + (position + 1));
        if (position <= outputList.size() -1) {
            holder.Rx.setText(outputList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return outputList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout Header;
        private TextView Number;
        private TextView Rx;

        public ViewHolder(View itemView) {
            super(itemView);

            Header = (LinearLayout) itemView.findViewById(R.id.header);
            Number = (TextView) itemView.findViewById(R.id.number);
            Rx = (TextView) itemView.findViewById(R.id.Rx);
        }
    }
}
