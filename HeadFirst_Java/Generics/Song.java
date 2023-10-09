package HeadFirst_Java.Generics;

class Song implements Comparable<Song> {

    private final String title;
    private final String artist;
    private final String genre;
    private final int year;


    private final int timesPlayed;

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }
    Song(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timesPlayed = timesPlayed;
    }
    public String getTitle() {
        return title;
    }
        //The getter methods for the three attributes.
        public String getArtist() {
            return artist;
        }
        public String getGenre() {
            return genre;
        }

        public int getYear() {return year;}

        public int getTimesPlayed() {return timesPlayed;}
        public String toString() {
        return title + ", " + artist + ", " + genre + "\n";
        }

    }