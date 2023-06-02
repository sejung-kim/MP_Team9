package com.example.Healing_time;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HospitalInformationUserActivity extends AppCompatActivity {
    //사용자가 검색해서 나온 병원 상세 정보
    ImageView imageView;
    TextView HospitalName;
    TextView HospitalAddress;
    TextView HospitalPhone;
    TextView HospitalKakao;
    TextView HospitalTime;
    TextView HospitalExtra;
    hospitalUploadData HospitalData = new hospitalUploadData();
    UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_information_user);

        Intent intent = getIntent();
        userData.putUserId(intent.getStringExtra("UserId"));
        userData.putUserPassword(intent.getStringExtra("UserPwd"));
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhoneNum"));
        userData.putAdmin(intent.getStringExtra("Host"));

        System.out.println("병원 인포 유저 액티 유저 네임: "+userData.getUserName());;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println(response);
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {
                        HospitalData.putHospitalUploadData(jsonObject);


                        //imageView = findViewById(R.id.image_addphoto);
                        System.out.print(HospitalData.getHospitalNum());
                        //이미지 업로드
                        HospitalName = (TextView)findViewById(R.id.HospitalName);
                        HospitalName.setText(HospitalData.getHospitalName());
                        HospitalAddress = (TextView)findViewById(R.id.HospitalAddress);
                        HospitalAddress.setText(HospitalData.getHospitalAddress());
                        HospitalPhone = (TextView)findViewById(R.id.HospitalPhone);
                        HospitalPhone.setText(HospitalData.getHospitalPhone());
                        HospitalKakao = (TextView)findViewById(R.id.HospitalKakao);
                        HospitalKakao.setText(HospitalData.getHospitalKakao());
                        HospitalTime = (TextView)findViewById(R.id.HospitalTime);
                        HospitalTime.setText(HospitalData.gethospitalTime());
                        HospitalExtra = (TextView)findViewById(R.id.HospitalExtra);
                        HospitalExtra.setText(HospitalData.getHospitalExtra());

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        HospitalInformationControl HospitalRequest = new HospitalInformationControl("2", responseListener);
        RequestQueue queue = Volley.newRequestQueue(HospitalInformationUserActivity.this);
        queue.add(HospitalRequest);

    }

    public void sendImageRequest(ImageView imageView, String url) {
        ImageLoadControl task = new ImageLoadControl(url, imageView);
        task.execute();
    }

    public void onClick_reserve_hospital(View view){
        Intent intent = new Intent(HospitalInformationUserActivity.this, ReserveHospitalActivity.class);
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