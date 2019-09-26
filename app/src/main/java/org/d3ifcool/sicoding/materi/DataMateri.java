package org.d3ifcool.sicoding.materi;

import java.util.ArrayList;

public class DataMateri {
    public static String[][] data = new String[][]{
            {"Pengenalan HTML","HTML atau Hyper Text Markup Language merupakan bahasa  markah  yang digunakan untuk membuat halaman web dan menampilkan berbagai informasi dalam penjelajah web.\n\nFile HTML dapat dibuat dengan teks editor yang memiliki fitur syntax highlighter seperti Notepad++, Sublime Text, Gedit, Kate, dan lain-lain. Kemudian file HTML disimpan dengan ekstensi html atau htm."},
            {"Sejarah HTML","Hyper Text Markup Language (HTML) pertama kali diciptakan dan dikembangkan oleh Tim Berners-Lee pada awal tahun 1990-an yang pada saat itu masih bekerja di CERN. HTML diciptakan dengan tujuan sebagai cara sederhana namun efektif untuk mengkodekan dokumen elektronik. HTML pertama kali dipopulerkan dengan menggunakan browser Mosaic.\n\n" +
                    "Tahun 1980, IBM memikirkan pembuatan suatu dokumen yang akan mengenali setiap elemen dari dokumen dengan suatu tanda tertentu. IBM kemudian mengembangkan suatu jenis bahasa yang menggabungkan teks dengan perintah-perintah pemformatan dokumen. Bahasa ini dinamakan Markup Language, sebuah bahasa yang menggunakan tanda-tanda sebagai basisnya. IBM menamakan sistemnya ini sebagai Generalized Markup Language atau GML."}
    };

    public static ArrayList<MenuMateri> getListData(){
        ArrayList<MenuMateri> list = new ArrayList<>();
        for (String[] aData :data){
            MenuMateri menu = new MenuMateri();
            menu.setJudul(aData[0]);
            menu.setDesk(aData[1]);
            list.add(menu);
        }

        return list;
    }
}
