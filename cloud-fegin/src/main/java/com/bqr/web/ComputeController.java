package com.bqr.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bqr.domain.ComputeClientDTO;
import com.bqr.service.ComputeClient;
import com.bqr.service.ComputeClient2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Fegin接口", description = "openService接口")
public class ComputeController
{
    
    private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    ComputeClient computeClient;
    
    @Autowired
    ComputeClient2 computeClient2;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add()
    {
        return computeClient.add(10, 20);
    }
    
    @ApiOperation(value = "加法", response = Integer.class)
    @GetMapping("/add1")
    public Integer add(@ApiParam("加数A") @RequestParam(value = "a") Integer a,
        @ApiParam("加数B") @RequestParam(value = "b") Integer b)
    {
        Integer a1 = computeClient.getA(a);
//        Integer b1 = computeClient2.getB(b);
//        logger.info("getA === " + a1 + "------------ getB ===" + b1);
//        computeClient.add(a1, b1);
//        ComputeClientDTO dto = new ComputeClientDTO();
        return a1;
    }
    
}