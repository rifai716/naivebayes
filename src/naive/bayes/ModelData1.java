/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naive.bayes;

/**
 *
 * @author LENOVO
 */
public class ModelData1 {
    private String[] data;
    private String result;

    public ModelData1(String[] data, String result){
        this.data = data;
        this.result = result;
    }
    
    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
