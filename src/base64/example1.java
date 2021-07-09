package base64;

import java.io.*;
import java.util.Base64;

public class example1 {

    private static void encodeImage(FileInputStream inputImage){
        byte [] bytes=null;
        String encoded=null;
        try {
            bytes= inputImage.readAllBytes();
            encoded= Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Encode Img : "+encoded);
        try {
            bytes=Base64.getDecoder().decode(encoded);
            FileOutputStream fw=new FileOutputStream("C:\\Users\\abhis\\IdeaProjects\\untitled1\\src\\base64\\txt.png");
            fw.write(bytes);
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file=new File("C:\\Users\\abhis\\IdeaProjects\\untitled1\\src\\base64\\img.png");
        FileInputStream fio=null;
        try {
            fio=new FileInputStream(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(file);
        encodeImage(fio);
       // System.out.println("Encode Img : "+encodeImage(fio));

    }
}
