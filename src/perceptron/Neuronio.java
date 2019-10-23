package perceptron;

public class Neuronio {
	private int[] x; //entradas (Atributos do Padrao Apresentado)
 
	private double[] w; //pesos (Aprendizado da Rede)
	
	private double y; //Saida do neuronio
	
	private double yd; //Saida desejada (Necessaria para treinar a rede)

	private double e; //erro do neuronio

	private double n; //Taxa de aprendizado 


	/**
	 * Construtor da classe Neuronio
	 * Inicializa as variaveis globais e chama o metodo inicilizaPesos()
	 * 
	 * @param quantEntrada
	 */
	public Neuronio(int quantEntrada) {
		x = new int[quantEntrada];
		w = new double[quantEntrada];
		
		n = 0.3;//Inicializa taxa de aprendizado
		
		inicializaPesos();
	}
	
	/**
	 * Inicializa pesos
	 *
	 */
	private void inicializaPesos() {
		for (int i = 0; i < w.length; i++) {
			w[i] = 0;
		}
	}
	
	/**
	 * Insere entrada do neuronio (padrao)
	 * 
	 * @param indice
	 * @param valor
	 */
	public void setEntrada(int indice, int valor) {
		x[indice] = valor;
	}
	
	/**
	 * Insere o valor da saida desejada do padrao
	 * @param valor
	 */
	public void setSaidaDesejada(int valor) {
		yd = valor;
	}
	
	/**
	 * calcula a saida do neuronio usando funcao degrau
	 *
	 */
	public void calcSaidaNeuronio() {
		double u = 0;//somatorio
		//Somatorio
		for (int i = 0; i < w.length; i++) {
			u = u + (x[i] * w[i]);
		}
		System.out.println("U = "+u);
		
		//Funcao degrau
		
		if(u >= 0)
			y = 1;
		else
			y = 0;
		
		System.out.println("Y = "+y);
	}

	/**
	 * Calcula erro do neuronio
	 */
	public void setErro() {
		e = yd - y;
		if (e != 0)
			atualizaPeso();
		System.out.println("e = " + e);
	}

	/**
	 * Atualiza os pesos do neuronio
	 * 
	 */
	private void atualizaPeso() {
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i] + n*e*x[i];
			System.out.println("w[" + i + "] = "+w[i]);
		}
	}
	
	/**
	 * 
	 * @return retorna o erro total do neuronio
	 */
	public double getErro() {
		return e;
	}
	
	/**
	 * 
	 * @return retorna a saida do neuronio
	 */
	public double getSaida() {
		return y;
	}

}
