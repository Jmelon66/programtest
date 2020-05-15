package web;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import com.jdbcsql.manager;

public class process extends UnicastRemoteObject implements processinir{
	private int SleepTime=100;
	private int RetryTimes=110;
	private int CycleRetryTimes=100;
	private int pag=10;
	private int type=3;
	private int maxcount=100;
	

	public process() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(int SleepTime, int RetryTimes, int CycleRetryTimes, int pag, int type, int maxcount) throws RemoteException{
		// TODO Auto-generated method stub
		setCycleRetryTimes(CycleRetryTimes);
		setSleepTime(SleepTime);
		setPag(pag);
		setType(type);
		setMaxcount(maxcount);
		setRetryTimes(RetryTimes);
	}

	public int getSleepTime() throws RemoteException{
		return SleepTime;
	}

	public void setSleepTime(int sleepTime) throws RemoteException{
		SleepTime = sleepTime;
	}

	public int getRetryTimes() throws RemoteException{
		return RetryTimes;
	}

	public void setRetryTimes(int retryTimes) throws RemoteException{
		RetryTimes = retryTimes;
	}

	public int getCycleRetryTimes() throws RemoteException{
		return CycleRetryTimes;
	}

	public void setCycleRetryTimes(int cycleRetryTimes) throws RemoteException{
		CycleRetryTimes = cycleRetryTimes;
	}



	public int getPag() throws RemoteException{
		return pag;
	}

	public void setPag(int pag) throws RemoteException{
		this.pag = pag;
	}

	public int getType() throws RemoteException{
		return type;
	}
	public void setType(int type) throws RemoteException{
		this.type = type;
	}
	public int getMaxcount() throws RemoteException{
		return maxcount;
	}
	public void setMaxcount(int maxcount) throws RemoteException{
		this.maxcount = maxcount;
	}
	public void run() throws RemoteException{
		// TODO Auto-generated method stub
		REPrecess git=new REPrecess();
		git.run(SleepTime, RetryTimes, CycleRetryTimes, pag, type, maxcount);
	}

	public void savechange() throws RemoteException{
		// TODO Auto-generated method stub
		manager.save(this);
	}

}
