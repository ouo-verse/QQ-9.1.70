package pz2;

import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lpz2/b;", "", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "d", "info", "", "f", "b", "", "isFirstScreen", "", "e", "", "position", "g", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "deviceInfo", "c", "I", "lastAdvPosition", "<init>", "()V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f428093a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static qq_ad_get.QQAdGet.DeviceInfo deviceInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile int lastAdvPosition;

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        deviceInfo = f428093a.d();
    }

    private final qq_ad_get.QQAdGet.DeviceInfo d() {
        try {
            GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
            params.supportOpenMotiveAd = true;
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), params);
            if (create != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QzoneAdReqHelper", 2, "gdt device info init success");
                }
                return create.deviceInfo;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("QzoneAdReqHelper", 1, "Error when get gdt device info:", e16);
            return null;
        }
    }

    public final void b() {
        if (deviceInfo == null) {
            ThreadManagerV2.excute(new Runnable() { // from class: pz2.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c();
                }
            }, 16, null, false);
        }
    }

    @NotNull
    public final byte[] e(boolean isFirstScreen) {
        b();
        access.AdGetReq adGetReq = new access.AdGetReq();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            adGetReq.busi_type.set(84);
            adGetReq.client_mod.set(GdtDeviceInfoHelper.getClientMode());
            if (isFirstScreen) {
                qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
                positionInfo.pos_id.set("8090302387112051");
                qQAdGet.position_info.add(positionInfo);
                lastAdvPosition = 0;
            }
            qq_ad_get.QQAdGet.PositionInfo positionInfo2 = new qq_ad_get.QQAdGet.PositionInfo();
            positionInfo2.pos_id.set("216178319149618383");
            qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
            positionExt.deep_link_version.set(1);
            positionInfo2.pos_ext.set(positionExt);
            qQAdGet.position_info.add(positionInfo2);
            qq_ad_get.QQAdGet.DeviceInfo deviceInfo2 = deviceInfo;
            if (deviceInfo2 != null) {
                qQAdGet.device_info.set(deviceInfo2);
            }
            adGetReq.qq_ad_get.set(qQAdGet);
            access.QzoneInfo qzoneInfo = new access.QzoneInfo();
            qzoneInfo.last_adv_position.set(lastAdvPosition);
            adGetReq.qzone_info.set(qzoneInfo);
            QLog.d("QzoneAdReqHelper", 1, "getQzoneAdReqParam isFirstScreen:" + isFirstScreen + ", lastAdvPosition:" + lastAdvPosition);
        } catch (Throwable th5) {
            QLog.e("QzoneAdReqHelper", 1, "create ad req failed " + th5 + ", busiType:84");
        }
        byte[] byteArray = adGetReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "adGetReq.toByteArray()");
        return byteArray;
    }

    public final void f(@Nullable qq_ad_get.QQAdGet.DeviceInfo info) {
        QLog.d("QzoneAdReqHelper", 1, "updateDeviceInfo");
        deviceInfo = info;
    }

    public final void g(int position) {
        QLog.d("QzoneAdReqHelper", 1, "updateLastAdvPosition:" + position);
        lastAdvPosition = position;
    }
}
