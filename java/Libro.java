package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Libro extends Material
{
	private int numPaginas;
	private String autor;
	private String genero;
	private String editorial;
	
	public Libro(){
		super();
		tipo="LIBRO";
	}
	
	public Libro (String tipo, String titulo, String fechaPublicacion, 
					int numPaginas, String genero, String editorial, String autor)
	{
		super (titulo, fechaPublicacion,tipo);
		this. numPaginas=numPaginas;
		this. genero=genero;
		this. editorial=editorial;
		this. autor=autor;
	}
	
	public int getNumPaginas(){
		return numPaginas;
	}
	public String getGenero(){
		return genero;
	}
	public String getEditorial(){
		return editorial;
	}
	public String getAutor (){
		return autor;
	}
	public void setNumPaginas(int numPaginas){
		this.numPaginas=numPaginas;
	}
	public void setGenero(String genero){
		this.genero=genero;
	}
	public void setEditorial (String editorial){
		this.editorial=editorial;
	}
	public void setAutor(String autor){
		this.autor=autor;
	}
	
	@Override
	public void pedirDatos(){
	Scanner leer= new Scanner (System.in);
	super. pedirDatosPadre();	
	System.out.println ("Ingresa genero");
	genero=leer.nextLine();
	System.out.println ("Ingresa editorial");
	editorial=leer.nextLine();
	System.out.println ("Ingresa autor");
	autor=leer.nextLine();
	System.out.println ("Ingresa numero de paginas");
	numPaginas=leer.nextInt();
	}
	@Override
	public void mostrarDatos(){
		super.mostrarDatosPadre();
		System.out.println("Autor: "+getAutor());
		System.out.println("Genero: "+getGenero());
		System.out.println("Editorial: "+getEditorial());
		System.out.println("Numero de paginas: "+getNumPaginas());
	}
	
	@Override
	public double cuantoCuesto(String tipo){
		if (tipo=="prestamo")
			return 100;
		else 
			return getNumPaginas()*.50;
	}
	
	@Override
	public String guardarDatos()
	{
		String linea="LIBRO,";
		linea+=titulo+","+fechaPublicacion+","+numPaginas+",";
		linea+=genero+","+editorial+","+autor;
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
		genero=tokens.nextToken();
		editorial=tokens.nextToken();
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