package com.bluelinelabs.conductor.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

/**
 * An {@link AnimatorChangeHandler} that will cross fade two views
 */
public class FadeChangeHandler extends AnimatorChangeHandler {

    public FadeChangeHandler() { }

    public FadeChangeHandler(boolean removesFromViewOnPush) {
        super(removesFromViewOnPush);
    }

    public FadeChangeHandler(long duration) {
        super(duration);
    }

    public FadeChangeHandler(long duration, boolean removesFromViewOnPush) {
        super(duration, removesFromViewOnPush);
    }

    @Override
    protected Animator getAnimator(@NonNull ViewGroup container, View from, View to, boolean isPush, boolean toAddedToContainer) {
        AnimatorSet animator = new AnimatorSet();
        if (to != null && toAddedToContainer) {
            animator.play(ObjectAnimator.ofFloat(to, View.ALPHA, 0, 1));
        }

        if (from != null) {
            animator.play(ObjectAnimator.ofFloat(from, View.ALPHA, 0));
        }

        return animator;
    }

    @Override
    protected void resetFromView(@NonNull View from) {
        from.setAlpha(1);
    }
}
