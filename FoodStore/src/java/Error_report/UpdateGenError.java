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
public class UpdateGenError {

    private String cusNameLenError = "";
    private String cusPhoneLenError = "";
    private String cusPhoneNotMatch = "";

    private boolean checkLen(String data, int min, int max) {
        return (data.trim().length() >= min) && (data.trim().length() <= max);
    }

    public boolean checkCusName(String cusName, int min, int max) {
        if (!checkLen(cusName, min, max)) {
            cusNameLenError = "Name must have length between " + min + " - " + max;
            return false;
        }
        cusNameLenError = "";
        return true;
    }

    public boolean checkPhone(String phone, int size) {
        if (!phone.trim().matches("^[0-9]*$") && phone.length() != size) {
            cusPhoneLenError = "";
            cusPhoneNotMatch = "Phone number must not contain special characters & the length must be " + size;
            return false;
        } else if (!phone.trim().matches("^[0-9]*$") && phone.length() == size) {
            cusPhoneLenError = "";
            cusPhoneNotMatch = "Phone number must not contain special characters";
            return false;
        } else if (phone.trim().matches("^[0-9]*$") && phone.length() != size) {
            cusPhoneLenError = "The length of the phone number must be  " + size;
            cusPhoneNotMatch = "";
            return false;
        } else {
            cusPhoneLenError = "";
            cusPhoneNotMatch = "";
            return true;
        }
    }

    public String getCusNameLenError() {
        return cusNameLenError;
    }

    public void setCusNameLenError(String cusNameLenError) {
        this.cusNameLenError = cusNameLenError;
    }

    public String getCusPhoneLenError() {
        return cusPhoneLenError;
    }

    public void setCusPhoneLenError(String cusPhoneLenError) {
        this.cusPhoneLenError = cusPhoneLenError;
    }

    public String getCusPhoneNotMatch() {
        return cusPhoneNotMatch;
    }

    public void setCusPhoneNotMatch(String cusPhoneNotMatch) {
        this.cusPhoneNotMatch = cusPhoneNotMatch;
    }

}
