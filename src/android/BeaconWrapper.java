package com.streethawk.beacon

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import android.app.Service;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.os.IBinder;
import android.content.Context;
import com.streethawk.library.beacon.INotifyBeaconTransition;
import com.streethawk.library.beacon.BeaconData;
import android.app.Activity;

public class BeaconWrapper extends Service implements INotifyBeaconTransition{
    
    private final String TAG = "StreetHawk";
    private final String SUBTAG = "BeaconWrapper ";
    
    private final String UUID           = "uuid";
    private final String MAJOR_NUMBER   = "majornumber";
    private final String MINOR_NUMBER   = "minornumber";
    private final String DISTANCE       = "distance";
    

	private static CallbackContext shNotifyBeaconDetectedCallback;
	
    private static BeaconWrapper mInstance=null;

	public static BeaconWrapper getInstance(){
		if(null==mInstance){
			mInstance = new BeaconWrapper();
		}
		return mInstance;
	}
    
    public void setNotifyBeaconDetectCallback(Activity activity,CallbackContext cb){
		shNotifyBeaconDetectedCallback = cb;
        if(null==activity)
            return;
        Intent intent = new Intent(actvity,BeaconWrapper.class);
        Context context = activity.getApplicationContext();
        context.startService(intent);
        Beacons.getInstance(context).registerForBeaconStatus(this);
	}
    
    @Override
    public void notifyBeaconDetected() {
        ArrayList<BeaconData> beacons = Beacons.getInstance(this).getDetectedBeaconList();
        if(null!=shNotifyBeaconDetectedCallback){
            JSONArray beaconArray = new JSONArray();
            for(BeaconData data : beacons){
                JSONObject obj = new JSONObject();
                try {
                    obj.put(UUID, data.getUUID());
                    obj.put(MAJOR_NUMBER, data.getMajorNumber());
                    obj.put(MINOR_NUMBER, data.getMinorNumber());
                    obj.put(DISTANCE, data.getDistance());
                }catch(JSONException e){
                    e.printStackTrace();
                }
                beaconArray.put(obj);
            }
            PluginResult presult = new PluginResult(PluginResult.Status.OK,beaconArray);
            presult.setKeepCallback(true);
            shNotifyBeaconDetectedCallback.sendPluginResult(presult);
        }   
    }
    
    @Override
	public IBinder onBind(Intent intent) {
		return null;
	}   
}