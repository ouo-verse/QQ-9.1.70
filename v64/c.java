package v64;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\nB)\b\u0016\u0012\u001e\u0010$\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030#\"\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b%\u0010&J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006J7\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00112\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0011J\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!\u00a8\u0006'"}, d2 = {"Lv64/c;", "T", "", "Lv64/b;", "delegate", "b", "", "viewType", "", "allowReplacingDelegate", "a", "items", "position", "d", "(Ljava/lang/Object;I)I", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "f", "holder", "", "payloads", "", "e", "(Ljava/lang/Object;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "j", "g", h.F, "i", "c", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "mDelegateList", "Lv64/b;", "mFallbackDelegate", "", "delegates", "<init>", "([Lv64/b;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<Object> f441202d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SparseArrayCompat<b<T>> mDelegateList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b<T> mFallbackDelegate;

    static {
        List<Object> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        f441202d = emptyList;
    }

    public c(@NotNull b<T>... delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.mDelegateList = new SparseArrayCompat<>();
        for (b<T> bVar : delegates) {
            b(bVar);
        }
    }

    @NotNull
    public final c<T> a(int viewType, boolean allowReplacingDelegate, @NotNull b<T> delegate) {
        boolean z16;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        boolean z17 = true;
        if (viewType != 2147483646) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!allowReplacingDelegate && this.mDelegateList.get(viewType) != null) {
                z17 = false;
            }
            if (z17) {
                this.mDelegateList.put(viewType, delegate);
                return this;
            }
            throw new IllegalArgumentException(("An AdapterDelegate is already registered for the viewType = " + viewType + ". Already registered AdapterDelegate is " + this.mDelegateList.get(viewType)).toString());
        }
        throw new IllegalArgumentException("The view type = 2147483646 is reserved for fallback adapter delegate (see setFallbackDelegate() ). Please use another view type.".toString());
    }

    @NotNull
    public final c<T> b(@NotNull b<T> delegate) {
        boolean z16;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        int size = this.mDelegateList.size();
        do {
            z16 = false;
            if (this.mDelegateList.get(size) != null) {
                size++;
                if (size != 2147483646) {
                    z16 = true;
                }
            } else {
                return a(size, false, delegate);
            }
        } while (z16);
        throw new IllegalArgumentException("Oops, we are very close to Integer.MAX_VALUE".toString());
    }

    @Nullable
    public final b<T> c(int viewType) {
        return this.mDelegateList.get(viewType, this.mFallbackDelegate);
    }

    public final int d(T items, int position) {
        String str;
        int size = this.mDelegateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mDelegateList.valueAt(i3).a(items, position)) {
                return this.mDelegateList.keyAt(i3);
            }
        }
        if (this.mFallbackDelegate != null) {
            return 2147483646;
        }
        if (items instanceof List) {
            str = "No AdapterDelegate added that matches item=" + String.valueOf(((List) items).get(position)) + " at position=" + position + " in data source";
        } else {
            str = "No AdapterDelegate added for item at position=" + position + ". items=" + items;
        }
        throw new NullPointerException(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public final void e(T items, int position, @NotNull RecyclerView.ViewHolder holder, @Nullable List<?> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b<T> c16 = c(holder.getItemViewType());
        if (c16 != 0) {
            if (payloads == null) {
                payloads = f441202d;
            }
            Intrinsics.checkNotNull(payloads, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            c16.b(items, position, holder, payloads);
            return;
        }
        throw new NullPointerException("No delegate found for item at position = " + position + " for viewType = " + holder.getItemViewType());
    }

    @NotNull
    public final RecyclerView.ViewHolder f(@NotNull ViewGroup parent, int viewType) {
        ViewParent viewParent;
        Intrinsics.checkNotNullParameter(parent, "parent");
        b<T> c16 = c(viewType);
        if (c16 != null) {
            RecyclerView.ViewHolder c17 = c16.c(parent);
            try {
                View view = c17.itemView;
                if (view != null) {
                    viewParent = view.getParent();
                } else {
                    viewParent = null;
                }
                Intrinsics.checkNotNull(viewParent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) viewParent).removeView(c17.itemView);
            } catch (Exception unused) {
            }
            return c17;
        }
        throw new NullPointerException("No AdapterDelegate added for ViewType " + viewType);
    }

    public final boolean g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b<T> c16 = c(holder.getItemViewType());
        if (c16 != null) {
            return c16.d(holder);
        }
        throw new NullPointerException("No delegate found for " + holder + " for item at position = " + holder.getAdapterPosition() + " for viewType = " + holder.getItemViewType());
    }

    public final void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b<T> c16 = c(holder.getItemViewType());
        if (c16 != null) {
            c16.e(holder);
            return;
        }
        throw new NullPointerException("No delegate found for " + holder + " for item at position = " + holder.getAdapterPosition() + " for viewType = " + holder.getItemViewType());
    }

    public final void i(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b<T> c16 = c(holder.getItemViewType());
        if (c16 != null) {
            c16.f(holder);
            return;
        }
        throw new NullPointerException("No delegate found for " + holder + " for item at position = " + holder.getAdapterPosition() + " for viewType = " + holder.getItemViewType());
    }

    public final void j(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b<T> c16 = c(holder.getItemViewType());
        if (c16 != null) {
            c16.g(holder);
            return;
        }
        throw new NullPointerException("No delegate found for " + holder + " for item at position = " + holder.getAdapterPosition() + " for viewType = " + holder.getItemViewType());
    }
}
