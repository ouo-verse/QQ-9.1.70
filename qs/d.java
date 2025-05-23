package qs;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f429427e = {-1, -2148308, -1009097, -8136876, -13338378};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f429428f = {-16777216, -1, -2148308, -1009097, -8136876, -13338378};

    /* renamed from: a, reason: collision with root package name */
    public int f429429a;

    /* renamed from: b, reason: collision with root package name */
    public int f429430b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f429431c;

    /* renamed from: d, reason: collision with root package name */
    public String f429432d;

    public d(Drawable drawable, int i3, int i16) {
        this.f429431c = drawable;
        this.f429429a = i3;
        this.f429430b = i16;
        if (i3 == 0) {
            this.f429432d = a(i16);
        }
    }

    public static String a(int i3) {
        switch (i3) {
            case -16777216:
                return HardCodeUtil.qqStr(R.string.ksk);
            case -13338378:
            case -9576193:
                return HardCodeUtil.qqStr(R.string.ksi);
            case -10233288:
            case -8136876:
                return HardCodeUtil.qqStr(R.string.ksh);
            case -6989057:
                return HardCodeUtil.qqStr(R.string.ksd);
            case -5789785:
                return HardCodeUtil.qqStr(R.string.ksc);
            case -2148308:
            case -845543:
                return HardCodeUtil.qqStr(R.string.ksg);
            case -1009097:
            case -27392:
                return HardCodeUtil.qqStr(R.string.ksj);
            case -274353:
                return HardCodeUtil.qqStr(R.string.ksb);
            case -1:
                return HardCodeUtil.qqStr(R.string.kse);
            default:
                return "";
        }
    }

    public static int b(boolean z16) {
        if (z16) {
            return f429428f[2];
        }
        return f429427e[1];
    }
}
