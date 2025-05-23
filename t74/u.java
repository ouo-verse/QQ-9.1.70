package t74;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lt74/u;", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lt74/u$a;", "", "Landroid/content/Context;", "context", "", "c", "b", "", "a", "", "disableLog", "d", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f", "RATIO_MIN_SCREEN", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: t74.u$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getDisplayMetrics().density;
        }

        public final int b(Context context) {
            com.tencent.zplan.common.utils.b bVar = com.tencent.zplan.common.utils.b.f385287a;
            if (context == null) {
                context = BaseApplication.context;
            }
            Intrinsics.checkNotNullExpressionValue(context, "context ?: BaseApplication.context");
            return bVar.a(context);
        }

        public final int c(Context context) {
            com.tencent.zplan.common.utils.b bVar = com.tencent.zplan.common.utils.b.f385287a;
            if (context == null) {
                context = BaseApplication.context;
            }
            Intrinsics.checkNotNullExpressionValue(context, "context ?: BaseApplication.context");
            return bVar.b(context);
        }

        public final boolean d(Context context, boolean disableLog) {
            Intrinsics.checkNotNullParameter(context, "context");
            int c16 = c(context);
            int b16 = b(context);
            if (c16 <= 0 || b16 <= 0) {
                return false;
            }
            float f16 = c16 / b16;
            float f17 = 1 / 0.71f;
            if (!disableLog) {
                QLog.d("ZPlanScreenUtil", 1, "isFolderScreenOpenMode:" + f16 + " |minRatio:0.71|maxRatio" + f17 + "__disPlayWidth| disPlayHeight:" + c16 + "|" + b16);
            }
            return 0.71f <= f16 && f16 <= f17;
        }

        public final boolean f(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                int i3 = activity.getResources().getConfiguration().orientation;
                QLog.d("ZPlanScreenUtil", 1, "activity.configuration " + i3);
                return i3 == 2;
            } catch (Exception e16) {
                QLog.e("ZPlanScreenUtil", 1, "configuration error ", e16);
                return false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean g() {
            boolean z16;
            boolean isInMultiWindowMode;
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            Activity topActivity = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getTopActivity();
            if (topActivity != null) {
                isInMultiWindowMode = topActivity.isInMultiWindowMode();
                if (isInMultiWindowMode) {
                    z16 = true;
                    return !z16;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }

        Companion() {
        }

        public static /* synthetic */ boolean e(Companion companion, Context context, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            return companion.d(context, z16);
        }
    }
}
