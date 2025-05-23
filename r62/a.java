package r62;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, VideoEntity> f430821a = new HashMap();

    /* compiled from: P */
    /* renamed from: r62.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11116a {

        /* renamed from: a, reason: collision with root package name */
        private String f430822a;

        /* renamed from: b, reason: collision with root package name */
        private long f430823b;

        /* renamed from: f, reason: collision with root package name */
        private long f430827f;

        /* renamed from: g, reason: collision with root package name */
        private int f430828g;

        /* renamed from: h, reason: collision with root package name */
        private int f430829h;

        /* renamed from: i, reason: collision with root package name */
        private int f430830i;

        /* renamed from: k, reason: collision with root package name */
        private int f430832k;

        /* renamed from: l, reason: collision with root package name */
        private int f430833l;

        /* renamed from: m, reason: collision with root package name */
        private String f430834m;

        /* renamed from: n, reason: collision with root package name */
        private int f430835n;

        /* renamed from: c, reason: collision with root package name */
        private String f430824c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f430825d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f430826e = "";

        /* renamed from: j, reason: collision with root package name */
        private String f430831j = "";

        /* renamed from: o, reason: collision with root package name */
        private int f430836o = -1;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            return this.f430834m != null || this.f430836o > 0;
        }

        public static C11116a g(k62.b bVar) {
            C11116a c11116a = new C11116a();
            if (bVar == null) {
                return c11116a;
            }
            c11116a.f430826e = bVar.f411786r;
            c11116a.f430824c = bVar.f411771c;
            q52.a aVar = bVar.f411785q;
            if (aVar != null) {
                c11116a.f430825d = aVar.f428384a;
                c11116a.f430829h = aVar.F;
                c11116a.f430828g = aVar.E;
            }
            return c11116a;
        }

        public HashMap<String, Object> e() {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, com.tencent.mobileqq.kandian.repo.report.a.f240074a);
            hashMap.put("dt_pgid", a.c(this.f430822a));
            hashMap.put("channel_id", Long.valueOf(this.f430823b));
            hashMap.put("vid", a.c(this.f430824c));
            hashMap.put("rowkey", a.c(this.f430825d));
            hashMap.put("cid", "");
            hashMap.put("cmsid", "");
            hashMap.put(IPublicAccountBrowser.KEY_PUB_UIN, a.c(this.f430826e));
            hashMap.put("video_height", Integer.valueOf(this.f430829h));
            hashMap.put("video_width", Integer.valueOf(this.f430828g));
            hashMap.put("is_short", Integer.valueOf(this.f430830i));
            hashMap.put(PlayParamConst.ParamKey.PLAY_SESSION_ID, a.c(this.f430831j));
            hashMap.put(PlayParamConst.ParamKey.PLAY_TYPE, Integer.valueOf(this.f430832k));
            hashMap.put(PlayParamConst.ParamKey.PLAY_LOOP_TYPE, Integer.valueOf(this.f430833l));
            hashMap.put("backend_info", a.c(this.f430834m));
            return hashMap;
        }

        public C11116a h(int i3) {
            this.f430835n = i3;
            return this;
        }

        public C11116a i(String str) {
            this.f430822a = str;
            return this;
        }

        public C11116a j(int i3) {
            this.f430833l = i3;
            return this;
        }

        public C11116a k(String str) {
            this.f430831j = str;
            return this;
        }

        public C11116a l(int i3) {
            this.f430832k = i3;
            return this;
        }

        public C11116a m(int i3) {
            this.f430836o = i3;
            return this;
        }

        public C11116a n(long j3) {
            this.f430827f = j3;
            return this;
        }
    }

    private static void d(Object obj, Object obj2, C11116a c11116a) {
        VideoEntity build = new VideoEntity.Builder().setContentId(c11116a.f430825d).setPage(obj).ignoreReport(c11116a.f430835n == 1).setContentType(c11116a.f430835n).setVideoDuration((int) c11116a.f430827f).addCustomParams((Map<String, ?>) c11116a.e()).bizReady(c11116a.f()).setIdentifier(c11116a.f430825d).build();
        f430821a.put(Integer.valueOf(obj2.hashCode()), build);
        VideoReport.bindVideoPlayerInfo(obj2, build);
    }

    public static void b(Object obj, VideoPlayerWrapper videoPlayerWrapper, C11116a c11116a) {
        if (videoPlayerWrapper != null) {
            videoPlayerWrapper.x0(c11116a.f430825d);
            d(obj, videoPlayerWrapper, c11116a);
        }
    }

    public static void e(VideoPlayerWrapper videoPlayerWrapper) {
        if (videoPlayerWrapper != null) {
            VideoReport.unbindVideoPlayerInfo(videoPlayerWrapper);
            f430821a.remove(videoPlayerWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        return str != null ? str : "";
    }
}
