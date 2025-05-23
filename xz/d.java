package xz;

import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010'\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\n\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b\u0018\u0010.\"\u0004\b/\u00100R$\u00107\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00103\u001a\u0004\b\u0010\u00104\"\u0004\b5\u00106R(\u0010;\u001a\u0004\u0018\u00010\u000f2\b\u00108\u001a\u0004\u0018\u00010\u000f8F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b(\u00109\u001a\u0004\b\u0003\u0010:R\u0011\u0010<\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u001b\u00a8\u0006?"}, d2 = {"Lxz/d;", "", "", "a", "Ljava/lang/String;", "getVerticalFrom", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "verticalFrom", "b", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "verticalTestId", "", "Lcom/tencent/biz/pubaccount/weishi/player/l;", "c", "Ljava/util/List;", "g", "()Ljava/util/List;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/util/List;)V", "videoInfoList", "", "d", "I", "f", "()I", "r", "(I)V", "videoIndex", "", "Z", "i", "()Z", "k", "(Z)V", "isPlay", "l", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "j", DomainData.DOMAIN_NAME, "isSeamlessPlay", "", tl.h.F, "J", "()J", "o", "(J)V", "startPosition", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "()Lcom/tencent/biz/pubaccount/weishi/player/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/biz/pubaccount/weishi/player/e;)V", "playingParam", "<set-?>", "Lcom/tencent/biz/pubaccount/weishi/player/l;", "()Lcom/tencent/biz/pubaccount/weishi/player/l;", "currentVideoInfo", "videoInfoListSize", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<l> videoInfoList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int videoIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int playState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isSeamlessPlay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long startPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.player.e playingParam;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private l currentVideoInfo;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String verticalFrom = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String verticalTestId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isPlay = true;

    public final l a() {
        List<l> list = this.videoInfoList;
        if (list != null) {
            int size = list.size();
            int i3 = this.videoIndex;
            if (size > i3) {
                this.currentVideoInfo = list.get(i3);
            }
        }
        return this.currentVideoInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getPlayState() {
        return this.playState;
    }

    /* renamed from: c, reason: from getter */
    public final com.tencent.biz.pubaccount.weishi.player.e getPlayingParam() {
        return this.playingParam;
    }

    /* renamed from: d, reason: from getter */
    public final long getStartPosition() {
        return this.startPosition;
    }

    /* renamed from: e, reason: from getter */
    public final String getVerticalTestId() {
        return this.verticalTestId;
    }

    /* renamed from: f, reason: from getter */
    public final int getVideoIndex() {
        return this.videoIndex;
    }

    public final List<l> g() {
        return this.videoInfoList;
    }

    public final int h() {
        List<l> list = this.videoInfoList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsPlay() {
        return this.isPlay;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsSeamlessPlay() {
        return this.isSeamlessPlay;
    }

    public final void k(boolean z16) {
        this.isPlay = z16;
    }

    public final void l(int i3) {
        this.playState = i3;
    }

    public final void m(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.playingParam = eVar;
    }

    public final void n(boolean z16) {
        this.isSeamlessPlay = z16;
    }

    public final void o(long j3) {
        this.startPosition = j3;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verticalFrom = str;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verticalTestId = str;
    }

    public final void r(int i3) {
        this.videoIndex = i3;
    }

    public final void s(List<l> list) {
        this.videoInfoList = list;
    }
}
