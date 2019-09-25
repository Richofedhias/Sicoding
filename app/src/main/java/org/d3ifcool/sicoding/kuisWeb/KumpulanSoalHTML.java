package org.d3ifcool.sicoding.kuisWeb;

public class KumpulanSoalHTML {


    private String textQuestions [] = {
            "1. Bagaimanakah perintah HTML agar muncul input type password",
            "2. Untuk mengulangi pengisian pada form menggunakan perintah :",
            "3. Type yang berfungsi untuk menerima masukan berupa teks dari pengguna adalah",
            "4. Atribute ACTION digunakan untuk",
            "5. Tag <SELECT> digunakan untuk ?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"<td><input type=\"password\" name=\"alamat\"</td>", "<td><input type=\"name\" name=\"password\"</td>", "<td><input type=\"password\" password=\"alamat\"</td>", "<td><input type=\"word\" name=\"password\"</td>"},
            {" <input type=”reset” value=”reset”>", "<input type=”submit value=”reset”>", "<input type=”checkbox” value=”reset”>", "<ol type=”circle” value=”reset”>"},
            {"Checkbox ", "Submit", "File", "Text"},
            {"Menentukan nama form", "Menetukan metode pengiriman yang dipakai", "Menentukan alamat halaman web yang akan memproses masukan dari Form.", "Menerima masukan berupa pilihan"},
            {"memilih beberapa opsi", "menentukan ukuran", "menandai beberapa opsi", "menampilkan opsi pilihan"}
    };

    private String mCorrectAnswers[] = {"<td><input type=\"password\" name=\"alamat\"</td>", "<input type=”reset” value=”reset”>", "Text", "Menentukan alamat halaman web yang akan memproses masukan dari Form.", "menampilkan opsi pilihan"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
