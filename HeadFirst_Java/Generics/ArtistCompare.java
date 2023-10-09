package HeadFirst_Java.Generics;
import java.util.*;
public class ArtistCompare implements Comparator<Song>{
    public int compare(Song one, Song two) {
        return one.getArtist().compareTo((two.getArtist()));
    }
}
