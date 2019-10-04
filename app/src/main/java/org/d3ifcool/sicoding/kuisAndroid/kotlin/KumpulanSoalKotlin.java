package org.d3ifcool.sicoding.kuisAndroid.kotlin;

public class KumpulanSoalKotlin {
    private String textQuestions[] = {
            "1. Fungsi apa yang untuk menampilkan teks apa adanya.",
            "2. Fungsi apa yang untuk menampilkan teks dalam satu baris.? ",
            "3. Simbol Dollar digunakan untuk?",
            "4. Ada berapa Variabel di Kotlin?",
            "5. Apa yang dimaksud dengan Variabel Imutable?",
            "6. Apa yang dimaksud dengan Variabel Mutable?",
            "7. Source code / kode untuk pembuatan Variabel Imutable",
            "8. Source code / kode untuk pembuatan Variabel Mutable",
            "9. Ada berapa Tipe data dalam Kotlin?",
            "10. Fungsi method toFloat() adalah?"
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"println()", "print()", "readLine()", "Scanner"},
            {"println()", "print()", "readLine()", "Scanner"},
            {"Berpindah Halaman","mengambil nilai dari variabel dan menampilkannya ke dalam teks.","Memasukan Data","Untuk menampilkan teks dalam satu baris"},
            {"3","2","4","5"},
            {"variabel yang bisa diisi lagi nilainya","variabel yang hanya bisa sekali pakai","Yang hanya bisa digunakan Tipe Data Int","Yang hanya bisa digunakan Tipe Data String"},
            {"variabel yang bisa diisi lagi nilainya","variabel yang hanya bisa sekali pakai","Yang hanya bisa digunakan Tipe Data Int","Yang hanya bisa digunakan Tipe Data String"},
            {"var","val","far","fal"},
            {"var","val","far","fal"},
            {"5","2","7","8"},
            {"Mengubah nilai ke dalam tipe String","Mengubah nilai ke dalam tipe Long","Mengubah nilai ke dalam tipe Float","Mengubah nilai ke dalam tipe Int"}
    };

    private String mCorrectAnswers[] = {
            "print()",
            "println()",
            "mengambil nilai dari variabel dan menampilkannya ke dalam teks",
            "2",
            "variabel yang hanya bisa sekali pakai",
            "variabel yang bisa diisi lagi nilainya",
            "val",
            "var",
            "7",
            "Mengubah nilai ke dalam tipe Float"
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