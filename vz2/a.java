package vz2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.pad.l;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\t"}, d2 = {"Lvz2/a;", "", "Landroid/content/Context;", "context", "", "a", "b", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f443771a = new a();

    a() {
    }

    private final int a(Context context) {
        int d16 = m.d();
        if (d16 == 0) {
            return ScreenUtil.getRealWidth(context);
        }
        return d16;
    }

    public final int b(@Nullable Context context) {
        boolean isInMultiWindowMode;
        float f16;
        boolean z16;
        Configuration configuration;
        if (AppSetting.t(MobileQQ.sMobileQQ.getApplicationContext()) && context != null) {
            if ((context instanceof l) && e.a() == SplitViewState.STATE_FLAT) {
                return a(context);
            }
            if (Build.VERSION.SDK_INT >= 24 && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                isInMultiWindowMode = activity.isInMultiWindowMode();
                if (isInMultiWindowMode) {
                    Resources resources = activity.getResources();
                    if (resources != null && (configuration = resources.getConfiguration()) != null) {
                        f16 = configuration.screenWidthDp;
                    } else {
                        f16 = 0.0f;
                    }
                    if (f16 == 0.0f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        return ViewUtils.dpToPx(f16);
                    }
                    return ScreenUtil.getRealWidth(context);
                }
            }
            return ScreenUtil.getRealWidth(context);
        }
        return ScreenUtil.getRealWidth(context);
    }
}
