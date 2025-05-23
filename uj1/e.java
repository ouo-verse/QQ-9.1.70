package uj1;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.data.ab;
import com.tencent.mobileqq.ad.cardad.data.ac;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u000225\u0018\u0000 \u00052\u00020\u0001:\u0001\u001bB;\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001a\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001cR\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00106\u00a8\u0006>"}, d2 = {"Luj1/e;", "", "", "curProgressMs", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "", DomainData.DOMAIN_NAME, "l", "p", "pageId", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "o", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "b", "I", "slot", "", "c", "Ljava/util/Map;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "d", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "mCardAdView", "e", "Ljava/lang/String;", "mVideoKey", "f", "mPageId", "g", "mPageParams", "Lcom/tencent/gdtad/aditem/GdtAd;", h.F, "Lcom/tencent/gdtad/aditem/GdtAd;", "mGdtAd", "i", "J", "mLastVideoReportProgress", "j", "mLastVideoStartTime", "uj1/e$d", "Luj1/e$d;", "mAdVideoProgressCallback", "uj1/e$e", "Luj1/e$e;", "mAdVideoVoiceOnChangeCallback", "", "adByteArray", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "feedbackHideAdListener", "<init>", "(Landroid/view/ViewGroup;[BILjava/util/Map;Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int slot;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> reportParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardAdView mCardAdView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mVideoKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mPageId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, ? extends Object> mPageParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd mGdtAd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mLastVideoReportProgress;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long mLastVideoStartTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mAdVideoProgressCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C11354e mAdVideoVoiceOnChangeCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"uj1/e$a", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "e", "a", "b", "f", "g", "c", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements aa {
        a() {
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void a(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void b(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            uj1.d.f439072a.y(e.this.reportParams);
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void c(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void d(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void e(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void f(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            uj1.d dVar = uj1.d.f439072a;
            dVar.w(e.this.reportParams);
            dVar.i(e.this.container, gdtAd, e.this.reportParams);
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void g(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            uj1.d dVar = uj1.d.f439072a;
            dVar.k(e.this.container, gdtAd, 0, e.this.reportParams);
            dVar.x(e.this.reportParams);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"uj1/e$b", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$c;", "", "curProgressMs", "", "a", "onVideoStop", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements CardAdView.c {
        b() {
        }

        @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.c
        public void a(long curProgressMs) {
            com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "onVideoStart curProgressMs:" + curProgressMs);
            if (!e.this.m(curProgressMs)) {
                return;
            }
            e.this.mLastVideoStartTime = System.currentTimeMillis();
            e.this.mLastVideoReportProgress = curProgressMs;
            GdtAd gdtAd = e.this.mGdtAd;
            if (gdtAd != null) {
                e eVar = e.this;
                com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "onVideoStart dtReportAdVideoStart");
                uj1.d.f439072a.m(eVar.container, gdtAd, eVar.mPageId, eVar.reportParams);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.c
        public void onVideoStop() {
            GdtAd gdtAd = e.this.mGdtAd;
            if (gdtAd != null) {
                e eVar = e.this;
                uj1.d.f439072a.l(eVar.container, gdtAd, eVar.mPageId, eVar.mPageParams, eVar.reportParams);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"uj1/e$d", "Lcom/tencent/mobileqq/ad/cardad/data/ab;", "", "progress", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ab {
        d() {
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.ab
        public void a(long progress) {
            GuildFeedVideoPlayParamManager.f223979d.h(e.this.mVideoKey, (int) progress);
            com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "onVideoProgressMs:" + progress + ", videoKey:" + e.this.mVideoKey);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"uj1/e$e", "Lcom/tencent/mobileqq/ad/cardad/data/ac;", "", "isVoiceOn", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uj1.e$e, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C11354e implements ac {
        C11354e() {
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.ac
        public void a(boolean isVoiceOn) {
            com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "onVoiceOnChange:" + isVoiceOn + ", mFeedPosition:" + e.this.slot);
            GuildFeedVideoPlayParamManager.f223979d.g(isVoiceOn ^ true);
        }
    }

    public e(@NotNull ViewGroup container, @NotNull byte[] adByteArray, int i3, @NotNull Map<String, String> reportParams, @NotNull CardAdView.b feedbackHideAdListener) {
        Map<String, ? extends Object> emptyMap;
        CardAdView cardAdView;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(adByteArray, "adByteArray");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        Intrinsics.checkNotNullParameter(feedbackHideAdListener, "feedbackHideAdListener");
        this.container = container;
        this.slot = i3;
        this.reportParams = reportParams;
        this.mVideoKey = "";
        this.mPageId = "";
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.mPageParams = emptyMap;
        this.mAdVideoProgressCallback = new d();
        this.mAdVideoVoiceOnChangeCallback = new C11354e();
        com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "create ad view: slot:" + i3);
        GdtAd r16 = uj1.d.f439072a.r(adByteArray);
        this.mGdtAd = r16;
        if (r16 != null) {
            cardAdView = com.tencent.mobileqq.ad.cardad.manager.a.f186722a.c(container.getContext(), container, r16, "", 5, new a());
        } else {
            cardAdView = null;
        }
        this.mCardAdView = cardAdView;
        if (cardAdView != null) {
            cardAdView.setSlot(i3);
            cardAdView.setVideoAutoPlayRectPercent(0.9f);
            cardAdView.setNeedReportAntiSpam(true);
            cardAdView.setFeedbackHideAdListener(feedbackHideAdListener);
            cardAdView.setVoiceOnChangeCallback(this.mAdVideoVoiceOnChangeCallback);
            cardAdView.setVideoProgressCallback(this.mAdVideoProgressCallback);
            CardAdView cardAdView2 = this.mCardAdView;
            this.mVideoKey = (cardAdView2 != null ? cardAdView2.N() : null) + "_" + i3;
            cardAdView.setVideoStateListener(new b());
        }
        k();
    }

    private final void k() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.reportParams);
        GdtAd gdtAd = this.mGdtAd;
        if (gdtAd != null) {
            linkedHashMap.put("sgrp_ad_id", String.valueOf(gdtAd.getAId()));
            String traceId = gdtAd.getTraceId();
            if (traceId == null) {
                traceId = "";
            }
            Intrinsics.checkNotNullExpressionValue(traceId, "it.traceId ?: \"\"");
            linkedHashMap.put("sgrp_ad_trace_id", traceId);
            linkedHashMap.put("sgrp_ad_content_type", Integer.valueOf(uj1.d.f439072a.o(gdtAd)));
        }
        ch.W0(this.mCardAdView, "em_sgrp_feed_section_ad", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(long curProgressMs) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mLastVideoReportProgress;
        if (j3 == 0 && curProgressMs >= 0 && currentTimeMillis - this.mLastVideoStartTime < 300) {
            return false;
        }
        if (j3 != 0 && j3 == curProgressMs && currentTimeMillis - this.mLastVideoStartTime < 300) {
            return false;
        }
        return true;
    }

    public final void l() {
        boolean z16;
        com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "checkExpoAndAutoPlay: slot:" + this.slot);
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            if (uj1.a.f439069a.a() < 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            cardAdView.setEnableVideoPlay(z16);
            com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "setEnableVideoPlay:" + z16);
            if (z16) {
                GuildFeedVideoPlayParamManager guildFeedVideoPlayParamManager = GuildFeedVideoPlayParamManager.f223979d;
                cardAdView.setIsVoiceOn(!guildFeedVideoPlayParamManager.c());
                cardAdView.setVideoStartPosition(guildFeedVideoPlayParamManager.d(this.mVideoKey));
            }
            cardAdView.j();
            if (!z16) {
                CardAdView.u0(cardAdView, false, 1, null);
            }
        }
    }

    @NotNull
    public final String n() {
        String str;
        GdtAd gdtAd = this.mGdtAd;
        if (gdtAd != null) {
            str = gdtAd.getTraceId();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void o() {
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.onDestroy();
        }
    }

    public final void p() {
        GdtAd gdtAd = this.mGdtAd;
        if (gdtAd != null) {
            uj1.d.f439072a.j(this.container, gdtAd, this.reportParams);
        }
    }

    public final void q(@NotNull String pageId, @NotNull Map<String, ? extends Object> pageParams) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        this.mPageId = pageId;
        this.mPageParams = pageParams;
    }

    public final void r() {
        com.tencent.xaction.log.b.a("GuildFeedSquareCardAd", 1, "stopVideo: slot:" + this.slot);
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            CardAdView.u0(cardAdView, false, 1, null);
        }
    }
}
