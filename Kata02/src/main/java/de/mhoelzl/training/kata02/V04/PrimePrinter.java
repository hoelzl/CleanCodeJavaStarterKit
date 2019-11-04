package de.mhoelzl.training.kata02.V04;


/**
 *
 * Step 4: Extract Functions from the main Sections
 * =================================================================
 * In PrimePrinterHelper invoke the top code generates prime number
 *  This is the:  while (primeIndex < numberOfPrimes){..}
 *
 * The bottom part prints a report.
 * This is from:  pagenumber = 1; to the end of the code.
 *
 * We need to extract the two sections in their own functions.
 * The simples solution is to extract the bottom part in
 * the method printNumbers and let the top part in invoke()
 *
 * * 4.1)  Select 'pagenumber = 1' to the end of the code to }
 * * 4.2)  Refactor => Extract => Method..
 * * 4.3)  Name: printNumbers
 * *
 * *  printNumbers() seems to print primes
 * *  but this method could print any array of number
 * *  not just primes. To make it generic we need arguments
 *
 * * 4.5) Change private void printNumber() to
 *               private void printNumber(int[] primes, int numberOfPrimes)
 *
 * * 4.6) Change the call printNumbers() in invoke() into
 *        invoke(){.....  printNumbers(primes, numberOfPrimes}
 *
 *
 * * 4.7) Rename the printNumbers parameter to signal that it can print any number array>
 *        from: printNumbers(int[] primes, int numberOfPrimes)
 *        to  : printNumbers(int[] numbers, int numberOfNumbers)
 *
 * * 4.8) Run the Test....
 *
 * STEP 4 DONE!
 *
 *  *  * << Go to V05 to see the Result of the Refactoring! >>
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
        pagenumber = 1;
        pageoffset = 1;
        while (pageoffset <= numberOfPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfPrimes));
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfPrimes)
                        System.out.printf("%10d", primes[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }

}


