package u52;

import android.content.Context;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lu52/b;", "Lt52/a;", "Lo52/d;", "videoView", "Lo52/b;", "b", "", "token", "c", "Landroid/content/Context;", "context", "", "isUseTextureView", "a", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements t52.a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f438357a = new b();

    b() {
    }

    @Override // t52.a
    public o52.d a(Context context, boolean isUseTextureView) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (QQVideoPlaySDKManager.isSDKReady()) {
            return new d(SuperPlayerFactory.createPlayerVideoView(context));
        }
        return new d(null);
    }

    @Override // t52.a
    public o52.b b(o52.d videoView) {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            return new a(SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 104, null));
        }
        return new a(null);
    }

    @Override // t52.a
    public o52.b c(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        ISuperPlayer obtainMediaPlayer = SuperPlayerFactory.obtainMediaPlayer(token);
        if (obtainMediaPlayer != null) {
            return new a(obtainMediaPlayer);
        }
        return null;
    }
}
