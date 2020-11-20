package com.company.Week2.Mission3;

import java.io.IOException;

public class LedgerMain {
    public static void main(String[] args) throws IOException {
        Writer.initialize();
        Writer.work();
        System.out.println("Thanks for using JH Ledger Manager!");
    }
}
