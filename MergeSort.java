public class MergeSort {
    
    public void gerarQuickSortMed3(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println();
        System.out.println("____________MERGE SORT - ORDEM ALFABETICA____________");
        System.out.println();
        System.out.println("Medio Caso:");
        criarArquivo(QuickSortMed3Tempo(vetor), "b3stocks_ticker_QuickSortMediana3_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_QuickSortMediana3_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(QuickSortMed3Tempo(vetor), "b3stocks_ticker_QuickSortMediana3_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_QuickSortMediana3_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(QuickSortMed3Tempo(inverterVetor(vetor)), "b3stocks_ticker_QuickSortMediana3_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_QuickSortMediana3_piorCaso.csv\" criado com sucesso.");
    }
        public Registro[] MergeSortTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();

            MergeSort(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] MergeSort(Registro[] vetor, int inicio, int fim){

            if(inicio < fim){
                int meio = (inicio + fim)/2;
                pivo = Partition(vetor, inicio, fim);

                QuickSortTicker(vetor, inicio, pivo - 1);
                QuickSortTicker(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public int Partition(Registro A[], int inicio, int fim){        
            Registro pivo = A[fim];
            int i = inicio - 1;
    
            for(int j = inicio; j <= fim - 1; j++){
                if((A[j].getTicker().compareTo(pivo.getTicker()) < 0)){
                    i++;
                    troca(A, i, j);
                }
            }
            troca(A, i + 1, fim);
    
            return i+1;
        }
}
