package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Tesis extends Material
{
	private int numPaginas;
	private String autor;
	private String tema;
	private String institucion;
	
	public Tesis(){
		super();
		tipo="TESIS";
	}
	
public Tesis (String tipo, String titulo, String fechaPublicacion, 
					int numPaginas, String tema, String institucion, String autor)
	{
		super (titulo, fechaPublicacion,tipo);
		this. numPaginas=numPaginas;
		this. tema=tema;
		this. institucion=institucion;
		this. autor=autor;
	}
	
	public int getNumPaginas(){
		return numPaginas;
	}
	public String getTema(){
		return tema;
	}
	public String getInstitucion(){
		return institucion;
	}
	public String getAutor (){
		return autor;
	}
	public void setNumPaginas(int numPaginas){
		this.numPaginas=numPaginas;
	}
	public void setTema(String tema){
		this.tema=tema;
	}
public void setInstitucion (String institucion){
		this.institucion=institucion;
	}
	public void setAutor(String autor){
		this.autor=autor;
	}
	
	@Override
	public void pedirDatos(){
	Scanner leer= new Scanner (System.in);
	super. pedirDatosPadre();	
	System.out.println ("Ingresa tema");
	tema=leer.nextLine();
	System.out.println ("Ingresa institucion");
	institucion=leer.nextLine();
	System.out.println ("Ingresa autor");
	autor=leer.nextLine();
	System.out.println ("Ingresa numero de paginas");
	numPaginas=leer.nextInt();
	}
	@Override
	public void mostrarDatos(){
		super.mostrarDatosPadre();
		System.out.println("Autor: "+getAutor());
		System.out.println("Tema: "+getTema());
		System.out.println("Institucion: "+getInstitucion());
		System.out.println("Numero de paginas: "+getNumPaginas());
	}
	
	@Override
	public double cuantoCuesto(String tipo){
	if (tipo=="prestamo")
			return 0.0;
		else 
			return getNumPaginas()*.50;
	}
	
	@Override
	public String guardarDatos()
	{
		String linea="TESIS,";
		linea+=titulo+","+fechaPublicacion+","+numPaginas+",";
		linea+=tema+","+institucion+","+autor;
		if (disponibilidad)
			linea+=",T";
		else 
			linea+=",F";
		return(linea);		
	}

	
	@Override
	public void cargarDatos(StringTokenizer tokens)
	{
		titulo=tokens.nextToken();
		fechaPublicacion=tokens.nextToken();
		numPaginas=Integer.parseInt(tokens.nextToken());
		tema=tokens.nextToken();
		institucion=tokens.nextToken();
		autor=tokens.nextToken();
		String disponible=tokens.nextToken();
		switch(disponible){
			case "T":
			disponibilidad=true;
			break;
			case "F":
			disponibilidad=false;
		break;}
	}
	
}