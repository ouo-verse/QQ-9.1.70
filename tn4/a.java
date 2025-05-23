package tn4;

import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends TRTCCloudListener {

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<WeakReference<TRTCCloudListener>> f436893a = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: tn4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC11302a {
        void a(TRTCCloudListener tRTCCloudListener);
    }

    public void L(InterfaceC11302a interfaceC11302a) {
        for (int size = f436893a.size() - 1; size >= 0; size--) {
            TRTCCloudListener tRTCCloudListener = f436893a.get(size).get();
            if (tRTCCloudListener != null) {
                interfaceC11302a.a(tRTCCloudListener);
            } else {
                f436893a.remove(size);
            }
        }
    }

    public void M(TRTCCloudListener tRTCCloudListener) {
        f436893a.add(new WeakReference<>(tRTCCloudListener));
    }

    public void N(TRTCCloudListener tRTCCloudListener) {
        for (int size = f436893a.size() - 1; size >= 0; size--) {
            TRTCCloudListener tRTCCloudListener2 = f436893a.get(size).get();
            if (tRTCCloudListener2 != null) {
                if (tRTCCloudListener == tRTCCloudListener2) {
                    f436893a.remove(size);
                }
            } else {
                f436893a.remove(size);
            }
        }
    }
}
