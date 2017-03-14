package com.github.rvesse.airline.types.numerics.bases;

import com.github.rvesse.airline.types.numerics.ComplexNumericTypeConverter;
import com.github.rvesse.airline.types.numerics.NumericCandidate;

public class Octal extends ComplexNumericTypeConverter {

    @Override
    protected int getRadix(NumericCandidate candidate) {
        return 8;
    }

}