package com.github.enzoDante.controllers;

import com.github.enzoDante.exception.UnsuportedMathOperationException;
import com.github.enzoDante.utilities.BasicMath;
import com.github.enzoDante.utilities.NumericOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math") // permite que todos os endpoints aq comecem com /math
public class MathController {

    private final NumericOperations op = new NumericOperations();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double Sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("digite um numero valido");
        return BasicMath.sum(op.convertToDouble(numberOne), op.convertToDouble(numberTwo));
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!op.isNumeric((numberOne)) || !op.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("");
        return BasicMath.sub(op.convertToDouble(numberOne), op.convertToDouble(numberTwo));
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("");
        return BasicMath.mult(op.convertToDouble(numberOne), op.convertToDouble(numberTwo));
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!op.isNumeric(numberOne) || !op.isNumeric(numberTwo) || numberTwo.equals("0")) throw new UnsuportedMathOperationException("");
        return BasicMath.div(op.convertToDouble(numberOne), op.convertToDouble(numberTwo));
    }

    @RequestMapping("/media/{numberOne}/{numberTwo}")
    public Double media(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) throw new UnsuportedMathOperationException("");
        return BasicMath.media(op.convertToDouble(numberOne), op.convertToDouble(numberTwo));
    }
    @RequestMapping("/sqrt/{numberOne}")
    public Double sqrt(
            @PathVariable("numberOne") String numberOne
    ){
        if(!op.isNumeric(numberOne)) throw new UnsuportedMathOperationException("");
        return BasicMath.sqrt(op.convertToDouble(numberOne));
    }
}
