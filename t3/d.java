package t3;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements Interpolator {

    /* renamed from: b, reason: collision with root package name */
    public static int f435348b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f435349c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static float f435350d = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: e, reason: collision with root package name */
    private static final float f435351e;

    /* renamed from: f, reason: collision with root package name */
    private static final float f435352f;

    /* renamed from: a, reason: collision with root package name */
    private int f435353a;

    static {
        float k3 = 1.0f / k(1.0f);
        f435351e = k3;
        f435352f = 1.0f - (k3 * k(1.0f));
    }

    public d(int i3) {
        this.f435353a = i3;
    }

    public static boolean a(@NonNull View view, PointF pointF, boolean z16) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !f(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.f87754v8);
                    if (QCircleDaTongConstant.ElementParamValue.FIXED.equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a16 = a(childAt, pointF, z16);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a16;
                }
            }
        }
        if (z16 || view.canScrollVertically(-1)) {
            return true;
        }
        return false;
    }

    public static boolean b(@NonNull View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.f87754v8);
                    if (QCircleDaTongConstant.ElementParamValue.FIXED.equals(tag) || "fixed-bottom".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean b16 = b(childAt, pointF);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return b16;
                }
            }
            return true;
        }
        return true;
    }

    public static int c(float f16) {
        return (int) ((f16 * f435350d) + 0.5f);
    }

    public static void d(View view, int i3) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i3);
            return;
        }
        if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i3);
            return;
        }
        if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i3);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i3);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i3);
        }
    }

    public static boolean e(View view) {
        if (view instanceof q3.a) {
            return false;
        }
        if (!f(view) && !(view instanceof ViewPager) && !(view instanceof NestedScrollingParent)) {
            return false;
        }
        return true;
    }

    public static boolean f(View view) {
        if (view instanceof q3.a) {
            return false;
        }
        if (!(view instanceof AbsListView) && !(view instanceof ScrollView) && !(view instanceof ScrollingView) && !(view instanceof WebView) && !(view instanceof NestedScrollingChild)) {
            return false;
        }
        return true;
    }

    public static boolean g(@NonNull View view, @NonNull View view2, float f16, float f17, PointF pointF) {
        boolean z16;
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f16, f17};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f16;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f18 = fArr[0];
        if (f18 >= 0.0f && scrollY >= 0.0f && f18 < view2.getWidth() && fArr[1] < view2.getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && pointF != null) {
            pointF.set(fArr[0] - f16, fArr[1] - f17);
        }
        return z16;
    }

    public static int h(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    public static float i(int i3) {
        return i3 / f435350d;
    }

    public static void j(@NonNull AbsListView absListView, int i3) {
        absListView.scrollListBy(i3);
    }

    private static float k(float f16) {
        float f17 = f16 * 8.0f;
        if (f17 < 1.0f) {
            return f17 - (1.0f - ((float) Math.exp(-f17)));
        }
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (this.f435353a == f435349c) {
            float f17 = 1.0f - f16;
            return 1.0f - (f17 * f17);
        }
        float k3 = f435351e * k(f16);
        if (k3 > 0.0f) {
            return k3 + f435352f;
        }
        return k3;
    }
}
