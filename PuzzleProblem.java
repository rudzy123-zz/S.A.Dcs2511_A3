package domains.puzzle;

import framework.problem.Problem;
/**
 * 
 * @author rudolfmusika Class PuzzleProblem extends Problem
 */
public class PuzzleProblem extends Problem
{   
    public PuzzleProblem() 
    {
        super.setName("8-Puzzle");
        super.setMover(new PuzzleMover());
        super.setIntroduction(INTRO);
        super.setInitialState(PuzzleProblem.START);
        super.setCurrentState(PuzzleProblem.START);
        super.setFinalState(PuzzleProblem.END);
    }
    /**
     * static set new puzzle to the configuration meant to be followed.
     */
    static 
    {
        START = new PuzzleState(new int[][] { { 1, 4, 2 }, { 7, 8, 3 }, 
            { 0, 6, 5 } });
        END = new PuzzleState(new int[][] { { 1, 2, 3 }, { 8, 0, 4 }, 
            { 7, 6, 5 } });
    }
    private static final PuzzleState START;
    private static final PuzzleState END;
    private static final String INTRO = "You are given a board in which "
            + "numbered "
            + "tiles can slide around. There is one blank space that holds "
            + "no tile.  "
            + "A legal move consists of sliding a tile into the blank space "
            + "if the "
            + "tile is adjacent to it. The goal is to move tiles around "
            + "until the "
            + "board looks like the goal state below.";
}
