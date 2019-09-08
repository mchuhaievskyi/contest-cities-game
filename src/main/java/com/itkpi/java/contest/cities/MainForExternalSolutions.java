package com.itkpi.java.contest.cities;

import com.itkpi.java.contest.cities.solution.SolutionValidator;
import com.itkpi.java.contest.cities.utils.IOUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainForExternalSolutions
{
    private static final String INPUT_FILE_PATH = "./input-cities-list.txt";
    private static final String OUTPUT_FILE_PATH = "./output.txt";

    /**
     * Requirements for external solutions are next:
     * <li>Be runnable at windows (sorry, I don't have linux env right now)</li>
     * <li>Accepts 2 command line params: input file path and output file path</li>
     * <li>Writes the solution* to the file which path was passed as a second argument</li>
     * <br/>
     * <p>* cities chain in the same format as in input file</p>
     */
    public static void main(String[] args) throws Exception
    {
        if (args.length == 0)
        {
            System.out.println("Please pass the command which should run your solution");
            System.exit(0);
        }

        final String externalSolverRunCommand = args[0];

        final List<String> solution;
        try
        {
            final String commandWithArgs = externalSolverRunCommand + " " + INPUT_FILE_PATH + " " + OUTPUT_FILE_PATH;

            SolutionValidator.initTimeout();
            int exitCode = Runtime.getRuntime().exec(commandWithArgs).waitFor();
            System.out.println("External solver finished with exitcode = " + exitCode);
            SolutionValidator.stopTimeout();

            solution = Files.readAllLines(Paths.get(OUTPUT_FILE_PATH));
        }
        catch (Exception ex)
        {
            System.out.println("Your solution doesn't work =(");
            ex.printStackTrace();
            System.exit(1);
            return;
        }


        final List<String> inputCitiesList = IOUtils.readCitiesList();
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
