package com.gto.bang.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gto.bang.R;
import com.gto.bang.college.CollegeActivity;

/**
 * Created by shenjialong on 16/6/9 19:53.
 * 首页－帮帮tab
 */
public class HBangbangFragment extends Fragment {


    TextView college;

    public HBangbangFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.bang_bang, container, false);
        college=(TextView)rootView.findViewById(R.id.bang_bang_college_tv);
        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), CollegeActivity.class);
                startActivityForResult(intent,2001);
            }
        });
        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==20001){
            Bundle b=data.getExtras();
            String collegeName=b.getString("college");
            Toast t = Toast.makeText(getActivity(), b.getString("college"), Toast.LENGTH_SHORT);
            t.show();
            this.college.setText(collegeName);

        }

    }

}