package com.example.Healing_time;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalUploadActivity extends AppCompatActivity {
    //병원 관리자가 병원을 등록하는 화면
    private static String IP_ADDRESS = "humming1106.dothome.co.kr";
    private static String HospitalUpload = "/HospitalDataInsert.php";

    private static final int REQUEST_CODE = 21;
    private ImageView image_addphoto;
    private Bitmap bitmapimg;

    private EditText editText_HospitalName;
    private EditText editText_HospitalAddress;
    private EditText editText_HospitalPhone;
    private EditText editText_HospitalKakao;
    private EditText editText_HospitalTime;
    private EditText editText_HospitalExtra;
    UserData userData = new UserData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_upload);

        Intent intent = getIntent();
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhone"));
        userData.putAdmin(intent.getStringExtra("Host"));

        editText_HospitalName = (EditText)findViewById(R.id.editText_HospitalName);
        editText_HospitalAddress = (EditText)findViewById(R.id.editText_HospitalAddress);
        editText_HospitalPhone = (EditText)findViewById(R.id.editText_HospitalPhone);
        editText_HospitalKakao = (EditText)findViewById(R.id.editText_HospitalKakao);
        editText_HospitalTime = (EditText)findViewById(R.id.editText_HospitalTime);
        editText_HospitalExtra = (EditText)findViewById(R.id.editText_HospitalExtra);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK && data.getData()!= null) {
                Uri path = data.getData();
                try {
                    //InputStream in = getContentResolver().openInputStream(path);
                    bitmapimg = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                    image_addphoto.setImageBitmap(bitmapimg);
                    //in.close();

                    //addphoto_image.setImageBitmap(bitmapimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }
//    protected void uploadImage() {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmapimg.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream);
//        byte[] imageInByte = byteArrayOutputStream.toByteArray();
//
//        String encodedImage = Base64.encodeToString(imageInByte, Base64.DEFAULT);
//        //Toast.makeText(this, encodedImgae,Toast.LENGTH_SHORT).show();
//        Call<ResponsePOJO> call = Client.getInstancce().getApi().uploadImage(encodedImage);
//        call.enqueue(new Callback<ResponsePOJO>() {
//            @Override
//            public void onResponse(Call<ResponsePOJO> call, Response<ResponsePOJO> response) {
//                Toast.makeText(HospitalUploadActivity.this, response.body().getRemarks(), Toast.LENGTH_SHORT).show();
//
//                if (response.body().isStatus()) {
//
//                } else {
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponsePOJO> call, Throwable t) {
//                Toast.makeText(HospitalUploadActivity.this, "Network Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    protected void uploadHospitalData(){

    }

    public void onClick_upload_hospital(View view){
        String hospitalName = editText_HospitalName.getText().toString();
        String hospitalAddress = editText_HospitalAddress.getText().toString();
        String hospitalPhone = editText_HospitalPhone.getText().toString();
        String hospitalKakao = editText_HospitalKakao.getText().toString();
        String hospitalTime = editText_HospitalTime.getText().toString();
        String hospitalExtra = editText_HospitalExtra.getText().toString();

        HospitalUploadControl task = new HospitalUploadControl();
        //InsertDataControl task = new InsertDataControl();
        System.out.println(userData.getUserNum());
        task.execute("http://" + IP_ADDRESS + HospitalUpload, userData.getUserNum(),hospitalName, hospitalAddress, hospitalPhone,hospitalKakao, hospitalTime, hospitalExtra);
        //uploadImage();
        Intent intent = new Intent(HospitalUploadActivity.this, HospitalInformationHostActivity.class);
        startActivity(intent);
    }
}