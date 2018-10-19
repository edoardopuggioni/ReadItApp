package com.example.android.readitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapterAvailableQuizzes extends ArrayAdapter
{
    // Note that we are using a list of books to display the list of available quizzes, because
    // we need to display the title of the book corresponding to the quiz. Then from the book
    // object we can retrieve the quiz.

    public CustomArrayAdapterAvailableQuizzes(Context context, ArrayList<Book> quizzes)
    {
        super( context, 0, quizzes );
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent )
    {
        // Get the data item for this position.
        Book book = (Book) getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.available_quizzes_custom_list_item, parent, false);

        // Lookup view to catch layout elements.
        TextView title = (TextView) convertView.findViewById(R.id.available_quizzes_item_title);

        // Populate the data into the template view using the data object.
        title.setText(book.getTitle());

        // Return the completed view to render on screen
        return convertView;
    }
}
