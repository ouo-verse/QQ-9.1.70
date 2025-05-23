package zk4;

import com.tencent.timi.game.utils.l;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lzk4/a;", "", "", "data", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f452717a = new a();

    a() {
    }

    @Nullable
    public final MessageOuterClass$TimMsgBody a(@Nullable byte[] data) {
        boolean z16 = true;
        l.h("TimiPushUtils_", 1, "pushDataToTimMsgBody data:" + data);
        if (data == null) {
            return null;
        }
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        try {
            messageOuterClass$TimMsgBody.mergeFrom(data);
        } catch (IOException e16) {
            l.e("TimiPushUtils_", "pushDataToTimMsgBody onError " + e16);
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return messageOuterClass$TimMsgBody;
    }
}
