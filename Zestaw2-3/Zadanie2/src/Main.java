public class Main {

    public static int wystapienia(String[][] tab, String fraza, int niepodzielne)
    {
        int wystap = 0;
        int x = 0;

        // Rozmiar tablicy:
        var columns = tab.length;
        var rows = tab[0].length;
        int sum_of_length = 0;
        String chain = "";

        for(int i=0; i < columns; i++)
        {
            for(int j=0; j < rows; j++)
            {
                if(tab[i][j].contains(fraza))
                {
                    var tekst = tab[i][j];
                    while(tekst.contains(fraza))
                    {
                        tekst = tekst.replaceFirst(fraza,"");
                        wystap++;
                    }
                }
                //suma do sredniej:
                sum_of_length += tab[i][j].length();

                //konkat:
                if((i%5)==0 && (i%niepodzielne)!=0)
                {
                    if(tab[i][j].length() < 3)
                    {
                        chain.concat(tab[i][j]);
                    }
                    chain.concat(tab[i][j].substring(0,2));
                }
            }
        }

        double mean = sum_of_length / (rows*columns);
        System.out.println("Srednia:" + mean);
        System.out.println("Lancuch:" + chain);
        return wystap;
    }

    public static void main(String[] args)
    {
        int rows = 2;
        int columns = 2;
        String[][] Array = new String[columns][rows];

        Array[0][0] = "Adam";
        Array[1][1] = "Adamello";
        Array[1][0] = "Damiano";
        Array[0][1] = "Roterdamdamdam";

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.print(Array[i][j] + " | ");
            }
            System.out.print("\n");
        }

        System.out.print("Wystapienia:" + wystapienia(Array,"a",3));
        // This program is case-sensitive

    }
}
