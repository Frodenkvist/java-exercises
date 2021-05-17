package com.hackosynth.naturalnumber;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class NaturalNumber {
    public static Classification classify(int naturalNumber) {
        throw new NotImplementedException();
    }

    public enum Classification {
        DEFICIENT, PERFECT, ABUNDANT
    }
}

