# contest-cities-game

#### Current high score table:

Place | Score | Name | Solution link
--- | --- | --- | ---
1 | 16500** | @black220sun | https://gitlab.com/black220sun/contest-cities-game/tree/Attempt-1
2 | 14800** | @dantistnfs | https://github.com/Dantistnfs/contest-cities-game (Rust)
3 | 13847 | @tsvietOK | https://github.com/tsvietOK/contest-cities-game
4 | 6976* | @kovez | https://github.com/luxTutamen/cities
5 | 12 | @freudzone | https://github.com/mchug/contest-cities-game/pull/3 

\* _the actual score = 11976 - 5000 (penalty because the solution wasn't integrated into a provided skeleton)_

\*\* _the actual score is higher, but since solution behaviour is not idempotent, I have chosen the best score and added extra penalty -100_

#### For external solution (solutions written not in Java) 
The requirements are next:
* Be runnable at windows (sorry, I don't have linux env right now)
* Accepts 2 command line params: input file path and output file path
* Writes the solution* to the file which path was passed as a second argument
 
\* cities chain in the same format as in input file 

#### For Java solutions
Implement the method *com.itkpi.java.contest.cities.solution*.**Solver#solveCitiesGame**

```java
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
        // TODO: implement this
        return Collections.emptyList();
    }
```
