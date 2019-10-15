package Kata02.V11;


/**
 * Step 11 Refactor PrimeGenerator
 * ==================================
 *
 * Step 12 Refactor NumberPrinter
 * ==============================
 *
 *   :-)
 *
 */



public class PrimePrinter {

    public static final int numberOfPrimes = 1000;
    public static final int linesPerPage = 50;
    public static  final int columns = 4;

    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        NumberPrinter numberPrinter = new NumberPrinter(linesPerPage, columns);

        int[] primes = primeGenerator.generatePrimes(numberOfPrimes);
        numberPrinter.print(primes, numberOfPrimes);
    }
}


