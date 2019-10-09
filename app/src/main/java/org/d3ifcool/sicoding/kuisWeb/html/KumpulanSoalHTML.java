package org.d3ifcool.sicoding.kuisWeb.html;

public class KumpulanSoalHTML {


    private String textQuestions[] = {
            "1. Bagaimanakah perintah HTML agar muncul input type password",
            "2. Untuk mengulangi pengisian pada form menggunakan perintah :",
            "3. Type yang berfungsi untuk menerima masukan berupa teks dari pengguna adalah",
            "4. Atribute ACTION digunakan untuk",
            "5. Tag <SELECT> digunakan untuk ?",
            "6. Bagaimanakah perintah membuat hyperlink pada HTML?",
            "7. Berfungsi untuk menampilkan daftar list dalam bentuk huruf atau angka , disebut",
            "8. Bagaimanakah perintah menampilkan gambar pada HTML?",
            "9. Bagaimanakah perintah menghubungkan HTML dengan CSS?",
            "10. Mendefinisikan sebuah anchor yang digunakan untuk saling manautkan antara satu dokumen HTML ke dokumen HTML yang lain, merupakan fungsi dari tag...."
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"<td><input type=\"password\" name=\"password\"</td>", "<td><input type=\"name\" name=\"password\"</td>", "<td><input type=\"password\" password=\"alamat\"</td>", "<td><input type=\"word\" name=\"password\"</td>"},
            {" <input type=”reset” value=”reset”>", "<input type=”submit value=”reset”>", "<input type=”checkbox” value=”reset”>", "<ol type=”circle” value=”reset”>"},
            {"Checkbox ", "Submit", "File", "Text"},
            {"Menentukan nama form", "Menetukan metode pengiriman yang dipakai", "Menentukan alamat halaman web yang akan memproses masukan dari Form.", "Menerima masukan berupa pilihan"},
            {"memilih beberapa opsi", "menentukan ukuran", "menandai beberapa opsi", "menampilkan opsi pilihan"},
            {"<a href=\"sicoding.com\">klik disini</a>", "<href=\"sicoding.com\">klik disini</a>", "<td><a href=\"sicoding.com\">klik disini</td>", "<li>sicoding.com</li>", ""},
            {"List", "Unordered list", " Ordered list", "Head"},
            {"<img scr=\"malasngoding.png\">", "<img src=\"malasngoding.png\">", "<a href src=\"malasngoding.png\">", "<a href =\"malasngoding.png\"></a>"},
            {"<link rel=\"stylesheet\" type=\"text/css\" href=\"style.html\">", "<a href =\"stylesheet\" type=\"text/css\" href=\"style.css\"></a>", "<link href=\"stylesheet\" type=\"text/css\" href=\"style.css\">", "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">"},
            {"<b>", " <a>\n", "<script>", "<td>"}
    };

    private String mCorrectAnswers[] = {"<td><input type=\"password\" name=\"password\"</td>",
            "<input type=”reset” value=”reset”>",
            "Text",
            "Menentukan alamat halaman web yang akan memproses masukan dari Form.",
            "menampilkan opsi pilihan",
            "<a href=\"sicoding.com\">klik disini</a>",
            "Ordered list",
            "<img src=\"malasngoding.png\">",
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">",
            "<a>"};

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
