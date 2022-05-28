package Servidor;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.PerimetroInterfaz_Servidor;

public class ServidorMain extends UnicastRemoteObject
	implements PerimetroInterfaz_Servidor{
	
	// Declaracion de las variables globales
	private final static int PUERTO = 9090;
	
	// Constructor de la clase ServidorMain
	public ServidorMain() throws RemoteException {
		super();
	}
	
	// Funciones del servidor que implementaran las funciones de la interfaz
	public int Perimetro(int distancia, int lados) {
		int res = distancia * lados;
		return res;
	}

	// Funcion para inicial el servidor
	public void IniciarServidor() {
		try {
			String LocalIP = (InetAddress.getLocalHost()).toString(); // Obtenemos la Direccion IP de la maquina
			System.out.println("Escuchando en ..."+LocalIP+" en el puerto "+PUERTO);
			// En la siguiente linea se obtiene el registro de la interfaz que es la ubicacion y 
			// aquello que se realizara.
			Registry registro = LocateRegistry.createRegistry(PUERTO);
			registro.bind("Perimetro", (PerimetroInterfaz_Servidor) this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// funcion Main
	public static void main(String[] args) throws Exception {
		/*
		 * En esta ocacion en lugar de generar una funcion que inicie el servidor
		 * iniciare el servidor desde la funcion main
		 * */
		/*
		try {
			String LocalIP = (InetAddress.getLocalHost()).toString(); // Obtenemos la Direccion IP de la maquina
			System.out.println("Escuchando en ..."+LocalIP+" en el puerto "+PUERTO);
			// En la siguiente linea se obtiene el registro de la interfaz que es la ubicacion y 
			// aquello que se realizara.
			Registry registro = LocateRegistry.createRegistry(PUERTO);
			registro.bind("Perimetro", (PerimetroInterfaz_Servidor) this);
		} catch (Exception e) {
			e.printStackTrace();
		} */
		
		//--------------------------------------------------------------
		// No funciona una de las partes de ejecucion del servidor, la parte que genera la palabra clave para la ejecucion de la interfaz
    	(new ServidorMain()).IniciarServidor(); 
	}

}