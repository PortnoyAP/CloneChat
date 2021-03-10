package com.example.clonechat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {

    public MessageAdapter(Context context, int resource, List<Message>messages) {
        super(context, resource,messages);
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        if(convertView == null) {
            convertView = ((Activity)getContext()).getLayoutInflater()
                    .inflate(R.layout.message_item, parent,false);
        }

        ImageView photoImageView = convertView.findViewById(R.id.photoImageView);
        TextView  textView = convertView.findViewById(R.id.textView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);

        Message message = getItem(position);


        boolean isText = message.getImageUrl() == null;

        if(isText) {
            textView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            textView.setText(message.getText());
        }else {
            textView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            textView.setText(message.getText());
        }

        return super.getView(position, convertView, parent);
    }
}
