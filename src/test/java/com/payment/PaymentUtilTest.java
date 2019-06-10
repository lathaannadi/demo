package com.payment;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PaymentUtilTest {

    @Test
    public void testMergeSort10() {
        testMergeSort(10);
    }

    @Test
    public void testMergeSort100() {
        testMergeSort(100);
    }

    @Test
    public void testMergeSort1000() {
        testMergeSort(1000);
    }

    @Test
    public void testQuickSort10() {
        testQuickSort(10);
    }

    @Test
    public void testQuickSort100() {
        testQuickSort(100);
    }

    @Test
    public void testQuickSort1000() {
        testQuickSort(1000);
    }

    public void testMergeSort(int count) {
        List<Payment> payments = getPaymentObjects(count);
        long start = System.nanoTime();
        PaymentUtil.mergeSortPayment(payments);
//        System.out.println("=======================================================");
//        for (Payment payment : payments) {
//            System.out.println(payment.getDate().toString());
//       }
        List<Payment> descending = PaymentUtil.sortPaymentDescending(payments);
        Assert.assertEquals(payments, descending);
        Assert.assertEquals(payments.get(0).getDate(), descending.get(0).getDate());
        Assert.assertEquals(payments.get(8).getDate(), descending.get(8).getDate());
        if (count == 100)
            Assert.assertEquals(payments.get(88).getDate(), descending.get(88).getDate());
        if (count == 1000)
            Assert.assertEquals(payments.get(888).getDate(), descending.get(888).getDate());
        // ...
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time taken for Merge Sort "+count +" records ============="+timeElapsed);
    }


    public void testQuickSort(int count) {
        List<Payment> payments = getPaymentObjects(count);
        long start = System.nanoTime();
        PaymentUtil.quickSortPayment(payments);
//         System.out.println("=======================================================");
//        for (Payment payment : payments) {
//            System.out.println(payment.getDate().toString());
//        }
        List<Payment> descending = PaymentUtil.sortPaymentDescending(payments);
        Assert.assertEquals(payments, descending);
        Assert.assertEquals(payments.get(0).getDate(), descending.get(0).getDate());
        Assert.assertEquals(payments.get(8).getDate(), descending.get(8).getDate());
        if (count == 100)
            Assert.assertEquals(payments.get(88).getDate(), descending.get(88).getDate());
        if (count == 1000)
            Assert.assertEquals(payments.get(888).getDate(), descending.get(888).getDate());
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time taken for Quick Sort============="+timeElapsed);
    }

    @Test
    public void testMergeSortCopy() {
        List<Payment> payments = getPaymentObjects(10);
        List<Payment> paymentsCopy = new ArrayList<Payment>(payments);
        PaymentUtil.mergeSortPayment(payments);
        List<Payment> descending = PaymentUtil.sortPaymentDescending(payments);
        Assert.assertNotEquals(paymentsCopy, descending);
    }


    @Test
    public void testQuickSortCopy() {
        List<Payment> payments = getPaymentObjects(10);
        List<Payment> paymentsCopy = new ArrayList<Payment>(payments);
        PaymentUtil.quickSortPayment(payments);
        List<Payment> descending = PaymentUtil.sortPaymentDescending(payments);
        Assert.assertNotEquals(paymentsCopy, descending);
    }


    public List<Payment> getPaymentObjects(int count) {
        List<Payment> paymentObjects = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Random r = new Random();
            int nextPaymentNumber = r.nextInt((1000 - 1) + 1);
            LocalDate date = LocalDate.now().minus(Period.ofDays((ThreadLocalRandom.current().nextInt(365 * 70))));
            paymentObjects.add(new Payment(nextPaymentNumber, 1000.00 + nextPaymentNumber, java.sql.Date.valueOf(date)));
            //System.out.println(date.toString());
        }
        return paymentObjects;
    }


}
