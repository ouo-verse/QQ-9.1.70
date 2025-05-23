package so3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import c01.c;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u000eB\u000f\u0012\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0015J&\u0010\u0007\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR+\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\"\u0004\b\u0012\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lso3/a;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", HippyTextInputController.COMMAND_getValue, "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Landroidx/compose/runtime/MutableState;", "a", "Landroidx/compose/runtime/MutableState;", "composeState", "<set-?>", "b", "Lkotlin/properties/ReadWriteProperty;", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "ktState", "initialValue", "<init>", "c", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a<T> implements ReadWriteProperty<Object, T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableState<T> composeState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty ktState;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f434108d = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "ktState", "getKtState()Ljava/lang/Object;", 0))};

    /* renamed from: e, reason: collision with root package name */
    public static final int f434109e = 8;

    public a(T t16) {
        MutableState<T> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
        this.composeState = mutableStateOf$default;
        this.ktState = c.a(t16);
    }

    private final T a() {
        return (T) this.ktState.getValue(this, f434108d[0]);
    }

    private final void b(T t16) {
        this.ktState.setValue(this, f434108d[0], t16);
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.composeState.getValue();
        return a();
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object thisRef, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.composeState.setValue(value);
        b(value);
    }
}
