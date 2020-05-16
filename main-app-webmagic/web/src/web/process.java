package web;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import com.jdbcsql.manager;
import com.mainmethod.rethread;

public class process extends UnicastRemoteObject implements processinir{
	private int SleepTime=100;
	private int RetryTimes=110;
	private int CycleRetryTimes=100;
	private int pag=10;
	private int type=1;
	private int maxcount=100;
	private String url="";
	REPrecess git;
	rethread th=new rethread();
	public String getUrl()  throws RemoteException{
		return url;
	}
	public void setUrl(String url)  throws RemoteException{
		this.url = url;
	}
	public int getthtime() throws RemoteException{
		return th.getTime();
	}
	public void setthtime(int time) throws RemoteException{
		th.setTime(time);
	}
	public int getthmax() throws RemoteException{
		return th.getMax();
	}
	public void setthmax(int max) throws RemoteException{
		th.setMax(max);
	}
	public process() throws RemoteException {
		super();
		th.start();
		// TODO Auto-generated constructor stub
	}

	public void init(String url,int SleepTime, int RetryTimes, int CycleRetryTimes, int pag, int type, int maxcount) throws RemoteException{
		// TODO Auto-generated method stub
		setCycleRetryTimes(CycleRetryTimes);
		setSleepTime(SleepTime);
		setPag(pag);
		setType(type);
		setMaxcount(maxcount);
		setRetryTimes(RetryTimes);
		setUrl(url);
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
		return git.getcon();
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
		git=new REPrecess();
		git.run(url,SleepTime, RetryTimes, CycleRetryTimes, pag, type, maxcount);
	}

	public void savechange() throws RemoteException{
		// TODO Auto-generated method stub
		manager.save(this);
	}

}
