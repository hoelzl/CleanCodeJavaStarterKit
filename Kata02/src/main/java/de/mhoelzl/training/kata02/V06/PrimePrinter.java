package de.mhoelzl.training.kata02.V06;

/**
 *
 * Step 6: Separate invoke and printNumbers in different classes.
 * =======================================================================

 * * 6.1) Select invoke() => Refactor => Rename.. => generatePrimes()
 *
 *  We could have a PrimeGenerator class with int[] generatePrimes()
 *  and a NumberPrinter class with void printNumbers(int[] numbers, int numberOfNumbers)
 * *
 * *  => Extract a class from printNumbers(int[] numbers, int numberOfNumbers)
 *
 * * 6.2) Select the bodey of printNumber: Extract => Method Object => NumberPrinter
 * *      The new NumberPrinter class is a private inner class from the PrimePrinterHelper
 * *
 * * => We want this class to be outer class.
 *
 * * 6.3) Select NuperPrinter class => Refactor => Move..=> Name: NumberPrinter
 *        Deactivate the checkbox :  Pass outer class's Instance as a parameter.
 * *
 * * =>  Problem Detected
 * ========================
 * *  field PrimePrinterHelper.pageoffset
 * * field PrimePrinterHelper.column
 * * field PrimePrinterHelper.pagenumber
 * * field PrimePrinterHelper.rowoffset
 * * field PrimePrinterHelper.linesPerPage
 * *field PrimePrinterHelper.columns
 *  *will become inaccessible from method NumberPrinter.invoke()
 *
 *
 *  => We have to deal with all these problems to make the code compile and runable.
 *  => Most of them is easy to solve for example by defining the variables.
 *
 * * 6.4) In NumberPrinter invoke Repace
 *         pagenumber = 1;  => int pagenumber = 1;
 *         pageoffset = 1;  => int  pageoffset = 1;
 *
 *         for (rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
 *         for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++)
 *
 *         for (column = 0; column <= columns - 1; column++)
 *         for (int column = 0; column <= columns - 1; column++)
 *
 *
 *   => We still have the errors with column and linesPerPage
 *
 *   6.5) Pass in the columns and linesPerPage in the NumberPrinter Constructor
 *   public NumberPrinter(int linesPerPage, int columns, int[] numbers, int numberOfNumbers) {
 *
 *   => Define to instance variables> linesPerPage and columns:
 *   6.6) Refactoring: Create Field for Parameter 'linesPerPage
 *        and set them in the constructor. The result ist:
 *
 *   class NumberPrinter {
 *     private int linesPerPage;
 *     private int columns;
 *     private int[] numbers;
 *     private int numberOfNumbers;
 *
 *     public NumberPrinter(int linesPerPage, int columns, int[] numbers, int numberOfNumbers) {
 *         this.linesPerPage = linesPerPage;
 *         this.columns = columns;
 *         this.numbers = numbers;
 *         this.numberOfNumbers = numberOfNumbers;
 *     }
 *
 *
 *
 *   => Now there is no error more in NumberPrinter
 *      But now we get an error in PrimePrinter:
 *      Since the argument of NumberPrinter don't match any more:
 *
 *       public void printNumbers(int[] numbers, int numberOfNumbers) {
 *         new NumberPrinter(numbers, numberOfNumbers).invoke();
 *     }
 *
 *
 *  => We have to fix this problem!
 *
 *  6.7) Add linesPerPage and columns to the new NumberPrinter
 *
 *  * public void printNumbers(int[] numbers, int numberOfNumbers) {
 *  *         new NumberPrinter(linesPerPage, columns, numbers, numberOfNumbers).invoke();
 *  *     }
 *
 *
 *  * 6.8) RUN THE TEST....
 *
 *  STEP 6 is DONE!
 *
 *  << GO TO V07 to see the Result of this Refactoring >>
 *
 */



public class PrimePrinter {

    public static final int numberOfPrimes = 1000;

    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int[] primes = primePrinterHelper.invoke();
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

    public int[] invoke() {
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
        pagenumber = 1;
        pageoffset = 1;
        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfNumbers)
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }

}


