/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abidjan.experiment;

/**
 *
 * @author gnana
 */
public class User {

      private int id;

      private String  first_name;
      private String  last_name;
      private String  email;      

     
    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "User [Prénom=" + first_name + ", Nom=" + last_name + ", Email=" + email
                + "]";
    }




}
