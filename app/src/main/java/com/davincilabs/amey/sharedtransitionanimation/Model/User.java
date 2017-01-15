package com.davincilabs.amey.sharedtransitionanimation.Model;

import java.io.Serializable;

/**
 * Created by Amey on 1/14/17.
 */
public class User implements Serializable
{
    public String firstName;
    public String listingURL;
    public String detailsURL;

    public User(String firstName, String listingURL, String detailsURL) {
        this.firstName = firstName;
        this.listingURL = listingURL;
        this.detailsURL = detailsURL;
    }
}
