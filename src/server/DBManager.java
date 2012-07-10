package server;

import java.io.BufferedReader;
import java.io.FileReader;

public class DBManager {
	
	//mudar aki o caminho para os arquivos
	//TODO ver um jeito do caminho nao depender de path
	private static final String path ="/home/daniel/workspace/lab3_RMI/files/"; 
	private static final String strAllInfoFile = path + "allinfo";
	private static final String strAllCoursesFile = path + "courses";
	
	
	
	public String listAll(){
		BufferedReader buffer;
		
		try{
			buffer = new BufferedReader(new FileReader(strAllInfoFile));
			
			String aux ="";
			String info="*******************Todas as Informacoes:**********************\n";
			while((aux = buffer.readLine())!=null){
				info = info + aux + "\n";
			}
			
			System.out.println(" Chegou aqui :" + info);
			buffer.close();
			return info;
		}catch (Exception e){
			System.out.println("Exception File Reader:" + e);
		}
		
		return null;
	}
	
	public String listagem(){
		try {
			BufferedReader buffer;
			buffer = new BufferedReader(new FileReader(strAllCoursesFile));
			String aux ="";
			String info="*******************Todas as Materias (siglas):**********************\n";
			while((aux = buffer.readLine())!=null){
				info = info + aux + "\n";
				
			}
			buffer.close();
			return info;
			
		}catch (Exception e){
			System.out.println("Exception File Reader:" + e);
		}	
	
		return null;
	}
	
	private static String getInfoFromFile(String sigla){
		
		try{
			BufferedReader buffer;
			buffer = new BufferedReader(new FileReader(path + sigla));
			String aux ="";
			String content="";
			while((aux = buffer.readLine())!=null){
				content = content + aux ;	
			}
			//tokenizar
			System.out.println(content);
			return content;
			
		}catch(Exception e){
			return null;
		}
	}
	
	public String informar(String sigla){
		String result;
		String info = getInfoFromFile(sigla);
		if(info == null){
			return "Materia nao encontrada";
		}
		String tokens[];
		tokens = info.split("\\|");
		/*
		result =          "Sigla: "      + m.getSigla()      + "\n";
		result = result + "Titulo: "     + m.getTitulo()     + "\n";
		result = result + "Programa: "   + m.getPrograma()   + "\n";
		result = result + "Horario: "    + m.getHorario()    + "\n";
		result = result + "Comentario: " + m.getComentario() + "\n";
		
		return result;
		*/
		
		 result = "SIGLA : " + tokens[0]  +             "\n";
		 result = result + "TITULO: "     + tokens[0] + "\n";
		 result = result + "PROGRAMA: "   + tokens[1]   + "\n";
		 result = result + "HORARIO: "    + tokens[2]    + "\n";
		 result = result + "COMENTARIO: " + tokens[3] + "\n";
		
		return result;
	}
	
	public String programa(String sigla){
		String result;
		String info = getInfoFromFile(sigla);
		if(info == null){
			return "Materia nao encontrada";
		}
		String tokens[];
		tokens = info.split("\\|");
		result = "PROGRAMA: "   + tokens[1]   + "\n";
		
		return result;
	}
	
	
	public String lerComen(String sigla){
		String result;
		String info = getInfoFromFile(sigla);
		if(info == null){
			return "Materia nao encontrada";
		}
		String tokens[];
		tokens = info.split("\\|"); // delimitador eh |
		result = "COMENTARIO: "   + tokens[3]   + "\n";
		
		return result;
	}
	
	

}
