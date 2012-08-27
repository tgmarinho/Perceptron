import java.util.HashMap;
import java.util.Map;

public class PerceptronRNA {

	public static void main(String arg[]) {
		
		/**
		 Algoritmo:
					O algoritmo do Perceptron é descrito a seguir:
					1. Inicializar os pesos e o coeficiente de limiar com valores dentro do intervalo (0,1);
					2. Apresentar o padrão de entrada e saída desejada;
					3. Calcular a saída;
					4. Aplicar a função limiar: Sq(t) = flim (S(t))
					5. Atualizar os pesos: Wi+1 = Wi + η * (d - y)* xi;
					η = constante de aprendizado (0,2) ; d – y = erro (diferença entre saída desejada e calculada), xi = i
						i-ésima entrada
					6. Voltar ao passo 2 até que a saída Sq esteja respondendo corretamente à saída desejada.
					Quando não ocorrem mudanças, diz se que a rede aprendeu o processo.
		 */
		
		
		int[] peso = new int[4];
		int[][] entrada = new int[4][8];
		
		peso[0] =  1; // W1
		peso[1] = -1; // W2
		peso[2] = -1; // W3
		peso[3] = -1; // Wb
		
		//entrada x1
		entrada[0][0] = 0;
		entrada[0][1] = 0;
		entrada[0][2] = 0;
		entrada[0][3] = 0;
		entrada[0][4] = 1;
		entrada[0][5] = 1;
		entrada[0][6] = 1;
		entrada[0][7] = 1;
		
		//entrada x2
		entrada[1][0] = 0;
		entrada[1][1] = 0;
		entrada[1][2] = 1;
		entrada[1][3] = 1;
		entrada[1][4] = 0;
		entrada[1][5] = 0;
		entrada[1][6] = 1;
		entrada[1][7] = 1;
		
		//entrada x3
		entrada[2][0] = 0;
		entrada[2][1] = 1;
		entrada[2][2] = 0;
		entrada[2][3] = 1;
		entrada[2][4] = 0;
		entrada[2][5] = 1;
		entrada[2][6] = 0;
		entrada[2][7] = 1;
		
		//entrada d
		entrada[3][0] = 0;
		entrada[3][1] = 0;
		entrada[3][2] = 0;
		entrada[3][3] = 1;
		entrada[3][4] = 1;
		entrada[3][5] = 1;
		entrada[3][6] = 1;
		entrada[3][7] = 1;
				
		
		Map<String, Integer> soma = new HashMap<String, Integer>();
		
		// soma = w1X1 + w2X2 + ... + wpXp (peso*entrada) + (peso1*entrada2) ....
		
			for(int j = 0; j < entrada[0].length; j++) {
				
				switch(j){
					
					case 0: 
							soma.put("soma0", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;
					
					case 1: 
							soma.put("soma1", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;	
					
					case 2: 
							soma.put("soma2", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;
					
					case 3: 
							soma.put("soma3", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;
					case 4: 
							soma.put("soma4", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;
							
					case 5: 
							soma.put("soma5", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;	
							
					case 6: 
							soma.put("soma6", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;
					case 7: 
							soma.put("soma7", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j] + peso[3] * entrada[3][j]);
							break;	
					default : System.out.println("vixi não tem vc hein : " + j);
				}
			
		}// fim for
			
			// percorro do os valores de do Mapa Soma
			for(int i = 0; i<soma.size();i++){
				// verifico se tem alguma chave chamada soma0, soma1, soma2 .... somaN
				if(soma.containsKey("soma"+i)){
					// se tiver mando imprimir o seu valor correpondente a chave soma0...somaN
					System.out.println("soma"+ i + "=" + soma.get("soma"+i) );
				}
			}
	
	}
}