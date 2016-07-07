package com.gto.bang.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gto.bang.R;
import com.gto.bang.base.BaseActivity;
/**
 * Created by shenjialong on 16/6/11 07:20.
 * 个人中心主页面
 */
public class PMainActivity extends BaseActivity {

    private RelativeLayout noticeRL;
    private RelativeLayout messageRL;
    private RelativeLayout experienceRL;
    private RelativeLayout questionRL;
    RelativeLayout[] rls;

    //显示未读消息数
    private TextView messageNumTV;
    private TextView noticeNumTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bang_person_main);
        initViews();
    }

    private void initViews(){

        experienceRL=(RelativeLayout)findViewById(R.id.pexperience_rl);
        messageRL=(RelativeLayout)findViewById(R.id.pmessage_rl);
        questionRL=(RelativeLayout)findViewById(R.id.pquestion_rl);
        noticeRL=(RelativeLayout)findViewById(R.id.pnotice_rl);
        messageNumTV=(TextView)findViewById(R.id.pmessage_num_tv);
        noticeNumTV=(TextView)findViewById(R.id.pnotice_num_tv);
        rls=new RelativeLayout[]{noticeRL,messageRL,experienceRL,questionRL};
        for(int i=0;i<rls.length;i++){
            rls[i].setOnClickListener(listener);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.pmessage_rl:
                    intent =new Intent(PMainActivity.this,PMessageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.pnotice_rl:
                    intent =new Intent(PMainActivity.this,PNoticeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.pexperience_rl:
                    intent =new Intent(PMainActivity.this,PExperienceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.pquestion_rl:
                    intent =new Intent(PMainActivity.this,PQuestionActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;

            }



        }
    };


}
