package org.d3ifcool.sicoding.beranda;

public class IsiBeranda {
    String namaLanguage;
    int logoLanguage;

    public IsiBeranda(String namaLanguage, int logoLanguage) {
        this.namaLanguage = namaLanguage;
        this.logoLanguage = logoLanguage;
    }

    public String getNamaLanguage() {
        return namaLanguage;
    }

    public void setNamaLanguage(String namaLanguage) {
        this.namaLanguage = namaLanguage;
    }

    public int getLogoLanguage() {
        return logoLanguage;
    }

    public void setLogoLanguage(int logoLanguage) {
        this.logoLanguage = logoLanguage;
    }
}
