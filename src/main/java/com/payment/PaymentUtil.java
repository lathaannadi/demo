package com.payment;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class PaymentUtil {

    public static void mergeSortPayment(List<Payment> payments) {
        MergeSort.sort(payments, 0, payments.size()-1);
    }

    public static void quickSortPayment(List<Payment> payments) {
        QuickSort.quickSort(payments, 0, payments.size()-1);
    }

    public static List<Payment> sortPaymentDescending(List<Payment> payments) {
        List<Payment> sortedPayments = payments.stream()
                .sorted(Comparator.comparing(Payment::getDate).reversed())
                .collect(Collectors.toList());
        return sortedPayments;
    }



}
