import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadID {

	public static void main(String[] args) throws IOException {

		 List<String> list = new ArrayList<String>(); 
		    List<String> id = new ArrayList<String>();
		    File file = new File("id.txt");
		    if(file.exists()){
		        try { 
		            list = Files.readAllLines(file.toPath(),Charset.defaultCharset());
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		     
		    }
		    for(String line : list){
		        String [] res = line.split(",");
		        id.add(res[1]);
		        
		    }
		    
		    List<Integer> listID = new ArrayList<Integer>();
		    for(String s : id){
		    	listID.add(Integer.valueOf(s));
		    }

		    
		    
		    int[] numb = {34844, 28745, 44127};
		    List<Integer> intCheckList = new ArrayList<Integer>();
		    for (int i = 0; i < numb.length; i++){
		    	intCheckList.add(numb[i]);
		    }
		    
		   
		    
		    // check id 
//		    int count = 1;
//		    for(int i =0; i < id.size();i++){
//		   
//		    
//		    System.out.print("ID " + count + " : ");
//		    
//		    System.out.print( id.get(i));
//		    System.out.println( "");
//		    count++;
//		    }
		    
		    List<Integer> acceptID = new ArrayList<Integer>();
		    
		    for (Integer igr : listID) {
		        if (intCheckList.contains(igr)) {
		        	System.out.println("This id is acceptable " +  igr);
		            acceptID.add(igr);
		        }else{
		    		System.out.println("Error ! " + " This id is not acceptable " + igr);
		    	}
		    }
		  
		    
		    System.out.println("\n");
		    
		    
	    	System.out.println("List of IDs that acceptable ");

		    String[] status = {"admin","guest","house member"};
	    

		    for(int i =0; i < acceptID.size();i++){
		    	if(id.get(i) == "34844")
		    	System.out.println( id.get(i) + " -- " + status[0]);
		    	else if(id.get(i) == "28745"){
			    	System.out.println( id.get(i) + " -- " + status[2]);
		    	}
		    	else {
		    		System.out.println( id.get(i) + " -- " + status[1]);
		    	}
		    }
		    
				   
	}

}
