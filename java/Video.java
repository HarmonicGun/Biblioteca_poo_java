package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Video extends Material
{
	String tema, realizador;
	int duracion;
	
	public Video (){
		super ();
		tipo="VIDEO";
	}
	
	public Video (String tipo, String titulo, String fechaPublicacion, String tema, String realizador, int duracion){
	super (titulo, fechaPublicacion, tipo);
	this. tema=tema;
	this. realizador=realizador;
	this.duracion=duracion;
	}

	public String getTema(){
		return tema;
	}
	public String getRealizador(){
		return realizador;
	}
	public int getDuracion(){
		return duracion;
	}
	public void setTema(String tema){
		this.tema=tema;
	}
	public void setRealizador(String realizador){
		this.realizador=realizador;
	}
	public void setDuracion(int duracion){
		this.duracion=duracion;
	}
	@Override
	public void pedirDatos(){
		Scanner leer= new Scanner (System.in);
		super.pedirDatosPadre();
		System.out.println ("Ingresa tema:");
		tema=leer.nextLine();
		System.out.println ("Ingresa realizador: ");
		realizador=leer.nextLine();
		System.out.println ("Ingresa duracion:");
		duracion=leer.nextInt();
	}		
	@Override
	public void mostrarDatos(){
		super.mostrarDatosPadre();
		System.out.println("Realizador: "+getRealizador());
		System.out.println("Tema: "+getTema());
		System.out.println("Duracion : "+getDuracion()+" minutos");
	}
	@Override
	public double cuantoCuesto(String tipo){
		if (tipo=="prestamo")
			return 100;
		else 
			return 10*getDuracion();
	}
	
	@Override
	public String guardarDatos()
	{
		String linea="VIDEO,";
		linea+=titulo+","+fechaPublicacion+","+tema+",";
		linea+=realizador+","+duracion;
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
		realizador=tokens.nextToken();
		duracion=Integer.parseInt(tokens.nextToken());
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