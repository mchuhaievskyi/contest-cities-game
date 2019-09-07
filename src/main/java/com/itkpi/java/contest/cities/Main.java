package com.itkpi.java.contest.cities;

import java.util.List;

import com.itkpi.java.contest.cities.solution.Solver;
import com.itkpi.java.contest.cities.solution.SolutionValidator;
import com.itkpi.java.contest.cities.utils.IOUtils;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        final List<String> inputCitiesList = IOUtils.readCitiesList();

        SolutionValidator.initTimeout();

        final List<String> solution;
        try
        {
            solution = new Solver().solveCitiesGame(inputCitiesList);
        }
        catch (Exception ex)
        {
            System.out.println("Your solution doesn't work =(");
            ex.printStackTrace();
            System.exit(1);
            return;
        }

        SolutionValidator.stopTimeout();

        if (SolutionValidator.isSolutionValid(inputCitiesList, solution))
        {
            final int score = SolutionValidator.evaluateSolution(solution);
            System.out.println("Your score is " + score);
        }
        else
        {
            System.out.println("The solution is not valid");
        }
    }
}
