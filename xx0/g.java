package xx0;

import com.tencent.icgame.game.tim.api.message.MsgStatus;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TextMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xx0.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u00182\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010$\u001a\u00020 \u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\u0013\u0010\u001e\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R$\u0010,\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010/R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00103R\u0014\u00105\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00101\u00a8\u00068"}, d2 = {"Lxx0/g;", "Lcom/tencent/icgame/game/tim/api/message/a;", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "id", "", "type", "", "time", "Lcom/tencent/icgame/game/tim/api/message/MsgStatus;", h.F, "status", "", "k", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "c", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "a", "g", "j", "f", "", "b", "i", "", "d", "data", "e", "other", "equals", "hashCode", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "l", "()Lcom/tencent/imsdk/v2/V2TIMMessage;", "v2TIMMessage", "Ljava/lang/String;", "TAG", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "getContent", "()Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "setContent", "(Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;)V", "content", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "msgRecord", "Lcom/tencent/icgame/game/tim/api/message/MsgStatus;", "innerStatus", "J", "timeDebug", "Ljava/lang/Object;", "memData", "createTimeStamp", "<init>", "(Lcom/tencent/imsdk/v2/V2TIMMessage;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class g implements com.tencent.icgame.game.tim.api.message.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final V2TIMMessage v2TIMMessage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageOuterClass$MsgContent content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageOuterClass$TimMsgBody msgRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgStatus innerStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long timeDebug;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object memData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long createTimeStamp;

    public g(@NotNull V2TIMMessage v2TIMMessage) {
        Intrinsics.checkNotNullParameter(v2TIMMessage, "v2TIMMessage");
        this.v2TIMMessage = v2TIMMessage;
        this.TAG = "ICGameMessageInfo";
        this.createTimeStamp = cy0.c.d() / 1000;
        this.timeDebug = v2TIMMessage.getTimestamp() * 1000;
    }

    private final MessageOuterClass$TimMsgBody m() {
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody;
        if (this.v2TIMMessage.getElemType() != 2) {
            return new MessageOuterClass$TimMsgBody();
        }
        if (this.msgRecord == null) {
            try {
                messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody().mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(this.v2TIMMessage.getCustomElem().getData(), 2));
            } catch (InvalidProtocolBufferMicroException unused) {
                com.tencent.icgame.game.utils.g.h(this.TAG, "parse error:" + this.v2TIMMessage.getCustomElem());
                messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
                messageOuterClass$TimMsgBody.msg_type.set(1);
                MessageOuterClass$MsgContent messageOuterClass$MsgContent = messageOuterClass$TimMsgBody.content;
                MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = new MessageOuterClass$MsgContent();
                MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent2.text_msg;
                MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
                messageOuterClass$TextMsg2.text.set("[\u6536\u5230\u4e00\u6761\u6d88\u606f\uff0c\u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301\u67e5\u770b\uff0c\u8bf7\u66f4\u65b0\u81f3\u65b0\u7248\u672c]");
                messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
                messageOuterClass$MsgContent.set(messageOuterClass$MsgContent2);
            }
            this.msgRecord = messageOuterClass$TimMsgBody;
        }
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody2 = this.msgRecord;
        Intrinsics.checkNotNull(messageOuterClass$TimMsgBody2);
        return messageOuterClass$TimMsgBody2;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    @NotNull
    public MessageOuterClass$MsgContent a() {
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        if (this.content == null) {
            if (this.v2TIMMessage.getElemType() == 1) {
                f.Companion companion = f.INSTANCE;
                String text = this.v2TIMMessage.getTextElem().getText();
                Intrinsics.checkNotNullExpressionValue(text, "v2TIMMessage.textElem.text");
                messageOuterClass$MsgContent = companion.a(text);
            } else {
                messageOuterClass$MsgContent = m().content;
            }
            this.content = messageOuterClass$MsgContent;
        }
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = this.content;
        if (messageOuterClass$MsgContent2 == null) {
            return new MessageOuterClass$MsgContent();
        }
        return messageOuterClass$MsgContent2;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public boolean b() {
        return this.v2TIMMessage.isSelf();
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    @NotNull
    public CommonOuterClass$QQUserId c() {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = m().from_user;
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "msgRecord().from_user");
        return commonOuterClass$QQUserId;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    @Nullable
    /* renamed from: d, reason: from getter */
    public Object getMemData() {
        return this.memData;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public void e(@Nullable Object data) {
        this.memData = data;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(g.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.icgame.game.tim.api.impl.message.MsgInfo");
        if (Intrinsics.areEqual(id(), ((g) other).id())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public long f() {
        ULong uLongOrNull;
        String userID = this.v2TIMMessage.getUserID();
        if (userID != null && (uLongOrNull = UStringsKt.toULongOrNull(userID)) != null) {
            return uLongOrNull.getData();
        }
        return 0L;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    @NotNull
    public String g() {
        String str = m().update_text.get();
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord().update_text.get()");
        return str;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    @NotNull
    public MsgStatus h() {
        MsgStatus msgStatus = this.innerStatus;
        if (msgStatus != null) {
            Intrinsics.checkNotNull(msgStatus);
            return msgStatus;
        }
        int status = this.v2TIMMessage.getStatus();
        if (status != 1) {
            if (status != 2) {
                if (status != 3) {
                    if (status != 4) {
                        if (status != 6) {
                            return MsgStatus.SUCCESS;
                        }
                        return MsgStatus.REVOKE;
                    }
                    return MsgStatus.DELETE;
                }
                return MsgStatus.FAILED;
            }
            return MsgStatus.SUCCESS;
        }
        return MsgStatus.SENDING;
    }

    public int hashCode() {
        return this.v2TIMMessage.hashCode();
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public boolean i() {
        if (j() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    @NotNull
    public String id() {
        String msgID = this.v2TIMMessage.getMsgID();
        Intrinsics.checkNotNullExpressionValue(msgID, "v2TIMMessage.msgID");
        return msgID;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public long j() {
        ULong uLongOrNull;
        String groupID = this.v2TIMMessage.getGroupID();
        if (groupID != null && (uLongOrNull = UStringsKt.toULongOrNull(groupID)) != null) {
            return uLongOrNull.getData();
        }
        return 0L;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public void k(@NotNull MsgStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.innerStatus = status;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final V2TIMMessage getV2TIMMessage() {
        return this.v2TIMMessage;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public long time() {
        long j3;
        if (this.v2TIMMessage.getTimestamp() != 0) {
            j3 = this.v2TIMMessage.getTimestamp();
        } else {
            j3 = this.createTimeStamp;
        }
        return j3 * 1000;
    }

    @Override // com.tencent.icgame.game.tim.api.message.a
    public int type() {
        if (this.v2TIMMessage.getElemType() != 2 || !m().msg_type.has()) {
            return 1;
        }
        return m().msg_type.get();
    }
}
