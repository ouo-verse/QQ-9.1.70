package rs3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$GetAllVMAppInfoReq;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lrs3/d;", "Lrs3/a;", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "", "a", "I", "size", "b", "offset", "<init>", "(II)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int size;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int offset;

    public d(int i3, int i16) {
        this.size = i3;
        this.offset = i16;
    }

    @Override // rs3.a
    @NotNull
    public String getCmd() {
        return "miniapp.trpc.minigame.virtualappbasicinfo.Virtualappbasicinfo.GetAllVMAppInfo";
    }

    @Override // rs3.a
    @NotNull
    public MessageMicro<?> getRequestData() {
        VMBasicInfo$GetAllVMAppInfoReq vMBasicInfo$GetAllVMAppInfoReq = new VMBasicInfo$GetAllVMAppInfoReq();
        vMBasicInfo$GetAllVMAppInfoReq.size.set(this.size);
        vMBasicInfo$GetAllVMAppInfoReq.offset.set(this.offset);
        return vMBasicInfo$GetAllVMAppInfoReq;
    }

    public /* synthetic */ d(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? 0 : i16);
    }
}
