package shark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.HeapObject;
import shark.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00062\u00020\u0001:\u0003\u0003\u0007\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\t\u0002\u00a8\u0006\n"}, d2 = {"Lshark/HeapObject;", "", "Lshark/HeapObject$HeapInstance;", "a", "()Lshark/HeapObject$HeapInstance;", "asInstance", "c", "HeapClass", "HeapInstance", "Lshark/HeapObject$HeapClass;", "shark-graph"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public abstract class HeapObject {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Map<String, PrimitiveType> f433821a;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f433822b;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lshark/HeapObject$HeapClass;", "Lshark/HeapObject;", "", "Lshark/e;", h.F, "", "toString", "", "d", "J", "e", "()J", "objectId", "()Ljava/lang/String;", "name", "", "g", "()Z", "isArrayClass", "f", "()Lshark/HeapObject$HeapClass;", "superclass", "Lkotlin/sequences/Sequence;", "b", "()Lkotlin/sequences/Sequence;", "classHierarchy", "Lshark/HeapObject$HeapInstance;", "c", "instances", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes29.dex */
    public static final class HeapClass extends HeapObject {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long objectId;

        @NotNull
        public final Sequence<HeapClass> b() {
            return SequencesKt.generateSequence(this, new Function1<HeapClass, HeapClass>() { // from class: shark.HeapObject$HeapClass$classHierarchy$1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final HeapObject.HeapClass invoke(@NotNull HeapObject.HeapClass it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return it.f();
                }
            });
        }

        @NotNull
        public final Sequence<HeapInstance> c() {
            if (g()) {
                return SequencesKt.emptySequence();
            }
            throw null;
        }

        @NotNull
        public final String d() {
            getObjectId();
            throw null;
        }

        /* renamed from: e, reason: from getter */
        public long getObjectId() {
            return this.objectId;
        }

        @Nullable
        public final HeapClass f() {
            throw null;
        }

        public final boolean g() {
            return StringsKt.endsWith$default(d(), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, (Object) null);
        }

        @NotNull
        public final List<FieldRecord> h() {
            throw null;
        }

        @NotNull
        public String toString() {
            return "class " + d();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\b\u0010\f\u001a\u00020\u0004H\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Lshark/HeapObject$HeapInstance;", "Lshark/HeapObject;", "Lshark/f$a$a$a;", "i", "", "declaringClassName", "fieldName", "Lshark/a;", "g", "c", "Lkotlin/sequences/Sequence;", h.F, "toString", "", "d", "J", "f", "()J", "objectId", "e", "()Ljava/lang/String;", "instanceClassName", "Lshark/HeapObject$HeapClass;", "()Lshark/HeapObject$HeapClass;", "instanceClass", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes29.dex */
    public static final class HeapInstance extends HeapObject {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long objectId;

        public static final /* synthetic */ d b(HeapInstance heapInstance) {
            heapInstance.getClass();
            return null;
        }

        @Nullable
        public final a c(@NotNull String declaringClassName, @NotNull String fieldName) {
            Intrinsics.checkParameterIsNotNull(declaringClassName, "declaringClassName");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            return g(declaringClassName, fieldName);
        }

        @NotNull
        public final HeapClass d() {
            throw null;
        }

        @NotNull
        public final String e() {
            throw null;
        }

        /* renamed from: f, reason: from getter */
        public long getObjectId() {
            return this.objectId;
        }

        @Nullable
        public final a g(@NotNull String declaringClassName, @NotNull String fieldName) {
            a aVar;
            boolean z16;
            Intrinsics.checkParameterIsNotNull(declaringClassName, "declaringClassName");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            Iterator<a> it = h().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = it.next();
                    a aVar2 = aVar;
                    if (Intrinsics.areEqual(aVar2.getDeclaringClass().d(), declaringClassName) && Intrinsics.areEqual(aVar2.getName(), fieldName)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            return aVar;
        }

        @NotNull
        public final Sequence<a> h() {
            final Lazy lazy = LazyKt.lazy(new Function0<p45.a>() { // from class: shark.HeapObject$HeapInstance$readFields$fieldReader$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final p45.a invoke() {
                    HeapObject.HeapInstance.b(HeapObject.HeapInstance.this);
                    HeapObject.HeapInstance.this.i();
                    throw null;
                }
            });
            final KProperty kProperty = null;
            return SequencesKt.flatten(SequencesKt.map(d().b(), new Function1<HeapClass, Sequence<? extends a>>() { // from class: shark.HeapObject$HeapInstance$readFields$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Sequence<a> invoke(@NotNull final HeapObject.HeapClass heapClass) {
                    Sequence asSequence;
                    Sequence<a> map;
                    Intrinsics.checkParameterIsNotNull(heapClass, "heapClass");
                    asSequence = CollectionsKt___CollectionsKt.asSequence(heapClass.h());
                    map = SequencesKt___SequencesKt.map(asSequence, new Function1<FieldRecord, a>() { // from class: shark.HeapObject$HeapInstance$readFields$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final a invoke(@NotNull FieldRecord fieldRecord) {
                            Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
                            HeapObject.HeapInstance.b(HeapObject.HeapInstance.this);
                            heapClass.getObjectId();
                            throw null;
                        }
                    });
                    return map;
                }
            }));
        }

        @NotNull
        public f.a.AbstractC11230a.C11231a i() {
            getObjectId();
            throw null;
        }

        @NotNull
        public String toString() {
            return "instance @" + getObjectId() + " of " + e();
        }
    }

    static {
        Set<String> of5;
        PrimitiveType[] values = PrimitiveType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (PrimitiveType primitiveType : values) {
            StringBuilder sb5 = new StringBuilder();
            String name = primitiveType.name();
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (name != null) {
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                sb5.append(lowerCase);
                sb5.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                arrayList.add(TuplesKt.to(sb5.toString(), primitiveType));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        f433821a = MapsKt.toMap(arrayList);
        String name2 = Boolean.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "Boolean::class.javaObjectType.name");
        String name3 = Character.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name3, "Char::class.javaObjectType.name");
        String name4 = Float.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name4, "Float::class.javaObjectType.name");
        String name5 = Double.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name5, "Double::class.javaObjectType.name");
        String name6 = Byte.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name6, "Byte::class.javaObjectType.name");
        String name7 = Short.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name7, "Short::class.javaObjectType.name");
        String name8 = Integer.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name8, "Int::class.javaObjectType.name");
        String name9 = Long.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name9, "Long::class.javaObjectType.name");
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{name2, name3, name4, name5, name6, name7, name8, name9});
        f433822b = of5;
    }

    @Nullable
    public final HeapInstance a() {
        if (this instanceof HeapInstance) {
            return (HeapInstance) this;
        }
        return null;
    }
}
