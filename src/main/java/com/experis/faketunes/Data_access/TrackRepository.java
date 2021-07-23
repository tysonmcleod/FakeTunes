package com.experis.faketunes.Data_access;

import com.experis.faketunes.Models.Artist;
import com.experis.faketunes.Models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class TrackRepository {
    //Set up connection
    private String URL = CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Track> getAllTrack() {
        ArrayList<Track> Track = new ArrayList<>();

        try {
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("SELECT trackId, name FROM Track");
            ResultSet set = prep.executeQuery();

            while (set.next()) {
                Track.add(new Track(
                        set.getString("trackId"),
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

        return Track;
    }

    public Boolean addTrack(Track track) {
        Boolean success = false;
        try {
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("INSERT INTO Track(trackId, name)" +
                            " VALUES(?,?,?,?)");
            prep.setString(1, track.getTrackID());
            prep.setString(2, track.getName());


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

    public Track getSpecificTrack(String name) {
        Track specificTracks = null;

        try {
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT trackId, name FROM Track WHERE name LIKE ?");
            preparedStatement.setString(1, name);
            ResultSet set = preparedStatement.executeQuery();

            while (set.next()) {
               specificTracks  = new Track(
                        set.getString("trackId"),
                        set.getString("name")
                );
            }
        }
        catch (Exception exception) {
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }


        return specificTracks;
    }

}

