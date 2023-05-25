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
    String hospitalTime;
    String hospitalExtra;

    public hospitalUploadData putHospitalUploadData(JSONObject jsonObject){
        try {
            hospitalNum = jsonObject.getString("hospitalNum");
            HostNum = jsonObject.getString("hostNum");
            hospitalName = jsonObject.getString("hospitalName");
            hospitalAddress = jsonObject.getString("hospitalAddress");
            hospitalPhone = jsonObject.getString("hospitalPhone");
            hospitalKakao = jsonObject.getString("hospitalKakao");
            hospitalTime = jsonObject.getString("hospitalTime");
            hospitalExtra = jsonObject.getString("hospitalExtra");
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
    public void putHospitalTime(String CTime){hospitalTime = CTime;}
    public void putHospitalExtra(String CExtra){
        hospitalExtra = CExtra;}

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


    public String gethospitalTime() {
        return hospitalTime;
    }

    public String getHospitalExtra() {
        return hospitalExtra;
    }


}


class ReservationData {
    String ReservationNum;
    String UserNum;
    String UserName;
    String HospitalNum;
    String HostNum;
    String HostPhoneNum;
    String UserPhoneNum;
    String HospitalName;
    String date;
    String HospitalAddress;
    String HospitalExtraUse;
    String HospitalKakao;
    String Accept;

    public ReservationData putReservationData(JSONObject jsonObject){
        try{
            ReservationNum = jsonObject.getString("reservationNum");
            UserNum = jsonObject.getString("userNum");
            UserName = jsonObject.getString("userName");
            HospitalNum = jsonObject.getString("hospitalNum");
            HostNum = jsonObject.getString("hostNum");
            HostPhoneNum = jsonObject.getString("hostPhoneNum");
            UserPhoneNum = jsonObject.getString("userPhoneNum");
            HospitalName = jsonObject.getString("hospitalName");
            date = jsonObject.getString("date");
            HospitalAddress = jsonObject.getString("hospitalAddress");
            HospitalExtraUse = jsonObject.getString("hospitalExtraUse");
            HospitalKakao = jsonObject.getString("hospitalKakao");
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
    public void putHospitalNum(String CNum){
        HospitalNum = CNum;}
    public void putHostNum(String HName){HostNum = HName;}
    public void putHostPhoneNum(String HPhone){HostPhoneNum = HPhone;}
    public void putUserPhoneNum(String UPhone){UserPhoneNum = UPhone;}
    public void putHospitalName(String CName){
        HospitalName = CName;}
    public void putdate(String Date){date = Date;}
    public void putHospitalAddress(String CAddress){
        HospitalAddress = CAddress;}
    public void putHospitalExtraUse(String CUse){
        HospitalExtraUse = CUse;}
    public void putHospitalKakao(String CKakao){ HospitalKakao = CKakao;}
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

    public String getHospitalNum() {
        return HospitalNum;
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
        return HospitalName;
    }

    public String getDate() {
        return date;
    }

    public String getHospitalAddress() {
        return HospitalAddress;
    }


    public String gethospitalExtraUse() {
        return HospitalExtraUse;
    }

    public String getHospitalKakao() { return HospitalKakao; }

    public String getAccept() {return Accept;}
}
