package w80;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StSearchGameCollection;
import feedcloud.FeedCloudRead$StSearchIconItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f444963a;

    /* renamed from: b, reason: collision with root package name */
    public final e f444964b;

    /* renamed from: c, reason: collision with root package name */
    public final List<f> f444965c;

    /* renamed from: d, reason: collision with root package name */
    public final g f444966d;

    /* renamed from: e, reason: collision with root package name */
    public final d f444967e;

    /* renamed from: f, reason: collision with root package name */
    public final d f444968f;

    /* renamed from: g, reason: collision with root package name */
    public final a f444969g;

    /* renamed from: h, reason: collision with root package name */
    public final b f444970h;

    /* renamed from: i, reason: collision with root package name */
    public final int f444971i = 2;

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f444972j;

    public c(@NonNull FeedCloudRead$StSearchGameCollection feedCloudRead$StSearchGameCollection) {
        this.f444963a = feedCloudRead$StSearchGameCollection.background.get();
        this.f444964b = new e(feedCloudRead$StSearchGameCollection.header.get());
        List<FeedCloudRead$StSearchIconItem> list = feedCloudRead$StSearchGameCollection.icons.get();
        this.f444965c = new ArrayList(list.size());
        Iterator<FeedCloudRead$StSearchIconItem> it = list.iterator();
        while (it.hasNext()) {
            this.f444965c.add(new f(it.next()));
        }
        this.f444966d = new g(feedCloudRead$StSearchGameCollection.image.get());
        this.f444967e = new d(feedCloudRead$StSearchGameCollection.gift_bag.get());
        this.f444968f = new d(feedCloudRead$StSearchGameCollection.props.get());
        this.f444969g = new a(feedCloudRead$StSearchGameCollection.game.get());
        this.f444970h = new b(feedCloudRead$StSearchGameCollection);
        this.f444972j = a(feedCloudRead$StSearchGameCollection.report.get());
    }

    private Map<String, Object> a(@NonNull FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        HashMap hashMap = new HashMap();
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudCommon$StCommonExt.mapInfo.get()) {
            String str = feedCloudCommon$Entry.key.get();
            String str2 = feedCloudCommon$Entry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }
}
