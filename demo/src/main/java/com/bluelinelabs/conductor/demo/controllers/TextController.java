package com.bluelinelabs.conductor.demo.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.demo.util.BundleBuilder;
import com.bluelinelabs.conductor.demo.R;
import com.bluelinelabs.conductor.demo.controllers.base.BaseController;

import butterknife.Bind;

public class TextController extends BaseController {

    private static final String KEY_TEXT = "TextController.text";

    @Bind(R.id.text_view) TextView mTextView;

    public TextController(String text) {
        this(new BundleBuilder(new Bundle())
                .putString(KEY_TEXT, text)
                .build()
        );
    }

    public TextController(Bundle args) {
        super(args);
    }

    @NonNull
    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_text, container, false);
    }

    @Override
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        mTextView.setText(getArgs().getString(KEY_TEXT));
    }

}
