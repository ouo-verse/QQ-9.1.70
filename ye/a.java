package ye;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J$\u0010\u000f\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\u0006H&\u00a8\u0006\u0013"}, d2 = {"Lye/a;", "", "", "", "", "singleFeedDataMap", "", "d", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/proxy/feedcomponent/model/l;", "jceData", "", "b", "key", "a", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a {
    public abstract void b(BusinessFeedData feedData, com.qzone.proxy.feedcomponent.model.l jceData);

    public abstract boolean c();

    public abstract boolean d(Map<Integer, byte[]> singleFeedDataMap);

    public final boolean a(Map<Integer, byte[]> singleFeedDataMap, int key) {
        return singleFeedDataMap != null && singleFeedDataMap.containsKey(Integer.valueOf(key));
    }
}
