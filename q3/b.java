package q3;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import r3.j;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface b {
    void a(e eVar, View view, View view2);

    void b(j jVar);

    boolean canLoadMore();

    boolean canRefresh();

    @NonNull
    View getScrollableView();

    @NonNull
    View getView();

    void moveSpinner(int i3, int i16, int i17);

    void onActionDown(MotionEvent motionEvent);

    ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished(int i3);

    void setEnableLoadMoreWhenContentNotFull(boolean z16);
}
