package automation;

public class BlackList {
	protected Integer passCode;
	
public BlackList(){}
	
	public BlackList(int passCode)
	{
		this.passCode = passCode;

	}
	
	public Integer getpassCode()
	{
		return passCode;
	}
	
	
	
	public void setpassCode(Integer passCode)
	{
		this.passCode = passCode;
	}
	
	public String toString(){
  	  String output= "" ;
	       output +=  "Pass Code : " + " " + this.passCode + "\n" ;   
			return output;
  	
  }
	
}
