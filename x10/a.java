package x10;

import NS_KING_SOCIALIZE_META.VideoSpecUrl;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import com.tencent.biz.pubaccount.weishi.player.WSRetryVideoSpecUrl;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e;
import com.tencent.biz.pubaccount.weishi.video.specurl.WSVideoSpecUrl;
import com.tencent.biz.pubaccount.weishi.video.specurl.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003\u00a8\u0006\u0016"}, d2 = {"Lx10/a;", "", "LUserGrowth/stSimpleMetaFeed;", "feed", "Lcom/tencent/biz/pubaccount/weishi/player/l;", "a", "Lcom/tencent/biz/pubaccount/weishi/video/specurl/c;", "videoSpecUrl", "Lcom/tencent/biz/pubaccount/weishi/player/k;", "c", "", h.F, "i", "", "e", "j", "f", "b", "g", "d", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f446854a = new a();

    a() {
    }

    @JvmStatic
    public static final l a(stSimpleMetaFeed feed) {
        String str;
        Intrinsics.checkNotNullParameter(feed, "feed");
        l lVar = new l();
        d dVar = d.f82378a;
        WSVideoSpecUrl c16 = dVar.c(feed.video_spec_urls);
        lVar.f81166a = feed.f25129id;
        lVar.f81171f = i(feed, c16);
        lVar.f81175j = feed.feed_desc;
        stMetaUgcVideoSeg stmetaugcvideoseg = feed.video;
        lVar.f81169d = stmetaugcvideoseg != null ? stmetaugcvideoseg.duration : 0;
        lVar.f81170e = e(feed, c16);
        lVar.f81167b = j(feed, c16);
        lVar.f81168c = f(feed, c16);
        lVar.f81179n = b(c16);
        lVar.f81180o = d(c16);
        lVar.f81173h = bb.j(feed, false);
        lVar.f81172g = bb.n(feed, false);
        lVar.f81174i = bb.r(feed, false);
        lVar.f81177l = feed.video_type;
        lVar.f81176k = feed.videoPoolType;
        lVar.f81178m = g(c16);
        stSimpleMetaPerson stsimplemetaperson = feed.poster;
        if (stsimplemetaperson == null || (str = stsimplemetaperson.f25130id) == null) {
            str = "";
        }
        lVar.f81181p = str;
        lVar.f81182q = feed.traceId;
        lVar.f81183r = feed.map_ext;
        stOpVideo stopvideo = feed.opVideo;
        lVar.f81184s = stopvideo != null ? stopvideo.videoType : 0;
        stVideoTag stvideotag = feed.videoTag;
        lVar.f81185t = stvideotag != null ? stvideotag.tagId : 0;
        stVideoTag stvideotag2 = feed.bottomTag;
        lVar.f81186u = stvideotag2 != null ? stvideotag2.tagId : 0;
        lVar.f81187v = feed.gdt_ad_type == 1;
        lVar.f81189x = c(feed, dVar.a(feed.video_spec_urls));
        lVar.f81188w = e.p(feed);
        return lVar;
    }

    @JvmStatic
    private static final WSRetryVideoSpecUrl c(stSimpleMetaFeed feed, WSVideoSpecUrl videoSpecUrl) {
        String i3 = i(feed, videoSpecUrl);
        Intrinsics.checkNotNull(i3);
        return new WSRetryVideoSpecUrl(i3, e(feed, videoSpecUrl), j(feed, videoSpecUrl), f(feed, videoSpecUrl), b(videoSpecUrl), g(videoSpecUrl), d(videoSpecUrl));
    }

    @JvmStatic
    public static final int e(stSimpleMetaFeed feed, WSVideoSpecUrl videoSpecUrl) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (videoSpecUrl != null) {
            return (int) videoSpecUrl.getVideoSpecUrl().size;
        }
        stMetaUgcVideoSeg stmetaugcvideoseg = feed.video;
        if (stmetaugcvideoseg != null) {
            return stmetaugcvideoseg.file_size;
        }
        return 0;
    }

    @JvmStatic
    public static final String h(stSimpleMetaFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        return i(feed, d.f82378a.c(feed.video_spec_urls));
    }

    @JvmStatic
    public static final String i(stSimpleMetaFeed feed, WSVideoSpecUrl videoSpecUrl) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (videoSpecUrl != null) {
            String str = videoSpecUrl.getVideoSpecUrl().url;
            if (!(str == null || str.length() == 0)) {
                return videoSpecUrl.getVideoSpecUrl().url;
            }
        }
        return feed.video_url;
    }

    @JvmStatic
    private static final int b(WSVideoSpecUrl videoSpecUrl) {
        if (videoSpecUrl != null) {
            return videoSpecUrl.getDecodeStrategyType();
        }
        return 0;
    }

    @JvmStatic
    private static final int d(WSVideoSpecUrl videoSpecUrl) {
        if (videoSpecUrl != null) {
            return videoSpecUrl.getSelectedSpecReason();
        }
        return 0;
    }

    @JvmStatic
    private static final int f(stSimpleMetaFeed feed, WSVideoSpecUrl videoSpecUrl) {
        if (videoSpecUrl != null) {
            return videoSpecUrl.getVideoSpecUrl().height;
        }
        stMetaUgcVideoSeg stmetaugcvideoseg = feed.video;
        if (stmetaugcvideoseg != null) {
            return stmetaugcvideoseg.width;
        }
        return 0;
    }

    @JvmStatic
    private static final int g(WSVideoSpecUrl videoSpecUrl) {
        VideoSpecUrl videoSpecUrl2;
        if (videoSpecUrl == null || (videoSpecUrl2 = videoSpecUrl.getVideoSpecUrl()) == null) {
            return -1;
        }
        return videoSpecUrl2.videoQuality;
    }

    @JvmStatic
    private static final int j(stSimpleMetaFeed feed, WSVideoSpecUrl videoSpecUrl) {
        if (videoSpecUrl != null) {
            return videoSpecUrl.getVideoSpecUrl().width;
        }
        stMetaUgcVideoSeg stmetaugcvideoseg = feed.video;
        if (stmetaugcvideoseg != null) {
            return stmetaugcvideoseg.width;
        }
        return 0;
    }
}
