package nju.com.piece;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shen on 15/6/4.
 */
public class IconImageAdaptor extends ArrayAdapter<Item> {

    Context context;
    int layoutResourceId;
    List<Item> images = new ArrayList<Item>();


    public IconImageAdaptor(Context context, int resource, List<Item> images) {
        super(context, resource, images);
        this.context = context;
        this.layoutResourceId = resource;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout view = (LinearLayout)convertView;

        if (view == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = (LinearLayout)inflater.inflate(layoutResourceId, parent, false);
        }

        TagIconView icon = (TagIconView)view.findViewById(R.id.icon_img);

        Item currentItem = images.get(position);

        icon.setImages(currentItem.getResource(),currentItem.getSelected());
        icon.setImageResource(currentItem.getResource());

        return view;
    }
}
