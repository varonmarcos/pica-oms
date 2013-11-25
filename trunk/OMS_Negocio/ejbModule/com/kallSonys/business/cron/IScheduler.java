package com.kallSonys.business.cron;

import javax.ejb.Remote;



@Remote
public interface IScheduler {

	
	public void startUpTimer();
	public void shutDownTimer();
}
