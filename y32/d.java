package y32;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f\u001a\u0006\u0010\u000f\u001a\u00020\u0002\u001a\"\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u001a\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0016\u001a\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u001a\u0006\u0010 \u001a\u00020\u0002\u001a\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u001a\u001e\u0010%\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"\u001a\u0016\u0010'\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\"\u001a\u000e\u0010(\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010)\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010*\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010+\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010,\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\"\u001a\u000e\u0010-\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010.\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a \u0010/\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u001a\u0018\u00100\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u001a\u0006\u00101\u001a\u00020\u0002\u001a\u0006\u00102\u001a\u00020\u0002\u001a\u0006\u00103\u001a\u00020\u0002\u001a\u0006\u00104\u001a\u00020\u0002\u001a\u0006\u00105\u001a\u00020\u0002\u00a8\u00066"}, d2 = {"", "roomId", "", "g", h.F, "f", "i", "e", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "d", "Lcom/tencent/mobileqq/qqlive/data/room/QQLiveRoomStatusInfo;", "info", "D", "E", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "B", "startTime", "", "c", "t", "u", "v", "w", "", "errorCode", "errorMessage", HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "isPageClosed", "shouldExitRoom", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, MiniChatConstants.MINI_APP_LANDSCAPE, "k", "j", DomainData.DOMAIN_NAME, "o", "p", "J", UserInfo.SEX_FEMALE, "G", "H", ReportConstant.COSTREPORT_PREFIX, "a", "b", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {
    public static final void A(long j3, boolean z16, boolean z17) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageOut", "roomId=" + j3 + " isPageClosed=" + z16 + " shouldExitRoom=" + z17);
    }

    public static final void B(long j3, @Nullable String str, @Nullable LiveRoomExtraInfo liveRoomExtraInfo) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPagePreLoad", "roomId: " + j3 + " url: " + str);
    }

    public static final void C(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onRealActivityDestroy", "roomId:" + j3);
    }

    public static final void D(@NotNull QQLiveRoomStatusInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        rt0.a.INSTANCE.k("ICGameAudienceView", "onRoomClose", "closeType: " + info.closeType + ", closeReason: " + info.closeReason);
    }

    public static final void E() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onRoomClose", "uid not match");
    }

    public static final void F(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onRoomClosed", "roomId: " + j3);
    }

    public static final void G(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onRoomClosed", "exitRoom success roomId:" + j3);
    }

    public static final void H(long j3, int i3, @Nullable String str) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onRoomClosed", "exit room " + j3 + " failed: " + i3 + " " + str);
    }

    public static final void I() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "resetGiftBannerContainer", "gift panel show, do not reset gift container");
    }

    public static final void J(long j3, boolean z16) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "switchScreen", "roomId: " + j3 + ", isLandscape " + z16);
    }

    public static final void a() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "doUnFollowAction", "on unfollow success");
    }

    public static final void b() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "doUnFollowAction", "on unfollow failed");
    }

    public static final void c(@NotNull String startTime, @NotNull Throwable e16) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(e16, "e");
        rt0.a.INSTANCE.k("ICGameAudienceView", "getJumpStartTime", "startTime:" + startTime + " format error" + e16);
    }

    public static final void d() {
        rt0.a.INSTANCE.j("ICGameAudienceView", "init");
    }

    public static final void e(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onActivityDestroy", "roomId:" + j3);
    }

    public static final void f(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onActivityPause", "roomId:" + j3);
    }

    public static final void g(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onActivityResume", "roomId:" + j3);
    }

    public static final void h(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onActivityStart", "roomId:" + j3);
    }

    public static final void i(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onActivityStop", "roomId:" + j3);
    }

    public static final void j(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onBackPressed", "roomId: " + j3);
    }

    public static final void k(long j3, boolean z16) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onConfigurationChanged", "landscape " + z16 + " roomId:" + j3);
    }

    public static final void l(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "roomId:" + j3);
    }

    public static final void m(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", NodeProps.ON_DETACHED_FROM_WINDOW, "roomId:" + j3);
    }

    public static final void n(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onEnterRoom", "roomId: " + j3);
    }

    public static final void o(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onEnterRoom", "audienceRoom=null, roomId: " + j3);
    }

    public static final void p(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onExitRoom", "roomId: " + j3);
    }

    public static final void q() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onFloatCloseRoom", "onFloatCloseRoom, roomId not match");
    }

    public static final void r() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onFloatCloseRoom", "onFloatCloseRoom");
    }

    public static final void s(int i3, @Nullable String str) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "showLiveEndView", "onFollowClickAction onFail:error_code:" + i3 + " errMsg:" + str);
    }

    public static final void t(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageIn", "roomId:" + j3);
    }

    public static final void u(long j3) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageIn", "enter room after UI destroyed!! roomId:" + j3);
    }

    public static final void v() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageIn", "enter room success");
    }

    public static final void w() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageIn", "he room was closed");
    }

    public static final void x(int i3, @Nullable String str) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageIn", "onPageIn audienceEnterRoom onError " + i3 + ", " + str);
    }

    public static final void y() {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageIn", "view destroyed, do nothing");
    }

    public static final void z(int i3, @Nullable String str) {
        rt0.a.INSTANCE.k("ICGameAudienceView", "onPageIn", "report audienceEnterRoom onError " + i3 + "," + str);
    }
}
