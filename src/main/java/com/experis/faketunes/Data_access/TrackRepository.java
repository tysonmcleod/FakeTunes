package com.experis.faketunes.Data_access;
import com.experis.faketunes.Models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class TrackRepository {
    // set up connection
    private String URL = CONNECTION_URL;
    private Connection conn = null;



    // #1
    // get x tracks from the database
    public ArrayList<Track> getRandomTracks(int numberOfTracks){
        ArrayList<Track> tracks = new ArrayList<>();

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT TrackId, Name FROM Track ORDER BY RANDOM() LIMIT ? ");
            preparedStatement.setInt(1, numberOfTracks);
            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                tracks.add(
                        new Track(
                                set.getString("TrackId"),
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
        return tracks;
    }
}
