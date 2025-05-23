package vh1;

import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh1.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lvh1/k;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lvh1/k$a;", "", "", "guildId", "from", "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vh1.k$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String from, ArrayList guildIdsLongList, int i3, String str) {
            Intrinsics.checkNotNullParameter(from, "$from");
            Intrinsics.checkNotNullParameter(guildIdsLongList, "$guildIdsLongList");
            QLog.i("RecentGuildUtils", 1, "addRecentVisitGuildsListSync from:" + from + ", guilds:" + guildIdsLongList + ", result:" + i3 + ", errMsg:" + str);
        }

        public final void b(@NotNull String guildId, @NotNull final String from) {
            List mutableListOf;
            Collection collection;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(from, "from");
            try {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(Long.parseLong(guildId)));
                collection = CollectionsKt___CollectionsKt.toCollection(mutableListOf, new ArrayList());
                final ArrayList<Long> arrayList = (ArrayList) collection;
                r rVar = r.f214743a;
                IRuntimeService S0 = ch.S0(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
                ((IGPSService) S0).addRecentVisitGuildsListSync(arrayList, new wh2.b() { // from class: vh1.j
                    @Override // wh2.b
                    public final void onResult(int i3, String str) {
                        k.Companion.c(from, arrayList, i3, str);
                    }
                });
            } catch (NumberFormatException e16) {
                QLog.e("RecentGuildUtils", 1, "addRecentVisitGuildsListSync from" + from + ", convert guildIds exception:" + e16);
            }
        }

        Companion() {
        }
    }
}
