/**
 * Copyright (c) 2025, Martin Urban
 * Licensed under the BSD 3-Clause License (https://opensource.org/license/bsd-3-clause)
 * This file may not be copied, modified, or distributed except according to those terms.
 * ======================================================================================
 */
package org.example

import java.io.File

/**
 * Utility class for file operations.
 *
 * @author Martin Urban
 */
class FileUtil {
    
    /**
     * Returns the extension of the file represented by the given pathname.
     *
     * Note: If no file extension could be detected, an empty string is returned.
     *
     * @param aFilepath representing the file whose extension should be extracted
     * @return extension of the given file; an empty string if no file extension is specified
     * @throws IllegalArgumentException if the given file pathname is empty
     */
    fun getFileExtension(aFilepath: String): String {
        //<editor-fold desc="Checks">
        if (aFilepath.isEmpty()) {
            throw IllegalArgumentException("Given file pathname is empty.")
        }
        //</editor-fold>
        val tmpFile: File = File(aFilepath)
        val tmpFilename: String = tmpFile.getName()
        val tmpLastIndexOfDot: Int = tmpFilename.lastIndexOf('.')
        if (tmpLastIndexOfDot == -1) {
            return ""
        }
        val tmpFileExtension: String = tmpFilename.substring(tmpLastIndexOfDot)
        return tmpFileExtension
    }
}
