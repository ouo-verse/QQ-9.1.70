package rx2;

import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.tvideo.danmaku.event.TVideoBarrageSwitchEvent;
import com.tencent.mobileqq.tvideo.danmaku.manager.n;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.Video;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\nH\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006,"}, d2 = {"Lrx2/f;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "l1", "r1", "q1", "Landroid/view/View;", "view", ICustomDataEditor.STRING_PARAM_1, "", "j1", "i1", "p1", "o1", "", "w0", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onResumed", "onFeedSelected", "data", "position", "k1", "", "I", "Z", "isFirstCreat", "Ltvideo/Video;", "J", "Ltvideo/Video;", "videoFeed", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "landscapeDmButton", "L", "verticalDmButton", "<init>", "()V", "M", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFirstCreat = true;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Video videoFeed;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView landscapeDmButton;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView verticalDmButton;

    private final View i1() {
        if (ScreenUtils.isLandscape()) {
            return this.landscapeDmButton;
        }
        return this.verticalDmButton;
    }

    private final int j1() {
        return n.b().e() ? 1 : 0;
    }

    private final void l1() {
        n.b().j();
        r1();
        q1();
        o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o1() {
        Map<String, Object> i3 = gy2.c.i(this.videoFeed);
        Intrinsics.checkNotNullExpressionValue(i3, "buildElementParams(videoFeed)");
        i3.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(j1()));
        VideoReport.reportEvent("clck", i1(), i3);
        p1();
    }

    private final void p1() {
        Map<String, Object> i3 = gy2.c.i(this.videoFeed);
        Intrinsics.checkNotNullExpressionValue(i3, "buildElementParams(videoFeed)");
        i3.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(j1()));
        VideoReport.reportEvent("imp", i1(), i3);
    }

    private final void q1() {
        SimpleEventBus.getInstance().dispatchEvent(new TVideoBarrageSwitchEvent(j1()));
    }

    private final void r1() {
        if (n.b().e()) {
            jy2.f fVar = jy2.f.f411169a;
            fVar.j(this.landscapeDmButton, "https://ugd.gtimg.com//vg/1682583711267_Pause_player_icon_default.png");
            fVar.j(this.verticalDmButton, "https://ugd.gtimg.com/vg/1687932323516_icon_dm_open.png");
        } else {
            jy2.f fVar2 = jy2.f.f411169a;
            fVar2.j(this.landscapeDmButton, "https://ugd.gtimg.com//vg/1682583533123_Pause_player_icon_default.png");
            fVar2.j(this.verticalDmButton, "https://ugd.gtimg.com/vg/1687932302712_icon_dm_close.png");
        }
    }

    private final void s1(View view) {
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, "bulletscreen_switch");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.isFirstCreat = true;
        this.landscapeDmButton = (ImageView) rootView.findViewById(R.id.f56772li);
        this.verticalDmButton = (ImageView) rootView.findViewById(R.id.f112796ow);
        if (!n.b().d()) {
            ImageView imageView = this.landscapeDmButton;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.verticalDmButton;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        r1();
        ImageView imageView3 = this.landscapeDmButton;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: rx2.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.m1(f.this, view);
                }
            });
        }
        ImageView imageView4 = this.verticalDmButton;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: rx2.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.n1(f.this, view);
                }
            });
        }
        s1(this.landscapeDmButton);
        s1(this.verticalDmButton);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        this.videoFeed = jy2.g.q(data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        if (n.b().d() && !jy2.g.A(this.videoFeed)) {
            ImageView imageView = this.landscapeDmButton;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.verticalDmButton;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            r1();
            if (!jy2.g.E((FeedCloudMeta$StFeed) this.f85017h) && !jy2.g.z((FeedCloudMeta$StFeed) this.f85017h)) {
                p1();
                return;
            }
            return;
        }
        ImageView imageView3 = this.landscapeDmButton;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = this.verticalDmButton;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        if (n.b().d() && !this.isFirstCreat) {
            p1();
        }
        this.isFirstCreat = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "TVideoDmButtonPresenter";
    }
}
