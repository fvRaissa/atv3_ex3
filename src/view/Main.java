package view;
import java.util.concurrent.Semaphore;
import controller.caixaEletronico;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		
		
		int permissoes = 1;
		
		Semaphore semaforo = new Semaphore(permissoes);
		Random random = new Random();
		
		
		double saldo;
		double valorTransacao;
		int transacao;
		
		for(int i = 0; i< 20; i++) {
			transacao = random.nextInt(2);
			saldo = (double)((Math.random()*101)+200);
			valorTransacao = (double)((Math.random()*101)+100);
			caixaEletronico caixa = new caixaEletronico(transacao,semaforo,semaforo,i+1,saldo,valorTransacao);
			caixa.start();
		}

	}

}
