package com.bayne.calculator;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderCallback<T> {

    T doSomethingWithReader(BufferedReader br) throws IOException;
}
