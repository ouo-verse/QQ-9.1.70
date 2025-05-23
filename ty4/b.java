package ty4;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<Class<?>> f437918a = new SparseArray<>();

    private static Class a(int i3, String str, Context context) {
        SparseArray<Class<?>> sparseArray = f437918a;
        Class<?> cls = sparseArray.get(i3);
        if (cls != null) {
            return cls;
        }
        try {
            String str2 = "com.tx.x2j." + d.a(str) + "Binding";
            d.b("getBindingClass layoutName=" + str + "\uff0c clzName=" + str2);
            Class<?> loadClass = context.getClassLoader().loadClass(str2);
            sparseArray.put(i3, loadClass);
            return loadClass;
        } catch (Exception e16) {
            d.d("getBindingClass", e16);
            return null;
        }
    }

    private static View b(LayoutInflater layoutInflater, Context context, int i3, String str, ViewGroup viewGroup, boolean z16) {
        return c(layoutInflater, context, i3, str, viewGroup, z16);
    }

    private static View c(LayoutInflater layoutInflater, Context context, int i3, String str, ViewGroup viewGroup, boolean z16) {
        Class a16 = a(i3, str, context);
        if (a16 == null) {
            return i(layoutInflater, context, i3, viewGroup, z16);
        }
        try {
            View s16 = ((c) a16.newInstance()).s(context, viewGroup, z16);
            if (s16 != null) {
                return s16;
            }
            d.c("getViewInner view == null layoutId=" + i3);
            return i(layoutInflater, context, i3, viewGroup, z16);
        } catch (Exception unused) {
            return i(layoutInflater, context, i3, viewGroup, z16);
        }
    }

    public static View d(int i3, Context context, ViewGroup viewGroup, boolean z16, c cVar) {
        try {
            View s16 = cVar.s(context, viewGroup, z16);
            if (s16 != null) {
                return s16;
            }
            d.c("inflate view == null layoutId=" + i3);
            return LayoutInflater.from(context).inflate(i3, viewGroup, z16);
        } catch (Exception e16) {
            d.d("inflateViewInner", e16);
            return LayoutInflater.from(context).inflate(i3, viewGroup, z16);
        }
    }

    public static View e(Context context, int i3, String str, ViewGroup viewGroup) {
        boolean z16;
        if (viewGroup != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return f(context, i3, str, viewGroup, z16);
    }

    public static View f(Context context, int i3, String str, ViewGroup viewGroup, boolean z16) {
        return b(null, context, i3, str, viewGroup, z16);
    }

    public static View g(LayoutInflater layoutInflater, int i3, String str, ViewGroup viewGroup) {
        boolean z16;
        if (viewGroup != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return h(layoutInflater, i3, str, viewGroup, z16);
    }

    public static View h(LayoutInflater layoutInflater, int i3, String str, ViewGroup viewGroup, boolean z16) {
        return b(layoutInflater, layoutInflater.getContext(), i3, str, viewGroup, z16);
    }

    private static View i(LayoutInflater layoutInflater, Context context, int i3, ViewGroup viewGroup, boolean z16) {
        if (layoutInflater == null) {
            d.c("inflateView \u56de\u9000\u5230\u7cfb\u7edfInflate\u65b9\u5f0f, inflater == null");
            return LayoutInflater.from(context).inflate(i3, viewGroup, z16);
        }
        d.c("inflateView \u56de\u9000\u5230\u7cfb\u7edfInflate\u65b9\u5f0f");
        return layoutInflater.inflate(i3, viewGroup, z16);
    }
}
