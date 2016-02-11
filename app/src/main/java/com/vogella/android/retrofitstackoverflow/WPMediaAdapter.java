package com.vogella.android.retrofitstackoverflow;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Sifat on 2/6/2016.
 */
public class WPMediaAdapter extends BaseAdapter {

    Context mContext;
    private LayoutInflater mLayoutInflater;
    List<WordpressMedia> wordpressMedias;

    public WPMediaAdapter(final Context context, List<WordpressMedia> wordpressMedias) {
        this.mContext = context;
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.wordpressMedias = wordpressMedias;
    }


    @Override
    public int getCount() {
        return wordpressMedias.size();
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
                    R.layout.list_item_wp, parent, false);

        } else {
            itemView = (RelativeLayout) convertView;
        }

        SimpleDraweeView bannerImageView = (SimpleDraweeView)itemView.findViewById(R.id.banner_image);
        FSLightTextView brandNameView = (FSLightTextView)itemView.findViewById(R.id.brand_name);
        FSBoldTextView tagsView = (FSBoldTextView)itemView.findViewById(R.id.tags);

        bannerImageView.setImageURI(Uri.parse(wordpressMedias.get(position).media_details.sizes.medium.source_url));
        brandNameView.setText(wordpressMedias.get(position).title.rendered);
        tagsView.setText(wordpressMedias.get(position).caption);
        return itemView;
    }
}
