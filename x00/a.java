package x00;

import UserGrowth.stGetPersonalInfoRsp;
import com.tencent.biz.pubaccount.weishi.net.common.b;
import com.tencent.biz.pubaccount.weishi.net.common.e;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.net.d;
import com.tencent.biz.pubaccount.weishi.request.ProfileHomePageRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lx00/a;", "", "", "pid", "Lcom/tencent/biz/pubaccount/weishi/profile/a;", "listener", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String pid, com.tencent.biz.pubaccount.weishi.profile.a listener) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (pid != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(pid);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                e.a(new ProfileHomePageRequest(pid)).b(new C11522a(listener));
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J0\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\u000f"}, d2 = {"x00/a$a", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stGetPersonalInfoRsp;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x00.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11522a extends b<stGetPersonalInfoRsp, stGetPersonalInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.pubaccount.weishi.profile.a f446833a;

        C11522a(com.tencent.biz.pubaccount.weishi.profile.a aVar) {
            this.f446833a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            this.f446833a.onFail(errorInfo != null ? errorInfo.a() : -1, errorInfo != null ? errorInfo.b() : null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stGetPersonalInfoRsp rsp) {
            this.f446833a.P(rsp);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stGetPersonalInfoRsp c(g<stGetPersonalInfoRsp> request, stGetPersonalInfoRsp rsp, d headerBean) {
            return rsp;
        }
    }
}
