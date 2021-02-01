package mealyvemooremakinalari;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Moore {
    public String MooreMakinasi(String girdiDosyasiAdi,String gecisdiagramiDosyaAdi,String outputDosyaAdi) throws FileNotFoundException, IOException {
        File f=new File(girdiDosyasiAdi);         
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);        
        String s=br.readLine(); 
        String input[]=new String[3];        
        int say=0;  
        while(s!=null)
        {
            input[say]=s;
            say++;
            s=br.readLine();
        }
        String Q=input[0].substring(3,input[0].length()-1);
        String states[]=Q.split(",");
        String A=input[1].substring(3,input[1].length()-1);
        String alfabe[]=A.split(",");       
        int statescount=states.length; 
        
        File f1=new File(outputDosyaAdi);         
        FileReader fr1=new FileReader(f1);
        BufferedReader br1=new BufferedReader(fr1);  
        s=br1.readLine();
        s=br1.readLine();
        String output[][]=new String[statescount][2];
        int satir=0;
        while(s!=null)
        {    
           if(satir==statescount)
                break;
           output[satir][0]=s.split("\t")[0];
           output[satir][1]=s.split("\t")[1];
           satir++;          
           s=br1.readLine();
        }      
        File f2=new File(gecisdiagramiDosyaAdi);         
        FileReader fr2=new FileReader(f2);
        BufferedReader br2=new BufferedReader(fr2);  
        s=br2.readLine();
        s=br2.readLine();
        String gecistablosu[][]=new String[statescount][3]; 
        satir=0;
        while(s!=null)
        {
            gecistablosu[satir][0]=s.split("\t")[0].substring(1);
            gecistablosu[satir][1]=s.split("\t")[1].substring(1);
            gecistablosu[satir][2]=s.split("\t")[2].substring(1);
            satir++;
            s=br2.readLine();
        }          
        System.out.println("Durumlar");
        for(int i=0;i<statescount;i++)
        {
            System.out.print(states[i]+" ");
            
        } 
        System.out.println("\nÇıktılar");
        for(int i=0;i<satir;i++)
        {
            System.out.println(output[i][0]+"-"+output[i][1]);
            
        }
       
        System.out.println("\nGeçiş tablosu");
        for(int i=0;i<satir;i++)
        {
            System.out.println(gecistablosu[i][0]+"-"+gecistablosu[i][1]+"-"+gecistablosu[i][2]);
            
        }
       
        System.out.println("input stringini giriniz");
        Scanner scan=new Scanner(System.in);
        String inputString=scan.next();
        System.out.println(output[0][1]);
        String next; 
        int indis=0;
        StringBuilder temp = new StringBuilder();
        temp.append(output[0][0]+"\n");
        for(int i=0;i<inputString.length();i++)
        {
            if(Character.compare(inputString.charAt(i),'a')==0)
            {               
                 next=gecistablosu[indis][1];
            }
           else
            {
                next=gecistablosu[indis][2];
            }
            System.out.print(inputString.charAt(i)+ " " + output[Integer.parseInt(next)][0]+"-");
            temp.append(inputString.charAt(i)+ " " + output[Integer.parseInt(next)][0]+"-");
            for(int j=0;j<output.length;j++)
            {
                if(output[j][0].equals(output[Integer.parseInt(next)][0]))
                {
                    temp.append(output[j][1] + "\n");
                    System.out.println(output[j][1]);
                    indis=j;
                    break;
                }
            }
        }
       return temp.toString(); 
    }
    
}