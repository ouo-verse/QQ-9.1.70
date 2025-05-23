package zu0;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lzu0/a;", "", "", "b", "()Ljava/lang/Boolean;", "", "uid", "a", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "mapGiftReceiver", "Ljava/util/HashSet;", "c", "Ljava/util/HashSet;", "lsObserver", "Ljava/lang/ref/WeakReference;", "Lzu0/a$a;", "d", "Ljava/lang/ref/WeakReference;", "multiAvChatCallbackRef", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f453416a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<Long, Object> mapGiftReceiver = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashSet<Object> lsObserver = new HashSet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<InterfaceC11716a> multiAvChatCallbackRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lzu0/a$a;", "", "", "isStarted", "()Ljava/lang/Boolean;", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zu0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC11716a {
        @Nullable
        Boolean isStarted();
    }

    a() {
    }

    public final boolean a(long uid) {
        if (mapGiftReceiver.get(Long.valueOf(uid)) != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Boolean b() {
        InterfaceC11716a interfaceC11716a;
        WeakReference<InterfaceC11716a> weakReference = multiAvChatCallbackRef;
        if (weakReference != null && (interfaceC11716a = weakReference.get()) != null) {
            return interfaceC11716a.isStarted();
        }
        return null;
    }
}
