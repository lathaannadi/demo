package com.payment;



import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "payment")
public class Payment {
    @Id
    @SequenceGenerator(name="PAYMENT_SEQ_GENERATOR", sequenceName="PAYMENT_SEQ", initialValue = 5, allocationSize = 20)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENT_SEQ_GENERATOR")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="PAYMENTNUMBER")
    private Integer paymentNumber;

    @Column(name="AMOUNT")
    private Double amount;

    private Date date;


    public Payment(Integer paymentNumber, Double amount, Date date){
        this.paymentNumber = paymentNumber;
        this.amount = amount;
        this.date = date;
    }

    public Payment(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public Integer getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(Integer paymentNumber) {
        this.paymentNumber = paymentNumber;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if(this.getDate().equals(payment.getDate()) &&
            this.getAmount().equals(payment.getAmount()) &&
            this.getPaymentNumber().equals(payment.getPaymentNumber())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, paymentNumber);
    }

    @Override
    public String toString(){
        return String.format("Payment Details::" + id + "  "+paymentNumber +" "+amount+ "  " +date);

    }

}
