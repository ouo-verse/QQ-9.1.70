package u50;

import feedcloud.FeedCloudMeta$StBarrage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, ArrayList<FeedCloudMeta$StBarrage>> f438270a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, C11324a> f438271b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f438272c = new HashMap();

    /* compiled from: P */
    /* renamed from: u50.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C11324a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f438273a;

        /* renamed from: b, reason: collision with root package name */
        private long f438274b = -1;

        C11324a() {
        }

        public static C11324a a() {
            return new C11324a();
        }

        public boolean b() {
            return this.f438273a;
        }

        public C11324a c(long j3) {
            this.f438274b = j3;
            return this;
        }

        public C11324a d(boolean z16) {
            this.f438273a = z16;
            return this;
        }

        public String toString() {
            return "FSCommentResponse{mIsFinish=" + this.f438273a + ", mFeedAttachInfo=" + this.f438274b + '}';
        }
    }

    public Map<String, ArrayList<FeedCloudMeta$StBarrage>> a() {
        return this.f438270a;
    }

    public Map<String, C11324a> b() {
        return this.f438271b;
    }

    public void c() {
        this.f438270a.clear();
        this.f438271b.clear();
        this.f438272c.clear();
    }
}
