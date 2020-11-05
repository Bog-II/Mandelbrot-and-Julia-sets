/**
 * S1 Support - DUT Info - 2020-2021
 * Project Mandelbrot/Julia part 2
 * Groupe 9 : Lucas HUERTA / Alexis VILMARD
 * Paul WUST / Benoit SACHART / Louis WASSNER 
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mandelbrot3_3 { 

    /**
     * appartenancePointEnsemble
     * 
     * @param ptX   partie réelle de l'ensemble
     * @param ptY   partie Imaginaire de l'ensemble
     * @param maxIt le nombre maximum d'itérations avant de quitter la boucle
     * @return soit le dernier nb d'itérations atteint soit maxIte
     */
    public static int appartenancePointEnsemble(double ptX, double ptY, int maxIte) {
        // variables
        double x2;
        double y2;

        for (int t = 1; t <= maxIte; t++) {
            if ((ptX * ptX + ptY * ptY) >= 4) {
                return t;
            }

            x2 = ptX * ptX - ptY * ptY + 0.382;
            y2 = 2 * ptX * ptY + 0.147;
            ptX = x2;
            ptY = y2;
        }

        return maxIte;
    }    

    public static void main(String[] args){
        
        //variable en argument
        double maxX = Math.max(Double.parseDouble(args[0]),Double.parseDouble(args[2]));
        double maxY = Math.max(Double.parseDouble(args[1]),Double.parseDouble(args[3]));
        double minX = Math.min(Double.parseDouble(args[0]),Double.parseDouble(args[2]));
        double minY = Math.min(Double.parseDouble(args[1]),Double.parseDouble(args[3]));
        double dimMax = Double.parseDouble(args[4]);
        //variables dans le code
        double pxHauteur, pxLargeur;
        double largeur, hauteur;
        int max = 1000;
        int nbIterations = 0;
        
        // traitement de des arguments pour le zoom
        largeur = maxX - minX;
        hauteur = maxY - minY;
        if (largeur >= hauteur) {
            pxLargeur = dimMax;
            pxHauteur = dimMax*(hauteur/largeur);
        } else {
            pxLargeur = dimMax*(largeur/hauteur);
            pxHauteur = dimMax;    
        }
        
        //création de l'image
        BufferedImage image = new BufferedImage((int)pxLargeur + 1, (int)pxHauteur + 1, BufferedImage.TYPE_INT_RGB);
        int[] colors = new int[max];
        for (int i = 0; i<max; i++) {
            colors[i] = Color.HSBtoRGB(i/256f, 1, i/(i+8f));
        }

        //parcours de chaque pixels et création de l'animation
        for (int ligne = 0; ligne < pxHauteur ; ligne ++){
            
            for (int colonne = 0; colonne < pxLargeur ; colonne ++) {

                    nbIterations= appartenancePointEnsemble(minX + (largeur*ligne)/pxLargeur ,minY + (hauteur*colonne)/pxHauteur, max);
                if (nbIterations < max){
                    image.setRGB(ligne, colonne, colors[nbIterations]);
                }else{
                    image.setRGB(ligne,colonne,0);
                }
            }
        }
            
        //Enregistrement de l'image
        try {
            File outputfile = new File("your_directory/julia.png");
            ImageIO.write(image, "png", outputfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
