/*
 * Copyright (c) 2011, Ben Lavery
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

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
