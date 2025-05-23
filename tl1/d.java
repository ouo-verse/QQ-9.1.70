package tl1;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Ltl1/d;", "", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f436521a = new d();

    d() {
    }

    public final boolean a() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_channel_homepage_default_tab_change");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026EPAGE_DEFAULT_TAB_CHANGE)");
        if (expEntity.isExperiment("exp_channel_homepage_default_tab_change_A")) {
            expEntity.reportExpExposure();
            return true;
        }
        if (expEntity.isExperiment("exp_channel_homepage_default_tab_change_B")) {
            expEntity.reportExpExposure();
            return false;
        }
        QLog.d("GuildFeedSubPageLocateABTestUtils", 1, "default, locateHotPage");
        return true;
    }
}
