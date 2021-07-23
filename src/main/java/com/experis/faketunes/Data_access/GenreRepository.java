package com.experis.faketunes.Data_access;

import com.experis.faketunes.Models.CustomerGenre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class GenreRepository {
    private String URL = CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<CustomerGenre> getallCustomerGenre() {
        ArrayList<CustomerGenre> CustomerGenre = new ArrayList<>();

        try {
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("SELECT genreName FROM CustomerGenre");
            ResultSet set = prep.executeQuery();

            while (set.next()) {
                CustomerGenre.add(new CustomerGenre(
                        set.getString("name")
                ));
            }


        } catch (Exception exception) {
            System.out.println(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }

        return CustomerGenre;
    }
    }

