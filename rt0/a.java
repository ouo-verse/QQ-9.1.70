package rt0;

import android.os.Looper;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lrt0/a;", "", "a", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Set<String> f432183b;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0015\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0003J\b\u0010\u0007\u001a\u00020\u0002H\u0003J\b\u0010\b\u001a\u00020\u0002H\u0003J\b\u0010\t\u001a\u00020\u0002H\u0003J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\f\u001a\u00020\u0002H\u0003J\b\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u000f\u001a\u00020\rH\u0007J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0007J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0007J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J \u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001cR\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0014\u0010#\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001cR\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001cR\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u001cR\u0014\u0010'\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u001cR\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u001cR\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u001cR\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u001cR\u0014\u0010+\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u001cR\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u001cR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00062"}, d2 = {"Lrt0/a$a;", "", "", "tag", "d", "info", "c", "b", "o", "p", "", "e", DomainData.DOMAIN_NAME, "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "action", "f", "g", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, h.F, "", "th", "i", "a", "AUDIENCE", "Ljava/lang/String;", "CHAT_MESSAGE", "ENTER_ROOM", "GIFT", "ICGAME", "ICGAME_AUDIENCE_VIEW", "ICGAME_ROOM_DISPLAY_VIEW", "LOGIN", "OPEN_LIVE", "PENDANT", "PK_BIZ", "PUSH", "ROOM_INFO", "SHARE", "TAG_SPLITTER", "UNKNOWN", "VSREQUEST", "", "modulesSet", "Ljava/util/Set;", "<init>", "()V", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rt0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final String b() {
            return "[" + o() + "|" + p() + "|" + n() + "]";
        }

        @JvmStatic
        private final String c(String info) {
            return b() + info;
        }

        @JvmStatic
        private final String d(String tag) {
            return "ICGame|" + tag;
        }

        @JvmStatic
        private final void e(String tag) {
            boolean contains$default;
            List split$default;
            if (QLog.isDevelopLevel()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) tag, (CharSequence) "|", false, 2, (Object) null);
                if (contains$default) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) tag, new String[]{"|"}, false, 0, 6, (Object) null);
                    tag = (String) split$default.get(0);
                }
                if (a.f432183b.contains(tag)) {
                    return;
                }
                throw new IllegalArgumentException(tag + " not in modules");
            }
        }

        @JvmStatic
        private final String n() {
            if (!AppNetConnInfo.isNetSupport()) {
                return "none";
            }
            if (AppNetConnInfo.isWifiConn()) {
                return "wifi";
            }
            if (!AppNetConnInfo.isMobileConn()) {
                return "none";
            }
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            if (mobileInfo != 0 && mobileInfo != 1) {
                if (mobileInfo != 2) {
                    if (mobileInfo != 3) {
                        if (mobileInfo != 4) {
                            return "none";
                        }
                        return "5G";
                    }
                    return "4G";
                }
                return "3G";
            }
            return "2G";
        }

        @JvmStatic
        private final String o() {
            int i3 = MobileQQ.sProcessId;
            if (i3 == 1) {
                return "MobileQQ";
            }
            if (i3 == 7) {
                return "tool";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            return sb5.toString();
        }

        @JvmStatic
        private final String p() {
            if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                String name = Thread.currentThread().getName();
                Intrinsics.checkNotNullExpressionValue(name, "currentThread().name");
                return name;
            }
            return String.valueOf(Thread.currentThread().getId());
        }

        @JvmStatic
        public final void a(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            e(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a(d(tag), c("[" + action + "]: " + info));
        }

        @JvmStatic
        public final void f(@NotNull String tag, @NotNull String action) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            e(tag);
            if (l()) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).d(d(tag), c("[" + action + "]"));
            }
        }

        @JvmStatic
        public final void g(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            e(tag);
            if (l()) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).d(d(tag), c("[" + action + "]: " + info));
            }
        }

        @JvmStatic
        public final void h(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            e(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(d(tag), c("[" + action + "]: " + info));
        }

        @JvmStatic
        public final void i(@NotNull String tag, @NotNull String action, @NotNull String info, @NotNull Throwable th5) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(th5, "th");
            e(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(d(tag), c("[" + action + "]: " + info), th5);
        }

        @JvmStatic
        public final void j(@NotNull String tag, @NotNull String action) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            e(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(d(tag), c("[" + action + "]"));
        }

        @JvmStatic
        public final void k(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            e(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(d(tag), c("[" + action + "]: " + info));
        }

        @JvmStatic
        public final boolean l() {
            return QLog.isColorLevel();
        }

        @JvmStatic
        public final boolean m() {
            return QLog.isDevelopLevel();
        }

        @JvmStatic
        public final void q(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            e(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(d(tag), c("[" + action + "]: " + info));
        }

        Companion() {
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"ICGameUnknown", "ICGameLogin", "ICGameGift", "ICGameVSRequest", "ICGameOpen_Live", "ICGameAudience", "ICGameShare", "ICGameAudienceView", "ICGameEntrance", "ICGameRoomDisplayView", "ICGameRoom_info", "ICGamePush", "ICGamePendant", "ICGamePK_Biz", "ICGameChat_Message"});
        f432183b = of5;
    }

    @JvmStatic
    public static final void b(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.g(str, str2, str3);
    }

    @JvmStatic
    public static final void c(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.h(str, str2, str3);
    }

    @JvmStatic
    public static final void d(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Throwable th5) {
        INSTANCE.i(str, str2, str3, th5);
    }

    @JvmStatic
    public static final void e(@NotNull String str, @NotNull String str2) {
        INSTANCE.j(str, str2);
    }

    @JvmStatic
    public static final void f(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.k(str, str2, str3);
    }

    @JvmStatic
    public static final void g(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.q(str, str2, str3);
    }
}
