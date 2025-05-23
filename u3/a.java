package u3;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import java.util.LinkedList;
import q3.b;
import q3.e;
import r3.j;
import t3.d;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements b, r3.a, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: d, reason: collision with root package name */
    protected View f438169d;

    /* renamed from: e, reason: collision with root package name */
    protected View f438170e;

    /* renamed from: f, reason: collision with root package name */
    protected View f438171f;

    /* renamed from: h, reason: collision with root package name */
    protected View f438172h;

    /* renamed from: i, reason: collision with root package name */
    protected View f438173i;

    /* renamed from: m, reason: collision with root package name */
    protected int f438174m = 0;
    protected boolean C = true;
    protected boolean D = true;
    protected s3.a E = new s3.a();

    public a(@NonNull View view) {
        this.f438171f = view;
        this.f438170e = view;
        this.f438169d = view;
    }

    @Override // q3.b
    public void a(e eVar, View view, View view2) {
        d(this.f438169d, eVar);
        if (view != null || view2 != null) {
            this.f438172h = view;
            this.f438173i = view2;
            FrameLayout frameLayout = new FrameLayout(this.f438169d.getContext());
            int indexOfChild = eVar.getRefreshLayout().getLayout().indexOfChild(this.f438169d);
            eVar.getRefreshLayout().getLayout().removeView(this.f438169d);
            frameLayout.addView(this.f438169d, 0, new ViewGroup.LayoutParams(-1, -1));
            eVar.getRefreshLayout().getLayout().addView(frameLayout, indexOfChild, this.f438169d.getLayoutParams());
            this.f438169d = frameLayout;
            if (view != null) {
                view.setTag(R.id.f87754v8, "fixed-top");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild2 = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams.height = d.h(view);
                viewGroup.addView(new Space(this.f438169d.getContext()), indexOfChild2, layoutParams);
                frameLayout.addView(view, 1, layoutParams);
            }
            if (view2 != null) {
                view2.setTag(R.id.f87754v8, "fixed-bottom");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild3 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                layoutParams2.height = d.h(view2);
                viewGroup2.addView(new Space(this.f438169d.getContext()), indexOfChild3, layoutParams2);
                layoutParams3.gravity = 80;
                frameLayout.addView(view2, 1, layoutParams3);
            }
        }
    }

    @Override // q3.b
    public void b(j jVar) {
        if (jVar instanceof s3.a) {
            this.E = (s3.a) jVar;
        } else {
            this.E.f433151b = jVar;
        }
    }

    @Override // r3.a
    public void c(boolean z16, boolean z17) {
        this.C = z16;
        this.D = z17;
    }

    @Override // q3.b
    public boolean canLoadMore() {
        if (this.D && this.E.canLoadMore(this.f438169d)) {
            return true;
        }
        return false;
    }

    @Override // q3.b
    public boolean canRefresh() {
        if (this.C && this.E.canRefresh(this.f438169d)) {
            return true;
        }
        return false;
    }

    protected void d(View view, e eVar) {
        boolean z16;
        boolean isInEditMode = this.f438169d.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            if (view2 == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            view = f(view, z16);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                t3.b.a(view, eVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f438171f = view2;
        }
    }

    protected View e(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (d.g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ((childAt instanceof ViewPager) || !d.e(childAt)) {
                        pointF.offset(pointF2.x, pointF2.y);
                        View e16 = e(childAt, pointF, view2);
                        pointF.offset(-pointF2.x, -pointF2.y);
                        return e16;
                    }
                    return childAt;
                }
            }
        }
        return view2;
    }

    protected View f(View view, boolean z16) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z16 || view3 != view) && d.e(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        linkedList.add(viewGroup.getChildAt(i3));
                    }
                }
            }
        }
        if (view2 != null) {
            return view2;
        }
        return view;
    }

    @Override // q3.b
    @NonNull
    public View getScrollableView() {
        return this.f438171f;
    }

    @Override // q3.b
    @NonNull
    public View getView() {
        return this.f438169d;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    @Override // q3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void moveSpinner(int i3, int i16, int i17) {
        boolean z16;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        boolean z17 = true;
        if (i16 != -1 && (findViewById2 = this.f438170e.findViewById(i16)) != null) {
            if (i3 > 0) {
                findViewById2.setTranslationY(i3);
                z16 = true;
                if (i17 != -1 && (findViewById = this.f438170e.findViewById(i17)) != null) {
                    if (i3 >= 0) {
                        findViewById.setTranslationY(i3);
                        if (!z17) {
                            this.f438170e.setTranslationY(i3);
                        } else {
                            this.f438170e.setTranslationY(0.0f);
                        }
                        view = this.f438172h;
                        if (view != null) {
                            view.setTranslationY(Math.max(0, i3));
                        }
                        view2 = this.f438173i;
                        if (view2 != null) {
                            view2.setTranslationY(Math.min(0, i3));
                            return;
                        }
                        return;
                    }
                    if (findViewById.getTranslationY() < 0.0f) {
                        findViewById.setTranslationY(0.0f);
                    }
                }
                z17 = z16;
                if (!z17) {
                }
                view = this.f438172h;
                if (view != null) {
                }
                view2 = this.f438173i;
                if (view2 != null) {
                }
            } else if (findViewById2.getTranslationY() > 0.0f) {
                findViewById2.setTranslationY(0.0f);
            }
        }
        z16 = false;
        if (i17 != -1) {
            if (i3 >= 0) {
            }
        }
        z17 = z16;
        if (!z17) {
        }
        view = this.f438172h;
        if (view != null) {
        }
        view2 = this.f438173i;
        if (view2 != null) {
        }
    }

    @Override // q3.b
    public void onActionDown(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f438169d.getLeft(), -this.f438169d.getTop());
        View view = this.f438171f;
        View view2 = this.f438169d;
        if (view != view2) {
            this.f438171f = e(view2, pointF, view);
        }
        if (this.f438171f == this.f438169d) {
            this.E.f433150a = null;
        } else {
            this.E.f433150a = pointF;
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.f438174m) * this.f438171f.getScaleY();
            View view = this.f438171f;
            if (view instanceof AbsListView) {
                d.j((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.f438174m = intValue;
    }

    @Override // q3.b
    public ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished(int i3) {
        View view = this.f438171f;
        if (view != null && i3 != 0) {
            if ((i3 < 0 && view.canScrollVertically(1)) || (i3 > 0 && this.f438171f.canScrollVertically(-1))) {
                this.f438174m = i3;
                return this;
            }
            return null;
        }
        return null;
    }

    @Override // q3.b
    public void setEnableLoadMoreWhenContentNotFull(boolean z16) {
        this.E.f433152c = z16;
    }
}
