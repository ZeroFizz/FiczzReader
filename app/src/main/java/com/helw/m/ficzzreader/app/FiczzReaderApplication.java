package com.helw.m.ficzzreader.app;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.helw.m.ficzzreader.utils.DebugUtil;
import com.helw.m.mylibrary.HttpUtils;

/**
 * Created by user on 2017/12/7.
 */

public class FiczzReaderApplication extends Application {

    private static FiczzReaderApplication ficzzReaderApplication;

    public static FiczzReaderApplication getInstance() {
        return ficzzReaderApplication;
    }

    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();
        ficzzReaderApplication = this;
        HttpUtils.getInstance().init(this, DebugUtil.DEBUG);
        initTextSize();
    }

    /**
     * 使其系统更改字体大小无效
     */
    private void initTextSize() {
        Resources res = getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}
