package xl;

import com.qzone.reborn.configx.g;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lxl/b;", "Lcom/qzone/reborn/part/publish/common/inputarea/a;", "", "b", "maxLength", "", "c", "", "a", "I", "getMSpaceType", "()I", "mSpaceType", "<init>", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends com.qzone.reborn.part.publish.common.inputarea.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mSpaceType;

    public b(int i3) {
        this.mSpaceType = i3;
    }

    @Override // com.qzone.reborn.part.publish.common.inputarea.a
    public String a() {
        return g.f53821a.h().v(this.mSpaceType);
    }

    @Override // com.qzone.reborn.part.publish.common.inputarea.a
    public int b() {
        return 10000;
    }

    @Override // com.qzone.reborn.part.publish.common.inputarea.a
    public void c(int maxLength) {
        String string = BaseApplication.getContext().getResources().getString(R.string.f173054gr0);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.g\u2026d_count_limit_is_reached)");
        d(string);
    }
}
