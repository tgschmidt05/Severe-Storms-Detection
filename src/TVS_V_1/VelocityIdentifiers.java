package TVS_V_1;
import java.util.ArrayList;

public class VelocityIdentifiers {
	private static final int xMax = 459;
	private static final int yMax = 459;
	private static final int neg64Kts = -16777120;
	private static final int neg50Kts = -16748384;
	private static final int neg36Kts = -16727872;
	private static final int neg26Kts = -16718848;
	private static final int neg20Kts = -16736768;
	private static final int neg10Kts = -16752128;
	private static final int neg1Kts = -5197648;
	private static final int zeroKts = -2236963;
	private static final int pos10Kts = -4145152;
	private static final int pos20Kts = -4155392;
	private static final int pos26Kts = -4165632;
	private static final int pos36Kts = -6277120;
	private static final int pos50Kts = -8388608;
	private static final int pos64Kts = -10485760;
	
	private static final int pos35or34Kts = -6013184;
	private static final int neg30or29Kts = -16722872;
	private static final int pos24or23Kts = -4156672;
	private static final int neg25or24Kts = -16720872;
	private static final int neg33or32Kts = -16724872;
	private static final int pos32or31Kts = -4693504;
	private static final int pos25or24Kts = -4160512;
	private static final int pos19or18Kts = -4151552;
	private static final int pos6or5Kts = -3421381;
	private static final int pos33or32Kts = -5221376;
	private static final int pos28or27Kts = -4164352;
	private static final int neg34or33Kts = -16725872;
	private static final int pos39or38Kts = -6541056;
	private static final int neg3or2Kts = -6643302;
	private static final int neg13or12Kts = -16745728;
	private static final int neg22or21Kts = -16731136;
	private static final int neg12or11Kts = -16747520;
	private static final int neg19or18Kts = -16740352;
	private static final int neg23or22Kts = -16724992;
	private static final int pos18or17Kts = -4150272;
	private static final int neg8or7Kts = -12419774;
	private static final int neg35or34Kts = -16730436;
	private static final int pos20or19Kts = -4154112;
	private static final int pos34or33Kts = -5485312;
	private static final int neg41or40Kts = -16738128;
	private static final int pos47or46Kts = -7332864;
	private static final int neg38or37Kts = -16733000;
	private static final int pos63or62Kts = -9961472;
	private static final int pos3or2Kts = -2829172;
	private static final int pos11or10Kts = -4146432;
	private static final int neg16or15Kts = -16742144;
	private static final int neg55or54Kts = -16755568;
	private static final int pos12or11Kts = -4147712;
	private static final int pos57or56Kts = -9175040;
	private static final int neg52or51Kts = -16751976;
	private static final int neg61or60Kts = -16766344;
	private static final int neg47or46Kts = -16740692;
	private static final int pos4or3Kts = -3026575;
	private static final int pos45or44Kts = -7068928;
	private static final int pos43or42Kts = -6804992;
	private static final int pos49or48Kts = -8124672;
	private static final int neg11or10Kts = -15308010;
	private static final int neg4or3Kts = -9531538;
	private static final int pos48or47Kts = -7860736;
	private static final int neg57or56Kts = -16759160;
	private static final int neg62or61Kts = -16769936;
	private static final int neg48or47Kts = -16745820;
	private static final int neg39or38Kts = -16735564;
	private static final int pos62or61Kts = -9699328;
	private static final int pos52or51Kts = -8912896;
	private static final int pos51or50Kts = -8650752;
	private static final int neg58or57Kts = -16762752;
	private static final int pos61or60Kts = -9437184;
	private static final int pos2or1Kts = -2434366;
	private static final int neg63or62Kts = -16773528;
	private static final int neg2or1Kts = -4210753;
	
	private ArrayList<Integer> confirmedTornadoListx = new ArrayList<Integer>();
	private ArrayList<Integer> confirmedTornadoListy = new ArrayList<Integer>();
	private ArrayList<Integer> tornadoListx = new ArrayList<Integer>();
	private ArrayList<Integer> tornadoListy = new ArrayList<Integer>();
	private ArrayList<Integer> anomalyListx = new ArrayList<Integer>(); //FOR SECOND TEST
	private ArrayList<Integer> anomalyListy = new ArrayList<Integer>(); //FOR SECOND TEST
	private int[][] radarArray;
	
	
	public VelocityIdentifiers() {
		LoadData radarData = new LoadData();
		radarArray = radarData.createArray();
	}
	
	public void confirmTornado() {
		if (tornadoListx.size() >= 2) {
			for (int listIncrement = 0; listIncrement < tornadoListx.size() - 1; listIncrement++) {
				int currentX = tornadoListx.get(listIncrement);
				int nextX = tornadoListx.get(listIncrement + 1);
				int currentY = tornadoListy.get(listIncrement);
				int nextY = tornadoListy.get(listIncrement + 1);
				if ((currentX == nextX + 1) && ((currentY == nextY + 1) || (currentY == nextY - 1) || (currentY == nextY))) {
					if (this.checkKnots(tornadoListx.get(listIncrement), tornadoListy.get(listIncrement), tornadoListx.get(listIncrement + 1), tornadoListy.get(listIncrement + 1))) {
							confirmedTornadoListx.add(tornadoListx.get(listIncrement));
							confirmedTornadoListy.add(tornadoListy.get(listIncrement));
					}
				}
				else if ((currentX == nextX - 1) && ((currentY == nextY + 1) || (currentY == nextY - 1) || (currentY == nextY))) {
					if (this.checkKnots(tornadoListx.get(listIncrement), tornadoListy.get(listIncrement), tornadoListx.get(listIncrement + 1), tornadoListy.get(listIncrement + 1))) {
							confirmedTornadoListx.add(tornadoListx.get(listIncrement));
							confirmedTornadoListy.add(tornadoListy.get(listIncrement));
					}
				}
				else if ((currentX == nextX) && ((currentY == nextY + 1) || (currentY == nextY - 1) || (currentY == nextY))) {
					if (this.checkKnots(tornadoListx.get(listIncrement), tornadoListy.get(listIncrement), tornadoListx.get(listIncrement + 1), tornadoListy.get(listIncrement + 1))) {
							confirmedTornadoListx.add(tornadoListx.get(listIncrement));
							confirmedTornadoListy.add(tornadoListy.get(listIncrement));
					}
				}
			}
		}
	}
	private boolean checkKnots(int firstListX, int firstListY, int secondListX, int secondListY) {
		if ((radarArray[firstListX][firstListY] == neg64Kts) && (this.neg64KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg63or62Kts) && (this.neg63or62KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg62or61Kts) && (this.neg62or61KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg61or60Kts) && (this.neg61or60KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg58or57Kts) && (this.neg58or57KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg57or56Kts) && (this.neg57or56KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg55or54Kts) && (this.neg55or54KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg52or51Kts) && (this.neg52or51KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg50Kts) && (this.neg50KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg48or47Kts) && (this.neg48or47KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg47or46Kts) && (this.neg47or46KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg41or40Kts) && (this.neg41or40KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg39or38Kts) && (this.neg39or38KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg38or37Kts) && (this.neg38or37KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg36Kts) && (this.neg36KtsFirstCheck(secondListX, secondListY))) {
			return true;	
		}
		else if ((radarArray[firstListX][firstListY] == neg35or34Kts) && (this.neg35or34KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg34or33Kts) && (this.neg34or33KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg33or32Kts) && (this.neg33or32KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg30or29Kts) && (this.neg30or29KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg26Kts) && (this.neg26KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg25or24Kts) && (this.neg25or24KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg23or22Kts) && (this.neg23or22KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg22or21Kts) && (this.neg22or21KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg20Kts) && (this.neg20KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg19or18Kts) && (this.neg19or18KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg16or15Kts) && (this.neg16or15KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg13or12Kts) && (this.neg13or12KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg12or11Kts) && (this.neg12or11KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg11or10Kts) && (this.neg11or10KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg10Kts) && (this.neg10KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg8or7Kts) && (this.neg8or7KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg4or3Kts) && (this.neg4or3KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg3or2Kts) && (this.neg3or2KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg2or1Kts) && (this.neg2or1KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == neg1Kts) && (this.neg1KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == zeroKts) && (this.zeroKtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos2or1Kts) && (this.pos2or1KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos3or2Kts) && (this.pos3or2KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos4or3Kts) && (this.pos4or3KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos6or5Kts) && (this.pos6or5KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos10Kts) && (this.pos10KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos11or10Kts) && (this.pos11or10KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos12or11Kts) && (this.pos12or11KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos18or17Kts) && (this.pos18or17KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos19or18Kts) && (this.pos19or18KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos20or19Kts) && (this.pos20or19KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos20Kts) && (this.pos20KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos24or23Kts) && (this.pos24or23KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos25or24Kts) && (this.pos25or24KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos26Kts) && (this.pos26KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos28or27Kts) && (this.pos28or27KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos32or31Kts) && (this.pos32or31KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos33or32Kts) && (this.pos33or32KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos34or33Kts) && (this.pos34or33KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos35or34Kts) && (this.pos35or34KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos36Kts) && (this.pos36KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos39or38Kts) && (this.pos39or38KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos43or42Kts) && (this.pos43or42KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos45or44Kts) && (this.pos45or44KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos47or46Kts) && (this.pos47or46KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos48or47Kts) && (this.pos48or47KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos49or48Kts) && (this.pos49or48KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos50Kts) && (this.pos50KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos51or50Kts) && (this.pos51or50KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos52or51Kts) && (this.pos52or51KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos57or56Kts) && (this.pos57or56KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos61or60Kts) && (this.pos61or60KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos62or61Kts) && (this.pos62or61KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos63or62Kts) && (this.pos63or62KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else if ((radarArray[firstListX][firstListY] == pos64Kts) && (this.pos64KtsFirstCheck(secondListX, secondListY))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList<Integer> getConfirmedTornadoListx() {
		return confirmedTornadoListx;
	}
	
	public ArrayList<Integer> getConfirmedTornadoListy() {
		return confirmedTornadoListy;
	}
	
	public ArrayList<Integer> getTornadoListx() {
		return tornadoListx;
	}
	
	public ArrayList<Integer> getTornadoListy() {
		return tornadoListy;
	}
	
	public ArrayList<Integer> getAnomalyListx() {
		return anomalyListx;
	}
	
	public ArrayList<Integer> getAnomalyListy() {
		return anomalyListy;
	}
	
	public void outBoundAnomalyCheck() {
		for (int yIncrement = 1; yIncrement <= yMax - 1; yIncrement++) {
			for (int xIncrement = 1; xIncrement <= xMax - 1; xIncrement++) {
				if (radarArray[xIncrement][yIncrement] == neg64Kts) {
					if (this.neg64KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg64KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg64KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg64KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg64KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg64KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg64KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg64KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg64KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg64KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg64KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg64KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg64KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg64KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg64KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg64KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg64KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg64KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg64KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg64KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg64KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg64KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg64KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg64KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg64KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg64KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg64KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg64KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg63or62Kts) {
					if (this.neg63or62KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg63or62KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg63or62KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg63or62KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg63or62KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg63or62KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg63or62KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg63or62KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg63or62KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg63or62KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg63or62KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg63or62KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg63or62KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg63or62KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg63or62KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg63or62KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg63or62KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg63or62KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg63or62KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg63or62KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg63or62KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg63or62KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg63or62KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg63or62KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg63or62KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg63or62KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg63or62KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg63or62KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg62or61Kts) {
					if (this.neg62or61KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg62or61KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg62or61KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg62or61KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg62or61KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg62or61KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg50KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg62or61KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg62or61KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg62or61KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg62or61KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg62or61KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg62or61KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg62or61KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg62or61KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg62or61KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg62or61KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg62or61KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg62or61KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg62or61KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg62or61KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg62or61KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg62or61KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg62or61KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg62or61KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg62or61KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg62or61KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg62or61KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg61or60Kts) {
					if (this.neg61or60KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg61or60KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg61or60KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg61or60KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg61or60KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg61or60KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg61or60KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg61or60KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg61or60KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg61or60KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg61or60KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg61or60KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg61or60KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg61or60KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg61or60KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg61or60KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg61or60KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg61or60KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg61or60KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg61or60KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg61or60KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg61or60KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg61or60KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg61or60KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg61or60KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg61or60KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg61or60KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg61or60KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg58or57Kts) {
					if (this.neg58or57KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg58or57KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg58or57KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg58or57KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg58or57KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg58or57KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg58or57KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg58or57KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg58or57KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg58or57KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg58or57KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg58or57KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg58or57KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg58or57KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg58or57KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg58or57KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg58or57KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg58or57KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg58or57KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg58or57KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg58or57KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg58or57KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg58or57KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg58or57KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg58or57KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg58or57KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg58or57KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg58or57KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg57or56Kts) {
					if (this.neg57or56KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg57or56KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg57or56KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg57or56KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg57or56KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg57or56KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg57or56KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg57or56KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg57or56KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg57or56KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg57or56KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg57or56KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg57or56KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg57or56KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg57or56KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg57or56KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg57or56KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg57or56KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg57or56KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg57or56KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg57or56KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg57or56KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg57or56KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg57or56KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg57or56KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg57or56KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg57or56KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg57or56KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg55or54Kts) {
					if (this.neg55or54KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg55or54KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg55or54KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg55or54KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg55or54KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg55or54KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg55or54KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg55or54KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg55or54KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg55or54KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg55or54KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg55or54KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg55or54KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg55or54KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg55or54KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg55or54KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg55or54KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg55or54KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg55or54KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg55or54KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg55or54KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg55or54KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg55or54KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg55or54KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg55or54KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg55or54KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg55or54KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg55or54KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg52or51Kts) {
					if (this.neg52or51KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg52or51KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg52or51KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg52or51KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg52or51KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg52or51KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg52or51KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg52or51KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg52or51KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg52or51KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg52or51KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg52or51KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg52or51KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg52or51KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg52or51KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg52or51KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg52or51KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg52or51KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg52or51KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg52or51KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg52or51KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg52or51KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg52or51KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg52or51KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg52or51KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg52or51KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg52or51KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg52or51KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg50Kts) {
					if (this.neg50KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg50KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg50KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg50KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg50KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg50KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg50KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg50KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg50KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg50KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg50KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg50KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg50KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg50KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg50KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg50KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg50KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg50KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg50KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg50KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg50KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg50KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg50KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg50KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg50KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg50KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg50KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg50KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg48or47Kts) {
					if (this.neg48or47KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg48or47KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg48or47KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg48or47KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg48or47KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg48or47KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg48or47KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg48or47KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg48or47KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg48or47KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg48or47KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg48or47KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg48or47KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg48or47KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg48or47KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg48or47KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg48or47KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg48or47KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg48or47KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg48or47KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg48or47KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg48or47KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg48or47KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg48or47KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg48or47KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg48or47KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg48or47KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg48or47KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg47or46Kts) {
					if (this.neg47or46KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg47or46KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg47or46KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg47or46KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg47or46KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg47or46KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg47or46KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg47or46KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg47or46KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg47or46KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg47or46KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg47or46KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg47or46KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg47or46KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg47or46KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg47or46KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg47or46KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg47or46KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg47or46KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg47or46KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg47or46KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg47or46KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg47or46KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg47or46KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg47or46KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg47or46KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg47or46KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg47or46KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg41or40Kts) {
					if (this.neg41or40KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg41or40KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg41or40KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg41or40KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg41or40KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg41or40KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg41or40KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg41or40KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg41or40KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg41or40KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg41or40KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg41or40KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg41or40KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg41or40KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg41or40KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg41or40KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg41or40KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg41or40KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg41or40KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg41or40KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg41or40KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg41or40KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg41or40KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg41or40KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg41or40KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg41or40KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg41or40KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg41or40KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg39or38Kts) {
					if (this.neg39or38KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg39or38KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg39or38KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg39or38KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg39or38KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg39or38KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg39or38KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg39or38KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg39or38KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg39or38KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg39or38KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg39or38KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg39or38KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg39or38KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg39or38KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg39or38KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg39or38KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg39or38KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg39or38KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg39or38KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg39or38KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg39or38KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg39or38KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg39or38KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg39or38KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg39or38KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg39or38KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg39or38KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg38or37Kts) {
					if (this.neg38or37KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg38or37KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg38or37KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg38or37KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg38or37KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg38or37KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg38or37KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg38or37KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg38or37KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg38or37KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg38or37KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg38or37KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg38or37KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg38or37KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg38or37KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg38or37KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg38or37KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg38or37KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg38or37KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg38or37KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg38or37KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg38or37KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg38or37KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg38or37KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg38or37KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg38or37KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg38or37KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg38or37KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg36Kts) {
					if (this.neg36KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg36KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg36KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg36KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg36KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg36KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg36KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg36KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg36KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg36KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg36KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg36KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg36KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg36KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg36KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg36KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg36KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg36KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg36KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg36KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg36KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg36KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg36KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg36KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg36KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg36KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg36KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg36KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg35or34Kts) {
					if (this.neg35or34KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg35or34KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg35or34KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg35or34KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg35or34KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg35or34KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg35or34KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg35or34KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg35or34KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg35or34KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg35or34KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg35or34KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg35or34KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg35or34KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg35or34KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg35or34KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg35or34KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg35or34KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg35or34KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg35or34KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg35or34KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg35or34KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg35or34KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg35or34KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg35or34KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg35or34KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg35or34KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg35or34KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg34or33Kts) {
					if (this.neg34or33KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg34or33KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg34or33KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg34or33KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg34or33KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg34or33KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg34or33KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg34or33KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg34or33KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg34or33KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg34or33KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg34or33KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg34or33KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg34or33KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg34or33KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg34or33KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg34or33KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg34or33KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg34or33KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg34or33KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg34or33KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg34or33KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg34or33KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg34or33KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg34or33KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg34or33KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg34or33KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg34or33KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg33or32Kts) {
					if (this.neg33or32KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg33or32KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg33or32KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg33or32KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg33or32KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg33or32KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg33or32KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg33or32KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg33or32KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg33or32KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg33or32KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg33or32KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg33or32KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg33or32KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg33or32KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg33or32KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg33or32KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg33or32KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg33or32KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg33or32KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg33or32KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg33or32KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg33or32KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg33or32KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg33or32KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg33or32KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg33or32KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg33or32KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg30or29Kts) {
					if (this.neg30or29KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg30or29KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg30or29KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg30or29KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg30or29KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg30or29KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg30or29KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg30or29KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg30or29KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg30or29KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg30or29KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg30or29KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg30or29KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg30or29KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg30or29KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg30or29KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg30or29KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg30or29KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg30or29KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg30or29KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg30or29KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg30or29KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg30or29KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg30or29KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg30or29KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg30or29KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg30or29KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg30or29KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg26Kts) {
					if (this.neg26KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg26KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg26KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg26KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg26KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg26KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg26KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg26KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg26KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg26KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg26KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg26KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg26KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg26KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg26KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg26KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg26KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg26KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg26KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg26KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg26KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg26KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg26KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg26KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg26KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg26KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg26KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg26KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg25or24Kts) {
					if (this.neg25or24KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg25or24KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg25or24KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg25or24KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg25or24KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg25or24KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg25or24KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg25or24KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg25or24KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg25or24KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg25or24KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg25or24KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg25or24KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg25or24KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg25or24KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg25or24KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg25or24KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg25or24KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg25or24KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg25or24KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg25or24KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg25or24KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg25or24KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg25or24KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg25or24KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg25or24KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg25or24KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg25or24KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg23or22Kts) {
					if (this.neg23or22KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg23or22KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg23or22KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg23or22KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg23or22KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg23or22KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg23or22KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg23or22KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg23or22KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg23or22KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg23or22KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg23or22KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg23or22KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg23or22KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg23or22KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg23or22KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg23or22KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg23or22KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg23or22KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg23or22KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg23or22KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg23or22KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg23or22KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg23or22KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg23or22KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg23or22KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg23or22KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg23or22KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg22or21Kts) {
					if (this.neg22or21KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg22or21KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg22or21KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg22or21KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg22or21KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg22or21KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg22or21KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg22or21KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg22or21KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg22or21KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg22or21KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg22or21KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg22or21KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg22or21KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg22or21KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg22or21KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg22or21KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg22or21KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg22or21KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg22or21KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg22or21KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg22or21KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg22or21KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg22or21KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg22or21KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg22or21KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg22or21KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg22or21KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg20Kts) {
					if (this.neg20KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg20KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg20KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg20KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg20KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg20KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg20KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg20KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg20KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg20KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg20KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg20KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg20KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg20KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg20KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg20KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg20KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg20KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg20KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg20KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg20KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg20KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg20KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg20KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg20KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg20KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg20KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg20KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg19or18Kts) {
					if (this.neg19or18KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg19or18KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg19or18KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg19or18KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg19or18KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg19or18KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg19or18KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg19or18KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg19or18KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg19or18KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg19or18KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg19or18KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg19or18KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg19or18KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg19or18KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg19or18KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg19or18KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg19or18KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg19or18KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg19or18KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg19or18KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg19or18KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg19or18KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg19or18KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg19or18KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg19or18KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg19or18KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg19or18KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg16or15Kts) {
					if (this.neg16or15KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg16or15KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg16or15KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg16or15KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg16or15KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg16or15KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg16or15KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg16or15KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg16or15KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg16or15KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg16or15KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg16or15KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg16or15KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg16or15KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg16or15KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg16or15KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg16or15KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg16or15KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg16or15KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg16or15KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg16or15KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg16or15KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg16or15KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg16or15KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg16or15KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg16or15KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg16or15KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg16or15KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg13or12Kts) {
					if (this.neg13or12KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg13or12KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg13or12KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg13or12KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg13or12KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg13or12KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg13or12KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg13or12KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg13or12KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg13or12KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg13or12KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg13or12KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg13or12KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg13or12KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg13or12KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg13or12KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg13or12KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg13or12KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg13or12KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg13or12KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg13or12KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg13or12KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg13or12KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg13or12KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg13or12KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg13or12KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg13or12KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg13or12KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg12or11Kts) {
					if (this.neg12or11KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg12or11KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg12or11KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg12or11KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg12or11KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg12or11KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg12or11KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg12or11KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg12or11KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg12or11KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg12or11KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg12or11KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg12or11KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg12or11KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg12or11KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg12or11KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg12or11KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg12or11KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg12or11KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg12or11KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg12or11KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg12or11KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg12or11KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg12or11KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg12or11KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg12or11KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg12or11KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg12or11KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg11or10Kts) {
					if (this.neg11or10KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.neg11or10KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.neg11or10KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.neg11or10KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg11or10KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.neg11or10KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.neg11or10KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg11or10KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.neg11or10KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.neg11or10KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.neg11or10KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.neg11or10KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.neg11or10KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.neg11or10KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg11or10KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.neg11or10KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.neg11or10KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg11or10KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.neg11or10KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.neg11or10KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.neg11or10KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg11or10KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.neg11or10KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.neg11or10KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.neg11or10KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.neg11or10KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.neg11or10KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.neg11or10KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg10Kts) {
					if (this.neg10KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg10KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg10KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg10KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg8or7Kts) {
					if (this.neg8or7KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg8or7KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg8or7KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg8or7KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg4or3Kts) {
					if (this.neg4or3KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg4or3KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg4or3KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg4or3KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg3or2Kts) {
					if (this.neg3or2KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg3or2KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg3or2KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg3or2KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg2or1Kts) {
					if (this.neg2or1KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg2or1KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg2or1KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg2or1KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == neg1Kts) {
					if (this.neg1KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg1KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg1KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.neg1KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == zeroKts) {
					if (this.zeroKtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.zeroKtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.zeroKtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.zeroKtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos2or1Kts) {
					if (this.pos2or1KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos2or1KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos2or1KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos2or1KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos3or2Kts) {
					if (this.pos3or2KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos3or2KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos3or2KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos3or2KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos4or3Kts) {
					if (this.pos4or3KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos4or3KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos4or3KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos4or3KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos6or5Kts) {
					if (this.pos6or5KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos6or5KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos6or5KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos6or5KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos10Kts) {
					if (this.pos10KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos10KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos10KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.lowKtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.lowKtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos10KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.lowKtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.lowKtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.lowKtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos11or10Kts) {
					if (this.pos11or10KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos11or10KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos11or10KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos11or10KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos11or10KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos11or10KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos11or10KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos11or10KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos11or10KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos11or10KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos11or10KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos11or10KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos11or10KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos11or10KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos11or10KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos11or10KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos11or10KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos11or10KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos11or10KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos11or10KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos11or10KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos11or10KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos11or10KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos11or10KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos11or10KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos11or10KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos11or10KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos11or10KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos12or11Kts) {
					if (this.pos12or11KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos12or11KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos12or11KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos12or11KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos12or11KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos12or11KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos12or11KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos12or11KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos12or11KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos12or11KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos12or11KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos12or11KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos12or11KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos12or11KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos12or11KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos12or11KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos12or11KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos12or11KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos12or11KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos12or11KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos12or11KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos12or11KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos12or11KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos12or11KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos12or11KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos12or11KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos12or11KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos12or11KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos18or17Kts) {
					if (this.pos18or17KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos18or17KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos18or17KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos18or17KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos18or17KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos18or17KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos18or17KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos18or17KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos18or17KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos18or17KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos18or17KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos18or17KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos18or17KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos18or17KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos18or17KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos18or17KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos18or17KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos18or17KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos18or17KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos18or17KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos18or17KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos18or17KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos18or17KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos18or17KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos18or17KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos18or17KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos18or17KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos18or17KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos19or18Kts) {
					if (this.pos19or18KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos19or18KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos19or18KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos19or18KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos19or18KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos19or18KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos19or18KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos19or18KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos19or18KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos19or18KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos19or18KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos19or18KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos19or18KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos19or18KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos19or18KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos19or18KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos19or18KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos19or18KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos19or18KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos19or18KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos19or18KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos19or18KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos19or18KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos19or18KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos19or18KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos19or18KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos19or18KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos19or18KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos20or19Kts) {
					if (this.pos20or19KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos20or19KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos20or19KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos20or19KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos20or19KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos20or19KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos20or19KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos20or19KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos20or19KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos20or19KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos20or19KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos20or19KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos20or19KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos20or19KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos20or19KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos20or19KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos20or19KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos20or19KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos20or19KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos20or19KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos20or19KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos20or19KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos20or19KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos20or19KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos20or19KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos20or19KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos20or19KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos20or19KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos20Kts) {
					if (this.pos20KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos20KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos20KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos20KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos20KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos20KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos20KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos20KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos20KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos20KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos20KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos20KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos20KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos20KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos20KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos20KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos20KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos20KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos20KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos20KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos20KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos20KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos20KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos20KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos20KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos20KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos20KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos20KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos24or23Kts) {
					if (this.pos24or23KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos24or23KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos24or23KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos24or23KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos24or23KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos24or23KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos24or23KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos24or23KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos24or23KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos24or23KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos24or23KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos24or23KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos24or23KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos24or23KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos24or23KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos24or23KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos24or23KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos24or23KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos24or23KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos24or23KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos24or23KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos24or23KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos24or23KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos24or23KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos24or23KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos24or23KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos24or23KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos24or23KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos25or24Kts) {
					if (this.pos25or24KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos25or24KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos25or24KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos25or24KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos25or24KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos25or24KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos25or24KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos25or24KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos25or24KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos25or24KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos25or24KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos25or24KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos25or24KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos25or24KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos25or24KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos25or24KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos25or24KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos25or24KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos25or24KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos25or24KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos25or24KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos25or24KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos25or24KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos25or24KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos25or24KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos25or24KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos25or24KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos25or24KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos26Kts) {
					if (this.pos26KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos26KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos26KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos26KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos26KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos26KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos26KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos26KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos26KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos26KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos26KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos26KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos26KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos26KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos26KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos26KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos26KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos26KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos26KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos26KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos26KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos26KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos26KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos26KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos26KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos26KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos26KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos26KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos28or27Kts) {
					if (this.pos28or27KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos28or27KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos28or27KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos28or27KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos28or27KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos28or27KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos28or27KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos28or27KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos28or27KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos28or27KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos28or27KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos28or27KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos28or27KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos28or27KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos28or27KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos28or27KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos28or27KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos28or27KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos28or27KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos28or27KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos28or27KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos28or27KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos28or27KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos28or27KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos28or27KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos28or27KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos28or27KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos28or27KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos32or31Kts) {
					if (this.pos32or31KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos32or31KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos32or31KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos32or31KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos32or31KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos32or31KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos32or31KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos32or31KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos32or31KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos32or31KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos32or31KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos32or31KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos32or31KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos32or31KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos32or31KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos32or31KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos32or31KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos32or31KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos32or31KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos32or31KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos32or31KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos32or31KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos32or31KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos32or31KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos32or31KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos32or31KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos32or31KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos32or31KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos33or32Kts) {
					if (this.pos33or32KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos33or32KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos33or32KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos33or32KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos33or32KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos33or32KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos33or32KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos33or32KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos33or32KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos33or32KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos33or32KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos33or32KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos33or32KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos33or32KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos33or32KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos33or32KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos33or32KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos33or32KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos33or32KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos33or32KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos33or32KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos33or32KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos33or32KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos33or32KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos33or32KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos33or32KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos33or32KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos33or32KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos34or33Kts) {
					if (this.pos34or33KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos34or33KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos34or33KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos34or33KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos34or33KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos34or33KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos34or33KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos34or33KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos34or33KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos34or33KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos34or33KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos34or33KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos34or33KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos34or33KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos34or33KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos34or33KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos34or33KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos34or33KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos34or33KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos34or33KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos34or33KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos34or33KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos34or33KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos34or33KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos34or33KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos34or33KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos34or33KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos34or33KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos35or34Kts) {
					if (this.pos35or34KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos35or34KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos35or34KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos35or34KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos35or34KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos35or34KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos35or34KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos35or34KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos35or34KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos35or34KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos35or34KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos35or34KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos35or34KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos35or34KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos35or34KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos35or34KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos35or34KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos35or34KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos35or34KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos35or34KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos35or34KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos35or34KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos35or34KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos35or34KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos35or34KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos35or34KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos35or34KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos35or34KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos36Kts) {
					if (this.pos36KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos36KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos36KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos36KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos36KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos36KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos36KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos36KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos36KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos36KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos36KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos36KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos36KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos36KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos36KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos36KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos36KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos36KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos36KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos36KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos36KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos36KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos36KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos36KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos36KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos36KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos36KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos36KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos39or38Kts) {
					if (this.pos39or38KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos39or38KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos39or38KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos39or38KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos39or38KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos39or38KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos39or38KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos39or38KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos39or38KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos39or38KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos39or38KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos39or38KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos39or38KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos39or38KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos39or38KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos39or38KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos39or38KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos39or38KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos39or38KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos39or38KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos39or38KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos39or38KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos39or38KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos39or38KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos39or38KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos39or38KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos39or38KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos39or38KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos43or42Kts) {
					if (this.pos43or42KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos43or42KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos43or42KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos43or42KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos43or42KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos43or42KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos43or42KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos43or42KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos43or42KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos43or42KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos43or42KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos43or42KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos43or42KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos43or42KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos43or42KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos43or42KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos43or42KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos43or42KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos43or42KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos43or42KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos43or42KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos43or42KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos43or42KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos43or42KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos43or42KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos43or42KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos43or42KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos43or42KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos45or44Kts) {
					if (this.pos45or44KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos45or44KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos45or44KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos45or44KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos45or44KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos45or44KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos45or44KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos45or44KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos45or44KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos45or44KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos45or44KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos45or44KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos45or44KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos45or44KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos45or44KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos45or44KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos45or44KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos45or44KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos45or44KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos45or44KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos45or44KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos45or44KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos45or44KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos45or44KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos45or44KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos45or44KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos45or44KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos45or44KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos47or46Kts) {
					if (this.pos47or46KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos47or46KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos47or46KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos47or46KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos47or46KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos47or46KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos47or46KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos47or46KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos47or46KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos47or46KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos47or46KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos47or46KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos47or46KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos47or46KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos47or46KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos47or46KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos47or46KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos47or46KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos47or46KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos47or46KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos47or46KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos47or46KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos47or46KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos47or46KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos47or46KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos47or46KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos47or46KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos47or46KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos48or47Kts) {
					if (this.pos48or47KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos48or47KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos48or47KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos48or47KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos48or47KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos48or47KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos48or47KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos48or47KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos48or47KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos48or47KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos48or47KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos48or47KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos48or47KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos48or47KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos48or47KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos48or47KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos48or47KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos48or47KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos48or47KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos48or47KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos48or47KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos48or47KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos48or47KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos48or47KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos48or47KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos48or47KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos48or47KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos48or47KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos49or48Kts) {
					if (this.pos49or48KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos49or48KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos49or48KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos49or48KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos49or48KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos49or48KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos49or48KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos49or48KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos49or48KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos49or48KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos49or48KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos49or48KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos49or48KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos49or48KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos49or48KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos49or48KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos49or48KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos49or48KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos49or48KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos49or48KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos49or48KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos49or48KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos49or48KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos49or48KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos49or48KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos49or48KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos49or48KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos49or48KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos50Kts) {
					if (this.pos50KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos50KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos50KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos50KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos50KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos50KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos50KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos50KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos50KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos50KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos50KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos50KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos50KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos50KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos50KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos50KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos50KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos50KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos50KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos50KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos50KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos50KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos50KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos50KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos50KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos50KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos50KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos50KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos51or50Kts) {
					if (this.pos51or50KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos51or50KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos51or50KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos51or50KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos51or50KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos51or50KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos51or50KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos51or50KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos51or50KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos51or50KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos51or50KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos51or50KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos51or50KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos51or50KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos51or50KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos51or50KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos51or50KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos51or50KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos51or50KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos51or50KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos51or50KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos51or50KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos51or50KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos51or50KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos51or50KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos51or50KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos51or50KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos51or50KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos52or51Kts) {
					if (this.pos52or51KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos52or51KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos52or51KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos52or51KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos52or51KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos52or51KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos52or51KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos52or51KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos52or51KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos52or51KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos52or51KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos52or51KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos52or51KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos52or51KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos52or51KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos52or51KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos52or51KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos52or51KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos52or51KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos52or51KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos52or51KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos52or51KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos52or51KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos52or51KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos52or51KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos52or51KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos52or51KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos52or51KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos57or56Kts) {
					if (this.pos57or56KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos57or56KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos57or56KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos57or56KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos57or56KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos57or56KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos57or56KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos57or56KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos57or56KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos57or56KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos57or56KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos57or56KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos57or56KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos57or56KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos57or56KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos57or56KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos57or56KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos57or56KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos57or56KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos57or56KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos57or56KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos57or56KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos57or56KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos57or56KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos57or56KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos57or56KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos57or56KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos57or56KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos61or60Kts) {
					if (this.pos61or60KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos61or60KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos61or60KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos61or60KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos61or60KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos61or60KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos61or60KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos61or60KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos61or60KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos61or60KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos61or60KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos61or60KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos61or60KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos61or60KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos61or60KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos61or60KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos61or60KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos61or60KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos61or60KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos61or60KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos61or60KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos61or60KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos61or60KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos61or60KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos61or60KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos61or60KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos61or60KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos61or60KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos62or61Kts) {
					if (this.pos62or61KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos62or61KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos62or61KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos62or61KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos62or61KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos62or61KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos62or61KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos62or61KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos62or61KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos62or61KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos62or61KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos62or61KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos62or61KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos62or61KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos62or61KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos62or61KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos62or61KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos62or61KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos62or61KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos62or61KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos62or61KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos62or61KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos62or61KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos62or61KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos62or61KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos62or61KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos62or61KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos62or61KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos63or62Kts) {
					if (this.pos63or62KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos63or62KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos63or62KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos63or62KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos63or62KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos63or62KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos63or62KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos63or62KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos63or62KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos63or62KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos63or62KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos63or62KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos63or62KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos63or62KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos63or62KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos63or62KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos63or62KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos63or62KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos63or62KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos63or62KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos63or62KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos63or62KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos63or62KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos63or62KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos63or62KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos63or62KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos63or62KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos63or62KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else if (radarArray[xIncrement][yIncrement] == pos64Kts) {
					if (this.pos64KtsFirstCheck(xIncrement + 1, yIncrement)) {
						if (this.pos64KtsSecondaryCheck(xIncrement - 1, yIncrement)) {
							if ((this.pos64KtsSecondaryCheck(xIncrement - 1, yIncrement + 1)) || (this.pos64KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos64KtsSecondaryCheck(xIncrement - 2,yIncrement)) && ((this.pos64KtsSecondaryCheck(xIncrement - 2, yIncrement + 1)) || 
										(this.pos64KtsSecondaryCheck(xIncrement - 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos64KtsFirstCheck(xIncrement, yIncrement + 1)) {
						if (this.pos64KtsSecondaryCheck(xIncrement, yIncrement - 1)) {
							if ((this.pos64KtsSecondaryCheck(xIncrement + 1, yIncrement - 1)) || (this.pos64KtsSecondaryCheck(xIncrement - 1, yIncrement - 1))) {
								if ((this.pos64KtsSecondaryCheck(xIncrement,yIncrement - 2)) && ((this.pos64KtsSecondaryCheck(xIncrement + 1, yIncrement - 2)) || 
										(this.pos64KtsSecondaryCheck(xIncrement - 1, yIncrement - 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos64KtsFirstCheck(xIncrement, yIncrement - 1)) {
						if (this.pos64KtsSecondaryCheck(xIncrement, yIncrement + 1)) {
							if ((this.pos64KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos64KtsSecondaryCheck(xIncrement - 1, yIncrement + 1))) {
								if ((this.pos64KtsSecondaryCheck(xIncrement,yIncrement + 2)) && ((this.pos64KtsSecondaryCheck(xIncrement + 1, yIncrement + 2)) || 
										(this.pos64KtsSecondaryCheck(xIncrement - 1, yIncrement + 2)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
					else if (this.pos64KtsFirstCheck(xIncrement - 1, yIncrement)) {
						if (this.pos64KtsSecondaryCheck(xIncrement + 1, yIncrement)) {
							if ((this.pos64KtsSecondaryCheck(xIncrement + 1, yIncrement + 1)) || (this.pos64KtsSecondaryCheck(xIncrement + 1, yIncrement - 1))) {
								if ((this.pos64KtsSecondaryCheck(xIncrement + 2,yIncrement)) && ((this.pos64KtsSecondaryCheck(xIncrement + 2, yIncrement + 1)) || 
										(this.pos64KtsSecondaryCheck(xIncrement + 2, yIncrement - 1)))) {
									tornadoListx.add(xIncrement);
									tornadoListy.add(yIncrement);
								}
							}
							else {
								anomalyListx.add(xIncrement);
								anomalyListy.add(yIncrement);
							}
							
						}
						else {
							anomalyListx.add(xIncrement);
							anomalyListy.add(yIncrement);
						}
					}
				}
				else {
				
				}
			}
		}
	}
	
	private boolean neg64KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg63or62KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg62or61KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg61or60KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg58or57KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	private boolean neg57or56KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg55or54KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg52or51KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg50KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg48or47KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg47or46KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg41or40KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg39or38KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg38or37KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg36KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg35or34KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg34or33KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg33or32KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg30or29KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg26KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	////////////
	//here//////
	////////////
	private boolean neg25or24KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg23or22KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg22or21KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg20KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg19or18KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg16or15KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg13or12KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg12or11KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg11or10KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg10KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg8or7KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg4or3KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg3or2KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg2or1KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg1KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean zeroKtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos2or1KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos3or2KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos4or3KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos6or5KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos10KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos11or10KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos12or11KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos18or17KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos19or18KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos20or19KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos20KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos24or23KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos25or24KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos26KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos28or27KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos32or31KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos33or32KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos34or33KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos35or34KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos36KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos39or38KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos43or42KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos45or44KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos47or46KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos48or47KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos49or48KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos50KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos51or50KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos52or51KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos57or56KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos61or60KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos62or61KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos63or62KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean pos64KtsFirstCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
 		else {
			return false;
		}
	}
	
	private boolean neg64KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg63or62KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg62or61KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg61or60KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg58or57KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg58or57Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg57or56KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg55or54KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg55or54Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg52or51KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean neg50KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg48or47KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg47or46KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg41or40KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg41or40Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg39or38KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg38or37KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg38or37Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg36KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg35or34KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg34or33KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg33or32KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg30or29KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg30or29Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg26KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg25or24KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg23or22KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg23or22Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg22or21KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg22or21Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg20KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg19or18KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg16or15KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg13or12KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg12or11KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean neg11or10KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean lowKtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == neg20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg16or15Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg13or12Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	private boolean pos11or10KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos12or11KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg8or7Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos18or17KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg2or1Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos19or18KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == neg1Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos20or19KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos20KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos24or23KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos25or24KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos26KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos28or27KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos32or31KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos33or32KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos34or33KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos35or34KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos36KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos39or38KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos2or1Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == zeroKts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos43or42KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos4or3Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos3or2Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos45or44KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos6or5Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos47or46KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos48or47KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos49or48KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos50KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos51or50KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos11or10Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos52or51KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos12or11Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos57or56KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos20or19Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos19or18Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos18or17Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos61or60KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos62or61KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos63or62KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean pos64KtsSecondaryCheck(int inputX, int inputY) {
		if (radarArray[inputX][inputY] == pos64Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos63or62Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos62or61Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos61or60Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos57or56Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos52or51Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos51or50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos50Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos49or48Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos48or47Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos47or46Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos45or44Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos43or42Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos39or38Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos36Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos35or34Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos34or33Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos33or32Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos32or31Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos28or27Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos26Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos25or24Kts) {
			return true;
		}
		else if (radarArray[inputX][inputY] == pos24or23Kts) {
			return true;
		}
		else {
			return false;
		}
	}
}