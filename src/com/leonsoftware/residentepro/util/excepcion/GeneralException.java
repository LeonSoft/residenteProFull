/**
 *
 * @author LeonSoftware 2017
 */
package com.leonsoftware.residentepro.util.excepcion;


public class GeneralException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>SisgriException</code> without detail
     * message.
     */
    public GeneralException() {
    }

    /**
     * Constructs an instance of <code>SisgriException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GeneralException(String msg) {
        super(msg);
    }
}
