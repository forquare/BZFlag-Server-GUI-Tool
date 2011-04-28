/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben Lavery
 * @version 16/4/08
 */
public class FileReadWrite {

    private FileReader fread;
    private BufferedReader buf;
    private File file;
    private FileWriter fw;

    /**
     * Reads in, line by line, the values from a file into
     * a Vector.
     *
     * @return An array of String containing all of the values from the file.
     */
    public Vector<String> read(String path) {
        file = new File(path);
        try {
            fread = new FileReader(file);
            buf = new BufferedReader(fread);
        } catch (FileNotFoundException e) {
            Logger.getLogger(FileReadWrite.class.getName()).log(Level.SEVERE, null, e);
        } catch (NullPointerException e) {
            Logger.getLogger(FileReadWrite.class.getName()).log(Level.SEVERE, null, e);
        }


        String temp;
        Vector<String> working = new Vector<String>();

        while (true) {
            try {
                temp = buf.readLine();

                if (temp == null) {
                    break;
                } else {
                    working.add(temp);
                }
            } catch (IOException e) {
                Logger.getLogger(FileReadWrite.class.getName()).log(Level.SEVERE, null, e);
            } catch (NullPointerException e) {
                Logger.getLogger(FileReadWrite.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return working;
    }

    public void writer(Vector<String> toWrite, String path) {
        file = new File(path);
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            Logger.getLogger(FileReadWrite.class.getName()).log(Level.SEVERE, null, e);
        }

        for (int i = 0; i < toWrite.size(); i++) {
            try {
                fw.write(toWrite.get(i));
                fw.write('\n');
                fw.flush();
            } catch (IOException e) {
                Logger.getLogger(FileReadWrite.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
