package mealyvemooremakinalari;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Mealey {
    public String MealyMakinasi(String girdiDosyasiAdi,String gecisdiagramiDosyaAdi ) throws IOException{
        StringBuilder temp = new StringBuilder();
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
        int statescount=states.length;
        String A=input[1].substring(3,input[1].length()-1);
        String alfabe[]=A.split(",");
        String S=input[2].substring(3,input[2].length()-1);
        String sonuc[]=S.split(",");
        File f2=new File(gecisdiagramiDosyaAdi);         
        FileReader fr2=new FileReader(f2);
        BufferedReader br2=new BufferedReader(fr2);  
        s=br2.readLine();
        System.out.println(s);
        s=br2.readLine();
        String[] gecisler=new String[states.length];  
        say=0;
        String a="";
        while(s!=null)
        {
            System.out.println(s);
            for(int i=1;i<(alfabe.length*2);i++)
            {
                
                 a=a.concat(s.split("\t")[i].split("/")[0]+"-"+s.split("\t")[i].split("/")[1]+"-"+s.split("\t")[i+1]+"/"); 
                 i++;
            }
            gecisler[say]=a.substring(0,a.length()-1);
            a="";            
            say++;
            s=br2.readLine();
        }
       
        System.out.println("\ninput:");
        Scanner scan=new Scanner(System.in);
        String girdi=scan.next();
        int next=0;
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        String bol[];
        for(int i=0;i<girdi.length();i++)
        {
            bol=gecisler[next].split("/");
            for(int j=0;j<bol.length;j++)
            {
                if(girdi.charAt(i)==bol[j].charAt(0))
                {
                    sb.append("q"+next+"-->");
                    sb.append(girdi.charAt(i)+" geldi "+bol[j].split("-")[2]);
                    sb.append(" git "+bol[j].split("-")[1]+" yaz ");
                    System.out.print("q"+next+"-->");
                    System.out.print(girdi.charAt(i)+" geldi "+bol[j].split("-")[2]);
                    System.out.print(" git "+bol[j].split("-")[1]+" yaz ");
                    sb1.append(bol[j].split("-")[1]);
                    next=Integer.parseInt(bol[j].split("-")[2].substring(1));
                }
            }
            sb.append("\n");
            System.out.println();
        }
        System.out.println(sb.toString());
        sb.append(sb1.toString());
        return sb.toString();
        
   
    }
    
}
