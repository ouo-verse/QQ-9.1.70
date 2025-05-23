package r40;

import android.text.TextUtils;
import com.tencent.avbiz.Constants;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f430715a;

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f430716b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashSet<String> f430717c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashSet<String> f430718d;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f430715a = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        f430716b = hashSet2;
        HashSet<String> hashSet3 = new HashSet<>();
        f430717c = hashSet3;
        HashSet<String> hashSet4 = new HashSet<>();
        f430718d = hashSet4;
        hashSet.add(Constants.Business.SYSTEM_PHONE);
        hashSet2.add(Constants.Business.QQ_RTC);
        hashSet2.add(Constants.Business.QQ_GUILD);
        hashSet2.add(Constants.Business.MATCH_FRIEND);
        hashSet4.add(Constants.Business.LISTEN_TOGETHER);
        hashSet4.add(Constants.Business.QQ_GUILD_KARAOKE);
        hashSet3.add("QQ\u76f4\u64ad");
        hashSet3.add(Constants.Business.QQCIRCLE);
        hashSet3.add(Constants.Business.QQ_GUILD_LIVE_AUTHOR);
        hashSet3.add(Constants.Business.QQ_GUILD_LIVE_VIEWER);
        hashSet3.add(Constants.Business.QQ_LAYER);
        hashSet3.add(Constants.Business.QQ_CIRCLE_WINDOW);
    }

    public static int a(String str) {
        if (!f430716b.contains(str) && !f430715a.contains(str)) {
            return 8888;
        }
        return 101;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        if (f430717c.contains(str)) {
            return 0;
        }
        if (!f430718d.contains(str)) {
            return 3;
        }
        return 1;
    }
}
