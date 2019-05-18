package de.boebelix.Kontingenz;

import java.util.Arrays;

class ContingencyTable
{
    private double [][] copyTable;

    public ContingencyTable(double [][] inputTable)
    {
        copyTable(inputTable);
    }

    private void copyTable(double[][] inputTable)
    {
        copyTable = new double[inputTable.length][];
        for (int i = 0; i < inputTable.length; i++)
        {
            copyTable[i] = new double[inputTable[i].length];
            for (int j = 0; j < copyTable[i].length; j++)
            {
                copyTable[i][j] = inputTable[i][j];
            }
        }
    }

    public void printTable()
    {
        for (double [] i: copyTable)
        {
            // Optimierung Buffer
            System.out.println(Arrays.toString(i));
        }

    }



}

