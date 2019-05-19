package de.boebelix.Kontingenz;

import java.util.Arrays;

public class ContingencyTableTest
{
    public static void main(String[] args)
    {
        // Vorraussetzung: Alle Zeilen des Arrays müssen gleich lang sein),

        // Spaltenbasierendes Tabelle
        // 100  60  104
        // 40   50  46
        // 100  20  40

        double[][] inTable = {{100, 40, 100}, {60, 50, 20}, {104, 46, 40}};


        ContingencyTable a = new ContingencyTable(inTable);
        a.report();

        // Meine berechneten Werte

        double[][] myExpectedFrequencyTable = {{113.14, 58.3, 68.6}, {61.3, 31.6, 37.1}, {89.6, 46.1, 54.3}};
        double myChisq = 46.33;
        double myCoefficientOfContingency = 0.2764;
        double myMaxCoefficientOfContingency = 0.816;
        double myNormalizedCoefficientOfContingency = 0.338;

        // Test
        boolean testSuccessfulExpecetdFrequencyTable = isTestSuccessfulExpecetdFrequencyTable(a, myExpectedFrequencyTable);
        boolean testSuccessfulChisq = compareDouble(a.getChisq(), myChisq, 0.1);
        boolean testSuccessfulCoefficientOfContingency = compareDouble(a.getCoefficientOfContingency(), myCoefficientOfContingency, 0.1);
        boolean testSuccessfulMaxCoefficientOfContingency = compareDouble(a.getMaxCoefficientOfContingency(), myMaxCoefficientOfContingency, 0.1);
        boolean testSuccessfulNormalizedCoefficientOfContingency = compareDouble(a.getNormalizedCoefficientOfContingency(), myNormalizedCoefficientOfContingency, 0.1);


        System.out.println();
        System.out.println("Test erwartete Häufigkeit: " + testSuccessfulExpecetdFrequencyTable);
        System.out.println("Test Chi - Quadrat: " + testSuccessfulChisq );
        System.out.println("Test Kontingenzkoeffizent: " + testSuccessfulCoefficientOfContingency);
        System.out.println("Test maximaler Kontingenzkoeffizent: " + testSuccessfulMaxCoefficientOfContingency);
        System.out.println("Test korrigierter Kontingenzkoeffizent : " + testSuccessfulNormalizedCoefficientOfContingency);

    }

    private static boolean isTestSuccessfulExpecetdFrequencyTable(ContingencyTable a, double[][] expectedFrequencyTable)
    {
        for (int i = 0; i < expectedFrequencyTable.length; i++)
        {
            for (int j = 0; j < expectedFrequencyTable[i].length; j++)
            {
                if (compareDouble(a.getExpectedFrequencyTable()[i][j], expectedFrequencyTable[i][j], 0.1) == false)
                {
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean compareDouble(double a, double b, double EPSILON)
    {
        return a - b < EPSILON;
    }

}
