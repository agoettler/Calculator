
/*
 * Introduction to Software Design Fall 2014
 * Author: Andrew Goettler
 * Problem: 14.9 Calculator (p. 626)
 * Problem description: Create a calculator GUI as shown on p. 626
 * 		and implement the functionality as indicated
 * 		in the homework grid.
 */

public class CalculatorOPS
{	
	private String operation = "";
	private boolean floatMode = false;
	
	private String output = "";
	private String previousOutput = "";
	
	private String storedArgument  = "";
	
	/**
	 * This method accepts operations represented as characters from the
	 * CalculatorGUI. The method uses these operations to perform the
	 * calculations and returns the result as a string to be displayed
	 * in the CalculatorGUI.
	 * 
	 * @param input a character representing a calculator button press
	 * @return a String representing the results of the calculation operations
	 */
	public String calculate(String input)
	{	
		output = "";
		
		switch( input )
		{
			case "=":
				output = this.finishCalculation(operation, storedArgument, previousOutput);
				// TODO find some way to allow continuation
				previousOutput = "";
				operation = "";
				storedArgument = "";
				break;
				
			case "+":
			case "-":
			case "*":
			case "/":
				storedArgument = previousOutput;
				previousOutput = "";
				operation = input;
				break;
					
			case ".":
				if(!floatMode)
				{
					output = previousOutput + input;
					previousOutput = output;
					floatMode = true;
				}
				
				else
				{
					output = previousOutput;
				}
				break;
				
			default:
				output = previousOutput + input;
				previousOutput = output;
				break;
			}
		
		return output;
	} 
	
	private String finishCalculation(String operand, String arg1, String arg2)
	{
		if(floatMode)
		{
			float floatArg1; 
			float floatArg2;
			
			if(arg1 != "")
				floatArg1 = Float.parseFloat(arg1);
			else
				floatArg1 = 0;
			
			if(arg2 != "")
				floatArg2  = Float.parseFloat(arg2);
			else
				floatArg2 = 0;
			
			switch(operand)
			{
				case "+":
					return Float.toString(floatArg1 + floatArg2);
				
				case "-":
					return Float.toString(floatArg1 - floatArg2);
					
				case "*":
					return Float.toString(floatArg1 * floatArg2);
					
				case "/":
					if(floatArg2 == 0)
						return "NaN";
					else
						return Float.toString(floatArg1 / floatArg2);
					
				default:
					return arg1;
			}
		}
		
		else
		{
			int intArg1;
			int intArg2;
			
			if(arg1 != "")
				intArg1 = Integer.parseInt(arg1);
			else
				intArg1 = 0;
			
			if (arg2 != "")
				intArg2 = Integer.parseInt(arg2);
			else
				intArg2 = 0;
			
			switch(operand)
			{
				case "+":
					return Integer.toString(intArg1 + intArg2);
					
				case "-":
					return Integer.toString(intArg1 - intArg2);
					
				case "*":
					return Integer.toString(intArg1 * intArg2);
					
				case "/":
					if(intArg2 == 0)
						return "Nan";
					else 
						return Integer.toString(intArg1 / intArg2);
					
				default:
					return arg1;
			}
		}
	}
}
