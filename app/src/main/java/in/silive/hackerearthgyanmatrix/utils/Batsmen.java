package in.silive.hackerearthgyanmatrix.utils;

import java.io.Serializable;

/**
 * Created by akriti on 11/3/17.
 */

public class Batsmen implements Serializable {
    static final long serialVersionUID = 727566175075960653L;
    private static int count = 0;
    private int id;
    private String name;
    private String description;
    private String country;
    private Integer matches;
    private Long runs;




    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", matches='" + matches.toString() + '\'' +
                ", runs='" + runs.toString() + '\'' +
                '}';
    }
}
