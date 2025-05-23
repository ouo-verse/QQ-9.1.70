package z81;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class a {

    /* compiled from: P */
    /* renamed from: z81.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C11663a extends b {

        /* renamed from: g, reason: collision with root package name */
        public String f452143g = HippyQQConstants.HIPPY_CHANNEL;

        @Override // z81.a.b
        public void b(AppInterface appInterface, Bundle bundle) {
            this.f452143g = bundle.getString("PromotionDescription");
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public long f452144a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f452145b = "0";

        /* renamed from: c, reason: collision with root package name */
        public String f452146c = "0";

        /* renamed from: d, reason: collision with root package name */
        public boolean f452147d = true;

        /* renamed from: e, reason: collision with root package name */
        public boolean f452148e = true;

        /* renamed from: f, reason: collision with root package name */
        public boolean f452149f = false;

        public final void a(AppInterface appInterface, Bundle bundle) {
            if (bundle == null) {
                return;
            }
            this.f452144a = bundle.getLong("RecoglizeMask", 0L);
            this.f452145b = bundle.getString("H5Source", "0");
            this.f452146c = bundle.getString("version", "0");
            this.f452147d = !bundle.getBoolean("disablecloud", false);
            this.f452149f = bundle.getBoolean("is_from_h5_entry", false);
            this.f452148e = false;
            b(appInterface, bundle);
        }

        public abstract void b(AppInterface appInterface, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class d extends b {

        /* renamed from: g, reason: collision with root package name */
        public String f452150g = null;

        @Override // z81.a.b
        public void b(AppInterface appInterface, Bundle bundle) {
            this.f452150g = bundle.getString("PromotionDescription", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private Bundle f452151a;

        public e(Bundle bundle) {
            this.f452151a = bundle;
        }

        public void a(boolean z16) {
            this.f452151a.putBoolean("arTransferPromotion", z16);
        }

        public void b(long j3) {
            this.f452151a.putLong("downloadItems", j3);
        }

        public void c(boolean z16) {
            this.f452151a.putBoolean("NoLimitParams", z16);
        }

        public void d(long j3) {
            this.f452151a.putLong("recognitionMask", j3);
        }

        public Bundle e() {
            return this.f452151a;
        }
    }

    public static Bundle a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        e eVar = new e(bundle);
        eVar.b(10L);
        eVar.a(true);
        eVar.c(true);
        eVar.d(4096L);
        return eVar.e();
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c extends b {
        @Override // z81.a.b
        public void b(AppInterface appInterface, Bundle bundle) {
        }
    }
}
