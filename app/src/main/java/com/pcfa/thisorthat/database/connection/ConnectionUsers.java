package com.pcfa.thisorthat.database.connection;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pcfa.thisorthat.database.model.User;

import java.util.ArrayList;

/**
 * Created by paulachen on 15/07/2017.
 */

public class ConnectionUsers {

        public ConnectionUsers () {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Users");

            ArrayList<User> userList = new ArrayList<>();
            User paula = new User("aluapchen28", "aluap@gmail.com", "opaula", "dontcare", 5, "Ola eu sou a paula.");
            userList.add(paula);
            myRef.setValue(userList);

        }
}
