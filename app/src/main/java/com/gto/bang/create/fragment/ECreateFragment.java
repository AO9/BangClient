package com.gto.bang.create.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gto.bang.R;
import com.gto.bang.base.BaseInputFragment;
import com.gto.bang.create.network.CreateRequest;
import com.gto.bang.util.Constant;
import com.gto.bang.util.VolleyUtils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by shenjialong on 16/6/10 02:04.
 * 新建 经验 update 2016-07-14
 */
public class ECreateFragment extends BaseInputFragment {


    TextView content;
    TextView keyword;
    TextView title;
    TextView[] views;
    String [] inputHints=new String[]{"请填写标题","请填写关键字","请填写经验内容"};

    public ECreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bang_experience, container, false);

        return rootView;
    }


    /**
     * 初始化View的监听事件
     */
    @Override
    public void initViews(){

        View rootView=getView();
        content=(TextView)rootView.findViewById(R.id.experience_content_et);
        keyword=(TextView)rootView.findViewById(R.id.experience_keyword_et);
        title=(TextView)rootView.findViewById(R.id.experience_title_et);

        views=new TextView[]{title,keyword,content};

        TextView save = (TextView) rootView.findViewById(R.id.experience_save_btn);

        //发布经验按钮监听事件
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //参数样式 title=sjl&content=1&type=1&authorid=123&keyword=1
                Log.i("sjl","开始校验");
                if(check()){
                    Log.i("sjl","校验通过");
                    //校验通过后拼接请求参数并向服务器发送请求
                    StringBuilder sb=new StringBuilder();
                    sb.append("title=").append(title.getText().toString()).append("&content=").append(content.getText().toString())
                            .append("&keyword=").append(keyword.getText().toString()).append("&type=1&authorid=123");
                    publish(sb.toString());
                }
            }
        });
    }


    /**
     * 字段非空校验
     * @return
     */
    private boolean check(){
        Log.i("sjl","begin check");
        for(int i=0;i<views.length;i++){
            if(null==views[i].getText()||StringUtils.isEmpty(views[i].getText().toString())){
                Toast t = Toast.makeText(getActivity(), inputHints[i], Toast.LENGTH_SHORT);
                t.show();
                return false;
            }
        }
        return true;
    }


    /**
     * 发布经验
     */
    public void publish(String params) {
        ResponseListener responseListener = new ResponseListener();
        Log.i("sjl","url:"+ Constant.URL_BASE+ CreateRequest.AJAX+params);
        CreateRequest.Request req = new CreateRequest.Request(
                getActivity(), responseListener, responseListener, params);
        req.setTag(getRequestTag());
        VolleyUtils.getRequestQueue(getActivity()).add(req);
    }


    @Override
    protected String getRequestTag(){
        return "ECreateTag";
    }
}
