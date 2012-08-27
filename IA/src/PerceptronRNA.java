import java.util.HashMap;
import java.util.Map;

/**
 * @author tgmarinho
 * @version 1
 * @category Inteligencia Artificial
 * @since 2012
 * @serial Perceptron Algoritmo para RNA
 * 
 * 		 Algoritmo:
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

public class PerceptronRNA {

	public static void main(String arg[]) {
		
		// Inicializar a rede e o treinamento
		iniciliarRede();

	}

	public static void iniciliarRede(){

		int[] peso = new int[4];
		int[][] entrada = new int[4][8];

		peso[0] =  1; // W1
		peso[1] = -1; // W2
		peso[2] = -1; // W3
		//peso[3] = -1; // Wb

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

		//Inicializar o Treinamento
		elementoProcessador(entrada, peso, soma);

		// soma = w1X1 + w2X2 + ... + wpXp (peso*entrada) + (peso1*entrada2) ....

	}

	public static void elementoProcessador(int entrada[][], int peso[], Map<String, Integer> soma) {

		for(int j = 0; j < entrada[0].length; j++) {

			switch(j){

			case 0: 
				soma.put("saida0", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;

			case 1: 
				soma.put("saida1", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;	

			case 2: 
				soma.put("saida2", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;

			case 3: 
				soma.put("saida3", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;
			case 4: 
				soma.put("saida4", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;

			case 5: 
				soma.put("saida5", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;	

			case 6: 
				soma.put("saida6", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;
			case 7: 
				soma.put("saida7", peso[0] * entrada[0][j] + peso[1] * entrada[1][j] + peso[2] * entrada[2][j]);
				break;	
			default : System.out.println("vixi não tem vc hein : " + j);
			}

		}// fim for

		// percorro do os valores de do Mapa Soma
		for(int i = 0; i<soma.size();i++){
			// verifico se tem alguma chave chamada soma0, soma1, soma2 .... somaN
			if(soma.containsKey("saida"+i)){

				for(int posicao = 0; posicao<entrada[3].length; posicao++){
					if(entrada[3][posicao] == soma.get("saida"+posicao)){
						System.out.println("beleza não precisa atualizar peso..." + soma.get("saida"+posicao));
					} else {
						atualizarPeso(entrada, peso, soma);
						//atualizo o novo peso, e logo em seguida executo o processo novamente
					}

				}


				// se tiver mando imprimir o seu valor correpondente a chave soma0...somaN
				System.out.println("EntradaX"+ i + "=" + soma.get("saida"+i) );
			}
		}
	}


	public static void atualizarPeso(int entrada[][], int peso[], Map<String, Integer> soma) {

		

		// depois de atualizar o peso executo o processador
		elementoProcessador(entrada, peso, soma);

	}
}