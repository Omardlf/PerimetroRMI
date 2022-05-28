package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PerimetroInterfaz_Servidor extends Remote {
	public int Perimetro(int distancia, int lados) throws RemoteException;
}