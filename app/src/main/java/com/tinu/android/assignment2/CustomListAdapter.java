package com.tinu.android.assignment2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tinu on 05-05-2016.
 */
public class CustomListAdapter extends BaseAdapter {

    private final Activity context;
    private List<ListItems> itemListData;
    private LayoutInflater layoutInflator;
    private ViewHolder holder;

    public CustomListAdapter(Activity context, List<ListItems> itemList) {
        super();
        itemListData = itemList;
        this.context = context;
        layoutInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return itemListData.size();
    }

    @Override
    public ListItems getItem(int position) {

        return itemListData.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ListItems item = getItem(position);
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = layoutInflator.inflate(R.layout.list_items, null);
            holder.list_image = (ImageView) convertView.findViewById(R.id.image);
            holder.text_title = (TextView) convertView.findViewById(R.id.text_title);
            holder.text_date = (TextView) convertView.findViewById(R.id.text_date);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        //Get the data from the list and set the data.
        ListItems ListData = itemListData.get(position);

        //Create the bitmap of image.
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), ListData.getImage());

        //Reduce the size of the image.
        Bitmap resized_bitmap=Bitmap.createScaledBitmap(bitmap, 84, 84, true);

        holder.list_image.setImageBitmap(resized_bitmap);
        holder.text_title.setText(ListData.getTitle());
        holder.text_date.setText(ListData.getDate_and_time());

        return convertView;

    }

    public static class ViewHolder {

        ImageView list_image;
        TextView text_title;
        TextView text_date;

    }
}
