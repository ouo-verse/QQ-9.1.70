package zj3;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.dependency.AbsLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\r\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lzj3/l;", "Lcom/tencent/rdelivery/dependency/AbsLog;", "", "isColorLevel", "", "tag", "Lcom/tencent/rdelivery/dependency/AbsLog$Level;", "logLevel", "msg", "", "b", "", "throwable", "c", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l extends AbsLog {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f452673a;

        static {
            int[] iArr = new int[AbsLog.Level.values().length];
            try {
                iArr[AbsLog.Level.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbsLog.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbsLog.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbsLog.Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbsLog.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f452673a = iArr;
        }
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void b(String tag, AbsLog.Level logLevel, String msg2) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        int i3 = b.f452673a[logLevel.ordinal()];
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, msg2);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                if (Intrinsics.areEqual("ResHub.MultiProcFileOptLock", tag)) {
                    return;
                }
                QLog.i(tag, 1, msg2);
                return;
            } else if (i3 == 4) {
                QLog.w(tag, 1, msg2);
                return;
            } else {
                if (i3 != 5) {
                    return;
                }
                QLog.e(tag, 1, msg2);
                return;
            }
        }
        if (msg2 != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(msg2, "doLoadAllRDeliveryDatasFromDisc it key =", false, 2, null);
            if (startsWith$default) {
                return;
            }
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(msg2, "decodeRDDataFromJson key =", false, 2, null);
            if (startsWith$default2) {
                return;
            }
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(msg2, "decodeJsonConfigs op", false, 2, null);
            if (startsWith$default3) {
                return;
            }
        }
        if (!Intrinsics.areEqual("ResHub.MultiProcFileOptLock", tag) && QLog.isColorLevel()) {
            QLog.d(tag, 2, msg2);
        }
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void c(String tag, AbsLog.Level logLevel, String msg2, Throwable throwable) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        int i3 = b.f452673a[logLevel.ordinal()];
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, msg2, throwable);
            }
        } else if (i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, msg2, throwable);
            }
        } else if (i3 == 3) {
            QLog.i(tag, 1, msg2, throwable);
        } else if (i3 == 4) {
            QLog.w(tag, 1, msg2, throwable);
        } else {
            if (i3 != 5) {
                return;
            }
            QLog.e(tag, 1, msg2, throwable);
        }
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog, com.tencent.raft.standard.log.IRLog
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }
}
