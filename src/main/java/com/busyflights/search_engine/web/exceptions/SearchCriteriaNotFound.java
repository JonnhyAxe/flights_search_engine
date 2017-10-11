package com.busyflights.search_engine.web.exceptions;


/**
 * Search Criteria Not Found Exception
 *
 */
public class SearchCriteriaNotFound extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -3746929043353775316L;

    public SearchCriteriaNotFound() {
        super();
    }

    public SearchCriteriaNotFound(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SearchCriteriaNotFound(final String message) {
        super(message);
    }

    public SearchCriteriaNotFound(final Throwable cause) {
        super(cause);
    }

}

