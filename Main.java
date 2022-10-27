
public class Main extends Funcoes{

    public static void main(String[] args) {
        
        String caminho = "./b3_stocks_1994_2020.csv";
        String caminho2 = "./b3stocks_T1.csv";
        String caminho3 = "./b3stocks_F1.csv";
        String caminhoTeste = "./b3_stock_teste.csv";

        //TransformarData transformarData = new TransformarData();
        //transformarData.transformacao(caminho);

        //FiltrarRegistro filtrarRegistro = new FiltrarRegistro();
        //filtrarRegistro.filtrar(caminho2);

        //Registro[] baseDeDados = construirVetorRegistro(caminho2); //verificar tamanho do vetor construido
        Registro[] baseDeDados = construirVetorMenor(caminhoTeste); //Vetor menor para testar as ordenações
        
        InsertionSort objInsertionSort = new InsertionSort();
        objInsertionSort.gerarInsertionSort(baseDeDados);

        SelectionSort objSelectionSort = new SelectionSort();
        objSelectionSort.gerarSelectionSort(baseDeDados);

        QuickSort objQuickSort = new QuickSort();
        objQuickSort.gerarQuickSort(baseDeDados);

        QuickSortMedianaDe3 objQuickSortMedianaDe3 = new QuickSortMedianaDe3();
        objQuickSortMedianaDe3.gerarQuickSortMed3(baseDeDados);

    }//Fim do main
}