import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        // Losowanie
        Random generator = new Random();
        int number = generator.nextInt(151) - 50;

        // Inicjalizacja zmiennych
        int minimum = number;
        int maximum = number;
        int maximum2 = number;
        int mianownik=0;
        int suma=0;

        // Pętla
        do {

           if(number > maximum)
           {
               maximum = number;
           }

           if(number > maximum2 && number < maximum)
           {
                maximum2 = number;
           }

           if(number < minimum)
           {
               minimum = number;
           }

           if(number > 0 && number%2==0)
           {
               suma += number;
               mianownik++;
           }
           number = generator.nextInt(151) - 50;

        }while(number != 0);

        double srednia;
        if(mianownik != 0) {
            srednia = suma / mianownik;
            System.out.println("MAX: " + maximum + " MIN: " + minimum + " MEAN:" + srednia);
        }
        else
        {
            System.out.println("MAX: " + maximum + " MIN: " + minimum + " MEAN: BRAK");
        }

        int maxfibo = Math.abs(maximum2) * Math.abs(minimum);
        int fibo1=1;
        int fibo2=1;
        int fibosum;
        if(maxfibo > 1)
        {
            System.out.println(1);
            System.out.println(1);
            while(fibo2 < maxfibo)
            {
                fibosum = fibo1 + fibo2;
                System.out.println(fibosum);
                fibo1 = fibo2;
                fibo2 = fibosum;
            }
        }
    }
}
