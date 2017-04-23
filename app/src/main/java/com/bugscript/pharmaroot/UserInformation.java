package com.bugscript.pharmaroot;

/**
 * Created by syamsundark on 01/04/17.
 */

public class UserInformation extends DataEntry {

    public String tabletNumber,tabletName,batchNumber,manuDate,expDate,mrp,licenceNumber,maximumDosage,diseaseCured,companyName;

    public UserInformation(){

    }

    public UserInformation(String tableNumber, String tableName, String batchNumber, String manuDate, String expDate, String mrp, String licenceNumber, String maximumDosage, String diseaseCured, String companyName) {
        this.tabletNumber = tableNumber;
        this.tabletName = tableName;
        this.batchNumber = batchNumber;
        this.manuDate = manuDate;
        this.expDate = expDate;
        this.mrp = mrp;
        this.licenceNumber = licenceNumber;
        this.maximumDosage = maximumDosage;
        this.diseaseCured = diseaseCured;
        this.companyName = companyName;
    }
}
