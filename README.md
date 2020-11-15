# Mandelbrot-and-Julia-sets

<img src="/Julia/animation_julia.gif" alt="Julia set" width="350">

Here is our code to print the Mandelbrot and Julia sets. The code "julia_animation" allows to create an animation of the variation of the Julia sets

Pour compiler : 
  - Il faut d'abord compiler le fichier Picture.java --> javac Picture.java
  - Puis compiler le code : javac Julia.java ou javac Mandelbrot.java
Pour exécuter : 
  - java {leNomDuFichier} {xA} {yA} {xB} {yB} {taille}
  - avec xA et yA les coordonnées du point A et xB et yB les coordonnées du point B
    - cela permet de définir une fenêtre d'affichage pour visualiser la fonction, on s'en sert pour faire un zoom
  - taille correspond à la résolution voulu, c'est à dire le nombre de pixels par côté
  
Exemple :
  - pour Julia : java Julia -1.5 -1.5 1.5 1.5 1000
  - pour Mandelbrot : java Mandelbrot -2.05 -1.3 0.55 1.3 1000
 
Le programme "appartenance" montre le fonctionne de la fonction "AppartenanceMandelbrot". Il permet de dire si un point appartient ou non à l'ensemble. Dans les progammes finaux, lorsqu'il n'appartient pas à l'ensemble, on retourne le nombre d'itérations qu'il a fait afin de déterminer sa couleur.

