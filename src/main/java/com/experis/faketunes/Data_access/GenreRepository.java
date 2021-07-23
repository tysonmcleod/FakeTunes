package com.experis.faketunes.Data_access;
import com.experis.faketunes.Models.Genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class GenreRepository {
    // set up connection
    private String URL = CONNECTION_URL;
    private Connection conn = null;



    // #1
    // get x genres from the database
    public ArrayList<Genre> getRandomGenres(int numberOfGenres){
        ArrayList<Genre> genres = new ArrayList<>();

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT GenreId, Name FROM Genre ORDER BY RANDOM() LIMIT ? ");
            preparedStatement.setInt(1, numberOfGenres);
            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                genres.add(
                        new Genre(
                                set.getString("GenreId"),
                                set.getString("Name")
                        ));

            }
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally{
            try{
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return genres;
    }
}
