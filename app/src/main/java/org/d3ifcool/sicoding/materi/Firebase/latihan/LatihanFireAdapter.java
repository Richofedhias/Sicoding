package org.d3ifcool.sicoding.materi.Firebase.latihan;

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
import org.d3ifcool.sicoding.materi.Firebase.materi.DataMateriFire;
import org.d3ifcool.sicoding.materi.JSON.latihan.DataLatihanJSON;
import org.d3ifcool.sicoding.materi.css.latihanCSS.DataLatihanCSS;
import org.d3ifcool.sicoding.materi.css.latihanCSS.DetailLatihanCSSActivity;
import org.d3ifcool.sicoding.materi.css.latihanCSS.LatihanCSSAdapter;
import org.d3ifcool.sicoding.materi.css.materiCSS.DataMateriCSS;
import org.d3ifcool.sicoding.materi.css.materiCSS.MateriCSSAdapter;

import java.util.ArrayList;

public class LatihanFireAdapter extends RecyclerView.Adapter<LatihanFireAdapter.myViewHolder> {

    Context context;
    ArrayList<DataLatihanFire> lists;

    public LatihanFireAdapter(Context context, ArrayList<DataLatihanFire> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_latihan_fire_item, parent, false);
        return new LatihanFireAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        final DataLatihanFire item = lists.get(position);
        holder.judul.setText(item.getJudul());
        holder.desk.setText(item.getDesk());

        Picasso.get().load(lists.get(position).getImages()).into(holder.images);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailLatihanFireActivity.class);
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

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView judul, desk;
        ImageView images;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tV_contoh_fire);
            desk = itemView.findViewById(R.id.tV_deskContoh_fire);
            images = itemView.findViewById(R.id.iV_contoh_fire);
        }
    }
}
