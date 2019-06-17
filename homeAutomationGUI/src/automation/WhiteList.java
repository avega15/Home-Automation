package automation;

public class WhiteList {
	protected Integer passCode;
	
public WhiteList(){}
	
	public WhiteList(int passCode)
	{
		this.passCode = passCode;

	}
	
	public Integer WgetpassCode()
	{
		return passCode;
	}
	
	
	public void WsetpassCode(Integer passCode)
	{
		this.passCode = passCode;
	}
	
	public String toString(){
  	  String output= "" ;
	       output +=  "Pass Code : " + " " + this.passCode + "\n" ;   
			return output;
  	
  }
	
}
