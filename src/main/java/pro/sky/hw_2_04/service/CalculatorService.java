package pro.sky.hw_2_04.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Number plus(Integer a, Integer b){
        return a+b;
    }
    public Number minus(Integer a, Integer b){
        return a-b;
    }
    public Number multiply(Integer a, Integer b){
        return a*b;
    }
    public Number divedi(Integer a, Integer b){
        return a/b;
    }
}
