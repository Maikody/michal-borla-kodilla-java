package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectorTestSuite {

    private static ShapeCollector collector;
    private static int testCounter = 1;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @BeforeEach
    public void setupBeforeEveryTest() {
        collector = new ShapeCollector();
        System.out.println("Running test #" + testCounter++);
    }

    @Nested
    @DisplayName("Tests for adding/removing data from collection")
    public class TestAdditionsRemovals {

        @DisplayName("If figure is added to collection, should return expected number of objects in collection")
        @Test
        public void testAddFigure() {
            collector.addFigure(new Circle(2));
            assertEquals(1, collector.showFigures().size());
        }

        @DisplayName("If figure which doesn't exist in collection is attempted to be removed, should return false")
        @Test
        public void testRemoveNonExistingFigure() {
            boolean result = collector.removeFigure(new Circle(2));
            assertFalse(result);
        }

        @DisplayName("If figure which exists in collection is removed, should return true")
        @Test
        public void testRemoveExistingFigure() {
            Circle circle = new Circle(2);
            collector.addFigure(circle);
            boolean result = collector.removeFigure(circle);
            assertTrue(result);
            assertEquals(0, collector.showFigures().size());
        }
    }

    @Nested
    @DisplayName("Tests for retrieving data from collection")
    public class TestRetrievals {

        @DisplayName("If created figure is the same like a figure existing in collection, should return true ")
        @Test
        public void testGetFigure() {
            Circle circle = new Circle(2);
            collector.addFigure(circle);
            assertSame(circle, collector.getFigure(0));
        }

        @DisplayName("If collection of figures consists all figures added to this collection, should return true")
        @Test
        public void testShowFigures() {
            List<Shape> expectedShapeCollection = new ArrayList<>();

            Square square = new Square(2);
            Circle circle = new Circle(2);
            Triangle triangle = new Triangle(2, 2);

            collector.addFigure(square);
            collector.addFigure(circle);
            collector.addFigure(triangle);
            expectedShapeCollection.add(square);
            expectedShapeCollection.add(circle);
            expectedShapeCollection.add(triangle);

            assertEquals(expectedShapeCollection, collector.showFigures());
        }
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

}
