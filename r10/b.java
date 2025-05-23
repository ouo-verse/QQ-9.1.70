package r10;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lr10/b;", "Landroid/support/v7/widget/RecyclerView$OnItemTouchListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "Landroid/view/MotionEvent;", "event", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "motionEvent", "", "onTouchEvent", "b", "onRequestDisallowInterceptTouchEvent", "a", "Z", "mScrolling", "", UserInfo.SEX_FEMALE, "touchDownX", "c", "touchDownY", "", "d", "I", "mTouchSlop", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements RecyclerView.OnItemTouchListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mScrolling;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float touchDownX;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float touchDownY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.touchDownX = event.getX();
            this.touchDownY = event.getY();
            this.mScrolling = false;
        } else if (action == 1) {
            this.mScrolling = false;
        } else if (action == 2) {
            this.mScrolling = Math.abs(this.touchDownX - event.getX()) >= ((float) this.mTouchSlop) || Math.abs(this.touchDownY - event.getY()) >= ((float) this.mTouchSlop);
        }
        return this.mScrolling;
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean b16) {
    }
}
