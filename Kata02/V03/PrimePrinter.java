package Kata02.V03;



/**
 *
 * Step 3: Make all private Variable from
 * PrimePrinterHelper invoke() to Instance Variables and rename them!
 * =================================================================
 * * Refactor -> Extract -> Field.. Initialize in Field Declaration
 * * 3.1)  And give them better names!
 * * 3.2)  int M => numberOfPrimes
 * * 3.3)  int RR => linesPerPage
 * * 3.4)  int CC => columns
 * * 3.5)  int ORDMAX => ordmax
 * * 3.6)  int[] p => int[] primes
 * * 3.7)  int PAGENUMBER => pagenumer
 * * 3.8)  int PAGEOFFSET => pageoffset
 * * 3.9)  int ROWOFFSET => rowoffset
 * * 3.10) int C => column;
 * * 3.11) int J => candidate
 * * 3.12) int K => primeIndex
 * * 3.13) boolean JPRIME => possiblyPrime
 * * 3.14) int ORD => ord
 * * 3.15) int SQUARE => square
 * * 3.16) int N=0 => n
 * * 3.17) int MULT[] => multiples
 *
 * STEP 3 DONE!
 *
 *  << Go to V04 to see the Result of the Refactoring! >>
 */


public class PrimePrinter {
    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        primePrinterHelper.invoke();
    }

}

class PrimePrinterHelper {
    public void invoke() {
        final int M = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORDMAX = 30;
        int P[] = new int[M + 1];
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int C;
        int J;
        int K;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N = 0;
        int MULT[] = new int[ORDMAX + 1];

        J = 1;
        K = 1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (K < M) {
            do {
                J += 2;
                if (J == SQUARE) {
                    ORD++;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K] = J;
        }
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= M) {
            System.out.print("The First ");
            System.out.print(Integer.toString(M));
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET = PAGEOFFSET; ROWOFFSET <= PAGEOFFSET + RR - 1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= M)
                        System.out.printf("%10d", P[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR * CC;
        }
    }

}


