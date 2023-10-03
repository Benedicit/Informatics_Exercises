package HeadFirst_Java;
import java.util.*;

class MockSongs {

    public static List<SongV3> getSongsV3() {
        List<SongV3> songs = new ArrayList<>();
        songs.add(new SongV2("somersault", "zero 7", 147));
        songs.add(new SongV2("cassidy", "grateful dead", 158));
        songs.add(new SongV2("$10", "hitchhiker", 140));
        songs.add(new SongV2("havana", "cabello", 105));
        songs.add(new SongV2("Cassidy", "grateful dead", 158));
        songs.add(new SongV2("50 ways", "simon", 102));
        return songs;
        // We made a new method in the MockSongs class to mock the new song data.
    }
}
