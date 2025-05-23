package w80;

import feedcloud.FeedCloudRead$StSearchGameCollection;
import feedcloud.FeedCloudRead$StSearchGameDetail;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f444956a;

    /* renamed from: b, reason: collision with root package name */
    public final String f444957b;

    /* renamed from: c, reason: collision with root package name */
    public final String f444958c;

    /* renamed from: d, reason: collision with root package name */
    public final String f444959d;

    /* renamed from: e, reason: collision with root package name */
    public final String f444960e;

    /* renamed from: f, reason: collision with root package name */
    public final String f444961f;

    /* renamed from: g, reason: collision with root package name */
    public final String f444962g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FeedCloudRead$StSearchGameCollection feedCloudRead$StSearchGameCollection) {
        this.f444956a = feedCloudRead$StSearchGameCollection.app_id.get();
        this.f444957b = feedCloudRead$StSearchGameCollection.channel_id.get();
        FeedCloudRead$StSearchGameDetail feedCloudRead$StSearchGameDetail = feedCloudRead$StSearchGameCollection.detail.get();
        this.f444958c = feedCloudRead$StSearchGameDetail.pkg_name.get();
        this.f444959d = feedCloudRead$StSearchGameDetail.game_name.get();
        this.f444960e = feedCloudRead$StSearchGameDetail.game_icon.get();
        this.f444961f = feedCloudRead$StSearchGameDetail.game_download_url.get();
        this.f444962g = feedCloudRead$StSearchGameDetail.android_pkg_size.get();
    }
}
