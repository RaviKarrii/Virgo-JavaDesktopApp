package com.allGUI;

import javax.swing.*;

import sun.tools.jconsole.JConsole;
import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;

public class Chart {
    public JPanel Main;
    int[] planets = { SweConst.SE_SUN,
            SweConst.SE_MOON,
            SweConst.SE_MARS,
            SweConst.SE_MERCURY,
            SweConst.SE_JUPITER,
            SweConst.SE_VENUS,
            SweConst.SE_SATURN,
            SweConst.SE_MEAN_NODE };	// Some systems prefer SE_MEAN_NODE

    int flags = SweConst.SEFLG_SWIEPH |        // slow and least accurate calculation method
            SweConst.SEFLG_SIDEREAL |    // sidereal zodiac
            SweConst.SEFLG_SPEED;        // to determine retrograde vs. direct motion
    boolean retrograde = false;

    public String getPlanetPos(){

        return "";
    }

    public void start() {
        System.out.println("Ravi");
        for(int number: planets){
            System.out.println(number);
        }
        }
    }

