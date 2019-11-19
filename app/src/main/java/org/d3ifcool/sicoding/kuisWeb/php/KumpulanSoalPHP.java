package org.d3ifcool.sicoding.kuisWeb.php;

public class KumpulanSoalPHP {

    private String textQuestions[] = {
            "1. Kepanjangan dari PHP adalah",
            "2. Sebuah perangkat lunak yang bertujuan untuk menginstal atau memasang localhost pada pc atau laptop , disebut",
            "3. Penulisan variable yang tepat pada php adalah",
            "4. berikut merupakan tipe data pada PHP , kecuali",
            "5. Merupakan kode pemograman yang di buat khusus untuk mempersingkat sebuah aksi yang ingin dilakukan di dalam sebuah penulisan kode program , disebut",
            "6. Bagaimanakah penulisan yang tepat untuk menggunakan switch case pada PHP?",
            "7. Bagaimanakah penulisan yang tepat untuk membuat operator aritmatika di PHP?",
            "8. Fungsi php yang digunakan untuk menggabungkan kembali string yang telah dipecahkan menggunakan fungsi explode , merupakan fungsi dari",
            "9. Bagaimanakah penulisan yang tepat untuk menampilkan tanggal di PHP?",
            "10. 1. Mencegah Spam\n" +
                    "2. mencegah serangan brute force\n" +
                    "3. menyimpan database\n" +
                    "4. Membuat form interaktif.\n" +
                    "Manakah yang merupakan fungsi dari captcha",
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"Hypertext Preprocessor", "PostgreSQL", "Hyperlink Prepocessor", "Hypermedia Pocessor"},
            {"MySQL", "XAMPP", "PHP", "Captcha"},
            {"<?php\n" +
                    "$nama;\n" +
                    "?>",
                    "php<?\n" +
                            "$nama;\n" +
                            "?>",
                    "<?php\n" +
                            "Echo nama;\n" +
                            "?>",
                    "<?\n" +
                            "$nama;\n" +
                            "?>"},
            {"Integer", "String", "Private", "float"},
            {"Dinamis", " Captcha", "Pagination", "Function"},
            {"<?php\n" +
                    "$angka = 2;\n" +
                    "switch ($angka) {\n" +
                    "case 1:\n" +
                    "echo \"Isi variabel\";\n" +
                    "break;\n" +
                    "case 2:\n" +
                    "\n" +
                    "echo \"Isi variabel\";\n" +
                    "break;\n" +
                    "}\n" +
                    "\n" +
                    "?>",
                    "<?\n" +
                            "$angka = 2;\n" +
                            "switch ($angka) {\n" +
                            "case 1:\n" +
                            "echo \"Isi variabel\";\n" +
                            "case 2:\n" +
                            "echo \"Isi variabel\";\n" +
                            "break;\n" +
                            "}\n" +
                            "\n" +
                            "?>",
                    "php <?\n" +
                            "$angka = 1;\n" +
                            "switch ($angka) {\n" +
                            "case :\n" +
                            "echo \"Isi variabel\";\n" +
                            "break;\n" +
                            "case sad:\n" +
                            "echo \"Isi variabel\";\n" +
                            "break;\n" +
                            "}\n" +
                            "\n" +
                            "?>",
                    "<?php\n" +
                            "$angka = 3;\n" +
                            "switch () {\n" +
                            "case 1:\n" +
                            "echo \"Isi variabel\";\n" +
                            "break;\n" +
                            "}\n" +
                            "\n" +
                            ">?"},
            {"<?\n" +
                    "$a = 18;\n" +
                    "$b = 8;\n" +
                    "echo $a % $b\n" +
                    "?>",
                    " <?php\n" +
                            "$a = 18;\n" +
                            "$b = 8;\n" +
                            "echo $a % $b;\n" +
                            "?>",
                    "<php\n" +
                            "$a = 18;\n" +
                            "$b = 8;\n" +
                            "echo $a % $b;\n" +
                            "/php>",
                    "<?php\n" +
                            "$a : 18;\n" +
                            "$b : 8;\n" +
                            "Echo “ $a % $b “;\n" +
                            "?>"},
            {"Construct", "Enkapsulasi", "explode", "implode"},
            {"php<?\n" +
                    "echo date(l, d-m-Y);\n" +
                    "?>",
                    " <?php\n" +
                            "echo date('l, d-m-Y');\n" +
                            "?>",
                    "<php\n" +
                            "echo date('l, d-m-Y');\n" +
                            "/php>",
                    "<?php\n" +
                            "date('l, d-m-Y');\n" +
                            "?>"},
            {"1 dan 3", "3 dan 4", "semua benar", "1 dan 2"},
    };

    private String mCorrectAnswers[] = {"Hypertext Preprocessor",
            "XAMPP",
            "<?php\n" +
                    "$nama;\n" +
                    "?>",
            "Private",
            "Function",
            "<?php\n" +
                    "$angka = 2;\n" +
                    "switch ($angka) {\n" +
                    "case 1:\n" +
                    "echo \"Isi variabel\";\n" +
                    "break;\n" +
                    "case 2:\n" +
                    "\n" +
                    "echo \"Isi variabel\";\n" +
                    "break;\n" +
                    "}\n" +
                    "\n" +
                    "?>",
            "<?php\n" +
                    "$a = 18;\n" +
                    "$b = 8;\n" +
                    "echo $a % $b;\n" +
                    "?>",
            "implode",
            "<?php\n" +
                    "echo date('l, d-m-Y');\n" +
                    "?>",
            "1 dan 2"};

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
