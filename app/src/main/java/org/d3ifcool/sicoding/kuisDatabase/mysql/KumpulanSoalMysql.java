package org.d3ifcool.sicoding.kuisDatabase.mysql;

public class KumpulanSoalMysql {
    private String textQuestions[] = {
            "1. sebuah perangkat lunak sistem manajemen basis data SQL atau DBMS yang multialur, multipengguna, dengan sekitar 6 juta instalasi di seluruh dunia adalah pengertian dari ...",
            "2. Pengembangan MySQL saat ini dipegang ...",
            "3. $conn = new mysqli ($servername, $username, $password, $dbname);\n" +
                    "if ($conn->connect_error) {\n" +
                    " \tdie(“Connection failed: ” . $conn->connect_error);\n" +
                    "}\n" +
                    "Diatas adalah fungsi dari MySQL :",
            "4. Siapakah pencipta MYSQL ?",
            "5. Pada tahun berapa mysql diciptakan ?",
            "6. Tamplikanlah seluruh field yang berada didalam tabel barang?",
            "7. Buat lah barang dengan field kode_barang char(6),nama barang varchar2(25),satuan_barang varchar2(20) dan stok_barang number(4) primary key adalah kode barang ?",
            "8. Ciri  dari Primary Key adalah ?",
            "9. Cara menghapus tabel barang?",
            "10. Buat lah user baru pada table karyawan dengan user = sofyan dan password = sosa?"
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            //1
            {"SQLite",
                    "MySQL",
                    "MyLite",
                    "MariaDB"},
            //2
            {"JAVA",
                    "Google",
                    "Microsoft",
                    "Oracle"},
            //3
            {"Create table",
                    "Connection database",
                    "Diconnect database",
                    "Update database"},
            //4
            {"Carles Cabbage",
                    "Howard Akein",
                    "Linus Torvald",
                    "Michael \"Monty\" Widenius."},
            //5
            {"MySQL pada awalnya diciptakan pada tahun 1979",
                    "MySQL pada awalnya diciptakan pada tahun 1997",
                    "MySQL pada awalnya diciptakan pada tahun 1977",
                    "MySQL pada awalnya diciptakan pada tahun 1987"},
            //6
            {"Select from barang;",
                    "select * from barang;",
                    "select * barang;",
                    "select * from barang"},
            //7
            {"create table barang(\n" +
                    "kode_barang char(6)\n" +
                    "nama_barang varchar2(25)\n" +
                    "satuan_barang varchar2(20)\n" +
                    "stock_barang number(4)\n" +
                    "constraint pk_barang primary key(kode_barang)\n" +
                    ");\n",
                    "create table barang(\n" +
                            "kode_barang char(6),\n" +
                            "nama_barang varchar2(25),\n" +
                            "constraint pk_barang primary key(kode_barang)\n" +
                            ");\n",
                    "create table barang(\n" +
                            "kode_barang char(6),\n" +
                            "nama_barang varchar2(25),\n" +
                            "satuan_barang varchar2(20),\n" +
                            "stock_barang number(4),\n" +
                            "constraint pk_barang primary key(kode_barang)\n" +
                            ");\n",
                    "create table barang(\n" +
                            "kode_barang char(6),\n" +
                            "nama_barang varchar2(25),\n" +
                            "satuan_barang varchar2(20),\n" +
                            "stock_barang number(4),\n" +
                            "constraint pk_barang primary key(kode_barang)"},
            //8
            {"Bersifat unik,",
                    "Bersifat umum",
                    "Memiliki kesamaan data dengan",
                    "Mudah dihapal"},
            //9
            {"drop table barang",
                    "drop table barang;",
                    "drop table_barang;",
                    "drop table * barang;"},
            //10
            {"SQL create user sofyan identified by sosa;",
                    "SQL> create user sofyan by sosa;",
                    "SQL> create user sofyan identified by sosa;",
                    "SQL> create user sofyan identified by sosa"}
    };

    private String mCorrectAnswers[] = {
            //1
            "MySQL",
            //2
            "Oracle",
            //3
            "Connection database",
            //4
            "Michael \"Monty\" Widenius.",
            //5
            "MySQL pada awalnya diciptakan pada tahun 1979",
            //6
            "select * from barang;",
            //7
            "create table barang(\n" +
                    "kode_barang char(6),\n" +
                    "nama_barang varchar2(25),\n" +
                    "satuan_barang varchar2(20),\n" +
                    "stock_barang number(4),\n" +
                    "constraint pk_barang primary key(kode_barang)\n" +
                    ");",
            //8
            "Bersifat unik",
            //9
            "drop table * barang;",
            //10
            "SQL> create user sofyan identified by sosa;"
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
