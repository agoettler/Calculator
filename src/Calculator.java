
/*
 * Introduction to Software Design Fall 2014
 * Author: Andrew Goettler
 * Problem: 14.9 Calculator (p. 626)
 * Problem description: Create a calculator GUI as shown on p. 626
 * 		and implement the functionality as indicated
 * 		in the homework grid.
 */

import javax.swing.JFrame;

public class Calculator
{
	private CalculatorGUI calculatorGraphics; // the GUI object for the calculator object
	private CalculatorOPS calculatorOperator; // the operations object for the calculator object
	
	private final static int height = 300;
	private final static int width = 250;
	
	// default, no-argument constructor
	public Calculator()
	{
		calculatorOperator = new CalculatorOPS();
		
		calculatorGraphics = new CalculatorGUI(calculatorOperator);
		calculatorGraphics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorGraphics.setSize(width,height);
		calculatorGraphics.setVisible(true);
	}
}
