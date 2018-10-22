package com.example.android.readitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomArrayAdapterOtherBadges extends ArrayAdapter
{
    private Context context;

    public CustomArrayAdapterOtherBadges(Context context, ArrayList<Badge> badges)
    {
        super( context, 0, badges );
        this.context = context;
    }

    public View getView(final int position, View convertView, final ViewGroup parent )
    {
        // Get the data item for this position.
        Badge badge = (Badge) getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.other_badges_custom_list_item, parent, false);

        // Lookup view to catch layout elements.
        ImageView imageViewBadge = (ImageView) convertView.findViewById(R.id.other_badges_imageView);

        // Populate the data into the template view using the data object.
        imageViewBadge.setImageResource( badge.getIcon() );

        // Return the completed view to render on screen
        return convertView;
    }
}
