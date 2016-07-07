package com.abyss.tech.concurrency.collaberation;

public class Car
{
   private boolean waxOn = false;
   public synchronized void waitforWaxOn() throws InterruptedException
   {
       while(!waxOn)
    
            wait();
        

   }
   //sleep 0.5sec
   public synchronized void waxOn()
   {
       waxOn = true;
       System.out.println("Wax On On On");
       notifyAll();
   }
   public synchronized void waitforWaxOff() throws InterruptedException
   {
       while(waxOn)
            wait();

   }
   //sleep 0.5 sec
   public synchronized void waxOff()
   {
       waxOn = false;
       System.out.println("Wax Off Off Off");
       notifyAll();
   }
   

}
