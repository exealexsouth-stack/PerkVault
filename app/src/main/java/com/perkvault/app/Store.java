package com.perkvault.app;
import android.content.*;import org.json.*;import java.time.*;
class Store {
 static JSONArray read(Context c){try{return new JSONArray(c.getSharedPreferences("vault",0).getString("items","[]"));}catch(Exception e){return new JSONArray();}}
 static void write(Context c,JSONArray a){c.getSharedPreferences("vault",0).edit().putString("items",a.toString()).apply();}
 static boolean expired(JSONObject o){try{return LocalDate.parse(o.optString("expiry")).isBefore(LocalDate.now());}catch(Exception e){return false;}}
 static boolean duplicate(Context c,String code){if(code.trim().isEmpty())return false;JSONArray a=read(c);for(int i=0;i<a.length();i++)if(a.optJSONObject(i).optString("code").equalsIgnoreCase(code))return true;return false;}
}
