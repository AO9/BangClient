package com.gto.bang.question.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gto.bang.R;

/**
 * Created by shenjialong on 16/6/9 15:08.
 * 经验详情页
 */
public class QDetailFragment extends Fragment {
    TextView content;
    TextView author;
    TextView title;
    TextView date;
    TextView describe;

    public QDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bang_question_detail, container, false);

        content=(TextView)rootView.findViewById(R.id.question_detail_content_tv);
        author=(TextView)rootView.findViewById(R.id.question_detail_author_tv);
        title=(TextView)rootView.findViewById(R.id.question_detail_title_tv);
        date=(TextView)rootView.findViewById(R.id.question_detail_date_tv);
        describe=(TextView)rootView.findViewById(R.id.question_detail_describe_tv);

        return rootView;
    }



}
