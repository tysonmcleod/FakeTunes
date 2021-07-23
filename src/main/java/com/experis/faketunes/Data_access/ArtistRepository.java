package com.experis.faketunes.Data_access;

import com.experis.faketunes.Models.Artist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class ArtistRepository {
    // set up connection
    private String URL = CONNECTION_URL;
    private Connection conn = null;



    // #1
    // get x artists from the database
    public ArrayList<Artist> getRandomArtists(int numberOfArtists){
        ArrayList<Artist> artists = new ArrayList<>();

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT ArtistId, Name FROM Artist ORDER BY RANDOM() LIMIT ? ");
                    preparedStatement.setInt(1, numberOfArtists);
            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                artists.add(
                        new Artist(
                                set.getString("ArtistId"),
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
        return artists;
    }
}
