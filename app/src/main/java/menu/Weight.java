package menu;

/**
 * Created by LAB203_52 on 17/9/2561.
 */

public class Weight {
    String date;
    int weight;
    String status;

    public Weight(){

    }

    public Weight(String date, int weight, String status){
        this.setDate(date);
        this.setWeight(weight);
        this.setStatus(status);
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getStatus(){
        return  status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
