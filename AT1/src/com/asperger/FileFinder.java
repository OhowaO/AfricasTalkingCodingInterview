package com.asperger;

import java.io.*;

public class FileFinder {

    //declare constants and class variables

    private InputStream fileInputStream;
    private String path;

    private final int small_a_ASCII = (int) ('a');
    private final int big_A_ASCII = (int) ('A');

    // create constructor that takes the path of the directory with the files being searched

    public FileFinder(String path){
        this.path = path;
    }

    // create respective getters and setters

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public int getBig_A_ASCII() {
        return big_A_ASCII;
    }

    public int getSmall_a_ASCII(){
        return small_a_ASCII;
    }

    public String getPath() {
        return path;
    }

    // method that takes a file object and checks whether it has the letter A in the file

    public boolean readEachFile(File file){
        try {
            setFileInputStream(new FileInputStream(file));
            int c;
            while ((c = getFileInputStream().read()) != -1){
                if (c == getSmall_a_ASCII() || c == getBig_A_ASCII()){
                    return true;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("[FILE NOT FOUND] : " + file.getName() + " has not been found");
        }catch (IOException e){
            System.out.println("[IOException] : " + file.getName() + " has thrown an IO exception");
        }
        return false;
    }

    // recursive method that goes through files and directories and prints names of files containing letter A

    public void printFiles(File file){
        if (file.isFile()){
            if (readEachFile(file)) {
                System.out.println(file.getName());
            }
        } else if (file.isDirectory()){
            File[] files = file.listFiles();
            for(File nestedFile: files){
                printFiles(nestedFile);
            }
        } else {
        }
    }

    // method that creates a file object from the target file path and calls he printFiles method

    public void execute(){
        File folder = new File(getPath());
        printFiles(folder);

    }
}
