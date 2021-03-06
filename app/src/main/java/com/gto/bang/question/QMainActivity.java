package com.gto.bang.question;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gto.bang.R;
import com.gto.bang.base.BaseTabActivity;
import com.gto.bang.comment.CommentInputActivity;
import com.gto.bang.question.fragment.QCommentFragment;
import com.gto.bang.question.fragment.QDetailFragment;
import com.gto.bang.util.Constant;

/**
 * Created by shenjialong on 16/6/10 00:48.
 */
public class QMainActivity extends BaseTabActivity{

    public  static  int COMMENT=10000;

    @Override
    public void init(){
        this.titles = new String[]{getString(R.string.bang_question), getString(R.string.bang_comment)};
        this.tabIds=new int[]{R.id.bang_e_section1,R.id.bang_e_section2};
        this.fragments=new Class[]{ QDetailFragment.class,QCommentFragment.class};
        this.tabNum=2;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.comment, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_write_comment:
                //点评的按钮
                intent = new Intent(this, CommentInputActivity.class);
                startActivityForResult(intent, Constant.CALL_COMMENT_ACTIVITY);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==CommentInputActivity.SUCCESS){
            //reload listview data from server
            Toast.makeText(this,"评论成功",Toast.LENGTH_LONG).show();
        }
    }
}
