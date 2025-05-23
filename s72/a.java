package s72;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Ls72/a;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "b", "desc", "c", "background", com.tencent.mobileqq.msf.core.net.r.a.f248963o, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String desc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String background;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String foreground;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Ls72/a$a;", "", "Ls72/a;", "a", "", "DEFAULT_BACKGROUND", "Ljava/lang/String;", "DEFAULT_DESC", "DEFAULT_FOREGROUND", "DEFAULT_TITLE", "ENTRY_CONFIG_ID", "KEY_BACKGROUND", "KEY_DESC", "KEY_FOREGROUND", "KEY_TITLE", "TAG", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s72.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            try {
                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105950", "{}");
                QLog.i("QQStrangerNearbyEntryConfig", 1, "config: " + loadAsString);
                JSONObject jSONObject = new JSONObject(loadAsString);
                String title = jSONObject.optString("title", "\u9644\u8fd1");
                String desc = jSONObject.optString("description", "\u53d1\u73b0\u9644\u8fd1\u65b0\u9c9c\u4e8b");
                String background = jSONObject.optString("background", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_B579SpbT2hd.png");
                String foreground = jSONObject.optString(com.tencent.mobileqq.msf.core.net.r.a.f248963o, "");
                Intrinsics.checkNotNullExpressionValue(title, "title");
                Intrinsics.checkNotNullExpressionValue(desc, "desc");
                Intrinsics.checkNotNullExpressionValue(background, "background");
                Intrinsics.checkNotNullExpressionValue(foreground, "foreground");
                return new a(title, desc, background, foreground);
            } catch (Throwable th5) {
                QLog.e("QQStrangerNearbyEntryConfig", 1, "load config error: " + th5);
                return new a("\u9644\u8fd1", "\u53d1\u73b0\u9644\u8fd1\u65b0\u9c9c\u4e8b", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_B579SpbT2hd.png", "");
            }
        }

        Companion() {
        }
    }

    public a(String title, String desc, String background, String foreground) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(foreground, "foreground");
        this.title = title;
        this.desc = desc;
        this.background = background;
        this.foreground = foreground;
    }

    /* renamed from: a, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: c, reason: from getter */
    public final String getForeground() {
        return this.foreground;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
