package Kata02.V08;


/**
 *
 * Step 8: Let a NumberPrinter Object calls the print(numbers, numberOfNumbers) in Main
 * ======================================================================================

 * * 8.1) Move the call:  new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
 *
 *       from:
 *
 *        public void printNumbers(int[] numbers, int numberOfNumbers) {
 *         new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
 *     }
 *
 *     to the main Method: instead of
 *
 *        primePrinterHelper.printNumbers(primes, numberOfPrimes);
 *
 *
 *     Result:
 *
 *     public void printNumbers(int[] numbers, int numberOfNumbers) {
 *
 *     }
 *
 *        public static void main(String[] args) {
 *         PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
 *         int[] primes = primePrinterHelper.generatePrimes();
 *         new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
 *     }
 *
 *
 *
 *     => The code does not compile: Error
 *
 *     => We have to fix this error>
 *
 *
 *
 * * 8.2) Copy linePerPage and columns variables form PrimePrinterHelper
 *        paste them in PrimePrinter and change them to public static final
 *
 *       public static final int linesPerPage = 50;
 *       public static  final int columns = 4;
 *
 *
 *   => There is still error in print(numbers, numberOfNumbers);
 *
 *  8.3)  Change numbers to primes and numberOfNumbers to numberOfPrimes
 *
 *    new NumberPrinter(linesPerPage, columns).print(primes, numberOfPrimes);
 *
 *
 *  8.4) RUN TEST.....
 *
 *  8.5)  Remove both linesPerPage and columns from PrimePrinterHelper
 *
 *     private final int linesPerPage = 50;
 *     private final int columns = 4;
 *
 *  8.6) Remove also  public void printNumbers(int[] numbers, int numberOfNumbers) { }
 *  STEP 8 is DONE
 *
 *  8.7) Remove all not used variables from PrimePrinterHelper:
 *
 *     private int pagenumber;
 *     private int pageoffset;
 *     private int rowoffset;
 *     private int column;
 *
 *
 *  8.8) This class hae now become not the PrimePrinterHelper
 *       but the PrimeGenerator
 *
 *   => Rename this class to PrimeGenerator
 *   => Extract => Rename => PrimeGenerator
 *
 *   8.9) Change also the name of primePrinterHelper to primeGenerator
 *
 *   8.10) RUN THE TEST .....
 *
 *  << Go to V09 to see the Result of this Refactoring >>
 *
 */




public class PrimePrinter {

    public static final int numberOfPrimes = 1000;

    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int[] primes = primePrinterHelper.generatePrimes();
        primePrinterHelper.printNumbers(primes, numberOfPrimes);
    }

}

class PrimePrinterHelper {

    private final int numberOfPrimes = 1000;
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private final int[] primes = new int[numberOfPrimes + 1];
    private int pagenumber;
    private int pageoffset;
    private int rowoffset;
    private int column;
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

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
    }

}


