import java.util.*; 
import java.lang.*; 
import java.awt.*; 

public class Mandelbrot {  

    /** 
     * Permet de savoir si un point fait partie ou non de l'ensemble de Mandelbrot
     * @param Re_Z Partie réel du complexe 
     * @param Im_Z Partie imaginaire du complexe
     * @return True s'il appartient à l'ensemble et false s'il n'appartient pas
     */ 
    public static Boolean AppartenanceMandelbrot(double Re_Z, double Im_Z) { 
        double Re_Z1 = Re_Z; 
        double Im_Z1 = Im_Z; 
        double Re_Z2; 
        double Im_Z2; 

        for (int i = 1; i <= 200; i++){ 
            Re_Z2 = Re_Z*Re_Z-Im_Z*Im_Z + Re_Z1 ; 
            Im_Z2 = 2*Re_Z*Im_Z + Im_Z1; 
            Re_Z = Re_Z2; 
            Im_Z = Im_Z2; 

            if ((Re_Z*Re_Z+Im_Z*Im_Z) >= 4) { 
                return false; 
            } 
        } 

        return true; 
    } 

    public static void main(String[] args){ 

        double Re_C = Double.parseDouble(args[0]);
        double Im_C = Double.parseDouble(args[1]);

        if (AppartenanceMandelbrot(Re_C, Im_C))
            System.out.println("Le point appartient à l'ensemble de Mandelbrot");    
        else
            System.out.println("Le point n'appartient pas à l'ensemble de Mandelbrot");
        
    } 
} 
