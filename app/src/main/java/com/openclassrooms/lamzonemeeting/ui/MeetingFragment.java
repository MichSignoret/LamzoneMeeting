package com.openclassrooms.lamzonemeeting.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.lamzonemeeting.R;
import com.openclassrooms.lamzonemeeting.di.DI;
import com.openclassrooms.lamzonemeeting.events.DeleteMeetingEvent;
import com.openclassrooms.lamzonemeeting.model.Meeting;
import com.openclassrooms.lamzonemeeting.service.MeetingApiService;
import com.openclassrooms.lamzonemeeting.ui.placeholder.PlaceholderContent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class MeetingFragment extends Fragment {

    private MeetingApiService mApiService;
    private List<Meeting> mMeetingList;
    private RecyclerView mRecyclerView;


    public static MeetingFragment newInstance() {
        MeetingFragment fragment = new MeetingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getMeetingApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_list, container, false);

        // Set the adapter
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        return view;
    }

    private void initList(){

        mMeetingList = mApiService.getMeetings();
        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(mMeetingList,this.getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event) {

        mApiService.deleteMeeting(event.meeting);
        initList();
    }
}