package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyPageEditActivity extends AppCompatActivity {
//사용자 정보 수정 페이지
    private static String IP_ADDRESS = "humming1106.dothome.co.kr";
    private static String reservation = "/userDataUpdate.php";
    UserData userData = new UserData();
    TextView UserId;
    private EditText editText_UserName;
    private EditText editText_UserPassword;
    private EditText editText_UserPhoneNum;
    private EditText editText_UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_edit);

        Intent intent = getIntent();
        userData.putUserId(intent.getStringExtra("UserId"));
        userData.putUserPassword(intent.getStringExtra("UserPwd"));
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhoneNum"));
        userData.putAdmin(intent.getStringExtra("Host"));

        UserId = (TextView)findViewById(R.id.UserId);
        UserId.setText(userData.getUserId());


        editText_UserName = (EditText)findViewById(R.id.editText_UserName);
        editText_UserName.setText(userData.getUserName());
        editText_UserPassword = (EditText)findViewById(R.id.editText_UserPassword);
        editText_UserPassword.setText(userData.getUserPassword());
        editText_UserPhoneNum = (EditText)findViewById(R.id.editText_UserPhoneNum);
        editText_UserPhoneNum.setText(userData.getUserPhoneNum());
        editText_UserEmail = (EditText)findViewById(R.id.editText_UserEmail);
        editText_UserEmail.setText(userData.getUserEmail());

    }

    public void onClick_complete_userinfo(View view){
        //관리자인지 유저인지 확인받아서 다른 화면으로 보내야함
        //유저
        if(userData.getHost().equals("2")) {

            String UserName = editText_UserName.getText().toString();
            String UserPassword = editText_UserPassword.getText().toString();
            String UserPhoneNum = editText_UserPhoneNum.getText().toString();
            String UserEmail = editText_UserEmail.getText().toString();

            MyPageEditControl task = new MyPageEditControl();
            //InsertDataControl task = new InsertDataControl();
            task.execute("http://" + IP_ADDRESS + reservation, userData.getUserNum(),userData.getUserId(),UserName, UserPassword,UserPhoneNum,UserEmail);


            Intent intent = new Intent(MyPageEditActivity.this, MyPageUserActivity.class);
            intent.putExtra( "UserId", userData.getUserId());
            intent.putExtra( "UserPwd", UserPassword);
            intent.putExtra( "UserName", UserName);
            intent.putExtra( "UserNum", userData.getUserNum());
            intent.putExtra( "UserEmail", UserEmail);
            intent.putExtra( "UserPhoneNum", UserPhoneNum);
            intent.putExtra( "Host", userData.getHost());
            startActivity(intent);
        }
        //관리자
        else{

            String UserName = editText_UserName.getText().toString();
            String UserPassword = editText_UserPassword.getText().toString();
            String UserPhoneNum = editText_UserPhoneNum.getText().toString();
            String UserEmail = editText_UserEmail.getText().toString();
            MyPageEditControl task = new MyPageEditControl();
            //InsertDataControl task = new InsertDataControl();
            task.execute("http://" + IP_ADDRESS + reservation, userData.getUserNum(),userData.getUserId(),UserName, UserPassword,UserPhoneNum,UserEmail);

            Intent intent = new Intent(MyPageEditActivity.this, MyPageHostActivity.class);
            intent.putExtra( "UserId", userData.getUserId());
            intent.putExtra( "UserPwd", UserPassword);
            intent.putExtra( "UserName", UserName);
            intent.putExtra( "UserNum", userData.getUserNum());
            intent.putExtra( "UserEmail", UserEmail);
            intent.putExtra( "UserPhoneNum", UserPhoneNum);
            intent.putExtra( "Host", userData.getHost());
            startActivity(intent);
        }
    }
}