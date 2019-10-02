package org.d3ifcool.sicoding.QnA;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.materi.DetailMateriActivity;
import org.d3ifcool.sicoding.materi.MenuMateri;
import org.d3ifcool.sicoding.materi.MenuMateriAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class QnAAdapter extends RecyclerView.Adapter<QnAAdapter.myViewHolder> {

    private ArrayList<QnAList> QnAlist;
    private Context mContext;

    public QnAAdapter(ArrayList<QnAList> qnAlist) {
        QnAlist = qnAlist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_qna_item, parent, false);
        return new QnAAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        final QnAList item = QnAlist.get(position);
        holder.user.setText(item.getUser());
        holder.quest.setText(item.getQuestion());
        holder.image.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return QnAlist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView user ;
        TextView quest ;
        CircleImageView image;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.tV_userQ);
            quest = itemView.findViewById(R.id.tV_quest);
            image = itemView.findViewById(R.id.iV_avatar);
        }
    }
}
