package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Manager manager = new Manager();
		Naming.rebind("rmi://localhost/lab3", manager);
		
	}

}
