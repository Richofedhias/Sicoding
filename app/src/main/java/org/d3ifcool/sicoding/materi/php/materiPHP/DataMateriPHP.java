package org.d3ifcool.sicoding.materi.php.materiPHP;

public class DataMateriPHP {
    String judul;
    String desk;

    public DataMateriPHP() {
    }

    public DataMateriPHP(String judul, String desk) {
        this.judul = judul;
        this.desk = desk;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }
}
