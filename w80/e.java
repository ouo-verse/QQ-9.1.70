package w80;

import feedcloud.FeedCloudRead$StSearchHeaderColumn;
import feedcloud.FeedCloudRead$StSearchIconItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f444976a;

    /* renamed from: b, reason: collision with root package name */
    public final String f444977b;

    /* renamed from: c, reason: collision with root package name */
    public final String f444978c;

    /* renamed from: d, reason: collision with root package name */
    public final List<f> f444979d;

    /* renamed from: e, reason: collision with root package name */
    public final String f444980e;

    /* renamed from: f, reason: collision with root package name */
    public final String f444981f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FeedCloudRead$StSearchHeaderColumn feedCloudRead$StSearchHeaderColumn) {
        this.f444976a = feedCloudRead$StSearchHeaderColumn.name.get();
        this.f444977b = feedCloudRead$StSearchHeaderColumn.description.get();
        List<FeedCloudRead$StSearchIconItem> list = feedCloudRead$StSearchHeaderColumn.playing_icons.get();
        this.f444979d = new ArrayList(list.size());
        Iterator<FeedCloudRead$StSearchIconItem> it = list.iterator();
        while (it.hasNext()) {
            this.f444979d.add(new f(it.next()));
        }
        this.f444978c = feedCloudRead$StSearchHeaderColumn.playing_text.get();
        this.f444980e = feedCloudRead$StSearchHeaderColumn.scheme.get();
        this.f444981f = feedCloudRead$StSearchHeaderColumn.report.attachInfo.get();
    }
}
