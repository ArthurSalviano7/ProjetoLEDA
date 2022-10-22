import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class FiltrarRegistro extends Funcoes{

    public void filtrar(String caminho){

        String colunas;
        String linha = null;
        int i = 0;

        float maiorVolume;

        try{
            FileWriter novoArquivo = new FileWriter("b3stocks_F1.csv"); //Criação do novo arquivo para escrita
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho))); 
            
            PrintWriter escrever = new PrintWriter(novoArquivo);
            colunas = arq.readLine(); 
            escrever.println(colunas); //Escreve a primeira linha

            Registro[] vetorRegistro = construirVetorRegistro(caminho); //Criação do vetor de objetos do tipo Registro
            OrdenarPorData(vetorRegistro);
            while((i < vetorRegistro.length)) {
                
                //String arrayDados[] = separarDados(linha);

                escrever.println(vetorRegistro[i].getData() +","+vetorRegistro[i].getTicker()+","+vetorRegistro[i].getOpen()+","+vetorRegistro[i].getClose()+","+vetorRegistro[i].getLow()+","+vetorRegistro[i].getHigh()+","+vetorRegistro[i].getVolume());
                i++;
            }

            System.out.println("Arquivo \"b3stocks_F1.csv\" criado com sucesso.");

            escrever.close();
            arq.close();
            novoArquivo.close();
        }//Fim do bloco try externo
        catch(IOException ex){
            System.out.println("Arquivo não encontrado!");
        }//Fim do catch

        

        //System.out.println(vetorRegistro[0].toString());
        //System.out.println(vetorRegistro[vetorRegistro.length - 1].toString());
    
    
    }//Fim do método transformacao()

    public Registro[] OrdenarPorData(Registro[] vetor){
	    int j;
	    
		for(int k=1; k<vetor.length; k++)   {

			Registro key = vetor[k];

			j = k-1;
			while(j>0 && (key.getData().compareTo(vetor[j].getData()) < 0))   {
				vetor[j+1] = vetor[j];
				j = j-1;
			}
			vetor[j+1] = key;
			
		}

		return vetor; 
	}
    }
