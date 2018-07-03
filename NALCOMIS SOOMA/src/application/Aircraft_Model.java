package application;

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
	static Aircraft_Model ac0 = new Aircraft_Model(129460, 00, "HMH-461", "CH-53E");
	static Aircraft_Model ac1 = new Aircraft_Model(129461, 01, "HMH-461", "CH-53E");
	static Aircraft_Model ac2 = new Aircraft_Model(129462, 02, "HMH-461", "CH-53E");
	static Aircraft_Model ac3 = new Aircraft_Model(129463, 03, "HMH-461", "CH-53E");
	static Aircraft_Model ac4 = new Aircraft_Model(129464, 04, "HMH-461", "CH-53E");
	static Aircraft_Model ac5 = new Aircraft_Model(129465, 05, "HMH-461", "CH-53E");
	static Aircraft_Model ac6 = new Aircraft_Model(129466, 06, "HMH-461", "CH-53E");
	static Aircraft_Model ac7 = new Aircraft_Model(129467, 07, "HMH-461", "CH-53E");
	static Vector<Aircraft_Model> acHolder = new Vector<Aircraft_Model>();
	
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
	
	protected void setTsn(int tsn) {
		this.tsn = tsn;
	}
	
	protected void setTso(int tso) {
		this.tso = tso;
	}
	
	protected void setModex(int modex) {
		this.modex = modex;
	}
	
	protected int getTsn() {
		return tsn;
	}
	
	protected int getTso() {
		return tso;
	}
	
	protected int getModex() {
		return modex;
	}
	
	protected int getBuno() {
		return buno;
	}
	
	protected int getPhInterval() {
		return phaseInterval;
	}
	
	protected int getPhDue() {
		return phaseDue;
	}
	
	protected int getTsi() {
		return tsi;
	}
	
	protected String getnextInsp() {
		return nextInsp;
	}
	
	protected String getstatus() {
		return status;
	}
	
	protected String getstate() {
		return state;
	}
	
	protected String getlastPhase() {
		return lastPhase;
	}
	
	protected String getOrg() {
		return org;
	}
	
	protected String getAcType() {
		return acftType;
	}
	
	protected Engine getEng() {
		return engine;
	}
	
	protected MainRotorHub getMRH() {
		return mainRotorHub;
	}
	
	protected TailRotorHub getTRH() {
		return tailRotorHub;
	}
	
	protected Aircraft_Model createDefAc() {
		Aircraft_Model ac1 = new Aircraft_Model();
		return ac1;
	}
	
	protected Aircraft_Model createAc(int b, int m, String o, String t) {
		
		Aircraft_Model ac = new Aircraft_Model(b, m, o, t);
		acHolder.add(ac);	
		count++;
		return acHolder.get(count);	
	}
	
	protected void setTsn(Vector a, int m, int tsn) {
		a.get(m);
		this.tsn = tsn;
	}
	
	protected void setTso(Vector a, int m, int tso) {
		a.get(m);
		this.tso = tso;
	}
	
	protected void setModex(Vector a, int m, int tso) {
		a.get(m);
		this.modex = modex;
	}
	
	protected TreeItem<Aircraft_Model> addAc(Aircraft_Model ac) {
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
