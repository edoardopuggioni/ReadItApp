package com.example.android.readitapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter {


    public CustomArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
