package ArrayGugudan;

public class Demogugudan implements DemoInterface {

	private int miDan = 8;
	private final int miBae = 9;
	private int iArrDan[];
	private int iArrBae[] = new int[miBae];
	private String strResult = new String();

	public Demogugudan() {
		iArrDan = new int[miDan];
		for (int i = 0; i < iArrDan.length; i++) {
			iArrDan[i] = i + 2;
		}
		for (int i = 0; i < iArrBae.length; i++) {
			iArrBae[i] = i + 1;
		}
	}

	public Demogugudan(int num) throws Exception {
		miDan = num;
		if( num < 0)
			throw new Exception();
		iArrDan = new int[miDan];
		for (int i = 0; i < iArrDan.length; i++) {
			iArrDan[i] = i + 2;
		}
		for (int i = 0; i < iArrBae.length; i++) {
			iArrBae[i] = i + 1;
		}
	}

	@Override
	public String gugudan() {
		for (int i = 0; i < iArrDan.length; i++) {
			for (int j = 0; j < iArrBae.length; j++) {
				strResult += iArrDan[i] + "*" + iArrBae[j] + "=" + (iArrDan[i] * iArrBae[j]) + "\n";
			}
			strResult += "\n";
		}
		return strResult;
	}
}
