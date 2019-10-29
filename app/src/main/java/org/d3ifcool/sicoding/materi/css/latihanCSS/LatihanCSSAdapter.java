package org.d3ifcool.sicoding.materi.css.latihanCSS;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.HTML.latihanHTML.DetailLatihanActivity;
import org.d3ifcool.sicoding.materi.HTML.latihanHTML.LatihanAdapter;
import org.d3ifcool.sicoding.materi.HTML.latihanHTML.MenuContoh;

import java.util.ArrayList;

public class LatihanCSSAdapter extends RecyclerView.Adapter<LatihanCSSAdapter.myyViewHolder> {
    private ArrayList<DataLatihanCSS> lists;
    private Context mContext;

    public LatihanCSSAdapter(ArrayList<DataLatihanCSS> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_latihan_css_item, parent, false);
        return new LatihanCSSAdapter.myyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myyViewHolder holder, int position) {
        final DataLatihanCSS item = lists.get(position);
        holder.judul.setText(item.getJudul());
        holder.desk.setText(item.getDesk());

        Picasso.get().load(lists.get(position).getImages()).into(holder.images);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailLatihanCSSActivity.class);
                intent.putExtra("judul", item.getJudul());
                intent.putExtra("penjelasan", item.getDesk());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class myyViewHolder extends RecyclerView.ViewHolder {
        TextView judul, desk;
        ImageView images;

        public myyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tV_contoh_css);
            desk = itemView.findViewById(R.id.tV_deskContoh_css);
            images = itemView.findViewById(R.id.iV_contoh_css);
        }
    }
}
