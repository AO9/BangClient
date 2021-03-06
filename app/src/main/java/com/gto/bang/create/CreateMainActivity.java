package com.gto.bang.create;

import android.os.Bundle;

import com.gto.bang.R;
import com.gto.bang.base.BaseTabActivity;
import com.gto.bang.create.fragment.ECreateFragment;
import com.gto.bang.create.fragment.QCreateFragment;

/**
 * Created by shenjialong on 16/6/10 01:37.
 * 新建主入口类＝新建经验分享＋新建问答
 */
public class CreateMainActivity extends BaseTabActivity {

    @Override
    public void init(){
        this.titles = new String[]{getString(R.string.bang_create_experience),getString(R.string.bang_create_question) };
        this.tabIds=new int[]{R.id.bang_e_section1,R.id.bang_e_section2};
        this.fragments=new Class[]{ ECreateFragment.class,QCreateFragment.class};
        this.tabNum=2;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
