package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderProcessor {
    private Supplier supplierOrderService;
    private FoodOrderRepository orderRepository;

    public OrderProcessor(FoodOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        supplierOrderService = SupplierFactory.getSupplier(orderRequest.getSupplier());
        boolean isOrderAccepted = supplierOrderService != null && supplierOrderService.process(orderRequest);
        if (isOrderAccepted) {
            orderRepository.createOrder(orderRequest);
            return new OrderDto(supplierOrderService, orderRequest.getProduct(), orderRequest.getAmount(), true);
        } else {
            return new OrderDto(supplierOrderService, orderRequest.getProduct(), orderRequest.getAmount(),false);
        }
    }
}
