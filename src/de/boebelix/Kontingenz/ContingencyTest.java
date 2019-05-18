package de.boebelix.Kontingenz;

public class ContingencyTest
{
    public static void main(String[] args)
    {
        double [][] inTable = {{100, 40, 100}, {60, 50, 20}, {104, 46, 40}};

        ContingencyTable a = new ContingencyTable(inTable);
        a.printTable();
    }


}
