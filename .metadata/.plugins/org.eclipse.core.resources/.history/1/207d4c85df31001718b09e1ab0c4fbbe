import java.util.ArrayList;

public class DataBaseID {
     private ArrayList<BlackList> bl;    
    
     public DataBaseID( ArrayList<BlackList> bl) {
 		this.bl = bl;
 	}       

	public ArrayList<BlackList> getBL(){
    	 return this.bl;
     }      
	public void deleteBL(int a){
		for (BlackList item : this.bl) {
			if( item.getpassCode() ==( a ) ){
                this.bl.remove( item );
                break;
			}
			}
	}
	

     public String printDatabaseBL(){
   	  String output= "" ;
	       output +=  "" + " " + this.bl + "\n" ;   
			return output;
   	
   }
  
     
     
}