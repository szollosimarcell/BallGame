/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseclasses;

/**
 *
 * @author Marci
 */
public class Player {

    private final String name;
    private int points;
    private int time;

    public Player(String nev) {
        this.name = nev;
    }

    /**
     * A játékos pontot kap
     */
    public void earnPoint() {
        points++;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + ": " + points + ", " + time + " másodperc";
    }

}
