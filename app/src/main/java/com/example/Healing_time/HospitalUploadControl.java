package com.example.Healing_time;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HospitalUploadControl extends AsyncTask<String, Void, String> {
    ProgressDialog progressDialog;
    private static String TAG = "test";
    @Override
    protected String doInBackground(String... params) {

        String userNum = (String) params[1];
        String hospitalName = (String) params[2];
        String hospitalAddress = (String) params[3];
        String hospitalPhone = (String) params[4];
        String hospitalKakao = (String) params[5];
        String hospitalTime = (String) params[6];
        String hospitalExtra = (String) params[7];

        String serverURL = (String) params[0];
        //hospitalName, hospitalAddress, hospitalPhone,hospitalKakao, accountNum, hospitalTime, hospitalCost, hospitalExtra);

        //host num 추가해야함
        String postParameters = "userNum=" + userNum + "&name=" + hospitalName + "&address=" + hospitalAddress + "&phone=" + hospitalPhone + "&kakao=" + hospitalKakao + "&time=" + hospitalTime + "&extra=" + hospitalExtra;

        try {

            URL url = new URL(serverURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();


            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(postParameters.getBytes("UTF-8"));

            outputStream.flush();
            outputStream.close();


            int responseStatusCode = httpURLConnection.getResponseCode();
            //reponseStatusCode == 200
            Log.d(TAG, "POST response code - " + responseStatusCode);

            InputStream inputStream;
            if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }


            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }


            bufferedReader.close();


            return sb.toString();


        } catch (Exception e) {

            Log.d(TAG, "InsertData: Error ", e);

            return new String("Error: " + e.getMessage());
        }

    }
}
