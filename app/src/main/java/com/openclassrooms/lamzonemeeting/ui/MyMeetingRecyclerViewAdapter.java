package com.openclassrooms.lamzonemeeting.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.openclassrooms.lamzonemeeting.events.DeleteMeetingEvent;
import com.openclassrooms.lamzonemeeting.model.Meeting;
import com.openclassrooms.lamzonemeeting.ui.placeholder.PlaceholderContent.PlaceholderItem;

import com.openclassrooms.lamzonemeeting.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetingList;
    private Context mContext;

    public MyMeetingRecyclerViewAdapter(List<Meeting> items, Context context) {
        mMeetingList = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetingList.get(position);

  //      holder.mListNumber.setText(position);
        holder.mMeetingName.setText(meeting.getmName()+" - " +meeting.returnStartingHour()
                +" - " +meeting.getmPlace());

        holder.mMeetingTeamMate.setText(meeting.getTeamMates());
        holder.mMeetingTeamMate.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });
    }



    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_list_name)
        public TextView mMeetingName;
        @BindView(R.id.teamMate)
        public TextView mMeetingTeamMate;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}