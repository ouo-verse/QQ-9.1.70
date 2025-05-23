package wd1;

import android.text.Layout;
import android.text.Spannable;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.qa.editor.effect.g;
import com.tencent.mobileqq.gamecenter.qa.editor.effect.i;
import com.tencent.mobileqq.gamecenter.qa.editor.effect.k;
import com.tencent.mobileqq.gamecenter.qa.editor.effect.l;
import com.tencent.mobileqq.gamecenter.qa.editor.effect.q;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wd1.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tJE\u0010\u0012\u001a\u00020\u0005\"\u0004\b\u0000\u0010\f\"\u0010\b\u0001\u0010\u000e*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016JB\u0010$\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0016J\u0006\u0010%\u001a\u00020\u0005R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010+\u00a8\u0006/"}, d2 = {"Lwd1/b;", "Lwd1/e;", "Lwd1/a;", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editor", "", "g", "Landroid/view/ViewGroup;", "toolbarContainer", "Lwd1/d;", "toolbar", h.F, "V", "Lzd1/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;", QQWinkConstants.TAB_EFFECT, "value", "b", "(Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/g;Ljava/lang/Object;)V", "f", "e", "Lwd1/c$b;", "listener", "i", "", "start", "end", "a", "Landroid/text/Spannable;", "before", "after", "selStartBefore", "selEndBefore", "selStartAfter", "selEndAfter", "c", "d", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "mEditor", "Lwd1/d;", "mToolbar", "Lwd1/c;", "Lwd1/c;", "mOPManager", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b implements e, a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameStrategyEditTextView mEditor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mToolbar;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final transient c mOPManager = new c();

    @Override // wd1.a
    public void a(@NotNull GameStrategyEditTextView editor, int start, int end) {
        Layout.Alignment alignment;
        int roundToInt;
        Intrinsics.checkNotNullParameter(editor, "editor");
        QLog.d("RTManager", 1, "onSelectionChanged, start=", Integer.valueOf(start), ", end=", Integer.valueOf(end));
        Iterator<g<?, ?>> it = com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ALL_EFFECTS.iterator();
        List<Integer> list = null;
        List<Layout.Alignment> list2 = null;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        boolean z26 = false;
        while (it.hasNext()) {
            g<?, ?> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "Effects.ALL_EFFECTS");
            g<?, ?> gVar = next;
            if (gVar.b(editor)) {
                if (gVar instanceof com.tencent.mobileqq.gamecenter.qa.editor.effect.b) {
                    z16 = true;
                } else if (gVar instanceof k) {
                    z17 = true;
                } else if (gVar instanceof q) {
                    z18 = true;
                } else if (gVar instanceof com.tencent.mobileqq.gamecenter.qa.editor.effect.d) {
                    z19 = true;
                } else if (gVar instanceof l) {
                    z26 = true;
                } else if (gVar instanceof com.tencent.mobileqq.gamecenter.qa.editor.effect.a) {
                    list2 = com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ALIGNMENT.f(editor);
                } else if (gVar instanceof i) {
                    list = com.tencent.mobileqq.gamecenter.qa.editor.effect.h.FONTSIZE.f(editor);
                }
            }
        }
        d dVar = this.mToolbar;
        if (dVar != null) {
            dVar.setBold(z16);
        }
        d dVar2 = this.mToolbar;
        if (dVar2 != null) {
            dVar2.e(z17);
        }
        d dVar3 = this.mToolbar;
        if (dVar3 != null) {
            dVar3.c(z18);
        }
        d dVar4 = this.mToolbar;
        if (dVar4 != null) {
            dVar4.g(z19);
        }
        d dVar5 = this.mToolbar;
        if (dVar5 != null) {
            dVar5.f(z26);
        }
        if (list == null) {
            d dVar6 = this.mToolbar;
            if (dVar6 != null) {
                roundToInt = MathKt__MathJVMKt.roundToInt(editor.getTextSize());
                dVar6.h(roundToInt);
            }
        } else if (list.size() == 1) {
            Integer num = list.get(0);
            if (num != null) {
                int intValue = num.intValue();
                d dVar7 = this.mToolbar;
                if (dVar7 != null) {
                    dVar7.h(intValue);
                }
            }
        } else {
            d dVar8 = this.mToolbar;
            if (dVar8 != null) {
                dVar8.h(-1);
            }
        }
        if (list2 != null && list2.size() == 1) {
            d dVar9 = this.mToolbar;
            if (dVar9 != null) {
                dVar9.a(list2.get(0));
                return;
            }
            return;
        }
        boolean d16 = ae1.a.d(editor.getText(), start, end);
        d dVar10 = this.mToolbar;
        if (dVar10 != null) {
            if (d16) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            }
            dVar10.a(alignment);
        }
    }

    @Override // wd1.e
    public <V, C extends zd1.e<V>> void b(@Nullable g<V, C> effect, V value) {
        GameStrategyEditTextView gameStrategyEditTextView = this.mEditor;
        if (gameStrategyEditTextView != null) {
            gameStrategyEditTextView.M(effect, value);
        }
    }

    @Override // wd1.a
    public void c(@NotNull GameStrategyEditTextView editor, @Nullable Spannable before, @NotNull Spannable after, int selStartBefore, int selEndBefore, int selStartAfter, int selEndAfter) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Intrinsics.checkNotNullParameter(after, "after");
        QLog.d("RTManager", 1, "onTextChanged, after=", after);
        this.mOPManager.a(editor, new c.d(before, after, selStartBefore, selEndBefore, selStartAfter, selEndAfter));
    }

    public final void d() {
        d dVar = this.mToolbar;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void e() {
        GameStrategyEditTextView gameStrategyEditTextView = this.mEditor;
        if (gameStrategyEditTextView != null) {
            c cVar = this.mOPManager;
            Intrinsics.checkNotNull(gameStrategyEditTextView);
            cVar.f(gameStrategyEditTextView);
        }
    }

    public void f() {
        GameStrategyEditTextView gameStrategyEditTextView = this.mEditor;
        if (gameStrategyEditTextView != null) {
            c cVar = this.mOPManager;
            Intrinsics.checkNotNull(gameStrategyEditTextView);
            cVar.h(gameStrategyEditTextView);
        }
    }

    public final void g(@Nullable GameStrategyEditTextView editor) {
        this.mEditor = editor;
        if (editor != null) {
            editor.d0(this);
        }
    }

    public final void h(@Nullable ViewGroup toolbarContainer, @NotNull d toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        this.mToolbar = toolbar;
        toolbar.b(this);
    }

    public final void i(@NotNull c.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOPManager.g(listener);
    }
}
