package com.bwei.day_07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bwei.day_07.adapter.Myxlistview;
import com.bwei.day_07.bean.UserBean;
import com.bwei.day_07.utils.HttpUrlUtils;
import com.bwei.day_07.view.XListView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String path=" https://www.apiopen.top/journalismApi";
    private XListView xListView;
    private  List<UserBean.Data.Mydata> auto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inteformfata();
        insertfordata();


    }
    public void inteformfata(){

        xListView=findViewById(R.id.xlistview);
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                 insertfordata();
            }

            @Override
            public void onLoadMore() {
                insertfordata();
            }
        });

    }
    public void insertfordata(){
        HttpUrlUtils httpUrlUtils=HttpUrlUtils.getInstance();
        httpUrlUtils.getAs(path);
        httpUrlUtils.MyBack(new HttpUrlUtils.Callback() {
            @Override
            public void getdata(String s) {
                Log.i("sss",s);
                Gson gson=new Gson();
                UserBean userBean = gson.fromJson(s,UserBean.class);
                UserBean.Data data = userBean.getData();
                List<UserBean.Data.Mydata> auto = data.getAuto();


                Myxlistview myxlistview=new Myxlistview(auto,MainActivity.this);
                xListView.setAdapter(myxlistview);

            }
        });

    }
}
