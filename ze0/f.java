package ze0;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f452404a = new AtomicInteger(0);

    public byte[] a(Intent intent, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(i3);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(b()));
            if (!TextUtils.isEmpty(str)) {
                stQWebReq.traceid.set(str);
            }
            if (intent != null) {
                intent.putExtra("traceid", str);
            }
            return stQWebReq.toByteArray();
        }
        throw new RuntimeException("req traceId is null!");
    }

    public abstract byte[] b();
}
