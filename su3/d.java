package su3;

import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lsu3/d;", "", "Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;", "params", "Lcom/tencent/mobileqq/filemanager/nt/NTFileUtils$b;", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f434769a = new d();

    d() {
    }

    public final NTFileUtils.b a(MsgRecordParams params) {
        if (params == null) {
            return null;
        }
        NTFileUtils.b bVar = new NTFileUtils.b();
        bVar.f208719a = params.b();
        bVar.f208722d = params.a();
        bVar.f208723e = params.g();
        bVar.f208720b = params.e();
        bVar.f208721c = params.f();
        return bVar;
    }
}
