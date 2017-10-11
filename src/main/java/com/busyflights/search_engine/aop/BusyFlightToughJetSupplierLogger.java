package com.busyflights.search_engine.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlightRequest;

/**
 * <class description>
 *
 */
@Aspect
@Component
public class BusyFlightToughJetSupplierLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusyFlightCrazyAirSupplierLogger.class);

    @Before("execution(* com.busyflights.search_engine.services.tough_jet.service.ToughJetServiceBean.searchToughJetFlights(..)) && args(toughJetRequest)")
    public void beforeSearchCrazyFlights(ToughJetFlightRequest toughJetRequest) {

        LOGGER.info("Tough Jet Service received a request [{}]", toughJetRequest);

    }

    @AfterReturning(pointcut = "execution(* com.busyflights.search_engine.services.tough_jet.service.ToughJetServiceBean.searchToughJetFlights(..))", returning = "result")
    public void afterSearch(JoinPoint joinPoint, Object result) {

        LOGGER.info("Tough Jet Service reply with [{}]", result);
    }

}
