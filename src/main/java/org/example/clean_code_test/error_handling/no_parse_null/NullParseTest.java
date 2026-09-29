package org.example.clean_code_test.error_handling.no_parse_null;

import java.util.logging.Logger;

public class NullParseTest {

    private static final Logger logger = Logger.getLogger("NullParseTest.class");

    public static void main(String[] args) {
        NullParseTest nullParseTest = new NullParseTest();
        Point p = new Point(23,22);

        nullTest(nullParseTest, p);
        double result = nullParseTest.xProjection(new Point(12,32),p);
    }

    private static void nullTest(NullParseTest nullParseTest, Point p) {
        try{
            nullParseTest.xProjection(null, p);
        }catch (IllegalArgumentException e){
            logger.info("Caught expected error : "+ e.getMessage());
        }
    }

    // Null pass check
    public double xProjection(Point p1, Point p2){
        assert p1 != null : "p1 should not be null";
        assert p2 != null : "p2 should not be null";

        if(p1 == null | p2 == null){
            throw new IllegalArgumentException("p1 or p2 shouldn't be null");
        }
        return (p2.x - p1.x) * 1.5;
    }
}

class Point{
    public final double x;
    public final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
