package tk1;

import com.tencent.mobileqq.guild.api.FeedListDelegateType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import qj1.h;
import tk1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00028\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Ltk1/c;", "Ltk1/b;", "Ext", "", "Lqj1/h;", "getData", "()Lqj1/h;", "data", "a", "()Ltk1/b;", "ext", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c<Ext extends b> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static <Ext extends b> int a(@NotNull c<Ext> cVar) {
            if (cVar.getData().getFeedType() == 2) {
                return FeedListDelegateType.LongFeed.getLayoutType();
            }
            return cVar.getData().o();
        }
    }

    @NotNull
    Ext a();

    @NotNull
    h getData();
}
