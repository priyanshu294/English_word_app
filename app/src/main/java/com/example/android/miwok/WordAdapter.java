package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;


    public WordAdapter(Context context, ArrayList<Word> words,int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;

    }


   @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word curAdapter = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_View);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultTextView.setText(curAdapter.getDefaultTranslation());

       ImageView imageview = (ImageView) listItemView.findViewById(R.id.image);

       // Check if an image is provided for this word or not
       if (curAdapter.hasImage()) {
           // If an image is available, display the provided image based on the resource ID
           imageview.setImageResource(curAdapter.getImageResourceId());
           // Make sure the view is visible
           imageview.setVisibility(View.VISIBLE);
       } else {
           // Otherwise hide the ImageView (set visibility to GONE)
           imageview.setVisibility(View.GONE);
       }
       // Set the theme color for the list item
       View textContainer = listItemView.findViewById(R.id.text_container);
       // Find the color that the resource ID maps to
       int color = ContextCompat.getColor(getContext(), mColorResourceId);
       // Set the background color of the text container View
       textContainer.setBackgroundColor(color);

       // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
       // the ListView.

        return listItemView;
    }
}
