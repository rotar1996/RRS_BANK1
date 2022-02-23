package com.projectLoans;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final DecimalFormat df = new DecimalFormat("0.00");
    public void   initializePSPDFKit() throws PSPDFKitInitializeException {
        PSPDFKit.initializeTrial();
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bun venit pe pagina de calcul.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Tastati ce anume doriti.");
        String whatDo = scanner.next();

            if (!whatDo.contains("credit") ){
                System.out.println(" Acest meniu nu exista");
            System.exit(1);
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Pentru inceput ce salar net aveti?:");
        Double NetSalary = scanner.nextDouble();
         if (NetSalary < 1000) {
             System.out.println("Salariul minim pentru creditare este de 1000 Ron");
             TimeUnit.SECONDS.sleep(1);
             System.out.println(" Ne pare rau dar nu putem continua aceasta cerere.");
             System.exit(1);
         }
        System.out.println(" Care sunt cheltuielile totale ");
        Double Expenses = scanner.nextDouble();
        double DiferenceAmout = NetSalary - Expenses;

        int Percent =100;
        int MaxGrade = 50/100;
//
//  what the hell
        if ((DiferenceAmout) > (  NetSalary)) {
            System.out.println("Gradul dumneavoastra de indatorare este depasit");
            TimeUnit.SECONDS.sleep(1);
            System.exit(1);
        }

        //
        //trebuie facut formula de calcul
        System.out.println("Ce suma doriti sa imprumutati?");
        double RequestAmout = scanner.nextDouble();
        System.out.println("perioada in ani; ");
        double HowMounts = scanner.nextDouble();
        HowMounts= HowMounts *12;
        System.out.println(" Dobanda platita %");
        double Rate = scanner.nextDouble();
        Rate =( Rate/100)/12;
        //double Rate= (3/100) /12;  // nu functioneaza
        double payments = (RequestAmout * Rate) / (1 - Math.pow(1 + Rate, -HowMounts));
        System.out.println("Rata lunare este de: " + df.format(payments) + " RON");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Suma totala platita este de: " + (df.format (payments * HowMounts))+ " RON");









    }

}
