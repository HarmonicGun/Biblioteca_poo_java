package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;

public abstract class Material implements Archivo
{
	protected String titulo;
	protected String fechaPublicacion;
	protected boolean disponibilidad;
	protected String tipo;
	
	public Material (){
	disponibilidad=true;
	
	}
	public Material (String titulo, String fechaPublicacion,String tipo)
	{
	this. titulo=titulo;
	this. fechaPublicacion=fechaPublicacion;
	disponibilidad=true;
	this.tipo=tipo;
	}
	
	public String getTitulo (){
		return titulo;
	}
	public String getFechaPublicacion(){
		return fechaPublicacion;
	}
	public boolean getDisponibilidad(){
		return disponibilidad;
	}
	public String getTipo (){
		return tipo;
	}
	
	public void setTitulo (String titulo){
		this.titulo=titulo;
	}
	public void setFechaPublicacion(String fechaPublicacion){
		this.fechaPublicacion=fechaPublicacion;
	}
	public void setDisponibilidad (boolean disponibilidad){
		this.disponibilidad=disponibilidad;
	}
	public void setTipo (String tipo){
		this.tipo=tipo;
	}
	
	public abstract void pedirDatos();
	
	protected void pedirDatosPadre(){
	Scanner leer= new Scanner(System.in);
	System.out.println ("Ingresa titulo");
	titulo= leer.nextLine();
	System.out.println ("Ingresa fecha publicacion");
	fechaPublicacion= leer.nextLine();
	}
	
	public abstract void mostrarDatos();
	
	protected void mostrarDatosPadre(){
		if (disponibilidad)
			System.out.println ("DISPONIBLE");
		else 
			System.out.println ("NO DISPONIBLE");
		System.out.println ("Titulo: "+getTitulo());
		System.out.println ("Fecha de publicacion: "+getFechaPublicacion());
	}

	public abstract double cuantoCuesto(String tipo);
	
	public abstract String guardarDatos();
	public abstract void cargarDatos(StringTokenizer tokens);
	

	}