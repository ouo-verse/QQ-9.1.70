package s14;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends AsyncListDifferDelegationAdapter<a24.b> {

    /* compiled from: P */
    /* renamed from: s14.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C11199a extends DiffUtil.ItemCallback<a24.b> {
        C11199a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull a24.b bVar, @NonNull a24.b bVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull a24.b bVar, @NonNull a24.b bVar2) {
            return Objects.equals(bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NonNull a24.b bVar, @NonNull a24.b bVar2) {
            return new Object();
        }
    }

    public a(AdapterDelegatesManager adapterDelegatesManager) {
        super(new C11199a(), adapterDelegatesManager);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        List<a24.b> items = getItems();
        if (items != null && items.size() != 0 && i3 < items.size()) {
            a24.b bVar = items.get(i3);
            if (bVar != null) {
                return bVar.a();
            }
            return i3;
        }
        return i3;
    }
}
