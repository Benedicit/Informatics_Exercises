package HeadFirst_Java;

class SongV3 implements Comparable<SongV3> {

    private String title;
    private String artist;
    private int bpm;
    //Three instance variables tor the three song attributes in the file.
    public int compareTo(SongV3 s) {
        return title.compareTo(s.getTitle());
    }
    SongV3 (String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }
    public String getTitle() {
        return title;
    }
        //The getter methods for the three attributes.
        public String getArtist() {
            return artist;
        }
        public int getbpm() {
            return bpm;
        }
        public String tostring() {
            return title;
        }
        /*The variables are all set in the constructor whenever a new Song is created.
        We override toString), because when you do a System.out printIn(aSong Object), we want to see the title. When you do a System.out.
                printIn(aListOfSongs), it calls the toString()
        method of EACH element in the list.*/
    }