package naive.bayes;

public class DataTraining {
  
    public static String[][] datas = {
        {"sunny","hot","high","weak"},
        {"sunny","hot","high","strong"},
        {"overcast","hot","high","weak"},
        {"rain","mild","high","weak"},
        {"rain","cool","normal","weak"},
        {"rain","cool","normal","strong"},
        {"overcast","cool","normal","strong"},
        {"sunny","mild","high","weak"},
        {"sunny","cool","normal","weak"},
        {"rain","mild","normal","weak"},
        {"sunny","mild","normal","strong"},
        {"overcast","mild","high","strong"},
        {"overcast","hot","normal","weak"},
        {"rain","mild","high","strong"},
    };
    
    public static String[] result = {
        "no",
        "no",
        "yes",
        "yes",
        "yes",
        "no",
        "yes",
        "no",
        "yes",
        "yes",
        "yes",
        "yes",
        "yes",
        "no", 
    };
}
