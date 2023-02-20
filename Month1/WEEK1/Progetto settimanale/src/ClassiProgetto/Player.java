/**
 * 
 */
package ClassiProgetto;

abstract public class Player {
	protected String title;
	protected String tipo;

	public Player(String title) {
		this.title = title;
	}

	protected void play() {
	};

	protected void show() {
	};

	protected String getTipo() {
		return this.tipo;
	}
}
