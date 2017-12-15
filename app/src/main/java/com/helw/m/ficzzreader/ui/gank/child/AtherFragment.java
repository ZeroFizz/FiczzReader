package com.helw.m.ficzzreader.ui.gank.child;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.helw.m.ficzzreader.R;

/**
 * Created by user on 2017/12/14.
 */

public class AtherFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ll = inflater.inflate(R.layout.fragment_base_old, null);
        TextView tv = (TextView) ll.findViewById(R.id.tv);
        tv.setText("AtherFragment");
        return ll;
    }
}