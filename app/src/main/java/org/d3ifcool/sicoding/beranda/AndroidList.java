package org.d3ifcool.sicoding.beranda;

public class AndroidList {
    String namaAndLanguage;
    int logoAndLanguage;

    public AndroidList(String namaAndLanguage, int logoAndLanguage) {
        this.namaAndLanguage = namaAndLanguage;
        this.logoAndLanguage = logoAndLanguage;
    }

    public String getNamaAndLanguage() {
        return namaAndLanguage;
    }

    public void setNamaAndLanguage(String namaAndLanguage) {
        this.namaAndLanguage = namaAndLanguage;
    }

    public int getLogoAndLanguage() {
        return logoAndLanguage;
    }

    public void setLogoAndLanguage(int logoAndLanguage) {
        this.logoAndLanguage = logoAndLanguage;
    }
}
