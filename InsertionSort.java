
public class InsertionSort extends Funcoes {

    public void gerarInsertionSort(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println("____________INSERTION SORT - ORDEM ALFABETICA____________");
        System.out.println();
        System.out.println("Medio Caso:");
        criarArquivo(insertionSortTicker(vetor), "b3stocks_ticker_insertionSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_insertionSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(insertionSortTicker(vetor), "b3stocks_ticker_insertionSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_insertionSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(insertionSortTicker(inverterVetor(vetor)), "b3stocks_ticker_insertionSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_insertionSort_piorCaso.csv\" criado com sucesso.");
    }

        public Registro[] insertionSortTicker(Registro[] vetor){
            int j;
            Registro key;
            long inicio = System.currentTimeMillis();
            

            for(int i = 1; i < vetor.length; i++){
                key = vetor[i];
                j = i - 1;

                while(j >= 0 && (key.getTicker().compareTo(vetor[j].getTicker()) < 0)){
                    vetor[j+1] = vetor[j];
                    j--;
                }
                vetor[j+1] = key;
            }
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");
        
            return vetor;
        }
}
