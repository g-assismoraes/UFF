package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOOCont.GabrielAssis;

public class Pessoa {
   private String nome;
   private long cpf;
   
   public Pessoa(){
       
   }
   
   public Pessoa(String nome, long cpf){
       this.nome = nome;
       this.cpf = cpf;
   }
   
   public String getNome(){
       return nome;
   }
   
   public long getCPF(){
       return cpf;
   }
   
   public void setNome(String nome){
       this.nome = nome;
   }
   
   public void setCPF(long cpf){
       this.cpf = cpf;
   }
}
