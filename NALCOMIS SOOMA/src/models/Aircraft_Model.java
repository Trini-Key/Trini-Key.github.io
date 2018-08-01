package models;

import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class Aircraft_Model {
	
	static int count = 7;
	
	int tsn;
	int tso;
	int buno;
	int modex;
	int phaseInterval;
	int phaseDue;
	int tsi;
	String nextInsp;
	String state;
	String status;
	String lastPhase;
	String org;
	String acftType;
	Engine engine;
	MainRotorHub mainRotorHub;
	TailRotorHub tailRotorHub;
	Vector<Object> parts;
	public static Aircraft_Model ac0 = new Aircraft_Model(129460, 00, "HMH-461", "CH-53E");
	public static Aircraft_Model ac1 = new Aircraft_Model(129461, 01, "HMH-461", "CH-53E");
	public static Aircraft_Model ac2 = new Aircraft_Model(129462, 02, "HMH-461", "CH-53E");
	public static Aircraft_Model ac3 = new Aircraft_Model(129463, 03, "HMH-461", "CH-53E");
	public static Aircraft_Model ac4 = new Aircraft_Model(129464, 04, "HMH-461", "CH-53E");
	public static Aircraft_Model ac5 = new Aircraft_Model(129465, 05, "HMH-461", "CH-53E");
	public static Aircraft_Model ac6 = new Aircraft_Model(129466, 06, "HMH-461", "CH-53E");
 	public static Aircraft_Model ac7 = new Aircraft_Model(129467, 07, "HMH-461", "CH-53E");
	public static Vector<Aircraft_Model> acHolder = new Vector<Aircraft_Model>();
	
	public void addAllVectior(Aircraft_Model ac) {
		acHolder.add(ac);
	}
	
	public Aircraft_Model() {
		// TODO Auto-generated constructor stub
		int tsn = 0;
		int tso = 0;
		int buno = 123456;
		int modex = 01;
		int phaseInterval = 1500;
		int phaseDue= 1500;
		int tsi = 0;
		String nextInsp = "None";
		String state = "Not in inspection";
		String status = "up";
		String lastPhase = "D";
		String org = "HMH-461";
		String acftType = "CH-53E";
		Engine engine;
		MainRotorHub mainRotorHub;
		TailRotorHub tailRotorHub;
		Vector<Parts> parts;		
		final int count = 1;
	}
	
	public Aircraft_Model(int buno, int modex, String org, String acftType ) {
		// TODO Auto-generated constructor stub
		this.tsn = 0;
		this.tso = 0;
		this.buno = buno;
		this.modex = modex;
		this.phaseInterval = 1500;
		this.phaseDue= 1500;
		this.tsi = 0;
		this.nextInsp = "None";
		this.state = "Not in inspection";
		this.status = "up";
		this.lastPhase = "D";
		this.org = org;
		this.acftType = acftType;
		Engine engine;
		MainRotorHub mainRotorHub;
		TailRotorHub tailRotorHub;
		Vector<Parts> parts;		
	}
	
	public void setTsn(int tsn) {
		this.tsn = tsn;
	}
	
	public void setTso(int tso) {
		this.tso = tso;
	}
	
	public void setModex(int modex) {
		this.modex = modex;
	}
	
	public int getTsn() {
		return tsn;
	}
	
	public int getTso() {
		return tso;
	}
	
	public int getModex() {
		return modex;
	}
	
	public int getBuno() {
		return buno;
	}
	
	public int getPhInterval() {
		return phaseInterval;
	}
	
	public int getPhDue() {
		return phaseDue;
	}
	
	public int getTsi() {
		return tsi;
	}
	
	public String getnextInsp() {
		return nextInsp;
	}
	
	public String getstatus() {
		return status;
	}
	
	public String getstate() {
		return state;
	}
	
	public String getlastPhase() {
		return lastPhase;
	}
	
	public String getOrg() {
		return org;
	}
	
	public String getAcType() {
		return acftType;
	}
	
	public Engine getEng() {
		return engine;
	}
	
	public MainRotorHub getMRH() {
		return mainRotorHub;
	}
	
	public TailRotorHub getTRH() {
		return tailRotorHub;
	}
	
	public Aircraft_Model createDefAc() {
		Aircraft_Model ac1 = new Aircraft_Model();
		return ac1;
	}
	
	public Aircraft_Model createAc(int b, int m, String o, String t) {
		
		Aircraft_Model ac = new Aircraft_Model(b, m, o, t);
		acHolder.add(ac);	
		count++;
		return acHolder.get(count);	
	}
	
	public void setTsn(Vector a, int m, int tsn) {
		a.get(m);
		this.tsn = tsn;
	}
	
	public void setTso(Vector a, int m, int tso) {
		a.get(m);
		this.tso = tso;
	}
	
	public void setModex(Vector a, int m, int tso) {
		a.get(m);
		this.modex = modex;
	}
	
	public TreeItem<Aircraft_Model> addAc(Aircraft_Model ac) {
		TreeItem<Aircraft_Model> acTree = new TreeItem<>(ac);
		return acTree;
	}
	
	public String toString() {
		return acftType + " " + modex;
	}
	
	public String toString1() {
		return buno + " " + modex;
	}
	
	public static void main(String args[]) {
		ObservableList<Aircraft_Model> acs = FXCollections.observableArrayList(ac0, ac1, ac2, ac3, ac4, ac5, ac6, ac7);
		acHolder.addAll(acs);
		
		
	}

}
