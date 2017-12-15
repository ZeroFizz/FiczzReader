package com.helw.m.ficzzreader.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.helw.m.ficzzreader.R;
import com.helw.m.ficzzreader.base.BaseActivity;
import com.helw.m.ficzzreader.databinding.ActivityNavDownloadBinding;
import com.helw.m.ficzzreader.utils.PerfectClickListener;
import com.helw.m.ficzzreader.utils.QRCodeUtil;
import com.helw.m.ficzzreader.utils.ShareUtils;

/**
 * Created by user on 2017/12/13.
 */

public class NavDownloadActivity extends BaseActivity<ActivityNavDownloadBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_download);
        showContentView();


        setTitle("扫码下载");
        String url = "https://www.pgyer.com/mM63";
        QRCodeUtil.showThreadImage(this, url, bindingView.ivErweima, R.mipmap.ic_cloudreader_mip);
        bindingView.tvShare.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                ShareUtils.share(v.getContext(), R.string.string_share_text);
            }
        });
    }

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, NavDownloadActivity.class);
        mContext.startActivity(intent);
    }
}
