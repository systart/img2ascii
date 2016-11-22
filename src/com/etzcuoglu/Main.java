package com.etzcuoglu;

public class Main {

    public static void main(String[] args) {

        Img2Ascii i2a = new Img2Ascii();

        try{
            i2a.setImg(args[0]);
        }
        catch (Exception ex){
            System.out.println("Error!");
            System.out.println("Example using: img2ascii [InputFile] [OutputFile]");
            System.exit(-1);
        }

        try{
            i2a.setOutput(args[1]);
        }
        catch (Exception ex){
            i2a.setOutput("output.txt");
        }

        i2a.generateAsciiFile();
    }
}
