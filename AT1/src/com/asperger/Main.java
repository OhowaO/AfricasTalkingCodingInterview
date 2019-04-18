package com.asperger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //You can run the FileFinder class in 2 ways
        // 1. By asking for a file path from the user
        if (args.length < 1){

            Scanner scanner = new Scanner(System.in);
            System.out.print("Please specify a file path : ");

            if (scanner.hasNext()) {
                String path = scanner.next();
                FileFinder fileFinder = new FileFinder(path);
                fileFinder.execute();
            }

            scanner.close();

        } else {

            // 2. by allowing the user to specify the file path as an argument

            String path = args[0];
            FileFinder fileFinder = new FileFinder(path);
            fileFinder.execute();
        }

    }

}
