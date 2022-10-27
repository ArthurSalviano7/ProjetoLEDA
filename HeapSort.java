public class HeapSort extends Funcoes {

    public void gerarHeapSort(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println();
        System.out.println("____________HEAP SORT - ORDEM ALFABETICA____________");
        System.out.println();
        System.out.println("Medio Caso:");
        criarArquivo(HeapSortTicker(vetor), "b3stocks_ticker_HeapSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_HeapSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(HeapSortTicker(vetor), "b3stocks_ticker_HeapSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_HeapSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(HeapSortTicker(inverterVetor(vetor)), "b3stocks_ticker_HeapSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_HeapSort_piorCaso.csv\" criado com sucesso.");
    }

        public Registro[] HeapSortTicker(Registro[] vetor){
            int i;
            long inicio = System.currentTimeMillis();

            buildMaxHeap(vetor);

            for(i = vetor.length-1; i>0;i--){
                troca(vetor, 0, i);
                maxHeapify(vetor, 0, i);
            }
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public void buildMaxHeap(Registro vetor[]){        
            for(int i = (vetor.length/2)-1; i >= 0; i--){
                maxHeapify(vetor, i, vetor.length);
            }
        }

        public void maxHeapify(Registro[] vetor, int i, int fim){

            int esq = 2*i+1;
            int dir = 2*i+2;

            int maior;

            if(esq < fim && (vetor[esq].getTicker().compareTo(vetor[i].getTicker()) >= 0)){
                maior = esq;
            }
            else{
                maior = i;
            }

            if(dir < fim && (vetor[dir].getTicker().compareTo(vetor[maior].getTicker()) >= 0)){
                maior = dir;
            }
            
            if(maior != i){
                troca(vetor, maior, i);
                maxHeapify(vetor, maior, fim);
            }
        }
}
