package com.vogella.android.retrofitstackoverflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by Sifat on 2/6/2016.
 */
public class MyListAdapter extends BaseAdapter {

    Context mContext;
    private LayoutInflater mLayoutInflater;
    ArrayList<Question> stackoverflowQuestions;

    public MyListAdapter(final Context context, ArrayList<Question> q) {
        this.mContext = context;
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.stackoverflowQuestions = q;
    }


    @Override
    public int getCount() {
        return stackoverflowQuestions.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout itemView;
        if (convertView == null){
            itemView = (RelativeLayout) mLayoutInflater.inflate(
                    R.layout.list_item_s, parent, false);

        } else {
            itemView = (RelativeLayout) convertView;
        }

        SimpleDraweeView avatarView = (SimpleDraweeView)itemView.findViewById(R.id.profile_image);
        FSLightTextView questionView = (FSLightTextView)itemView.findViewById(R.id.question);
        FSBoldTextView dateView = (FSBoldTextView)itemView.findViewById(R.id.date);

//        avatarView.setImageURI(Uri.parse(stackoverflowQuestions.get(position).profile_image));
//        questionView.setText(stackoverflowQuestions.get(position).title);
//        dateView.setText(stackoverflowQuestions.get(position).creation_date);

        return itemView;
    }
}
