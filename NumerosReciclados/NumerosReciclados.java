/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosreciclados;

/**
 *
 * @author HUGO
 */
import java.awt.FileDialog;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class NumerosReciclados {
int caso=0;
FileWriter fichero;
    BufferedWriter buffer;
    PrintWriter escritura;
String dir="C:\\Users\\HUGO\\Documents\\GitHub\\ExamenFinal\\NumerosReciclados\\dataset1.txt";
String dir2="";
int num1[];
int num2[];
int tam=0;
int x=0;
String escribirl[]=null;
public NumerosReciclados(){
  
   
}    
    public void leer(){

 File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        String linea = dir;

        try {
           
            archivo = new File(linea);
           
            fr = new FileReader(archivo);
            
            br = new BufferedReader(fr);

            String[] datos = null;
             
            
            while ((linea = br.readLine()) != null) {

               
               
                datos = linea.split(" ");
         
                
                
              
              if(datos.length>1){
                   
                revisar(datos);
               
              }
            }

            //Capturamos las posibles excepciones
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
 public void escribir(){
        try {
            fichero = new FileWriter("C:\\Users\\HUGO\\Documents\\GitHub\\ExamenFinal\\NumerosReciclados\\escritura_201213192.txt",false);
            buffer = new BufferedWriter(fichero);
            escritura = new PrintWriter(buffer);
            int x=escribirl.length;
            for(int i=0;i<x;i++){
            escritura.println(escribirl[i]);}
            escritura.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }    
    public void revisar (String dato[]){
        int uno=Integer.parseInt(dato[0]);
        int dos=Integer.parseInt(dato[1]);
        
       int num=uno;
        int l=dato[0].length();
        num1=new int[l];
        num2=new int[l];
        while(uno<dos){
          String n1=Integer.toString(num);
          String n2=Integer.toString(num+1);
          
          for(int i=0;i<l;i++){
            if(n1.charAt(i)==n2.charAt(i)){
            x=1;
            }else{
            x=0;
            }
          
          }
        
          if(x==1){
          caso++;
          escribirl[tam]="caso "+tam+1+" "+caso;
          tam++;
          }
          
          
            uno++;
       
        
        }
         caso=0;
    }
    public static void main(String[] args) {
     NumerosReciclados p=new NumerosReciclados();
     p.leer();
     p.escribir();
    }
}
