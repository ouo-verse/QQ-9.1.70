package tj;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014\u00a8\u0006\u000e"}, d2 = {"Ltj/h;", "Ltj/e;", "Lsj/c;", "da", "", "fetchLeft", "fetchRight", "", "X9", "Lq9/a;", "Lsj/b;", "L9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h extends e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<sj.b> L9() {
        ViewModel viewModel = getViewModel(wj.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateF\u2026ataViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // tj.e
    protected sj.c da() {
        return new sj.c();
    }

    @Override // tj.e, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public void X9(boolean fetchLeft, boolean fetchRight) {
    }
}
