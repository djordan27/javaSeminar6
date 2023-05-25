package org.example;

public abstract class Computer {
    // 1 - ОЗУ
    abstract public String getRam ();
    // 2 - Объём ЖД
    abstract public String getHdd ();
//    // 3 - Операционная система
    abstract public String getOperatingSystem ();
//    // 4 - Цвет
    abstract public String getColor ();
}
