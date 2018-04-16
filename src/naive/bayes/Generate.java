package naive.bayes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Generate {
    
    public static JSONArray dataLearning(ArrayList<ModelData1> data){
        
        int totalData = data.size();
        
        HashMap<String, Integer> mapResult = new HashMap<>();
        
        JSONArray arrJSON = new JSONArray();
        
        //Generate Result Probabilitas
        JSONObject objResult = new JSONObject();
        HashSet<String> unqResult = new HashSet<>();
        for(ModelData1 m : data){
            //System.out.println(m.getResult());
            unqResult.add(m.getResult());
        }
        //System.out.println(unqResult.toString());
        for (String r : unqResult) {
            int hitung = 0;
            for(ModelData1 m : data){
                if(m.getResult().equalsIgnoreCase(r)){
                    hitung++;
                }
            }
            //tambah dengan map
            mapResult.put(r, hitung);
            //
            objResult.put(r, (double)hitung/totalData);
        }
        arrJSON.add(objResult);
        
        //kelompokan berdasarkan Hasilnya (Yes | No)        
        for(String s : unqResult){
            System.out.println("\n\nKELOMPOK : "+s+"\n-------------------");
            JSONObject oData = new JSONObject();
            JSONArray ar1 = new JSONArray();
            
            for(int i = 0; i < data.get(0).getData().length; i++){                
                HashSet<String> unqAttribut = new HashSet<>();
                for(ModelData1 md : data){
                    unqAttribut.add(md.getData()[i]);
                }
                
                JSONObject kelompokData = new JSONObject();
                for(String r : unqAttribut){
                    int hitung = 0;
                    for(ModelData1 d : data){
                        if(d.getData()[i].equalsIgnoreCase(r) && d.getResult().equalsIgnoreCase(s)){
                            hitung++;
                        }
                    }
                    kelompokData.put(r, (double)hitung/mapResult.get(s));
                    System.out.println(r+" = "+(double)hitung/mapResult.get(s));
                }
                System.out.println("-----------------------------");
                
                ar1.add(kelompokData);
                oData.put(s, ar1);
            }
            arrJSON.add(oData);
        }
                
        //System.out.println(arrJSON.get(2)); //test only
        return arrJSON;
    }
    
    public static String test(String[] dataTest, JSONArray training){
        //hanya untuk tes
        //System.out.println("Hasil = "+testHelper(dataTest, training, 1, "no", 1, dataTest[1]));
        
        String out = null;
        double yesResult = 1;
        double noResult = 1;
        
        for(int i = 0; i < dataTest.length; i++){
            //System.out.println(testHelper(dataTest, training, 2, "yes", i, dataTest[i]));
            //System.out.println(testHelper(dataTest, training, 1, "no", i, dataTest[i]));
            yesResult *= (double)testHelper(dataTest, training, 2, "yes", i, dataTest[i]);
            noResult *= (double)testHelper(dataTest, training, 1, "no", i, dataTest[i]);
        }
        yesResult = yesResult*(double)((JSONObject)training.get(0)).get("yes");
        noResult = noResult*(double)((JSONObject)training.get(0)).get("no");
        
        System.out.println("YES : "+yesResult);
        System.out.println("NO : "+noResult);  
        
        if(yesResult < noResult) out = "NO";
        if(yesResult > noResult) out = "YES";
        
        return out;
    }
    
    private static double testHelper(String[] dataTest, JSONArray training,int idx, String keyResult, int idxAttr, String searchVal){
        JSONObject pTarget = (JSONObject)training.get(idx);
        //System.out.println(pTarget.get(keyResult));
        JSONArray qTarget = (JSONArray)pTarget.get(keyResult);
        //System.out.println(qTarget.get(idxAttr));
        JSONObject ppTarget = (JSONObject)qTarget.get(idxAttr);
        //System.out.println(ppTarget.get(searchVal));
        return (double)ppTarget.get(searchVal);
    }
}
