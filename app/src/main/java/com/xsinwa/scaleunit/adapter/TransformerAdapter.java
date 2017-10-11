package com.xsinwa.scaleunit.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xsinwa.scaleunit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xsinwa on 2017/10/3.
 */

public class TransformerAdapter extends RecyclerView.Adapter<TransformerAdapter.ViewHolder> {
    private OnInputOneFillListener oneFillListener;
    private OnInputTwoFillListener twoFillListener;
    private OnInputThreeFillListener threeFillListener;
    private OnGetOneInputListener onGetOneInputListener;
    private ViewHolder viewHolder;

//    private List<String> inputList1 = new ArrayList<>();
//    private List<String> inputList2 = new ArrayList<>();
//    private List<String> inputList3 = new ArrayList<>();
//
//    public TransformerAdapter() {
//    }
//
//    public TransformerAdapter(List<String> inputList1, List<String> inputList2, List<String> inputList3) {
//        this.inputList1 = inputList1;
//        this.inputList2 = inputList2;
//        this.inputList3 = inputList3;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transformer, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position != 0){
            holder.Header.setVisibility(View.GONE);
        }
        holder.Number.setText(""+ (position +1));
        holder.Input1.setTag(position);
        holder.Input2.setTag(position);
        holder.Input3.setTag(position);

//        if (inputList1.size() > 0){
//            if (position < inputList1.size()) {
//                if (!TextUtils.isEmpty(inputList1.get(position))) {
//                    holder.Input1.setText(inputList1.get(position));
//                }
//            }
//        }
//        if (inputList2.size() > 0){
//            if (position < inputList2.size()) {
//                if (!TextUtils.isEmpty(inputList2.get(position))) {
//                    holder.Input2.setText(inputList2.get(position));
//                }
//            }
//        }
//        if (inputList3.size() > 0){
//            if (position < inputList3.size()) {
//                if (!TextUtils.isEmpty(inputList3.get(position))) {
//                    holder.Input3.setText(inputList3.get(position));
//                }
//            }
//        }

        holder.Input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Integer.parseInt(holder.Input1.getTag().toString()) == position ){
//                    if (position < inputList1.size()){
//                        if (!TextUtils.isEmpty(inputList1.get(position))) {
//                            holder.Input1.removeTextChangedListener(this);
//                            int len = inputList1.get(position).length() - 1;
//                            s.replace(0, len, inputList1.get(position).substring(0, len));
//                            holder.Input1.addTextChangedListener(this);
//                        }
//                    }
                    oneFillListener.onInputOneFill(position, s.toString());
                }
            }
        });

        holder.Input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Integer.parseInt(holder.Input2.getTag().toString()) == position ){
                    twoFillListener.onInputTwoFill(position, s.toString());
                }
            }
        });

        holder.Input3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Integer.parseInt(holder.Input3.getTag().toString()) == position ){
                    threeFillListener.onInputThreeFill(position, s.toString());
                }
            }
        });

    }
     public interface OnGetOneInputListener{
         String getOneInputContent(String s);
     }

    public interface OnInputOneFillListener{
        void onInputOneFill(int position, String s);
    }

    public void setOnInputOneFillListener(OnInputOneFillListener oneFillListener){
        this.oneFillListener = oneFillListener;
    }

    public interface OnInputTwoFillListener{
        void onInputTwoFill(int position, String s);
    }

    public void setOnInputTwoFillListener(OnInputTwoFillListener twoFillListener){
        this.twoFillListener = twoFillListener;
    }

    public interface OnInputThreeFillListener{
        void onInputThreeFill(int position, String s);
    }

    public void setOnInputThreeFillListener(OnInputThreeFillListener threeFillListener){
        this.threeFillListener = threeFillListener;
    }

    @Override
    public int getItemCount() {
        return 17;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout Header;
        private TextView Number;
        private EditText Input1;
        private EditText Input2;
        private EditText Input3;

        public ViewHolder(View itemView) {
            super(itemView);

            Header = (LinearLayout) itemView.findViewById(R.id.header);
            Number = (TextView) itemView.findViewById(R.id.number);
            Input1 = (EditText) itemView.findViewById(R.id.input1);
            Input2 = (EditText) itemView.findViewById(R.id.input2);
            Input3 = (EditText) itemView.findViewById(R.id.input3);

        }
    }
}
