/*
 * Copyright (c) 2015 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lineageos.settings.device;

import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class ChopChopSensor implements SensorEventListener, UpdatedStateNotifier {
    private static final String TAG = "LineageActions-ChopChopSensor";

    private static final int TURN_SCREEN_ON_WAKE_LOCK_MS = 500;

    private final LineageActionsSettings mLineageActionsSettings;
    private final SensorAction mAction;
    private final SensorHelper mSensorHelper;
    private final Sensor mSensor;

    private boolean mIsEnabled;

    public ChopChopSensor(LineageActionsSettings cmActionsSettings, SensorAction action,
        SensorHelper sensorHelper) {
        mLineageActionsSettings = cmActionsSettings;
        mAction = action;
        mSensorHelper = sensorHelper;
        mSensor = sensorHelper.getChopChopSensor();
    }

    @Override
    public synchronized void updateState() {
        if (mLineageActionsSettings.isChopChopGestureEnabled() && !mIsEnabled) {
            Log.d(TAG, "Enabling");
            mSensorHelper.registerListener(mSensor, this);
            mIsEnabled = true;
        } else if (! mLineageActionsSettings.isChopChopGestureEnabled() && mIsEnabled) {
            Log.d(TAG, "Disabling");
            mSensorHelper.unregisterListener(this);
            mIsEnabled = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "chop chop triggered");
        mAction.action();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
