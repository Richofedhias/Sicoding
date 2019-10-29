package org.d3ifcool.sicoding.materi.HTML.materiHTML;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.d3ifcool.sicoding.R;

public class MenuMateriAdapter extends RecyclerView.Adapter<MenuMateriAdapter.myViewholder> {

    public static final String EXTRA_MESSAGE = "org.d3ifcool.sicoding";
    Context context;
    ArrayList<MenuMateri> menuMateri;

    public MenuMateriAdapter(Context context, ArrayList<MenuMateri> menuMateri) {
        this.context = context;
        this.menuMateri = menuMateri;
    }

    @NonNull
    @Override
    public MenuMateriAdapter.myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_menu_materi_item,parent,false);
        return new MenuMateriAdapter.myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuMateriAdapter.myViewholder holder, final int position) {
        final MenuMateri materi= menuMateri.get(position);

        holder.judulMateri.setText(materi.getJudul());
        holder.descMateri.setText(materi.getDesk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMateriActivity.class);
                intent.putExtra("judul", materi.getJudul());
                intent.putExtra("deskripsi", materi.getDesk());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuMateri.size();
    }

    public class myViewholder extends RecyclerView.ViewHolder{

        TextView judulMateri, descMateri;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            judulMateri = itemView.findViewById(R.id.tv_judulMateri);
            descMateri = itemView.findViewById(R.id.tv_deskMateri);

        }

    }
}