package wd1;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0004\u0010\u000b\u000f\nB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lwd1/c;", "", "Lwd1/c$c;", "op", "Ljava/util/Stack;", "stack", "", "e", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editor", "d", "b", "", "", "stacks", "c", "a", h.F, "f", "Ljava/util/Map;", "mUndoStacks", "mRedoStacks", "Lwd1/c$b;", "Lwd1/c$b;", "getMOperationChangeListener", "()Lwd1/c$b;", "g", "(Lwd1/c$b;)V", "mOperationChangeListener", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes12.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Stack<AbstractC11476c>> mUndoStacks = new HashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Stack<AbstractC11476c>> mRedoStacks = new HashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mOperationChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lwd1/c$b;", "", "", "size", "", "b", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void a(int size);

        void b(int size);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B;\b\u0000\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lwd1/c$c;", "", "other", "", "a", "previousOp", "b", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editor", "", "d", "c", "Landroid/text/Spannable;", "Landroid/text/Spannable;", "mBefore", "mAfter", "", "I", "mSelStartBefore", "mSelEndBefore", "e", "mSelStartAfter", "f", "mSelEndAfter", "", "g", "J", "mTimestamp", "<init>", "(Landroid/text/Spannable;Landroid/text/Spannable;IIII)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wd1.c$c, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static abstract class AbstractC11476c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Spannable mBefore;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Spannable mAfter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int mSelStartBefore;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mSelEndBefore;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int mSelStartAfter;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int mSelEndAfter;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final long mTimestamp;

        public AbstractC11476c(@Nullable Spannable spannable, @NotNull Spannable mAfter, int i3, int i16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(mAfter, "mAfter");
            this.mBefore = spannable;
            this.mAfter = mAfter;
            this.mSelStartBefore = i3;
            this.mSelEndBefore = i16;
            this.mSelStartAfter = i17;
            this.mSelEndAfter = i18;
            this.mTimestamp = System.currentTimeMillis();
        }

        public final boolean a(@NotNull AbstractC11476c other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (Math.abs(this.mTimestamp - other.mTimestamp) < 300) {
                return true;
            }
            return false;
        }

        @NotNull
        public final AbstractC11476c b(@NotNull AbstractC11476c previousOp) {
            Intrinsics.checkNotNullParameter(previousOp, "previousOp");
            this.mBefore = previousOp.mBefore;
            this.mSelStartBefore = previousOp.mSelStartBefore;
            this.mSelEndBefore = previousOp.mSelEndBefore;
            return this;
        }

        public final void c(@NotNull GameStrategyEditTextView editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            editor.f0();
            editor.X();
            editor.setText(this.mAfter, TextView.BufferType.EDITABLE);
            int length = editor.length();
            int i3 = this.mSelStartAfter;
            if (length >= i3) {
                editor.setSelection(i3, this.mSelEndAfter);
            }
            editor.e0();
            editor.K();
        }

        public final void d(@NotNull GameStrategyEditTextView editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            editor.f0();
            editor.X();
            editor.setText(this.mBefore, TextView.BufferType.EDITABLE);
            int length = editor.length();
            int i3 = this.mSelStartBefore;
            if (length >= i3) {
                editor.setSelection(i3, this.mSelEndBefore);
            }
            editor.e0();
            editor.K();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lwd1/c$d;", "Lwd1/c$c;", "Landroid/text/Spannable;", "before", "after", "", "selStartBefore", "selEndBefore", "selStartAfter", "selEndAfter", "<init>", "(Landroid/text/Spannable;Landroid/text/Spannable;IIII)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d extends AbstractC11476c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@Nullable Spannable spannable, @NotNull Spannable after, int i3, int i16, int i17, int i18) {
            super(spannable, after, i3, i16, i17, i18);
            Intrinsics.checkNotNullParameter(after, "after");
        }
    }

    private final Stack<AbstractC11476c> b(GameStrategyEditTextView editor) {
        return c(this.mRedoStacks, editor);
    }

    private final Stack<AbstractC11476c> c(Map<Integer, Stack<AbstractC11476c>> stacks, GameStrategyEditTextView editor) {
        Stack<AbstractC11476c> stack = stacks.get(Integer.valueOf(editor.getId()));
        if (stack == null) {
            Stack<AbstractC11476c> stack2 = new Stack<>();
            stacks.put(Integer.valueOf(editor.getId()), stack2);
            return stack2;
        }
        return stack;
    }

    private final Stack<AbstractC11476c> d(GameStrategyEditTextView editor) {
        return c(this.mUndoStacks, editor);
    }

    private final void e(AbstractC11476c op5, Stack<AbstractC11476c> stack) {
        if (stack.size() >= 5) {
            stack.remove(0);
        }
        stack.push(op5);
    }

    public final synchronized void a(@NotNull GameStrategyEditTextView editor, @NotNull AbstractC11476c op5) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Intrinsics.checkNotNullParameter(op5, "op");
        Stack<AbstractC11476c> d16 = d(editor);
        Stack<AbstractC11476c> b16 = b(editor);
        while (!d16.empty()) {
            AbstractC11476c peek = d16.peek();
            Intrinsics.checkNotNullExpressionValue(peek, "undoStack.peek()");
            if (!op5.a(peek)) {
                break;
            }
            AbstractC11476c previousOp = d16.pop();
            Intrinsics.checkNotNullExpressionValue(previousOp, "previousOp");
            op5.b(previousOp);
        }
        e(op5, d16);
        b16.clear();
        b bVar = this.mOperationChangeListener;
        if (bVar != null) {
            bVar.b(d16.size());
        }
        b bVar2 = this.mOperationChangeListener;
        if (bVar2 != null) {
            bVar2.a(b16.size());
        }
    }

    public final synchronized void f(@NotNull GameStrategyEditTextView editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Stack<AbstractC11476c> b16 = b(editor);
        if (!b16.empty()) {
            Stack<AbstractC11476c> d16 = d(editor);
            AbstractC11476c op5 = b16.pop();
            Intrinsics.checkNotNullExpressionValue(op5, "op");
            e(op5, d16);
            op5.c(editor);
            while (!b16.empty()) {
                AbstractC11476c peek = b16.peek();
                Intrinsics.checkNotNullExpressionValue(peek, "redoStack.peek()");
                if (!op5.a(peek)) {
                    break;
                }
                op5 = b16.pop();
                Intrinsics.checkNotNullExpressionValue(op5, "op");
                e(op5, d16);
                op5.c(editor);
            }
        }
        b bVar = this.mOperationChangeListener;
        if (bVar != null) {
            bVar.b(d(editor).size());
        }
        b bVar2 = this.mOperationChangeListener;
        if (bVar2 != null) {
            bVar2.a(b16.size());
        }
    }

    public final void g(@Nullable b bVar) {
        this.mOperationChangeListener = bVar;
    }

    public final synchronized void h(@NotNull GameStrategyEditTextView editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Stack<AbstractC11476c> d16 = d(editor);
        if (!d16.empty()) {
            Stack<AbstractC11476c> b16 = b(editor);
            AbstractC11476c op5 = d16.pop();
            Intrinsics.checkNotNullExpressionValue(op5, "op");
            e(op5, b16);
            op5.d(editor);
            while (!d16.empty()) {
                AbstractC11476c peek = d16.peek();
                Intrinsics.checkNotNullExpressionValue(peek, "undoStack.peek()");
                if (!op5.a(peek)) {
                    break;
                }
                op5 = d16.pop();
                Intrinsics.checkNotNullExpressionValue(op5, "op");
                e(op5, b16);
                op5.d(editor);
            }
        }
        b bVar = this.mOperationChangeListener;
        if (bVar != null) {
            bVar.b(d16.size());
        }
        b bVar2 = this.mOperationChangeListener;
        if (bVar2 != null) {
            bVar2.a(b(editor).size());
        }
    }
}
