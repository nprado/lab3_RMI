package client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class Main {

	private static String getParameter(String oper){
		String param;
		String tokens[];
		tokens = oper.split(" ");
		
		param = tokens[1];
		
		return param;
		
	}
	
	private static double media(long v[], int n){
		long soma = 0;
		for (int i=0 ; i<n; i++){
			soma =+ v[i];
		}
		double media =  ((double)soma / (double) n); 
		return media;
	}
	
	
	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws NotBoundException, IOException {
		Client cli = (Client) Naming.lookup("rmi://localhost/lab3"); 
		
		System.out.println("Digite a operacao desejada:");
		System.out.println("listall: Listar todas as informacoes de Materias");
		System.out.println("listagem: Listar todas as Materias (siglas)");
		System.out.println("informar <sigla>: Informacoes da materia ");
		System.out.println("programa <sigla>: Programa da materia ");
		System.out.println("lercomen <sigla>: Comentarios da materia ");
		System.out.println("esccomen <sigla>   <comentario>: Escrever Comentario na materia ");
		System.out.println("estat    <comando> <parametros>: Escrever Comentario na materia ");
		System.out.println("sair: Sair do programa");
		
		boolean allowedOp = false;
		//le entrada padrao
		while(true){
			BufferedReader stdin = new BufferedReader
			(new InputStreamReader(System.in));
			String op;
			System.out.flush();
	    
			op = stdin.readLine();
			//verifica
			System.out.println("Leu : " + op);
	    
			if(op.equals("sair")){
				System.out.println("Bye");
				System.exit(0);
			}
	    
			if(op.equals("listall")){
				allowedOp = true;
				System.out.println(cli.listTudo());
			}
			
			if(op.equals("listagem")){
				allowedOp = true;
				System.out.println(cli.listagem());
			}
	    
			if(op.contains("informar")){
				allowedOp = true;
				String param = getParameter(op);
				System.out.println(param);
				System.out.println(cli.informar(param));
			}
			
			if(op.contains("programa")){
				allowedOp = true;
				String param = getParameter(op);
				System.out.println(param);
				System.out.println(cli.programa(param));
			}
			
			if(op.contains("lercomen")){
				allowedOp = true;
				String param = getParameter(op);
				System.out.println(param);
				System.out.println(cli.lerComen(param));
			}
			if(op.contains("estat")){
				long times[] = new long[100];
				allowedOp = true;
				String comando, param1;
				String[] tokens =op.split(" ");
				comando = tokens[1];
				if(tokens.length < 3){
					param1=null;
				}
				else{
					param1 = tokens[2];
				}
				for(int i=0; i<100 ;i++){
					//long tStart = new Date().getTime();
					long tStart = System.nanoTime();
					
					
					//System.out.println(cli.statistic(comando,param1, null) + "loop" + i);
					cli.statistic(comando,param1, null);
						
					//long tStop = new Date().getTime();
					long tStop = System.nanoTime();
					
					long deltaT = tStop - tStart;
					
					times[i]= deltaT;
					
					System.out.println(deltaT );
					
					
				}
				//calcula media
				System.out.println("media: " + media(times,100) + "ns");
				System.out.println("End.");
			}
			
			if(!allowedOp){
				System.out.println(op + " nao e um comando valido.");
			}
			
			allowedOp = false;
		}
	}
}
