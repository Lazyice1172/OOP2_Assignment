package ie.tudublin;

public class Main {

	public void startUI() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new Audio());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.startUI();

	}
}