package com.gto.bang.create.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gto.bang.R;

/**
 * Created by shenjialong on 16/6/10 02:04.
 * 新建 经验
 */
public class ECreateFragment extends Fragment {

    private TextView content;
    private TextView keyword;
    private TextView title;
    private TextView save;

    public ECreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bang_experience, container, false);
        initViews(rootView);

        return rootView;
    }

    public void initViews(View rootView){

        content=(TextView)rootView.findViewById(R.id.experience_content_et);
        keyword=(TextView)rootView.findViewById(R.id.experience_keyword_et);
        title=(TextView)rootView.findViewById(R.id.experience_title_et);
        save=(TextView)rootView.findViewById(R.id.experience_save_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT);
                t.show();
            }
        });

    }

}
