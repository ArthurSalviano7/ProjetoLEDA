import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Funcoes{

    public static void main(String[] args) {
        
        String caminho = "./b3_stocks_1994_2020.csv";
        String caminho2 = "./b3stocks_T1.csv";
        String caminho3 = "./b3stocks_F1.csv";

        TransformarData transformarData = new TransformarData();
        transformarData.transformacao(caminho);

        FiltrarRegistro filtrarRegistro = new FiltrarRegistro();
        filtrarRegistro.filtrar(caminho2);

        Registro[] baseDeDados = construirVetorRegistro(caminho2);
        
        InsertionSort objInsertionSort = new InsertionSort();
        objInsertionSort.insertionSort(baseDeDados);

        System.out.println("Dados Armazenados no Vetor");

    }//Fim do main
}