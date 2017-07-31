import disks.Compact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inventory {
    public static void main(String[] args) {
        Compact countryjoe = new Compact("Country Joe", "Dog Nap", 1994, 22);
        Compact urbankeith = new Compact("Urban Keith", "Actually, really country more than Urban", 1998, 35);
        Compact hippyhoppyYo = new Compact("HHY", "HippyHoppyYo Comes UP", 2006, 18);
        Compact acdc = new Compact("AC/DC", "Highway to Hell", 1980, 10);

        Compact[] allCompacts = {countryjoe, urbankeith, hippyhoppyYo, acdc};
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to the nostalgic CD Experience.  What would you like to do?  Enter one of the following options: See entire inventory(1) or search based on Artist(2), Album(3), release(4), or price(5)");

            try {

                String navigationChoice = bufferedReader.readLine();

                if (navigationChoice.equals("entire inventory")) {
                    for (Compact individualCompact : allCompacts) {
                        System.out.println("----------------------");
                        System.out.println(individualCompact.artist);
                        System.out.println(individualCompact.album);
                        System.out.println(individualCompact.release);
                        System.out.println(individualCompact.price);
                    }
                } else if (navigationChoice.equals("price")) {
                    System.out.println("What is your maximum budget for a CD?");
                    String stringUserMaxBudget = bufferedReader.readLine();
                    int userMaxBudget = Integer.parseInt(stringUserMaxBudget);
                    System.out.println("Alright, here's what we have in your price range:");
                    for (Compact individualCompact : allCompacts) {
                        if (individualCompact.worthBuying(userMaxBudget)) {
                            System.out.println("----------------------");
                            System.out.println(individualCompact.artist);
                            System.out.println(individualCompact.album);
                            System.out.println(individualCompact.release);
                            System.out.println(individualCompact.price);
                        }
                    }
                } else if (navigationChoice.equals("release")) {
                    System.out.println("What year was the album released?");
                    String stringUserReleaseDate = bufferedReader.readLine();
                    int userReleaseDate = Integer.parseInt(stringUserReleaseDate);
                    System.out.println("Alright, here's what we have from that year:");
                    for (Compact individualCompact : allCompacts) {
                        if (individualCompact.releaseDate(userReleaseDate)) {
                            System.out.println("----------------------");
                            System.out.println(individualCompact.artist);
                            System.out.println(individualCompact.album);
                            System.out.println(individualCompact.release);
                            System.out.println(individualCompact.price);
                        }
                    }
                } else if (navigationChoice.equals("Artist")) {
                    System.out.println("What artist are you looking for?");
                    String userArtist = bufferedReader.readLine();
                    System.out.println("Here are the albums by that artist:");
                    for (Compact individualCompact : allCompacts) {
                        if (individualCompact.rightArtist(userArtist)) {
                            System.out.println("----------------------");
                            System.out.println(individualCompact.artist);
                            System.out.println(individualCompact.album);
                            System.out.println(individualCompact.release);
                            System.out.println(individualCompact.price);
                        }
                    }
                } else {
                    System.out.println("I'm sorry, we don't recognize your input");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
