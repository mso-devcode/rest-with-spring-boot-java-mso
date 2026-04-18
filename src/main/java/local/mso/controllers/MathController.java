package local.mso.controllers;

import local.mso.exception.RecursoNaoEncontradoException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new RecursoNaoEncontradoException("The value is not numeric!");
        }
        return converterToDouble(numberOne) + converterToDouble(numberTwo);
    }

    private Double converterToDouble(String strNumber)  throws Exception {
        if (strNumber.isEmpty() || strNumber == null){ throw new RecursoNaoEncontradoException("The value is not numeric!");}
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber.isEmpty() || strNumber == null){ return false;}
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
