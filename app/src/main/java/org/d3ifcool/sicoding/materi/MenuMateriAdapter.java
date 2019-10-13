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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.d3ifcool.sicoding.R;

public class MenuMateriAdapter extends RecyclerView.ViewHolder {

    View view;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

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


//    public void setDetail(Context context, String title , String desk){
//        TextView mTitle = view.findViewById(R.id.tv_judulMateri);
//        TextView mDesk = view.findViewById(R.id.tv_deskMateri);
//        mTitle.setText(title);
//        mDesk.setText(desk);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        reference = firebaseDatabase.getReference();
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                MenuMateri menuMateri = dataSnapshot.getValue(MenuMateri.class);
//                mAuthorView.setText(post.author);
//                mTitleView.setText(post.title);
//                mBodyView.setText(post.body);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

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