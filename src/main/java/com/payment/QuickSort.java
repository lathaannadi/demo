package com.payment;

import java.util.Date;
import java.util.List;

public class QuickSort {

    public static void quickSort(List<Payment> payments, int start, int end){
        if(start<end) {
            int partition = findPivot(payments, start, end);
            quickSort(payments, start, partition-1);
            quickSort(payments, partition+1, end);
        }
    }

    private static int findPivot(List<Payment> payments, int start, int end) {
        Payment payment = payments.get(end);
        Date date = payment.getDate();
        int i = start-1;

        for(int j= start; j<end; j++) {
            Payment paymentJ = payments.get(j);
            if (paymentJ.getDate().after(date)) {
                i++;
                Payment paymentI = payments.get(i);
                payments.set(i, paymentJ);
                payments.set(j, paymentI);
            }
        }
        Payment paymentI = payments.get(i+1);
        payments.set(i+1, payment);
        payments.set(end, paymentI);
        return i+1;
    }
}
