package domains.arithmetic;

import framework.problem.State;

/**
 *
 * @author rudolfmusika
 */
/////////////////////
public class ArithmeticState implements State  {
/**
 * 
 * @param jonny is being created as instance.
 */
    public ArithmeticState(int jonny) {
        this.jonny = jonny;
    }
        @Override
        public boolean equals(Object other) {
                if(this==other) return true;
                if(other==null) return false;
                if(this.getClass()!=other.getClass()) return false;
                ArithmeticState otherDummy = (ArithmeticState) other;
                if(this.jonny != otherDummy.jonny) return false;
                if(this.name==null){
                    if(otherDummy.name!=null)return false;
                }
                else if(this.name.equals(otherDummy.name))return false;                
                return true;
        }

    /**
     * 
     * @return 
     */    
    @Override
        public String toString() {
            String[] str = {String.valueOf(jonny)};          
            StringBuilder sb = new StringBuilder();
                for (String line: str){                    
                sb.append(String.format("The value is: "+"%s", line));
            }
            return sb.toString();
                     
        }
//    @Override
        public int getNumber(){
            return jonny;
        }
            
    private final int jonny; 
    private String name;
}
