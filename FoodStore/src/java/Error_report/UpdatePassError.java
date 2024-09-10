/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Error_report;

/**
 *
 * @author DELL
 */
public class UpdatePassError {

    private String passwordLenError = "";
    private String confirmNotMatch = "";
    private String curPassNotMatch = "";

    public boolean checkConfirm(String confirm, String password) {
        if (!confirm.equals(password)) {
            confirmNotMatch = "Confirm password doesn't match new password!";
            return false;
        }
        confirmNotMatch = "";
        return true;
    }

    private boolean checkLen(String data, int min, int max) {
        return (data.trim().length() >= min) && (data.trim().length() <= max);
    }

    public boolean checkPassLen(String password, int min, int max) {
        if (!checkLen(password, min, max)) {
            passwordLenError = "password must have length between " + min + " - " + max;
            return false;
        } 
        passwordLenError = "";
        return true;
    }

    public String getPasswordLenError() {
        return passwordLenError;
    }

    public void setPasswordLenError(String passwordLenError) {
        this.passwordLenError = passwordLenError;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getCurPassNotMatch() {
        return curPassNotMatch;
    }

    public void setCurPassNotMatch(String curPassNotMatch) {
        this.curPassNotMatch = curPassNotMatch;
    }
    
}
