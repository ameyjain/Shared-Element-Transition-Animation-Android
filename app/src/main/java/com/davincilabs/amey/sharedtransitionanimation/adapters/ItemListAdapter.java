package com.davincilabs.amey.sharedtransitionanimation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davincilabs.amey.sharedtransitionanimation.viewHolder.ItemViewHolder;
import com.davincilabs.amey.sharedtransitionanimation.Model.User;
import com.davincilabs.amey.sharedtransitionanimation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amey on 1/14/17.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<User> users;

    //==============================================================================================
    // Instance Methods
    //==============================================================================================

    public void setData(List<User> users) {
        this.users = new ArrayList<>();
        this.users = users;
        notifyDataSetChanged();
    }

    //==============================================================================================
    // Adapter Implementation
    //==============================================================================================

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.load(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

}
