package HeadFirst_Java.Generics;

import java.util.*;
import java.util.stream.Collectors;

public class Jukebox3 {
    public static void main(String[] args) {

        List<Song> songs = new Songs().getSongs();
        List<Song> rockSongs = songs.stream()
                .filter(song -> song.getArtist().equals("The Beatles"))
                .collect(Collectors.toList());
        List<String> genres = songs.stream()
                .map(song -> song.getGenre())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(rockSongs);
        System.out.println(genres);

    }

}