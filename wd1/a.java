package wd1;

import android.text.Spannable;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&JB\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0011"}, d2 = {"Lwd1/a;", "", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editor", "", "start", "end", "", "a", "Landroid/text/Spannable;", "before", "after", "selStartBefore", "selEndBefore", "selStartAfter", "selEndAfter", "c", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface a {
    void a(@NotNull GameStrategyEditTextView editor, int start, int end);

    void c(@NotNull GameStrategyEditTextView editor, @Nullable Spannable before, @NotNull Spannable after, int selStartBefore, int selEndBefore, int selStartAfter, int selEndAfter);
}
