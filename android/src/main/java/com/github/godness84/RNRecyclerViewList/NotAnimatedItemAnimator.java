package com.github.godness84.RNRecyclerViewList;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

/**
 * Implementation of {@link SimpleItemAnimator} that disables all default animations.
 */
/*package*/ class NotAnimatedItemAnimator extends SimpleItemAnimator {

  @Override
  public void runPendingAnimations() {
    // nothing
  }

  @Override
  public boolean animateRemove(RecyclerView.ViewHolder holder) {
    dispatchRemoveStarting(holder);
    dispatchRemoveFinished(holder);
    return true;
  }

  @Override
  public boolean animateAdd(RecyclerView.ViewHolder holder) {
    dispatchAddStarting(holder);
    dispatchAddFinished(holder);
    return true;
  }

  @Override
  public boolean animateMove(
      RecyclerView.ViewHolder holder,
      int fromX,
      int fromY,
      int toX,
      int toY) {
    dispatchMoveStarting(holder);
    dispatchMoveFinished(holder);
    return true;
  }

  @Override
  public boolean animateChange(
      RecyclerView.ViewHolder oldHolder,
      RecyclerView.ViewHolder newHolder,
      int fromLeft,
      int fromTop,
      int toLeft,
      int toTop) {
    dispatchChangeStarting(oldHolder, true);
    dispatchChangeFinished(oldHolder, true);

    // TODO: capire perchè a volte diventa NULL
    if (newHolder != null) {
      dispatchChangeStarting(newHolder, false);
      dispatchChangeFinished(newHolder, false);
    }
    return true;
  }

  @Override
  public void endAnimation(RecyclerView.ViewHolder item) {
  }

  @Override
  public void endAnimations() {
  }

  @Override
  public boolean isRunning() {
    return false;
  }
}
