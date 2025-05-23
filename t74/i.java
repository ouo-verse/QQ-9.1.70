package t74;

import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a(\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a.\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003\u001a.\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0001\u001a.\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\f0\u0005*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0004\u001a\u00020\f\u001a(\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000e0\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e\u001a.\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000e0\u0005*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0004\u001a\u00020\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "Lkotlin/properties/ReadWriteProperty;", "", "b", "Lkotlin/Function0;", "keyGetter", "f", "e", "", "c", "", "a", "d", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\f"}, d2 = {"t74/i$a", "Lkotlin/properties/ReadWriteProperty;", "", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Boolean;", "value", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements ReadWriteProperty<Object, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanMMKVApi f435543a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f435544b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f435545c;

        a(IZPlanMMKVApi iZPlanMMKVApi, String str, boolean z16) {
            this.f435543a = iZPlanMMKVApi;
            this.f435544b = str;
            this.f435545c = z16;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return Boolean.valueOf(this.f435543a.getBoolean(this.f435544b, this.f435545c));
        }

        public void b(Object thisRef, KProperty<?> property, boolean value) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.f435543a.setBoolean(this.f435544b, value);
        }

        @Override // kotlin.properties.ReadWriteProperty
        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Boolean bool) {
            b(obj, kProperty, bool.booleanValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\f"}, d2 = {"t74/i$b", "Lkotlin/properties/ReadWriteProperty;", "", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Boolean;", "value", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements ReadWriteProperty<Object, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanMMKVApi f435546a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<String> f435547b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f435548c;

        b(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> function0, boolean z16) {
            this.f435546a = iZPlanMMKVApi;
            this.f435547b = function0;
            this.f435548c = z16;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return Boolean.valueOf(this.f435546a.getBoolean(this.f435547b.invoke(), this.f435548c));
        }

        public void b(Object thisRef, KProperty<?> property, boolean value) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.f435546a.setBoolean(this.f435547b.invoke(), value);
        }

        @Override // kotlin.properties.ReadWriteProperty
        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Boolean bool) {
            b(obj, kProperty, bool.booleanValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001f\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002J'\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"t74/i$c", "Lkotlin/properties/ReadWriteProperty;", "", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "value", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements ReadWriteProperty<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanMMKVApi f435549a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<String> f435550b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f435551c;

        c(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> function0, String str) {
            this.f435549a = iZPlanMMKVApi;
            this.f435550b = function0;
            this.f435551c = str;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return this.f435549a.getString(this.f435550b.invoke(), this.f435551c);
        }

        @Override // kotlin.properties.ReadWriteProperty
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(Object thisRef, KProperty<?> property, String value) {
            Intrinsics.checkNotNullParameter(property, "property");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f435549a.setString(this.f435550b.invoke(), value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\f"}, d2 = {"t74/i$d", "Lkotlin/properties/ReadWriteProperty;", "", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Integer;", "value", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements ReadWriteProperty<Object, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanMMKVApi f435552a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<String> f435553b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f435554c;

        d(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> function0, int i3) {
            this.f435552a = iZPlanMMKVApi;
            this.f435553b = function0;
            this.f435554c = i3;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return Integer.valueOf(this.f435552a.getInt(this.f435553b.invoke(), this.f435554c));
        }

        public void b(Object thisRef, KProperty<?> property, int value) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.f435552a.setInt(this.f435553b.invoke(), value);
        }

        @Override // kotlin.properties.ReadWriteProperty
        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Integer num) {
            b(obj, kProperty, num.intValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\f"}, d2 = {"t74/i$e", "Lkotlin/properties/ReadWriteProperty;", "", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Long;", "value", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class e implements ReadWriteProperty<Object, Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanMMKVApi f435555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f435556b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f435557c;

        e(IZPlanMMKVApi iZPlanMMKVApi, String str, long j3) {
            this.f435555a = iZPlanMMKVApi;
            this.f435556b = str;
            this.f435557c = j3;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return Long.valueOf(this.f435555a.getLong(this.f435556b, this.f435557c));
        }

        public void b(Object thisRef, KProperty<?> property, long value) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.f435555a.setLong(this.f435556b, value);
        }

        @Override // kotlin.properties.ReadWriteProperty
        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Long l3) {
            b(obj, kProperty, l3.longValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\f"}, d2 = {"t74/i$f", "Lkotlin/properties/ReadWriteProperty;", "", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Long;", "value", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class f implements ReadWriteProperty<Object, Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanMMKVApi f435558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<String> f435559b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f435560c;

        f(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> function0, long j3) {
            this.f435558a = iZPlanMMKVApi;
            this.f435559b = function0;
            this.f435560c = j3;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return Long.valueOf(this.f435558a.getLong(this.f435559b.invoke(), this.f435560c));
        }

        public void b(Object thisRef, KProperty<?> property, long value) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.f435558a.setLong(this.f435559b.invoke(), value);
        }

        @Override // kotlin.properties.ReadWriteProperty
        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Long l3) {
            b(obj, kProperty, l3.longValue());
        }
    }

    public static final ReadWriteProperty<Object, Long> a(IZPlanMMKVApi iZPlanMMKVApi, String key, long j3) {
        Intrinsics.checkNotNullParameter(iZPlanMMKVApi, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return new e(iZPlanMMKVApi, key, j3);
    }

    public static final ReadWriteProperty<Object, Boolean> b(IZPlanMMKVApi iZPlanMMKVApi, String key, boolean z16) {
        Intrinsics.checkNotNullParameter(iZPlanMMKVApi, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return new a(iZPlanMMKVApi, key, z16);
    }

    public static final ReadWriteProperty<Object, Integer> c(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> keyGetter, int i3) {
        Intrinsics.checkNotNullParameter(iZPlanMMKVApi, "<this>");
        Intrinsics.checkNotNullParameter(keyGetter, "keyGetter");
        return new d(iZPlanMMKVApi, keyGetter, i3);
    }

    public static final ReadWriteProperty<Object, Long> d(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> keyGetter, long j3) {
        Intrinsics.checkNotNullParameter(iZPlanMMKVApi, "<this>");
        Intrinsics.checkNotNullParameter(keyGetter, "keyGetter");
        return new f(iZPlanMMKVApi, keyGetter, j3);
    }

    public static final ReadWriteProperty<Object, String> e(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> keyGetter, String defaultValue) {
        Intrinsics.checkNotNullParameter(iZPlanMMKVApi, "<this>");
        Intrinsics.checkNotNullParameter(keyGetter, "keyGetter");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return new c(iZPlanMMKVApi, keyGetter, defaultValue);
    }

    public static final ReadWriteProperty<Object, Boolean> f(IZPlanMMKVApi iZPlanMMKVApi, Function0<String> keyGetter, boolean z16) {
        Intrinsics.checkNotNullParameter(iZPlanMMKVApi, "<this>");
        Intrinsics.checkNotNullParameter(keyGetter, "keyGetter");
        return new b(iZPlanMMKVApi, keyGetter, z16);
    }
}
