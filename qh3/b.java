package qh3;

import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lqh3/b;", "", "", "d", "", "getSceneType", "b", "getPageId", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "a", "", "c", "getSceneId", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        public static int a(b bVar) {
            return 0;
        }

        public static int b(b bVar) {
            return 0;
        }

        public static int c(b bVar) {
            int i3 = C11078b.f428947a[bVar.a().ordinal()];
            if (i3 == 1) {
                return bVar.getSceneType();
            }
            if (i3 != 2) {
                return bVar.getPageId();
            }
            return bVar.b();
        }

        public static int d(b bVar) {
            return 0;
        }

        public static boolean e(b bVar) {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: qh3.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public /* synthetic */ class C11078b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f428947a;

        static {
            int[] iArr = new int[CheckPhoneManager.EntryType.values().length];
            try {
                iArr[CheckPhoneManager.EntryType.AVATAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CheckPhoneManager.EntryType.MOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f428947a = iArr;
        }
    }

    CheckPhoneManager.EntryType a();

    int b();

    void c();

    boolean d();

    int getPageId();

    int getSceneId();

    int getSceneType();
}
