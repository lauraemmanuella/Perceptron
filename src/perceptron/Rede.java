package perceptron;

import java.util.Scanner;

public class Rede {

	Scanner entrada = new Scanner(System.in);
	int qtdAtributos;
	int qtdExemplos;
	Neuronio mcp;//McCulloch e Pitts (criadores do neuronio)
	
	int[][] exemplos = { {1,0 },{ 0,1 }, {1,0 }, { 1,1 } };
	int[] saidaDesejada = { 0, 1, 1, 1};

	public static void main(String[] args) {
		Rede perceptron = new Rede();
		perceptron.iniciarRede();
		perceptron.treinarRede();
		perceptron.executarRede();
	}

	public void iniciarRede() {
		System.out.println("--------------------------------");
		System.out.println("INICIANDO REDE NEURAL PERCEPTRON");
		System.out.println("--------------------------------");
		qtdExemplos = exemplos.length;
		qtdAtributos = exemplos[0].length;
		mcp = new Neuronio(qtdAtributos); //inicializa o objeto
	}

	public void treinarRede() {
		double erro;
		int iteracao = 1;
		System.out.println("--------------------------------");
		System.out.println("TREINANDO REDE NEURAL PERCEPTRON");
		System.out.println("--------------------------------");
		do {
			System.out.println("ITERACAO " + iteracao++);
			erro = 0;
			for (int i = 0; i < qtdExemplos; i++) {//Mostra todos os padroes
				for (int j = 0; j < qtdAtributos; j++) {//Mostra os atributos de cada padrao
					mcp.setEntrada(j, exemplos[i][j]);//indice e valor da entrada do neuronio
				}
				mcp.setSaidaDesejada(saidaDesejada[i]);
				mcp.calcSaidaNeuronio();
				mcp.setErro();
				erro = erro + Math.abs(mcp.getErro()); //TODO valor absoluto de getErro
			}
		} while (erro > 0);
		System.out.println("--------------------------------");
	}

	public void executarRede() {
		do {
			System.out.println("--------------------------------");
			System.out.println("EXECUTANDO REDE NEURAL PERCEPTRON");
			System.out.println("--------------------------------");
			System.out.println("ENTRE COM OS ATRIBUTOS DO PADRAO ");
			for (int j = 0; j < qtdAtributos; j++) {
				mcp.setEntrada(j, entrada.nextInt());
			}
			mcp.calcSaidaNeuronio();
			System.out.println("PADRAO PERTENCE A CLASSE: " + mcp.getSaida());
			System.out.println("DIGITE 9 PARA CONTINUAR");
		} while (entrada.nextInt() == 9);
		System.out.println("--------------------------------");
	}

}
