package Kata02.V05;


/**
 *
 * Step 5: Pull the printNumbers(primes, numberOfPrimes) from invoke() out
 * =======================================================================
 * To separate the both functions invoke() and printNumbers(int[] primes, int numberOfPrimes)
 *  from each other, we should pul the call printNumbers(primes, numberOfPrimes) out of invoke()
 *
 *  The idea: invoke() should returns an array of primeNumbers
 *  and the printNumbers should print it.

 *
 * * 5.1)  Change void invoke() => int[] invoke()
 * * 5.2)  Let invoke return primes:  int[] invoke(){..return primes;}
 * * 5.3)  In main: save the call primePrinterHelper.invoke(); in int[] primes
 *         int[] primes =  primePrinterHelper.invoke();
 *
 * * 5.4)  cut the call: printNumbers(primes, numberOfPrimes);
 *          and past it in main to call it:
 *          primePrinterHelper.printNumbers(primes, numberOfPrimes);
 *
 *  To make this code compile we should change
 *  the printNumbers to public and we need the numberOfPrimes.
 *
 *  * 5.5)change private void printNumbers(int[] numbers, int numberOfNumbers)
 *      to     public void printNumbers(int[] numbers, int numberOfNumbers)
 *
 * * 5.6) Define public static final int numberOfPrimes = 1000;
 *        in the PrimePrinter Class.
 *
 * * 5.7) Runt the test...
 *
 * * STEP 5 ist DONE !
 * ==================
 *
 *  * << Go to V06 to see the Result of the Refactoring! >>
 */


public class PrimePrinter {
    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        primePrinterHelper.invoke();
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

    public void invoke() {
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
        printNumbers(primes, numberOfPrimes);
    }

    private void printNumbers(int[] numbers, int numberOfNumbers) {
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


