package de.boebelix.Kontingenz;

import java.util.Arrays;

class ContingencyTable
{
    private double [][] copyTable;
    private double [] columnSum;
    private double [] rowSum;
    private double sum;
    private double [][] expectedFrequencyTable;
    private double chisq;
    private double coefficientOfContingency;
    private double maxCoefficientOfContingency;
    private double normalizedCoefficientOfContingency;

    public ContingencyTable(double [][] inputTable)
    {
        copyTable(inputTable);
        calcRowSum();
        calcColumnSum();
        calcSum();
        calcExpectedFrequency();
        calcChisq();
        calcCoefficientOfContingency();
        calcMaxCoefficientOfContingency();
        calcNormalizedCoefficientOfContingency();
    }


    public final void setCopyTable(double[][] copyTable)
    {
        this.copyTable = copyTable;
    }

    public double[] getColumnSum()
    {
        return columnSum;
    }

    public double[] getRowSum()
    {
        return rowSum;
    }

    public double getSum(){return sum;}

    public double [][] getExpectedFrequencyTable()
    {
        return expectedFrequencyTable;
    }

    public double getChisq()
    {
        return chisq;
    }

    public double getCoefficientOfContingency()
    {
        return coefficientOfContingency;
    }

    public double getNormalizedCoefficientOfContingency()
    {
        return normalizedCoefficientOfContingency;
    }

    // Kontingenzkoeffizient
    public void calcCoefficientOfContingency()
    {
            coefficientOfContingency = Math.sqrt(chisq / (chisq + sum));
    }

    public void calcMaxCoefficientOfContingency()
    {
        double maxValueOfContingency = minSizeOfTable();
        maxCoefficientOfContingency = Math.sqrt((maxValueOfContingency - 1) / maxValueOfContingency);
    }

    public void calcNormalizedCoefficientOfContingency()
    {
        normalizedCoefficientOfContingency = coefficientOfContingency / maxCoefficientOfContingency;
    }

    // Gibt die kleinere Seite von Zeile und Spalte zurück
    public int minSizeOfTable()
    {
        return copyTable.length > copyTable[0].length ? copyTable.length : copyTable[0].length;
    }
    // Skript Seite 6
    public void calcChisq()
    {
        chisq = 0;

        for (int i = 0; i < copyTable.length; i++)
        {
            for (int j = 0; j < copyTable[i].length; j++)
            {
                chisq += copyTable[i][j] * copyTable[i][j] / expectedFrequencyTable[i][j];
            }
        }
        chisq -= sum;
    }

    // Erwartete Häufigkeit (Häufigkeit bei Unabhänigikeit) Skript Seite 7
    public void calcExpectedFrequency()
    {
            expectedFrequencyTable = new double[copyTable.length][copyTable[0].length];
        for (int i = 0; i < expectedFrequencyTable.length; i++)
        {
            for (int j = 0; j < expectedFrequencyTable[i].length; j++)
            {
                expectedFrequencyTable[i][j] = rowSum[j] * columnSum[i] / sum;
            }
        }
    }

    // public nach Test in Private ändern
    public void calcColumnSum()
    {
        columnSum = new double[copyTable.length];

        for (int i = 0; i < copyTable.length; i++)
        {
            for (int j = 0; j < copyTable[i].length; j++)
            {
                columnSum[i] += copyTable[i][j];
            }
        }
    }

    // public nach Test in Private ändern
    public void calcRowSum()
    {
        rowSum = new double[copyTable[0].length];

        for (int j = 0; j < copyTable[0].length; j++)
        {
            for (int i = 0; i < copyTable.length; i++)
            {
                rowSum[j] += copyTable[i][j];
            }
        }
    }

    public void calcSum()
    {
        for (double i : rowSum)
        {
            sum += i;
        }
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

    public void printExpectedFrequencyTable()
    {
        System.out.println("Erwartete Häufigkeit / Häufigkeit bei Unabhängigkeit");
        printTable(expectedFrequencyTable);
    }

    public void printInputTable()
    {
        System.out.println("Eingegebene Tabelle");
        printTable(copyTable);
    }

    public void printTable(double [][] inputTable)
    {
        for (double [] i: inputTable)
        {
            // Optimierung Buffer
            System.out.println(Arrays.toString(i));
        }
    }

    public void report()
    {
        printInputTable();
        printExpectedFrequencyTable();

        System.out.println("Chi- Quadrat: " + chisq);
        System.out.println("Kontingenzkoeffizient C: " + coefficientOfContingency);
        System.out.println("Maximalwert von C: " + maxCoefficientOfContingency);
        System.out.println("Korrigierter Kontingenzkoeffizient: " + normalizedCoefficientOfContingency);
    }

}

