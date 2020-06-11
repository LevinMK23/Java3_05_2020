package lesson6;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Example1 {

    private static final Logger LOG = Logger.getLogger(Example1.class);

    static void foo() {
        LOG.debug("func execution");
    }

    public static void main(String[] args) {
        LOG.debug("OK");
        foo();
    }
}
