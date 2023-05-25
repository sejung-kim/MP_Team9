package com.example.Healing_time;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReserveHospitalActivity extends AppCompatActivity {
    //사용자가 캠핑장 상세정보에서 예약하기 버튼을 클릭한 뒤의 화면
    private static String IP_ADDRESS = "humming1106.dothome.co.kr";
    private static String reservation = "/reservationDataInsert.php";

    private static final int REQUEST_CODE = 21;
    TextView HospitalName;
    EditText editText_date, editText_HospitalExtraUse;
    hospitalUploadData HospitalData = new hospitalUploadData();
    UserData userData = new UserData();
    ReservationData reservationData = new ReservationData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_hospital);

        Intent intent = getIntent();
        HospitalData.putHospitalName(intent.getStringExtra("HospitalName"));
        HospitalData.putHospitalNum(intent.getStringExtra("HospitalNum"));
        HospitalData.putHostNum(intent.getStringExtra("HostNum"));
        HospitalData.putHospitalAddress(intent.getStringExtra("HospitalAddress"));
        HospitalData.putHospitalPhone(intent.getStringExtra("HospitalPhone"));
        HospitalData.putHospitalKakao(intent.getStringExtra("HospitalKakao"));
        HospitalData.putHospitalTime(intent.getStringExtra("HospitalTime"));
        HospitalData.putHospitalExtra(intent.getStringExtra("HospitalExtra"));
        userData.putUserId(intent.getStringExtra("UserId"));
        userData.putUserPassword(intent.getStringExtra("UserPwd"));
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhoneNum"));
        userData.putAdmin(intent.getStringExtra("Host"));

        editText_date = (EditText)findViewById(R.id.editText_date);
        editText_HospitalExtraUse = (EditText)findViewById(R.id.editText_HospitalExtra);

        HospitalName = (TextView)findViewById(R.id.HospitalName);
        HospitalName.setText(HospitalData.getHospitalName());

    }

    public void onClick_reserve_complete(View view){
        String date = editText_date.getText().toString();
        String HospitalExtra = editText_HospitalExtraUse.getText().toString();

        System.out.println("유저 네임: "+userData.getUserName());
        System.out.println("액티비티 보내짐 "+ userData.getUserNum() + userData.getUserName()+  HospitalData.getHospitalNum()+  HospitalData.getHostNum() + HospitalData.getHospitalPhone()+  userData.getUserPhoneNum() + HospitalData.getHospitalName()+  date+ HospitalData.getHospitalAddress()+  HospitalExtra+ HospitalData.getHospitalKakao());
        ReserveHospitalControl task = new ReserveHospitalControl();
        //InsertDataControl task = new InsertDataControl();
        task.execute("http://" + IP_ADDRESS + reservation, userData.getUserNum(),userData.getUserName(), HospitalData.getHospitalNum(), HospitalData.getHostNum(), HospitalData.getHospitalPhone(), userData.getUserPhoneNum(), HospitalData.getHospitalName(), date, HospitalData.getHospitalAddress(), HospitalExtra, HospitalData.getHospitalKakao());
        Intent intent = new Intent(ReserveHospitalActivity.this, ReserveCompleteActivity.class);
        intent.putExtra("HospitalNum", HospitalData.getHospitalNum());
        intent.putExtra("HostNum", HospitalData.getHostNum());
        intent.putExtra("HospitalName", HospitalData.getHospitalName());
        intent.putExtra("HospitalAddress", HospitalData.getHospitalAddress());
        intent.putExtra("HospitalPhone", HospitalData.getHospitalPhone());
        intent.putExtra("HospitalKakao", HospitalData.getHospitalKakao());
        intent.putExtra("HospitalTime", HospitalData.gethospitalTime());
        intent.putExtra("HospitalExtra", HospitalData.getHospitalExtra());
        intent.putExtra( "UserNum", userData.getUserNum());
        intent.putExtra( "UserName", userData.getUserName());
        intent.putExtra( "UserId", userData.getUserId());
        intent.putExtra( "UserPwd", userData.getUserPassword());
        intent.putExtra( "UserEmail", userData.getUserEmail());
        intent.putExtra( "UserPhoneNum", userData.getUserPhoneNum());
        intent.putExtra( "Host", userData.getHost());
        startActivity(intent);
    }
}