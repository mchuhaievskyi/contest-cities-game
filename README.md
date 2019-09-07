# contest-cities-game

Current high score table:

Place | Score | Name | Solution link
--- | --- | --- | ---
1 | 6976* | @kovez | https://github.com/luxTutamen/cities
2 | 12 | @freudzone | https://github.com/mchug/contest-cities-game/pull/3 

\* _the actual score = 11976 - 5000 (penalty because the solution wasn't integrated into a provided skeleton)_

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
