package com.example.Healing_time;

import org.json.JSONException;
import org.json.JSONObject;

class UserData {
    String UserNum;
    String UserName;
    String UserId;
    String UserPassword;
    String UserEmail;
    String UserPhoneNum;
    String Host;


    public void putUserData(JSONObject jsonObject){
        try {
            UserName = jsonObject.getString( "UserName" );
            UserNum = jsonObject.getString( "UserNum" );
            UserId = jsonObject.getString( "UserId" );
            UserPassword = jsonObject.getString( "UserPwd" );
            UserEmail = jsonObject.getString( "UserEmail" );
            UserPhoneNum = jsonObject.getString( "UserPhone" );
            Host = jsonObject.getString( "host" );

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public UserData getUserData(){
        return this;
    }
    public void putUserNum(String Num){
        UserNum = Num;
    }
    public void putUserName(String Name){
        UserName=Name;
    }
    public void putUserId(String Id){
        UserId = Id;
    }
    public void putUserPassword(String Password){
        UserPassword = Password;
    }
    public  void putUserEmail(String Email){
        UserEmail = Email;
    }
    public  void putUserPhoneNum(String PhoneNumber){
        UserPhoneNum = PhoneNumber;
    }
    public void putAdmin(String host){Host = host;}

    //get
    public String getUserNum(){
        return UserNum;
    }
    public String getUserName(){
        return UserName;
    }
    public String getUserId(){
        return UserId;
    }
    public String getUserPassword(){
        return UserPassword;
    }
    public String getUserEmail(){
        return UserEmail;
    }
    public String getUserPhoneNum() { return UserPhoneNum;}
    public String getHost(){return Host;}
}


class hospitalUploadData {
    String hospitalNum;
    String HostNum; //host의 usernum
    String hospitalName;
    String hospitalAddress;
    String hospitalPhone;
    String hospitalKakao;
    String AccountNum;
    String CampTime;
    String hospitalExtra;
    String hospitalCost;
    String Imagepath;

    public hospitalUploadData putHospitalUploadData(JSONObject jsonObject){
        try {
            hospitalNum = jsonObject.getString("campNum");
            HostNum = jsonObject.getString("hostNum");
            hospitalName = jsonObject.getString("campName");
            hospitalAddress = jsonObject.getString("campAddress");
            hospitalPhone = jsonObject.getString("campPhone");
            hospitalKakao = jsonObject.getString("campKakao");
            AccountNum = jsonObject.getString("campAccount");
            CampTime = jsonObject.getString("campTime");
            hospitalExtra = jsonObject.getString("campExtra");
            hospitalCost = jsonObject.getString("campPrice");
            Imagepath = jsonObject.getString("imagepath");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return this;

    }

    public hospitalUploadData getCampUploadData(){
        return this;
    }
    public void putHospitalNum(String CNum){
        hospitalNum = CNum;
    }
    public void putHostNum(String HNum){
        HostNum = HNum;
    }
    public void putHospitalName(String CName){
        hospitalName = CName;
    }
    public void putHospitalAddress(String CAddress){
        hospitalAddress = CAddress;
    }
    public void putHospitalPhone(String CPhone){
        hospitalPhone = CPhone;
    }
    public void putHospitalKakao(String CKakao){
        hospitalKakao = CKakao;
    }
    public void putAccountNum(String ANum){AccountNum = ANum;}
    public void putHospitalTime(String CTime){CampTime = CTime;}
    public void putHospitalExtra(String CExtra){
        hospitalExtra = CExtra;}
    public void putHospitalCost(String CCost){
        hospitalCost = CCost;}
    public void putImagePath(String imagepath){Imagepath = imagepath;}

    //get
    public String getHospitalNum(){
        return hospitalNum;
    }

    public String getHostNum() {
        return HostNum;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    public String getHospitalKakao() {
        return hospitalKakao;
    }

    public String getAccountNum() {
        return AccountNum;
    }

    public String gethospitalTime() {
        return CampTime;
    }

    public String getHospitalExtra() {
        return hospitalExtra;
    }

    public String getHospitalCost() {
        return hospitalCost;
    }
    public String getImagepath() {
        return Imagepath;
    }

}


class ReservationData {
    String ReservationNum;
    String UserNum;
    String UserName;
    String CampNum;
    String HostNum;
    String HostPhoneNum;
    String UserPhoneNum;
    String CampName;
    String date;
    String CampAddress;
    String AccountNum;
    String CampExtraUse;
    String CampCost;
    String CampKakao;
    String Accept;

    public ReservationData putReservationData(JSONObject jsonObject){
        try{
            ReservationNum = jsonObject.getString("reservationNum");
            UserNum = jsonObject.getString("userNum");
            UserName = jsonObject.getString("userName");
            CampNum = jsonObject.getString("campNum");
            HostNum = jsonObject.getString("hostNum");
            HostPhoneNum = jsonObject.getString("hostPhoneNum");
            UserPhoneNum = jsonObject.getString("userPhoneNum");
            CampName = jsonObject.getString("campName");
            date = jsonObject.getString("date");
            CampAddress = jsonObject.getString("campAddress");
            AccountNum = jsonObject.getString("accountNum");
            CampExtraUse = jsonObject.getString("campExtraUse");
            CampCost = jsonObject.getString("campCost");
            CampKakao = jsonObject.getString("campKakao");
            Accept = jsonObject.getString("accept");

        }catch (JSONException e){
            e.printStackTrace();
        }
        return this;
    }

    public ReservationData getReservationData() {return this;}
    public void putReservationNum(String RNum) {ReservationNum = RNum;}
    public void putUserNum(String UNum){UserNum = UNum;}
    public void putUserName(String UName){UserName = UName;}
    public void putCampNum(String CNum){CampNum = CNum;}
    public void putHostNum(String HName){HostNum = HName;}
    public void putHostPhoneNum(String HPhone){HostPhoneNum = HPhone;}
    public void putUserPhoneNum(String UPhone){UserPhoneNum = UPhone;}
    public void putCampName(String CName){CampName = CName;}
    public void putdate(String Date){date = Date;}
    public void putCampAddress(String CAddress){CampAddress = CAddress;}
    public void putAccountNum(String ANum){AccountNum = ANum;}
    public void putCampExtraUse(String CUse){CampExtraUse = CUse;}
    public void putCampCost(String CCost){CampCost = CCost;}
    public void putCampKakao(String CKakao){ CampKakao = CKakao;}
    public void putAccept(String CAccept){Accept = CAccept;}

    public String getReservationNum() {
        return ReservationNum;
    }

    public String getUserNum() {
        return UserNum;
    }

    public String getUserName() {
        return UserName;
    }

    public String getCampNum() {
        return CampNum;
    }

    public String getHostNum() {
        return HostNum;
    }

    public String getHostPhoneNum() {
        return HostPhoneNum;
    }

    public String getUserPhoneNum() {
        return UserPhoneNum;
    }

    public String gethospitalName() {
        return CampName;
    }

    public String getDate() {
        return date;
    }

    public String getHospitalAddress() {
        return CampAddress;
    }

    public String getAccountNum() {
        return AccountNum;
    }

    public String gethospitalExtraUse() {
        return CampExtraUse;
    }

    public String gethospitalCost() {
        return CampCost;
    }

    public String getCampKakao() { return CampKakao; }

    public String getAccept() {return Accept;}
}
