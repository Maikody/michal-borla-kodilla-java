package com.kodilla.good.patterns.challenges;

public class OrderApp {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderProcessor orderProcessor = new ProductOrderProcessor(
                new MailService(), new LaptopOrderService(), new LaptopOrderRepository());
        orderProcessor.process(orderRequest);

        OrderRequestRetriever anotherOrderRequestRetriever = new OrderRequestRetriever();
        OrderRequest anotherOrderRequest = anotherOrderRequestRetriever.retrieve();

        ProductOrderProcessor anotherOrderProcessor = new ProductOrderProcessor(
                new MailService(), new PhoneOrderService(), new PhoneOrderRepository());
        anotherOrderProcessor.process(anotherOrderRequest);
    }

}
