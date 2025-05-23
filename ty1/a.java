package ty1;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0007J0\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0007J/\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00102\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000e\"\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lty1/a;", "", "", "taskName", "", "extraInfo", "", h.F, "event", "b", "d", "key", "value", "f", "", "args", "", "e", "([Ljava/lang/String;)Ljava/util/Map;", "Ljava/util/Map;", "taskNameKeyMap", "", "c", "taskNameTimeMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f437904a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, String> taskNameKeyMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Long> taskNameTimeMap = new LinkedHashMap();

    a() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull String taskName, @NotNull String event) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(event, "event");
        c(taskName, event, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(@NotNull String taskName, @NotNull String event, @NotNull Map<String, String> extraInfo) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        String str = taskNameKeyMap.get(taskName);
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildScheduleReportTask", 2, "addTaskEvent (" + event + ") but taskKey is empty. return");
                    return;
                }
                return;
            }
            QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
            HashMap hashMap = new HashMap();
            hashMap.putAll(extraInfo);
            long uptimeMillis = SystemClock.uptimeMillis();
            Long l3 = taskNameTimeMap.get(taskName);
            Intrinsics.checkNotNull(l3);
            hashMap.put("timestamp_from_start_on", String.valueOf(uptimeMillis - l3.longValue()));
            ((IQQOpenTelemetryReportApi) api).reportOpenTelemetryTask(str, event, hashMap);
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildScheduleReportTask", 2, "addTaskEvent eventName: " + event + ", params: " + hashMap);
            }
        }
    }

    public static /* synthetic */ void c(String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = e(new String[0]);
        }
        b(str, str2, map);
    }

    @JvmStatic
    public static final void d(@NotNull String taskName) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        String str = taskNameKeyMap.get(taskName);
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildScheduleReportTask", 2, "endTask but taskKey is empty. return");
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            long uptimeMillis = SystemClock.uptimeMillis();
            Long l3 = taskNameTimeMap.get(taskName);
            Intrinsics.checkNotNull(l3);
            hashMap.put("timestamp_from_start_on", String.valueOf(uptimeMillis - l3.longValue()));
            QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
            iQQOpenTelemetryReportApi.reportOpenTelemetryTask(str, "end", hashMap);
            iQQOpenTelemetryReportApi.endOpenTelemetryTask(str);
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildScheduleReportTask", 2, "endTask, taskName=" + taskName + ", taskKey=" + str);
            }
            taskNameKeyMap.remove(taskName);
        }
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> e(@NotNull String... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (args.length % 2 != 0) {
            return linkedHashMap;
        }
        int i3 = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, args.length - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                String str = args[i3];
                String str2 = args[i3 + 1];
                if (str2 == null) {
                    str2 = "";
                }
                linkedHashMap.put(str, str2);
                if (i3 == progressionLastElement) {
                    break;
                }
                i3 += 2;
            }
        }
        return linkedHashMap;
    }

    @JvmStatic
    public static final void f(@NotNull String taskName, @NotNull String key, @NotNull String value) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = taskNameKeyMap.get(taskName);
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(key, value));
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(str, mapOf);
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@NotNull String taskName) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        i(taskName, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void h(@NotNull String taskName, @NotNull Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (taskNameKeyMap.containsKey(taskName)) {
            return;
        }
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String taskKey = iQQOpenTelemetryReportApi.startOpenTelemetryTask(taskName);
        long uptimeMillis = SystemClock.uptimeMillis();
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "start");
        HashMap hashMap = new HashMap();
        hashMap.put("ret", "0");
        hashMap.put("msg", "");
        hashMap.put("stage", "");
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(taskKey, hashMap);
        Map<String, String> map = taskNameKeyMap;
        Intrinsics.checkNotNullExpressionValue(taskKey, "taskKey");
        map.put(taskName, taskKey);
        taskNameTimeMap.put(taskName, Long.valueOf(uptimeMillis));
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildScheduleReportTask", 2, "startTask, taskName=" + taskName + ", taskKey=" + taskKey + " ");
        }
        if (!extraInfo.isEmpty()) {
            b(taskName, "start_task", extraInfo);
        }
    }

    public static /* synthetic */ void i(String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = e(new String[0]);
        }
        h(str, map);
    }
}
