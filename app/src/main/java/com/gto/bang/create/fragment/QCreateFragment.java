package com.gto.bang.create.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gto.bang.R;

/**
 * Created by shenjialong on 16/6/10 02:06.
 */
public class QCreateFragment extends Fragment{

    private TextView question_theme;
    private TextView question_describe;
    private Button question_save;
    public QCreateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bang_question, container, false);
        initViews(rootView);
        return rootView;
    }
    public void initViews( View rootView){

        question_describe=(TextView)rootView.findViewById(R.id.question_describe_et);
        question_theme=(TextView)rootView.findViewById(R.id.question_theme_et);
        question_save=(Button) rootView.findViewById(R.id.question_ok_btn);

        question_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }

}
