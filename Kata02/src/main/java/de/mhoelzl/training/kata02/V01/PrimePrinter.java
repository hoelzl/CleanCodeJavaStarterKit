package de.mhoelzl.training.kata02.V01;


// Beispiel: Donald Knuth Buch Literate Programming
// Generated Code from Donald Knuth Framework> Snips => Runnable Program

/**
 *
 * Step 1: Extract a Class from the main function
 * ================================================
 * * 1.1) Select all the code within the main method
 * * 1.2) Right Mouse Click => Refactor => Extract => Method Object...
 * * 1.3) Name: PrimePrinterHelper.   (We 're going to change the name later.)
 *
 * * 1.4) Change invoke from
 *        private static void invoke() => public into no static method
 *
 * * 1.5) Change the Call in Main into:
 *        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
 *        primePrinterHelper.invoke();
 *
 * * 1.6) Run the Test ...
 *
 * Step 1 DONE!
 *
 * << Go to V02 to see the Result of the Refactoring! >>
 *
 */

public class PrimePrinter {
    public static void main(String[] args) {
        final int M = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORDMAX = 30;
        int P[] = new int[M+1];
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int C;
        int J;
        int K;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N=0;
        int MULT[] = new int[ORDMAX+1];

        J=1;
        K=1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (K < M) {
            do {
                J += 2;
                if (J == SQUARE) {
                    ORD++;
                    SQUARE=P[ORD]*P[ORD];
                    MULT[ORD-1]=J;
                }
                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K]=J;
        }
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= M) {
            System.out.print("The First ");
            System.out.print(Integer.toString(M));
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C=0; C <= CC-1; C++)
                    if (ROWOFFSET+C*RR <= M)
                        System.out.printf("%10d", P[ROWOFFSET+C*RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;
        }
    }
}
