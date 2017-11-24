package br.com.joaomassan.crxrainyhills.session;

/**
 * I decided to implement this Application Exception
 * to make it ease to notify any problem related to 
 * arguments passed to the service.
 */
public class InvalidSurfaceException extends Exception {

    public InvalidSurfaceException(Exception cause) {
        super(cause.getMessage(), cause);
    }
}
