package vi1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001a\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\r*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lvi1/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "a", "(Lvi1/b;)Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "", "e", "(Lvi1/b;)I", "sourcePageBusinessType", "Landroid/os/Bundle;", "c", "(Lvi1/b;)Landroid/os/Bundle;", "queryBundle", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "d", "(Lvi1/b;)Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "queryContextInfo", "", "b", "(Lvi1/b;)Ljava/lang/String;", "query", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    @Nullable
    public static final GuildFeedBaseInitBean a(@NotNull b bVar) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Bundle arguments = bVar.getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
        } else {
            serializable = null;
        }
        if (!(serializable instanceof GuildFeedBaseInitBean)) {
            return null;
        }
        return (GuildFeedBaseInitBean) serializable;
    }

    @Nullable
    public static final String b(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Bundle c16 = c(bVar);
        if (c16 != null) {
            return c16.getString("keyword");
        }
        return null;
    }

    private static final Bundle c(b bVar) {
        Bundle arguments = bVar.getArguments();
        if (arguments != null) {
            return arguments.getBundle("search_request");
        }
        return null;
    }

    @Nullable
    public static final FeedBatchManageSearchArgs d(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Bundle c16 = c(bVar);
        if (c16 != null) {
            return (FeedBatchManageSearchArgs) c16.getParcelable("search_args");
        }
        return null;
    }

    public static final int e(@NotNull b bVar) {
        Object obj;
        HashMap<String, Serializable> attrs;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        GuildFeedBaseInitBean a16 = a(bVar);
        Integer num = null;
        if (a16 != null && (attrs = a16.getAttrs()) != null) {
            obj = (Serializable) attrs.get("attr_src_business_type");
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
