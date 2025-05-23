package xj4;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.userlevel.IQQLiveUserLevelChangeListener;
import com.tencent.mobileqq.qqlive.callback.userlevel.UserLevelUpgrade;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\b\u0017\u001b\u001f#'+37\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b:\u0010;J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00108\u00a8\u0006="}, d2 = {"Lxj4/g;", "Lxj4/a;", "", "roomId", "Lxj4/b;", "receiver", "", "isAnchor", "", "a", "unregister", "d", "Lxj4/b;", "e", "J", "f", "Z", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveReceiveMessageListener;", tl.h.F, "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveReceiveMessageListener;", "iQQLiveReceiveMessageListener", "i", "iQQLiveSysMessageListener", "xj4/g$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxj4/g$c;", "iQQLiveAnnouncePushListener", "xj4/g$d", BdhLogUtil.LogTag.Tag_Conn, "Lxj4/g$d;", "iQQLiveReceiveFollowListener", "xj4/g$g", "D", "Lxj4/g$g;", "roomAudienceInfoListener", "xj4/g$h", "E", "Lxj4/g$h;", "roomLikeInfoListener", "xj4/g$f", UserInfo.SEX_FEMALE, "Lxj4/g$f;", "receiveGiftMessageListener", "xj4/g$b", "G", "Lxj4/g$b;", "cmdListener", "Lcom/tencent/mobileqq/qqlive/callback/userlevel/IQQLiveUserLevelChangeListener;", "H", "Lcom/tencent/mobileqq/qqlive/callback/userlevel/IQQLiveUserLevelChangeListener;", "userLevelUpgradeListener", "xj4/g$e", "I", "Lxj4/g$e;", "iQQLiveReceiveRoomFollowListener", "xj4/g$i", "Lxj4/g$i;", "timiCmdListener", "<init>", "()V", "K", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class g implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private xj4.b receiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener = new IQQLiveReceiveMessageListener() { // from class: xj4.d
        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener
        public final void onMessageReceive(LiveMessageData liveMessageData) {
            g.f(g.this, liveMessageData);
        }
    };

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveReceiveMessageListener iQQLiveSysMessageListener = new IQQLiveReceiveMessageListener() { // from class: xj4.e
        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener
        public final void onMessageReceive(LiveMessageData liveMessageData) {
            g.g(g.this, liveMessageData);
        }
    };

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c iQQLiveAnnouncePushListener = new c();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d iQQLiveReceiveFollowListener = new d();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final C11551g roomAudienceInfoListener = new C11551g();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final h roomLikeInfoListener = new h();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final f receiveGiftMessageListener = new f();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b cmdListener = new b();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IQQLiveUserLevelChangeListener userLevelUpgradeListener = new IQQLiveUserLevelChangeListener() { // from class: xj4.f
        @Override // com.tencent.mobileqq.qqlive.callback.userlevel.IQQLiveUserLevelChangeListener
        public final void userLevelChanged(UserLevelUpgrade userLevelUpgrade) {
            g.h(g.this, userLevelUpgrade);
        }
    };

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final e iQQLiveReceiveRoomFollowListener = new e();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final i timiCmdListener = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"xj4/g$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IQQCmdPushCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "onCmdFail", "errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.K(data);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"xj4/g$c", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "announcePushMessage", "", "onAnnounceReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IQQLiveAnnouncePushListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener
        public void onAnnounceReceive(@NotNull AnnouncePushMessage announcePushMessage) {
            Intrinsics.checkNotNullParameter(announcePushMessage, "announcePushMessage");
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.Q(announcePushMessage);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "onAnnounceFail", "errCode=" + errCode + ", errMsg=" + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"xj4/g$d", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "", "onFollowReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IQQLiveReceiveFollowListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "onFollowFail", "errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFollowReceive(@NotNull FollowPushMessage followPushMessage) {
            Intrinsics.checkNotNullParameter(followPushMessage, "followPushMessage");
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.J(followPushMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"xj4/g$e", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "", "onFollowReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements IQQLiveReceiveFollowListener {
        e() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "onRoomFollowFail", "errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFollowReceive(@NotNull FollowPushMessage followPushMessage) {
            Intrinsics.checkNotNullParameter(followPushMessage, "followPushMessage");
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.F(followPushMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"xj4/g$f", "Lcom/tencent/mobileqq/qqlive/callback/gift/ReceiveGiftMessageListener;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "giftMessage", "", "onGiftMessageReceive", "", "code", "", "msg", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements ReceiveGiftMessageListener {
        f() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onError(int code, @Nullable String msg2) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "onGiftFail", "errCode=" + code + ", errMsg=" + msg2);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onGiftMessageReceive(@NotNull GiftMessage giftMessage) {
            Intrinsics.checkNotNullParameter(giftMessage, "giftMessage");
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.onGiftMessageReceive(giftMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"xj4/g$i", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class i implements IQQCmdPushCallback {
        i() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "onTimiCmdFail", "errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.O(data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(g this$0, LiveMessageData messageData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xj4.b bVar = this$0.receiver;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(messageData, "messageData");
            bVar.D(messageData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(g this$0, LiveMessageData messageData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xj4.b bVar = this$0.receiver;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(messageData, "messageData");
            bVar.P(messageData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(g this$0, UserLevelUpgrade upgradeInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xj4.b bVar = this$0.receiver;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(upgradeInfo, "upgradeInfo");
            bVar.A(upgradeInfo);
        }
    }

    @Override // xj4.a
    public void a(long roomId, @NotNull xj4.b receiver, boolean isAnchor) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        AegisLogger.INSTANCE.i("Chat_Message|MessagePushMgr", "OldMessagePushMgr register");
        this.roomId = roomId;
        this.receiver = receiver;
        this.isAnchor = isAnchor;
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(roomId);
        if (k3 != null) {
            k3.registerRoomChatMsgListener(this.iQQLiveReceiveMessageListener);
            k3.registerSystemMsgListener(this.iQQLiveSysMessageListener);
            k3.registerAnnounceMessageListener(this.iQQLiveAnnouncePushListener);
            k3.registerFollowMessageListener(this.iQQLiveReceiveFollowListener);
            k3.registerAudienceInfoListener(this.roomAudienceInfoListener);
            k3.registerOnReceiveFloatHeartListener(this.roomLikeInfoListener);
            k3.registerReceiveGiftMessageListener(this.receiveGiftMessageListener);
            pj4.k kVar = pj4.k.f426383a;
            k3.registerLowPriorityListener(kVar.a(), this.cmdListener);
            k3.registerHighPriorityListener(kVar.a(), this.cmdListener);
            k3.registerUserLevelChangedListener(this.userLevelUpgradeListener);
            k3.registerRoomFollowListener(this.iQQLiveReceiveRoomFollowListener);
        }
        ((jg4.b) mm4.b.b(jg4.b.class)).Y1(isAnchor).a(this.timiCmdListener);
    }

    @Override // xj4.a
    public void unregister() {
        AegisLogger.INSTANCE.i("Chat_Message|MessagePushMgr", "OldMessagePushMgr unregister");
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(this.roomId);
        if (k3 != null) {
            k3.unRegisterRoomChatMsgListener(this.iQQLiveReceiveMessageListener);
            k3.unRegisterSystemMsgListener(this.iQQLiveSysMessageListener);
            k3.unRegisterAnnounceMessageListener(this.iQQLiveAnnouncePushListener);
            k3.unRegisterFollowMessageListener(this.iQQLiveReceiveFollowListener);
            k3.unRegisterAudienceInfoListener(this.roomAudienceInfoListener);
            k3.unRegisterOnReceiveFloatHeartListener(this.roomLikeInfoListener);
            k3.unRegisterReceiveGiftMessageListener(this.receiveGiftMessageListener);
            pj4.k kVar = pj4.k.f426383a;
            k3.unRegisterLowPriorityListener(kVar.a(), this.cmdListener);
            k3.unRegisterHighPriorityListener(kVar.a(), this.cmdListener);
            k3.unRegisterUserLevelChangedListener(this.userLevelUpgradeListener);
            k3.unRegisterRoomFollowListener(this.iQQLiveReceiveRoomFollowListener);
        }
        ((jg4.b) mm4.b.b(jg4.b.class)).Y1(this.isAnchor).b(this.timiCmdListener);
        this.receiver = null;
        this.roomId = 0L;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"xj4/g$g", "Lcom/tencent/mobileqq/qqlive/callback/room/RoomAudienceInfoListener;", "Lcom/tencent/mobileqq/qqlive/data/room/RoomAudienceInfo;", "info", "", "onRecAudienceInfo", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "onAudienceEnterRoom", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xj4.g$g, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11551g implements RoomAudienceInfoListener {
        C11551g() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onAudienceEnterRoom(@NotNull LiveMessageData.SpeakerInfo audienceInfo) {
            Intrinsics.checkNotNullParameter(audienceInfo, "audienceInfo");
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.G(audienceInfo);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onRecAudienceInfo(@Nullable RoomAudienceInfo info) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J1\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"xj4/g$h", "Lji2/a;", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "broadCastFreeLove", "", "onReceiveRoomLikePush", "", "uid", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/heart/FreeLove;", "freeLoves", "", "fromBroadCast", "onReceiveFreeLove", "(JLjava/util/ArrayList;Ljava/lang/Boolean;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h implements ji2.a {
        h() {
        }

        @Override // ji2.a
        public void onReceiveRoomLikePush(@Nullable QLBroadCastFreeLove broadCastFreeLove) {
            xj4.b bVar = g.this.receiver;
            if (bVar != null) {
                bVar.x(broadCastFreeLove);
            }
        }

        @Override // ji2.a
        public void onReceiveFreeLove(long uid, @Nullable ArrayList<FreeLove> freeLoves, @Nullable Boolean fromBroadCast) {
        }
    }
}
