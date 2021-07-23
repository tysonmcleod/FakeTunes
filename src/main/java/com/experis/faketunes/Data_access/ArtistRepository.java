package com.experis.faketunes.Data_access;

import com.experis.faketunes.Models.Artist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class ArtistRepository {

    //Set up connection
    private String URL = CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Artist> getAllAlbum() {
        ArrayList<Artist> Artist = new ArrayList<>();

        try {
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("SELECT name, artistId FROM Artist");
            ResultSet set = prep.executeQuery();

            while (set.next()) {
                Artist.add(new Artist(
                        set.getString("name"),
                        set.getInt("artistId")
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

        return Artist;
    }
    public Boolean addArtist(Artist artist) {
        Boolean success = false;
        try {
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("INSERT INTO Artist(name, artistId)" +
                            " VALUES(?,?,?,?)");
            prep.setString(1, artist.getName());
            prep.setInt(2, artist.getArtistId());


            int result = prep.executeUpdate();
            success = (result != 0); // if res = 1; true

            System.out.println("Add went well!");

        } catch (Exception exception) {
            System.out.println(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
        // ---
        return success;

    }
}
