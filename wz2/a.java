package wz2;

import com.tencent.mobileqq.aio.msglist.holder.external.c;
import com.tencent.mobileqq.aio.msglist.holder.external.d;
import com.tencent.mobileqq.aio.msglist.holder.external.e;
import com.tencent.mobileqq.aio.msglist.holder.external.g;
import com.tencent.qqnt.aio.refresher.bd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lwz2/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/g;", "", "type", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "b", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements g {
    @Override // com.tencent.mobileqq.aio.msglist.holder.external.g
    @Nullable
    public c a(@NotNull String str, @NotNull e eVar) {
        return g.a.a(this, str, eVar);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.g
    @Nullable
    public d b(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(bd.class).getQualifiedName())) {
            return new b();
        }
        return null;
    }
}
