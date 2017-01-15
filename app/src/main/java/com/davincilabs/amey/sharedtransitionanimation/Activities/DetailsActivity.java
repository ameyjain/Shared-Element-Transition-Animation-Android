package com.davincilabs.amey.sharedtransitionanimation.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.davincilabs.amey.sharedtransitionanimation.Model.User;
import com.davincilabs.amey.sharedtransitionanimation.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends Activity {

    User user;
    TextView nameTextView;
    ImageView profilePictureImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        user = (User) getIntent().getExtras().getSerializable("USER");

        nameTextView = (TextView) findViewById(R.id.name_text_view);
        profilePictureImageView = (ImageView) findViewById(R.id.profile_image_view);

        nameTextView.setText(user.firstName);
        Picasso.with(this)
                .load(user.detailsURL)
                .into(profilePictureImageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
