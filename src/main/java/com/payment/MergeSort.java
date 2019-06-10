package com.payment;

import java.util.List;

public class MergeSort {

    public static void sort(List<Payment> dates, int start, int end) {
        //done sorting
        if (end <= start) {
            return;
        }

        int mid = (start + end) / 2;
        sort(dates, start, mid); // sort left half
        sort(dates, mid + 1, end); // sort right half
        merge(dates, start, mid, end); // merge sorted results
    }

    public static void merge(List<Payment> payments, int start, int mid, int end) {
        Payment sortedDates[] = new Payment[end - start + 1];

        // index counter for the left side of the array
        int leftIdx = start;
        // index counter for the right side of the array
        int rightIdx = mid + 1;
        int k = 0;
        while (leftIdx <= mid && rightIdx <= end) {
            Payment paymentLeft = payments.get(leftIdx);
            Payment paymentRight = payments.get(rightIdx);

            if (paymentLeft.getDate().after(paymentRight.getDate())) {
                sortedDates[k] = paymentLeft;
                k++;
                leftIdx++;
            } else {
                sortedDates[k] = paymentRight;
                k++;
                rightIdx++;
            }
        }


        if (leftIdx <= mid) {
            while (leftIdx <= mid) {
                sortedDates[k] = payments.get(leftIdx);
                leftIdx = leftIdx + 1;
                k = k + 1;
            }
        } else if (rightIdx <= end) {
            while (rightIdx <= end) {
                sortedDates[k] = payments.get(rightIdx);
                rightIdx = rightIdx + 1;
                k = k + 1;
            }
        }

        // copy over the sorted dates to the payments
        for (int i = 0; i < sortedDates.length; i++) {
            payments.set(start + i, sortedDates[i]);
        }
    }

}
