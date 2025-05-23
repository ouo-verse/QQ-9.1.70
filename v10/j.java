package v10;

import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, n> f440757a;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements n {
        a() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.c(wSVerticalPageFragment, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements n {
        b() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.c(wSVerticalPageFragment, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class c implements n {
        c() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.h(wSVerticalPageFragment, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class d implements n {
        d() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.d(wSVerticalPageFragment, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class e implements n {
        e() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class f implements n {
        f() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class g implements n {
        g() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.c(wSVerticalPageFragment, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class h implements n {
        h() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.c(wSVerticalPageFragment, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class i implements n {
        i() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.e(wSVerticalPageFragment, true);
        }
    }

    /* compiled from: P */
    /* renamed from: v10.j$j, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11385j implements n {
        C11385j() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.c(wSVerticalPageFragment, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class k implements n {
        k() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.i(wSVerticalPageFragment, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class l implements n {
        l() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.i(wSVerticalPageFragment, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class m implements n {
        m() {
        }

        @Override // v10.j.n
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment) {
            return new v10.c(wSVerticalPageFragment, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface n {
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment);
    }

    static {
        HashMap hashMap = new HashMap();
        f440757a = hashMap;
        hashMap.put("aio_home_page", new e());
        hashMap.put("essence_tab", new f());
        hashMap.put("vertical_layer_collection_of_card", new g());
        hashMap.put("vertical_layer_collection", new h());
        hashMap.put("qqchat", new i());
        hashMap.put("trends", new C11385j());
        hashMap.put("share", new k());
        hashMap.put("qq_scheme_open_player", new l());
        hashMap.put("drama_preview", new m());
        hashMap.put("drama_history", new a());
        hashMap.put("drama_collection", new b());
        b(hashMap, "aio_enter_c_link");
        b(hashMap, "open_home_then_video");
        hashMap.put("float_window_out_ws", new c());
    }

    public static com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSVerticalPageFragment wSVerticalPageFragment, String str) {
        n nVar = f440757a.get(str);
        if (nVar != null) {
            return nVar.a(wSVerticalPageFragment);
        }
        return new v10.g(wSVerticalPageFragment.getActivity(), wSVerticalPageFragment, true);
    }

    private static void b(Map<String, n> map, String str) {
        map.put(str, new d());
    }
}
