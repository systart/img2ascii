package com.etzcuoglu;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Img2Ascii {
    private String inputFile;
    private String outputFile;
    private BufferedImage img;
    private PrintWriter writer;

    public void setImg(String input) {
        this.inputFile = input;
        try {
            this.img = ImageIO.read(new File(this.inputFile));
        } catch (IOException e) {
            System.out.println("Input file cannot be read.");
            System.exit(-2);
        }
    }

    public void setOutput(String output) {
        this.outputFile=output;
    }

    /*
        To Do:  Scale the image...
     */
    public void generateAsciiFile()
    {
        try{
            writer = new PrintWriter(outputFile, "UTF-8");
        }
        catch (Exception e) {
            System.out.println("Output file cannot be created.");
            System.exit(-3);
        }

        for(int i=0;i<this.img.getHeight();i++){
            for(int j=0;j<this.img.getWidth();j++){
                int color   = this.img.getRGB(j,i);
                int red   = color & 0x00ff0000 >> 16;
                int green = color & 0x0000ff00 >> 8;
                int blue  = color & 0x000000ff;
                double g = (((double)(red*0.2989) + (double)(green*0.1140) + (double)(blue* 0.5870)));
                if (g >= 230.0) {
                    writer.print(' ');
                } else if (g >= 200.0) {
                    writer.print('.');
                } else if (g >= 180.0) {
                    writer.print('*');
                } else if (g >= 160.0) {
                    writer.print(':');
                } else if (g >= 130.0) {
                    writer.print('e');
                } else if (g >= 100.0) {
                    writer.print('&');
                } else if (g >= 70.0) {
                    writer.print('8');
                } else if (g >= 50.0) {
                    writer.print('#');
                } else {
                    writer.print('@');
                }
            }
            writer.println();
        }
        writer.close();
    }
}
