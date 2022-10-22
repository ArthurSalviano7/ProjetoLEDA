import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Funcoes {
    
    public String[] separarDados(String linha){  //Separa os dados de cada linha por vírgula e armazena no array
        String valores[] = linha.split(",");

        return valores;
    }//Fim do método separarDados()


    public Registro[] construirVetorRegistro(String caminho){
        Date dataLinha = null;
        String tickerLinha;
        float openLinha;
        float closeLinha;
        float highLinha;
        float lowLinha;
        float volumeLinha;

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
                vetorRegistro[i] = new Registro(dataLinha, tickerLinha, openLinha, closeLinha, highLinha, lowLinha, volumeLinha);

                i++;
                //escrever.println(formatarData(arrayDados[0])+","+arrayDados[1]+","+arrayDados[2]+","+arrayDados[3]+","+arrayDados[4]+","+arrayDados[5]+","+arrayDados[6]);
            }//Fim do while

            //System.out.println("Arquivo \"b3stocks_F1.csv\" criado com sucesso.");
            arq.close();
        }catch(IOException ex){
            System.out.println("Arquivo não encontrado!");
        }//Fim do catch

        return vetorRegistro;
    }
}
