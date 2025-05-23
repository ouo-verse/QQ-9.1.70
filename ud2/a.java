package ud2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lud2/a;", "", "", "key", "feedId", "", "k", "", "l", "c", "a", "e", "f", "b", "d", h.F, "j", "g", "i", "Z", "enableFavTab", "enableGifEmoji", "Ljava/lang/String;", "disableFavTabText", "lastEmotionRedPointFeedId", "lastFavTabRedPointFeedId", "<init>", "()V", "qcircle-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f438849a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enableFavTab;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean enableGifEmoji;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String disableFavTabText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastEmotionRedPointFeedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastFavTabRedPointFeedId;

    static {
        a aVar = new a();
        f438849a = aVar;
        enableFavTab = true;
        enableGifEmoji = true;
        disableFavTabText = "\u90e8\u5206\u8868\u60c5\u6682\u4e0d\u652f\u6301\u4f7f\u7528";
        lastEmotionRedPointFeedId = "";
        lastFavTabRedPointFeedId = "";
        aVar.l();
    }

    a() {
    }

    private final boolean k(String key, String feedId) {
        boolean isBlank;
        if (c()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(feedId);
            if (isBlank) {
                return false;
            }
            int e16 = k.a().e(key, 3);
            if (e16 >= 0) {
                e16--;
                k.a().m(key, e16);
            }
            if (e16 < 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final void l() {
        boolean isBlank;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_input_bar_expression_config", "");
        isBlank = StringsKt__StringsJVMKt.isBlank(loadAsString);
        if (isBlank) {
            QLog.e("QFSEmojiFavExperiment", 1, "[parseCangLanConfig] no config");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            enableFavTab = jSONObject.optBoolean("enable_fav_tab", true);
            enableGifEmoji = jSONObject.optBoolean("enable_gif_expression", true);
            String optString = jSONObject.optString("fav_tab_guide_text", "\u90e8\u5206\u8868\u60c5\u6682\u4e0d\u652f\u6301\u4f7f\u7528");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"fav_tab_guide_text\", \"\u90e8\u5206\u8868\u60c5\u6682\u4e0d\u652f\u6301\u4f7f\u7528\")");
            disableFavTabText = optString;
        } catch (Exception e16) {
            QLog.e("QFSEmojiFavExperiment", 1, "[parseCangLanConfig] ", e16);
        }
    }

    public final boolean a() {
        return c();
    }

    public final boolean b() {
        int e16 = k.a().e("sp_key_comment_emotion_red_point_left_count", 3);
        if (c() && e16 >= 0) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        return enableFavTab;
    }

    public final boolean d() {
        int e16 = k.a().e("sp_key_comment_fav_tab_red_point_left_count", 3);
        if (c() && e16 >= 0) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (c() && enableGifEmoji) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        return disableFavTabText;
    }

    public final void g() {
        k.a().m("sp_key_comment_emotion_red_point_left_count", -1);
    }

    public final boolean h(@NotNull String feedId) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        isBlank = StringsKt__StringsJVMKt.isBlank(lastEmotionRedPointFeedId);
        if ((!isBlank) && Intrinsics.areEqual(lastEmotionRedPointFeedId, feedId)) {
            return true;
        }
        lastEmotionRedPointFeedId = feedId;
        return k("sp_key_comment_emotion_red_point_left_count", feedId);
    }

    public final void i() {
        k.a().m("sp_key_comment_fav_tab_red_point_left_count", -1);
        k.a().m("sp_key_comment_emotion_red_point_left_count", -1);
    }

    public final boolean j(@NotNull String feedId) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        isBlank = StringsKt__StringsJVMKt.isBlank(lastFavTabRedPointFeedId);
        if ((!isBlank) && Intrinsics.areEqual(lastFavTabRedPointFeedId, feedId)) {
            return true;
        }
        lastFavTabRedPointFeedId = feedId;
        return k("sp_key_comment_fav_tab_red_point_left_count", feedId);
    }
}
