package wk1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lwk1/n;", "", "Lwk1/a;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "", "a", "Ljava/lang/Boolean;", "backing", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean backing;

    public final boolean a(@Nullable a thisRef, @NotNull KProperty<?> property) {
        Boolean bool;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(property, "property");
        if (thisRef == null) {
            return false;
        }
        if (MobileQQ.sProcessId == 1) {
            if (GuildOpenRecordManager.f227480a.e(thisRef.c())) {
                return false;
            }
            return true;
        }
        if (this.backing == null) {
            EIPCResult syncCallGetSimpleDataMethod = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).syncCallGetSimpleDataMethod("check_guild_home_exists", thisRef.c());
            if (syncCallGetSimpleDataMethod != null && (bundle = syncCallGetSimpleDataMethod.data) != null) {
                bool = Boolean.valueOf(bundle.getBoolean("is_guild_home_exists"));
            } else {
                bool = Boolean.FALSE;
            }
            this.backing = bool;
        }
        Boolean bool2 = this.backing;
        Intrinsics.checkNotNull(bool2);
        return bool2.booleanValue();
    }
}
