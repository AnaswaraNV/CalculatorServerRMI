
import java.io.*;
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Anaswara Naderi Vadakkeperatta
 *
 */
public class CalculatorClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		try {

			Scanner keyboard = new Scanner(System.in);
			String input = "YES";

			while(true) {

				if(input.toUpperCase().equals("YES")){
					try { 
						System.out.println("Please input your command with space: (a op b) where op: + - * /");
						System.out.print("Command >>");
						String inputCommand = keyboard.nextLine();

						if(inputCommand!= null) {

							//Looking for registered RMI service and casted to calculator
							Calculator calcObject = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorServer");

							//Process to split the strings in input command 
							ArrayList<String> inputList = new ArrayList<String>();
							String arr[] = inputCommand.split(" ");

							for (String item : arr) {
								inputList.add(item);
							}

							//Storing split strings in variables to further processing
							double num1 = Double.parseDouble(inputList.get(0).toString());//num1
							char operator = inputList.get(1).toString().charAt(0);//operator
							double num2 = Double.parseDouble(inputList.get(2).toString());//num2

							//Creating Implementation class object and calling the calculate method 
							CalculatorImpl implObject  = new CalculatorImpl();
							double result = implObject.calculate(new Command(num1, operator, num2));

							if(num2 == 0 && operator == '/') {

							} else {
								System.out.println("Result: " + result);
							}

							//statements asking user if he wants to continue processing
							System.out.println("Continue ? (YES/NO)");
							input = keyboard.nextLine();

						} else {
							System.out.println("Command is Null, Please enter valid command!");
							System.out.println("Continue ? (YES/NO)");
							input = keyboard.nextLine();

						}
					} catch(NumberFormatException ne) {
						System.out.println("Number format Exception! Please enter valid input");
					}

				}else if(input.toUpperCase().equals("NO")) {
					//client finishes execution
					break;
				} else {
					System.out.println("Please Enter valid input YES/NO:");
					input = keyboard.nextLine();
				}
			} //End while

			System.out.println("Ending Client Connection..");
			keyboard.close();

		} catch (MalformedURLException e) {
			System.out.println("Not a valid URL!");
			e.printStackTrace();
		} catch (IOException ie) {
			System.out.println("Error in IO!");
			ie.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Registry bind failed!");
			e.printStackTrace();
		}

	} //main

} //calculator client
