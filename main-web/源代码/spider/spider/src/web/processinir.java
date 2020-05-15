package web;

import java.rmi.Remote;
import java.rmi.RemoteException;

public  interface processinir  extends Remote{
	 void init(int SleepTime,int RetryTimes,int  CycleRetryTimes,int pag,int type,int maxcount) throws RemoteException;
	 void run() throws RemoteException;
	 void savechange() throws RemoteException;
	 int getSleepTime() throws RemoteException;

	 void setSleepTime(int sleepTime) throws RemoteException;

	 int getRetryTimes() throws RemoteException;

	 void setRetryTimes(int retryTimes) throws RemoteException;

	 int getCycleRetryTimes() throws RemoteException;

	 void setCycleRetryTimes(int cycleRetryTimes) throws RemoteException;



	 int getPag() throws RemoteException;

	 void setPag(int pag) throws RemoteException;

	 int getType() throws RemoteException;

	 void setType(int type) throws RemoteException;

	 int getMaxcount() throws RemoteException;

	 void setMaxcount(int maxcount) throws RemoteException;
}
