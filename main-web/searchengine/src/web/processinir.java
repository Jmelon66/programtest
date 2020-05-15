package web;

import java.rmi.Remote;
import java.rmi.RemoteException;

public  interface processinir  extends Remote{
	 void init(String url,int SleepTime,int RetryTimes,int  CycleRetryTimes,int pag,int type,int maxcount) throws RemoteException;
	 void run() throws RemoteException;
	 void savechange() throws RemoteException;
	 int getSleepTime() throws RemoteException;
	 void setSleepTime(int sleepTime) throws RemoteException;

	 int getRetryTimes() throws RemoteException;

		public String getUrl()  throws RemoteException;

		public void setUrl(String url)  throws RemoteException;
	 void setRetryTimes(int retryTimes) throws RemoteException;

	 int getCycleRetryTimes() throws RemoteException;

	 void setCycleRetryTimes(int cycleRetryTimes) throws RemoteException;



	 int getPag() throws RemoteException;

	 void setPag(int pag) throws RemoteException;

	 int getType() throws RemoteException;

	 void setType(int type) throws RemoteException;

	 int getMaxcount() throws RemoteException;

	 void setMaxcount(int maxcount) throws RemoteException;
		public int getthtime() throws RemoteException;
		public void setthtime(int time) throws RemoteException;
		
		public int getthmax() throws RemoteException;
		public void setthmax(int max) throws RemoteException;
}
