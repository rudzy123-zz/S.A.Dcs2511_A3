package framework.problem;

/**
 *
 * @author rudolfmusika
 *  A simple Benchmark class in the framework.problem package that stores 
 * and provides getters for a benchmark's name 
 * (for example, "Bench 5: 20 moves"), start state, and goal state. 
 * 
 */

public class Benchmark {
/**
 * Override the toString method from State class.
 * @return 
 */
    @Override
    public String toString(){
      return this.benchmark;  
    }
    /**
     * 
     * @return the given benchmark. 
     * although we are asked to have the toString do the same thing.
     * I plan to use both accordingly.
     */
    public String getBenchMarkName() {
        return benchmark;
    }
    /**
     * 
     * @param benchmark mutator for the name.
     */
    public void setBenchMarkName(String benchmark){
        this.benchmark = benchmark;
    }
    /**
    * getter for the start state.
    * @return the start
    */
    public State getStartState(){
        return this.start;
    }
    /**
     * setter for the start state.
     * @param start 
     */
    public void setStart(State start){
        this.start = start;
    }
    /**
     * 
     * @return  the goal state
     */
    public State getGoalState(){
        return this.goal;
    }
    /**
     * 
     * @param goal mutator for the goal.
     */
    public void setGoal(State goal){
        this.goal= goal;
    }
    private String benchmark;
    private State start;
    private State goal;
}
