package Bootcamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Dev {
	private String nome;
	private List<Conteudo> conteudosInscritos = new ArrayList<>();
	private List<Conteudo> conteudosConcluidos = new ArrayList<>();
	
	  public void inscreverBootcamp(Bootcamp bootcamp){
	        this.conteudosInscritos.addAll(bootcamp.getConteudos());
	        bootcamp.getDevsInscritos().add(this);
	 }
	  
	  public void progredir() {
	        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
	        if(conteudo.isPresent()) {
	            this.conteudosConcluidos.add(conteudo.get());
	            this.conteudosInscritos.remove(conteudo.get());
	        } else {
	            System.err.println("Você não está matriculado em nenhum conteúdo!");
	        }
	    }

	    public double calcularTotalXp() {
	        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
	        double soma = 0;
	        while(iterator.hasNext()){
	            double next = iterator.next().calcularXp();
	            soma += next;
	        }
	        return soma;
	    }

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Conteudo> getConteudosInscritos() {
			return conteudosInscritos;
		}

		public void setConteudosInscritos(List<Conteudo> conteudosInscritos) {
			this.conteudosInscritos = conteudosInscritos;
		}

		public List<Conteudo> getConteudosConcluidos() {
			return conteudosConcluidos;
		}

		public void setConteudosConcluidos(List<Conteudo> conteudosConcluidos) {
			this.conteudosConcluidos = conteudosConcluidos;
		}
	    
}
