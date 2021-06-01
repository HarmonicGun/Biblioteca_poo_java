package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;

public abstract class Usuario implements Archivo
{
	protected String nombre, contrasena;
	protected boolean permisoAdmin;
	
	public Usuario (){
		permisoAdmin=false;
	}
	
	public Usuario (boolean permisoAdmin, String nombre, String contrasena){
		this. nombre= nombre;
		this. contrasena=contrasena;
		this. permisoAdmin= permisoAdmin;
	}
	
	public String getNombre(){
		return nombre;
	}
	public String getContrasena(){
		return contrasena;
	}
	public boolean getPermisoAdmin(){
		return permisoAdmin;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public void setContrasena(String contrasena){
		this.contrasena=contrasena;
	}
	public void setPermisoAdmin(boolean permisoAdmin){
		this.permisoAdmin=permisoAdmin;
	}
	public abstract void pedirDatos();
	public abstract void mostrarDatos();
	
	protected void pedirDatosPrincipal(){
		Scanner leer= new Scanner(System.in);
		System.out.println("Ingresa Usuario:");
		nombre=leer.nextLine();
		System.out.println("Ingresa contrasena");
		contrasena=leer.nextLine();
	}
	protected void mostrarDatosPrincipal(){
		System.out.println ("Nombre: "+getNombre());
		System.out.println ("Contrasena: "+getContrasena());
	}
	public abstract void crecerMovimientos();
	public abstract String guardarDatos();
	public abstract void cargarDatos(StringTokenizer tokens);
}