package yq1;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f450969b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, j> f450970a;

    a() {
        HashMap<Integer, j> hashMap = new HashMap<>();
        this.f450970a = hashMap;
        hashMap.put(1, new h());
        this.f450970a.put(4, new h());
        this.f450970a.put(6, new d());
        this.f450970a.put(5, new g());
        this.f450970a.put(2, new i());
        this.f450970a.put(7, new e());
    }

    public static a b() {
        if (f450969b == null) {
            synchronized (a.class) {
                if (f450969b == null) {
                    f450969b = new a();
                }
            }
        }
        return f450969b;
    }

    public j a(int i3) {
        return this.f450970a.get(Integer.valueOf(i3));
    }
}
