import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class A {

	static MathContext mc = new MathContext(1, RoundingMode.HALF_EVEN);
	
	public static void main(String[] args) {
		
		Entrada[] e = new Entrada[]
		{
		 new Entrada(0,0,0,BigDecimal.ZERO),
		 new Entrada(0,0,1,BigDecimal.ZERO),
		 new Entrada(0,1,0,BigDecimal.ZERO),
		 new Entrada(0,1,1,BigDecimal.ONE),
		 new Entrada(1,1,0,BigDecimal.ONE),
		 new Entrada(1,1,1,BigDecimal.ONE)
		};
	
		BigDecimal w1 = new BigDecimal(1,mc);
		BigDecimal w2 = new BigDecimal(-1,mc);
		BigDecimal w3 = new BigDecimal(-1,mc);
		
		// Epoca
		boolean newepoca = false;
		int epoca = 1;
		do {
			newepoca = false;
			System.out.println("Epoca " + epoca);
			// Entrada
			for(int i=0; i<e.length; i++) {
				System.out.println("Entrada " + (i+1));
				System.out.println("x1 " + e[i].getX1());
				System.out.println("x2 " + e[i].getX2());
				System.out.println("x3 " + e[i].getX3());
				boolean mudouW = e[i].w(w1, w2, w3);
//				System.out.printf("y=%d e d=%d ", e[i].y(), e[i].getD());
				System.out.println("novo peso? " + mudouW);
				if(mudouW) {
					
					w1 = e[i].getW1();
					w2 = e[i].getW2();
					w3 = e[i].getW3();
					
					newepoca = true;
				}
				System.out.println("");
			}
			epoca++;
			if(epoca > 10) {
				break;
			}
		} while (newepoca);
		
		
		System.out.println("Tem " + epoca + " epocas");
		System.out.println("Testes:");
		
		Entrada [] teste = new Entrada[] {
				new Entrada(1,0,1,BigDecimal.ONE),
				new Entrada(1,0,0,BigDecimal.ONE),
				new Entrada(0,1,1,BigDecimal.ONE)
		};
		for(int i=0; i< teste.length; i++) {
			System.out.println("teste " + i + " é " + (teste[i].w(w1, w2, w3)?"Invalido" : "Valido"));
		}

	}
	
}

class Entrada {
	
	MathContext mc = new MathContext(1, RoundingMode.HALF_EVEN);
	
	private int x1;
	private int x2;
	private int x3;
	
	private BigDecimal w1;
	private BigDecimal w2;
	private BigDecimal w3;
	
	private BigDecimal d;
	
	public Entrada(int x1, int x2, int x3, BigDecimal i) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.d = i;
	}

	private BigDecimal y() {
		
		BigDecimal y = new BigDecimal( (x1 * w1.doubleValue()) + (x2 * w2.doubleValue()) + (x3 * w3.doubleValue()), mc );
		System.out.println("y = " + y);
		if (y.doubleValue() >= 1)  {
			return BigDecimal.ONE;
		}
		return BigDecimal.ZERO;
	}
	
	public boolean w(BigDecimal w1, BigDecimal w2, BigDecimal w3) {
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;

		BigDecimal y = y();
		if(y.longValue() != d.doubleValue()) {
			
			this.w1 =  w1.add(new BigDecimal(0.2).multiply(d.subtract(y).multiply(new BigDecimal(x1))), mc );
			this.w2 =  w2.add(new BigDecimal(0.2).multiply(d.subtract(y).multiply(new BigDecimal(x2))), mc );
			this.w3 =  w3.add(new BigDecimal(0.2).multiply(d.subtract(y).multiply(new BigDecimal(x3))), mc );
			System.out.println("w1 " + this.w1);
			System.out.println("w2 " + this.w2.toPlainString());
			System.out.println("w3 " + this.w3);
			return true;
		}
		return false;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public BigDecimal getW1() {
		return w1;
	}

	public void setW1(BigDecimal w1) {
		this.w1 = w1;
	}

	public BigDecimal getW2() {
		return w2;
	}

	public void setW2(BigDecimal w2) {
		this.w2 = w2;
	}

	public BigDecimal getW3() {
		return w3;
	}

	public void setW3(BigDecimal w3) {
		this.w3 = w3;
	}

	public BigDecimal getD() {
		return d;
	}

	public void setD(BigDecimal d) {
		this.d = d;
	}

	

	
	
}