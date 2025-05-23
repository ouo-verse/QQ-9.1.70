package xz2;

import com.tencent.qqnt.aio.factory.f;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lxz2/c;", "Lcom/tencent/qqnt/aio/factory/f;", "Lcom/tencent/qqnt/aio/factory/a;", "param", "", QZoneImageUtils.KEY_MATCH, "", "getAIOFactoryClassName", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements f {
    @Override // com.tencent.qqnt.aio.factory.f
    public boolean cacheAble() {
        return f.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.factory.f
    public String getAIOFactoryClassName(com.tencent.qqnt.aio.factory.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        String name = b.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "SquareTempAIOFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.qqnt.aio.factory.f
    public boolean match(com.tencent.qqnt.aio.factory.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return param.b() == 115;
    }
}
