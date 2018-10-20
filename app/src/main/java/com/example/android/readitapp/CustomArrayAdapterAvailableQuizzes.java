package com.example.android.readitapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class CustomArrayAdapterAvailableQuizzes extends ArrayAdapter
{
    private Context context;
    // Note that we are using a list of books to display the list of available quizzes, because
    // we need to display the title of the book corresponding to the quiz. Then from the book
    // object we can retrieve the quiz.

    public CustomArrayAdapterAvailableQuizzes(Context context, ArrayList<Book> quizzes)
    {
        super( context, 0, quizzes );
        this.context = context;
    }

    @Override
    public View getView( final int position, View convertView, final ViewGroup parent )
    {
        // Get the data item for this position.
        Book book = (Book) getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.available_quizzes_custom_list_item, parent, false);

        // Lookup view to catch layout elements.
        Button button = (Button) convertView.findViewById(R.id.available_quizzes_item_button);

        // Populate the data into the template view using the data object.
        button.setText(book.getTitle());

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                // Passing the reference to the selected book (the user actually selected a quiz).
//                Intent intent = new Intent( getContext(), QuizStartActivity.class );
//                String message = String.valueOf(position);
//                intent.putExtra( EXTRA_MESSAGE, message );
//                getContext().startActivity(intent);

                ((ListView) parent).performItemClick(view, position, 0);

            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}
