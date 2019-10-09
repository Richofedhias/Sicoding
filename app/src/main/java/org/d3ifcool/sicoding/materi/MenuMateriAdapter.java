package org.d3ifcool.sicoding.materi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;

public class MenuMateriAdapter extends RecyclerView.ViewHolder {

    View view;

    public MenuMateriAdapter(View itemView){
        super(itemView);
        view=  itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });
    }


    public void setDetail(Context context, String title , String desk){
        TextView mTitle = view.findViewById(R.id.tv_judulMateri);
        TextView mDesk = view.findViewById(R.id.tv_deskMateri);
        mTitle.setText(title);
        mDesk.setText(desk);
    }

    public void setDetails(Context context, String title , String desk){

    }

    private MenuMateriAdapter.ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View view, int position);
        void  onItemLongClick (View view , int position);
    }

    public void setOnClickListener(MenuMateriAdapter.ClickListener clickListener){
        mClickListener = clickListener;
    }
}