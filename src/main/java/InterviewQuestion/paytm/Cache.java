package InterviewQuestion.paytm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Synchronized;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    public static Map<String,String> cache = new HashMap<>(20);
    public static Map<Long,Student> Stdcache = new HashMap<>(20);

    public static  String cache(String str){
        synchronized (Cache.class){
            if(cache.containsKey(str)){
                return cache.get(str);
            }else{
                cache.put(str,str);
                return "New data inserted";
            }
        }
    }

    public static  String cache(Long id ,Student obj,int counter){
        synchronized (Cache.class){
            if(Stdcache.containsKey(id)){
                //Stdcache.get(id);
                return "data already exist";
            }else{
                if (counter >5 ) {
                    Stdcache.put(id,obj);
                    return "data already not exist";
                }
                return "No need to push data";

            }
        }
    }

    public static  String cache(Long id ,Student obj){
        synchronized (Cache.class){
            if(Stdcache.containsKey(id)){
                //Stdcache.get(id);
                return "data already exist";
            }else{
                Stdcache.put(id,obj);
                return "data already not exist";
            }
        }
    }
}


