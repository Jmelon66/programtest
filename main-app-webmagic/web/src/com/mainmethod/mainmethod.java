package com.mainmethod;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import web.process;
import web.processinir;

public class mainmethod {
	public static void main(String[] args) {
		String port = "12";
		String host = "127.0.0.1";
		 System.out.println("1");
		    try {
		    	processinir facade = new process();
				LocateRegistry.createRegistry(12);
				Naming.rebind("rmi://" +
			    		host + ":" +
			    		port +
		                 "/processFacade",facade);
			    System.out.println("Service Bound...");

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
}
