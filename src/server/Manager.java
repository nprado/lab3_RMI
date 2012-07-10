package server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import client.Client;

public class Manager extends UnicastRemoteObject implements Client{

	protected Manager() throws RemoteException {
		super();
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String listTudo() throws RemoteException {
		DBManager db = new DBManager();
		return db.listAll();
	}

	public String listagem() throws RemoteException {
		DBManager db = new DBManager();
		return db.listagem();
	}


	public String informar(String sigla){
		DBManager db = new DBManager();
		//Materia m = new Materia();
		
		//if(m.setInfoFromFile(sigla)){
			return db.informar(sigla);
		//}
		//else
	//		return sigla + "Materia nao encontrada/Parametro invalido";
	}

	
	public String programa(String sigla) throws RemoteException {
		DBManager db = new DBManager();
		return db.programa(sigla);
	}


	public String lerComen(String sigla) throws RemoteException {
		DBManager db = new DBManager();
		
		return db.lerComen(sigla);
	}


	public String statistic(String comando, String param1, String param2)
			throws RemoteException {
		 
		
		DBManager db = new DBManager();
		
		// mapeia comando String em inteiros para usar switch(){}
		Hashtable<String,Integer> h = new Hashtable<String,Integer>();
		h.put("listall", new Integer(0));
		h.put("listagem", new Integer(1));
		h.put("informar", new Integer(2));
		h.put("programa", new Integer(3));
		h.put("lercomen", new Integer(4));
		h.put("esccomen", new Integer(5));
		
		
		Integer op = new Integer(h.get(comando));
		if(op==null){
			// no caso de nao achar a chave ( comando invalido) 
			op = new Integer(-1);
		}
		
		switch(op){
			case 0:
				db.listAll();
				return "Teste 0";
			case 1:
				db.listagem();				
				return "Teste 1";
			case 2:	
				db.informar(param1);
				return "Teste 2";
			case 3:
				db.programa(param1);
				return "Teste 3";
			case 4:
				db.lerComen(param1);
				return "Teste 4";
			case 5:
				return "Teste 5";
			default:
				return "comando invalido"; 
			}	
			
		
	}
}
