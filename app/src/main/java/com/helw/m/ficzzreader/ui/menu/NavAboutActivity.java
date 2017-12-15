package com.helw.m.ficzzreader.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.helw.m.ficzzreader.R;
import com.helw.m.ficzzreader.base.BaseActivity;
import com.helw.m.ficzzreader.databinding.ActivityNavAboutBinding;
import com.helw.m.ficzzreader.utils.BaseTools;
import com.helw.m.ficzzreader.utils.CommonUtils;
import com.helw.m.ficzzreader.utils.PerfectClickListener;
import com.helw.m.ficzzreader.view.webview.WebViewActivity;

/**
 * Created by user on 2017/12/13.
 */

public class NavAboutActivity extends BaseActivity<ActivityNavAboutBinding> {

    private static String string_url_update_log = "http://jingbin.me/2016/12/30/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97-%E4%BA%91%E9%98%85/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_about);
        showContentView();
        setTitle("关于FiczzReader");
        bindingView.tvVersionName.setText("当前版本 V" + BaseTools.getVersionName());


        // 直接写在布局文件里会很耗内存
        Glide.with(this).load(R.mipmap.ic_cloudreader).into(bindingView.ivIcon);
        bindingView.tvGankio.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        bindingView.tvGankio.getPaint().setAntiAlias(true);//抗锯齿
        bindingView.tvDouban.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        bindingView.tvDouban.getPaint().setAntiAlias(true);//抗锯齿

        initListener();
    }

    private void initListener() {
        bindingView.tvGankio.setOnClickListener(listener);
        bindingView.tvDouban.setOnClickListener(listener);
        bindingView.tvAboutStar.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                BaseTools.openLink(v.getContext(), CommonUtils.getString(R.string.string_url_cloudreader));
            }
        });
        bindingView.tvFunction.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                BaseTools.openLink(v.getContext(), CommonUtils.getString(R.string.string_url_cloudreader));
            }
        });
        bindingView.tvNewVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseTools.openLink(v.getContext(), CommonUtils.getString(R.string.string_url_cloudreader));
            }
        });
    }

    private PerfectClickListener listener = new PerfectClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            String url = null;
            switch (v.getId()) {
                case R.id.tv_gankio:
                    url = CommonUtils.getString(R.string.string_url_gankio);
                    break;
                case R.id.tv_douban:
                    url = CommonUtils.getString(R.string.string_url_douban);
                    break;
                case R.id.tv_about_star:
                    url = CommonUtils.getString(R.string.string_url_cloudreader);
                    break;
                case R.id.tv_function:// 更新日志
                    url = CommonUtils.getString(R.string.string_url_cloudreader);
                    break;
                default:
                    break;
            }
            WebViewActivity.loadUrl(v.getContext(), url, "加载中...");
        }
    };

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, NavAboutActivity.class);
        mContext.startActivity(intent);
    }
}
