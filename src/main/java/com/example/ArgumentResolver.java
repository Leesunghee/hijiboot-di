package com.example;

import java.io.InputStream;

/**
 * Created by leesunghee on 2017. 2. 11..
 */
public interface ArgumentResolver {
    Argument resolve(InputStream stream);
}
