package si1;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\"\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005R$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lsi1/a;", "", "", "guildId", "channelId", "", "action", "", "a", "", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "actionSelfMarkList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f433837a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> actionSelfMarkList = new ArrayList<>();

    a() {
    }

    public final boolean a(@Nullable String guildId, @Nullable String channelId, int action) {
        String str = guildId + "-" + channelId + "-" + action;
        ArrayList<String> arrayList = actionSelfMarkList;
        if (arrayList.contains(str)) {
            arrayList.remove(str);
            return true;
        }
        return false;
    }

    public final void b(@Nullable String guildId, @Nullable String channelId, int action) {
        String str = guildId + "-" + channelId + "-" + action;
        ArrayList<String> arrayList = actionSelfMarkList;
        if (arrayList.contains(str)) {
            arrayList.remove(str);
        }
        arrayList.add(str);
    }
}
