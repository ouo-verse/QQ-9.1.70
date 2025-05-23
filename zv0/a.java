package zv0;

import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import fu0.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nJ\u0006\u0010\r\u001a\u00020\tJ\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R;\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lzv0/a;", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "roomId", "Lkotlin/Function1;", "Ljz0/a;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/icgame/game/liveroom/impl/room/fans/FansGroupReceiver;", "receiver", "a", "b", "", "data", "onReceive", "", "errCode", "", "errMsg", "onFail", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoomMessage;", "d", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoomMessage;", "liveRoomMessage", "e", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "f", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a implements IQQCmdPushCallback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ILiveRoomMessage liveRoomMessage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super jz0.a, Unit> receiver;

    public final void a(long roomId, @Nullable Function1<? super jz0.a, Unit> receiver) {
        this.receiver = receiver;
        ILiveRoomMessage k3 = ((c) qx0.a.b(c.class)).k(roomId);
        this.liveRoomMessage = k3;
        if (k3 != null) {
            k3.registerHighPriorityListener(21, this);
        }
    }

    public final void b() {
        this.receiver = null;
        ILiveRoomMessage iLiveRoomMessage = this.liveRoomMessage;
        if (iLiveRoomMessage != null) {
            iLiveRoomMessage.unRegisterHighPriorityListener(21, this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
    public void onFail(int errCode, @Nullable String errMsg) {
        rt0.a.INSTANCE.h("ICGameAudience|ICGameFansGroupPushMgr", "onFail", "errCode=" + errCode + ", errMsg=" + errMsg);
    }

    @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
    public void onReceive(@Nullable byte[] data) {
        if (data == null) {
            rt0.a.INSTANCE.q("ICGameAudience|ICGameFansGroupPushMgr", "onReceive", "invalid data");
            return;
        }
        try {
            jz0.a c16 = jz0.a.c(data);
            rt0.a.INSTANCE.k("ICGameAudience|ICGameFansGroupPushMgr", "onReceive", "groupName=" + c16.f411240i);
            Function1<? super jz0.a, Unit> function1 = this.receiver;
            if (function1 != null) {
                function1.invoke(c16);
            }
        } catch (Exception e16) {
            rt0.a.INSTANCE.i("ICGameAudience|ICGameFansGroupPushMgr", "onReceive", "error, ", e16);
            Function1<? super jz0.a, Unit> function12 = this.receiver;
            if (function12 != null) {
                function12.invoke(null);
            }
        }
    }
}
