package org.d3ifcool.sicoding.kuisDatabase.firebase;

public class KumpulanSoalFirebase {
    private String textQuestions[] = {
            "1. Apa yang dimaksud dengan project Firebase?",
            "2. Apa saja peran fundamental yang didukung Firebase console?",
            "3. Apa fungsi Firebase Auth?",
            "4. Firebase adalah ...",
            "5. Jenis operasi Firebase Realtime Database ...",
            "6. Operasi ini mencerminkan permintaan awal atas data di lokasi spesifik dari klien. Misalnya, metode on() atau once() untuk klien web adalah jenis operasi firebase realtime ...",
            "7. Fungsi remove() di firebase adalah...",
            "8. {\n" +
                    "\"rules\" : {\n" +
                    "\t\".read\" : true,\n" +
                    "\t\".write\" : true\n" +
                    "\t}\n" +
                    "}\n" +
                    "Fungsi dari indeks didalam String \"rules\" adalah :",
            "9. Function writeUserData(userId, name, email, imageUrl) {\n" +
                    "\tFirebase.database().ref(\'users/\' + userId).set({\n" +
                    "\t\tUsername : name,\n" +
                    "\t\tEmail: email,\n" +
                    "\t\tProfile_picture : imageUrl\n" +
                    "}):\n" +
                    "}\n" +
                    "Operasi Dasar diatas menunjukkan bahwa firebase ...",
            "10. Var userId = firebase.auth().currentUser.uid;\n" +
                    "Return firebase.database().ref(\'users/\' + userId).once(\'value\').then(function(snapshot) {\n" +
                    "\tVar username = (snapshot.val() && snapshot.val().username) || \'Anonymous\';\n" +
                    "\t// . . .\n" +
                    "});\n" +
                    "Operasi diatas menunjukkan bahwa firebase ..."
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"Project adalah proyek.", "Project adalah aplikasi untuk IOS, Android, dan web.", "Project adalah container untuk aplikasi iOS, Android, dan web.", "Project adalah container untuk Animation."},
            {"Pemilik, server, pengakses", "Server, editor, pengakses", "Pemilik , editor, pengakses", "Pemilik saja"},
            {"Dapat mengirim dan menerima pesan lintas platform seperti Android, iOS dan web.",
                    "Sebagai layanan sistem otentikasi yang menerapkan client-side code, sehingga user dapat mendaftar/login ke aplikasi.",
                    "Dapat menyimpan dan menerima konten dari user seperti gambar, audio, video secara langsung dari Firebase Client SDK.",
                    "Menerima informasi permasalahan setelah aplikasi kita di publish."},
            {"Format pertukaran data yang ringan, mudah dibaca dan ditulis oleh manusia, serta mudah diterjemahkan.",
                    "Database yang di-host di cloud. Data disimpan sebagai JSON dan disinkronkan secara realtime ke setiap klien yang terhubung.",
                    "Standar terbuka berbasis text ringan yang bisa dibaca manusia.",
                    "sistem manajemen database relasional yang dikembangkan dari MySQL."},
            {"Concurrent-connect",
                    "Realtime-add",
                    "A dan B benar",
                    "A dan B salah"},
            {"Listener-listen",
                    "Realtime-write",
                    "Realtime-update",
                    "Listener-unlisten"},
            {"Menambah data",
                    "Mengedit data",
                    "Menyimpan data",
                    "Menghapus data"},
            {"Menjelaskan apakah dan kapan data boleh dibaca oleh pengguna dan menjelaskan apakah dan kapan data boleh ditulis.",
                    "Menjelaskan apakah dan kapan data boleh dihapus oleh pengguna dan menjelaskan apakah dan kapan data boleh ditulis.",
                    "Menjelaskan apakah dan kapan data boleh dibaca oleh admin dan menjelaskan apakah dan kapan data boleh ditulis oleh admin.",
                    "Menjelaskan apakah dan kapan data boleh dibaca oleh pengguna dan menjelaskan apakah dan kapan data boleh dihapus."},
            {"Menambah data",
                    "Mengedit data",
                    "Menyimpan data",
                    "Menghapus data"},
            {"Menambah data",
                    "Membaca data",
                    "Menyimpan data",
                    "Mengedit data"}
    };

    private String mCorrectAnswers[] = {
            "Project adalah container untuk aplikasi iOS, Android, dan web.",
            "Pemilik , editor, pengakses",
            "Sebagai layanan sistem otentikasi yang menerapkan client-side code, sehingga user dapat mendaftar/login ke aplikasi.",
            "Database yang di-host di cloud. Data disimpan sebagai JSON dan disinkronkan secara realtime ke setiap klien yang terhubung.",
            "Concurrent-connect",
            "Listener-listen",
            "Menghapus data",
            "Menjelaskan apakah dan kapan data boleh dibaca oleh pengguna dan menjelaskan apakah dan kapan data boleh ditulis.",
            "Menyimpan data",
            "Membaca data"
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
