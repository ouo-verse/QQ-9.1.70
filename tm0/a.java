package tm0;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import cooperation.qzone.PlatformInfor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Ltm0/a;", "", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "serviceCode", "", "a", "", "b", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f436590a = new a();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: tm0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C11299a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436591a;

        static {
            int[] iArr = new int[VasAdvServiceCode.values().length];
            try {
                iArr[VasAdvServiceCode.SUCCEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VasAdvServiceCode.CREATE_REQUEST_ERR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VasAdvServiceCode.CREATE_REPORT_ERR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_CMD_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_RSP_PARSE_ERR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VasAdvServiceCode.REQUEST_RSP_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_CMD_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_RSP_PARSE_ERR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VasAdvServiceCode.REPORT_RSP_FAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f436591a = iArr;
        }
    }

    a() {
    }

    public final int a(@NotNull VasAdvServiceCode serviceCode) {
        Intrinsics.checkNotNullParameter(serviceCode, "serviceCode");
        switch (C11299a.f436591a[serviceCode.ordinal()]) {
            case 1:
                return 0;
            case 2:
            case 3:
                return 5;
            case 4:
                return 2;
            case 5:
            case 6:
                return 6;
            case 7:
                return 3;
            case 8:
            case 9:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final String b() {
        String str;
        if (SimpleUIUtil.isNowElderMode()) {
            str = PlatformInfor.ELDER_MODE;
        } else {
            str = "default";
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        return str;
    }
}
