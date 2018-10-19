package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import framework.problem.*;// <--- Include all libraries just in case.
/**
 * 
 * @author rudolfmusika
 */
public class PuzzleMover extends Mover
{  
    public PuzzleMover() 
    {
        super.addMove(SLIDE_T1, s -> this.tryMove(1, s));
        super.addMove(SLIDE_T2, s -> this.tryMove(2, s));
        super.addMove(SLIDE_T3, s -> this.tryMove(3, s));
        super.addMove(SLIDE_T4, s -> this.tryMove(4, s));
        super.addMove(SLIDE_T5, s -> this.tryMove(5, s));
        super.addMove(SLIDE_T6, s -> this.tryMove(6, s));
        super.addMove(SLIDE_T7, s -> this.tryMove(7, s));
        super.addMove(SLIDE_T8, s -> this.tryMove(8, s));
    }
    /**
     * 
     * @param tile
     * @param s
     * @return You are returning the state, the block location and the Blank 
     * location.
     */
    private PuzzleState tryMove(final int tile, final State s) 
    {
        final PuzzleState state = (PuzzleState)s;
        final PuzzleState.Location tileLoc = state.getLocation(tile);
        final PuzzleState.Location blankLoc = state.getLocation(0);
        final int tileRow = tileLoc.getRow();
        final int tileColumn = tileLoc.getColumn();
        final int blankRow = blankLoc.getRow();
        final int blankColumn = blankLoc.getColumn();
        if (tileRow != blankRow && tileColumn != blankColumn) return null; 
        if (tileRow != blankRow + 1 && tileRow != blankRow - 1 && tileColumn != 
                blankColumn + 1 && tileColumn != blankColumn - 1)  return null; 
        
        return new PuzzleState(state, tileLoc, blankLoc);
    }
    /**
     * 
     * @param args Notice that the final rows are set to show as it should be 
     * for this main function.
     */
    public static void main(final String[] args) 
    {
        final int[] row1 = { 1, 2, 3 };
        final int[] row2 = { 8, 0, 4 };
        final int[] row3 = { 7, 6, 5 };
        final PuzzleState state1 = new PuzzleState(new int[][] { row1, row2, row3 });
        System.out.println(state1);
        final PuzzleMover mover = new PuzzleMover();
        for (int tile = 0; tile <= 8; ++tile) 
        {
            System.out.println("For tile = " + tile + " tryMove = " + mover.tryMove(tile, state1));
        }
    }
    public static final String SLIDE_T1 = "SLIDE TILE 1";
    public static final String SLIDE_T2  = "SLIDE TILE 2";
    public static final String SLIDE_T3  = "SLIDE TILE 3";
    public static final String SLIDE_T4  = "SLIDE TILE 4";
    public static final String SLIDE_T5  = "SLIDE TILE 5";
    public static final String SLIDE_T6  = "SLIDE TILE 6";
    public static final String SLIDE_T7  = "SLIDE TILE 7";
    public static final String SLIDE_T8  = "SLIDE TILE 8";
}