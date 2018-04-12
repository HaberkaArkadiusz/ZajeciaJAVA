import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Losowanie rozmiaru
        int size;
        Random generator = new Random();
        do {
            size = generator.nextInt(51) + 50;
        }while((size % 4) != 0);

        // Inicjalizacja tablicy:
        double[][] tab = new double[size][size];

        // Input od usera:
        Scanner reader = new Scanner(System.in);
        System.out.println("Wprowadź granicę A:");
        int a = reader.nextInt();

        System.out.println("Wprowadź granicę B:");
        int b = reader.nextInt();
        reader.close();

        // Zakładam że b to górna granica, więc zamieniam a z b w przypadku gdy a jest większe od b
        if(a > b)
        {
            var tmp = a;
            a = b;
            b = tmp;
        }

        // Maksymalna ilość 1 oraz -1 na przekątnej
        int max_positives = (int) (size * 0.75);
        int max_negatives = (int) (size * 0.25);

        // Zmienna przechowywująca aktualną ilość 1 i -1 na przekątnej
        int positives = 0;
        int negatives = 0;

        // Wypełnianie tablicy:
        for(int i=0; i < size; i++)
        {
            for(int j=0; j < size; j++)
            {
                if(i==j)
                {
                    var choose = generator.nextBoolean();
                    if(choose)
                    {
                        if(positives < max_positives)
                        {
                            tab[i][j] = 1;
                            positives++;
                        }
                        else
                        {
                            tab[i][j] = -1;
                            negatives++;
                        }
                    }
                    else
                    {
                        if(negatives < max_negatives)
                        {
                            tab[i][j] = -1;
                            negatives++;
                        }
                        else
                        {
                            tab[i][j] = 1;
                            positives++;
                        }
                    }
                }
                else
                {
                    tab[i][j] = generator.nextInt(b) + a;
                }
            }
        }

        // Wyświetlanie tablicy:
        for(int i=0; i<size; i++)
        {
            for(int j=0; j<size; j++)
            {
                System.out.print(tab[i][j]);
                System.out.print(" | ");
            }
            System.out.print("\n");
        }

    }
}
