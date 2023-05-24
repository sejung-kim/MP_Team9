package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyPageHostActivity extends AppCompatActivity {
//캠핑장 관리자 마이페이지

    TextView UserPassword;
    TextView UserId;
    TextView UserName;
    TextView UserPhoneNum;
    TextView UserEmail;
    UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_host);
        Intent intent = getIntent();
        userData.putUserId(intent.getStringExtra("UserId"));
        userData.putUserPassword(intent.getStringExtra("UserPwd"));
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhoneNum"));
        userData.putAdmin(intent.getStringExtra("Host"));



        UserPassword = (TextView)findViewById(R.id.UserPassword);
        UserPassword.setText(userData.getUserPassword());
        UserId = (TextView)findViewById(R.id.UserId);
        UserId.setText(userData.getUserId());
        UserName = (TextView)findViewById(R.id.UserName);
        UserName.setText(userData.getUserName());
        UserPhoneNum = (TextView)findViewById(R.id.UserPhoneNum);
        UserPhoneNum.setText(userData.getUserPhoneNum());
        UserEmail = (TextView)findViewById(R.id.UserEmail);
        UserEmail.setText(userData.getUserEmail());

    }

    public void onClick_edit_userinfo(View view){
        Intent intent = new Intent(MyPageHostActivity.this, MyPageEditActivity.class);
        intent.putExtra( "UserId", userData.getUserId());
        intent.putExtra( "UserPwd", userData.getUserPassword());
        intent.putExtra( "UserName", userData.getUserName());
        intent.putExtra( "UserNum", userData.getUserNum());
        intent.putExtra( "UserEmail", userData.getUserEmail());
        intent.putExtra( "UserPhoneNum", userData.getUserPhoneNum());
        intent.putExtra( "Host", userData.getHost());
        startActivity(intent);
    }

    public void onClick_reserve_manage(View view){
        Intent intent = new Intent(MyPageHostActivity.this, ReserveManageActivity.class);
        intent.putExtra( "UserId", userData.getUserId());
        intent.putExtra( "UserPwd", userData.getUserPassword());
        intent.putExtra( "UserName", userData.getUserName());
        intent.putExtra( "UserNum", userData.getUserNum());
        intent.putExtra( "UserEmail", userData.getUserEmail());
        intent.putExtra( "UserPhoneNum", userData.getUserPhoneNum());
        intent.putExtra( "Host", userData.getHost());
        startActivity(intent);
    }

    public void onClick_drop_user(View view){
        Intent intent = new Intent(MyPageHostActivity.this, DropUserActivity.class);
        intent.putExtra( "UserId", userData.getUserId());
        intent.putExtra( "UserPwd", userData.getUserPassword());
        intent.putExtra( "UserName", userData.getUserName());
        intent.putExtra( "UserNum", userData.getUserNum());
        intent.putExtra( "UserEmail", userData.getUserEmail());
        intent.putExtra( "UserPhoneNum", userData.getUserPhoneNum());
        intent.putExtra( "Host", userData.getHost());
        startActivity(intent);
    }
}