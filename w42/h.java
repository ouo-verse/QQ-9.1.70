package w42;

import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lw42/h;", "Lw42/e;", "", "id", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData$SpeakerInfo;", "c", "message", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "a", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "d", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "b", "()Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "liveMessageData", "e", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsg", "Lw42/i;", "f", "Lw42/i;", "msgHeader", "<init>", "(Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h implements e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveMessageData liveMessageData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageOuterClass$TimMsgBody timMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i msgHeader;

    public h(@NotNull LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(liveMessageData, "liveMessageData");
        this.liveMessageData = liveMessageData;
        this.msgHeader = new i();
    }

    @Override // w42.e
    @Nullable
    public MessageOuterClass$TimMsgBody a() {
        Object obj;
        boolean z16;
        if (this.timMsg == null) {
            MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = null;
            try {
                ArrayList<LiveMessageData.ExtData> arrayList = this.liveMessageData.msgContent.mExtDatas;
                Intrinsics.checkNotNullExpressionValue(arrayList, "liveMessageData.msgContent.mExtDatas");
                Iterator<T> it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((LiveMessageData.ExtData) obj).mId == 100001) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                LiveMessageData.ExtData extData = (LiveMessageData.ExtData) obj;
                if (extData != null) {
                    messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody().mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(extData.mValue, 2));
                }
            } catch (InvalidProtocolBufferMicroException unused) {
            }
            this.timMsg = messageOuterClass$TimMsgBody;
        }
        return this.timMsg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LiveMessageData getLiveMessageData() {
        return this.liveMessageData;
    }

    @Override // w42.e
    @NotNull
    public LiveMessageData.SpeakerInfo c() {
        LiveMessageData.SpeakerInfo speakerInfo = this.liveMessageData.mSpeakerInfo;
        Intrinsics.checkNotNullExpressionValue(speakerInfo, "liveMessageData.mSpeakerInfo");
        return speakerInfo;
    }

    @Override // w42.e
    @NotNull
    public String id() {
        String str = this.liveMessageData.mMessageId;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // w42.e
    @NotNull
    public String message() {
        Intrinsics.checkNotNullExpressionValue(this.liveMessageData.msgContent.mMsgElements, "liveMessageData.msgContent.mMsgElements");
        if (!r0.isEmpty()) {
            String str = this.liveMessageData.msgContent.mMsgElements.get(0).mTextMsg.strText;
            Intrinsics.checkNotNullExpressionValue(str, "liveMessageData.msgConte\u2026ments[0].mTextMsg.strText");
            return str;
        }
        return "";
    }
}
