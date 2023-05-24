package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HospitalInformationHostActivity extends AppCompatActivity {
//캠핑장 관리자가 업로드한 캠핑장 정보 볼 수 있는 곳
    //사용자가 검색해서 나온 캠핑장 상세 정보
    ImageView imageView;
    TextView HospitalName;
    TextView HospitalAddress;
    TextView HospitalPhone;
    TextView HospitalKakao;
    TextView AccountNum;
    TextView HospitalTime;
    TextView HospitalExtra;
    TextView HospitalCost;
    hospitalUploadData HospitalData = new hospitalUploadData();
    UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_information_host);

        Intent intent = getIntent();
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhone"));
        userData.putAdmin(intent.getStringExtra("Host"));

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
                        //이미지 로드
                        //sendImageRequest(imageView, "http://117.16.46.95:8080/"+ HospitalData.getImagepath());
                        HospitalName = (TextView)findViewById(R.id.HospitalName);
                        HospitalName.setText(HospitalData.getHospitalName());
                        HospitalAddress = (TextView)findViewById(R.id.HospitalAddress);
                        HospitalAddress.setText(HospitalData.getHospitalAddress());
                        HospitalPhone = (TextView)findViewById(R.id.HospitalPhone);
                        HospitalPhone.setText(HospitalData.getHospitalPhone());
                        HospitalKakao = (TextView)findViewById(R.id.HospitalKakao);
                        HospitalKakao.setText(HospitalData.getHospitalKakao());
                        AccountNum = (TextView)findViewById(R.id.AccountNum);
                        AccountNum.setText(HospitalData.getAccountNum());
                        HospitalTime = (TextView)findViewById(R.id.HospitalTime);
                        HospitalTime.setText(HospitalData.gethospitalTime());
                        HospitalExtra = (TextView)findViewById(R.id.HospitalExtra);
                        HospitalExtra.setText(HospitalData.getHospitalExtra());
                        HospitalCost = (TextView)findViewById(R.id.HospitalCost);
                        HospitalCost.setText(HospitalData.getHospitalCost());

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        HospitalInformationControl HospitalRequest = new HospitalInformationControl("2", responseListener);
        RequestQueue queue = Volley.newRequestQueue(HospitalInformationHostActivity.this);
        queue.add(HospitalRequest);

    }
    public void sendImageRequest(ImageView imageView, String url) {
        ImageLoadControl task = new ImageLoadControl(url, imageView);
        task.execute();
    }

    public void onClick_edit_Hospital(View view){
        System.out.println("뿅: "+ HospitalData.getHospitalNum());
        Intent intent = new Intent(HospitalInformationHostActivity.this, hospitalInformationEditActivity.class);
        intent.putExtra( "UserNum", userData.getUserNum());
        intent.putExtra( "UserName", userData.getUserName());
        intent.putExtra( "UserEmail", userData.getUserEmail());
        intent.putExtra( "UserPhoneNum", userData.getUserPhoneNum());
        intent.putExtra( "Host", userData.getHost());
        intent.putExtra("HospitalNum", HospitalData.getHospitalNum());
        intent.putExtra("HostNum", HospitalData.getHostNum());
        intent.putExtra("HospitalName", HospitalData.getHospitalName());
        intent.putExtra("HospitalAddress", HospitalData.getHospitalAddress());
        intent.putExtra("HospitalPhone", HospitalData.getHospitalPhone());
        intent.putExtra("HospitalKakao", HospitalData.getHospitalKakao());
        intent.putExtra("AccountNum", HospitalData.getAccountNum());
        intent.putExtra("HospitalTime", HospitalData.gethospitalTime());
        intent.putExtra("HospitalExtra", HospitalData.getHospitalExtra());
        intent.putExtra("HospitalCost", HospitalData.getHospitalCost());
        intent.putExtra("imagepath", HospitalData.getImagepath());
        startActivity( intent );
    }
}