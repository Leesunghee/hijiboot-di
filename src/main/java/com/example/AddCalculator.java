package com.example;

import org.springframework.stereotype.Component;

/**
 * Created by leesunghee on 2017. 2. 11..
 */
@Component
public class AddCalculator implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
