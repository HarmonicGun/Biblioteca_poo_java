package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Periodico extends Material
{
	String primeraPlana, director, ciudad;
	int numPaginas;
	
	public Periodico (){
		super ();
		tipo="PERIODICO";
	}
	
	public Periodico (String tipo, String titulo, String fechaPublicacion, String primeraPlana, String director, 
		String ciudad, int numPaginas)
	{
		super (titulo, fechaPublicacion, tipo);
		this.primeraPlana=primeraPlana;
		this.director=director;
		this.ciudad=ciudad;
		this.numPaginas=numPaginas;
	}
	
	public String getPrimeraPlana(){
		return primeraPlana;
	}
	public String getDirector (){
		return director;
	}
	public String getCiudad (){
		return ciudad;
	}
	public int getNumPaginas (){
		return numPaginas;
	}
	
	public void setPrimeraPlana (String primeraPlana){
		this.primeraPlana=primeraPlana;
	}
	public void setDirector (String director){
		this.director=director;
	}
	public void setCiudad (String ciudad){
		this.ciudad=ciudad;
	}	
	public void setNumPaginas (int numPaginas){
		this.numPaginas=numPaginas;
	}	
	@Override
	public void pedirDatos(){
	Scanner leer= new Scanner(System.in);
	super.pedirDatosPadre();
	System.out.println ("Ingresa primera plana");
	primeraPlana=leer.nextLine();
	System.out.println ("Ingresa director ");
	director=leer.nextLine();
	System.out.println ("Ingresa ciudad");
	ciudad=leer.nextLine();
	System.out.println ("Ingresa numero de paginas");
	numPaginas=leer.nextInt();		
	}
	@Override
	public void mostrarDatos(){
		super.mostrarDatosPadre();
		System.out.println("Primera plana: "+getPrimeraPlana());
		System.out.println("Director: "+getDirector());
		System.out.println("Ciudad: "+getCiudad());
		System.out.println("Numero de paginas: "+getNumPaginas());
	}
	@Override
	public double cuantoCuesto(String tipo){
	if (tipo=="prestamo")
			return 0.0;
		else 
			return getNumPaginas()*2;
	}
	
	@Override
	public String guardarDatos()
	{
		String linea="PERIODICO,";
		linea+=titulo+","+fechaPublicacion+","+primeraPlana+",";
		linea+=director+","+ciudad+","+numPaginas;
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
		primeraPlana=tokens.nextToken();
		director=tokens.nextToken();
		ciudad=tokens.nextToken();
		numPaginas=Integer.parseInt(tokens.nextToken());
		String disponible=tokens.nextToken();
		switch(disponible){
			case "T":
			disponibilidad=true;
			break;
			case "F":
			disponibilidad=false;
			break;
		}
			
	}
	
}