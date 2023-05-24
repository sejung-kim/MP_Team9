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
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hospital1),
                "Sam Smith", "I'm not the only one.\r\nStay with me.\r\n"); ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hospital2),
                "Bryan Adams", "heaven.\r\nI do it for you.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hospital3),
                "Eric Clapton", "Tears in heaven.\r\nChange the world.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hospital3),
                "Gary Moore", "Still got the blues.\r\nOne day.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hospital4),
                "Helloween", "A tale that wasn't right.\r\nI want out.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hospital1),
                "Adele", "Hello.\r\nSomeone like you.") ;

    }

}