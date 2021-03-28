package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxiOrderTestSuite {

    @Test
    void testBasicTaxiOrderGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();

        BigDecimal calculatedCost = theOrder.getCost();

        assertEquals(new BigDecimal("5.00"), calculatedCost);
    }

    @Test
    void testBasicTaxiOrderGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();

        String description = theOrder.getDescription();

        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        BigDecimal calculatedCost = theOrder.getCost();

        assertEquals(new BigDecimal("40.00"), calculatedCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("Drive a course by Taxi network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal("37.00"), theCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("Drive a course by MyTaxi network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal("29.00"), theCost);
    }

    @Test
    public void testUberWithTwoChildSeatsGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("Drive a course by Uber network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getCost());

        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal("57.00"), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getDescription());

        String description = theOrder.getDescription();

        assertEquals("Drive a course by Taxi network express service variant VIP + child seat", description);
    }

}