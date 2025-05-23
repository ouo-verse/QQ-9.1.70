package qe1;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.aisearch.models.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lqe1/d;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.aisearch.models.a> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.aisearch.models.a oldItem, @NotNull com.tencent.mobileqq.guild.aisearch.models.a newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(oldItem.getClass()), Reflection.getOrCreateKotlinClass(newItem.getClass()))) {
            return false;
        }
        if ((oldItem instanceof a.QuestionItem) && (newItem instanceof a.QuestionItem)) {
            return Intrinsics.areEqual(((a.QuestionItem) oldItem).getQuestion(), ((a.QuestionItem) newItem).getQuestion());
        }
        if (!(oldItem instanceof a.AnswerItem) || !(newItem instanceof a.AnswerItem)) {
            return false;
        }
        a.AnswerItem answerItem = (a.AnswerItem) oldItem;
        a.AnswerItem answerItem2 = (a.AnswerItem) newItem;
        if (!Intrinsics.areEqual(answerItem.getMessageId(), answerItem2.getMessageId()) || answerItem.b().getValue().getState() != answerItem2.b().getValue().getState()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.aisearch.models.a oldItem, @NotNull com.tencent.mobileqq.guild.aisearch.models.a newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (oldItem.a() == newItem.a()) {
            return true;
        }
        return false;
    }
}
