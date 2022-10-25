import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Funcoes {
    
    public static String[] separarDados(String linha){  //Separa os dados de cada linha por vírgula e armazena no array
        String valores[] = linha.split(",");

        return valores;
    }//Fim do método separarDados()


    public static Registro[] construirVetorRegistro(String caminho){
        Date dataLinha = null;
        String tickerLinha;
        float openLinha;
        float closeLinha;
        float highLinha;
        float lowLinha;
        float volumeLinha;
        String registroLinha;

        String linha = null;
        int i = 0;

        Registro vetorRegistro[] = new Registro[1883203]; //Quantidade de linhas (Desconsiderando a primeira)//

        try{
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho)));

            arq.readLine(); //Desconsidera a primeira linha;

            while((linha = arq.readLine()) != null) {
                
                String arrayDados[] = separarDados(linha);

                try{
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    dataLinha = formatter.parse(arrayDados[0]); 
                }catch(ParseException e){
                    e.printStackTrace();
                }
                
                tickerLinha = arrayDados[1];
                openLinha = Float.parseFloat(arrayDados[2]);
                closeLinha = Float.parseFloat(arrayDados[3]);
                highLinha = Float.parseFloat(arrayDados[4]);
                lowLinha = Float.parseFloat(arrayDados[5]);
                volumeLinha = Float.parseFloat(arrayDados[6]);
                registroLinha = linha;
                vetorRegistro[i] = new Registro(dataLinha, tickerLinha, openLinha, closeLinha, highLinha, lowLinha, volumeLinha, registroLinha);

                i++;
            }//Fim do while
            arq.close();
        }catch(IOException ex){
            System.out.println("Arquivo não encontrado!");
        }//Fim do catch

        return vetorRegistro;
    }//Fim do metodo ConstruirVetorRegistro

    public static void criarArquivo(Registro[] banco, String nomeArquivo){
        int i = 0;
        try{
            FileWriter novoArquivo = new FileWriter(nomeArquivo); //Criação do novo arquivo para escrita            
            PrintWriter escrever = new PrintWriter(novoArquivo);

            escrever.println("datetime,ticker,open,close,high,low,volume");

            while(i < banco.length){
                escrever.println(banco[i].toString());
                i++;
            }
            
            escrever.close();
            novoArquivo.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
