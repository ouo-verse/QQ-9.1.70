package rh1;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0016\u0018\u0000 \u00052\u00020\u0001:\u0002\u0007\nB/\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017\u00a8\u0006!"}, d2 = {"Lrh1/e;", "", "", "c", "d", "e", "", "a", "Landroid/view/View;", "f", "b", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "getGdtAd", "()Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "I", "slot", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "mCardAdView", "rh1/e$c", "Lrh1/e$c;", "mCardAdReportCallback", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "feedbackHideAdListener", "Lrh1/e$a;", "cardAdExpoReportCallback", "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/gdtad/aditem/GdtAd;ILcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;Lrh1/e$a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtAd gdtAd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int slot;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardAdView mCardAdView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mCardAdReportCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lrh1/e$a;", "", "", "f", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void f();

        void h();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"rh1/e$c", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "e", "a", "b", "f", "g", "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements aa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f431461a;

        c(a aVar) {
            this.f431461a = aVar;
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void a(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            this.f431461a.f();
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void b(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
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
            this.f431461a.h();
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void g(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        }
    }

    public e(@NotNull ViewGroup container, @NotNull GdtAd gdtAd, int i3, @NotNull CardAdView.b feedbackHideAdListener, @NotNull a cardAdExpoReportCallback) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        Intrinsics.checkNotNullParameter(feedbackHideAdListener, "feedbackHideAdListener");
        Intrinsics.checkNotNullParameter(cardAdExpoReportCallback, "cardAdExpoReportCallback");
        this.gdtAd = gdtAd;
        this.slot = i3;
        c cVar = new c(cardAdExpoReportCallback);
        this.mCardAdReportCallback = cVar;
        com.tencent.xaction.log.b.a("GuildDiscCardAd", 1, "create ad view: slot:" + i3);
        CardAdView c16 = com.tencent.mobileqq.ad.cardad.manager.a.f186722a.c(container.getContext(), container, gdtAd, "", 6, cVar);
        this.mCardAdView = c16;
        if (c16 != null) {
            c16.setSlot(i3);
            c16.setEnableAutoPlay(false);
            c16.setPlayIconAlwaysVisible(true);
            c16.setNeedReportAntiSpam(true);
            c16.setFeedbackHideAdListener(feedbackHideAdListener);
        }
    }

    public final boolean a() {
        if (this.gdtAd.getInnerShowType() != 3 && this.gdtAd.getInnerShowType() != 4) {
            return false;
        }
        return true;
    }

    public final void b() {
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.onDestroy();
        }
    }

    public final void c() {
        com.tencent.xaction.log.b.a("GuildDiscCardAd", 1, "onExpose: slot:" + this.slot);
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.c0();
        }
    }

    public final void d() {
        com.tencent.xaction.log.b.a("GuildDiscCardAd", 1, "startVideo: slot:" + this.slot);
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.r0();
        }
    }

    public final void e() {
        com.tencent.xaction.log.b.a("GuildDiscCardAd", 1, "stopVideo: slot:" + this.slot);
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            CardAdView.u0(cardAdView, false, 1, null);
        }
    }

    @Nullable
    public final View f() {
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            return cardAdView.O();
        }
        return null;
    }
}
