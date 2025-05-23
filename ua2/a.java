package ua2;

import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lua2/a;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "", "toString", "", "a", "J", "()J", "tinyId", "<init>", "(J)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long tinyId;

    public a(long j3) {
        this.tinyId = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getTinyId() {
        return this.tinyId;
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        return 98;
    }

    @NotNull
    public String toString() {
        return "InviteTacitFriendFAQActionInfo: tinyId:" + this.tinyId + ", getActionType: " + getActionType();
    }
}
