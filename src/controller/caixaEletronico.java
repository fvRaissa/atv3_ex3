package controller;

import java.util.concurrent.Semaphore;

public class caixaEletronico extends Thread {
	
	private int transação;
	private Semaphore semaforo;
	private Semaphore semaforo2;
	private int conta;
	private double saldo;
	private double valorTransacao;
	

	public caixaEletronico(int transacao, Semaphore semaforo, Semaphore semaforo2, int conta, double saldo,double valorTransacao) {
		this.transação = transacao;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
		this.conta = conta;
		this.saldo = saldo;
		this.valorTransacao = valorTransacao;
	}

	public void run() {
		if(transação == 1) {
			try {
				semaforo.acquire();
				deposito();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				semaforo.release();
				transaçãoConcluida();
			}
		}else{
			try {
				semaforo2.acquire();
				saque();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				semaforo2.release();
				transaçãoConcluida();
			}
		}
		
		
		
		
		
		
	}

	
	private void deposito() {
		System.out.println(String.format("fazendo deposito de R$ %.2f", valorTransacao," na conta: ",conta));
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saque() {
		System.out.println(String.format("fazendo saque de R$ %.2f",valorTransacao," na conta: ",conta));
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	private void transaçãoConcluida() {
		System.out.println("Transação feita com sucesso");
		
	} 
}
