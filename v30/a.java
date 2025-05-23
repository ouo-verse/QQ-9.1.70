package v30;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a extends DiffUtil.ItemCallback<e30.b> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a */
    public boolean areContentsTheSame(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
        if (c(bVar, bVar2) || bVar.g() != bVar2.g()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b */
    public boolean areItemsTheSame(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
        return bVar.g().f398449id.get().equals(bVar2.g().f398449id.get());
    }

    public abstract boolean c(@NonNull e30.b bVar, @NonNull e30.b bVar2);
}
