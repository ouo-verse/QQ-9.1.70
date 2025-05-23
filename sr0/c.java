package sr0;

import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.b;
import com.tencent.qqnt.msg.data.h;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lsr0/c;", "Lcom/tencent/qqnt/msg/api/b;", "<init>", "()V", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements com.tencent.qqnt.msg.api.b {
    @Override // com.tencent.qqnt.msg.api.b
    public void a(@NotNull h hVar) {
        b.a.h(this, hVar);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void b(@NotNull byte[] bArr) {
        b.a.g(this, bArr);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> arrayList) {
        b.a.a(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGroupGuildUpdate(@NotNull GroupGuildNotifyInfo groupGuildNotifyInfo) {
        b.a.b(this, groupGuildNotifyInfo);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag guildMsgAbFlag) {
        b.a.c(this, guildMsgAbFlag);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvGroupGuildFlag(int i3) {
        b.a.d(this, i3);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvMsg(@NotNull ArrayList<MsgRecord> arrayList) {
        b.a.e(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvUDCFlag(int i3) {
        b.a.f(this, i3);
    }
}
