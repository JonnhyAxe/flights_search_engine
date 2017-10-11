package com.busyflights.search_engine.services.suppliers.crazy_air.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirRequest;
import com.busyflights.search_engine.services.suppliers.crazy_air.domain.CrazyAirResponse;

/**
 * Crazy Air Service Bean
 *
 */
@Service
public class CrazyAirServiceBean implements CrazyAirService {

    /*
     * (non-Javadoc)
     *
     * @see com.busyflights.search_engine.services.suppliers.crazy_air.service.
     * CrazyAirService#searchCrazyFlights(com.busyflights.search_engine.services
     * .suppliers.crazy_air.domain.CrazyAirRequest)
     */
    @Override
    public List<CrazyAirResponse> searchCrazyFlights(CrazyAirRequest crazyAirRequest) {

        // TODO Auto-generated method stub
        return null;
    }

}
