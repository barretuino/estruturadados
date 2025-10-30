package codFonte;

public class TrieComprimidaPatricia {

    
    public static void main(String[] args) {
       Patricia t = new Patricia();
         
        
        t.inserir("fato");
        t.inserir("fatal");
        t.inserir("fidedigno");
        t.inserir("fomentar");
        t.inserir("fel");
        t.inserir("feliz");
        t.inserir("fulguras");
        t.inserir("família");
        t.inserir("fomento");
        t.inserir("fazer");
        
        t.inserir("facção");
        t.inserir("formal");
        t.inserir("formalismo");
        t.inserir("final");
        t.inserir("finalidade");
        t.inserir("futil");
        t.inserir("futilidade");
        t.inserir("fundamento");
        t.inserir("fundar");
        t.inserir("fumar");
        
        
        //teste edital    
//        t.inserir("bear");
//        t.inserir("bell");
//        t.inserir("bid");
//        t.inserir("bull");
//        t.inserir("buy");
//        t.inserir("sell");
//        t.inserir("stock");
//        t.inserir("stop");
        
        System.out.println("Palavras contidas na árvore:"); 
        t.exibir();       
        
        System.out.println("//////////////////////////////////////////");        
        System.out.println("Níveis da árvore:");
        t.exibeNiveis();
    }
}
