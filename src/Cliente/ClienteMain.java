package Cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Interfaces.PerimetroInterfaz_Servidor;

public class ClienteMain {

	public static void main(String[] args) {
		
		String IPAdd = "localhost";
    	int SrvPort = 9090;
        int res = 0;
        int distancia = 4;
        int lados = 2;
        
        try{
            Registry registry = LocateRegistry.getRegistry(IPAdd,SrvPort);
            PerimetroInterfaz_Servidor servidorObj = (PerimetroInterfaz_Servidor) registry.lookup("Perimetro");
            res = servidorObj.Perimetro(distancia,lados);
            System.out.println("El perimetro de la figura de "+lados+" lados y "+distancia+" unidades de distancia es "+res);
        }catch (RemoteException | NotBoundException e){
            e.printStackTrace();
        }
	}
}