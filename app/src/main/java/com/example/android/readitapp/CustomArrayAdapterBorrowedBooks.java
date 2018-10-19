package com.example.android.readitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapterBorrowedBooks extends ArrayAdapter
{
    public CustomArrayAdapterBorrowedBooks(Context context, ArrayList<Book> books)
    {
        super(context, 0, books );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent )
    {
        // Get the data item for this position.
        Book book = (Book) getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.borrowed_books_custom_list_item, parent, false);
        // Lookup view to catch layout elements.
        TextView title = (TextView) convertView.findViewById(R.id.borrowed_books_item_title);

        // Populate the data into the template view using the data object.
        title.setText(book.getTitle());

        // Return the completed view to render on screen
        return convertView;
    }
}
