package com.bluelinelabs.conductor.internal;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.ControllerChangeHandler;

public class NoOpControllerChangeHandler extends ControllerChangeHandler {

    @Override
    public void performChange(@NonNull ViewGroup container, @NonNull View from, @NonNull View to, boolean isPush, @NonNull ControllerChangeCompletedListener changeListener) {
        changeListener.onChangeCompleted();
    }

}