package javaapplication5;
import java.util.Scanner;
public class ApBiblioteca{
	
	public static void main (String []args){
	String opcion;
	Scanner leer= new Scanner (System.in);
	Biblioteca miBiblioteca=new Biblioteca();
	
	do{
	
	System.out.println("\n                   BIENVENIDO\n");
	System.out.println("                    [1]Ingresar");
	System.out.println("                    [2]Crear usuario");
	System.out.println("                    [x]Salir");
	opcion=leer.nextLine();
		switch(opcion){
			case "1":
				System.out.println ("USUARIO:");	
				String usuario=leer.nextLine();
				System.out.println ("CONTRASENA");
				String contrasena=leer.nextLine();
					if(miBiblioteca.validarContrasena(usuario,contrasena)){
						if (miBiblioteca.validarAdmin(usuario)){
							do {
								System.out.println("\n                   BIENVENIDO ADMINISTRADOR\n");
								System.out.println("                    Que deseas hacer?");
								System.out.println("                    [1]Mostrar material");
								System.out.println("                    [2]Agregar material");
								System.out.println("                    [3]Buscar material");
								System.out.println("                    [4]Devolver material");
								System.out.println("                    [5]Prestar material");
								System.out.println("                    [6]Aprobar servicio");
								System.out.println("                    [7]Ver bitacora de usuarios");
								System.out.println("                    [x]Salir");
								opcion=leer.nextLine();
								switch(opcion){
									case "1":
									System.out.println("\n                   Mostrar...\n");
									System.out.println("  [1]Todo  [2]Libros  [3]Revistas [4]Videos [5]Periodicos  [6]Tesis\n");
									System.out.println("                    [x]salir");
										opcion=leer.nextLine();
										switch(opcion){
											case "1":miBiblioteca.mostrarMaterial();break;
											case "2":miBiblioteca.mostrarMaterial("LIBRO");break;
											case "3":miBiblioteca.mostrarMaterial("REVISTA");break;
											case "4":miBiblioteca.mostrarMaterial("VIDEO");break;
											case "5":miBiblioteca.mostrarMaterial("PERIODICO");break;
											case "6":miBiblioteca.mostrarMaterial("TESIS");break;
											default: 
												opcion="x";break;
										}
									break;
									case "2":
									
									miBiblioteca.crearBitacora(usuario,"agrego material",miBiblioteca.agregarMaterial(),0);
									break;
									case "3":
									System.out.println("\n                   Buscar en...\n");
									System.out.println("  [1]Todo  [2]Libros  [3]Revistas [4]Videos [5]Periodicos  [6]Tesis\n");
									System.out.println("                    [x]salir");
										opcion=leer.nextLine();
										switch(opcion){
											case"1":miBiblioteca.buscarMaterial();break;
											case"2":miBiblioteca.buscarMaterial("LIBRO");break;
											case"3":miBiblioteca.buscarMaterial("REVISTA");break;
											case"4":miBiblioteca.buscarMaterial("VIDEO");break;
											case"5":miBiblioteca.buscarMaterial("PERIODICO");break;
											case"6":miBiblioteca.buscarMaterial("TESIS");break;
											default: opcion="x";break;
										}
									break;
									case "4":
										
										miBiblioteca.crearBitacora(usuario,"devolvio material",miBiblioteca.devolverMaterial(),0);
									break;
									case "5":
									
										miBiblioteca.crearBitacora(usuario,"presto material",miBiblioteca.prestarMaterial(),0);
									break;
									case "6":
										miBiblioteca.aprobarServicio(usuario);
										//aqui es donde suben los movimientos aprobados y realizados
									break;
									case "7":
										miBiblioteca.verBitacora();
									break;
									default:
									opcion="x";
									break;
								}
							}while (opcion!="x");
						}
						else {
							do {
								System.out.println("\n                    BIENVENIDO INVITADO\n");
								System.out.println("                    Que deseas hacer?");
								System.out.println("                    [1]Mostrar material");
								System.out.println("                    [2]Buscar material");
								System.out.println("                    [3]Solicitar servicio");
								System.out.println("                    [4]Devolver material");
								System.out.println("                    [5]Ver bitacora de usuario");
								System.out.println("                    [x]Salir");
								opcion=leer.nextLine();
								switch(opcion){
									case "1":
									System.out.println("\n                   Mostrar...\n");
									System.out.println("  [1]Todo  [2]Libros  [3]Revistas [4]Videos [5]Periodicos  [6]Tesis\n");
									System.out.println("                    [x]salir");
										opcion=leer.nextLine();
										switch(opcion){
											case "1":miBiblioteca.mostrarMaterial();break;
											case "2":miBiblioteca.mostrarMaterial("LIBRO");break;
											case "3":miBiblioteca.mostrarMaterial("REVISTA");break;
											case "4":miBiblioteca.mostrarMaterial("VIDEO");break;
											case "5":miBiblioteca.mostrarMaterial("PERIODICO");break;
											case "6":miBiblioteca.mostrarMaterial("TESIS");break;
											default: 
												opcion="x";break;
										}
									break;
									case "2":
									System.out.println("\n                   Buscar en...\n");
									System.out.println("  [1]Todo  [2]Libros  [3]Revistas [4]Videos [5]Periodicos  [6]Tesis\n");
									System.out.println("                    [x]salir");
										opcion=leer.nextLine();
										switch(opcion){
											case"1":miBiblioteca.buscarMaterial();break;
											case"2":miBiblioteca.buscarMaterial("LIBRO");break;
											case"3":miBiblioteca.buscarMaterial("REVISTA");break;
											case"4":miBiblioteca.buscarMaterial("VIDEO");break;
											case"5":miBiblioteca.buscarMaterial("PERIODICO");break;
											case"6":miBiblioteca.buscarMaterial("TESIS");break;
											default: opcion="x";break;
										}
									break;
									case "3":
										miBiblioteca.solicitarServicio(usuario);
									break;
									case "4":
										miBiblioteca.crearBitacora(usuario,"devolvio material",miBiblioteca.devolverMaterial(),0);
									break;
									case "5":
										miBiblioteca.verBitacora(usuario);
									break;
									default:
									opcion="x";
									break;
								}
							}while (opcion!="x");
						}
					}
				break;
			case"2":
				miBiblioteca.crearUsuario();
				break;
			default:
				opcion="x";
				break;
		}				
	}while (opcion!="x");
	
	}
}