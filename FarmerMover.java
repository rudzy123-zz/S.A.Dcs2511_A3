package domains.farmer;

import framework.problem.Mover;
import framework.problem.State;
/**
 * 
 * @author rudolfmusika 4 FarmerMover. It extends Mover Class. 
 */
public class FarmerMover extends Mover
{
    public FarmerMover() 
    {
        super.addMove(GOES_ALONE, s -> this.goAlone(s));
        super.addMove(TAKES_WOLF, s -> this.takeWolf(s));
        super.addMove(TAKES_GOAT, s -> this.takeGoat(s));
        super.addMove(TAKES_CABBAGE, s -> this.takeCabbage(s));
    }
    
    private State goAlone(State state) 
    {
        FarmerState s = (FarmerState)state;
        return noFatality(new FarmerState(across(s.getFarmer()), s.getWolf(), 
                s.getGoat(), s.getCabbage()));
    }
    
    private State takeWolf(State state) 
    {
        FarmerState s = (FarmerState)state;
        if(s.getFarmer() != s.getWolf()) return null;
        else return noFatality(new FarmerState(across(s.getFarmer()), 
                        across(s.getWolf()), s.getGoat(), s.getCabbage()));
    }
    
    private State takeGoat(State state) 
    {
        FarmerState s = (FarmerState)state;
        if(s.getFarmer() !=s.getGoat()) return null;
        else return noFatality(new FarmerState(across(s.getFarmer()), 
                s.getWolf(), across(s.getGoat()), s.getCabbage()));
    }
    
    private State takeCabbage(State state) 
    {
        FarmerState s = (FarmerState)state;
        if(s.getFarmer() != s.getCabbage())return null;
        else return noFatality(new FarmerState(across(s.getFarmer()), 
                s.getWolf(), s.getGoat(), across(s.getCabbage())));
    }
    
    private static FarmerState.Side across(FarmerState.Side side) 
    {
        if (side == FarmerState.Side.EAST) 
        {
            return FarmerState.Side.WEST;
        }
        return FarmerState.Side.EAST;
    }
    
    private static boolean isNotReallyDead(FarmerState state) 
    {
        FarmerState.Side farmer = state.getFarmer();
        FarmerState.Side wolf = state.getWolf();
        FarmerState.Side goat = state.getGoat();
        FarmerState.Side cabbage = state.getCabbage();
        return  (cabbage != goat || cabbage == farmer)&&
                (goat != wolf || goat == farmer);
    }
    
    private static State noFatality(FarmerState state) 
    {
        if(isNotReallyDead(state)) return state;
        else return null;
    }
    
    public static final String GOES_ALONE = "Farmer Goes Alone";
    public static final String TAKES_WOLF = "Farmer Takes Wolf";
    public static final String TAKES_GOAT = "Farmer Takes Goat";
    public static final String TAKES_CABBAGE = "Farmer Takes Cabbage";   
}
