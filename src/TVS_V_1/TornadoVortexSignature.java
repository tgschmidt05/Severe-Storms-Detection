package TVS_V_1;


public class TornadoVortexSignature {
	public static void main(String[] args) {
		LoadData radar = new LoadData();
		VelocityIdentifiers check1 = new VelocityIdentifiers();
		
		radar.createArray();
		radar.displayLegend();
		System.out.println("");
		System.out.println("SCANNING...");
		System.out.println("");
		System.out.println("");
		System.out.println("Missing pixels: ");
		radar.missingPixels();
		//radar.displayTempPixels();
		System.out.println("");
		check1.outBoundAnomalyCheck();
		System.out.println("Anomalies:");
		if (check1.getAnomalyListx().size() != 0 ) {
			System.out.print("X: ");
			System.out.println(check1.getAnomalyListx().toString());
			System.out.print("Y: ");
			System.out.println(check1.getAnomalyListy().toString());
		}
		else {
			System.out.println("No anomalies detected...");
		}
		System.out.println("");
		System.out.println("Potential Tornadoes:");
		if (check1.getTornadoListx().size() != 0) {
			System.out.print("X: ");
			System.out.println(check1.getTornadoListx().toString());
			System.out.print("Y: ");
			System.out.println(check1.getTornadoListy().toString());
		}
		else {
			System.out.println("No potential tornadoes detected...");
		}
		System.out.println("");
		System.out.println("Confirmed Tornadoes:");
		check1.confirmTornado();
		if (check1.getConfirmedTornadoListx().size() != 0) {
			System.out.print("X: ");
			System.out.println(check1.getConfirmedTornadoListx().toString());
			System.out.print("Y: ");
			System.out.println(check1.getConfirmedTornadoListy().toString());
		}
		else {
			System.out.println("No confirmed tornadoes detected...");
		}
	}
}