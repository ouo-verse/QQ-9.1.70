package zl2;

import com.tencent.mobileqq.qzoneplayer.player.CachedMediaPlayer;
import com.tencent.mobileqq.qzoneplayer.video.k;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import zl2.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends b {
    /* JADX INFO: Access modifiers changed from: private */
    public CachedMediaPlayer g() {
        if (!c()) {
            PlayerUtils.log(4, "StandardInfoParser", "[createCachedMediaPlayer] supper player illegality.");
            return null;
        }
        CachedMediaPlayer c16 = CachedMediaPlayer.c(6, "", false);
        PlayerUtils.log(4, "StandardInfoParser", "[createCachedMediaPlayer] parse super player");
        return c16;
    }

    public void i(SegmentVideoInfo.StreamInfo streamInfo, b.a aVar) {
        if (c()) {
            PlayerUtils.log(4, "StandardInfoParser", "[parse] current super player allowed, start parse...");
            h(aVar, g());
        } else {
            PlayerUtils.log(4, "StandardInfoParser", "[parse] current super player not allowed, init super video sdk...");
            a(new C11695a(aVar));
        }
    }

    /* compiled from: P */
    /* renamed from: zl2.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11695a implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f452748a;

        C11695a(b.a aVar) {
            this.f452748a = aVar;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.k
        public void onSDKInited(boolean z16) {
            if (z16) {
                a aVar = a.this;
                aVar.h(this.f452748a, aVar.g());
            } else {
                PlayerUtils.log(4, "StandardInfoParser", "[onSDKInited] isSuccess == false.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(b.a aVar, CachedMediaPlayer cachedMediaPlayer) {
        if (aVar == null) {
            PlayerUtils.log(4, "StandardInfoParser", "[notifyCreateVideo] listener should not be null.");
        } else {
            aVar.a(cachedMediaPlayer);
        }
    }
}
