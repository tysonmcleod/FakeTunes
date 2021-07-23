package com.experis.faketunes.Data_access;

import com.experis.faketunes.Models.Genre;
import com.experis.faketunes.Models.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.experis.faketunes.Data_access.ConnectionHelper.CONNECTION_URL;

public class SearchRepository {

    // set up connection
    private String URL = CONNECTION_URL;
    private Connection conn = null;



    // #1
    // get x genres from the database
    public ArrayList<Search> search(String searchString){
        ArrayList<Search> searchResult = new ArrayList<>();

        try{
            // try and connect
            conn = DriverManager.getConnection(URL);

            // make sql query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Track.Name AS TrackName, Artist.Name AS ArtistName, Album.Title AS AlbumName, Genre.Name AS GenreName FROM" +
                            " Track INNER JOIN Album ON Track.AlbumId = Album.AlbumId" +
                            " INNER JOIN Artist ON Album.ArtistId = Artist.ArtistId" +
                            " INNER JOIN Genre ON Track.GenreId = Genre.GenreId" +
                            " WHERE Track.Name LIKE ? OR Artist.Name LIKE ? OR Album.Title LIKE ? OR Genre.Name Like ?");

            preparedStatement.setString(1, searchString);
            // execute query
            ResultSet set = preparedStatement.executeQuery();

            while(set.next()){
                searchResult.add(
                        new Search(
                                set.getString("TrackName"),
                                set.getString("ArtistName"),
                                set.getString("AlbumName"),
                                set.getString("GenreName")
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
        return searchResult;
    }


}
