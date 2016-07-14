package com.gto.bang.create.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gto.bang.R;
import com.gto.bang.base.BaseInputFragment;
import com.gto.bang.create.network.CreateRequest;
import com.gto.bang.util.Constant;
import com.gto.bang.util.VolleyUtils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by shenjialong on 16/6/10 02:06.
 * 新建 问答  update 2016-07-14
 */
public class QCreateFragment extends BaseInputFragment {


    TextView question_theme;
    TextView question_describe;
    Button question_save;
    TextView [] textViews;
    String [] inputHints=new String[]{"请填写问答题目","请填写问答内容"};

    public QCreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bang_question, container, false);
        return rootView;
    }

    @Override
    public void initViews(){

        View rootView=getView();
        question_describe=(TextView)rootView.findViewById(R.id.question_describe_et);
        question_theme=(TextView)rootView.findViewById(R.id.question_theme_et);
        textViews=new TextView[]{question_describe,question_theme};

        question_save=(Button) rootView.findViewById(R.id.question_ok_btn);

        question_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sjl","开始校验");
                if(check()){
                    Log.i("sjl","校验通过");
                    //校验通过后拼接请求参数并向服务器发送请求
                    StringBuilder sb=new StringBuilder();
                    sb.append("title=").append(question_theme.getText().toString()).append("&content=")
                            .append(question_describe.getText().toString()).append("&type=2&authorid=123");
                    publish(sb.toString());
                }
            }
        });
    }

    /**
     * 发布
     */
    public void publish(String params) {
        ResponseListener responseListener = new ResponseListener();
        Log.i("sjl","url:"+ Constant.URL_BASE+ CreateRequest.AJAX+params);
        CreateRequest.Request req = new CreateRequest.Request(
                getActivity(), responseListener, responseListener, params);
        req.setTag(getRequestTag());
        VolleyUtils.getRequestQueue(getActivity()).add(req);
    }

    /**
     * 字段非空校验
     * @return
     */
    private boolean check(){
        Log.i("sjl","begin check");
        for(int i=0;i<textViews.length;i++){
            if(null==textViews[i].getText()|| StringUtils.isEmpty(textViews[i].getText().toString())){
                Toast t = Toast.makeText(getActivity(), inputHints[i], Toast.LENGTH_SHORT);
                t.show();
                return false;
            }
        }
        return true;
    }

    @Override
    protected String getRequestTag(){
        return "QCreateTag";
    }

}
