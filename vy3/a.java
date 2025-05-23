package vy3;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Set<Integer> f443732a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f443733b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f443734c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f443735d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f443736e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f443737f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f443738g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f443739h = false;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f443740i = true;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f443741j = false;

    /* renamed from: k, reason: collision with root package name */
    public static int f443742k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static long f443743l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static long f443744m = 0;

    /* renamed from: n, reason: collision with root package name */
    public static long f443745n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static long f443746o = 0;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f443747p = false;

    /* renamed from: q, reason: collision with root package name */
    public static long f443748q = -1;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f443749r = false;

    /* renamed from: s, reason: collision with root package name */
    public static Set<Integer> f443750s = new HashSet();

    public static SharedPreferences a() {
        return BaseApplication.getContext().getSharedPreferences(DeviceInfoUtil.PERF_CONFIG_FILE, 4);
    }
}
