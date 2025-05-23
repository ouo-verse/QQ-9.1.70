package w54;

import androidx.recyclerview.widget.DiffUtil;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.api.runtime.b;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u001f\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0006\u001a\u00020\u0005H\u0002R\u0014\u0010\t\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lw54/b;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lv64/e;", "Lb74/a;", "", "l0", UserInfo.SEX_FEMALE, "Lcom/tencent/mvi/api/runtime/b;", "mDialogContext", "Lcom/tencent/mvi/runtime/strategy/b;", "G", "Lcom/tencent/mvi/runtime/strategy/b;", "mStrategyService", "Ljava/util/concurrent/Executor;", "mExecutor", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/mvi/runtime/strategy/b;Ljava/util/concurrent/Executor;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b<C extends com.tencent.mvi.api.runtime.b> extends e<b74.a> {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final C mDialogContext;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.runtime.strategy.b mStrategyService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"w54/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lb74/a;", "oldItem", "newItem", "", "b", "a", "", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends DiffUtil.ItemCallback<b74.a> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull b74.a oldItem, @NotNull b74.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.b(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull b74.a oldItem, @NotNull b74.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.a(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull b74.a oldItem, @NotNull b74.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.c(newItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull C mDialogContext, @NotNull com.tencent.mvi.runtime.strategy.b mStrategyService, @NotNull Executor mExecutor) {
        super(mExecutor, new a(), null, 4, null);
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        Intrinsics.checkNotNullParameter(mStrategyService, "mStrategyService");
        Intrinsics.checkNotNullParameter(mExecutor, "mExecutor");
        this.mDialogContext = mDialogContext;
        this.mStrategyService = mStrategyService;
        l0();
    }

    private final void l0() {
        com.tencent.mvi.runtime.strategy.b bVar = this.mStrategyService;
        k64.a aVar = null;
        if (!bVar.a(k64.a.class)) {
            bVar = null;
        }
        if (bVar != null) {
            aVar = (k64.a) bVar.b(k64.a.class);
        }
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.robot.slash.dialog.stategy.AdapterDelegateListApi<C of com.tencent.robot.slash.dialog.content.list.adapter.DialogListDifferSelectItemAdapter>");
        Iterator<T> it = aVar.a(this.mDialogContext).iterator();
        while (it.hasNext()) {
            j0((v64.b) it.next());
        }
    }
}
