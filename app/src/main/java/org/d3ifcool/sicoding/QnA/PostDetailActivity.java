package org.d3ifcool.sicoding.QnA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.d3ifcool.sicoding.R;
import org.d3ifcool.sicoding.beranda.BerandaActivity;

import java.util.Calendar;
import java.util.Locale;

public class PostDetailActivity extends AppCompatActivity {

    String myUid,myEmail,myName,myDp,postId,pLikes,hisDp,hisName;

    ImageView uPictureIv,pImageIv;
    TextView nameTv,pTimeTv,pTitleTv,pDescTv,pLikesTv;
    ImageButton morebtn;
    Button likebtn,sharebtn;
    LinearLayout profileLayout;

    ProgressDialog pd;

    //add comment view
    EditText commentEt;
    ImageButton sendBtn;
    ImageView cAvatarIv;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        //ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Post Detail");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //get id
        Intent intent = getIntent();
        postId = intent.getStringExtra("postId");



        //init
        uPictureIv = findViewById(R.id.iV_avatar);
        pImageIv = findViewById(R.id.imagePost);
        nameTv = findViewById(R.id.tV_userQ);
        pTimeTv = findViewById(R.id.tV_TimeQ);
        pTitleTv = findViewById(R.id.tV_TitlePost);
        pDescTv = findViewById(R.id.tV_descriptionPost);
        pLikesTv = findViewById(R.id.tv_Like);
        morebtn = findViewById(R.id.moreBtn);
        likebtn = findViewById(R.id.btn_like);
        sharebtn = findViewById(R.id.btn_share);
//        profileLayout = findViewById(R.id.profileLayout);

        commentEt = findViewById(R.id.commentEt);
        sendBtn = findViewById(R.id.sendBtn);
        cAvatarIv = findViewById(R.id.cAvatarIV);

        loadPostInfo();

        checkUserStatus();

        loadUserInfo();


        actionBar.setSubtitle("Signed as :"+myEmail);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postComment();
            }
        });

    }

    private void postComment() {
        pd = new ProgressDialog(this);
        pd.setMessage("Adding Comment...");

        String comment = commentEt.getText().toString().trim();
        if (TextUtils.isEmpty(comment)){
            Toast.makeText(this, "Comment kosong ...", Toast.LENGTH_SHORT).show();
            //sampe sini
            return;
        }
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Post").child(postId).child("Comments");

    }

    private void loadUserInfo() {
        Query query = FirebaseDatabase.getInstance().getReference("User");
        query.orderByChild("uid").equalTo(myUid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    myName = ""+ds.child("name").getValue();
                    myDp = ""+ds.child("image").getValue();

                    try {
                        Picasso.get().load(R.drawable.ic_launcher_background).into(cAvatarIv);
                    }catch (Exception e){
                        Picasso.get().load(R.drawable.ic_launcher_background).into(cAvatarIv);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void loadPostInfo() {
        //get Post Using the id
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Post");
        Query query = reference.orderByChild("pId").equalTo(postId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){

                    String pTitle = ""+ds.child("mTitle").getValue();
                    String pDesc = ""+ds.child("mDesc").getValue();
                    pLikes = ""+ds.child("pLikes").getValue();
                    String pTimeStamp = ""+ds.child("pTime").getValue();
                    String pImage = ""+ds.child("pImage").getValue();
                    hisDp =""+ds.child("uDp").getValue();
                    String uid = ""+ds.child("uid").getValue();
                    hisName = ""+ds.child("uName").getValue();

                    Calendar calendar = Calendar.getInstance(Locale.getDefault());
                    calendar.setTimeInMillis(Long.parseLong(pTimeStamp));
                    final String pTime = DateFormat.format("dd/MM/yyyy hh:mm:aa", calendar).toString();

                    //set data
                    pTitleTv.setText(pTime);
                    pDescTv.setText(pDesc);
                    pLikesTv.setText(pLikes);
                    pTimeTv.setText(pTime);

                    nameTv.setText(hisName);

                    if (pImage.equals("noImage")) {
                        pImageIv.setVisibility(View.GONE);
                    } else {
                        pImageIv.setVisibility(View.VISIBLE);
                        try {
                            Picasso.get().load(pImage).into(pImageIv);
                        } catch (Exception e) {

                        }
                    }

                    try{
                        Picasso.get().load(hisDp).placeholder(R.drawable.ic_launcher).into(uPictureIv);
                    }catch (Exception e){
                        Picasso.get().load(R.drawable.ic_launcher).into(uPictureIv);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void checkUserStatus(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            //user is login
            myEmail = user.getEmail();
            myUid = user.getUid();

        }
        else {
            //user not login
            startActivity(new Intent(this, BerandaActivity.class));
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_post,menu);
        menu.findItem(R.id.action_post).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Logout

        return super.onOptionsItemSelected(item);
    }
}
