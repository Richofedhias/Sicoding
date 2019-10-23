package org.d3ifcool.sicoding.materi;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.net.ContentHandler;
import java.util.ArrayList;

public class DataLatihan {
    public static String[][] data = new String[][] {
            {"Tag Pada HTML","<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<title>Page Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h1>This is a Heading</h1>\n" +
                    "<p>This is a paragraph.</p>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>"},
            {"Sejarah HTML","Hyper Text Markup Language (HTML) pertama kali diciptakan dan dikembangkan oleh Tim Berners-Lee pada awal tahun 1990-an yang pada saat itu masih bekerja di CERN. HTML diciptakan dengan tujuan sebagai cara sederhana namun efektif untuk mengkodekan dokumen elektronik. HTML pertama kali dipopulerkan dengan menggunakan browser Mosaic.\n\n" +
                    "Tahun 1980, IBM memikirkan pembuatan suatu dokumen yang akan mengenali setiap elemen dari dokumen dengan suatu tanda tertentu. IBM kemudian mengembangkan suatu jenis bahasa yang menggabungkan teks dengan perintah-perintah pemformatan dokumen. Bahasa ini dinamakan Markup Language, sebuah bahasa yang menggunakan tanda-tanda sebagai basisnya. IBM menamakan sistemnya ini sebagai Generalized Markup Language atau GML."}
    };

    public static ArrayList<MenuContoh> getListData(){
        ArrayList<MenuContoh> list = new ArrayList<>();
        for (String[] aData :data){
            MenuContoh menu = new MenuContoh();
            menu.setJudul(aData[0]);
            menu.setDesk(aData[1]);
            list.add(menu);
        }
        return list;
    }
}
