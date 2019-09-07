package com.itkpi.java.contest.cities.solution;

import java.util.*;
import java.util.stream.Collectors;

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
     *
     * <br><br>
     *
     * <b>Additional requirements:</b>
     * Time limit is 2 minutes
     */
    public List<String> solveCitiesGame(List<String> allCitiesList)
    {
        TreeMap<Integer, List<String>> solutionMap = new TreeMap<>(Integer::compareTo);

        for (char c = 'a'; c <= 'z'; c++)
        {
            final List<String> solution = buildSolution(String.valueOf(c), allCitiesList);
            solutionMap.put(evaluateSolution(solution), solution);
        }

        // System.out.println("solutions = " + solutionMap.keySet());

        final List<String> bestSolution = solutionMap.lastEntry().getValue();

        // System.out.println("best solution = " + evaluateSolution(bestSolution));

        return bestSolution;
    }

    private static Integer evaluateSolution(List<String> solutionList)
    {
        return solutionList.stream().mapToInt(String::length).sum();
    }

    private static List<String> buildSolution(String firstLetter, List<String> availableCities)
    {
        final Map<Character, List<String>> citiesMap = availableCities
                .stream()
                .collect(Collectors.groupingBy(s -> s.toLowerCase().charAt(0)));

        final List<String> solutionList = new LinkedList<>();

        String currentCity = findNextCity(firstLetter, citiesMap);
        solutionList.add(currentCity);

        String nextCity;
        while (true)
        {
            nextCity = findNextCity(currentCity, citiesMap);

            if (nextCity == null)
            {
                break;
            }

            solutionList.add(nextCity);
            currentCity = nextCity;
        }

        return solutionList;
    }

    private static String findNextCity(String currentCity, Map<Character, List<String>> citiesMap)
    {
        // System.out.println("currentCity = " + currentCity);

        final char lastChar = getLastChar(currentCity);

        // System.out.println("lastChar = " + lastChar);

        final List<String> matchedCities = citiesMap.get(lastChar);

        // System.out.println("matchedCities = " + matchedCities);

        if (matchedCities.isEmpty())
        {
            return null;
        }

        final String nextCity = takeOptimalCity(matchedCities, citiesMap);

        // System.out.println("nextCity = " + nextCity);

        matchedCities.remove(nextCity);

        return nextCity;
    }

    private static String takeOptimalCity(List<String> matchedCities, Map<Character, List<String>> citiesMap)
    {
        TreeMap<Integer, String> matchedCitiesMap = new TreeMap<>(Integer::compareTo);

        for (String matchedCity : matchedCities)
        {
            char matchedCityLastChar = getLastChar(matchedCity);
            int matchedCityScore = citiesMap.get(matchedCityLastChar).size();
            matchedCitiesMap.put(matchedCityScore, matchedCity);
        }

        return matchedCitiesMap.lastEntry().getValue();
    }

    private static char getLastChar(String city)
    {
        return city.charAt(city.length() - 1);
    }
}
