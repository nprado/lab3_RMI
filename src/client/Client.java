package client;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote{
		
	public String listTudo() throws RemoteException;
	public String listagem() throws RemoteException;
	public String informar(String sigla) throws RemoteException;
	public String programa(String sigla) throws RemoteException;
	public String lerComen(String sigla) throws RemoteException;
	public String statistic(String comando, String param1, String param2) throws RemoteException;
	
}
