package org.d3ifcool.sicoding.kuisWeb.css;

public class KumpulanSoalCSS {
    private String textQuestions[] = {
            "1. Kepanjangan dari CSS adalah",
            "2. Berikut merupakan status hyperlink untuk manipulasi menggunakan CSS, kecuali",
            "3. Digunakan untuk menentukan bahwa sebuah elemen harus mengapung disebelah kiri dari posisi containing block (elemen blok yang menampungnya), disebut",
            "4. Berikut merupakan property CSS yang dapat digunakan untuk menentukan posisi element HTML, kecuali",
            "5. Digunakan untuk mengatur jarak alinea pada text, value yang dapat digunakan berupa nilai pixel dan yang sesuai kebutuhan , disebut",
            "6. Memberikan jarak elemen dengan konten elemen yang ada di dalamnya, merupakan fungsi dari",
            "7. Mengatur align dalam bentuk vertical pada text value yang digunakan adalah left untuk\n" +
                    "membuat rata kiri , right untuk membuat rata kanan dan center untuk rata tengah, merupakan\n" +
                    "fungsi dari..",
            "8. 1. Border-top\n" +
                    "2. Border-left\n" +
                    "3. Border-style\n" +
                    "\n" +
                    "4. Border-top-color\n" +
                    "Dari beberapa property diatas Manakah yang digunakan untuk mengatur garis dengan CSS?",
            "9. Bagaimanakah perintah yang tepat untuk membuat list dalam bentuk lingkaran kecil dengan\n" +
                    "menggunakan CSS?",
            "10. Berikut merupakan teknik metode penulisan css, kecuali.."
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"Cascading Style Sheets", "Cascading Style Sheets", "Cascading Sheets Style", "HyperText Markup Language"},
            {"link", "visited", "hover", "transform"},
            {"float", " float: left;", " float: right;", " float: none;"},
            {"Relative", "Fixed", "Absolute", "Toasts"},
            {"Text-color", "Text-decoration", "Text-indent", "Text-height"},
            {"Margin", "Padding", "Border", "Prev"},
            {"Vertical-align", "Line-height", "Text-spacing", "Align-left"},
            {"1 dan 3", "1 dan 4", "1 dan 2", "Semua benar"},
            {"a) ul.makanan {\n" +
                    "list-style-type: square;\n" +
                    "}",
                    "ul.makanan {\n" +
                            "list-style-type: circle;\n" +
                            "}",
                    "ul.makanan {\n" +
                            "list-style-type: upper;\n" +
                            "}",
                    "ol.makanan {\n" +
                            "list-style-type: square;\n" +
                            "}"},
            {"Inline CSS", " Internal CSS", "External CSS", "Universal Selector CSS"}
    };

    private String mCorrectAnswers[] = {"Cascading Style Sheets",
            "transform",
            "float: left;",
            "Toasts",
            "Text-indent",
            "Padding",
            "Vertical-align",
            "1 dan 2",
            "ul.makanan {\n" +
                    "list-style-type: circle;\n" +
                    "}",
            "Universal Selector CSS"};

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
