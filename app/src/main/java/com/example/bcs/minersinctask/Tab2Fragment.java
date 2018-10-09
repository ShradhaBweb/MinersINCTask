package com.example.bcs.minersinctask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {

    private InfinitePlaceHolderView mLoadMoreView;

    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        mLoadMoreView = (InfinitePlaceHolderView)view.findViewById(R.id.loadMoreView);
        setupView();
        return view;
    }

    private void setupView(){

        List<InfiniteFeedInfo> feedList = Utils.loadInfiniteFeeds(this.getActivity());
        Log.d("DEBUG", "LoadMoreView.LOAD_VIEW_SET_COUNT " + LoadMoreView.LOAD_VIEW_SET_COUNT);
        for(int i = 0; i < LoadMoreView.LOAD_VIEW_SET_COUNT; i++){
            mLoadMoreView.addView(new ItemView(this.getActivity(), feedList.get(i)));
        }
        mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, feedList));
    }
}
