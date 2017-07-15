package com.pcfa.thisorthat.database.model;


import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Dpswtf on 09/07/2017.
 *
 * This class holds the User model
 */

@IgnoreExtraProperties
public class User {

    public String username;
    public String email;
    public String password;
    public String profilePicUrl;
    public int gender;
    public String description;

    public User() {}

    public User(String username, String email, String password, String profilePicUrl, int gender, String description) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePicUrl = profilePicUrl;
        this.gender = gender;
        this.description = description;
    }


}