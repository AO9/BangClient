package com.gto.bang.personal.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gto.bang.R;
import com.gto.bang.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shenjialong on 16/6/10 19:08.
 */
public class PQuestionActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bang_common_listview);
        ListView listView=(ListView)findViewById(R.id.bang_common_lv);
        SimpleAdapter adapter = new SimpleAdapter(PQuestionActivity.this, getData1(), R.layout.bang_pmyquestion_item, new String[]{
                "title","date"},
                new int[]{R.id.bang_pmyquestion_title_tv,R.id.bang_pmyquestion_date_tv});
        listView.setAdapter(adapter);

    }

    //------------------------------------------------以下是测试数据－－－－－－－－－－－－－－

    String[] titles=new String[]{"这事标题","这事标题" +
            "这事标题","这事标题","这事标题这事标题这事标题这事标题这事标题"};
    String[] dates=new String[]{"20160514","20160514" +
            "20160514","20160514","20160514"};

    public List<Map<String, Object>> getData1() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;

        for(int j=0;j<3;j++){
            for(int i=0;i<titles.length;i++){
                map= new HashMap<String, Object>();
                map.put("title", titles[i]);
                map.put("date", dates[i]);
                list.add(map);
            }
        }

        return list;
    }
}
