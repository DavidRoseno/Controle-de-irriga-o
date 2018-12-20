package controleirrigação;

//import java.util.Calendar;
//import java.time.Clock;
//import java.time.ZoneId;
//import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @ short para economizar memoria e no uso de time()    // tentativa fracaçada de gerar documentação
 * @author David R.
 */

public class Controlewatertemp implements Controle {

    private boolean offon = true; //o ar começa ligado 
    private short time;
    private int temp;
    private float water;
    private boolean cond;
    private boolean ligth;
    
    public void Status(){
        System.out.println("-----------------");
        System.out.println("Status geral: ");
        System.out.println("Hora: " + data );
        System.out.println("Temperatura resgistrada: " +temp +"º"); //retornado errado
        //System.out.println("Litros de agua: " +this.getWater());
        System.out.println("luzes: " + ligth() );
        System.out.println("Ar: " + this.offon);
        System.out.println("-----------------");
    }
    
   protected String date = (new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(System.currentTimeMillis())));
   public String data = (new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date(System.currentTimeMillis())));
  
   /*
    DIVIDIR PRA CONQUISTAR; 
   */
    public boolean getOffon(){// o proprio metodo estará na rotina responsável pelo controle do ar
        if(this.offon==false && this.getTemp()>40){ 
            System.out.println("temperatura muito alta! Recomenda-se não desligar o ar!");   
        }
        return offon;
    }
        public void setOffon(boolean offon){
            /*
            para desligar o ar, é preciso alterar para false atraves deste metd. e depois chamar o metodo getOffon() para exibir 
            a msg, no caso da temperatura estiver muito alta
            */
            this.offon = offon;
        }
   
    public String getData() {
        return this.data;
    }
        public void setData(String data) {
            this.data = data;
        }    
    
    public int getTemp() {
        return temp;
        //this.cond = true;*/
    }
        public void setTemp(int temp) {
            this.temp = temp;
        }

    public short getTime() {
        return time;
    }
        public void setTime(short time) {
            this.time = time;
        }

    public float getWater() {
        System.out.println("Status de irrigação: irrigando... " + " " + "Utilizando " + 4.5f + " litros" );
           return 4.5f; 
    }
           private void setWater(float water) {      //ver posssibilidade de exclusão
               this.water = water;
           }

    public boolean getLigth() {
        return ligth;
    }
        public void setLigth(boolean ligth) {
            this.ligth = ligth;
        }
    
    public void Ar(){   // getTemp = temperatura do ambiente NÃO DO AR CONDIC. // AR CONDICIONADO
        while(this.getTemp()>=32 && this.getTemp()<=37){      // IF MÃE INICIO
            System.out.println("Temperatura alta registrada:" + temp +"º");
            if(this.getOffon()){
                temp -= 6;
                System.out.println("Baixando temperatura para:" + temp + "º");
            }else {
                System.out.println(" Ar inoperante: desligado!");
            }
        break;
        }
        
        while(this.getTemp()>=38 && this.getTemp()<=40){// IF FILHO INICIO 
         //(temp=>goias) pode ate passar um pouco a mais q isso; mas nu e pra tanto ne?
            System.out.println("Temperatura alta registrada:" + temp +"º");
            if(this.getOffon()){
                temp -= 8;
                System.out.println("Baixando temperatura para:" + temp + "º");
            }else {
                  // liga o Ar automaticamente por causa da alta temperatura (caso ele esteja desligado)
                this.setOffon(true);
                System.out.println("Ligando Ar...");
                temp -= 8;
                System.out.println("Baixando temperatura para:" + temp + "º");
            }
        break;    
        }
        
        while(this.getTemp()>40){        //// IF FILHO INICIO
            System.out.println("Temperatura alta registrada:" + temp +"º");
            if(this.getOffon()){
                temp -= 9;
                System.out.println("Baixando temperatura para:" + temp + "º" );
                this.getWater();
            }else {
                ///this.setDesligandoAr(true);
                  // liga o Ar automaticamente por causa da alta temperatura (caso ele esteja desligado)
                this.setOffon(true);
                System.out.println("Ligando Ar...");
                temp -= 9;
                System.out.println("Baixando temperatura para:" + temp + "º");
                this.getWater();
            }
        break;
        }    
    }       

// metod over
    @Override //                                     TEMP SO DEVERA FICAR COM A TEMP NIN E NORMAL, ACIMA-> AR()
    public void temp() {  // MEDIÇÃO DA TEMPERATURA = TERMOMETRO // TRATAMENTO DA TEMP
         while(this.getTemp()<=13){  //-// BASE    
            System.out.println("teperatura baixa resgistrada:" + temp +"º" );  
            if(this.getOffon()){          
                temp += 5; //alterando temp do ar condic.  e consequentimente a do ambiente 
                System.out.println("Aumentando temperatura para:" + temp +"°"); 
            }else{ 
                this.setOffon(true);
                System.out.println("Ligando Ar...");
                temp += 5;
                System.out.println("Aumantando temperatura para:" + temp +"º");
            break;
            }
        }
        if((this.getTemp() >14 && this.getTemp() <=29) || ("30".equals(this.getTemp()))){
            System.out.println( "Temperatura " + getTemp() + "º" + ": dentro do parâmetro. " );
        } else{ 
            Ar();
        }
     //return 0; 
    }
        
    @Override
    public String time() {
        LocalTime[] l = new LocalTime[4];
        LocalTime h = LocalTime.now();
        l[0] = l[0].of(7, 29);
        l[1] = l[1].of(8, 29);
        l[2] = l[2].of(17, 29);
        l[3] = l[3].of(18, 29);
            
        if ((h.isAfter(l[0]) && h.isBefore(l[1])) || (h.isAfter(l[2]) && h.isBefore(l[3]))){ 
            //System.out.println("Hora: " + data);
            System.out.println("Litros de agua: " + this.getWater() );
        }else{
            System.out.println("IRRIGAÇÃO: Fora do tempo de irrigação,(Execessão para altas temperaturas.)");       
        }
        ligth();
    return " ";      
    }

 /*   @Override
    public float water() {
        if(this.getCond(true)){System.out.println(this.getWater());}   //nao apagar pois 
return water;
    }*/

    @Override     
    public boolean ligth() {
        LocalTime hl = LocalTime.now();
        LocalTime[] lt = new LocalTime[4];
        lt[0] = LocalTime.of(8, 29);//y
        lt[1] = lt[1].of(18, 29);//y
        lt[2] = lt[2].of(21, 29);
        lt[3] = lt[3].of(5, 29);
        
        //TESTAR O SEGUNDO IF SEM(H1.isAfter(lt[1])) dentro da sua zona de efeito 
        if((hl.isAfter(lt[0]) && hl.isBefore(lt[1]))||(hl.isAfter(lt[2]) || hl.isBefore(lt[3]))){
             ligth = true;                              
        }
        else{if((hl.isAfter(lt[3]) && hl.isBefore(lt[0]))||(hl.isAfter(lt[1]) && hl.isBefore(lt[2]))){ //TESTAR COM || E &&
             ligth = false;
        }}
    return ligth;
   }

}

