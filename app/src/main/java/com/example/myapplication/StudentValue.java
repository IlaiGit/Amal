package com.example.myapplication;

public class StudentValue {

    private String FullName;
    private String Email;
    private String Password;
    private String Charectaristics;
    private String phoneNumber;
    private boolean studentChecked, teacherChecked, mentorChecked, serviceProviderChecked;

    public StudentValue(String FullName, String Email, String Password, String Charectaristics, String phoneNumber, boolean studentChecked, boolean teacherChecked, boolean mentorChecked, boolean serviceProviderChecked){
        this.studentChecked = studentChecked;
        this.teacherChecked = teacherChecked;
        this.mentorChecked = mentorChecked;
        this.serviceProviderChecked = serviceProviderChecked;
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
        this.Charectaristics = Charectaristics;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCharectaristics() {return Charectaristics;}

    public void setCharectaristics(String charectaristics) {Charectaristics = charectaristics;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public boolean isStudentChecked() {return studentChecked;}

    public void setStudentChecked(boolean studentChecked) {this.studentChecked = studentChecked;}

    public boolean isTeacherChecked() {return teacherChecked;}

    public void setTeacherChecked(boolean teacherChecked) {this.teacherChecked = teacherChecked;}

    public boolean isMentorChecked() {return mentorChecked;}

    public void setMentorChecked(boolean mentorChecked) {this.mentorChecked = mentorChecked;}

    public boolean isServiceProviderChecked() {return serviceProviderChecked;}

    public void setServiceProviderChecked(boolean serviceProviderChecked) {this.serviceProviderChecked = serviceProviderChecked;}

}
