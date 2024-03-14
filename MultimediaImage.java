
package com.mycompany.multimediaimage;

// The program support FUJI of RAW type image
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MultimediaImage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Using Fujifilm of RAW image
        System.out.println("Enter the File path whith out Double quotation :");
        String filepath = sc.nextLine();
        imageType(filepath);

    }

    // The method to knowe the type of image
    public static void imageType(String filepath) {

        FileInputStream fileInputStream = null;

        try {

            fileInputStream = new FileInputStream(filepath);

            byte[] reader = new byte[4];
            fileInputStream.read(reader);
            System.out.println("The first 3 bytes in the header  are : " + new String(reader, 0, 3));
            if (reader[0] == 'G' && reader[1] == 'I' && reader[2] == 'F') {
                System.out.println("The type of is : GIF");
            } else if (reader[0] == 'B' && reader[1] == 'M' && reader[2] == '8') {
                System.out.println("The type of image is : BMP");
            } else if (reader[1] == 'P' && reader[2] == 'N' && reader[3] == 'G') {
                System.out.println("The type of image is : PNG");
            } else if ((reader[0] == 'I' && reader[1] == 'I') || (reader[0] == 'M' && reader[1] == 'M')) {
                System.err.println("The type of image is : TIFF");
            } else if (reader[0] == (byte) 0xFF && reader[1] == (byte) 0xD8) {
                System.out.println("The image type is : JPEG");
            }
            // Using Fujifilm of RAW image
            else if (reader[0] == 'F' && reader[1] == 'U' && reader[2] == 'J' && reader[3] == 'I') {

                System.out.println("The type of image is : RAW");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception x) {
            System.out.println("your path is incorrect");
        }
    }
}
