package tu;

import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.av.mediacodec.api.IAndroidCodecHelperApi;
import com.tencent.av.utils.af;
import com.tencent.avcore.jni.codec.AndroidCodec;
import com.tencent.avcore.jni.codec.AndroidCodecBase;
import com.tencent.avcore.jni.codec.AndroidCodecStatusCallback;
import com.tencent.avcore.jni.codec.IAndroidCodecAdapter;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements IAndroidCodecAdapter {
    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public AndroidCodecBase createDecCodec(String str) {
        AndroidCodec androidCodec = new AndroidCodec(str);
        androidCodec.setAndroidCodecStatusCallback((AndroidCodecStatusCallback) QRoute.api(IAndroidCodecHelperApi.class));
        return androidCodec;
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public AndroidCodecBase createEncCodec(String str) {
        AndroidCodec androidCodec = new AndroidCodec(str);
        androidCodec.setAndroidCodecStatusCallback((AndroidCodecStatusCallback) QRoute.api(IAndroidCodecHelperApi.class));
        return androidCodec;
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public boolean isSupportAsyncAPI() {
        return DeviceCheck.m();
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public boolean isSupportHWDecLowLatency() {
        return af.C();
    }

    @Override // com.tencent.avcore.jni.codec.IAndroidCodecAdapter
    public boolean isSupportHWEncCBR() {
        return af.D();
    }
}
