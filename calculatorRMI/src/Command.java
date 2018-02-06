/**
 * 
 */


/**
 * Command class 
 * @author: Anaswara Naderi Vadakkeperatta
 * Version: 1.0
 *
 */
public class Command implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	//member variables
	private double num1;
	private char operator;
	private double num2;
	
	//constructor
	public Command(double num1, char operator, double num2) {
		setNum1(num1);
		setOperator(operator);
		setNum2(num2);
	}
	
	//setters and getters
	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

}
