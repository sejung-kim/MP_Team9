package com.example.Healing_time;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<String> list;          // 데이터를 넣은 리스트변수
    ListView listView = null;          // 검색을 보여줄 리스트변수
    private EditText editText_Search_filter;        // 검색어를 입력할 Input 창
    private ListViewControl adapter;      // 리스트뷰에 연결할 아답터
    UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        userData.putUserId(intent.getStringExtra("UserId"));
        userData.putUserPassword(intent.getStringExtra("UserPwd"));
        userData.putUserNum(intent.getStringExtra("UserNum"));
        userData.putUserName(intent.getStringExtra("UserName"));
        userData.putUserEmail(intent.getStringExtra("UserEmail"));
        userData.putUserPhoneNum(intent.getStringExtra("UserPhoneNum"));
        userData.putAdmin(intent.getStringExtra("Host"));

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.

        // 리스트에 연동될 아답터를 생성한다.
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
                Intent intent = new Intent(SearchActivity.this, HospitalInformationUserActivity.class);
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

        editText_Search_filter = (EditText) findViewById(R.id.editText_Search_filder);
        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editText_Search_filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filterText = editable.toString() ;
                ((ListViewControl)listView.getAdapter()).getFilter().filter(filterText);
            }
        });

        // 검색에 사용할 데이터을 미리 저장한다.
        adapter.addItem(null, "행복 병원", "[진료 과목] 소아청소년과, 내과, 이비인후과, 피부과, 안과\r\n경기 성남시 분당구 운중동\r\n"); ;

        adapter.addItem(null, "연세 소아과", "[진료 과목] 소아청소년과, 예방접종\r\n경기 성남시 분당구 정자동") ;

        adapter.addItem(null, "성남 치과", "[진료 과목] 치과\r\n경기 성남시 분당구 서현동") ;

        adapter.addItem(null, "바른 병원", "[진료 과목] 내과, 이비인후과\r\n경기 성남시 수정구 장곡동") ;

        adapter.addItem(null, "다솜 의원", "[진료 과목] 내과, 소아청소년과, 신경외과, 외과, 정형외과\r\n경기 성남시 수정구 태평동") ;

        adapter.addItem(null, "마이엠 치과 의원", "[진료 과목] 치과\r\n성남 수정구 복정동") ;

    }

}