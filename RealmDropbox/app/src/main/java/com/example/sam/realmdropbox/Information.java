package com.example.sam.realmdropbox;

import io.realm.RealmObject;

/**
 * Created by Sam on 2/21/2015.
 */
public class Information extends RealmObject {
      private String Name;
      private String Message;
      private int Age;

    public String getName(){
      return Name;
    }

    public void setName(String Name){
      this.Name = Name;
    }

    public String getMessage(){
        return Message;
    }

    public void setMessage(String Message){
        this.Message = Message;
    }

    public int getAge(){
        return Age;
    }

    public void setAge(int Age){
        this.Age = Age;
    }

}
