package org.d3ifcool.sicoding.QnA;

public class QnAList {
    String uid, uName, uEmail, uDp, pId, mTitle, mDesc,pLikes, pImage, pTime;

    public QnAList() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuDp() {
        return uDp;
    }

    public void setuDp(String uDp) {
        this.uDp = uDp;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public String getpLikes() {
        return pLikes;
    }

    public void setpLikes(String pLikes) {
        this.pLikes = pLikes;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public QnAList(String uid, String uName, String uEmail, String uDp, String pId, String mTitle, String mDesc, String pLikes, String pImage, String pTime) {
        this.uid = uid;
        this.uName = uName;
        this.uEmail = uEmail;
        this.uDp = uDp;
        this.pId = pId;
        this.mTitle = mTitle;
        this.mDesc = mDesc;
        this.pLikes = pLikes;
        this.pImage = pImage;
        this.pTime = pTime;

    }
}
