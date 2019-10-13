package org.d3ifcool.sicoding.materi;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuMateri {

    String judul;
    String desk;

    public MenuMateri(String judul) {
        this.judul = judul;
    }


    public MenuMateri() {

    }

    public MenuMateri(String judul, String desk) {
        this.judul = judul;
        this.desk = desk;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
