package com.kallSonys.business.cron;


import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;


@Stateless(name="cronBean", mappedName = "cronBean")
@Remote(IScheduler.class)
public class CronUpdateOrdersProcess implements IScheduler {

    
	/** Injección del TimerService */
	@Resource TimerService timerService;
	
	
    public CronUpdateOrdersProcess() 
    {
       
    }

   //@Schedule(minute="*/3", hour="*")    
    public void automaticTimeout() 
    {        
        System.out.println("Se ejecutó el Schedule: "+new Date());
    }
    
	
	/** 
    *  método callback que se 
    *  invocará al terminar el intervalo definido 
    */  
   @Timeout  
   public void execute(Timer timer)  
   {  
   	 System.out.println("Ejecutando el cron de actualizacion de ordenes - " + timer.getInfo());           
   } 
    
    
	@Override
	public void startUpTimer() 
	{
		  shutDownTimer();  
 	          
          long primeraEjecucion = (1*1000);//ejecucion inmediata: En un segundo
          long intervaloDeEjecucion = new Integer(10).longValue()*1000;//cada 10 segundos
          
          System.out.println("startUpTimer - Se creó nuevo servicio TIMER con primera ejecucion en: "+primeraEjecucion+" segundos. Con intervalo de ejecucion cada: "+intervaloDeEjecucion+" Segundos.");  
          timerService.createTimer(primeraEjecucion,intervaloDeEjecucion,"Proceso batch vericando estado de ordenes en los proveedores.");  			
	}

	@Override
	public void shutDownTimer() 
	{
		 @SuppressWarnings("unchecked")
		 Collection<Timer> timers = timerService.getTimers();  
		 System.out.println("shutDownTimer: " + timers);
		 
         if (timers != null)  
         {  
            for (Timer iterator : timers ) 
            {  
            	
            	iterator.cancel();                
                System.out.println("shutDownTimer - timer \""+iterator+"\" canceledo.");  
            }  
         }  
	}
	
	
}