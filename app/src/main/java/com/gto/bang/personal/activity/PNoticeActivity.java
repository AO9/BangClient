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
 * Created by shenjialong on 16/6/11 22:43.
 * 个人中心——通知页
 */
public class PNoticeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bang_common_listview);
        ListView listView=(ListView)findViewById(R.id.bang_common_lv);
        SimpleAdapter adapter = new SimpleAdapter(PNoticeActivity.this, getData1(), R.layout.bang_pmynotice_item, new String[]{
                "bang_ncontent_tv"},
                new int[]{R.id.bang_ncontent_tv});
        listView.setAdapter(adapter);

    }


    //------------------------------------------------以下是测试数据－－－－－－－－－－－－－－

    String[] comtents=new String[]{"这是系统通知","这是系统通知这是系统通知这是系统通知这是系统通知这是系统通知这是系统通知这是系统通知这是系统通知" +
            "这是系统通知","这是系统通知","这是系统通知这是系统通知"};

    public List<Map<String, Object>> getData1() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;

        for(int j=0;j<3;j++){
            for(int i=0;i<comtents.length;i++){
                map= new HashMap<String, Object>();
                map.put("bang_ncontent_tv", comtents[i]);
                list.add(map);
            }
        }

        return list;
    }

}
