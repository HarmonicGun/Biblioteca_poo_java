package javaapplication5;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
public class Biblioteca
{
	private Material miMaterial []= new Material [1000];
	private Usuario usuarios []=new Usuario [100];
	private Bitacora miBitacora []= new Bitacora[1000];
	private int contMaterial,contUsuarios,contBitacora;
	
	private Scanner seleccion=new Scanner(System.in);

	public Biblioteca ()
	{
		usuarios[0]=new Administrador();
		contMaterial=0;
		contUsuarios=0;
		contBitacora=0;
		cargarMaterial();
		cargarUsuarios();
			if (usuarios[0].getNombre()==null){
				System.out.println ("NO EXISTE ADMINISTRADOR.CREA UNO\n");
			crearAdmin();}
		cargarBitacora();
		
	}
	
	public void verBitacora(){
		for (int i=0;i<contBitacora;i++){
			miBitacora[i].mostrarBitacora();
			System.out.println("------------------------------");
		}
		System.out.println ("\n\n");
	}
	public void verBitacora(String usuario){
		for (int i=0;i<contBitacora;i++){
			if ((miBitacora[i].getUsuario()).equals(usuario)){
			miBitacora[i].mostrarBitacora();
			System.out.println("------------------------------");
			}
		}
		System.out.println ("\n\n");
	}
	public void verBitacora (boolean estatus){
		for (int i=0;i<contBitacora;i++){
			if (!(miBitacora[i].getUsuario()).equals(usuarios[0].getNombre())){
			if (miBitacora[i].getEstatusAprobacion()==estatus){
			System.out.println("-----FOLIO: "+i+"-------------");
			miBitacora[i].mostrarBitacora();
			}
			}
		}
		System.out.println ("\n\n");
	
	}
	public boolean validarContrasena(String usuario, String contrasena){
		
		for (int i=0;i<contUsuarios;i++){
			if ((usuarios[i].getNombre()).equals(usuario)&&(usuarios[i].getContrasena()).equals(contrasena))
				return true;				
		}
		System.out.println ("\nCONTRASENA O USUARIO INVALIDOS\n");
		return false;
	}
	public boolean validarAdmin(String usuario){
		for (int i=0;i<contUsuarios;i++){
			if ((usuarios[i].getNombre()).equals(usuario))
				return usuarios[i].getPermisoAdmin();	
		}
		return false;
	}
		
	public void crearUsuario(){
		usuarios[contUsuarios++]=new Invitado();
		usuarios[contUsuarios-1].pedirDatos();
		crearBitacora(usuarios[contUsuarios-1].getNombre(),"creo cuenta","Ninguno",0);
			guardarUsuarios();
	}
	
	public void mostrarUsuarios(){
		
	for (int i=0; i<contUsuarios;i++){
				System.out.println ("Numero de registro: "+i);
				usuarios[i].mostrarDatos();
			System.out.println();
			}
	}	
	public void crearBitacora(String usuario, String movimiento, String material, double costo){
		System.out.println ("Ingresa fecha de hoy(dd/mm/aa)");
		String fecha=seleccion.nextLine();
		miBitacora[contBitacora++]=new Bitacora (usuario,movimiento,fecha,usuarios[0].getNombre(),material,costo,false);
		guardarBitacora();
	}
	
	public void crearAdmin(){
		usuarios[contUsuarios++]= new Administrador();
		usuarios[contUsuarios-1].pedirDatos();
		System.out.println("Nuevo administrador agregado\n");
		System.out.println ();
		guardarUsuarios();
	}
	
	//cargar y guardar usuarios
	private void cargarUsuarios(){
		BufferedReader entrada= null;
		StringTokenizer tokens;
		
		try{
			entrada = new BufferedReader(new FileReader("Usuarios.db"));
			String linea, campo;
			
			while ((linea=entrada.readLine())!=null)
			{
				tokens= new StringTokenizer (linea, ",");
				campo=tokens.nextToken();
				switch(campo){
					case "T":
					usuarios[contUsuarios++]=new Administrador();
					break;
					case "F":
					usuarios[contUsuarios++]=new Invitado();
					break;
				}
				usuarios[contUsuarios-1].cargarDatos(tokens);
			}
			
			entrada.close();
			} 
		catch(IOException e)
		{
			System.out.println(e.toString());
			
		}
	}
	public void guardarUsuarios(){
		PrintWriter salida = null;
		String linea;	
		try
		{
			salida = new PrintWriter(new FileWriter("Usuarios.db"));
			for(int i=0;i<contUsuarios;i++)
			{
				linea=usuarios[i].guardarDatos();
				salida.println(linea);
			}	
			salida.close();
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}		
	}
	//Cargar y guardar bitácora
	private void cargarBitacora(){
		BufferedReader entrada= null;
		StringTokenizer tokens;
		try{
			entrada = new BufferedReader(new FileReader("Bitacoras.db"));
			String linea;
			while ((linea=entrada.readLine())!=null)
			{
				tokens= new StringTokenizer (linea, ",");
				miBitacora[contBitacora++]= new Bitacora();
				miBitacora[contBitacora-1].cargarDatos(tokens);
			}
			entrada.close();
			} 
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
	}
	public void guardarBitacora(){
		PrintWriter salida = null;
		String linea;	
		try
		{
			salida = new PrintWriter(new FileWriter("Bitacoras.db"));
			for(int i=0;i<contBitacora;i++)
			{
				linea=miBitacora[i].guardarDatos();
				salida.println(linea);
			}	
			salida.close();
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}		
	}
	
	//cargar y guardar MATERIAL
	private void cargarMaterial() {
		BufferedReader entrada = null;
		StringTokenizer tokens;
        try 
		{
			entrada = new BufferedReader(new FileReader("material.db"));
			String linea,campo;
			while ((linea = entrada.readLine()) != null) 
			{
				tokens = new StringTokenizer(linea, ",");
				campo = tokens.nextToken();
				switch(campo)
				{
					case "LIBRO":
						miMaterial[contMaterial++]=new Libro();
						break;
					case "PERIODICO":
						miMaterial[contMaterial++]=new Periodico();
						break;
					case "REVISTA":
						miMaterial[contMaterial++]=new Revista();
						break;
					case "TESIS":
						miMaterial[contMaterial++]=new Tesis();
						break;
					case "VIDEO":
						miMaterial[contMaterial++]=new Video();
						break;
				}
				miMaterial[contMaterial-1].cargarDatos(tokens);
			}
			entrada.close();
		} 
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
	}
	
	public void guardarMaterial(){
		PrintWriter salida = null;
		String linea;	
		try
		{
			salida = new PrintWriter(new FileWriter("material.db"));
			for(int i=0;i<contMaterial;i++)
			{
				linea=miMaterial[i].guardarDatos();
				salida.println(linea);
			}	
			salida.close();
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}		
	}
		
	public void mostrarMaterial(){
	System.out.println ("\n\n--------------------Libros--------------------\n");
	for (int i=0; i<contMaterial;i++){
			if (miMaterial[i].getTipo()=="LIBRO"){
				System.out.println ("Numero de registro "+i);
				miMaterial [i].mostrarDatos();
			System.out.println();
			}
	}		
	System.out.println ("\n\n--------------------Revistas--------------------\n");
	for(int i=0; i<contMaterial;i++){
			if (miMaterial[i].getTipo()=="REVISTA"){
				System.out.println ("numero de registro "+i);
				miMaterial [i].mostrarDatos();
			System.out.println();	
		}
	}
	System.out.println ("\n\n--------------------Videos--------------------\n");
	for(int i=0; i<contMaterial;i++){
			if (miMaterial[i].getTipo()=="VIDEO"){
				System.out.println ("numero de registro "+i);
				miMaterial [i].mostrarDatos();
			System.out.println();
		}
	}
	System.out.println ("\n\n--------------------Periodicos--------------------\n");
	for(int i=0; i<contMaterial;i++){
			if (miMaterial[i].getTipo()=="PERIODICO"){
				System.out.println ("numero de registro "+i);
				miMaterial [i].mostrarDatos();
			System.out.println();
		}
	}
	System.out.println ("\n\n--------------------Tesis--------------------\n");
	for(int i=0; i<contMaterial;i++){
			if (miMaterial[i].getTipo()=="TESIS"){
				System.out.println ("numero de registro "+i);
				miMaterial [i].mostrarDatos();
			System.out.println();	
		}
	}
	}
	
	public void mostrarMaterial (String tipo){
		
		for(int i=0; i<contMaterial;i++){
			if ((miMaterial[i].getTipo()).equals(tipo)){
				System.out.println ("numero de registro "+i);
				miMaterial [i].mostrarDatos();
			System.out.println();
		}
	}
	}
	public void mostrarMaterial (boolean disponibilidad){
			for(int i=0; i<contMaterial;i++){
			if (miMaterial[i].getDisponibilidad()==disponibilidad){
				System.out.println ("numero de registro "+i);
				miMaterial [i].mostrarDatos();
			System.out.println();
		}
	}
	}
	public String prestarMaterial (){
		String opcion;
		int col;
		
		System.out.println("\n                   Prestar...\n");
		System.out.println("  [1]Todo  [2]Libros  [3]Revistas [4]Videos [5]Periodicos  [6]Tesis\n");	
		System.out.println("                    [x]salir");
		opcion=seleccion.nextLine();
			switch(opcion){
					case "1":mostrarMaterial();break;
					case "2":mostrarMaterial("LIBRO");break;
					case "3":mostrarMaterial("REVISTA");break;
					case "4":mostrarMaterial("VIDEO");break;
					case "5":mostrarMaterial("PERIODICO");break;
					case "6":mostrarMaterial("TESIS");break;
					default: 
					opcion="x";break;
					}
		//seleccionar 
		System.out.println ("\n                    Escribe el numero de serie para prestamo");
		col= seleccion.nextInt();
			seleccion.nextLine();
		//modificar su disponibilidad
		miMaterial[col].setDisponibilidad (false);
		System.out.println ("\n                    Prestamo registrado");
		return miMaterial[col].getTitulo();
		
	}
	public String devolverMaterial (){
		int opcion;
		
		System.out.println ("Ingresa el numero de serie a devolver");
		opcion= seleccion.nextInt();		
		//modificar su disponibilidad
		miMaterial[opcion].setDisponibilidad (true);
		return miMaterial[opcion].getTitulo();
	}
	public String agregarMaterial (){
		int opcion;
		System.out.println("Que tipo de material deseas agregar? \n1.-Libro \n2.-Revista \n3.-Video \n4.-Periodico \n5.-Tesis");
		opcion= seleccion.nextInt();
			seleccion.nextLine();
		switch (opcion){
			case 1:
			Libro miLibro= new Libro();
			miMaterial[contMaterial++]=miLibro;
			break;
			case 2:
			Revista miRevista= new Revista();
			miMaterial[contMaterial++]=miRevista;
			break;
			case 3:
			Video miVideo= new Video();
			miMaterial[contMaterial++]=miVideo;
			break;
			case 4:
			Periodico miPeriodico= new Periodico();
			miMaterial[contMaterial++]=miPeriodico;
			break;
			case 5:
			Tesis miTesis= new Tesis();
			miMaterial[contMaterial++]=miTesis;
			break;
		}
			miMaterial [contMaterial-1].pedirDatos();
			System.out.println ("Material agregado con exito/n");
			guardarMaterial();
			return miMaterial[contMaterial-1].getTitulo();
	}	
	
	public void buscarMaterial(){
		int coincidencia=0,palabrasProb=0,palabrasBus,mayor=0, resul1=0, cont=0, iBus,iProb;
		String probable="",buscado="",palabra1="", palabra2="";
		Scanner busqueda= new Scanner(System.in);
		StringTokenizer objetoBuscado;
		StringTokenizer objetoProbable;
		buscado= busqueda.nextLine();
		
		
		for(cont=0; cont<contMaterial;cont++){
			probable= miMaterial [cont].getTitulo();
			objetoBuscado=new StringTokenizer(buscado);
			palabrasBus=objetoBuscado.countTokens();
			
			for (iBus=0;iBus<palabrasBus;iBus++){
					palabra1=objetoBuscado.nextToken();
					objetoProbable=new StringTokenizer(probable);
					palabrasProb=objetoProbable.countTokens();
			
				for (iProb=0;iProb<palabrasProb;iProb++){
					palabra2=objetoProbable.nextToken();
					if (palabra1.equalsIgnoreCase(palabra2))
					coincidencia++;
				}
			}
			if (coincidencia>mayor){
				mayor=coincidencia;
				resul1=cont;
			}
			
			coincidencia=0;
			
		}
				System.out.println ("La mejor coincidencia es: "+miMaterial [resul1].getTitulo()+" que es un "+miMaterial[resul1].getTipo());
				if (miMaterial[resul1].getDisponibilidad())
					System.out.println ("ESTATUS: disponible");
					
				else
					System.out.println ("ESTATUS: no disponible");
									
	}
	public void buscarMaterial(String tipo){
		int coincidencia=0,palabrasProb=0,palabrasBus,mayor=0, resul1=0, cont=0, iBus,iProb;
		String probable="",buscado="",palabra1="", palabra2="";
		Scanner busqueda= new Scanner(System.in);
		StringTokenizer objetoBuscado;
		StringTokenizer objetoProbable;
		buscado= busqueda.nextLine();
		
		
		for(cont=0; cont<contMaterial;cont++){
			if ((miMaterial[cont].getTipo()).equals(tipo)){
			probable= miMaterial [cont].getTitulo();
			objetoBuscado=new StringTokenizer(buscado);
			palabrasBus=objetoBuscado.countTokens();
			
			for (iBus=0;iBus<palabrasBus;iBus++){
					palabra1=objetoBuscado.nextToken();
					objetoProbable=new StringTokenizer(probable);
					palabrasProb=objetoProbable.countTokens();
			
				for (iProb=0;iProb<palabrasProb;iProb++){
					palabra2=objetoProbable.nextToken();
					if (palabra1.equalsIgnoreCase(palabra2))
					coincidencia++;
				}
			}
			if (coincidencia>mayor){
				mayor=coincidencia;
				resul1=cont;
			}
			}
			coincidencia=0;
			
		}
				System.out.println ("La mejor coincidencia es: "+miMaterial [resul1].getTitulo()+" que es un "+miMaterial[resul1].getTipo());
				if (miMaterial[resul1].getDisponibilidad())
					System.out.println ("ESTATUS: disponible");
					
				else
					System.out.println ("ESTATUS: no disponible");
									
	}
	public void prestarMaterial (String material){
	 for (int i=0; i<contMaterial; i++){
	 if ((miMaterial[i].getTitulo()).equals(material)){
		 miMaterial[i].setDisponibilidad(false);
		break;
	 }
	 }
	}
	public void solicitarServicio(String usuario){
		System.out.println ("\n                    Elige el tipo de servicio\n\n");
		System.out.println ("\n        [1]Prestamo de material   [2]Solicitar copia del material\n");
		System.out.println ("\n                            [x]Salir\n");
		
		String opcion=seleccion.nextLine();
		switch (opcion){
			case "1":
				mostrarMaterial(true);
				System.out.println ("\n                    Elige el numero de registro para el prestamo\n\n");
				opcion=seleccion.nextLine();
					if (miMaterial[Integer.parseInt(opcion)].cuantoCuesto("prestamo")!=0.0){
					System.out.println ("\n                    El costo del prestamo es de: "+
								miMaterial[Integer.parseInt(opcion)].cuantoCuesto("prestamo")+" pesos");
								
				int elegido=Integer.parseInt(opcion);
				System.out.println ("\n                    solicitar prestamo?\n");
				System.out.println ("\n                    [1]si          [2]no\n");
				opcion=seleccion.nextLine();
				
					switch (opcion){
						case "1":
						crearBitacora(usuario,"solicito prestamo",miMaterial[elegido].getTitulo(),miMaterial[Integer.parseInt(opcion)].cuantoCuesto("prestamo"));
						System.out.println ("\n          Su solicitud sera revisada por el administrador y, una vez aprobada\n" +
						"          en su bitacora personal, sera hecho el envio \n\n");
						break;
						default:
						break;
					}}
					else 
						System.out.println("\n                     No es posible el prestamo de periodicos o tesis\n");
						
				break;
			case "2":
				mostrarMaterial(true);
				System.out.println ("\n                    Elige el numero de registro para la copia\n\n");
				opcion=seleccion.nextLine();
				System.out.println ("\n                    El costo del prestamo es de: "+
								miMaterial[Integer.parseInt(opcion)].cuantoCuesto("copia")+" pesos");
				int elegido=Integer.parseInt(opcion);
				System.out.println ("\n                    solicitar copia?\n");
				System.out.println ("\n                    [1]si          [2]no\n");
				opcion=seleccion.nextLine();
					if (opcion=="1")
						crearBitacora(usuario,"solicito copia", miMaterial[elegido].getTitulo(),miMaterial[Integer.parseInt(opcion)].cuantoCuesto("copia"));
					else 
						break;
				System.out.println ("\n          Su solicitud sera revisada por el administrador y, una vez aprobada\n" +
				"          en su bitacora personal, sera hecho el envio \n\n");
				break;
			default:
				opcion="x";
				break;
		}
			
	}
	public void aprobarServicio(String usuario){
		String opcion;
			System.out.println("                    SERVICIOS POR APROBAR\n\n");
			verBitacora(false);
			System.out.println("           Escribe numero de folio de servicio a aprobar");
			System.out.println("                                                                        salir [x]");
			opcion=seleccion.nextLine();
			switch (opcion){
				case "x":
					break;
				case "X":
				default:
					int col=Integer.parseInt(opcion);
				miBitacora[col].setEstatusAprobacion(true);
				
				String respuesta= miBitacora[col].getMovimiento();
				switch (respuesta){
					case "solicito prestamo":
					prestarMaterial (miBitacora[col].getMaterial());
					System.out.println("\n           Aprobacion registrada con exito\n\n");
					crearBitacora(usuario,"aprobo movimiento",miBitacora[Integer.parseInt(opcion)].getMaterial(),0);
					crecerMovimientos(usuario, miBitacora[Integer.parseInt(opcion)].getUsuario());
					guardarUsuarios();
					guardarMaterial();
					opcion="";
					break;
					case "solicito copia":
					System.out.println("\n           Aprobacion registrada con exito\n\n");
					crearBitacora(usuario,"aprobo movimiento",miBitacora[Integer.parseInt(opcion)].getMaterial(),0);
					crecerMovimientos(usuario, miBitacora[Integer.parseInt(opcion)].getUsuario());
					guardarUsuarios();
					guardarMaterial();
					opcion="";
					break;
					case "creo cuenta":
					System.out.println("\n           Aprobacion registrada con exito\n\n");
					guardarBitacora();
					break;
				}
			}
			
		}
	
	
	public void crecerMovimientos(String admin,String invitado){
	
	for (int i=0; i<contUsuarios;i++){
		if ((usuarios[i].getNombre()).equals(admin)){
			usuarios[i].crecerMovimientos();
		break;}
	}
	for (int i=0; i<contUsuarios;i++){
		if ((usuarios[i].getNombre()).equals(invitado)){
			usuarios[i].crecerMovimientos();
		break;}
	}
	}		
}