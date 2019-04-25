package com.bluelinelabs.conductor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bluelinelabs.conductor.ControllerTransaction.ControllerChangeType;

public class TestController extends Controller {

    @IdRes public static final int VIEW_ID = 2342;

    private static final String KEY_CALL_STATE = "TestController.currentCallState";

    public CallState currentCallState;

    public TestController() {
        currentCallState = new CallState();
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        currentCallState.createViewCalls++;
        View view = new FrameLayout(inflater.getContext());
        view.setId(VIEW_ID);
        return view;
    }

    @Override
    protected void onChangeStarted(@NonNull ControllerChangeHandler changeHandler, @NonNull ControllerChangeType changeType) {
        super.onChangeStarted(changeHandler, changeType);
        currentCallState.changeStartCalls++;
    }

    @Override
    protected void onChangeEnded(@NonNull ControllerChangeHandler changeHandler, @NonNull ControllerChangeType changeType) {
        super.onChangeEnded(changeHandler, changeType);
        currentCallState.changeEndCalls++;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        currentCallState.attachCalls++;
    }

    @Override
    protected void onDetach(@NonNull View view) {
        super.onDetach(view);
        currentCallState.detachCalls++;
    }

    @Override
    protected void onDestroyView(View view) {
        super.onDestroyView(view);
        currentCallState.destroyViewCalls++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        currentCallState.destroyCalls++;
    }

    @Override
    protected void onSaveViewState(@NonNull View view, @NonNull Bundle outState) {
        super.onSaveViewState(view, outState);
        currentCallState.saveViewStateCalls++;
    }

    @Override
    protected void onRestoreViewState(@NonNull View view, @NonNull Bundle savedViewState) {
        super.onRestoreViewState(view, savedViewState);
        currentCallState.restoreViewStateCalls++;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        currentCallState.saveInstanceStateCalls++;

        outState.putParcelable(KEY_CALL_STATE, currentCallState);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        currentCallState = savedInstanceState.getParcelable(KEY_CALL_STATE);

        currentCallState.restoreInstanceStateCalls++;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        currentCallState.onActivityResultCalls++;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        currentCallState.onRequestPermissionsResultCalls++;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        currentCallState.createOptionsMenuCalls++;
    }

}
