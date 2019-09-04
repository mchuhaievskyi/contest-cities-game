package com.itkpi.java.contest.cities.solution;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SolutionValidator
{
    /**
     * For this task, the quality metric of the result is the length sum of all cities names.
     */
    public static int evaluateSolution(List<String> orderedCitiesList)
    {
        Objects.requireNonNull(orderedCitiesList, "orderedCitiesList argument can't be null");
        return orderedCitiesList.stream().mapToInt(String::length).sum();
    }

    public static boolean isSolutionValid(List<String> allCitiesList, List<String> orderedCitiesList)
    {
        Objects.requireNonNull(allCitiesList, "allCitiesList argument can't be null");
        Objects.requireNonNull(orderedCitiesList, "orderedCitiesList argument can't be null");

        if (orderedCitiesList.isEmpty())
        {
            return true;
        }

        if (!orderedCitiesList.parallelStream().allMatch(allCitiesList::contains))
        {
            System.out.println("Your solution contains invalid cities names");
            return false;
        }

        if (orderedCitiesList.size() != new HashSet<>(orderedCitiesList).size())
        {
            System.out.println("Your solution contains non unique cities names");
            return false;
        }

        final Iterator<String> solutionIterator = orderedCitiesList.iterator();

        String prevCity = orderedCitiesList.iterator().next().toLowerCase();
        String nextCity;
        while (solutionIterator.hasNext())
        {
            nextCity = solutionIterator.next().toLowerCase();

            if (nextCity.charAt(0) != prevCity.charAt(prevCity.length() - 1))
            {
                System.out.println("Each next city should starts with the last char of the previous city");
                return false;
            }

            prevCity = nextCity;
        }

        return true;
    }
}
