package in.silive.hackerearthgyanmatrix.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akriti on 11/3/17.
 */

public class BatsmenList {
    public static ArrayList<String> names_of_players;
    public static ArrayList<String> desc_of_players;
    public static ArrayList<Integer> img_of_players;
    public static ArrayList<String> country_of_players;
    public static ArrayList<Long> runs_of_players;
    public static ArrayList<Integer> matches_of_players;


    public BatsmenList(ArrayList<String> country_of_players, ArrayList<String> desc_of_players, ArrayList<Integer> img_of_players, ArrayList<Integer> matches_of_players, ArrayList<String> names_of_players, ArrayList<Long> runs_of_players) {
        this.country_of_players = country_of_players;
        this.desc_of_players = desc_of_players;
        this.img_of_players = img_of_players;
        this.matches_of_players = matches_of_players;
        this.names_of_players = names_of_players;
        this.runs_of_players = runs_of_players;
    }

    public static List<Batsmen> getBatsmenList(Context context){
        List blist  = new ArrayList<Batsmen>();
        for(int i=0;i<names_of_players.size();i++){
            blist.add(buildBatsmenInfo(names_of_players.get(i),desc_of_players.get(i),country_of_players.get(i),img_of_players.get(i),runs_of_players.get(i),matches_of_players.get(i)));
        }
        return blist;
    }
    private static Batsmen buildBatsmenInfo(String name, String des, String contry, Integer imag, Long runs, Integer match) {

        Batsmen batsmen = new Batsmen();
        batsmen.setId(Batsmen.getCount());
        Batsmen.incCount();
        String bname, bdesc, bcountry;
        try {
            bname = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            bdesc = new String(des.getBytes("ISO-8859-1"), "UTF-8");
            bcountry = new String(contry.getBytes("ISO-8859-1"), "UTF-8");
            batsmen.setName(bname);
            batsmen.setDescription(bdesc);
            batsmen.setCountry(bcountry);
        } catch (Exception e) {

        }
        batsmen.setMatches(match);
        batsmen.setRuns(runs);
        return batsmen;

    }
}
