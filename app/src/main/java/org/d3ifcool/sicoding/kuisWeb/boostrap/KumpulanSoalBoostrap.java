package org.d3ifcool.sicoding.kuisWeb.boostrap;

public class KumpulanSoalBoostrap {
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
            {"HTML", "CSS", "Boostrap", "Javascript"},
            {".table", ".table_striped", ".table_bordered", ".table_hover"},
            {"img", "img_circle", "img_thumbnail", "img_rounded"},
            {".btn_sm", ".btn", ".btn_md", ".btn_lg"}, {"Boostrap", "Img", "Jumbotron", "Container"},
            {"Alert_info", "Alert_warning", "Alert_danger", "Alert"},
            {"Col_lg-*", "Col_md-*", "Col_sm-*", "Col_xs-*"},
            {"Show", "Carousel", "Form", "Grid"},
            {"Panel_footer", "Panel_head", "Panel_body", "Panel_info"},
            {"Pagination", "Breadcrumb", "Navigation", "Alert Boostrap"}
    };

    private String mCorrectAnswers[] = {
            "Boostrap",
            ".table_striped",
            "Img_rounded",
            ".btn",
            "Jumbotron",
            "Alert_warning",
            "Col_lg-*",
            "Carousel",
            "Panel_body",
            "Pagination"
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
