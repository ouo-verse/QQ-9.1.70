package uz;

import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, InterfaceC11380b> f440641a;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements InterfaceC11380b {
        a() {
        }

        @Override // uz.b.InterfaceC11380b
        public com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSDramaPageFragment wSDramaPageFragment) {
            return new uz.a(wSDramaPageFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: uz.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11380b {
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSDramaPageFragment wSDramaPageFragment);
    }

    static {
        HashMap hashMap = new HashMap();
        f440641a = hashMap;
        hashMap.put("grid_drama_card", new a());
    }

    public static com.tencent.biz.pubaccount.weishi.baseui.b<Object> a(WSDramaPageFragment wSDramaPageFragment, String str) {
        InterfaceC11380b interfaceC11380b = f440641a.get(str);
        if (interfaceC11380b != null) {
            return interfaceC11380b.a(wSDramaPageFragment);
        }
        return new uz.a(wSDramaPageFragment);
    }
}
