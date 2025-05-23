package wg3;

import com.github.sisong.HPatch;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJV\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lwg3/b;", "", "", "oldFileName", "diffFileName", "outNewFileName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lwg3/b$b;", "patchParams", "", "listener", "b", "Lwg3/b$a;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSoInited", "isSoLoading", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listListener", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f445625a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isSoInited = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isSoLoading = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<a> listListener = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lwg3/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "errorCode", "b", "errorMessage", "", "c", "J", "()J", "patchCostTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wg3.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final /* data */ class C11482b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String errorCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String errorMessage;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long patchCostTime;

        public C11482b() {
            this(null, null, 0L, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: b, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        /* renamed from: c, reason: from getter */
        public final long getPatchCostTime() {
            return this.patchCostTime;
        }

        public int hashCode() {
            int hashCode = this.errorCode.hashCode() * 31;
            String str = this.errorMessage;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.patchCostTime);
        }

        public String toString() {
            return "errorCode = " + this.errorCode + ", errormessage = " + this.errorMessage + ", costTime = " + this.patchCostTime;
        }

        public C11482b(String errorCode, String str, long j3) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            this.errorCode = errorCode;
            this.errorMessage = str;
            this.patchCostTime = j3;
        }

        public /* synthetic */ C11482b(String str, String str2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0L : j3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof C11482b)) {
                return false;
            }
            C11482b c11482b = (C11482b) other;
            return Intrinsics.areEqual(this.errorCode, c11482b.errorCode) && Intrinsics.areEqual(this.errorMessage, c11482b.errorMessage) && this.patchCostTime == c11482b.patchCostTime;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"wg3/b$c", "Lwg3/b$a;", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f445632a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f445633b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f445634c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, C11482b, Unit> f445635d;

        /* JADX WARN: Multi-variable type inference failed */
        c(String str, String str2, String str3, Function2<? super Boolean, ? super C11482b, Unit> function2) {
            this.f445632a = str;
            this.f445633b = str2;
            this.f445634c = str3;
            this.f445635d = function2;
        }

        @Override // wg3.b.a
        public void a(boolean isSuccess, int errorCode, String errorMessage) {
            QLog.i("ZPlanDiffPatchUtil", 1, "loadHDiffPathSo, isSuccess " + isSuccess);
            long currentTimeMillis = System.currentTimeMillis();
            if (isSuccess) {
                try {
                    int a16 = HPatch.a(this.f445632a, this.f445633b, this.f445634c);
                    boolean z16 = a16 == 0;
                    this.f445635d.invoke(Boolean.valueOf(z16), new C11482b("res_patch" + a16, null, System.currentTimeMillis() - currentTimeMillis, 2, null));
                    return;
                } catch (Throwable th5) {
                    QLog.e("ZPlanDiffPatchUtil", 1, "exp", th5);
                    this.f445635d.invoke(Boolean.FALSE, new C11482b("res_exception", th5.toString(), System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
            }
            this.f445635d.invoke(Boolean.FALSE, new C11482b("res_load_patch_so" + errorCode, errorMessage, 0L, 4, null));
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j3, int i3, LoadExtResult loadExtResult) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.i("ZPlanDiffPatchUtil", 1, "load resCode " + i3 + ", " + loadExtResult.getReportCode() + " cost: " + currentTimeMillis);
        boolean z16 = i3 == 0;
        Iterator<T> it = listListener.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z16, i3, loadExtResult.getReportStr());
        }
        listListener.clear();
        isSoLoading.set(false);
        isSoInited.set(z16);
    }

    public final void b(String oldFileName, String diffFileName, String outNewFileName, Function2<? super Boolean, ? super C11482b, Unit> listener) {
        Intrinsics.checkNotNullParameter(oldFileName, "oldFileName");
        Intrinsics.checkNotNullParameter(diffFileName, "diffFileName");
        Intrinsics.checkNotNullParameter(outNewFileName, "outNewFileName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        c(new c(oldFileName, diffFileName, outNewFileName, listener));
    }

    public final void c(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isSoInited.get()) {
            QLog.d("ZPlanDiffPatchUtil", 1, "so inited");
            a.C11481a.a(listener, true, 0, null, 6, null);
            return;
        }
        listListener.add(listener);
        if (isSoLoading.get()) {
            return;
        }
        isSoLoading.set(true);
        final long currentTimeMillis = System.currentTimeMillis();
        SoLoadManager.getInstance().load(SoLoadConstants.SONAME_HDIFF_PATCH, new OnLoadListener() { // from class: wg3.a
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                b.d(currentTimeMillis, i3, loadExtResult);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lwg3/b$a;", "", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface a {
        void a(boolean isSuccess, int errorCode, String errorMessage);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: wg3.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        public static final class C11481a {
            public static /* synthetic */ void a(a aVar, boolean z16, int i3, String str, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 2) != 0) {
                        i3 = 0;
                    }
                    if ((i16 & 4) != 0) {
                        str = null;
                    }
                    aVar.a(z16, i3, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onComplete");
            }
        }
    }
}
