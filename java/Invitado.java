package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Invitado extends Usuario
{
	private int cantMovimientos;
	private String fechaAlta;
	
	public Invitado(){
		super();
		permisoAdmin=false;
	}
	public Invitado(String nombre, String contrasena, int cantMovimientos){
		this.nombre=nombre;
		this.contrasena=contrasena;
		this.cantMovimientos=cantMovimientos;
		permisoAdmin=false;
	}
	
	public int getCantMovimientos(){
		return cantMovimientos;
	}
	public String getFechaAlta(){
		return fechaAlta;
	}
	
	public void setCantMovimientos (int cantMovimientos){
		this.cantMovimientos=cantMovimientos;
	}
	
	public void setFechaAlta(String fechaAlta){
		this.fechaAlta=fechaAlta;
	}
	
	@Override 
	public void pedirDatos(){
		Scanner leer= new Scanner (System.in);
		pedirDatosPrincipal();
		System.out.println("Ingresa la fecha con formato DD/MM/AA");
		fechaAlta=leer.nextLine();
	}
	@Override
	public void mostrarDatos(){
		mostrarDatosPrincipal();
		System.out.println ("Movimientos realizados: "+cantMovimientos);
		System.out.println ("Fecha de alta: "+fechaAlta);
		
		
	}
	
	@Override
	public String guardarDatos(){
		String linea="F,";
		linea+=nombre+","+contrasena+","+fechaAlta+","+cantMovimientos;	
		return linea;
	}
	@Override 
	public void cargarDatos(StringTokenizer tokens){
		nombre=tokens.nextToken();
		contrasena=tokens.nextToken();
		fechaAlta=tokens.nextToken();
		cantMovimientos=Integer.parseInt(tokens.nextToken());
	}
	@Override
	public void crecerMovimientos(){
		setCantMovimientos(getCantMovimientos()+1);		
	}
}