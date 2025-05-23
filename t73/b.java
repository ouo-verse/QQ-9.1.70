package t73;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0007\u0010\u0006\u00a8\u0006\b"}, d2 = {"T", "Landroidx/lifecycle/MutableLiveData;", "Lt73/a;", "v", "", "b", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    public static final <T> void a(@NotNull MutableLiveData<a<T>> mutableLiveData, T t16) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        mutableLiveData.postValue(new a<>(t16));
    }

    public static final <T> void b(@NotNull MutableLiveData<a<T>> mutableLiveData, T t16) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        mutableLiveData.setValue(new a<>(t16));
    }
}
