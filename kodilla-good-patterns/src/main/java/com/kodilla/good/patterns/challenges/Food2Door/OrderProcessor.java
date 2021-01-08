package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderProcessor {
    private Supplier supplierOrderService;
    private FoodOrderRepository orderRepository;
    private static final String EXTRAFOODSHOP = "EXTRAFOODSHOP";
    private static final String HEALTHYSHOP = "HEALTHYSHOP";
    private static final String GLUTENFREESHOP = "GLUTENFREESHOP";

    public OrderProcessor(FoodOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        switch (orderRequest.getSupplier()) {
            case (EXTRAFOODSHOP):
                supplierOrderService = new ExtraFoodShop();
                break;
            case (HEALTHYSHOP):
                supplierOrderService = new HealthyShop();
                break;
            case (GLUTENFREESHOP):
                supplierOrderService = new GlutenFreeShop();
                break;
            default:
                System.out.println(orderRequest.getSupplier() + " not found in database.");
        }

        boolean isOrderAccepted = supplierOrderService.process(orderRequest);
        if (isOrderAccepted) {
            orderRepository.createOrder(orderRequest);
            return new OrderDto(supplierOrderService, orderRequest.getProduct(), orderRequest.getAmount(), true);
        } else {
            return new OrderDto(supplierOrderService, orderRequest.getProduct(), orderRequest.getAmount(),false);
        }
    }
}
