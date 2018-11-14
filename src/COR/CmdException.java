package COR;

/**
 * Exception à lancer si l'on veut qu'une exception se lance 
 * lorsque le COR n'execute pas une commande
 *
 */
public class CmdException extends Exception {

	public CmdException() {
		super();
	}

	public CmdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CmdException(String message, Throwable cause) {
		super(message, cause);
	}

	public CmdException(String message) {
		super(message);
	}

	public CmdException(Throwable cause) {
		super(cause);
	}
	

}
