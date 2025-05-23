package uq0;

import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Luq0/b;", "Lpl3/a;", "Luq0/a;", "", "action", "Lkotlinx/coroutines/flow/Flow;", "c", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements pl3.a<a, Object> {
    @Override // pl3.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull a aVar) {
        a.C11027a.a(this, aVar);
    }

    @Nullable
    public Flow<Object> c(@NotNull a action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).getChannelAvatar(action.getView(), action.getContact());
        return null;
    }
}
