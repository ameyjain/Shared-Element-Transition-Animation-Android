package com.davincilabs.amey.sharedtransitionanimation.viewHolder;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.davincilabs.amey.sharedtransitionanimation.Activities.DetailsActivity;
import com.davincilabs.amey.sharedtransitionanimation.Model.User;
import com.davincilabs.amey.sharedtransitionanimation.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Amey on 1/15/17.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView profileImageView;
    TextView nameTextView;

    public ItemViewHolder(final View itemView) {
        super(itemView);
        profileImageView = (ImageView) itemView.findViewById(R.id.profile_image_view);
        nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
    }

    public void load(final User user) {
        Picasso.with(itemView.getContext())
                .load(user.detailsURL)
                .placeholder(R.drawable.ic_user)
                .into(profileImageView);
        nameTextView.setText(user.firstName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                intent.putExtra("USER", user);

                Pair<View, String> p1 = Pair.create((View) profileImageView, "profile");
                Pair<View, String> p2 = Pair.create((View) nameTextView, "text");

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) itemView.getContext(), p1, p2);

                itemView.getContext().startActivity(intent, options.toBundle());
            }
        });
    }
}
