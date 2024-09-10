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
public class RegisterError {

    private String accountExist = "";
    private String cusNameLenError = "";
    private String fullNameLenError = "";
    private String passwordLenError = "";
    private String phoneLenError = "";
    private String phoneNotMatch = "";
    private String confirmError = "";

    private boolean checkLen(String data, int min, int max) {
        return (data.trim().length() >= min) && (data.trim().length() <= max);
    }

    public boolean checkCusNameLen(String cusName, int min, int max) {
        if (!checkLen(cusName, min, max)) {
            cusNameLenError = "User name must have length between " + min + " - " + max;
            return false;
        } else {
            cusNameLenError = "";
            return true;
        }
    }

    public boolean checkFullNameLen(String fullName, int min, int max) {
        if (!checkLen(fullName, min, max)) {
            fullNameLenError = "Full name must have length between " + min + " - " + max;
            return false;
        } else {
            fullNameLenError = "";
            return true;
        }
    }

    public boolean checkPasswordLen(String password, int min, int max) {
        if (!checkLen(password, min, max)) {
            passwordLenError = "Password must have length between " + min + " - " + max;
            return false;
        } else {
            passwordLenError = "";
            return true;
        }
    }

    public boolean checkPhone(String phone, int size) {
        if (!phone.trim().matches("^[0-9]*$") && phone.length() != size) {
            phoneLenError = "";
            phoneNotMatch = "Phone number must not contain special characters & the length must be " + size;
            return false;
        } else if (!phone.trim().matches("^[0-9]*$") && phone.length() == size) {
            phoneLenError = "";
            phoneNotMatch = "Phone number must not contain special characters";
            return false;
        } else if (phone.trim().matches("^[0-9]*$") && phone.length() != size) {
            phoneLenError = "The length of the phone number must be  " + size;
            phoneNotMatch = "";
            return false;
        } else {
            phoneLenError = "";
            phoneNotMatch = "";
            return true;
        }
    }

    public boolean checkConfirm(String password, String confirm) {
        if (password.equals(confirm)) {
            confirmError = "";
            return true;
        } else {
            confirmError = "Password and confirm must be the same";
            return false;
        }
    }

    public String getAccountExist() {
        return accountExist;
    }

    public void setAccountExist(String accountExist) {
        this.accountExist = accountExist;
    }

    public String getCusNameLenError() {
        return cusNameLenError;
    }

    public void setCusNameLenError(String cusNameLenError) {
        this.cusNameLenError = cusNameLenError;
    }

    public String getFullNameLenError() {
        return fullNameLenError;
    }

    public void setFullNameLenError(String fullNameLenError) {
        this.fullNameLenError = fullNameLenError;
    }

    public String getPasswordLenError() {
        return passwordLenError;
    }

    public void setPasswordLenError(String passwordLenError) {
        this.passwordLenError = passwordLenError;
    }

    public String getPhoneNotMatch() {
        return phoneNotMatch;
    }

    public void setPhoneNotMatch(String phoneNotMatch) {
        this.phoneNotMatch = phoneNotMatch;
    }

    public String getPhoneLenError() {
        return phoneLenError;
    }

    public void setPhoneLenError(String phoneLenError) {
        this.phoneLenError = phoneLenError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

}
