package com.busyflights.search_engine.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirRequest;

@Aspect
@Component
public class BusyFlightCrazyAirSupplierLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusyFlightCrazyAirSupplierLogger.class);

    @Before("execution(* com.busyflights.search_engine.services.suppliers.crazy_air.service.CrazyAirService.searchCrazyFlights(..)) && args(crazyAirRequest)")
    public void beforeSearchCrazyFlights(CrazyAirRequest crazyAirRequest) {

        LOGGER.info("Crazy Air Service received a request [{}]", crazyAirRequest);

    }

    @AfterReturning(pointcut = "execution(* com.busyflights.search_engine.services.suppliers.crazy_air.service.CrazyAirService.searchCrazyFlights(..))", returning = "result")
    public void afterSearch(JoinPoint joinPoint, Object result) {

        LOGGER.info("Crazy Air Service reply with [{}]", result);
    }

}
