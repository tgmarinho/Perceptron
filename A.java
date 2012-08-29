package b;

public class A {


	

	public static void main(String[] args) {
		
		Entrada[] e = new Entrada[]
		{
		 new Entrada(0,0,0,0),
		 new Entrada(0,0,1,0),
		 new Entrada(0,1,0,0),
		 new Entrada(0,1,1,1),
		 new Entrada(1,1,0,1),
		 new Entrada(1,1,1,1)
		};
		
		double w1 = 1.0;
		double w2 = -1.0;
		double w3 = -1.0;
		
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
				new Entrada(1,0,1,1),
				new Entrada(1,0,0,1),
				new Entrada(0,1,1,1)
		};
		for(int i=0; i< teste.length; i++) {
			System.out.println("teste " + i + " é " + (teste[i].w(w1, w2, w3)?"Invalido" : "Valido"));
		}

	}
	
}

class Entrada {
	
	private int x1;
	private int x2;
	private int x3;
	
	private double w1;
	private double w2;
	private double w3;
	
	private int d;
	
	public Entrada(int x1, int x2, int x3, int d) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.d = d;
	}

	private int y() {
		double y = (x1 * w1) + (x2 * w2) + (x3 * w3);
		System.out.println("y = " + y);
		if (y >= 1)  {
			return 1;
		}
		return 0;
	}
	
	public boolean w(double w1, double w2, double w3) {
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;

		int y = y();
		if(y != d) {
			
			this.w1 = w1 + (0.2 * ((d - y) * x1));
			this.w2 = w2 + (0.2 * ((d - y) * x2));
			this.w3 = w3 + (0.2 * ((d - y) * x3));
			System.out.println("w1 " + this.w1);
			System.out.println("w2 " + this.w2);
			System.out.println("w3 " + this.w3);
			return true;
		}
		return false;
	}
	
	public int getD() {
		return d;
	}

	public double getW1() {
		return w1;
	}

	public void setW1(double w1) {
		this.w1 = w1;
	}

	public double getW2() {
		return w2;
	}

	public void setW2(double w2) {
		this.w2 = w2;
	}

	public double getW3() {
		return w3;
	}

	public void setW3(double w3) {
		this.w3 = w3;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getX3() {
		return x3;
	}
	
	
	
	
	
}