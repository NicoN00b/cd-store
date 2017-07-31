package disks;

/**
 * Created by Guest on 7/31/17.
 */
public class Compact {
    public String artist;
    public String album;
    public int release;
    public int price;

    public Compact (String artist, String album, int release, int price) {
        this.artist = artist;
        this.album = album;
        this.release = release;
        this.price = price;
    }

    public boolean worthBuying(int maxPrice){
        return (this.price < maxPrice);
    }

    public boolean releaseDate(int userReleaseDate){
        return (this.release == userReleaseDate);
    }

    public boolean rightArtist(String userArtist){
        return(this.artist.equals(userArtist));
    }
}
