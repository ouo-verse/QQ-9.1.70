package xi;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u00a2\u0006\u0004\b+\u0010,J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ<\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J<\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nH\u0014J\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0016\u0010\u001e\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J$\u0010!\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003J\u0018\u0010\"\u001a\u00020\u00162\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016J2\u0010#\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J2\u0010$\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\n0%j\b\u0012\u0004\u0012\u00020\n`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lxi/b;", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/BaseProviderMultiAdapter;", "Lwi/b;", "", "list", "", "isExpanded", "", "J0", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "", "position", "isChangeChildCollapse", "animate", "notify", "", "parentPayload", "C0", "isChangeChildExpand", "E0", "Lxi/c;", "provider", "", "B0", "Lxi/a;", "k0", "type", "r0", "newData", "i0", "j0", "parentNode", "childIndex", "L0", "z0", "D0", "H0", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", UserInfo.SEX_FEMALE, "Ljava/util/HashSet;", "fullSpanNodeTypeSet", "nodeList", "<init>", "(Ljava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b extends BaseProviderMultiAdapter<wi.b> {

    /* renamed from: F, reason: from kotlin metadata */
    private final HashSet<Integer> fullSpanNodeTypeSet;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final int C0(int position, boolean isChangeChildCollapse, boolean animate, boolean notify, Object parentPayload) {
        wi.b bVar = m0().get(position);
        if (bVar instanceof wi.a) {
            wi.a aVar = (wi.a) bVar;
            if (aVar.getIsExpanded()) {
                aVar.e(false);
                List<wi.b> b16 = bVar.b();
                if (b16 == null || b16.isEmpty()) {
                    notifyItemChanged(position, parentPayload);
                    return 0;
                }
                List<wi.b> b17 = bVar.b();
                Intrinsics.checkNotNull(b17);
                List<wi.b> J0 = J0(b17, isChangeChildCollapse ? Boolean.FALSE : null);
                Iterator<T> it = J0.iterator();
                while (it.hasNext()) {
                    ((wi.b) it.next()).c(false);
                }
                int size = J0.size();
                m0().removeAll(J0);
                if (notify) {
                    if (animate) {
                        notifyItemChanged(position, parentPayload);
                        notifyItemRangeRemoved(position + 1, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    private final int E0(int position, boolean isChangeChildExpand, boolean animate, boolean notify, Object parentPayload) {
        wi.b bVar = m0().get(position);
        if (bVar instanceof wi.a) {
            wi.a aVar = (wi.a) bVar;
            if (!aVar.getIsExpanded()) {
                aVar.e(true);
                List<wi.b> b16 = bVar.b();
                if (b16 == null || b16.isEmpty()) {
                    notifyItemChanged(position, parentPayload);
                    return 0;
                }
                List<wi.b> b17 = bVar.b();
                Intrinsics.checkNotNull(b17);
                List<wi.b> J0 = J0(b17, isChangeChildExpand ? Boolean.TRUE : null);
                Iterator<T> it = J0.iterator();
                while (it.hasNext()) {
                    ((wi.b) it.next()).c(true);
                }
                int size = J0.size();
                int i3 = position + 1;
                m0().addAll(i3, J0);
                if (notify) {
                    if (animate) {
                        notifyItemChanged(position, parentPayload);
                        notifyItemRangeInserted(i3, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    private final List<wi.b> J0(Collection<? extends wi.b> list, Boolean isExpanded) {
        ArrayList arrayList = new ArrayList();
        for (wi.b bVar : list) {
            arrayList.add(bVar);
            if (bVar instanceof wi.a) {
                if (Intrinsics.areEqual(isExpanded, Boolean.TRUE) || ((wi.a) bVar).getIsExpanded()) {
                    List<wi.b> b16 = bVar.b();
                    if (!(b16 == null || b16.isEmpty())) {
                        arrayList.addAll(J0(b16, isExpanded));
                    }
                }
                if (isExpanded != null) {
                    ((wi.a) bVar).e(isExpanded.booleanValue());
                }
            } else {
                List<wi.b> b17 = bVar.b();
                if (!(b17 == null || b17.isEmpty())) {
                    arrayList.addAll(J0(b17, isExpanded));
                }
            }
        }
        return arrayList;
    }

    public final void B0(c provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.fullSpanNodeTypeSet.add(Integer.valueOf(provider.f()));
        k0(provider);
    }

    public final int H0(int position, boolean animate, boolean notify, Object parentPayload) {
        wi.b bVar = m0().get(position);
        if (!(bVar instanceof wi.a)) {
            return 0;
        }
        if (((wi.a) bVar).getIsExpanded()) {
            return C0(position, false, animate, notify, parentPayload);
        }
        return E0(position, false, animate, notify, parentPayload);
    }

    public final void L0(wi.b parentNode, int childIndex, Collection<? extends wi.b> newData) {
        Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        Intrinsics.checkNotNullParameter(newData, "newData");
        List<wi.b> b16 = parentNode.b();
        if (b16 != null) {
            b16.addAll(childIndex, newData);
            if (!(parentNode instanceof wi.a) || ((wi.a) parentNode).getIsExpanded()) {
                i0(m0().indexOf(parentNode) + 1 + childIndex, newData);
            }
        }
    }

    @Override // com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter
    public void i0(int position, Collection<? extends wi.b> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        super.i0(position, K0(this, newData, null, 2, null));
    }

    @Override // com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter
    public void j0(Collection<? extends wi.b> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        super.j0(K0(this, newData, null, 2, null));
    }

    @Override // com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter
    public void k0(a<wi.b> provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (provider instanceof c) {
            super.k0(provider);
            return;
        }
        throw new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter
    public boolean r0(int type) {
        return super.r0(type) || this.fullSpanNodeTypeSet.contains(Integer.valueOf(type));
    }

    public b(List<wi.b> list) {
        this.fullSpanNodeTypeSet = new HashSet<>();
        List<wi.b> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        m0().addAll(K0(this, list2, null, 2, null));
    }

    public final int D0(int position, boolean animate, boolean notify, Object parentPayload) {
        if (position < 0) {
            QLog.w("BaseNodeAdapter", 1, "expand pos illegal: " + position);
            return 0;
        }
        return E0(position, false, animate, notify, parentPayload);
    }

    @Override // com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter
    public void z0(Collection<? extends wi.b> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        super.z0(K0(this, list, null, 2, null));
    }

    public /* synthetic */ b(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }

    static /* synthetic */ List K0(b bVar, Collection collection, Boolean bool, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                bool = null;
            }
            return bVar.J0(collection, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
    }

    public static /* synthetic */ int F0(b bVar, int i3, boolean z16, boolean z17, Object obj, int i16, Object obj2) {
        if (obj2 == null) {
            if ((i16 & 2) != 0) {
                z16 = true;
            }
            if ((i16 & 4) != 0) {
                z17 = true;
            }
            if ((i16 & 8) != 0) {
                obj = null;
            }
            return bVar.D0(i3, z16, z17, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
    }

    public static /* synthetic */ int I0(b bVar, int i3, boolean z16, boolean z17, Object obj, int i16, Object obj2) {
        if (obj2 == null) {
            if ((i16 & 2) != 0) {
                z16 = true;
            }
            if ((i16 & 4) != 0) {
                z17 = true;
            }
            if ((i16 & 8) != 0) {
                obj = null;
            }
            return bVar.H0(i3, z16, z17, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
    }
}
