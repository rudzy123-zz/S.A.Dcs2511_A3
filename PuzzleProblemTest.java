package domains.puzzle;

import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author rudolfmusika
 */
public class PuzzleProblemTest {
    
    /**
     * Declare private instance fields here. For example:
     */
    
    private final Problem problem;
    private final Mover mover;
    private final String slide1, slide2, slide3, slide4,   // move names
                         slide5, slide6, slide7, slide8;
    /**
     * Initiated Instantiated fields here.
     */
    public PuzzleProblemTest() {

        /**
         * Initialize instance fields here
         */
        mover = new PuzzleMover();
        problem = new PuzzleProblem();
        slide1 = "SLIDE TILE 1";    slide6="SLIDE TILE 6";
        slide2 ="SLIDE TILE 2";     slide7="SLIDE TILE 7";
        slide3 ="SLIDE TILE 3";     slide8="SLIDE TILE 8";
        slide4 ="SLIDE TILE 4";
        slide5 ="SLIDE TILE 5";

    }

    @Test
    public void testSolution() {

	/**
	 * Display a welcome, the problem introduction, and the initial state.
	 * Perform moves until the problem is solved, making appropriate
	 * assertions along the way.
	 * Use FarmerProblemTest as a model.
         * Basically to fix this problem, one needs to go in the order of 7,8,4
         * 2,3&4.
         * Exception handling is also performed.
	 */
        try{
        display("Welcome to the " + problem.getName() + " problem");
        display(problem.getIntroduction());
        display(problem.getCurrentState());
        tryMove(slide7);
        assertFalse(problem.success());
        
        tryMove(slide8);
        assertFalse(problem.success());
        
        tryMove(slide4);
        assertFalse(problem.success());
        
        tryMove(slide2);
        assertFalse(problem.success());
        
        tryMove(slide3);
        assertFalse(problem.success());
        
        tryMove(slide4);
        assertTrue(problem.success());
        }
        catch (Exception x){
            fail("The test case has not been implemented.");
        }                
    }
    /**
     * 
     * @param o private method to output object.
     */
    private void display(Object o){
        System.out.println(o +"\n");
    }
    /**
     * 
     * @param move private method to initiate the movies in states.
     */
    
    private void tryMove(String move) {
        State next = mover.doMove(move, problem.getCurrentState());
        assertTrue(next != null);
        problem.setCurrentState(next);
        display(problem.getCurrentState());
    }
    
}