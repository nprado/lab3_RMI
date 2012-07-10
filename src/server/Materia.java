package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Materia {
	private static final String path ="/home/daniel/workspace/lab3_RMI/files/";
	//private  int id;
	private  String titulo;
	private  String programa;
	private  String comentario;
	private  String horario;
	private  String sigla;
	
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getPrograma() {
		return programa;
	}
	
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	/*
	public Boolean setInfoFromFile(String sigla) throws IOException{
		
		try{
			BufferedReader buffer;
			buffer = new BufferedReader(new FileReader(path + sigla));
			String aux ="";
			String content="";
			while((aux = buffer.readLine())!=null){
				content = content + aux + "\n";	
			}
			//tokenizar
			System.out.println(content);
			String[] tokens = content.split("|");
			this.titulo = tokens[0];
			this.programa = tokens[1];
			this.horario = tokens[2];
			this.comentario = tokens[3];
			this.sigla = sigla;			
			return true;
			
		}catch (FileNotFoundException e){
			return false;
		}
	}*/
}
