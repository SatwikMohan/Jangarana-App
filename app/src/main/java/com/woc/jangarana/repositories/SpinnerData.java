package com.woc.jangarana.repositories;

public class SpinnerData {


    public String Gender[] = {"Gender","Male","Female","Others"};
    public String Marital_st[]={"Married Status","Married","Unmarried"};
    public String MotherToung[]={"Mother Toung","Assamese","Bengali","Gujarati",
            "Hindi","Kannada","Punjabi","Marathi","Sanskrit","Tamil","Telugu","Manipuri"};
    public String OtherLanguage[]={"Other Language","Assamese","Bengali","Gujarati",
            "Hindi","Kannada","Punjabi","Marathi","Sanskrit","Tamil","Telugu","Manipuri"};
    public String States_ut[] = {
            "State/UT",
            "Andaman and Nicobar Islands",
            "Andhra Pradesh",
            "Arunachal Pradesh",
            "Assam",
            "Bihar",
            "Chandigarh",
            "Chhattisgarh",
            "Dadra and Nagar Haveli",
            "Daman and Diu",
            "Delhi",
            "Goa",
            "Gujarat",
            "Haryana",
            "Himachal Pradesh",
            "Jammu and Kashmir",
            "Jharkhand",
            "Karnataka",
            "Kerala",
            "Lakshadweep",
            "Madhya Pradesh",
            "Maharashtra",
            "Manipur",
            "Meghalaya",
            "Mizoram",
            "Nagaland",
            "Odisha",
            "Puducherry",
            "Punjab",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telangana",
            "Tripura",
            "Uttarakhand",
            "Uttar Pradesh",
            "West Bengal"};

    public SpinnerData() {
    }

    public String[] getGender() {
        return Gender;
    }

    public String[] getMarital_st() {
        return Marital_st;
    }

    public String[] getMotherToung() {
        return MotherToung;
    }

    public String[] getOtherLanguage() {
        return OtherLanguage;
    }

    public String[] getStates_ut() {
        return States_ut;
    }
}
