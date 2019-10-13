package org.d3ifcool.sicoding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;

    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        getSupportActionBar().setHomeButtonEnabled(true);

        listItems = getResources().getStringArray(R.array.edit);

        showDialogEditProfile();

    }


    //Pake FloatingButton
    public void showDialogEditProfile() {
        floatingActionButton = findViewById(R.id.fab_edit);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfileActivity.this);
                mBuilder.setTitle("Pilih Salah Satu Untuk Mengedit");
                mBuilder.setItems(listItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0) {
                            showImageProfileEditDialog();
                        } else if (i == 1) {
                            showImageCoverEditDialog();
                        } else if (i == 2) {
                            showNamaEditDialog();
                        } else if (i == 3) {
                            showHobiEditDialog();
                        } else if (i == 4) {
                            showKeterampilanEditDialog();
                        } else if (i == 5) {
                            showMottoEditDialog();
                        }
                    }
                });
//                        .setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        mResult.setText(listItems[i]);
//                        dialogInterface.dismiss();
//                    }
//                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }

    public void showImageCoverEditDialog() {
        String option[] = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Aksi");
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i ==0) {
                    //Camera di klik
                } else if (i == 1) {
                    //Galeri di klik
                }
            }
        });
        builder.create().show();
    }

    public void showImageProfileEditDialog() {
        String option[] = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Aksi");
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i ==0) {
                    //Camera di klik
                } else if (i == 1) {
                    //Galeri di klik
                }
            }
        });
        builder.create().show();
    }

    public void showNamaEditDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfileActivity.this);
        mBuilder.setTitle("Mengubah");
        LinearLayout linlay = new LinearLayout(ProfileActivity.this);
        linlay.setOrientation(LinearLayout.VERTICAL);
        linlay.setPadding(10,10,10,10);

        final EditText editText = new EditText(this);
        editText.setHint("Enter");
        linlay.addView(editText);

        mBuilder.setView(linlay);

        mBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        mBuilder.create().show();
    }

    public void showHobiEditDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfileActivity.this);
        mBuilder.setTitle("Mengubah Hobi");
        LinearLayout linlay = new LinearLayout(ProfileActivity.this);
        linlay.setOrientation(LinearLayout.VERTICAL);
        linlay.setPadding(10,10,10,10);

        final EditText editText = new EditText(this);
        editText.setHint("Enter");
        linlay.addView(editText);

        mBuilder.setView(linlay);

        mBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        mBuilder.create().show();
    }

    public void showKeterampilanEditDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfileActivity.this);
        mBuilder.setTitle("Mengubah Keterampilan");
        LinearLayout linlay = new LinearLayout(ProfileActivity.this);
        linlay.setOrientation(LinearLayout.VERTICAL);
        linlay.setPadding(10,10,10,10);

        final EditText editText = new EditText(this);
        editText.setHint("Enter");
        linlay.addView(editText);

        mBuilder.setView(linlay);

        mBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        mBuilder.create().show();
    }

    public void showMottoEditDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfileActivity.this);
        mBuilder.setTitle("Mengubah Motto Hidup");
        LinearLayout linlay = new LinearLayout(ProfileActivity.this);
        linlay.setOrientation(LinearLayout.VERTICAL);
        linlay.setPadding(10,10,10,10);

        final EditText editText = new EditText(this);
        editText.setHint("Enter");
        linlay.addView(editText);

        mBuilder.setView(linlay);

        mBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        mBuilder.create().show();
    }


    //Pake Menu diatas
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.nav_profile:

                break;
        }
    }
}
