package tv0;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.util.l;
import com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.IQQLiveFeedback;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import rv0.ShowControllerUIEvent;
import tl.h;
import uv0.d;
import uv0.e;
import uv0.f;

/* compiled from: P */
@ComponentEvent(eventList = {uv0.c.class, d.class, uv0.b.class, f.class, e.class, ShowControllerUIEvent.class, uv0.a.class, com.tencent.icgame.game.liveroom.impl.room.roomconfig.b.class})
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00013\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0006R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00102R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00104\u00a8\u0006;"}, d2 = {"Ltv0/a;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "", "B", "Lcom/tencent/mobileqq/icgame/api/room/ILiveAudienceTPPlayerRoom;", HippyTKDListViewAdapter.X, "k", "i", "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N", "K", BdhLogUtil.LogTag.Tag_Conn, "J", "G", "H", MiniChatConstants.MINI_APP_LANDSCAPE, UserInfo.SEX_FEMALE, "D", "E", "I", "isEnable", "L", "", "roomId", "showTips", "M", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lh22/a;", "setQqLiveRoomService", "(Lh22/a;)V", "Lvv0/a;", "operationBarSupport", "Lvv0/a;", "y", "()Lvv0/a;", "setOperationBarSupport", "(Lvv0/a;)V", "Lfu0/c;", h.F, "Lfu0/c;", "liveRoomService", "Z", "tv0/a$b", "Ltv0/a$b;", "audienceRoomPlayerListener", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a extends SingleUIComponent<AudienceOperationBarView> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fu0.c liveRoomService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b audienceRoomPlayerListener;

    @InjectService(key = vv0.a.class)
    public vv0.a operationBarSupport;

    @InjectService(key = h22.a.class)
    public h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"tv0/a$b", "Lb32/a;", "Lcom/tencent/mobileqq/icgame/api/room/StreamType;", "streamType", "", "url", "Lcom/tencent/mobileqq/icgame/api/room/PlayerConfig;", "playerConfig", "", "onPreparing", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends b32.a {
        b() {
        }

        @Override // b32.a
        public void onPreparing(@Nullable StreamType streamType, @Nullable String url, @Nullable PlayerConfig playerConfig) {
            boolean z16;
            a.Companion companion = rt0.a.INSTANCE;
            StreamType streamType2 = StreamType.FLV;
            boolean z17 = true;
            if (streamType == streamType2) {
                z16 = true;
            } else {
                z16 = false;
            }
            companion.k("ICGameUnknown|ICGameAudienceOperationBarComponent", "setSwitchDefinitionEnable", "streamType:" + streamType + "is enable:" + z16);
            a aVar = a.this;
            if (streamType != streamType2) {
                z17 = false;
            }
            aVar.L(z17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"tv0/a$c", "Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceOperationBarView$b;", "", "j", "a", h.F, "d", "c", "b", "g", "e", "i", "Lep4/b;", "freeLove", "f", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements AudienceOperationBarView.b {
        c() {
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void a() {
            ((IQQLiveFeedback) QRoute.api(IQQLiveFeedback.class)).openFeedbackActivity(Foreground.getTopActivity(), a.this.liveRoomService.f());
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void b() {
            a.this.w();
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void c() {
            a.this.getComponentContext().w0(new d());
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void d() {
            a.this.getComponentContext().w0(new e());
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void e() {
            ry0.a.INSTANCE.e(a.u(a.this));
            Context context = a.this.getComponentContext().getContext();
            boolean z16 = context instanceof Activity;
            if (!z16) {
                QLog.e("ICGameUnknown|ICGameAudienceOperationBarComponent", 1, "getHostActivity is null");
            }
            if (!z16) {
                context = null;
            }
            if (context != null) {
                a aVar = a.this;
                a.u(aVar).getBottomConfigModel().p((Activity) context, aVar.getComponentContext().getContext(), aVar.z(), a.u(aVar).getBottomConfigModel().i(), this);
            }
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void f(@NotNull ep4.b freeLove) {
            Intrinsics.checkNotNullParameter(freeLove, "freeLove");
            a.this.getComponentContext().w0(new com.tencent.icgame.game.liveroom.impl.room.roomconfig.b(freeLove));
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void g() {
            a.this.getComponentContext().w0(new uv0.c());
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void h() {
            a.this.getComponentContext().w0(new f());
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void i() {
            a.this.getComponentContext().w0(new uv0.a());
        }

        @Override // com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView.b
        public void j() {
            a.this.getComponentContext().w0(new uv0.b());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        mm4.a b16 = qx0.a.b(fu0.c.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        this.liveRoomService = (fu0.c) b16;
        this.audienceRoomPlayerListener = new b();
    }

    private final void A() {
        p().setAnchorOperationViewListener(new c());
    }

    private final boolean B() {
        return ((fu0.c) qx0.a.b(fu0.c.class)).I(z().getRoomId());
    }

    public static final /* synthetic */ AudienceOperationBarView u(a aVar) {
        return aVar.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        yw0.h.x(getComponentContext().getContext(), z().getRoomId(), z().getExtraInfo());
        l.b(z().getRoomId(), 1);
    }

    private final ILiveAudienceTPPlayerRoom x() {
        IAudienceRoom y16 = this.liveRoomService.y(z().getRoomId());
        if (y16 instanceof ILiveAudienceTPPlayerRoom) {
            return (ILiveAudienceTPPlayerRoom) y16;
        }
        return null;
    }

    public final void C() {
        p().A();
    }

    public final void D() {
        StreamType streamType;
        LiveInfo curLiveInfo;
        LiveAnchorInfo anchorInfo;
        boolean z16 = false;
        p().B(z().getRoomId(), false);
        p().w(z().getRoomId(), z().getExtraInfo());
        LiveRoomExtraInfo extraInfo = z().getExtraInfo();
        if (extraInfo != null && (curLiveInfo = z().getCurLiveInfo()) != null && (anchorInfo = curLiveInfo.anchorInfo) != null) {
            Intrinsics.checkNotNullExpressionValue(anchorInfo, "anchorInfo");
            p().H(extraInfo, anchorInfo, z().getRoomId());
        }
        if (z().getRoomType() == 1) {
            if (B()) {
                p().setVisibility(8);
            } else {
                p().setVisibility(0);
            }
        } else {
            p().setVisibility(0);
        }
        ILiveAudienceTPPlayerRoom x16 = x();
        if (x16 != null) {
            streamType = x16.getStreamType();
        } else {
            streamType = null;
        }
        rt0.a.INSTANCE.k("ICGameUnknown|ICGameAudienceOperationBarComponent", "onEnterRoom", "streamType:" + streamType);
        if (streamType == StreamType.FLV) {
            z16 = true;
        }
        L(z16);
        ILiveAudienceTPPlayerRoom x17 = x();
        if (x17 != null) {
            x17.registerRoomPlayerListener(this.audienceRoomPlayerListener);
        }
    }

    public final void E() {
        ILiveAudienceTPPlayerRoom x16 = x();
        if (x16 != null) {
            x16.unRegisterRoomPlayerListener(this.audienceRoomPlayerListener);
        }
        p().C(z().getRoomId());
        ry0.a.INSTANCE.d(p());
    }

    public final void F(boolean isLandscape) {
        this.isLandscape = isLandscape;
        p().D(isLandscape);
        ry0.a.INSTANCE.d(p());
    }

    public final void G() {
        p().E(z().getRoomId());
    }

    public final void H() {
        p().F(z().getRoomId());
        p().setTeamConditionSettingVisibility(false);
    }

    public final void I() {
        p().getBottomConfigModel().j();
    }

    public final void J() {
        p().G(z().getRoomId(), false, z().getPreLoadVideoUrl());
    }

    public final void K() {
        p().setContentByConfig(z().getRoomId());
    }

    public final void L(boolean isEnable) {
        p().getBottomConfigModel().n(isEnable);
    }

    public final void M(long roomId, boolean showTips) {
        long roomId2 = z().getRoomId();
        if (roomId2 != roomId) {
            rt0.a.INSTANCE.k("ICGameUnknown|ICGameAudienceOperationBarComponent", "showDefinitionTips", "fail, roomId=" + roomId + ", curRoom=" + roomId2);
            return;
        }
        rt0.a.INSTANCE.k("ICGameUnknown|ICGameAudienceOperationBarComponent", "showDefinitionTips", "roomId=" + roomId + ", showTips=" + showTips);
        if (showTips) {
            View y16 = p().y();
            if (this.isLandscape) {
                y16 = y().a();
                if (y16 == null) {
                    return;
                } else {
                    getComponentContext().w0(new ShowControllerUIEvent(true));
                }
            }
            ry0.a.INSTANCE.i(getComponentContext(), p(), y16);
            return;
        }
        ry0.a.INSTANCE.e(p());
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        A();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.u2z;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public AudienceOperationBarView n() {
        AudienceOperationBarView audienceOperationBarView = new AudienceOperationBarView(getComponentContext().getContext(), null, 0, 6, null);
        audienceOperationBarView.setOperationBarSupport(y());
        audienceOperationBarView.setRoomType(z().getRoomType());
        return audienceOperationBarView;
    }

    @NotNull
    public final vv0.a y() {
        vv0.a aVar = this.operationBarSupport;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("operationBarSupport");
        return null;
    }

    @NotNull
    public final h22.a z() {
        h22.a aVar = this.qqLiveRoomService;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        return null;
    }

    public final void N() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }
}
