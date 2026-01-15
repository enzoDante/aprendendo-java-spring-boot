package com.github.enzoDante.utilities;

import com.github.enzoDante.exception.UnsuportedMathOperationException;

public class NumericOperations {
    public boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
    public Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsuportedMathOperationException("Digite certo");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
