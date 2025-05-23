package uq1;

import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\u0002J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0086\u0002R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Luq1/a;", "", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "gLiveChannelCore", "Lkotlin/reflect/KProperty;", "property", "Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "a", "qqGuildLiveRoomStartParams", "", "b", "Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "getCache", "()Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "setCache", "(Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;)V", "cache", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GLiveChannelStartParams cache = new GLiveChannelStartParams("", "");

    @NotNull
    public final GLiveChannelStartParams a(@NotNull GLiveChannelCore gLiveChannelCore, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(gLiveChannelCore, "gLiveChannelCore");
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.cache.getChannelInfo() == null || this.cache.getGuildInfo() == null) {
            QLog.e("QGL.GLiveRoomStartParamsDelegate", 1, "get cache info is null.");
        }
        return this.cache;
    }

    public final void b(@NotNull GLiveChannelCore gLiveChannelCore, @NotNull KProperty<?> property, @NotNull GLiveChannelStartParams qqGuildLiveRoomStartParams) {
        Intrinsics.checkNotNullParameter(gLiveChannelCore, "gLiveChannelCore");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(qqGuildLiveRoomStartParams, "qqGuildLiveRoomStartParams");
        QLog.i("QGL.GLiveRoomStartParamsDelegate", 1, "set cache." + qqGuildLiveRoomStartParams);
        this.cache = qqGuildLiveRoomStartParams;
    }
}
