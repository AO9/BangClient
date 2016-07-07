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

//    Button eCreateBtn;
//    Button qCreateBtn;
//    ViewPager viewPager;


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
//        setContentView(R.layout.bang_create_main);
//        initViews();

    }

//    protected void initViews(){
//        eCreateBtn=(Button)findViewById(R.id.bang_ecreate_bt);
//        qCreateBtn=(Button)findViewById(R.id.bang_qcreate_bt);
//        eCreateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(0);
//                viewPager.invalidate();
//            }
//        });
//
//        qCreateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(1);
//            }
//        });
//
//
//
//        viewPager=(ViewPager)findViewById(R.id.bang_create_vp);
//        CommonViewPagerAdapter adapter=new CommonViewPagerAdapter(getSupportFragmentManager(),
//                new Class[]{ECreateFragment.class, QCreateFragment.class},
//                new String[]{getString(R.string.bang_create_question), getString(R.string.bang_create_experience)});
//
//        viewPager.setAdapter(adapter);
//        viewPager.setCurrentItem(0);
//        viewPager.setAdapter(adapter);
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                if(0==position){
////                    eCreateBtn.setSelected(true);
////                    eCreateBtn.setTextColor(Color.parseColor("#1586FF"));
////                    qCreateBtn.setSelected(false);
////                    eCreateBtn.setTextColor(Color.parseColor("#000000"));
////                }else{
////                    eCreateBtn.setSelected(false);
////                    qCreateBtn.setSelected(true);
////                    qCreateBtn.setTextColor(Color.parseColor("#1586FF"));
////                    eCreateBtn.setTextColor(Color.parseColor("#000000"));
////                }
//
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });




//    }

}
