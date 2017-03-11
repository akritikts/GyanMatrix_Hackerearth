package in.silive.hackerearthgyanmatrix.utils;

import java.util.ArrayList;

/**
 * Created by akriti on 11/3/17.
 */

public class BatsmenList {
    private ArrayList<String> names_of_players;
    private ArrayList<String> desc_of_players;
    private ArrayList<Integer> img_of_players;
    private ArrayList<String> country_of_players;
    private ArrayList<Long> runs_of_players;
    private ArrayList<Integer> matches_of_players;

    public BatsmenList(ArrayList<String> country_of_players, ArrayList<String> desc_of_players, ArrayList<Integer> img_of_players, ArrayList<Integer> matches_of_players, ArrayList<String> names_of_players, ArrayList<Long> runs_of_players) {
        this.country_of_players = country_of_players;
        this.desc_of_players = desc_of_players;
        this.img_of_players = img_of_players;
        this.matches_of_players = matches_of_players;
        this.names_of_players = names_of_players;
        this.runs_of_players = runs_of_players;
    }

}
