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

    public Batsmen() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Batsmen.count = count;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRuns() {
        return runs;
    }

    public void setRuns(Long runs) {
        this.runs = runs;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
