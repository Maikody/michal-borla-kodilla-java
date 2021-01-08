package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderProcessor {
    private Supplier supplierOrderService;
    private FoodOrderRepository orderRepository;

    public OrderProcessor(Supplier supplierOrderService,
                          FoodOrderRepository orderRepository) {
        this.supplierOrderService = supplierOrderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrderAccepted = supplierOrderService.process(orderRequest);
        if (isOrderAccepted) {
            orderRepository.createOrder(orderRequest);
            return new OrderDto(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getAmount(), true);
        } else {
            return new OrderDto(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getAmount(),false);
        }
    }
}
