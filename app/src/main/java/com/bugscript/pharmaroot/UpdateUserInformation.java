package com.bugscript.pharmaroot;

/**
 * Created by syamsundark on 01/04/17.
 */

public class UpdateUserInformation extends EditWholeSalers {

    public String batchNumber,manuDate,expDate;

    public UpdateUserInformation(){

    }

    public UpdateUserInformation(String batchNumber, String manuDate, String expDate) {
        this.batchNumber = batchNumber;
        this.manuDate = manuDate;
        this.expDate = expDate;
    }
}
