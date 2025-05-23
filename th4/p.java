package th4;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.timi.game.component.chat.ChatView;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$YoloRoomRotateMsg;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCommonConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomRotateMessage;
import trpc.yes.wuji.WujiSafeOuterClass$WujiSafeConf;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00032\u00020\u0001:\u0001\fB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0013\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lth4/p;", "", "Lcom/tencent/timi/game/tim/api/message/a;", "f", "", WidgetCacheConstellationData.NUM, "", "g", "Lcom/tencent/timi/game/component/chat/ChatView;", "chatView", "c", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "a", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "e", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "setQqUserId", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;)V", "qqUserId", "", "b", "J", "getRoomId", "()J", "setRoomId", "(J)V", "roomId", "d", "setChatId", "chatId", "I", "getLastTimeInsertMsgNum", "()I", "setLastTimeInsertMsgNum", "(I)V", "lastTimeInsertMsgNum", "Ltrpc/yes/common/MessageOuterClass$YoloRoomRotateMsg;", "Ltrpc/yes/common/MessageOuterClass$YoloRoomRotateMsg;", "getRotateMsg", "()Ltrpc/yes/common/MessageOuterClass$YoloRoomRotateMsg;", "setRotateMsg", "(Ltrpc/yes/common/MessageOuterClass$YoloRoomRotateMsg;)V", "rotateMsg", "<init>", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;JJ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class p {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private static p f436365g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CommonOuterClass$QQUserId qqUserId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long chatId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int lastTimeInsertMsgNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageOuterClass$YoloRoomRotateMsg rotateMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lth4/p$a;", "", "Lth4/p;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lth4/p;", "a", "()Lth4/p;", "b", "(Lth4/p;)V", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: th4.p$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final p a() {
            return p.f436365g;
        }

        public final void b(@Nullable p pVar) {
            p.f436365g = pVar;
        }

        Companion() {
        }
    }

    public p(@NotNull CommonOuterClass$QQUserId qqUserId, long j3, long j16) {
        YoloRoomOuterClass$YoloRoomRotateMessage yoloRoomOuterClass$YoloRoomRotateMessage;
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        this.qqUserId = qqUserId;
        this.roomId = j3;
        this.chatId = j16;
        this.lastTimeInsertMsgNum = -1;
        List<YoloRoomOuterClass$YoloRoomRotateMessage> R2 = ((j05.b) mm4.b.b(j05.b.class)).R2();
        ArrayList<YoloRoomOuterClass$YoloRoomRotateMessage> arrayList = new ArrayList();
        Iterator<T> it = R2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((YoloRoomOuterClass$YoloRoomRotateMessage) next).message_type.get() == 1) {
                arrayList.add(next);
            }
        }
        for (YoloRoomOuterClass$YoloRoomRotateMessage yoloRoomOuterClass$YoloRoomRotateMessage2 : arrayList) {
            if (this.rotateMsg == null) {
                MessageOuterClass$YoloRoomRotateMsg messageOuterClass$YoloRoomRotateMsg = new MessageOuterClass$YoloRoomRotateMsg();
                this.rotateMsg = messageOuterClass$YoloRoomRotateMsg;
                YoloRoomOuterClass$YoloRoomRotateMessage yoloRoomOuterClass$YoloRoomRotateMessage3 = messageOuterClass$YoloRoomRotateMsg.yolo_room_rotate_message;
                if (yoloRoomOuterClass$YoloRoomRotateMessage3 != null) {
                    yoloRoomOuterClass$YoloRoomRotateMessage3.set(yoloRoomOuterClass$YoloRoomRotateMessage2);
                }
            }
        }
        if (this.rotateMsg == null) {
            this.rotateMsg = new MessageOuterClass$YoloRoomRotateMsg();
            YoloRoomOuterClass$YoloRoomRotateMessage yoloRoomOuterClass$YoloRoomRotateMessage4 = new YoloRoomOuterClass$YoloRoomRotateMessage();
            yoloRoomOuterClass$YoloRoomRotateMessage4.message_type.set(1);
            yoloRoomOuterClass$YoloRoomRotateMessage4.message_tpl.set("\u7cfb\u7edf\u63d0\u793a\uff1a\u7528QQ\u5f00\u9ed1\u4ea4\u53cb\u5927\u5385\u8fdb\u884c\u4e92\u52a8\u65f6\uff0c\u4e25\u7981\u4f20\u64ad\u542b\u6709\u8fdd\u6cd5\u8fdd\u89c4\u3001\u9020\u8c23\u4f20\u8c23\u3001\u8bc5\u5492\u6076\u641e\u3001\u8272\u60c5\u4f4e\u4fd7\u3001\u5ba3\u4f20\u552e\u5356\u975e\u6cd5\u7269\u54c1\u3001\u5bfc\u6d41\u5e7f\u544a\u7c7b\u7b49\u8fdd\u89c4\u5185\u5bb9\u3002\u5982\u6709\u8fdd\u89c4\uff0c\u5c06\u5f71\u54cd\u4ea4\u53cb\u529f\u80fd\u7684\u4f7f\u7528\uff0c\u8fdd\u89c4\u4e25\u91cd\u65f6\u66f4\u4f1a\u5f71\u54cdQQ\u8d26\u53f7\u7684\u4f7f\u7528\u3002");
            MessageOuterClass$YoloRoomRotateMsg messageOuterClass$YoloRoomRotateMsg2 = this.rotateMsg;
            if (messageOuterClass$YoloRoomRotateMsg2 != null && (yoloRoomOuterClass$YoloRoomRotateMessage = messageOuterClass$YoloRoomRotateMsg2.yolo_room_rotate_message) != null) {
                yoloRoomOuterClass$YoloRoomRotateMessage.set(yoloRoomOuterClass$YoloRoomRotateMessage4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, trpc.yes.common.MessageOuterClass$MsgContent] */
    private final com.tencent.timi.game.tim.api.message.a f() {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = NetConnInfoCenter.getServerTime() * 1000;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
        objectRef.element = messageOuterClass$MsgContent;
        MessageOuterClass$YoloRoomRotateMsg messageOuterClass$YoloRoomRotateMsg = messageOuterClass$MsgContent.yolo_room_rotate_msg;
        MessageOuterClass$YoloRoomRotateMsg messageOuterClass$YoloRoomRotateMsg2 = this.rotateMsg;
        Intrinsics.checkNotNull(messageOuterClass$YoloRoomRotateMsg2);
        messageOuterClass$YoloRoomRotateMsg.set(messageOuterClass$YoloRoomRotateMsg2);
        return new b(longRef, this, objectRef);
    }

    public final void c(@NotNull ChatView chatView) {
        int i3;
        YoloRoomOuterClass$YoloRoomConf Y;
        YoloRoomOuterClass$YoloRoomCommonConf yoloRoomOuterClass$YoloRoomCommonConf;
        WujiSafeOuterClass$WujiSafeConf wujiSafeOuterClass$WujiSafeConf;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(chatView, "chatView");
        gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId);
        if (K0 != null && (Y = K0.Y()) != null && (yoloRoomOuterClass$YoloRoomCommonConf = Y.yolo_room_common_conf) != null && (wujiSafeOuterClass$WujiSafeConf = yoloRoomOuterClass$YoloRoomCommonConf.safe_conf) != null && (pBInt32Field = wujiSafeOuterClass$WujiSafeConf.system_notice_message_num) != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            i3 = 100;
        }
        if ((this.lastTimeInsertMsgNum == -1 || chatView.l() - this.lastTimeInsertMsgNum >= i3) && this.rotateMsg != null) {
            chatView.q(f());
            this.lastTimeInsertMsgNum = chatView.l();
        }
    }

    /* renamed from: d, reason: from getter */
    public final long getChatId() {
        return this.chatId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final CommonOuterClass$QQUserId getQqUserId() {
        return this.qqUserId;
    }

    public final void g(int num) {
        int i3 = this.lastTimeInsertMsgNum;
        if (i3 != -1) {
            this.lastTimeInsertMsgNum = i3 + num;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016\u00a8\u0006\""}, d2 = {"th4/p$b", "Lcom/tencent/timi/game/tim/api/message/a;", "", "id", "", "l", "", "type", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "c", "time", "Lcom/tencent/timi/game/tim/api/message/MsgStatus;", tl.h.F, "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "a", "g", "j", "f", "", "b", "i", "data", "", "k", "p", "value", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "d", "e", "status", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements com.tencent.timi.game.tim.api.message.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f436371a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f436372b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<MessageOuterClass$MsgContent> f436373c;

        b(Ref.LongRef longRef, p pVar, Ref.ObjectRef<MessageOuterClass$MsgContent> objectRef) {
            this.f436371a = longRef;
            this.f436372b = pVar;
            this.f436373c = objectRef;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        @NotNull
        public MessageOuterClass$MsgContent a() {
            return this.f436373c.element;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public boolean b() {
            return false;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        @NotNull
        public CommonOuterClass$QQUserId c() {
            return this.f436372b.getQqUserId();
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        @Nullable
        /* renamed from: d */
        public Object getMemData() {
            return null;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public long f() {
            return this.f436372b.getChatId();
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        @NotNull
        public String g() {
            return "";
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        @NotNull
        public MsgStatus h() {
            return MsgStatus.SUCCESS;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public boolean i() {
            return true;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        @NotNull
        public String id() {
            return String.valueOf(this.f436371a.element);
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public long j() {
            return this.f436372b.getChatId();
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public void k(@NotNull String data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public long l() {
            return 0L;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public int m() {
            return 0;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public int o() {
            return -1;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        @NotNull
        public String p() {
            return "";
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public void q(@NotNull MsgStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public long time() {
            return this.f436371a.element;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public int type() {
            return 63;
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public void e(@Nullable Object data) {
        }

        @Override // com.tencent.timi.game.tim.api.message.a
        public void n(int value) {
        }
    }
}
