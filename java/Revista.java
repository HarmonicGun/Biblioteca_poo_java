package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Revista extends Material
{
	String tema, volumen;
	int numPaginas;
	
	public Revista(){
		super();
		tipo="REVISTA";
	}
	public Revista (String tipo, String titulo, String fechaPublicacion, String tema, String volumen, int numPaginas) {
		super (titulo, fechaPublicacion, tipo);
		this.tema=tema;
		this.volumen=volumen;
		this.numPaginas=numPaginas;
		}
	
	public String getTema(){
		return tema;
	}
	public String getVolumen(){
		return volumen;
	}
	public int getNumPaginas(){
		return numPaginas;
	}
	
	public void setTema(String tema){
		this.tema=tema;
	}
	public void setVolumen (String volumen){
		this.volumen=volumen;
	}
	public void setNumPaginas(int numPaginas){
		this. numPaginas=numPaginas;
	}
	@Override
	public void pedirDatos(){
		Scanner leer= new Scanner (System.in);
		super.pedirDatosPadre();
		System.out.println ("Ingresa tema:");
		tema=leer.nextLine();
		System.out.println ("Ingresa volumen: ");
		volumen=leer.next();
		System.out.println ("Ingresa numero de paginas:");
		numPaginas=leer.nextInt();
	}
	@Override
	public void mostrarDatos(){
		super.mostrarDatosPadre();
		System.out.println("Tema: "+getTema());
		System.out.println("Volumen: "+getVolumen());
		System.out.println("Numero de paginas: "+getNumPaginas());
	}
	@Override
	public double cuantoCuesto(String tipo){
	if (tipo=="prestamo")
			return 80;
		else 
			return getNumPaginas()*.50;
	}
	
	@Override
	public String guardarDatos()
	{
		String linea="REVISTA,";
		linea+=titulo+","+fechaPublicacion+","+tema+",";
		linea+=volumen+","+numPaginas;
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
		tema=tokens.nextToken();
		volumen=tokens.nextToken();
		numPaginas=Integer.parseInt(tokens.nextToken());
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