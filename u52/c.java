package u52;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lu52/c;", "Lt52/d;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "", "a", "Lt52/c;", "listener", "c", "", "b", "success", "onSDKInited", "d", "Lt52/c;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements t52.d, SDKInitListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private t52.c listener;

    @Override // t52.d
    public void a() {
        if (QLog.isColorLevel()) {
            QLog.e(LogTag.TAG_READINJOY_VIDEO, 2, "initSuperPlayerSDK() finish");
        }
    }

    @Override // t52.d
    public boolean b() {
        return QQVideoPlaySDKManager.isSDKReady();
    }

    @Override // t52.d
    public void c(t52.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this);
    }

    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
    public void onSDKInited(boolean success) {
        if (success) {
            t52.c cVar = this.listener;
            if (cVar != null) {
                cVar.b();
                return;
            }
            return;
        }
        t52.c cVar2 = this.listener;
        if (cVar2 != null) {
            cVar2.a(0);
        }
    }
}
