package ty4;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class c {
    private View j(Context context, ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return o(context, (RelativeLayout) viewGroup);
        }
        if (viewGroup instanceof RecyclerView) {
            return q(context, (RecyclerView) viewGroup);
        }
        if (viewGroup instanceof RadioGroup) {
            return n(context, (RadioGroup) viewGroup);
        }
        if (viewGroup instanceof LinearLayout) {
            return m(context, (LinearLayout) viewGroup);
        }
        if (viewGroup instanceof AbsListView) {
            return k(context, (AbsListView) viewGroup);
        }
        if (viewGroup instanceof ConstraintLayout) {
            return p(context, (ConstraintLayout) viewGroup);
        }
        if (viewGroup instanceof FrameLayout) {
            return l(context, (FrameLayout) viewGroup);
        }
        return null;
    }

    protected View i(Context context) {
        return null;
    }

    protected View k(Context context, AbsListView absListView) {
        return null;
    }

    protected View l(Context context, FrameLayout frameLayout) {
        return null;
    }

    protected View m(Context context, LinearLayout linearLayout) {
        return null;
    }

    protected View n(Context context, RadioGroup radioGroup) {
        return null;
    }

    protected View o(Context context, RelativeLayout relativeLayout) {
        return null;
    }

    protected View p(Context context, ConstraintLayout constraintLayout) {
        return null;
    }

    protected View q(Context context, RecyclerView recyclerView) {
        return null;
    }

    public ViewGroup.LayoutParams r(Context context, ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        for (Class<?> cls = viewGroup.getClass(); cls != null; cls = cls.getSuperclass()) {
            String name = cls.getName();
            if ("android.widget.RelativeLayout".equals(name)) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                f(context, resources, displayMetrics, layoutParams);
                return layoutParams;
            }
            if ("androidx.recyclerview.widget.RecyclerView".equals(name)) {
                RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(-2, -2);
                h(context, resources, displayMetrics, layoutParams2);
                return layoutParams2;
            }
            if ("android.view.ViewGroup".equals(name)) {
                ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                a(context, resources, displayMetrics, layoutParams3);
                return layoutParams3;
            }
            if ("android.widget.RadioGroup".equals(name)) {
                RadioGroup.LayoutParams layoutParams4 = new RadioGroup.LayoutParams(-2, -2);
                e(context, resources, displayMetrics, layoutParams4);
                return layoutParams4;
            }
            if ("android.widget.LinearLayout".equals(name)) {
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                d(context, resources, displayMetrics, layoutParams5);
                return layoutParams5;
            }
            if ("android.widget.AbsListView".equals(name)) {
                AbsListView.LayoutParams layoutParams6 = new AbsListView.LayoutParams(-2, -2);
                b(context, resources, displayMetrics, layoutParams6);
                return layoutParams6;
            }
            if ("androidx.constraintlayout.widget.ConstraintLayout".equals(name)) {
                ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
                g(context, resources, displayMetrics, layoutParams7);
                return layoutParams7;
            }
            if ("android.widget.FrameLayout".equals(name)) {
                FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -2);
                c(context, resources, displayMetrics, layoutParams8);
                return layoutParams8;
            }
        }
        d.c("X2JBaseBinding.getLayoutParams, error parent : " + viewGroup);
        return null;
    }

    public View s(Context context, ViewGroup viewGroup, boolean z16) {
        boolean z17;
        try {
            View j3 = j(context, viewGroup);
            if (j3 == null) {
                j3 = i(context);
                z17 = false;
            } else {
                z17 = true;
            }
            if (viewGroup != null && !z17) {
                ViewGroup.LayoutParams r16 = r(context, viewGroup);
                if (r16 == null) {
                    return j3;
                }
                if (z16) {
                    viewGroup.addView(j3, r16);
                    return viewGroup;
                }
                j3.setLayoutParams(r16);
            }
            return j3;
        } catch (Exception e16) {
            d.d("X2JBaseBinding.inflate", e16);
            return null;
        }
    }

    public View t(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        return s(layoutInflater.getContext(), viewGroup, z16);
    }

    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
    }

    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
    }

    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
    }

    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
    }

    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
    }

    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
    }

    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
    }

    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
    }
}
