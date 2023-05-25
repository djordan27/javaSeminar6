package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Random;

@Component("notebook")
public class Notebook extends Computer{

    private static int myRandom(int count){
        Random random = new Random();
        int number = random.nextInt(0, count);
        return number;
    }
    // 1 - ОЗУ
    @Value("1024,2048,4096,8192,16384,32768")
    private String [] variableRam ;
    private  String ram = null;
    public String getRam() {
        if(ram == null) ram = variableRam[myRandom(variableRam.length)];
        return ram;
    }
    
    //    // 2 - Объём ЖД
    @Value("60,120,240,480,960,1980")
    private String [] variableHdd ;
    private  String hdd = null;
    public String getHdd() {
        if(hdd == null) hdd = variableHdd[myRandom(variableHdd.length)];
        return hdd;
    }
//    // 3 - Операционная система
@Value("Ios,Windows,Linux")
private String [] variableOperatingSystem ;
    private  String operatingSystem = null;
    public String getOperatingSystem() {
        if(operatingSystem == null) operatingSystem = variableOperatingSystem[myRandom(variableOperatingSystem.length)];
        return operatingSystem;
    }
//    // 4 - Цвет
@Value("White,Black,Blue,red")
private String [] variableColor;
    private  String color = null;
    public String getColor() {
        if(color == null) color = variableColor[myRandom(variableColor.length)];
        return color;
    }
    public void assignValue(){
        if(ram == null) ram = variableRam[myRandom(variableRam.length)];
        if(hdd == null) hdd = variableHdd[myRandom(variableHdd.length)];
        if(operatingSystem == null) operatingSystem = variableOperatingSystem[myRandom(variableOperatingSystem.length)];
        if(color == null) color = variableColor[myRandom(variableColor.length)];
    }

    public HashMap<String,String> getHashMap(){
        assignValue();
    HashMap<String, String> map = new HashMap<String,String>();
    map.put("ram",ram);
    map.put("hdd",hdd);
    map.put("operating system",operatingSystem);
    map.put("color",color);

    return map;
    }

    @Override
    public String toString() {
        if(ram == null) ram = variableRam[myRandom(variableRam.length)];
        if(hdd == null) hdd = variableHdd[myRandom(variableHdd.length)];
        if(operatingSystem == null) operatingSystem = variableOperatingSystem[myRandom(variableOperatingSystem.length)];
        if(color == null) color = variableColor[myRandom(variableColor.length)];
        return "Notebook{" +
                "ram='" + ram + '\'' +"mb" +
                ", hdd='" + hdd + "gb" + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}' +"\n";
    }
}
