package com.gto.bang.comment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.gto.bang.R;
import com.gto.bang.base.BaseActivity;
import com.gto.bang.message.MessageActivity;

/**
 * Created by shenjialong on 16/6/10 12:54.
 */
public class CommentInputActivity extends BaseActivity{

    public static int SUCCESS=1;
    public static int FAILE=0;

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
                //todo:发起http请求 
                intent = new Intent(this, MessageActivity.class);
                Bundle b=new Bundle();
                b.putString("newName","鷥鷥的大恐龙");
                intent.putExtras(b);
                //传递成功或者失败
                setResult(SUCCESS,intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
