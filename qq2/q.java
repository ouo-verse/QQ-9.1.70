package qq2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u00a8\u0006\u0002"}, d2 = {"", "a", "qq_setting_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class q {
    public static final boolean a() {
        List listOf;
        QRouteApi api = QRoute.api(IAssistedChatAdapterApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAssistedChatAdapterApi::class.java)");
        IAssistedChatAdapterApi iAssistedChatAdapterApi = (IAssistedChatAdapterApi) api;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 104, 119});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            if (iAssistedChatAdapterApi.isReplySuggestionExperiment(((Number) it.next()).intValue())) {
                return true;
            }
        }
        return false;
    }
}
