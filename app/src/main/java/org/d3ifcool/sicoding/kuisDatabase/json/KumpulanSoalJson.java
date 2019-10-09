package org.d3ifcool.sicoding.kuisDatabase.json;

public class KumpulanSoalJson {
    private String textQuestions[] = {
            "1. Sebuah library framework css yang dibuat khusus untuk bagian pengembangan front-end website, disebut",
            "2. Class tambahan untuk membuat table dengan menggunakan bootstrap , class ini berfungsi untuk membuat baris table yang bergaya belang-beling (strip) , merupakan fungsi dari:",
            "3. Class ini digunakan untuk membuat gambar berbentuk round atau pada sisi sudut gambar memiliki bentuk melengkung, merupakan fungsi dari",
            "4. Class bootstrap yang digunakan untuk membuat tombol dengan ukuran terkecil , sedang, maupun terbesar , adalah , kecuali",
            "5. Semacam bentuk yang dibuat dengan tujuan membuat sejenis pengumuman , konten khusus atau informasi tentang halaman website , disebut",
            "6. Membuat pesan alert yang berwarna kuning, biasanya digunakan untuk membuat pesan yang berupa peringatan, merupakan fungsi dari",
            "7. Mengatur grid pada monitor computer yang berukuran besar, merupakan fungsi dari",
            "8. Proses penampilan gambar yang diberi efek slide, dan biasanya diletakkan pada halaman depan sebuah website dengan design yang bermacam-macam , merupakan fungsi dari",
            "9. Class yang disediakan bootstrap untuk membuat panel bagian badan , merupakan fungsi dari",
            "10. Suatu metode untuk membagi suatu dokumen atau resource menjadi bagian-bagian lebih kecil yang saling terpisah, disebut"
};

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            //1

            {"Merupakan suatu format untuk mengedit data.",
                    "Merupakan suatu project untuk aplikasi.",
                    "Merupakan suatu variable untuk menyimpan data atau digunakan dalam sebuah proses pertukaran data.",
                    "Merupakan suatu syntax atau format untuk menyimpan data atau digunakan dalam sebuah proses pertukaran data."},
            //2
            {"employeeName.setText(“Name: ” +name);",
                    "JSONObject ob = new JSONObject(JSON_STRING);",
                    "name = employee.getString(“name”);",
                    "JSONObject employee = obj.getJSONObject(“employee”);"},
            //3
            {"Array",
                    "Object",
                    "Null",
                    "Boolean"},
            //4
            {"JSON.obj()",
                    "JSON.parse()",
                    "JSON.adapter()",
                    "JSON.parsing()"},
            //5
            {"Bill Gate",
                    "Albert Einstein",
                    "James Tamplin dan Andrew Lee",
                    "Douglas Crockford"},
            //6
            {"Fungsi JSON",
                    "Deskripsi JSON",
                    "Macam JSON",
                    "Sejarah JSON"},
            //7
            {"Untuk menghasilkan JSON dari Array Assosiatif",
                    "Untuk mengubah JSON menjadi Array",
                    "Untuk Mengubah Array menjadi JSON",
                    "Untuk Menghasilkan JSON dari Object Assosiatif"},
            //8
            {"Untuk menghasilkan JSON dari Array Assosiatif",
                    "Untuk mengubah JSON menjadi Array",
                    "Untuk Mengubah Array menjadi JSON",
                    "Untuk Menghasilkan JSON dari Object Assosiatif"},
            //9
            {"XML tidak perlu diurai dengan parse XML. JSON tidak harus diurai oleh parse JSON.",
                    "XML dan JSON sama-sama terdapat parse.",
                    "XML harus diurai dengan parser XML. JSON bisa diurai oleh fungsi JavaScript standar.",
                    "XML harus diurai dengan fungsi JavaScript standar. JSON bisa diurai dengan parse JSON."},
            //10
            {"Java Script Online Notation",
                    "Java Scholar Object Notation",
                    "Java Script Object Notation",
                    "Java Script Object Naration"}
    };

    private String mCorrectAnswers[] = {
            //1
            "Merupakan suatu syntax atau format untuk menyimpan data atau digunakan dalam sebuah proses pertukaran data.",
            //2
            "JSONObject employee = obj.getJSONObject(“employee”);",
            //3
            "Array",
            //4
            "JSON.parse()",
            //5
            "Douglas Crockford",
            //6
            "Fungsi JSON",
            //7
            "Untuk menghasilkan JSON dari Array Assosiatif",
            //8
            "Untuk mengubah JSON menjadi Array",
            //9
            "XML harus diurai dengan parser XML. JSON bisa diurai oleh fungsi JavaScript standar.",
            //10
            "Java Script Object Notation"
    };

    public int getLength() {
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num - 1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}

