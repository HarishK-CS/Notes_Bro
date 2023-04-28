package com.techcos.notesbro.admin;

public class UserInformation {
    public String uid;
    public  String name;
    public String dept;
    public String email;
    public String password;
    public Boolean isAdmin;
    public Boolean isStaff;

    public UserInformation() {
    }

    public UserInformation(String uid, String name, String dept, String email, String password, Boolean isAdmin, Boolean isStaff) {
        this.uid = uid;
        this.name = name;
        this.dept = dept;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getStaff() {
        return isStaff;
    }

    public void setStaff(Boolean staff) {
        isStaff = staff;
    }
}
