package org.d3ifcool.sicoding.register;

public class User {
    private String namaUser;
    private String username;
    private String password;

    public User(String namaUser, String username, String password) {
        this.namaUser = namaUser;
        this.username = username;
        this.password = password;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
