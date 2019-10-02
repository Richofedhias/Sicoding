package org.d3ifcool.sicoding.QnA;

public class QnAList {
    String user ;
    String question ;
    int image ;

    public QnAList(String user, String question, int image) {
        this.user = user;
        this.question = question;
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
