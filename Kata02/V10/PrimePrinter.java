package Kata02.V10;



/**
 * Step 10 Extract while body from public int[] generatePrimes(int numberOfPrimes)
 * ===============================================================================
 *
 * * 10.1) Select the body of the first while loop in public int[] generatePrimes()
 *        From do{  to  } while(!possiblyPrime);
 *
 *    => Extract => Method.. => Name: findNextPrime
 *
 * *  10.2) RUN THE TEST...
 *
 * *  10.3) Move PrimeGenerator to topLevel
 *
 *  => Refactor => Move..
 *
 *  * 10.4) RUN THE TEST...
 *
 *  * 10.5) in PrimePrinter extract a NumberPrinter variable
 *
 *      => Select: new NumberPrinter(linesPerPage, columns)
 *         Extract => Variable => Name: numberPrinter
 *
 * * 10.6) Move up NumberPrinter numberPrinter = new NumberPrinter(linesPerPage, columns);
 *
 *       result :
 *
 *    public class PrimePrinter {
 *
 *     public static final int numberOfPrimes = 1000;
 *     public static final int linesPerPage = 50;
 *     public static  final int columns = 4;
 *     public static void main(String[] args) {
 *         PrimeGenerator primeGenerator = new PrimeGenerator();
 *         NumberPrinter numberPrinter = new NumberPrinter(linesPerPage, columns);
 *         int[] primes = primeGenerator.generatePrimes(numberOfPrimes);
 *         numberPrinter.print(primes, numberOfPrimes);
 *     }
 * }
 *
 *
 * 10.7) RUN THE TEST...
 *
 *
 * * STEP 10 DONE!
 *
 * * << Go to V11 to see the result of this Refactoring >>
 *
 */


public class PrimePrinter {

    public static final int numberOfPrimes = 1000;
    public static final int linesPerPage = 50;
    public static  final int columns = 4;
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        int[] primes = primeGenerator.generatePrimes(numberOfPrimes);
        new NumberPrinter(linesPerPage, columns).print(primes, numberOfPrimes);
    }

}

class PrimeGenerator {

    private final int ordmax = 30;
    private  int[] primes ;
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private final int[] multiples = new int[ordmax + 1];

    public int[] generatePrimes(int numberOfPrimes) {

        primes = new int[numberOfPrimes + 1];
        n = 0;

        candidate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;

        while (primeIndex < numberOfPrimes) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;

        }

        return primes;
    }



}


