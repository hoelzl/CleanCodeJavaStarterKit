package Kata02.V09;



/**
 * Step 9
 * ==============
 *
 * * 9.1) change the public int[] generatePrimes()
 *        to public int[] generatePrimes(int numberOfPrimes)
 *
 * * 9.2) Remove private final int numberOfPrimes = 1000;
 *       from PrimeGenerator
 *
 *  => This will causes some errors!
 *         private final int[] primes = new int[numberOfPrimes + 1];
 *
 *   To fix this
 *
 * * 9.3) Put the statement: primes = new int[numberOfPrimes + 1];
 *       in the
 *
 *       public int[] generatePrimes(int numberOfPrimes) {
 *         primes = new int[numberOfPrimes + 1];
 *         ..
 *       }
 *
 *   and change the declaraion in PrimeGenerator to
 *     private int[] primes;
 *
 * * in main Method change the generatePrimes calls:
 *           int[] primes = primeGenerator.generatePrimes(numberOfPrimes);
 *
 * * 9.4) RUN THE TEST...
 *
 * * STEP 9 DONE!
 *
 * * << Go to V10 to see the result of this Refactoring >>
 *
 */

public class PrimePrinter {

    public static final int numberOfPrimes = 1000;
    public static final int linesPerPage = 50;
    public static  final int columns = 4;
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        int[] primes = primeGenerator.generatePrimes();
        new NumberPrinter(linesPerPage, columns).print(primes, numberOfPrimes);
    }

}

class PrimeGenerator {

    private final int numberOfPrimes = 1000;

    private final int ordmax = 30;
    private final int[] primes = new int[numberOfPrimes + 1];
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private final int[] multiples = new int[ordmax + 1];

    public int[] generatePrimes() {
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


