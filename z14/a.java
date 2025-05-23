package z14;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonState;
import com.tencent.mobileqq.util.conversationtitlebutton.g;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\b\u001a\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lz14/a;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/g;", "", "a", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSupport", "callback", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", DownloadInfo.spKey_Config, "onButtonDidShow", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements g {
    private final void a() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", "em_bas_agent_entry");
        hashMap.put("qq_pgid", "pg_bas_msglist");
        hashMap.put("qq_pgstp", 1);
        hashMap.put("qq_ref_pgid", PageUtils.VR_PAGE_NONE);
        String str2 = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUid();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "app?.currentUid ?: \"\"");
        }
        hashMap.put("uid", str);
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUin();
        }
        if (str2 != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "app?.currentUin ?: \"\"");
            str3 = str2;
        }
        hashMap.put("home_uin", str3);
        hashMap.put("msglist_type", 0);
        VideoReport.reportEvent("qq_imp", hashMap);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getAvatarDrawableList(@NotNull Context context, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo, @NotNull Function1<? super Drawable[], Unit> function1) {
        g.a.a(this, context, appInfo, function1);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getCustomTips(@NotNull Context context, @NotNull Function2<? super String, ? super List<? extends Drawable>, Unit> function2) {
        g.a.b(this, context, function2);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean handleIconClick(@NotNull TitleButtonState titleButtonState, @NotNull Context context, @NotNull String str) {
        return g.a.c(this, titleButtonState, context, str);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void isSupport(@NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(Boolean.FALSE);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeRedDot() {
        return g.a.d(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeTips() {
        return g.a.e(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void onButtonDidShow(@NotNull ConversationTitleBtnConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        a();
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void refreshRedDot(@NotNull RedTouch redTouch, @NotNull BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        g.a.g(this, redTouch, appInfo, z16);
    }
}
