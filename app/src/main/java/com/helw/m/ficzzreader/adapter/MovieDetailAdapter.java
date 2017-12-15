package com.helw.m.ficzzreader.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.helw.m.ficzzreader.R;
import com.helw.m.ficzzreader.base.baseadapter.BaseRecyclerViewAdapter;
import com.helw.m.ficzzreader.base.baseadapter.BaseRecyclerViewHolder;
import com.helw.m.ficzzreader.bean.moviechild.PersonBean;
import com.helw.m.ficzzreader.databinding.ItemMovieDetailPersonBinding;
import com.helw.m.ficzzreader.utils.PerfectClickListener;
import com.helw.m.ficzzreader.view.webview.WebViewActivity;


/**
 * Created by jingbin on 2016/12/10.
 */

public class MovieDetailAdapter extends BaseRecyclerViewAdapter<PersonBean> {
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_movie_detail_person);
    }

    private class ViewHolder extends BaseRecyclerViewHolder<PersonBean, ItemMovieDetailPersonBinding> {

        ViewHolder(ViewGroup parent, int layout) {
            super(parent, layout);
        }

        @Override
        public void onBindViewHolder(final PersonBean bean, int position) {
            binding.setPersonBean(bean);
            binding.llItem.setOnClickListener(new PerfectClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
                    if (bean != null && !TextUtils.isEmpty(bean.getAlt())) {
                        WebViewActivity.loadUrl(v.getContext(), bean.getAlt(), bean.getName());
                    }
                }
            });
        }
    }
}
