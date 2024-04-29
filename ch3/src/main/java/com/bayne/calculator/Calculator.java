package com.bayne.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer sum(final String filePath) throws IOException {
        return lineReadTemplate(filePath, (line, res) -> {
            Integer num = Integer.parseInt(line);
            return res + num;
        }, 0);
    }

    public Integer multiply(final String filePath) throws IOException {
        return lineReadTemplate(filePath, (line, res) -> {
            Integer num = Integer.parseInt(line);
            return res * num;
        }, 1);
    }

    public String concatenate(final String filePath) throws IOException {
        return lineReadTemplate(filePath, (line, res) -> res + line, "");
    }

    private <T> T fileReadTemplate(final String filePath, final BufferedReaderCallback<T> callback) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return callback.doSomethingWithReader(br);
        }
    }

    private <T> T lineReadTemplate(final String filePath, final LineCallback<T> callback, final T initVal) throws IOException {
        return fileReadTemplate(filePath, br -> {
            T res = initVal;
            String line;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
        });
    }
}
