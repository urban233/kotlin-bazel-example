/**
 * Copyright (c) 2025, Martin Urban
 * Licensed under the BSD 3-Clause License (https://opensource.org/license/bsd-3-clause)
 * This file may not be copied, modified, or distributed except according to those terms.
 * ======================================================================================
 */
package org.example;

/**
 * This class serves as the entry point for the application.
 *
 * @author Martin Urban
 */
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
