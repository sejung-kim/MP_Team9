package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ReserveCompleteActivity extends AppCompatActivity {
//사용자가 병원 진료 예약 완료 버튼을 클릭한 후 나오는 확인증

    TextView date;
    TextView UserName;
    TextView HospitalExtraUse;
    TextView HospitalName;
    TextView HospitalAddress;

    Button button_ok;
    hospitalUploadData HospitalData = new hospitalUploadData();
    UserData userData = new UserData();
    ReservationData reservationData = new ReservationData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_complete);

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

        System.out.println("액티비티 보내짐 "+ userData.getUserNum() + userData.getUserName()+  HospitalData.getHospitalNum()+  HospitalData.getHostNum() + HospitalData.getHospitalPhone()+  userData.getUserPhoneNum() + HospitalData.getHospitalName()+  HospitalData.getHospitalAddress()+ HospitalData.getHospitalKakao());


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println(response);
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {

                        reservationData.putReservationData(jsonObject);

                        date = (TextView)findViewById(R.id.date);
                        date.setText(reservationData.getDate());
                        UserName = (TextView)findViewById(R.id.UserName);
                        UserName.setText(reservationData.getUserName());
                        HospitalExtraUse = (TextView)findViewById(R.id.hospitalExtraUse);
                        HospitalExtraUse.setText(reservationData.gethospitalExtraUse());
                        HospitalName = (TextView)findViewById(R.id.HospitalName);
                        HospitalName.setText(reservationData.gethospitalName());
                        HospitalAddress = (TextView)findViewById(R.id.HospitalAddress);
                        HospitalAddress.setText(reservationData.getHospitalAddress());

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        ReserveCompleteControl HospitalRequest = new ReserveCompleteControl("2", responseListener);
        RequestQueue queue = Volley.newRequestQueue(ReserveCompleteActivity.this);
        queue.add(HospitalRequest);

    }

    public void onClick_ok(View view){
        Intent intent = new Intent(ReserveCompleteActivity.this, UserActivity.class);
        startActivity(intent);
    }
}