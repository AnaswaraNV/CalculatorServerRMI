/*
 * Calculator Interface 
 * @author: Anaswara Naderi Vadakkeperatta
 * Version: 1.0
 */

import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface Calculator extends Remote{
	public double calculate(Command commandObj) throws RemoteException; ;
}
