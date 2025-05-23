package qr0;

import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lqr0/f;", "", "", "getMsgId", "", "getPeerUin", "b", "getMsgSeq", "a", "getSenderUin", "getGuildID", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "c", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface f {
    long a();

    long b();

    @NotNull
    MsgElement c();

    @NotNull
    String getGuildID();

    long getMsgId();

    long getMsgSeq();

    @NotNull
    String getPeerUin();

    @NotNull
    String getSenderUin();
}
