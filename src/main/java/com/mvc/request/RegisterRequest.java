package com.mvc.request;

public class RegisterRequest {
    private String imperatorName;
    private String password1;
    private String password2;

    public RegisterRequest() {
    }

    public void setImperatorName(String imperatorName) {
        this.imperatorName = imperatorName;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getImperatorName() {
        return imperatorName;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "imperatorName='" + imperatorName + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
