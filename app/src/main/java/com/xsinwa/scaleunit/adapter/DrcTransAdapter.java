package com.xsinwa.scaleunit.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xsinwa.scaleunit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xsinwa on 2017/10/3.
 */

public class DrcTransAdapter extends RecyclerView.Adapter<DrcTransAdapter.ViewHolder> {
    private List<String> output1List = new ArrayList<String>();
    private List<String> output2List = new ArrayList<String>();
    private List<String> output3List = new ArrayList<String>();

    public DrcTransAdapter(List<String> output1List, List<String> output2List, List<String> output3List) {
        this.output1List = output1List;
        this.output2List = output2List;
        this.output3List = output3List;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drc_trans, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position != 0 ){
            holder.Header.setVisibility(View.GONE);
        }
        holder.Number.setText("" + (position + 1));
        if (position <= output1List.size()-1) {
            holder.output1.setText(output1List.get(position));
        }
        if (position <= output2List.size()-1) {
            holder.output2.setText(output2List.get(position));
        }
        if (position <= output3List.size()-1) {
            holder.output3.setText(output3List.get(position));
        }
    }

    @Override
    public int getItemCount() {
        int size = getMaxSize(output1List, output2List, output3List);
        return size;
    }

    private int getMaxSize(List<String> list1, List<String> list2, List<String> list3) {
        int a = list1.size();
        int b = list2.size();
        int c= list3.size();
        return Math.max(Math.max(a, b), Math.max(a, c));
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout Header;
        private TextView Number;
        private TextView output1;
        private TextView output2;
        private TextView output3;

        public ViewHolder(View itemView) {
            super(itemView);

            Header = (LinearLayout) itemView.findViewById(R.id.header);
            Number = (TextView) itemView.findViewById(R.id.number);
            output1 = (TextView) itemView.findViewById(R.id.output1);
            output2 = (TextView) itemView.findViewById(R.id.output2);
            output3 = (TextView) itemView.findViewById(R.id.output3);
        }
    }
}
