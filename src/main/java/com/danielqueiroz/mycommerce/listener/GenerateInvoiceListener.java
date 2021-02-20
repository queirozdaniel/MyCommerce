package com.danielqueiroz.mycommerce.listener;

import com.danielqueiroz.mycommerce.model.Order;
import com.danielqueiroz.mycommerce.service.InvoiceService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GenerateInvoiceListener {

    private InvoiceService invoiceService = new InvoiceService();

    @PrePersist
    @PreUpdate
    public void generate(Order order){
        if (order.wasPaid() && order.getInvoice() == null){
            this.invoiceService.generateInvoice(order);
        }
    }

}
