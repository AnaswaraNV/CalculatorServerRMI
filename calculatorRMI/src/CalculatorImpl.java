/*
 * Calculator implementation Class to implement the calculator interface
 * @author: Anaswara Naderi Vadakkeperatta
 * Version: 1.0
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CalculatorImpl extends UnicastRemoteObject 
							implements Calculator{

	/**
	 *  To remove warning 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorImpl() throws RemoteException {
		//super() calls the parent constructor with no arguments.
		super();
	}
	
	//Implementing method from interface
	public double calculate(Command commandObj) throws RemoteException {
		 
			double result = 0 ; 
			//Extracting values from the command object
			double num1 = commandObj.getNum1();
			double num2 = commandObj.getNum2();
			char operator = commandObj.getOperator();
			
			switch(operator) {
				case '+' : 	result = num1 + num2; 
							break;
				case '-' :  result = num1 - num2; 
							break;
				case '*' :  result = num1 * num2; 
							break;
				case '/' :  
							if(num2 == 0) {
								System.out.println("Cannot be divided by zero");
							} else {
								result = num1 / num2; 
							}
							break;
				default  :  System.out.println("Invalid Operator!");
							break;
			}
			return result;
	}
}
