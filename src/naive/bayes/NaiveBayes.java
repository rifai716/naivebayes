package naive.bayes;

import java.util.ArrayList;
import org.json.simple.JSONArray;

public class NaiveBayes {
    
    static String[] dataTest = {"overcast","hot","high","strong"};
//    static String[] dataTest = {"sunny","cool","high","strong"};
    
    public static void main(String[] args) {
        naiveBayes(dataTest);
    }
    
    public static void naiveBayes(String[] test){
        ArrayList<ModelData1> modelTraining = new ArrayList<>();
        
        JSONArray arrObj = new JSONArray();
        
        for(int i = 0; i < DataTraining.datas.length; i++){
            modelTraining.add(new ModelData1(DataTraining.datas[i],DataTraining.result[i]));    
        }
        
        arrObj = Generate.dataLearning(modelTraining);
        System.out.println("\n"+arrObj.toJSONString());
        
        //Hasil Test
        System.out.println("\nKesimpulannya = "+Generate.test(dataTest, arrObj));
    }
       
}
