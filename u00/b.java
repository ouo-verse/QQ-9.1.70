package u00;

import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lu00/b;", "Lcom/tencent/biz/pubaccount/weishi/player/wrapper/c;", "", "frameRate", "c", "width", "height", "", "b", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements com.tencent.biz.pubaccount.weishi.player.wrapper.c {
    private final int c(int frameRate) {
        if (frameRate <= 0) {
            return 30;
        }
        return frameRate;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.c
    public boolean a(int width, int height, int frameRate) {
        return QQVideoPlaySDKManager.isSDKReady() && TPLibraryLoader.isAllLibrariesSuccessfullyLoaded() && TPDecoderCapability.getVideoDecoderCapability(172, 102, width, height, (float) c(frameRate)) == 1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.c
    public boolean b(int width, int height, int frameRate) {
        return QQVideoPlaySDKManager.isSDKReady() && TPLibraryLoader.isAllLibrariesSuccessfullyLoaded() && TPDecoderCapability.getVideoDecoderCapability(172, width, height, (float) c(frameRate)) == 1;
    }
}
