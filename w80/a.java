package w80;

import feedcloud.FeedCloudRead$StSearchGame;
import feedcloud.FeedCloudRead$StSearchSmallItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f444953a;

    /* renamed from: b, reason: collision with root package name */
    public final String f444954b;

    /* renamed from: c, reason: collision with root package name */
    public final List<h> f444955c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FeedCloudRead$StSearchGame feedCloudRead$StSearchGame) {
        this.f444953a = feedCloudRead$StSearchGame.title.get();
        this.f444954b = feedCloudRead$StSearchGame.more.get();
        List<FeedCloudRead$StSearchSmallItem> list = feedCloudRead$StSearchGame.items.get();
        this.f444955c = new ArrayList(list.size());
        Iterator<FeedCloudRead$StSearchSmallItem> it = list.iterator();
        while (it.hasNext()) {
            this.f444955c.add(new h(it.next()));
        }
    }
}
