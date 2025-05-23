package w80;

import androidx.annotation.NonNull;
import feedcloud.FeedCloudRead$StSearchGoods;
import feedcloud.FeedCloudRead$StSearchSmallItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final List<h> f444973a;

    /* renamed from: b, reason: collision with root package name */
    public final String f444974b;

    /* renamed from: c, reason: collision with root package name */
    public final String f444975c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@NonNull FeedCloudRead$StSearchGoods feedCloudRead$StSearchGoods) {
        List<FeedCloudRead$StSearchSmallItem> list = feedCloudRead$StSearchGoods.items.get();
        this.f444973a = new ArrayList(list.size());
        Iterator<FeedCloudRead$StSearchSmallItem> it = list.iterator();
        while (it.hasNext()) {
            this.f444973a.add(new h(it.next()));
        }
        this.f444974b = feedCloudRead$StSearchGoods.title.get();
        this.f444975c = feedCloudRead$StSearchGoods.more.get();
    }
}
