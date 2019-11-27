package org.d3ifcool.sicoding.materi.HTML.latihanHTML;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import thereisnospon.codeview.CodeView;

import com.squareup.picasso.Picasso;

import org.d3ifcool.sicoding.R;

import java.util.ArrayList;

public class LatihanAdapter extends RecyclerView.Adapter<LatihanAdapter.myyViewHolder> {

    public static final String EXTRA_MESSAGE = "org.d3ifcool.sicoding";
    private ArrayList<MenuContoh> lists;
    private Context mContext;

    public LatihanAdapter(ArrayList<MenuContoh> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LatihanAdapter.myyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_contoh_item, parent, false);
        return new LatihanAdapter.myyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatihanAdapter.myyViewHolder holder, int position) {
        final MenuContoh item = lists.get(position);
        holder.judul.setText(item.getJudul());
        holder.desk.showCode(item.getDesk());

        Picasso.get().load(lists.get(position).getImages()).into(holder.images);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), DetailLatihanActivity.class);
//                intent.putExtra("judul", item.getJudul());
//                intent.putExtra("penjelasan", item.getDesk());
//                view.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myyViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        CodeView desk;
        ImageView images;

        public myyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tV_contoh);
            desk = itemView.findViewById(R.id.tV_Latihan_html);
            images = itemView.findViewById(R.id.iV_contoh);
        }
    }
}
