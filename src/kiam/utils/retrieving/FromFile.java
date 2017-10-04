/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiam.utils.retrieving;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kvaziuser
 */
public class FromFile {

    private String fileName;
    private File file;
    private String fileContent;

    public FromFile() {
    }

    public FromFile(String fileName) {
        System.err.println("    fileName: " + fileName);
        this.fileName = fileName;
    }

    /**
     * Get the value of fileName
     *
     * @return the value of fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Set the value of fileName
     *
     * @param fileName new value of fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    @Override
    public String toString() {
        return "FromFile{" + "fileName=" + fileName + ", file=" + file + '}';
    }

    public void readFile() {
        String line;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();

            //System.out.println("  read File ..");
            line = br.readLine();
            //System.out.println(line);

            int k = 0;
            for (; line != null;) {
                k++;
                if (line.trim().length() == 0) {
                    // line = pns.AppConstants.BLOCKS_DELIMITER;
                }
//                if (k < 6) {
                //System.out.println("k:" + k + "  " + line.length() + " " + line);
//
//                }
                //System.out.println(line);
                line = line.trim();
                if (line.length() > 0) {
                    sb.append(line);
                }
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            //System.out.println(sb.toString());

            //System.out.println("     filecontent " + fileContent);
            //System.out.println(sb.toString());
            this.fileContent = sb.toString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FromFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("    fileContent.length() " + fileContent.length() + "   " + fileContent);

    }
}
