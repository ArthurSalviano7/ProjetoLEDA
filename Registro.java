import java.util.Date;

public class Registro {
    
    private Date data;
    private String ticker;
    private float open;
    private float close;
    private float high;
    private float low;
    private float volume;

    Registro(){}

    public Registro(Date data, String ticker, float open, float close, float high, float low, float volume) {
        this.data = data;
        this.ticker = ticker;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }



    public void setData(Date data){
        this.data = data;
    }

    public Date getData(){
        return data;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
    

    @Override

    public String toString(){
        return data + "," + ticker + "," + open + "," + close + high + "," + low + "," + volume; 
    }


}
