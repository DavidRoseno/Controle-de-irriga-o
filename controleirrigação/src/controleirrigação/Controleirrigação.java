package controleirrigação;
 
//import java.io.IOException;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Scanner;
//import java.util.Calendar;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//import java.text.SimpleDateFormat;

public class Controleirrigação {
    public static void main(String[] matriz){
        
     try{
        Scanner entrada = new Scanner(System.in);
        Controlewatertemp c = new Controlewatertemp();
        
        LocalTime l = LocalTime.now();
        LocalDateTime com = LocalDateTime.now();
        LocalTime[] time = new LocalTime[5];
        time[0] = time[0].of(6, 00);
        time[1] = time[1].of(11, 50);// 12
        time[2] = time[2].of(18, 30);
        time[3] = time[3].of(19, 25);
         
        //c.setOffon(false);
        //System.out.println("desligando ar..." + c.getOffon());
        //System.out.println(" ");

        if(l.isAfter(time[0]) && l.isBefore(time[1])){//LocalTime
            System.out.println(c.date + " " + l + "   ou    " + com);// FLUXO      
            System.out.println("Bom dia! ");
            System.out.println("");
            System.out.print("Temperatura:");
            int temperatura = entrada.nextInt();
            c.setTemp(temperatura);
            c.Status();
            //System.out.println(c.temp() + c.time());
            c.temp();
            c.time();
        }else if(l.isAfter(time[1]) && l.isBefore(time[2])){
            System.out.println(c.date + " " + l + "   ou   " + com);
            System.out.println("Boa tarde! ");          
            System.out.println("");
            System.out.print("Temperatura:");
            int temperatura = entrada.nextInt();
            c.setTemp(temperatura);
            c.Status();
            //System.out.println(c.temp() + c.time());
            c.temp();
            c.time();
        }else{
            System.out.println(c.date + " " + l + "   ou    " + com);
            System.out.println("Boa noite! ");
            System.out.println("");
            //System.out.println(c.getOffon());
            System.out.print("Temperatura:");
            int temperatura = entrada.nextInt();
            c.setTemp(temperatura);
            c.Status();
            //System.out.println(c.time() + c.temp());
            c.temp();
            c.time();
        }
    System.out.println("\ntest: " + time[3]);
     
    }catch(Exception e){
        throw new RuntimeException(e);
    }     

    }   
}
