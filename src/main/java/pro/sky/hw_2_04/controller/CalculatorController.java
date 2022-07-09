package pro.sky.hw_2_04.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw_2_04.CalculatorApplication;
import pro.sky.hw_2_04.service.CalculatorService;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String greeting(){
        return "<h1> Добро пожаловать в калькулятор <h1>";
    }
    private String buildResult(Integer a, Integer b, Number result, String operation){
        return a+ " " + operation + " " + b + " = " + result;
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false)Integer a,
                       @RequestParam(value = "num2",required = false)Integer b){
        if(Objects.isNull(a) || Objects.isNull(b)){
            return "Введите оба параметра!";
        }
        return buildResult(a,b,calculatorService.plus(a,b),"+");

    }
    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false)Integer a,
                       @RequestParam(value = "num2",required = false)Integer b){
        if(Objects.isNull(a) || Objects.isNull(b)){
            return "Введите оба параметра!";
        }
        return buildResult(a,b,calculatorService.minus(a,b),"-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false)Integer a,
                           @RequestParam(value = "num2",required = false)Integer b){
        if(Objects.isNull(a) || Objects.isNull(b)){
            return "Введите оба параметра!";
        }
        return buildResult(a,b,calculatorService.multiply(a,b),"*");
    }
    @GetMapping("/divedi")
    public String divedi(@RequestParam(value = "num1", required = false)Integer a,
                         @RequestParam(value = "num2",required = false)Integer b){
        if(Objects.isNull(a) || Objects.isNull(b)){
            return "Введите оба параметра!";
        }
        if (b==0){
            return "На ноль лучше не делить)";
        }
        return buildResult(a,b,calculatorService.divedi(a,b),"/");
    }
}
