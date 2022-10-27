
public class SelectionSort extends Funcoes{
    
    public void gerarSelectionSort(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println();
        System.out.println("____________SELECTION SORT - ORDEM ALFABETICA____________");
        System.out.println();
        System.out.println("Medio Caso:");
        criarArquivo(selectionSortTicker(vetor), "b3stocks_ticker_selectionSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_selectionSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(selectionSortTicker(vetor), "b3stocks_ticker_selectionSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_selectionSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(selectionSortTicker(inverterVetor(vetor)), "b3stocks_ticker_selectionSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_selectionSort_piorCaso.csv\" criado com sucesso.");
    }

        public Registro[] selectionSortTicker(Registro[] vetor){
            int menor;
            long inicio = System.currentTimeMillis();
            

            for(int i = 0; i < vetor.length - 1; i++){
                menor = i;

                for(int j = i+1; j < vetor.length; j++){
                    if((vetor[menor].getTicker().compareTo(vetor[j].getTicker()) > 0)){
                        menor = j;
                    }
                }
                troca(vetor, i, menor);
            }
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");
        
            return vetor;
        }
}
