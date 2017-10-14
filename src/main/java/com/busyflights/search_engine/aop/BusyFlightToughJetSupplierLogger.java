package com.busyflights.search_engine.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.busyflights.search_engine.services.tough_jet.domain.ToughJetFlighTimeInterval;
/**
 * <class description>
 *
 */
@Aspect
@Component
public class BusyFlightToughJetSupplierLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusyFlightToughJetSupplierLogger.class);

    @Before("execution(* com.busyflights.search_engine.services.tough_jet.service.ToughJetService.searchToughJetFlights(..)) && args(toughJetFlighTimeInterval)")

    public void beforeSearchCrazyFlights(ToughJetFlighTimeInterval toughJetFlighTimeInterval) {

        LOGGER.info("Tough Jet Service received a request : {}", toughJetFlighTimeInterval);

    }

    @AfterReturning(pointcut = "execution(* com.busyflights.search_engine.services.tough_jet.service.ToughJetService.searchToughJetFlights(..))", returning = "result")
    public void afterSearch(JoinPoint joinPoint, Object result) {

        LOGGER.info("Tough Jet Service reply with : {}", result);
    }

}
