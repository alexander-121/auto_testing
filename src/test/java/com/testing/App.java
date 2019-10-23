package com.testing;

import org.junit.Test;

public class App {

    @Test
    public static void main (String[] args)
    {
        PageTest test = new PageTest();
        test.setUp();
        test.openPage();
        test.closeUp();
    }
}
