/*
 * @author: Anaswara Naderi Vadakkeperatta
 * Version: 1.0
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {

	public CalculatorServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try { 
			
			//creating object for the calculator
			Calculator calcObj = new CalculatorImpl();
			
			//Creating registry service with default port number
			LocateRegistry.createRegistry(1099);
			
			//Bind the calculator Object instance to the server
			Naming.rebind("rmi://localhost:1099/CalculatorServer", calcObj);
			
			System.out.println("Coonected to registry!");
			
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
} //CalculatorServer

