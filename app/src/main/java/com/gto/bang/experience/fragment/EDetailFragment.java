package com.gto.bang.experience.fragment;

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
public class EDetailFragment extends Fragment {
     TextView content;
     TextView author;
     TextView title;
     TextView date;

    public EDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bang_experience_detail, container, false);

        content=(TextView)rootView.findViewById(R.id.bang_econtent_tv);
        author=(TextView)rootView.findViewById(R.id.bang_eauthor_tv);
        title=(TextView)rootView.findViewById(R.id.bang_etitle_tv);
        date=(TextView)rootView.findViewById(R.id.bang_edate_tv);

        return rootView;
    }



}
