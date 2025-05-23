package zx2;

import com.tencent.biz.richframework.video.rfw.player.RFWTVKPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWTVKPlayerOptionFetch;
import jy2.g;
import tvideo.Video;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements IRFWTVKPlayerOptionFetch {
    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWTVKPlayerOptionFetch
    public RFWTVKPlayerOptions getTVKPlayerOption(Object obj) {
        if (!(obj instanceof e30.b)) {
            return null;
        }
        e30.b bVar = (e30.b) obj;
        Video q16 = g.q(bVar.g());
        if (q16 == null || q16.video_base_info == null) {
            return null;
        }
        return g.o(bVar.g(), q16, jy2.c.f411160a.b(q16));
    }
}
