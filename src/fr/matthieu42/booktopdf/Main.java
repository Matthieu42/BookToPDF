package fr.matthieu42.booktopdf;

import java.awt.*;

public class Main {
    public static void main(String args[]) throws AWTException {
        if(args.length < 6){
            System.out.println("Utilisation : x, y, longueur, hauteur, nombre de pages, nom du livre");
            System.exit(1);
        }
        int startX = Integer.parseInt(args[0]);
        int startY = Integer.parseInt(args[1]);
        int width = Integer.parseInt(args[2]);
        int height = Integer.parseInt(args[3]);
        int nbPages= Integer.parseInt(args[4]);
        String bookName = args[5];
        BookReader bookReader = new BookReader(startX,startY,width,height,nbPages,bookName);
        bookReader.automatedScreenShot();
        bookReader.saveToPNG();
    }
}