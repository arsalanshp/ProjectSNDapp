package com.example.root.tebsoundapp1.Adaptors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.tebsoundapp1.Model.Sound;
import com.example.root.tebsoundapp1.R;

import java.util.List;

/**
 * Created by root on 9/6/16.
 */
public class BaseSoundAdapter extends RecyclerView.Adapter<BaseSoundAdapter.SoundViewHolder> {

    public List<Sound> soundsList;

    public BaseSoundAdapter(List<Sound> soundsList) {
        this.soundsList = soundsList;
    }


    public class SoundViewHolder extends RecyclerView.ViewHolder {
        public TextView soundName,soundDownload,soundSize,soundUrl;


        public SoundViewHolder(View view) {
            super(view);
            soundName = (TextView) view.findViewById(R.id.sount_name_txt);
            soundDownload = (TextView) view.findViewById(R.id.download_time_txt);
            soundSize = (TextView) view.findViewById(R.id.size_txt);
//            commentText = (TextView) view.findViewById(R.id.sount_name_txt);
//            commentDate = (TextView) view.findViewById(R.id.comment_date);
//            userName = (TextView) view.findViewById(R.id.user_name);
//            view.findViewById(R.id.user_avatar);
//            view.findViewById(R.id.comment_score);

        }
    }

    @Override
    public SoundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sound_list_row, parent, false);

        return new SoundViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SoundViewHolder holder, int position) {
        Sound sound = soundsList.get(position);
        holder.soundDownload.setText(sound.getDownload());
        holder.soundName.setError(sound.getName());
        holder.soundSize.setText(sound.getSize());

//        holder.commentText.setText(comment.getCommentText());
//        holder.commentDate.setText(comment.getDate());
//        holder.userName.setText(comment.getUserName());
    }

    @Override
    public int getItemCount() {
        return soundsList.size();
    }

}
