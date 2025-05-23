package um0;

import com.tencent.gdtad.basics.sso.callback.SsoAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lum0/f;", "", "Ltencent/gdt/access$AdGetReq;", "adGetReq", "Lcom/tencent/gdtad/basics/sso/callback/SsoAdCallback;", "callback", "Ljava/lang/Runnable;", "c", "", "e", "Ltencent/gdt/qq_ad_get$QQAdGet;", "qqAdGet", "b", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f439212a = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"um0/f$a", "Lsm0/b;", "Ltencent/gdt/access$AdGetRsp;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "", "b", "rsp", "c", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements sm0.b<access.AdGetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SsoAdCallback f439213a;

        a(SsoAdCallback ssoAdCallback) {
            this.f439213a = ssoAdCallback;
        }

        @Override // sm0.b
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f439213a.onRsp(tm0.a.f436590a.a(code), null, errMsg);
            if (QLog.isColorLevel()) {
                QLog.d("GdtSsoLoadService", 2, "onError errMsg:" + errMsg);
            }
        }

        @Override // sm0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull access.AdGetRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            access.RetMsg retMsg = rsp.ret_msg.get();
            this.f439213a.onRsp(retMsg.ret_code.get(), rsp, retMsg.err_msg.get());
        }
    }

    f() {
    }

    private final Runnable c(final access.AdGetReq adGetReq, final SsoAdCallback callback) {
        return new Runnable() { // from class: um0.e
            @Override // java.lang.Runnable
            public final void run() {
                f.d(access.AdGetReq.this, callback);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(access.AdGetReq adGetReq, SsoAdCallback callback) {
        Intrinsics.checkNotNullParameter(adGetReq, "$adGetReq");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        c.f439206a.g(adGetReq, new a(callback));
    }

    @NotNull
    public final access.AdGetReq b(@NotNull qq_ad_get.QQAdGet qqAdGet) {
        Intrinsics.checkNotNullParameter(qqAdGet, "qqAdGet");
        access.AdGetReq adGetReq = new access.AdGetReq();
        try {
            adGetReq.busi_type.set(15);
            adGetReq.client_mod.set(tm0.a.f436590a.b());
        } catch (Throwable th5) {
            QLog.e("GdtSsoLoadService", 1, "create ad req failed", th5);
        }
        adGetReq.qq_ad_get.set(qqAdGet);
        return adGetReq;
    }

    public final void e(@NotNull access.AdGetReq adGetReq, @NotNull SsoAdCallback callback) {
        Intrinsics.checkNotNullParameter(adGetReq, "adGetReq");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d.b(d.f439209a, c(adGetReq, callback), true, false, 4, null);
    }
}
