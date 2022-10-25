
public class InsertionSort extends Funcoes {
    
    public void insertionSort(Registro[] vetorOriginal){
        int j;
        
        Registro[] vetor = vetorOriginal.clone();
        int n = vetor.length;

        for(int i = 1; i < n; i++){
            
            Registro key = vetor[i];
            j =i - 1;

            while(j >= 0 && (key.getTicker().compareTo(vetor[j].getTicker()) < 0)){
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = key;
        }
        criarArquivo(vetor, "b3stocks_ticker_insertionSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_insertionSort_medioCaso.csv\" criado com sucesso.");
    }
}
