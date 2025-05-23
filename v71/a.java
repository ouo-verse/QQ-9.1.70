package v71;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.vas.aio.animation.VasWordsInterceptProcessor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u71.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lv71/a;", "", "", "id", "", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "vipType", "", "a", "", "Lu71/b;", "Ljava/util/List;", "interceptList", "<init>", "()V", "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Vas/Inject_AIOAnimationIntercept.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<b>> f441212c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> interceptList;

    static {
        ArrayList<Class<b>> arrayList = new ArrayList<>();
        f441212c = arrayList;
        arrayList.add(VasWordsInterceptProcessor.class);
    }

    public a() {
        int collectionSizeOrDefault;
        Object first;
        ArrayList<Class<b>> arrayList = f441212c;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.animation.api.AIOInterceptProcessor");
            arrayList2.add((b) newInstance);
        }
        this.interceptList = arrayList2;
    }

    public final boolean a(int id5, long senderUin, int vipType) {
        Iterator<T> it = this.interceptList.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).a(id5, senderUin, vipType)) {
                QLog.e("AIOAnimationInterceptPart", 1, "id: " + id5 + " is intercept, vipType: " + vipType);
                return true;
            }
        }
        return false;
    }
}
