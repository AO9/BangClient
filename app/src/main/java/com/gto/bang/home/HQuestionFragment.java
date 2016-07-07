package com.gto.bang.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gto.bang.R;
import com.gto.bang.question.QMainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shenjialong on 16/6/9 19:53.
 * 首页－问答tab
 */
public class HQuestionFragment extends Fragment {

    ListView listView;

    public HQuestionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        listView=(ListView) rootView.findViewById(R.id.msgListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), QMainActivity.class);
                startActivity(intent);
            }
        });

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData1(), R.layout.hquestion_item, new String[]{
                "title_e", "author_e", "pv_e","date_e"},
                new int[]{R.id.title_e_tv, R.id.author_e_tv, R.id.pv_e_tv,R.id.date_e_tv});

        listView.setAdapter(adapter);
        return rootView;
    }


    //------------------------------------------------以下是测试数据－－－－－－－－－－－－－－

    String[] titles=new String[]{"答辩注意事项","论文规范性审查感悟","选题报告不会写！","项目背景描述哪里找"};
    String[] authors=new String[]{"论文届大佬","北交大学生","小弟","大连理工的学生"};
    String[] dates=new String[]{"20160609","20160605","20160605","20160605"};
    int[] pvs=new int[]{12,22,12,3};


    public List<Map<String, Object>> getData1() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;

        for(int j=0;j<3;j++){
            for(int i=0;i<titles.length;i++){
                map= new HashMap<String, Object>();
                map.put("title_e", titles[i]);
                map.put("author_e", authors[i]);
                map.put("pv_e", pvs[i]);
                map.put("date_e",dates[i]);
                list.add(map);
            }
        }

        return list;
    }
}