package com.gto.bang.experience.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gto.bang.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shenjialong on 16/6/9 15:07.
 */
public class ECommentFragment extends Fragment {

    ListView content;

    public ECommentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.bang_experience_comment, container, false);
        content=(ListView) rootView.findViewById(R.id.bang_c_listview);

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData1(), R.layout.bang_ecomment_item, new String[]{
                "author_e", "title_e", "date_e"},
                new int[]{R.id.bang_ecomment_item_author_tv, R.id.bang_ecomment_item_content_tv, R.id.bang_ecomment_item_date_tv});
        content.setAdapter(adapter);
        return rootView;
    }


    //------------------------------------------------以下是测试数据－－－－－－－－－－－－－－

    String[] titles=new String[]{"业界良心之作品","受教了","非常好的文章，给个赞！","论文答辩有希望啦"};
    String[] authors=new String[]{"论文届大佬","北交大学生","小弟","大连理工的学生"};
    String[] dates=new String[]{"20160609","20160605","20160605","20160605"};

    public  List<Map<String, Object>> getData1() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;

        for(int j=0;j<3;j++){
            for(int i=0;i<titles.length;i++){
                map= new HashMap<String, Object>();
                map.put("title_e", titles[i]);
                map.put("author_e", authors[i]);
                map.put("date_e",dates[i]);
                list.add(map);
            }
        }

        return list;
    }

}
