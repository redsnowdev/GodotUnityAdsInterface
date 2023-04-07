package com.redsnowdev.unityadsinterface;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;
import org.godotengine.godot.plugin.SignalInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnityAdsInterface extends GodotPlugin {
    public UnityAdsInterface(Godot godot) {
        super(godot);
    }

    @NonNull
    @Override
    public String getPluginName() {
        return "UnityAdsInterface";
    }

    @NonNull
    @Override
    public List<String> getPluginMethods() {
        return Arrays.asList(
                "getHelloWorld"
        );
    }
    public String getHelloWorld(){
        return "Hello Godot";
    }
}
/*
private boolean isAdReady = false;
    private boolean isInitialized = false;
    private final String TAG = "UnityAdsInterface";
    private SignalInfo UnityAdsReady = new SignalInfo("UnityAdsReady");
    private SignalInfo UnityAdsStart = new SignalInfo("UnityAdsStart");
    private SignalInfo UnityAdsFinish = new SignalInfo("UnityAdsFinish", String.class, String.class);
    private SignalInfo UnityAdsError = new SignalInfo("UnityAdsError", String.class);

    public UnityAdsInterface(Godot godot) {
        super(godot);
    }

    @androidx.annotation.NonNull
    @Override
    public String getPluginName() {
        return "UnityAdsGodot";
    }

    @NonNull
    @Override
    public List<String> getPluginMethods() {
        return new ArrayList<String>() {
            {
                add("initialise");
                add("loadAd");
                add("show");
                add("isReady");
            }
        };
    }

    @NonNull
    @Override
    public Set<SignalInfo> getPluginSignals() {
        return new HashSet<SignalInfo>() {
            {
                add(UnityAdsReady);
                add(UnityAdsStart);
                add(UnityAdsFinish);
                add(UnityAdsError);
            }
        };
    }

    public void initialise(String appId, boolean testMode) {
        try {
            UnityAds.initialize(getActivity(), appId, testMode, this);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
    }

    @Override
    public void onInitializationComplete() {
        isInitialized = true;
    }

    @Override
    public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {
        isInitialized = false;
        Log.e("UnityAdsExample", "Unity Ads initialization failed with error: [" + error + "] " + message);
    }

    private IUnityAdsLoadListener loadListener = new IUnityAdsLoadListener() {
        @Override
        public void onUnityAdsAdLoaded(String placementId) {
//            UnityAds.show((Activity)getApplicationContext(), adUnitId, new UnityAdsShowOptions(), showListener);
            emitSignal( UnityAdsReady.getName() );
            isAdReady = true;
        }

        @Override
        public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
            Log.e("UnityAdsExample", "Unity Ads failed to load ad for " + placementId + " with error: [" + error + "] " + message);
            isAdReady = false;
        }
    };

    private IUnityAdsShowListener showListener = new IUnityAdsShowListener() {
        @Override
        public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
            Log.e("UnityAdsExample", "Unity Ads failed to show ad for " + placementId + " with error: [" + error + "] " + message);
            int state = 0;
            emitSignal(UnityAdsFinish.getName(), placementId, String.format("%d", state));
        }

        @Override
        public void onUnityAdsShowStart(String placementId) {
            Log.v("UnityAdsExample", "onUnityAdsShowStart: " + placementId);
            emitSignal(UnityAdsStart.getName());
        }

        @Override
        public void onUnityAdsShowClick(String placementId) {
            Log.v("UnityAdsExample", "onUnityAdsShowClick: " + placementId);
        }

        @Override
        public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
            Log.v("UnityAdsExample", "onUnityAdsShowComplete: " + placementId);
            if (state.equals(UnityAds.UnityAdsShowCompletionState.COMPLETED)) {
                // Reward the user for watching the ad to completion
                emitSignal(UnityAdsFinish.getName(), placementId, String.format("%d", 2));
            } else {
                // Do not reward the user for skipping the ad
                emitSignal(UnityAdsFinish.getName(), placementId, String.format("%d", 1));
            }
        }
    };

    public boolean isReady(String placementId) {
        return isAdReady;
    }

    public void loadAd(String placementId) {
        UnityAds.load(placementId);
    }

    public boolean show(String placementId) {
        if (isAdReady) {
            try {
                UnityAds.show(getActivity(), placementId);
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage());
                return false;
            }
            return true;
        } else {
            Log.i(TAG, "Adds not ready");
            return false;
        }
    }
 */