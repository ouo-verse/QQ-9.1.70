package qw1;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u001a5\u0010\u0007\u001a\u00020\u0004*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\b\u0005H\u0007\u001a5\u0010\b\u001a\u00020\u0004*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\b\u0005H\u0007\u001a\f\u0010\t\u001a\u00020\u0004*\u0004\u0018\u00010\u0000\u001a\f\u0010\n\u001a\u00020\u0004*\u0004\u0018\u00010\u0000\u001a$\u0010\u0011\u001a\u00020\u0004*\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0012\u001a\u0016\u0010\u0016\u001a\u00020\u0000*\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\f\u001a\u0016\u0010\u0017\u001a\u00020\u0000*\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\f\u001a\u0012\u0010\u0019\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0000\u001a\u001a\u0010\u001a\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\f\u001a\u001c\u0010\u001b\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\f\u001a\u001a\u0010\u001f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\f\"\u0014\u0010\"\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Landroid/view/View;", "view", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "j", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/report/Reporters;", "", "errorName", "errorMessage", "", "throwable", h.F, "Landroid/content/Intent;", "e", "Landroid/os/Bundle;", "key", "f", "c", "reportTask", "r", ReportConstant.COSTREPORT_PREFIX, "t", "", QzoneIPCModule.RESULT_CODE, "resultMsg", "b", "a", "Ljava/lang/String;", "EXTRA_PARAM_REPORT_TASK", "base_proj_ext_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f430251a = "_extra_param_report_task";

    public static final void b(@NotNull IPerformanceReportTask iPerformanceReportTask, int i3, @NotNull String resultMsg) {
        Intrinsics.checkNotNullParameter(iPerformanceReportTask, "<this>");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        iPerformanceReportTask.setResultCode(i3);
        iPerformanceReportTask.setResultMsg(resultMsg);
        iPerformanceReportTask.report();
    }

    @NotNull
    public static final IPerformanceReportTask c(@Nullable Bundle bundle, @NotNull String key) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(key, "key");
        IPerformanceReportTask iPerformanceReportTask = null;
        if (bundle != null) {
            serializable = bundle.getSerializable(key);
        } else {
            serializable = null;
        }
        if (serializable instanceof IPerformanceReportTask) {
            iPerformanceReportTask = (IPerformanceReportTask) serializable;
        }
        if (iPerformanceReportTask != null) {
            bundle.remove(key);
            return iPerformanceReportTask;
        }
        return DummyPerformanceReportTask.INSTANCE;
    }

    public static /* synthetic */ IPerformanceReportTask d(Bundle bundle, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = f430251a;
        }
        return c(bundle, str);
    }

    @Nullable
    public static final IPerformanceReportTask e(@Nullable Intent intent) {
        Serializable serializable;
        if (intent != null) {
            serializable = intent.getSerializableExtra(f430251a);
        } else {
            serializable = null;
        }
        if (!(serializable instanceof IPerformanceReportTask)) {
            return null;
        }
        return (IPerformanceReportTask) serializable;
    }

    @NotNull
    public static final IPerformanceReportTask f(@Nullable Bundle bundle, @NotNull String key) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(key, "key");
        IPerformanceReportTask iPerformanceReportTask = null;
        if (bundle != null) {
            serializable = bundle.getSerializable(key);
        } else {
            serializable = null;
        }
        if (serializable instanceof IPerformanceReportTask) {
            iPerformanceReportTask = (IPerformanceReportTask) serializable;
        }
        if (iPerformanceReportTask == null) {
            return DummyPerformanceReportTask.INSTANCE;
        }
        return iPerformanceReportTask;
    }

    public static /* synthetic */ IPerformanceReportTask g(Bundle bundle, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = f430251a;
        }
        return f(bundle, str);
    }

    public static final void h(@Nullable Reporters reporters, @NotNull String errorName, @NotNull String errorMessage, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(errorName, "errorName");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        IPerformanceReportTask a16 = Reporters.f231995a.a().a();
        a16.setEventCode("caughtException");
        a16.setParam("error_name", errorName);
        a16.setExtra("error_message", errorMessage);
        a16.setExtra("stack", Log.getStackTraceString(throwable));
        a16.report();
    }

    @JvmOverloads
    public static final void i(@Nullable IPerformanceReportTask iPerformanceReportTask, @Nullable View view) {
        k(iPerformanceReportTask, view, null, 2, null);
    }

    @JvmOverloads
    public static final void j(@Nullable final IPerformanceReportTask iPerformanceReportTask, @Nullable View view, @Nullable final Function1<? super IPerformanceReportTask, Unit> function1) {
        if (iPerformanceReportTask != null && view != null && !(iPerformanceReportTask instanceof DummyPerformanceReportTask)) {
            final long uptimeMillis = SystemClock.uptimeMillis();
            OneShotPreDrawListener.add(view, new Runnable() { // from class: qw1.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.l(IPerformanceReportTask.this, uptimeMillis, function1);
                }
            });
        }
    }

    public static /* synthetic */ void k(IPerformanceReportTask iPerformanceReportTask, View view, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        j(iPerformanceReportTask, view, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(IPerformanceReportTask iPerformanceReportTask, long j3, Function1 function1) {
        iPerformanceReportTask.setTimeCost(SystemClock.uptimeMillis() - j3);
        if (function1 != null) {
            function1.invoke(iPerformanceReportTask);
        }
        iPerformanceReportTask.report();
    }

    public static final void m(@Nullable IPerformanceReportTask iPerformanceReportTask) {
        if (iPerformanceReportTask != null && !iPerformanceReportTask.getIsReported()) {
            iPerformanceReportTask.report();
        }
    }

    public static final void n(@Nullable IPerformanceReportTask iPerformanceReportTask) {
        if (iPerformanceReportTask != null && !iPerformanceReportTask.getIsReported()) {
            iPerformanceReportTask.setStageCode("single_end");
            iPerformanceReportTask.report();
        }
    }

    @JvmOverloads
    public static final void o(@Nullable IPerformanceReportTask iPerformanceReportTask, @Nullable View view) {
        q(iPerformanceReportTask, view, null, 2, null);
    }

    @JvmOverloads
    public static final void p(@Nullable IPerformanceReportTask iPerformanceReportTask, @Nullable View view, @Nullable Function1<? super IPerformanceReportTask, Unit> function1) {
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setStageCode("single_end");
        }
        if (iPerformanceReportTask != null) {
            j(iPerformanceReportTask, view, function1);
        }
    }

    public static /* synthetic */ void q(IPerformanceReportTask iPerformanceReportTask, View view, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        p(iPerformanceReportTask, view, function1);
    }

    @NotNull
    public static final Intent r(@NotNull Intent intent, @NotNull IPerformanceReportTask reportTask) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        intent.putExtra(f430251a, reportTask);
        return intent;
    }

    @NotNull
    public static final Intent s(@NotNull Intent intent, @NotNull IPerformanceReportTask reportTask, @NotNull String key) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        Intrinsics.checkNotNullParameter(key, "key");
        intent.putExtra(key, reportTask);
        return intent;
    }

    @NotNull
    public static final Bundle t(@NotNull Bundle bundle, @NotNull IPerformanceReportTask reportTask, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putSerializable(key, reportTask);
        return bundle;
    }

    public static /* synthetic */ Bundle u(Bundle bundle, IPerformanceReportTask iPerformanceReportTask, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = f430251a;
        }
        return t(bundle, iPerformanceReportTask, str);
    }
}
