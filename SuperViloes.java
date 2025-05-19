public class SuperViloes{
    private String nome;
    private int nivelDeMaldade;
   
   public SuperViloes(String nome, int nivelDeMaldade){
     this.nome = nome;
     this.nivelDeMaldade = nivelDeMaldade;
   }
     public String getNome(){
       return nome;
     }
     public int getNivelDeMaldade(){
       return nivelDeMaldade;
     }
     public void setNome(String nome){
       this.nome = nome;
     }
     public void setNivelDeMaldade(int nivelDeMaldade){
       this.nivelDeMaldade = nivelDeMaldade;
    }

   }