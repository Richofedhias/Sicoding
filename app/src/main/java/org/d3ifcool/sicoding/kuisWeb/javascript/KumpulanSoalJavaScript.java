package org.d3ifcool.sicoding.kuisWeb.javascript;

public class KumpulanSoalJavaScript {
    private String textQuestions[] = {
            "1. Berikut ini merupakan tipe data pada javascript, kecuali",
            "2. Tipe data yang mampu menyimpan banyak data di dalam satu buah variable disebut",
            "3. Macam macam event pada javascript, kecuali",
            "4. Penulisan yang tepat dalam membuat event klik pada sebuah tombol ketika ingin menampilkan sebuah keterangan nama",
            "5. Tipe data yang tersusun dari huruf atau kata adalah",
            "6. Fungsi yang berguna untuk membuat pengecekan sebuah nilai dan nilai yang tersedia bisa lebih dari satu adalah",
            "7. berikut function javascript yang dapat digunakan untuk memanipulasi string, kecuali..",
            "8. Penulisan script yang tepat membuat variable nama dan alamat pada javascript",
            "9. Menampilkan string dari karakter ke berapa sampai ke berapa disebut",
            "10.Penulisan script yang tepat untuk menampilkan tanggal dengan javascript",
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"Number", "String", "Boolean", "Script"},
            {"Array", "Number", "String", "Boolean"},
            {"Onclick", "Onchange", "Onpause", "Onload"},
            {"<button onclick=\"tampilkan_nama()\">KLIK</button>", "<button onklik=”tampilkan_nama()”>Click</button>", "<button onpause=”tampilkan_nama()”>Klik</button>", "<button onchange=”tampilkan_nama()”>Klik</button>"},
            {"Number", "String", "Boolean", "Script"},
            {"if", "else", "switch case", "case"},
            {"Length", "Search()", "Substring()", "Array"},
            {"<Script>\n" +
                    "Var nama = “siCoding”;\n" +
                    "Var alamat = “bandung”;\n" +
                    "document.getElementById(\"nama\").innerHTML = nama;\n" +
                    "document.getElementById(\"alamat\").innerHTML = alamat;\n" +
                    "\n" +
                    "</script>", "<script>\n" +
                    "Var nama = “siCoding”;\n" +
                    "Var alamat = “bandung”;\n" +
                    "document.getElement(\"nama\").innerHTML = nama;\n" +
                    "document.getElement(\"alamat\").innerHTML = alamat;\n" +
                    "</script>", "<script>\n" +
                    "Var nama = “siCoding”;\n" +
                    "Var alamat = “bandung”;\n" +
                    "document.getElementById(\"nama\") = nama;\n" +
                    "document.getElementById(\"alamat\")= alamat;\n" +
                    "</script>", "<script>\n" +
                    "Var nama = “siCoding”;\n" +
                    "Var alamat = “bandung”;\n" +
                    "getElementById(\"nama\").innerHTML = nama;\n" +
                    "getElementById(\"alamat\").innerHTML = alamat;\n" +
                    "</script>"},
            {"Slice()", "Sub()", "Substring()", "Replace"},
            {"<script>\n" +
                    "\n" +
                    "var tanggal = new hour();\n" +
                    "document.getElementById(\"hasil\").innerHTML = tanggal;\n" +
                    "</script>", "<script>\n" +
                    "\n" +
                    "var date = new Date();\n" +
                    "document.getElementById(\"hasil\").innerHTML = tanggal;\n" +
                    "</script>", "<script>\n" +
                    "\n" +
                    "var tanggal = new Date();\n" +
                    "getElementById(\"hasil\").innerHTML = tanggal;\n" +
                    "</script>", "<script>\n" +
                    "\n" +
                    "var tanggal = new Date();\n" +
                    "document.getElementById(\"hasil\").innerHTML = tanggal;\n" +
                    "</script>"}
    };

    private String mCorrectAnswers[] = {
            "Script",
            "Array",
            "Onpause",
            "<button onclick=\"tampilkan_nama()\">KLIK</button>",
            "String",
            "switch case",
            "Array",
            "<Script>\n" +
                    "Var nama = “siCoding”;\n" +
                    "Var alamat = “bandung”;\n" +
                    "document.getElementById(\"nama\").innerHTML = nama;\n" +
                    "document.getElementById(\"alamat\").innerHTML = alamat;",
            "Substring()",
            "<script>\n" +
                    "\n" +
                    "var tanggal = new Date();\n" +
                    "document.getElementById(\"hasil\").innerHTML = tanggal;\n" +
                    "</script>"

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
