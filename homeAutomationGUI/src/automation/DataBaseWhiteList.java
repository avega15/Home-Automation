package automation;

import java.util.ArrayList;

public class DataBaseWhiteList {
     private ArrayList<WhiteList> wl;    
    
     public DataBaseWhiteList( ArrayList<WhiteList> wl) {
 		this.wl = wl;
 	}       

	public ArrayList<WhiteList> getBL(){
    	 return this.wl;
     }       

	public void deleteWL(int a){
		for (WhiteList item : this.wl) {
			if( item.WgetpassCode() ==( a ) ){
                this.wl.remove( item );
                break;
			}
			}
	}
	
	
     public String printDatabaseWL(){
   	  String output= "" ;
	       output +=  "" + " " + this.wl + "\n" ;   
			return output;
   	
   }
  
     
     
}