public class MergeSort extends Funcoes{
    
    public void gerarMergeSort(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println();
        System.out.println("____________MERGE SORT - ORDEM ALFABETICA____________");
        System.out.println();
        System.out.println("Medio Caso:");
        criarArquivo(MergeSortTickerTempo(vetor), "b3stocks_ticker_MergeSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_MergeSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(MergeSortTickerTempo(vetor), "b3stocks_ticker_MergeSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_MergeSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(MergeSortTickerTempo(inverterVetor(vetor)), "b3stocks_ticker_MergeSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_MergeSort_piorCaso.csv\" criado com sucesso.");
    }
        public Registro[] MergeSortTickerTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();

            MergeSortTicker(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] MergeSortTicker(Registro[] vetor, int inicio, int fim){

            if(inicio < fim){
                int meio = (inicio + fim)/2;

                MergeSortTicker(vetor, inicio, meio);
                MergeSortTicker(vetor, meio + 1, fim);
                Merge(vetor, inicio, meio, fim);
            }
            return vetor;
        }

        public void Merge(Registro vetor[], int inicio, int meio, int fim){        
            int tamEsq = meio - inicio + 1;
            int tamDir = fim - meio;
            
            Registro[] esq = new Registro[tamEsq];
            Registro[] dir = new Registro[tamDir];
            
            for (int i = 0; i < tamEsq; i++) {
                esq[i] = vetor[inicio + i];  
            }
            for (int i = 0; i < tamDir; i++) {
                dir[i] = vetor[meio + i + 1];  
            }

            int indexEsq = 0;
            int indexDir = 0;
            int indexVetor = inicio;

            while(indexEsq < tamEsq && indexDir < tamDir){
                if((esq[indexEsq].getTicker().compareTo(dir[indexDir].getTicker()) < 0)){
                    vetor[indexVetor] = esq[indexEsq];
                    indexVetor++;
                    indexEsq++;
                }else{
                    vetor[indexVetor] = dir[indexDir];
                    indexVetor++;
                    indexDir++;
                }
            }

            while(indexEsq < tamEsq){
                vetor[indexVetor] = esq[indexEsq];
                indexVetor++;
                indexEsq++;
            }
            while(indexDir < tamDir){
                vetor[indexVetor] = dir[indexDir];
                indexVetor++;
                indexDir++;
            }
        }
}
