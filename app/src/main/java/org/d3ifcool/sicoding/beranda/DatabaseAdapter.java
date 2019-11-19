package org.d3ifcool.sicoding.beranda;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.Firebase.ListMateriFireActivity;
import org.d3ifcool.sicoding.materi.JSON.ListMateriJSONActivity;
import org.d3ifcool.sicoding.materi.mySQL.ListMateriMSYQLActivity;

import java.util.ArrayList;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.myViewHolder> {

    Context context;
    ArrayList<DatabaseList> isiDatabaselist;

    public DatabaseAdapter(Context context, ArrayList<DatabaseList> isiDatabaselist) {
        this.context = context;
        this.isiDatabaselist = isiDatabaselist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_database_language_item, parent, false);
        DatabaseAdapter.myViewHolder viewHolder = new DatabaseAdapter.myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.nama.setText(isiDatabaselist.get(position).getNamaDBLanguage());
        holder.logo.setImageResource(isiDatabaselist.get(position).getLogoDBLanguage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (position == 0) {
                    intent = new Intent(view.getContext(), ListMateriJSONActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 1) {
                    intent = new Intent(view.getContext(), ListMateriFireActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 2) {
                    intent = new Intent(view.getContext(), ListMateriMSYQLActivity.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return isiDatabaselist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        ImageView logo;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tV_namaDBLanguage);
            logo = itemView.findViewById(R.id.iV_logoDBLanguage);
        }
    }
}
