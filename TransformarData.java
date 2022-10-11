import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformarData {
    private String caminho;

    public TransformarData(String caminho){
        this.caminho = caminho;
    }

    public void transformacao(String caminho){

        String colunas;
        String linha = null;

        try{
            FileWriter novoArquivo = new FileWriter("b3stocks_T1.csv"); //Responsável pela criação  do novo arquivo formatado
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho))); //Responsável pela leitura do arquivo a ser transformado// 
            
            PrintWriter escrever = new PrintWriter(novoArquivo);
            colunas = arq.readLine();
            escrever.println(colunas);

            while((linha = arq.readLine()) != null) {
                
                String arrayDados[] = separarDados(linha);

                escrever.println(formatarData(arrayDados[0])+","+arrayDados[1]+","+arrayDados[2]+","+arrayDados[3]+","+arrayDados[4]+","+arrayDados[5]+","+arrayDados[6]);
            }

            System.out.println("Arquivo \"b3stocks_T1.csv\" criado com sucesso.");

            escrever.close();
            arq.close();
            novoArquivo.close();
        }//Fim do bloco try
        catch(IOException ex){
            System.out.println("Arquivo não encontrado!");
        }//Fim do catch
    }//Fim do método transformacao()



    private String[] separarDados(String linha){  //Separa os dados de cada linha por vírgula e armazena no array
        String valores[] = linha.split(",");

        return valores;
    }//Fim do método separarDados()


    private String formatarData(String data){ // Transforma de YYYY-MM-DD para o formato DD/MM/AAAA //
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateToStr = null;

        try{
            Date novaData = formatter.parse(data);
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            dateToStr = formatter.format(novaData);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        
        return dateToStr;
    }//Fim do método formatarData()

}
