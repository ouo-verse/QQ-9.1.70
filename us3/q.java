package us3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000eJ\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u001f"}, d2 = {"Lus3/q;", "", "", "packageName", "", "g", tl.h.F, "j", "desc", "l", "a", "appId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "", "e", "isUserMiniBox", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "isFirstEnter", "p", "crashInfo", DomainData.DOMAIN_NAME, "c", "i", TransferConfig.ExtendParamFloats.KEY_RULE, "o", "d", "k", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f440003a = new q();

    q() {
    }

    private final void g(String packageName) {
        m.f439991a.l(packageName + "_desc");
    }

    private final void h(String packageName) {
        m.f439991a.l(packageName + "_appid");
    }

    private final void j() {
        m.f439991a.l("miniBoxCrashReportRule");
    }

    @NotNull
    public final String a(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return m.f439991a.k(packageName + "_desc");
    }

    @NotNull
    public final String b(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return m.f439991a.k(packageName + "_appid");
    }

    @NotNull
    public final String c(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return m.f439991a.k("crash_" + appId);
    }

    @NotNull
    public final String d() {
        return m.f439991a.k("miniBoxCrashReportRule");
    }

    public final boolean e() {
        return m.f439991a.g("isMiniBoxUser");
    }

    public final boolean f() {
        return !m.f439991a.g("isFirstEntryMiniBoxLoadPage");
    }

    public final void i(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        m.f439991a.l("crash_" + appId);
    }

    public final void k(@NotNull String appId, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        g(packageName);
        h(packageName);
        i(appId);
        i("dex_" + appId);
        j();
    }

    public final void l(@NotNull String packageName, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(desc, "desc");
        m.f439991a.o(packageName + "_desc", desc);
    }

    public final void m(@NotNull String packageName, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        m.f439991a.o(packageName + "_appid", appId);
    }

    public final void n(@NotNull String appId, @NotNull String crashInfo) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(crashInfo, "crashInfo");
        m.f439991a.o("crash_" + appId, crashInfo);
    }

    public final void o(@NotNull String rule) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        m.f439991a.o("miniBoxCrashReportRule", rule);
    }

    public final void p(boolean isFirstEnter) {
        m.f439991a.m("isFirstEntryMiniBoxLoadPage", !isFirstEnter);
    }

    public final void q(boolean isUserMiniBox) {
        m.f439991a.m("isMiniBoxUser", isUserMiniBox);
    }
}
