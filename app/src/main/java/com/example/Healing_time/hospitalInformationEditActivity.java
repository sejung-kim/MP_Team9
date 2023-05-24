package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class hospitalInformationEditActivity extends AppCompatActivity {

    private static String IP_ADDRESS = "humming1106.dothome.co.kr";
    private static String hospitalUpload = "/HospitalDataInsert.php";

    private static final int REQUEST_CODE = 21;
    private ImageView image_addphoto;
    private Bitmap bitmapimg;
    ImageView imageView;

    hospitalUploadData hospitalData = new hospitalUploadData();
    UserData userData = new UserData();
    private EditText editText_hospitalName;
    private EditText editText_hospitalAddress;
    private EditText editText_hospitalPhone;
    private EditText editText_hospitalKakao;
    private EditText editText_hospitalTime;
    private EditText editText_hospitalExtra;
    private static String reservation = "/HospitalEdit.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_information_edit);

        Intent intent = getIntent();
        //hospitalData.putImagePath(intent.getStringExtra("imagepath"));
        hospitalData.putHospitalName(intent.getStringExtra("HospitalName"));
        hospitalData.putHospitalNum(intent.getStringExtra("HospitalNum"));
        hospitalData.putHostNum(intent.getStringExtra("HostNum"));
        hospitalData.putHospitalAddress(intent.getStringExtra("HospitalAddress"));
        hospitalData.putHospitalPhone(intent.getStringExtra("HospitalPhone"));
        hospitalData.putHospitalKakao(intent.getStringExtra("HospitalKakao"));
        hospitalData.putHospitalTime(intent.getStringExtra("HospitalTime"));
        hospitalData.putHospitalExtra(intent.getStringExtra("HospitalExtra"));
        userData.putUserId(intent.getStringExtra("UserId"));
        userData.putUserPassword(intent.getStringExtra("UserPwd"));
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhoneNum"));
        userData.putAdmin(intent.getStringExtra("Host"));


        //imageView = findViewById(R.id.image_addphoto);
        //sendImageRequest(imageView, "http://humming1106.dothome.co.kr/"+ hospitalData.getImagepath());
        editText_hospitalName = (EditText)findViewById(R.id.editText_HospitalName);
        editText_hospitalName.setText(hospitalData.getHospitalName());
        editText_hospitalAddress = (EditText)findViewById(R.id.editText_HospitalAddress);
        editText_hospitalAddress.setText(hospitalData.getHospitalAddress());
        editText_hospitalPhone = (EditText)findViewById(R.id.editText_HospitalPhone);
        editText_hospitalPhone.setText(hospitalData.getHospitalPhone());
        editText_hospitalKakao = (EditText)findViewById(R.id.editText_HospitalKakao);
        editText_hospitalKakao.setText(hospitalData.getHospitalKakao());
        editText_hospitalTime = (EditText)findViewById(R.id.editText_HospitalTime);
        editText_hospitalTime.setText(hospitalData.gethospitalTime());
        editText_hospitalExtra = (EditText)findViewById(R.id.editText_HospitalExtra);
        editText_hospitalExtra.setText(hospitalData.getHospitalExtra());

        //image_addphoto = findViewById(R.id.image_addphoto);
//        image_addphoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, REQUEST_CODE);
//            }
//        });
    }
//    public void sendImageRequest(ImageView imageView, String url) {
//        ImageLoadControl task = new ImageLoadControl(url, imageView);
//        task.execute();
//    }

    public void onClick_edit_complete_Hospital(View view){

        String hospitalname = editText_hospitalName.getText().toString();
        String hospitaladdress = editText_hospitalAddress.getText().toString();
        String hospitalphone = editText_hospitalPhone.getText().toString();
        String hospitalkakao = editText_hospitalKakao.getText().toString();
        String hospitaltime = editText_hospitalTime.getText().toString();
        String hospitalextra = editText_hospitalExtra.getText().toString();
        hospitalInformationEditControl task = new hospitalInformationEditControl();
        task.execute("http://" + IP_ADDRESS + reservation, hospitalData.getHospitalNum(),hospitalname,hospitaladdress, hospitalphone,hospitalkakao,hospitaltime,hospitalextra);

        Intent intent = new Intent(hospitalInformationEditActivity.this, HospitalInformationHostActivity.class);
        intent.putExtra("HospitalNum", hospitalData.getHospitalName());
        intent.putExtra("HostNum", hospitalData.getHostNum());
        intent.putExtra("HospitalName", hospitalname);
        intent.putExtra("HospitalAddress", hospitaladdress);
        intent.putExtra("HospitalPhone", hospitalphone);
        intent.putExtra("HospitalKakao", hospitalkakao);
        intent.putExtra("HospitalTime", hospitaltime);
        intent.putExtra("HospitalExtra", hospitalextra);
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