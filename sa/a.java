package sa;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0007"}, d2 = {"Lsa/a;", "Lcom/qzone/reborn/base/h;", "Lcb/b;", "", "j0", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends com.qzone.reborn.base.h<cb.b> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"sa/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcb/b;", "oldItem", "newItem", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sa.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11219a extends DiffUtil.ItemCallback<cb.b> {
        C11219a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(cb.b oldItem, cb.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(cb.b oldItem, cb.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getItemType() != newItem.getItemType()) {
                return false;
            }
            if (newItem.getItemType() == 1) {
                return oldItem.getCurTimeStamp() == newItem.getCurTimeStamp();
            }
            aa.e eVar = aa.e.f25753a;
            CommonPhotoInfo mediaData = oldItem.getMediaData();
            String b16 = eVar.b(mediaData != null ? mediaData.getMedia() : null);
            CommonPhotoInfo mediaData2 = newItem.getMediaData();
            return Intrinsics.areEqual(b16, eVar.b(mediaData2 != null ? mediaData2.getMedia() : null));
        }
    }

    public a() {
        super(new C11219a(), new AdapterDelegatesManager(new mb.b(), new mb.a(), new pb.a()));
    }

    @Override // com.qzone.reborn.base.h
    protected boolean j0() {
        return true;
    }
}
