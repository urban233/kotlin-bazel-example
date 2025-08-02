package org.example;

public class Main {

    /**
     * Entry point for the application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        FileUtil tmpFileUtil = new FileUtil();
        String tmpFileExtension = tmpFileUtil.getFileExtension("my_text.txt");
        System.out.print("The file extension is: " + tmpFileExtension);
    }
}
