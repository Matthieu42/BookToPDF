package fr.matthieu42.booktopdf;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BookReader{
    private Robot robot;
    private Rectangle bookArea;
    private Book book;

    public BookReader(int startX, int startY, int width, int height, int nbpages, String bookName) throws AWTException {
        this.robot = new Robot();
        this.bookArea = new Rectangle(startX,startY,width,height);
        this.book = new Book(bookName,nbpages);
    }

    public void automatedScreenShot(){
        for (int i = 0 ; i < book.getNbPages() ; i++){
            this.take();
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void take() {
        BufferedImage screenCapture = robot.createScreenCapture(bookArea);
        book.addPage(screenCapture);
    }
    public void saveToPNG(){
        try {
            this.book.saveAsPng();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
