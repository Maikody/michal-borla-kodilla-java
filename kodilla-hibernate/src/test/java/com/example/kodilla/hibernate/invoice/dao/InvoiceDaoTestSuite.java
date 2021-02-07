package com.example.kodilla.hibernate.invoice.dao;

import com.example.kodilla.hibernate.invoice.Invoice;
import com.example.kodilla.hibernate.invoice.Item;
import com.example.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoService() {
        Product notebook = new Product("MacBook Pro");
        Product phone = new Product("iPhone 12 Pro");
        Product tablet = new Product("iPad 10.2");
        productDao.saveAll(Arrays.asList(notebook, phone, tablet));

        Item notebookItem = new Item(notebook, new BigDecimal("1500"),2);
        Item phoneItem = new Item(phone, new BigDecimal("1000"),5);
        Item tabletItem = new Item(tablet, new BigDecimal("1250"),4);

        Invoice invoice = new Invoice("01020304");
        invoice.getItems().add(notebookItem);
        invoice.getItems().add(phoneItem);
        invoice.getItems().add(tabletItem);
        invoiceDao.save(invoice);

        notebookItem.setInvoice(invoice);
        phoneItem.setInvoice(invoice);
        tabletItem.setInvoice(invoice);

        itemDao.saveAll(Arrays.asList(notebookItem, phoneItem, tabletItem));

        int invoiceID = invoice.getId();

        assertNotEquals(0, invoiceID);

        itemDao.deleteAll();
        invoiceDao.deleteAll();
        productDao.deleteAll();
    }

}
