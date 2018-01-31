package com.example.hello.airindia;

/**
 * Created by hp on 7/11/2017.
 */

public class users {



        public int id;
        public String email,password,contact,country;

        public void setAll(int id, String email, String password,String contact,String country) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.contact= contact;
            this.country= country;
        }
}
