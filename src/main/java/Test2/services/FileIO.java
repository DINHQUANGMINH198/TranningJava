package Test2.services;
import  Test2.entities.ArrayInt;
import  Test2.generator.GenArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
public class FileIO {
    public static String inputFile = "src/main/java/Test2/files/input.txt";
    public static String outputFile = "src/main/java/Test2/files/output.txt";
    public static String configFile = "src/main/java/Test2/files/config.json";
    public static Integer lengthArray ;
    public static Integer threads;
    public static Boolean randomArray = false;

    public FileIO() {
    }

    public static void writeArrayToFile(String fileName, int[] arr){ //ghi mang ra file
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.append(String.valueOf(arr[0]));
            for(int i = 1; i < arr.length; i++){
                if(i % 10 == 0){
                    writer.append("\n").append(String.valueOf(arr[i]));
                }else{
                    writer.append(" ").append(String.valueOf(arr[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] readArrayToFile(String fileName, int n){ // doc mang tu file
        int[] arr = new int[n];
        int i = 0;
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = bf.readLine()) != null){
                String[] strings = line.split(" ");
                for(String str :  strings){
                    try{
                        arr[i++] = Integer.parseInt(str);
                    }catch (Exception ex){
                        i--;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
    public static void readConfigFile(String fileName) { //doc file config
        try (FileReader reader = new FileReader(fileName)) {
            //Read JSON file
            Object obj = JSONValue.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            try {
                String inputFile = (String) jsonObject.get("input");
                String outputFile = (String) jsonObject.get("output");
                long length = (Long) jsonObject.get("lengthArray");
                long thread = (Long) jsonObject.get("threads");
                boolean random = (boolean) jsonObject.get("random");
                threads = (int) thread;
                lengthArray = (int) length;
                randomArray = random;
            } catch (Exception ex) {
                System.err.println("Config sai roi...");
            }
        } catch (IOException e) {
            e.printStackTrace();}
//            System.out.println(randomArray);
//            System.out.println(lengthArray);
//            System.out.println(threads);
//            System.out.println(inputFile);
//            System.out.println(outputFile);
            if (randomArray) {
                ArrayInt myArray = new GenArray().randomArray(lengthArray);
                writeArrayToFile(inputFile, myArray.getArray());
            }
    }

    public static void main(String[] args) {
//        readConfigFile(configFile);
        ArrayInt arr = new GenArray().randomArray(1000000);
        writeArrayToFile("src/main/java/Test2/files/input2.txt", arr.getArray());
    }
}