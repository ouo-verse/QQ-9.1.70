package pv1;

import com.tencent.mobileqq.guild.base.recyclerview.adapter.BaseProviderMultiAdapter;
import hf1.f;
import java.util.List;
import sv1.c;
import sv1.e;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends BaseProviderMultiAdapter<rv1.a> implements f {
    private boolean W;

    public a(boolean z16) {
        this.W = z16;
        Y0(new e(z16));
        Y0(new c(z16));
    }

    @Override // hf1.f
    public hf1.e Q(com.tencent.mobileqq.guild.base.recyclerview.adapter.e<?, ?> eVar) {
        return new hf1.e(eVar);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.BaseProviderMultiAdapter
    protected int g1(List<? extends rv1.a> list, int i3) {
        if (!this.W || i3 != 0) {
            return 1;
        }
        return 2;
    }
}
