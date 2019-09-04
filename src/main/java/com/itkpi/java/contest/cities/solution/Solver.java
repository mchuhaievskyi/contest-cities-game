package com.itkpi.java.contest.cities.solution;

import java.util.Arrays;
import java.util.List;

public class Solver
{
    /**
     * This method should order cities names (strings) from allCitiesList argument
     * into longest chain possible following the rules of the "Cities game".
     *
     * <br><br>
     *
     * <b> Cities game rules: </b>
     * <li> Cities names should be ordered to the chain in which every next city name starting with the last letter of the previous city name. </li>
     * <li> The first city name can be any. </li>
     * <li> Each city name should be real. </li>
     * <li> All city names in the chain should be unique. </li>
     *
     * <br>
     *
     * <b>Example:</b> London, Naga, Aurora, Aswan
     */
    public List<String> solveCitiesGame(List<String> allCitiesList)
    {
        return Arrays.asList("Azua", "Azamgarh");
    }
}
