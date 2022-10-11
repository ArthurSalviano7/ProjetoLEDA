import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lerCSV{

    public static void main(String[] args) {
        
        File arquivoCSV = new File("b3_stocks_1994_2020.csv");
        
        int n = 1883204; //Quantidade de linhas do arquivo//
        int i = 0;

        String data[] = new String[n];
        String ticker[] = new String[n];
        float high[] = new float[n];
        float low[] = new float[n];
        float volume[] = new float[n];

        String linha;

        try{
            Scanner leitor = new Scanner(arquivoCSV);
            
            leitor.nextLine();

            while(leitor.hasNextLine()){

                linha = leitor.nextLine();
                
                
                String valores[] = linha.split(","); //Separa a linha//
                
                //Pega os valores separados por vírgula de cada linha//
                String dataLinha = valores[0];
                String tickerLinha = valores[1];
                float highLinha = Float.parseFloat(valores[4]);
                float lowLinha = Float.parseFloat(valores[5]);
                float volumeLinha = Float.parseFloat(valores[6]);

                //Adiciona nas respectivas listas//
                
                data[i] = dataLinha;
                ticker[i] = tickerLinha;
                high[i] = highLinha;
                low[i] = lowLinha;
                volume[i] = volumeLinha;
                

                i++;
            }//Fim do while
        }//Fim do try
        catch(FileNotFoundException ex){
            System.out.println("Arquivo não encontrado");
        }

        System.out.println("i = " + i);
        System.out.println("ARQUIVOS ARMAZENADOS");
        System.out.println("data: " + data[1048574] + "  ticker: " + ticker[1048574] + "  high: " + high[1048574] + "  low: " + low[1048574] + "  volume: " + volume[1048574]);
    }//Fim do main
}