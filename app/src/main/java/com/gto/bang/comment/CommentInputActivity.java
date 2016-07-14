package com.gto.bang.comment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gto.bang.R;
import com.gto.bang.base.BaseActivity;
import com.gto.bang.create.network.CreateRequest;
import com.gto.bang.message.MessageActivity;
import com.gto.bang.util.Constant;
import com.gto.bang.util.VolleyUtils;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by shenjialong on 16/6/10 12:54.
 */
public class CommentInputActivity extends BaseActivity{

    public static int SUCCESS=1;
    public static int FAILE=0;

    public static String REQUEST_TAG="comment_tag";

    EditText comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_input);
        initViews();
    }

    private void initViews(){
        comment=(EditText)findViewById(R.id.info_input_et);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.ok, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.action_ok:

                if(submit()){
                    intent = new Intent(this, MessageActivity.class);
                    Bundle b=new Bundle();
                    b.putString("newName","鷥鷥的大恐龙");
                    intent.putExtras(b);
                    //传递成功或者失败
                    setResult(SUCCESS,intent);
                    finish();
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private boolean submit(){

        Log.i("sjl","开始校验");
        if(check()){
            Log.i("sjl","校验通过");
            publish();
            return true;
        }else{
            Toast t = Toast.makeText(CommentInputActivity.this, "请填写评论内容", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

    }

    public boolean check(){
        if(null==comment|| comment.getText()==null||StringUtils.isEmpty(comment.getText().toString())){
            return false;
        }
        return true;
    }

    /**
     * 发布经验
     */
    public void publish() {
        //校验通过后拼接请求参数并向服务器发送请求
        StringBuilder sb=new StringBuilder();
        sb.append("&content=").append(comment.getText().toString()).append("&type=1&userId=123&artId=1&username=123&artTitle=1");
        ResponseListener responseListener = new ResponseListener();
        Log.i("sjl","url:"+ Constant.URL_BASE+ CreateRequest.AJAX+sb.toString());
        CreateRequest.Request req = new CreateRequest.Request(
                CommentInputActivity.this, responseListener, responseListener, sb.toString());
        req.setTag(REQUEST_TAG);
        VolleyUtils.getRequestQueue(CommentInputActivity.this).add(req);
    }

    /**
     * 请求响应
     */
    public  class ResponseListener implements Response.Listener<Map<String, Object>>, Response.ErrorListener {

        @Override
        public void onErrorResponse(VolleyError arg0) {

            Log.i("sjl","response Error");
        }

        @Override
        public void onResponse(Map<String, Object> res) {

            Log.i("sjl","response"+res.toString());
            Object status=res.get("status");
            Toast t ;
            Log.i("sjl","status:"+status+" data "+res.get("data").toString());
            if(null==status||!"1.0".equals(status.toString())){
                t = Toast.makeText(CommentInputActivity.this, "", Toast.LENGTH_SHORT);
            }else{
                t = Toast.makeText(CommentInputActivity.this, "", Toast.LENGTH_SHORT);
            }
            t.show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        VolleyUtils.getRequestQueue(CommentInputActivity.this).cancelAll(REQUEST_TAG);
    }


}
