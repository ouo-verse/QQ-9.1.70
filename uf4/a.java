package uf4;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import ft3.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Luf4/a;", "", "", "a", "Luf4/a$a;", "reporterData", "", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f438911a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Luf4/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "event", "b", "e", "result", "d", "msg", "domain", "", "J", "()J", "g", "(J)V", QCircleWeakNetReporter.KEY_COST, "f", "I", "()I", h.F, "(I)V", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uf4.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class ReporterData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String event;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String result;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String msg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String domain;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long cost;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int scene;

        public ReporterData(@NotNull String event, @NotNull String result, @Nullable String str, @NotNull String domain) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(domain, "domain");
            this.event = event;
            this.result = result;
            this.msg = str;
            this.domain = domain;
            this.cost = -1L;
        }

        /* renamed from: a, reason: from getter */
        public final long getCost() {
            return this.cost;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getDomain() {
            return this.domain;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getEvent() {
            return this.event;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getResult() {
            return this.result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReporterData)) {
                return false;
            }
            ReporterData reporterData = (ReporterData) other;
            if (Intrinsics.areEqual(this.event, reporterData.event) && Intrinsics.areEqual(this.result, reporterData.result) && Intrinsics.areEqual(this.msg, reporterData.msg) && Intrinsics.areEqual(this.domain, reporterData.domain)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getScene() {
            return this.scene;
        }

        public final void g(long j3) {
            this.cost = j3;
        }

        public final void h(int i3) {
            this.scene = i3;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.event.hashCode() * 31) + this.result.hashCode()) * 31;
            String str = this.msg;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + this.domain.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReporterData(event=" + this.event + ", result=" + this.result + ", msg=" + this.msg + ", domain=" + this.domain + ")";
        }
    }

    static {
        ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).init();
    }

    a() {
    }

    private final String a() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && waitAppRuntime.isLogin() && !TextUtils.isEmpty(waitAppRuntime.getCurrentAccountUin())) {
            String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appInterface.currentAccountUin");
            return currentAccountUin;
        }
        return "-1";
    }

    public final void b(@NotNull ReporterData reporterData) {
        Intrinsics.checkNotNullParameter(reporterData, "reporterData");
        HashMap hashMap = new HashMap();
        hashMap.put("uid", a());
        hashMap.put("ev_result", reporterData.getResult());
        String msg2 = reporterData.getMsg();
        if (msg2 == null) {
            msg2 = "";
        }
        hashMap.put("msg", msg2);
        hashMap.put("domain", reporterData.getDomain());
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(reporterData.getCost()));
        hashMap.put("pskey_scene", String.valueOf(reporterData.getScene()));
        c newReportTask = ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).newReportTask();
        if (newReportTask != null) {
            newReportTask.getData().putAll(hashMap);
            newReportTask.a(reporterData.getEvent());
            newReportTask.send();
        }
    }
}
