package com.itkpi.java.contest.cities.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.itkpi.java.contest.cities.utils.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionValidatorTest
{
    @Test
    void evaluateSolution_Empty()
    {
        final int expectedScore = 0;

        final int actualScore = SolutionValidator.evaluateSolution(Collections.emptyList());

        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    void evaluateSolution_Singleton()
    {
        final String city1 = "Astrakhan";
        final int expectedScore = city1.length();

        final List<String> singletonList = Collections.singletonList(city1);

        final int actualScore = SolutionValidator.evaluateSolution(singletonList);

        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    void evaluateSolution_MultipleEntries()
    {
        final String city1 = "Aurora";
        final String city2 = "Astrakhan";
        final int expectedScore = city1.length() + city2.length();

        final List<String> cityList = Arrays.asList(city1, city2);

        final int actualScore = SolutionValidator.evaluateSolution(cityList);

        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    void isSolutionValid_Empty() throws Exception
    {
        final List<String> solution = Collections.emptyList();

        final List<String> citiesList = IOUtils.readCitiesList();

        boolean solutionValid = SolutionValidator.isSolutionValid(citiesList, solution);

        Assertions.assertTrue(solutionValid);
    }

    @Test
    void isSolutionValid_Singleton() throws Exception
    {
        final String city1 = "Astrakhan";

        final List<String> solution = Collections.singletonList(city1);

        final List<String> citiesList = IOUtils.readCitiesList();

        boolean solutionValid = SolutionValidator.isSolutionValid(citiesList, solution);

        Assertions.assertTrue(solutionValid);
    }

    @Test
    void isSolutionValid_MultipleEntries() throws Exception
    {
        final String city1 = "Aurora";
        final String city2 = "Astrakhan";

        final List<String> solution = Arrays.asList(city1, city2);

        final List<String> citiesList = IOUtils.readCitiesList();

        boolean solutionValid = SolutionValidator.isSolutionValid(citiesList, solution);

        Assertions.assertTrue(solutionValid);
    }

    @Test
    void isSolutionValid_InvalidCity() throws Exception
    {
        final String city1 = "Kek";

        final List<String> solution = Collections.singletonList(city1);

        final List<String> citiesList = IOUtils.readCitiesList();

        boolean solutionValid = SolutionValidator.isSolutionValid(citiesList, solution);

        Assertions.assertFalse(solutionValid);
    }

    @Test
    void isSolutionValid_NonUnique() throws Exception
    {
        final String city1 = "Aurora";
        final String city2 = "Aurora";

        final List<String> solution = Arrays.asList(city1, city2);

        final List<String> citiesList = IOUtils.readCitiesList();

        boolean solutionValid = SolutionValidator.isSolutionValid(citiesList, solution);

        Assertions.assertFalse(solutionValid);
    }

    @Test
    void isSolutionValid_InvalidOrder() throws Exception
    {
        final String city1 = "Astrakhan";
        final String city2 = "Aurora";

        final List<String> solution = Arrays.asList(city1, city2);

        final List<String> citiesList = IOUtils.readCitiesList();

        boolean solutionValid = SolutionValidator.isSolutionValid(citiesList, solution);

        Assertions.assertFalse(solutionValid);
    }
}