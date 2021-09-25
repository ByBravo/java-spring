package cl.commander.micro_inventory.error;

public class MessageException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3523543564922949919L;
	
	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public MessageException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
}
