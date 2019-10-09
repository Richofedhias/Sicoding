package org.d3ifcool.sicoding.beranda;

public class DatabaseList {
    String namaDBLanguage;
    int logoDBLanguage;

    public DatabaseList(String namaDBLanguage, int logoDBLanguage) {
        this.namaDBLanguage = namaDBLanguage;
        this.logoDBLanguage = logoDBLanguage;
    }

    public String getNamaDBLanguage() {
        return namaDBLanguage;
    }

    public void setNamaDBLanguage(String namaDBLanguage) {
        this.namaDBLanguage = namaDBLanguage;
    }

    public int getLogoDBLanguage() {
        return logoDBLanguage;
    }

    public void setLogoDBLanguage(int logoDBLanguage) {
        this.logoDBLanguage = logoDBLanguage;
    }
}
