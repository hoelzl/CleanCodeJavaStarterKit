package de.mhoelzl.training.kata02.V07;

/**
 *
 * Step 7: Change NumberPrinter invoke to print(int[] numbers, int numberOfNumbers)
 * =======================================================================

 * * 7.1) Change NumberPrinter invoke() to print()
 *        Refactor => Rename => print()

 * * 7.2) Change the print() method  call from
 *
 *       public void printNumbers(int[] numbers, int numberOfNumbers) {
 *         new NumberPrinter(linesPerPage, columns, numbers, numberOfNumbers).print();
 *     }
 *
 *     To
 *
 *     public void printNumbers(int[] numbers, int numberOfNumbers) {
 *         new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
 *     }
 *
 *
 *
 * *   => This will cause errors! to fix them:
 *
 * * 7.3) Change the NumberPrinter Constrctor from
 *
 *    public NumberPrinter(int linesPerPage, int columns, int[] numbers, int numberOfNumbers) {
 *
 *    To:  public NumberPrinter(int linesPerPage, int columns) {...}
 *
 *  7.8) Cut numbers and numberOfNumber from NumberPrinter Constructor body:
 *        this.numbers = numbers;
 *        this.numberOfNumbers = numberOfNumbers
 *
 *    => The NumberPrinter Constructor looks now like this:
 *
 *        public NumberPrinter(int linesPerPage, int columns) {
 *         this.linesPerPage = linesPerPage;
 *        this.columns = columns;
 *     }
 *
 *
 *
 *
 ** 7.9) Change the Argument list of print from
 *       public void print() {
 *       to: public void print(int[] numbers, int numberOfNumbers) {
 *

 *  7.10) Paste the assignment of numbers and numberOfNumbers to the print method:
 *
 *    public void print(int[] numbers, int numberOfNumbers) {
 *        this.numbers = numbers;
 *  *     this.numberOfNumbers = numberOfNumbers
 *  ...
 *
 * 7.11) RUN THE TEST...
 *
 * 7.12) Intersting! the IDE said, We never used numbers and numberOfNumbers!
 *       So We can delete them from print
 *
 *
 * 7.11) RUN THE TEST...
 *  STEP 7 is DONE
 *
 *  << Go to V08 to see the Result of this Refactoring >>
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
        new NumberPrinter(linesPerPage, columns, numbers, numberOfNumbers).invoke();
    }

}


