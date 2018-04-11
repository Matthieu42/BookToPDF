package fr.matthieu42.booktopdf;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Book {
    private ArrayList<BufferedImage> pages;
    private String bookName;
    private int nbPages;

    public Book(String bookName, int nbPages) {
        this.bookName = bookName;
        this.nbPages = nbPages;
        this.pages = new ArrayList<>();
    }

    public void addPage(BufferedImage page) {
        this.pages.add(page);
    }

    public void saveAsPng() throws IOException {
        int i = 1;
        for (BufferedImage page : pages){
            File file = new File(bookName+i+".png");
            ImageIO.write(page, "png", file);
            i++;
        }
    }

    public int getNbPages() {
        return nbPages;
    }
}
