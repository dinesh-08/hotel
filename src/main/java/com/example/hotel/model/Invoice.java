package com.example.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoice_id;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingDetails booking;

    private Double amount;

    
    public Long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public BookingDetails getBooking() {
        return booking;
    }

    public void setBooking(BookingDetails booking) {
        this.booking = booking;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_id=" + invoice_id +
                ", booking=" + booking +
                ", amount=" + amount +
                '}';
    }
}

