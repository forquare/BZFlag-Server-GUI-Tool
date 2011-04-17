/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Adapted from
 * http://www.java2s.com/Code/Java/File-Input-Output/ListingtheDirectoryContents.htm
 */

package lib;

import java.io.File;
import java.util.Arrays;

public class Dir {
  static int indentLevel = -1;

  static String[] listPath(File path) {
    File files[];
    indentLevel++;

    files = path.listFiles();

    Arrays.sort(files);
    for (int i = 0, n = files.length; i < n; i++) {
      for (int indent = 0; indent < indentLevel; indent++) {
        System.out.print("  ");
      }
      System.out.println(files[i].toString());
      if (files[i].isDirectory()) {

        listPath(files[i]);
      }
    }
    indentLevel--;
  }
}