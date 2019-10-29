package org.d3ifcool.sicoding.QnA;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.d3ifcool.sicoding.R;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.myViewHolder> {
    Context context;
    List<ModelComment> commentList;

    public CommentAdapter(Context context, List<ModelComment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_comment_item, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        String uid = commentList.get(position).getUid();
        String name = commentList.get(position).getuName();
        String email = commentList.get(position).getuEmail();
        String image = commentList.get(position).getuDp();
        String cid = commentList.get(position).getcId();
        String comment = commentList.get(position).getComment();
        String timestamp = commentList.get(position).getTimestamp();

//        Calendar calendar = Calendar.getInstance(Locale.getDefault());
//        calendar.setTimeInMillis(Long.parseLong(timestamp));
//        String pTime = DateFormat.format("dd/MM/yyyy hh:mm:aa", calendar).toString();

        holder.nameTv.setText(name);
        holder.commentTv.setText(comment);
        holder.timeTv.setText(timestamp);

        try {
            Picasso.get().load(image).placeholder(R.mipmap.ic_launcher).into(holder.avatarIv);
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarIv;
        TextView nameTv, commentTv, timeTv;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarIv = itemView.findViewById(R.id.avatarIv);
            nameTv = itemView.findViewById(R.id.nameTv);
            commentTv= itemView.findViewById(R.id.commentTv);
            timeTv = itemView.findViewById(R.id.timeTv);
        }
    }
}
