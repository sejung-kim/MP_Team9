package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HospitalListActivity extends AppCompatActivity {
    //병원 관리자가 병원을 업로드한 리스트를 볼 수 있는 목록
    private Button button_hospital_add;
    TextView HospitalName, HospitalAddress;
    ImageView imageView;
    hospitalUploadData HospitalData = new hospitalUploadData();
    UserData userData = new UserData();
    ListView listView = null;          // 검색을 보여줄 리스트변수
    private ListViewControl adapter;      // 리스트뷰에 연결할 아답터


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.

        // 리스트에 연동될 아답터를 생성한다.

        Intent intent = getIntent();
        userData.putUserId(intent.getStringExtra("UserId"));
        userData.putUserPassword(intent.getStringExtra("UserPwd"));
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhoneNum"));
        userData.putAdmin(intent.getStringExtra("Host"));

        adapter = new ListViewControl();
        listView = (ListView) findViewById(R.id.listView);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get TextView's Text
                //String strText = (String)parent.getItemAtPosition(position);

                //데이터 가지고 캠핑장 세부 내용 보여주기
                Intent intent = new Intent(HospitalListActivity.this, HospitalInformationHostActivity.class);
                intent.putExtra( "UserId", userData.getUserId());
                intent.putExtra( "UserPwd", userData.getUserPassword());
                intent.putExtra( "UserName", userData.getUserName());
                intent.putExtra( "UserNum", userData.getUserNum());
                intent.putExtra( "UserEmail", userData.getUserEmail());
                intent.putExtra( "UserPhoneNum", userData.getUserPhoneNum());
                intent.putExtra( "Host", userData.getHost());
                startActivity(intent);
            }
        });

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("안녕");
                    System.out.println(response);
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {
                        System.out.println("하세요");
                        HospitalData.putHospitalUploadData(jsonObject);


                        System.out.print(HospitalData.getHospitalNum());
                        //이미지 로드
                        HospitalName = (TextView)findViewById(R.id.HospitalName);
                        HospitalName.setText(HospitalData.getHospitalName());
                        HospitalAddress = (TextView)findViewById(R.id.HospitalAddress);
                        HospitalAddress.setText(HospitalData.getHospitalAddress());

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        HospitalListControl hospitalRequest = new HospitalListControl("2", responseListener);
        RequestQueue queue = Volley.newRequestQueue(HospitalListActivity.this);
        queue.add(hospitalRequest);

        adapter.addItem(null, "행복병원", "[진료 과목] 소아청소년과, 내과, 이비인후과, 피부과, 안과\r\n경기도 성남시 분당구 운중로 140");
    }
    public void sendImageRequest(ImageView imageView, String url) {
        ImageLoadControl task = new ImageLoadControl(url, imageView);
        task.execute();
    }

    public void onClick_hospital_add(View view){
        Intent intent = new Intent(HospitalListActivity.this, HospitalUploadActivity.class);
        intent.putExtra( "UserNum", userData.getUserNum());
        intent.putExtra( "UserName", userData.getUserName());
        intent.putExtra( "UserEmail", userData.getUserEmail());
        intent.putExtra( "UserPhoneNum", userData.getUserPhoneNum());
        intent.putExtra( "Host", userData.getHost());
        startActivity(intent);
    }
}