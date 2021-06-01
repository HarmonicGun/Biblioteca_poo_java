package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Administrador extends Usuario
{
	private int movimientosAprobados;
	
	public Administrador(){
		super();
		permisoAdmin=true;
	}
	public Administrador(String nombre, String contrasena, int movimientosAprobados){
		this.nombre=nombre;
		this.contrasena=contrasena;
		this.movimientosAprobados=movimientosAprobados;
		permisoAdmin=true;
	}
	
	public int getMovimientosAprobados(){
		return movimientosAprobados;
	}
	public void setMovimientosAprobados (int movimientosAprobados){
		this.movimientosAprobados=movimientosAprobados;
	}
	
	@Override 
	public void pedirDatos(){
		pedirDatosPrincipal();
	}
	@Override
	public void mostrarDatos(){
		mostrarDatosPrincipal();
		System.out.println ("Movimientos aprobados: "+movimientosAprobados);
		
	}
	
	@Override
	public String guardarDatos(){
		String linea="T,";
		linea+=nombre+","+contrasena+","+movimientosAprobados;	
		return linea;
	}
	@Override 
	public void cargarDatos(StringTokenizer tokens){
		nombre=tokens.nextToken();
		contrasena=tokens.nextToken();
		movimientosAprobados=Integer.parseInt(tokens.nextToken());
	}
	@Override
	public void crecerMovimientos(){
		setMovimientosAprobados(getMovimientosAprobados()+1);		
	}
		
}