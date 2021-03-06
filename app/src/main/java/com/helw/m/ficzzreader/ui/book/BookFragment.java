package com.helw.m.ficzzreader.ui.book;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.helw.m.ficzzreader.R;
import com.helw.m.ficzzreader.base.BaseFragment;
import com.helw.m.ficzzreader.databinding.FragmentBookBinding;
import com.helw.m.ficzzreader.ui.book.child.BookCustomFragment;
import com.helw.m.ficzzreader.view.MyFragmentPagerAdapter;

import java.util.ArrayList;


/**
 * Created by user on 2017/12/12.
 */

public class BookFragment extends BaseFragment<FragmentBookBinding> {

    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showLoading();
        initFragmentList();
        /**
         * 注意使用的是：getChildFragmentManager，
         * 这样setOffscreenPageLimit()就可以添加上，保留相邻2个实例，切换时不会卡
         * 但会内存溢出，在显示时加载数据
         */
        MyFragmentPagerAdapter myAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mFragments, mTitleList);
        bindingView.vpBook.setAdapter(myAdapter);
        // 左右预加载页面的个数
        bindingView.vpBook.setOffscreenPageLimit(2);
        myAdapter.notifyDataSetChanged();
        bindingView.tabBook.setTabMode(TabLayout.MODE_FIXED);
        bindingView.tabBook.setupWithViewPager(bindingView.vpBook);
        showContentView();
    }

    @Override
    public int setContent() {
        return R.layout.fragment_book;
    }

    private void initFragmentList() {
        mTitleList.add("文学");
        mTitleList.add("文化");
        mTitleList.add("生活");
        mFragments.add(BookCustomFragment.newInstance("文学"));
        mFragments.add(BookCustomFragment.newInstance("文化"));
        mFragments.add(BookCustomFragment.newInstance("生活"));
    }
}
