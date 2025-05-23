package vc0;

import android.annotation.TargetApi;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.g;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f441361a = HardCodeUtil.qqStr(R.string.f208205c3);

    /* renamed from: b, reason: collision with root package name */
    public static boolean f441362b = AppSetting.d().contains("r");

    /* renamed from: c, reason: collision with root package name */
    public static final String f441363c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f441364d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f441365e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f441366f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f441367g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f441368h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f441369i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f441370j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f441371k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f441372l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f441373m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f441374n;

    /* renamed from: o, reason: collision with root package name */
    public static final String f441375o;

    /* renamed from: p, reason: collision with root package name */
    public static final String f441376p;

    /* renamed from: q, reason: collision with root package name */
    public static final Boolean f441377q;

    static {
        String str = g.f185853a + "/qqstory/";
        f441363c = str;
        f441364d = str + "debug/";
        String str2 = str + "upload/";
        f441365e = str2;
        f441366f = str2 + ".music/";
        String str3 = str + ".tmp/";
        f441367g = str3;
        f441368h = str3 + "download/preload/";
        f441369i = str3 + "download/mine/";
        String str4 = str3 + ".tmp/";
        f441370j = str4;
        String str5 = str4 + "watermark/";
        f441371k = str5;
        f441372l = str4 + "merge/";
        f441373m = str4 + "audio/";
        f441374n = str4 + "video/";
        f441375o = str4 + "pk/result/";
        f441376p = str5 + "download/";
        f441377q = Boolean.TRUE;
    }
}
