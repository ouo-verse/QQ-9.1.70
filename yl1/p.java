package yl1;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.lang.ref.SoftReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\b@\bX\u0088\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lyl1/p;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Lazy;", "", "isInitialized", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "initializer", "Ljava/lang/ref/SoftReference;", "e", "Ljava/lang/ref/SoftReference;", "softValueRef", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class p<R> implements Lazy<R> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<R> initializer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SoftReference<R> softValueRef;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Function0<? extends R> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
    }

    @Override // kotlin.Lazy
    public R getValue() {
        R r16;
        SoftReference<R> softReference = this.softValueRef;
        if (softReference != null) {
            r16 = softReference.get();
        } else {
            r16 = null;
        }
        if (r16 == null) {
            r16 = this.initializer.invoke();
            this.softValueRef = new SoftReference<>(r16);
        }
        Intrinsics.checkNotNull(r16);
        return r16;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        R r16;
        SoftReference<R> softReference = this.softValueRef;
        if (softReference != null) {
            r16 = softReference.get();
        } else {
            r16 = null;
        }
        if (r16 != null) {
            return true;
        }
        return false;
    }
}
