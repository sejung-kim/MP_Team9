package com.example.Healing_time;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class HospitalInformationControl extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://humming1106.dothome.co.kr/getHospitalData.php";
    private Map<String, String> map;

    public HospitalInformationControl(String num, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("hospitalNum", num);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
