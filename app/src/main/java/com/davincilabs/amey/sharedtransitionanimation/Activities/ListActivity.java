package com.davincilabs.amey.sharedtransitionanimation.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.davincilabs.amey.sharedtransitionanimation.Model.User;
import com.davincilabs.amey.sharedtransitionanimation.R;
import com.davincilabs.amey.sharedtransitionanimation.adapters.ItemListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView itemList;
    ItemListAdapter listAdapter;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        itemList = (RecyclerView) findViewById(R.id.item_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listAdapter = new ItemListAdapter();
        itemList.setLayoutManager(layoutManager);
        itemList.setAdapter(listAdapter);
        fetchUserData();
    }

    private void fetchUserData() {
        users = new ArrayList<>();
        listAdapter.setData(users);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("users");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String name = jo_inside.getString("firstName");
                String listURL = jo_inside.getString("listingURL");
                String detailUrl = jo_inside.getString("detailUrl");

                users.add(new User(name, listURL, detailUrl));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = ListActivity.this.getAssets().open("users.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
