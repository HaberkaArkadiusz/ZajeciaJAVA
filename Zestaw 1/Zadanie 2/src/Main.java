import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Random generator = new Random();
        double number = (generator.nextInt(201) - 100) / 10.0;

        int i=1;
        double sumadrugiej=number;

        int j=0;
        double sumapodzielnej=0;
        double maximum = number;

        double suma = number;

        //Pętla 1
        while(number != 0.0)
        {
            if(number > 0 && number%3==0)
            {
                sumapodzielnej += number;
                j++;
            }

            if(number > maximum)
            {
                maximum = number;
            }

            number = (generator.nextInt(201) - 100) / 10.0;
            i++;
            if(i%2==1)
            {
                sumadrugiej += number;
            }

            suma += number;
        }

        System.out.println("Suma co drugiej: " + sumadrugiej + " | Srednia dodatnich, podzielnych przez 3: " + (sumapodzielnej/j));

        double srednia1 = suma / i;

        //Pętla 2

        int counthighs=0;
        double suma2=0;

        for(int a=0; a<i; a++)
        {
            number = (generator.nextInt(201) - 100) / 10.0;
            if(number > maximum)
            {
                counthighs++;
            }
            suma2 += number;
        }

        double srednia2 = suma2 / i;

        System.out.println("Liczba większych niz max w 1: " + counthighs + " Różnica średnich: " + Math.abs(srednia1 - srednia2));
        if(srednia1 > srednia2)
        {
            System.out.println("Srednia wieksza w 1 pętli");
        }
        else
        {
            System.out.println("Srednia wieksza w 2 petli");
        }
    }
}
