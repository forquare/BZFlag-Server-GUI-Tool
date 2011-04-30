package util;

import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class allows easy reading and writing of plain text files.<br />
 * This class has remained mostly unchanged since 080416
 *
 * @author Ben Lavery
 * @version 110427
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
     * @param path - A String containing the path of the file to read.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Vector<String> read(String path) throws FileNotFoundException, IOException {
        file = new File(path);
        fread = new FileReader(file);
        buf = new BufferedReader(fread);

        String temp;
        Vector<String> working = new Vector<String>();

        while (true) {
            temp = buf.readLine();

            if (temp == null) {
                break;
            } else {
                working.add(temp);
            }
        }

        return working;
    }

     /**
     * Writes out, line by line, the values from a Vector into
     * a file.
     *
     * @param toWrite - A Vector, each element will be a new line in the file.
     * @param path - A String containing the path of the file to write.
      * @throws IOException
     */
    public void writer(Vector<String> toWrite, String path) throws IOException {
        file = new File(path);
        fw = new FileWriter(file);

        for (int i = 0; i < toWrite.size(); i++) {
            fw.write(toWrite.get(i));
            fw.write('\n');
            fw.flush();
        }
    }
}
