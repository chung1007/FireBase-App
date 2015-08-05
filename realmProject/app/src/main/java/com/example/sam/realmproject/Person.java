package com.example.sam.realmproject;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Sam on 1/22/2015.
 */
public class Person extends RealmObject {
    private String Name;
    private int Age;

    public String getName(){

        return Name;
    }
    
    public void setName(String Name){
        this.Name = Name;

    }
    public int getAge(){

        return Age;
    }

    public void setAge(int Age){

        this.Age = Age;
    }

}
