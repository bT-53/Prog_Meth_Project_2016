package Utility;

public class NameFormatException extends Exception {
	private int errorType;
	
	public NameFormatException(int errorType){
		this.errorType = errorType;
	}
	
	@Override
	public String getMessage(){
		if(this.errorType == 0)return "Same names";
		else return "Wrong name format";
		
	}

}