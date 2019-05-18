package de.boebelix.Kontingenz;

import java.util.Arrays;

public class ContingencyTableTest
{
    public static void main(String[] args)
    {
        // Tabelle muss in erster Spalte mindestens die maximale Länge haben,
        // sonst kann es bei der Berechnung zu Fehlern führen.
        // Vorraussetzung: besser alle Spalten gleich lang und alle Zeilen des Arrays müssen gleich lang sein),

        double [][] inTable = {{100, 40, 100}, {60, 50, 20}, {104, 46, 40}};

        ContingencyTable a = new ContingencyTable(inTable);
        a.printTable();

        // Test Spaltensumme
        a.calcColumnSum();
        System.out.println(Arrays.toString(a.getColumnSum()));

        // Test Zeilesumme
        a.calcRowSum();
        System.out.println(Arrays.toString(a.getRowSum()));

    }


}
