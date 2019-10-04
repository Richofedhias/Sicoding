package org.d3ifcool.sicoding.kuisAndroid.java;

public class KumpulanSoalJava {
    private String textQuestions[] = {
            "1. Objek apa yang disimpan di dalam onSaveInstanceState?",
            "2. Berapa banyak jenis intent? ",
            "3. Widget / Komponen apa yang digunakan untuk menampilkan gambar?",
            "4. Widget apa yang dibuat untuk memasukan huruf/angka?",
            "5. Apa saja jenis intent?",
            "6. File manakah yang bisa kita gunakan jika kita ingin membuat tema baru?",
            "7. Berikut adalah pernyataan yang benar mengenai RecyclerView dan ListView ?",
            "8. Library apa yang digunakan untuk mengambil data berupa gambar",
            "9. Fragment adalah?",
            "10. Saat apa onAttach dipanggil di fragment?"
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"Activity", "Bundles", "String", "Int"},
            {"4","5","1","2"},
            {"Button","Image View","Edit Text","Text View"},
            {"Edit Text","Text View","Button","Spinner"},
            {"Explicit dan Ekternal","Internal dan Implicit","Explicit dan Implicit","Eksternal dan Internal"},
            {"Dimens.xml","Strings.xml","Colors.xml","Styles.xml"},
            {"RecyclerView lebih cocok untuk data yang statik", "RecyclerView lebih powerful dan fleksibel daripada ListView", "RecyclerView lebih sulit untuk mengatur OnItemTouchListener", "ListView lebih bagus dalam menampilkan animasi"},
            {"Piccaso","Esspreso","Rest Api","CalendarPicker"},
            {"Sebuah reuseable class yang mengimplement beberapa fitur sebuah Activity.","sebuah komponen aplikasi yang menyediakan layar yang digunakan pengguna untuk berinteraksi guna melakukan sesuatu","sebuah kelas dalam programming Android yang berfungsi untuk perpindahan halaman.","tata letak dari suatu elemen desain yang di tempatkan dalam sebuah bidang menggunakan sebuah media yang sebelumnya sudah di konsep terlebih dahulu."},
            {"dipanggil saat sebuah fragment terhubung ke activity.","dipanggil saat sebuah fragment dibuat (objeknya di memori).","dipanggil setelah fragment siap untuk ditampilkan di layar.","dipanggil jika fragment sudah tidak dipakai"}
    };

    private String mCorrectAnswers[] = {
            "Bundles",
            "Edit Text",
            "2",
            "Image View",
            "Explicit dan Implicit",
            "Styles.xml",
            "RecyclerView lebih powerful dan fleksibel daripada ListView",
            "Piccaso",
            "Sebuah reuseable class yang mengimplement beberapa fitur sebuah Activity.",
            "dipanggil saat sebuah fragment terhubung ke activity"
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
