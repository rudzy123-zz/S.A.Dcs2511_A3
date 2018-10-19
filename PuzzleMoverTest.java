package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author rudolfmusika
 */
public class PuzzleMoverTest {
        
    /**
     * Declare private instance fields here. For example:
     */
    
    private final State start;
    private final Mover mover;
    private final String slide1, slide2, slide3, slide4,  // move names
	                 slide5, slide6, slide7, slide8;
    
    public PuzzleMoverTest() {
        
        /**
         * Initialize instance fields here
         */
        mover = new PuzzleMover();
        start = new PuzzleState(new int[][]{ 
            new int[]{1, 4, 2}, 
            new int[] {7, 8, 3}, 
            new int[] {0, 6, 5}});
        slide1 = "SLIDE TILE 1";    slide6="SLIDE TILE 6";
        slide2 ="SLIDE TILE 2";     slide7="SLIDE TILE 7";
        slide3 ="SLIDE TILE 3";     slide8="SLIDE TILE 8";
        slide4 ="SLIDE TILE 4";
        slide5 ="SLIDE TILE 5";
        
    }
    
    /**
     * Test all moves in the methods below by replacing the calls to fail.
     */

    @Test
    public void testSlide1() {
        /**
         * For example, if mover, start, and slide1 have been
         * initialized, call:
         *
         *     mover.doMove(slide1, start)
         *
         * and test the result with assertions.
         */
        try{
            mover.doMove(slide1, start);
            assertTrue(start !=null);
        }
        catch(Exception x){
           fail("The test case has not been implemented."); 
        }       
    }

    @Test
    public void testSlide2() {
        try{
        mover.doMove(slide2, start);
        assertTrue(start != null);   
        }
        catch(Exception x){
          fail("The test case has not been implemented.");  
        }                
    }

    @Test
    public void testSlide3() {
        try{
        mover.doMove(slide3, start);
        assertTrue(start != null);      
        }
        catch(Exception x){
          fail("The test case has not been implemented.");  
        }                
    }

    @Test
    public void testSlide4() {
        try{
        mover.doMove(slide4, start);
        assertTrue(start != null);    
        }
        catch(Exception x){
            fail("The test case has not been implemented.");   
        }            
    }

    @Test
    public void testSlide5() {
        try{
        mover.doMove(slide5, start);
        assertTrue(start != null);  
        }
        catch(Exception x){
          fail("The test case has not been implemented.");   
        }               
    }

    @Test
    public void testSlide6() {
        try{
        mover.doMove(slide6, start);
        assertTrue(start != null);    
        }
        catch(Exception x){
           fail("The test case has not been implemented.");  
        }           
    }

    @Test
    public void testSlide7() {
        try{
        mover.doMove(slide7, start);
        assertTrue(start != null);   
        }
        catch(Exception x){
         fail("The test case has not been implemented.");    
        }       
    }

    @Test
    public void testSlide8() {
        try{
        mover.doMove(slide8, start);
        assertTrue(start != null);     
        }
        catch(Exception x){
         fail("The test case has not been implemented.");
        }  
    }
    
}