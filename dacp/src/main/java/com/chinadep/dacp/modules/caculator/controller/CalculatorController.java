package com.chinadep.dacp.modules.caculator.controller;

import com.chinadep.dacp.common.api.CommonResult;
import com.chinadep.dacp.modules.caculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cal")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/v1")
    public CommonResult<Long> cal() {
        Long res = calculatorService.cal();
        return CommonResult.success(res);
    }
}
