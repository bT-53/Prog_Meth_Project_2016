package Utility;

public class InputUtility {
	private static boolean holdKeyUp1 = false;
	private static boolean holdKeyDown1 = false;
	private static boolean holdKeyRight1 = false;
	private static boolean holdKeyLeft1 = false;
	private static boolean holdKeyUp2 = false;
	private static boolean holdKeyDown2 = false;
	private static boolean holdKeyRight2 = false;
	private static boolean holdKeyLeft2 = false;
	
	public static void setKeyUp1(boolean t){
		holdKeyUp1 = t;
	}
	
	public static void setKeyDown1(boolean t){
		holdKeyDown1 = t;
	}
	
	public static void setKeyRight1(boolean t){
		holdKeyRight1 = t;
	}
	
	public static void setKeyLeft1(boolean t){
		holdKeyLeft1 = t;
	}
	
	public static void setKeyUp2(boolean t){
		holdKeyUp2 = t;
	}
	
	public static void setKeyDown2(boolean t){
		holdKeyDown2 = t;
	}
	
	public static void setKeyRight2(boolean t){
		holdKeyRight2 = t;
	}
	
	public static void setKeyLeft2(boolean t){
		holdKeyLeft2 = t;
	}
	
	public static boolean getKeyUp1(){
		return holdKeyUp1;
	}
	
	public static boolean getKeyDown1(){
		return holdKeyDown1;
	}
	
	public static boolean getKeyRight1(){
		return holdKeyRight1;
	}
	
	public static boolean getKeyLeft1(){
		return holdKeyLeft1;
	}
	
	public static boolean getKeyUp2(){
		return holdKeyUp2;
	}
	
	public static boolean getKeyDown2(){
		return holdKeyDown2;
	}
	
	public static boolean getKeyRight2(){
		return holdKeyRight2;
	}
	
	public static boolean getKeyLeft2(){
		return holdKeyLeft2;
	}
}