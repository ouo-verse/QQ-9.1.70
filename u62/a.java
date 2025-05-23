package u62;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.wxa.rf.d;
import com.tencent.luggage.wxa.se.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.view.FilterEnum;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    public static String A;

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f438472a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f438473b;

    /* renamed from: c, reason: collision with root package name */
    public static String f438474c;

    /* renamed from: d, reason: collision with root package name */
    public static String f438475d;

    /* renamed from: e, reason: collision with root package name */
    public static String f438476e;

    /* renamed from: f, reason: collision with root package name */
    public static String f438477f;

    /* renamed from: g, reason: collision with root package name */
    public static String f438478g;

    /* renamed from: h, reason: collision with root package name */
    public static String f438479h;

    /* renamed from: i, reason: collision with root package name */
    public static String f438480i;

    /* renamed from: j, reason: collision with root package name */
    public static String f438481j;

    /* renamed from: k, reason: collision with root package name */
    public static String f438482k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f438483l;

    /* renamed from: m, reason: collision with root package name */
    public static String f438484m;

    /* renamed from: n, reason: collision with root package name */
    public static String f438485n;

    /* renamed from: o, reason: collision with root package name */
    public static String f438486o;

    /* renamed from: p, reason: collision with root package name */
    public static String f438487p;

    /* renamed from: q, reason: collision with root package name */
    public static String f438488q;

    /* renamed from: r, reason: collision with root package name */
    public static int f438489r;

    /* renamed from: s, reason: collision with root package name */
    public static int f438490s;

    /* renamed from: t, reason: collision with root package name */
    public static int f438491t;

    /* renamed from: u, reason: collision with root package name */
    public static int f438492u;

    /* renamed from: v, reason: collision with root package name */
    public static final Pair<Integer, Integer>[] f438493v;

    /* renamed from: w, reason: collision with root package name */
    public static final Pair<Integer, Integer>[] f438494w;

    /* renamed from: x, reason: collision with root package name */
    public static final Pair<Integer, Integer>[] f438495x;

    /* renamed from: y, reason: collision with root package name */
    public static final Pair<Integer, Integer>[] f438496y;

    /* renamed from: z, reason: collision with root package name */
    public static String f438497z;

    static {
        char[] cArr = {Typography.ellipsis};
        f438472a = cArr;
        f438473b = new String(cArr);
        f438474c = "https://kandian.qq.com/mqq/html/homepage.html?_wv=16778243&_bid=2378&uin=";
        f438475d = "https://kandian.qq.com/mqq/html/messagebox3.html?_wv=3&_bid=2378&x5PreFetch=1&adtag=1&privateLetters=";
        f438476e = "https://kandian.qq.com/mqq/vue/comment?_wv=3&_bid=2378&x5PreFetch=1&feedstype=&uin=&feeds_id=";
        f438477f = "https://kandian.qq.com/mqq/html/recommend_friends.html?_wv=3&_bid=2378&x5PreFetch=1&feeds_id=";
        f438478g = "https://kandian.qq.com/mqq/vue/main?_wv=10145&_bid=3302&adfrom=qqshare&x5PreFetch=1&accountId=";
        f438479h = "https://kandian.qq.com/mqq/html/messagebox3.html?_wv=3&_bid=2378&x5PreFetch=1&adtag=2&privateLetters=";
        f438480i = "https://kandian.qq.com/mqq/html/allfrdbiu.html?_wv=3&_bid=2378&x5PreFetch=1";
        f438481j = "https://kandian.qq.com/mqq/vue/wendafeeds?_wv=67&_bid=2378&source=1";
        f438482k = "https://kandian.qq.com/mqq/vue/main?_wv=10145&_bid=3302&adfrom=qqshare&x5PreFetch=1&accountId=";
        f438483l = false;
        f438484m = "https://kandian.qq.com/mqq/html/feedback.html?_wv=3&_bid=2378&x5PreFetch=1";
        f438485n = "https://post.mp.qq.com/mkandian/history";
        f438486o = "https://post.mp.qq.com/mkandian/topic?_wv=3";
        f438487p = "https://kandian.qq.com/mqq/html/collectBox.html?_wv=3&_bid=2378&x5PreFetch=1";
        f438488q = "https://post.mp.qq.com/mkandian/notify?_wv=3";
        f438489r = 819200;
        f438490s = 3000;
        f438491t = 500;
        f438492u = 200;
        Integer valueOf = Integer.valueOf(FilterEnum.MIC_PTU_TRANS_XINXIAN);
        f438493v = new Pair[]{new Pair<>(159, 95), new Pair<>(179, 95), new Pair<>(158, 143), new Pair<>(178, 143), new Pair<>(238, 143), new Pair<>(Integer.valueOf(d.CTRL_INDEX), 143), new Pair<>(119, 95), new Pair<>(239, 95), new Pair<>(79, 95), new Pair<>(59, 95), new Pair<>(89, 95), new Pair<>(valueOf, valueOf)};
        f438494w = new Pair[]{new Pair<>(160, 90), new Pair<>(valueOf, valueOf), new Pair<>(30, 40), new Pair<>(90, 160), new Pair<>(440, 246)};
        Integer valueOf2 = Integer.valueOf(b.CTRL_INDEX);
        f438495x = new Pair[]{new Pair<>(159, 95), new Pair<>(179, 95), new Pair<>(158, 143), new Pair<>(178, 143), new Pair<>(238, 143), new Pair<>(Integer.valueOf(d.CTRL_INDEX), 143), new Pair<>(119, 95), new Pair<>(239, 95), new Pair<>(79, 95), new Pair<>(59, 95), new Pair<>(89, 95), new Pair<>(valueOf, valueOf), new Pair<>(valueOf2, 224), new Pair<>(valueOf2, 272), new Pair<>(valueOf2, Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST)), new Pair<>(valueOf2, 424)};
        f438496y = new Pair[]{new Pair<>(160, 90), new Pair<>(valueOf, valueOf), new Pair<>(30, 40), new Pair<>(90, 160), new Pair<>(440, 246), new Pair<>(valueOf2, 224), new Pair<>(valueOf2, 272), new Pair<>(valueOf2, Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST)), new Pair<>(valueOf2, 424)};
        f438497z = "https://post.mp.qq.com/mkandian/follow?_wv=7";
        A = "https://post.mp.qq.com/mkandian/fan?_wv=7";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer>[] a(String str, int i3) {
        boolean equals;
        if (!TextUtils.isEmpty(str)) {
            try {
                equals = TextUtils.equals(Uri.parse(str).getQueryParameter("new_crop_size"), "1");
            } catch (Exception e16) {
                QLog.e("ReadInJoyConstants", 1, "[getImageScales] e = " + e16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ReadInJoyConstants", 1, "[getImageScales] url = " + str + ", useNewCropSize = " + equals);
            }
            if (i3 != 0) {
                if (equals) {
                    return f438495x;
                }
                return f438493v;
            }
            if (equals) {
                return f438496y;
            }
            return f438494w;
        }
        equals = false;
        if (QLog.isColorLevel()) {
        }
        if (i3 != 0) {
        }
    }
}
