package domains.puzzle;

import framework.problem.State;
import java.util.Arrays;

/**
 * This class represents states of various tile-moving puzzle problems,
 * including the 8-Puzzle, which involves a 3x3 display area.
 * It can also represent other displays of different dimensions, e.g. 4x4.
 * A puzzle state is represented with a 2D array of integers.
 * @author tcolburn
 */
/**
 * 
 * @author rudolfmusika Completed and edited 
 */

public class PuzzleState implements State
{
    /**                                                                                                 
       A 2D integer array represents the tiles.                                                                   
     */
    private final int[][] tiles;
    
    private Object contents;
     /**
     * Getter for the underlying 2D array.
     * Most users of this class will not access these representation details.
     * This will be useful when the problem solving framework adds heuristic
     * search to its abilities.
     * @return the underlying 2D array
     */
    public int[][] getTiles() { 
        return this.tiles; 
    }
    /**
     * A puzzle state constructor that accepts a 2D array of integers.
     * @param tiles a 2d array of integers
     */
    public PuzzleState(final int[][] tiles) {
        this.tiles = tiles; 
    }
     
    /**
     * A nested class that represents a location within a puzzle state
     * as  a row and column pair.
     */
    public static class Location
    {
        /**
         * Creates a new location object.
         * @param row the row index of this location, zero origin
         * @param column the column index of this location, zero origin
         */
        public Location(final int row, final int column) 
        {
            this.row = row;
            this.column = column;
        }
        /**
         * Getter for this location row index.
         * @return this location row index
         */
        public int getRow() { return this.row; }
        /**
         * Getter for this location column index.
         * @return this location column index
         */
        public int getColumn() { return this.column; }
        
        /**
         * Creates a string representation of this location object for
         * debugging purposes.
         * @return a string representation of this location object as "(row,column)"
         */
        @Override
        public String toString() 
        {
            return "(" + this.row + "," + this.column + ")";
        }
        /**
         * Tests for equality of this location with another.
         * @param o the other location
         * @return true if this location has same row and column indexes as
         * the other, false otherwise
         */
        @Override
        public boolean equals(final Object o) 
        {
            if (o == null) { return false; }
            if (o.getClass() != this.getClass()) { return false; }
            final Location other = (Location)o;
            return this.row == other.row && this.column == other.column;
        }
        private int row;
        private int column;
    }
    
        /**
     * A puzzle state constructor that creates a new puzzle state from a
     * given puzzle state and two locations.
     * A copy of the given state is created and the contents of the two
     * given locations are swapped.
     * The original puzzle state is not changed.
     * @param state an existing puzzle state
     * @param loc1 a location within the given state
     * @param loc2 another location within the given state
     * @throws ArrayIndexOutOfBoundsException if either location is invalid
     * for this state
     */    
    public PuzzleState( PuzzleState state, Location loc1,  Location loc2) {
        this.tiles = copyTiles(state.tiles);
        final int temp = this.tiles[loc1.row][loc1.column];
        this.tiles[loc1.row][loc1.column] = this.tiles[loc2.row][loc2.column];
        this.tiles[loc2.row][loc2.column] = temp;
    }
    /**
     * Finds the location of a given tile in this state.
     * @param tile the tile to find
     * @return the location of the tile
     * @throws RuntimeException if the tile is not found in the state
     */
    public Location getLocation(final int tile) {
        for (int r = 0; r < this.tiles.length; ++r) 
        {
            for (int c = 0; c < this.tiles[r].length; ++c) 
            {
                if (this.tiles[r][c] == tile) 
                {
                    return new Location(r, c);
                }
            }
        }
        throw new RuntimeException("Tile " + tile + " not found in\n" + this.toString());
    }
    /**
     * Tests for equality of this puzzle state with another.
     * @param o the other state
     * @return true if the underlying arrays are equal, false otherwise
     */
    @Override
    public boolean equals(final Object o) 
    {
        if (o == null) { return false; }
        if (o.getClass() != PuzzleState.class) { return false; }
        final PuzzleState other = (PuzzleState)o;
        return this == other || Arrays.deepEquals(this.tiles, other.tiles);
    }
    
//    @Override
    public Object getItems() { 
        return contents; 
    }
    /**
     * Creates a string representation of this state, with the tiles laid out
     * in a table with dashes and vertical bars used to separate rows and columns.
     * @return the string representation of this state
     */
    @Override
    public String toString() 
    {
        final int width = this.tiles[0].length;
        final StringBuilder builder = new StringBuilder();
        for (final int[] row : this.tiles) 
        {
            builder.append(horizontalDivider(width));
            builder.append("\n");
            builder.append(horizontalRow(row));
            builder.append("\n");
        }
        builder.append(horizontalDivider(width));
        return builder.toString();
    }
    /*
    Private helper methods follow.
    */
    private static String horizontalDivider(final int width) 
    {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width; ++i) { builder.append("+---"); }
        builder.append("+");
        return builder.toString();
    }
    
    private static String horizontalRow(final int[] tiles) 
    {
        final StringBuilder builder = new StringBuilder();
        for (final int tile : tiles) 
        {
            builder.append("|");
            builder.append(tileString(tile));
        }
        builder.append("|");
        return builder.toString();
    }
    
    private static String tileString(final int tile) 
    {
        if (tile == 0) { return "   "; }
        if (tile / 10 == 0) { return " " + tile + " "; }
        return tile + " ";
    }
    
    private static int[][] copyTiles(final int[][] source) 
    {
        final int rows = source.length;
        final int columns = source[0].length;
        final int[][] dest = new int[rows][columns];
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < columns; ++c) 
            {
                dest[r][c] = source[r][c];
            }
        }
        return dest;
    }
    
//    @Override
    public int getHeuristic(State goal) {
        //return tilesOutOfPlace(this, goal);
        return sumManhattan(this, goal);
    }
    
    public static int tilesOutOfPlace(State current, State goal) {
        int count = 0;
        PuzzleState g = (PuzzleState)goal;
        PuzzleState c = (PuzzleState)current;
        int goalPuzzle[][] = g.getTiles();
        int currentPuzzle[][] = c.getTiles();
        
        for(int i = 0; i < 3; i++) {
            for(int x = 0; x < 3; x++) {
                if(goalPuzzle[i][x] != currentPuzzle[i][x] && 
                        currentPuzzle[i][x] != 0) count++; 
            }
        }
        return count;
    }
    /**
     * 
     * @param current Basically the current state. 
     * @param goal Where you want to get to.
     * @return sum the number close.
     */
    public static int sumManhattan(State current, State goal) {
        int num = 0;
        PuzzleState g = (PuzzleState)goal;
        PuzzleState c = (PuzzleState)current;
        int goalPuzzle[][] = g.getTiles();
        int currentPuzzle[][] = c.getTiles();
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int value = currentPuzzle[x][y];
                if (value != 0) {
                    for (int n = 0; n < 3; n++) {
                        for (int p = 0; p < 3; p++) { 
                            if(currentPuzzle[x][y] == goalPuzzle[n][p] 
                               && goalPuzzle[n][p] != 0) 
                                num += Math.abs(x-n) + Math.abs(y-p); 
                        }
                    }
                } 
            }
        }
        return num;
    }

}
