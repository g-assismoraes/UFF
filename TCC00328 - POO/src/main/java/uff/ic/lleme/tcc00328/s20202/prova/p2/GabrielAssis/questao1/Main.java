package uff.ic.lleme.tcc00328.s20202.prova.p2.GabrielAssis.questao1;
//segui a risca o UML deixando os atributos públicos, mas conforme o sr. falou na chamada coloquei os get's e set's
public class Main {
    public static Dicionario dicionario = new Dicionario();
    
    public static void main(String[] args){
        inserePalavras();
        mostraPalavras();
    }
    
    public static void inserePalavras(){
        //fiz hard-coded
        String grafia1 = "livro";
        String[] significados1 = {"coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por\n" +
"meio de cola, costura etc., formando um volume que se recobre com capa resistente.", "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."};
        dicionario.inserePalavra(grafia1, significados1, 0);
        
        String grafia2 = "obra";
        String[] significados2 = {"aquilo que resulta de um trabalho, de uma ação.", "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."};
        dicionario.inserePalavra(grafia2, significados2, 0);
    }
    
    public static void mostraPalavras(){
        
    for(int i = 0; i < dicionario.getTamanhoDicionario(); i++){
        System.out.println(dicionario.getPalavra(i).getGrafia());
        for(int j = 0; j < dicionario.getPalavra(i).getQtdSignificados(); j++){
            System.out.println(">> Significado " + (j + 1) + ":");
            System.out.println(dicionario.getPalavra(i).getSignificado(j));
        }
        System.out.println(" ");
    }
    
    }
}
