package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bitacora implements Archivo
{
	private String usuario,movimiento,fecha, aprobacion, material;
	private double costo;
	private boolean estatusAprobacion; 
	
	public Bitacora (){
	}
	public Bitacora(String usuario,String movimiento, String fecha, String aprobacion, String material,
		double costo, boolean estatusAprobacion){
		this.usuario=usuario;
		this.movimiento=movimiento;
		this.fecha=fecha;
		this.aprobacion=aprobacion;
		this.material=material;
		this.costo=costo;
		this.estatusAprobacion=estatusAprobacion;
		}
		
	//GETTERS
	public String getUsuario(){
		return usuario;
	}
	public String getMovimiento (){
		return movimiento;
	}
	public String getFecha(){
		return fecha;
	}
	public String getAprobacion(){
		return aprobacion;
	}
	public String getMaterial(){
		return material;
	}
	
	public double getCosto(){
		return costo;
	}
	public boolean getEstatusAprobacion(){
		return estatusAprobacion;
	}
	//SETTERS
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}
	public void setMovimiento(String movimiento){
		this.movimiento=movimiento;
	}
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public void setAprobacion(String aprobacion){
		this.aprobacion=aprobacion;
	}
	public void setMaterial(String material){
		this. material=material;
	}
		
	public void setCosto(float costo){
		this.costo=costo;
	}
	public void setEstatusAprobacion(boolean estatusAprobacion){
		this.estatusAprobacion=estatusAprobacion;
	}
	
	public void mostrarBitacora (){
		System.out.println("Usuario: "+getUsuario());
		System.out.println("Movimiento: "+getMovimiento());
		System.out.println("Fecha: "+getFecha());
		System.out.println("Material: "+getMaterial());
		System.out.println("Costo: "+getCosto());
		if (getEstatusAprobacion())
			System.out.println("Movimiento aprobado por "+aprobacion);
		else 
			System.out.println("Sin aprobacion");
	}
	
	
	@Override
	public String guardarDatos(){
		String linea="";
		if (estatusAprobacion)
			linea="AP,";
		else 
			linea="NAP,";
		linea+=usuario+","+movimiento+","+fecha+","+material+","+aprobacion+","+costo;
		return linea;
	}
	@Override
	public void cargarDatos(StringTokenizer tokens){
		String campo=tokens.nextToken();
		switch (campo){
			case "AP":
			estatusAprobacion=true;
			break;
			case "NAP":
			estatusAprobacion=false;
			break;
		}
		usuario=tokens.nextToken();	
		movimiento=tokens.nextToken();
		fecha=tokens.nextToken();
		material=tokens.nextToken();
		aprobacion=tokens.nextToken();
		costo=Float.parseFloat(tokens.nextToken());
	}
	
}