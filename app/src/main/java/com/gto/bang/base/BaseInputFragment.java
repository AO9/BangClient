package com.gto.bang.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gto.bang.util.VolleyUtils;

import java.util.Map;

/**
 * Created by shenjialong on 16/7/14 21:34.
 * 带有输入框＋提交按钮功能的Fragment基类
 */
public class BaseInputFragment extends Fragment {

    String [] hints=new String[]{"发布成功","发布失败"};


    public BaseInputFragment() {
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        initViews();
    }


    /**
     * 初始化View
     */
    protected String[] getHints(){
        return hints;
    }


    /**
     * 初始化View
     */
    protected void initViews(){
    }

    /**
     * 请求的标签
     */
    protected String getRequestTag(){
        return null;
    }


    /**
     * 请求响应
     */
    public  class ResponseListener implements Response.Listener<Map<String, Object>>, Response.ErrorListener {

        @Override
        public void onErrorResponse(VolleyError arg0) {

            Log.i("sjl",getRequestTag()+"response Error");
        }

        @Override
        public void onResponse(Map<String, Object> res) {

            Log.i("sjl",getRequestTag()+"response"+res.toString());
            Object status=res.get("status");
            Toast t ;
            Log.i("sjl","status:"+status+" data "+res.get("data").toString());
            if(null==status||!"1.0".equals(status.toString())){
                t = Toast.makeText(getActivity(), getHints()[0], Toast.LENGTH_SHORT);
            }else{
                t = Toast.makeText(getActivity(), getHints()[1], Toast.LENGTH_SHORT);
            }
            t.show();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        VolleyUtils.getRequestQueue(getActivity()).cancelAll(getRequestTag());
    }
}
