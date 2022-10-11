import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        String caminho = "./b3_stocks_1994_2020.csv";

        TransformarData transformarData = new TransformarData(caminho);
        transformarData.transformacao(caminho);
        
    }//Fim do main
}