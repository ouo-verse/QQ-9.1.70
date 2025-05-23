package vh2;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface bl {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f441681a;

        /* renamed from: b, reason: collision with root package name */
        public String f441682b;

        /* renamed from: c, reason: collision with root package name */
        public List<IGProUserInfo> f441683c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f441684d;

        /* renamed from: e, reason: collision with root package name */
        public Object f441685e;

        public static a a(List<IGProUserInfo> list, Object obj, boolean z16) {
            a aVar = new a();
            aVar.f441681a = 0;
            aVar.f441682b = "";
            aVar.f441683c = list;
            aVar.f441684d = z16;
            aVar.f441685e = obj;
            return aVar;
        }

        public static a b(int i3, String str) {
            a aVar = new a();
            aVar.f441681a = i3;
            aVar.f441682b = str;
            aVar.f441683c = Collections.emptyList();
            aVar.f441684d = true;
            return aVar;
        }

        public String toString() {
            return "Result{code=" + this.f441681a + ", message='" + this.f441682b + "', list.size=" + this.f441683c.size() + ", isEnd=" + this.f441684d + ", cookie=" + this.f441685e + '}';
        }
    }

    void a(a aVar);
}
