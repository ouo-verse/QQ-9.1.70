package retrofit2;

import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;
import kotlin.Unit;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import okio.Buffer;

/* compiled from: P */
/* loaded from: classes29.dex */
final class ae {

    /* renamed from: a, reason: collision with root package name */
    static final Type[] f431251a = new Type[0];

    /* renamed from: b, reason: collision with root package name */
    private static boolean f431252b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class a implements GenericArrayType {

        /* renamed from: d, reason: collision with root package name */
        private final Type f431253d;

        a(Type type) {
            this.f431253d = type;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof GenericArrayType) && ae.d(this, (GenericArrayType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f431253d;
        }

        public int hashCode() {
            return this.f431253d.hashCode();
        }

        public String toString() {
            return ae.u(this.f431253d) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class b implements ParameterizedType {

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private final Type f431254d;

        /* renamed from: e, reason: collision with root package name */
        private final Type f431255e;

        /* renamed from: f, reason: collision with root package name */
        private final Type[] f431256f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(@Nullable Type type, Type type2, Type... typeArr) {
            boolean z16;
            if (type2 instanceof Class) {
                if (type == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                ae.b(type3);
            }
            this.f431254d = type;
            this.f431255e = type2;
            this.f431256f = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ParameterizedType) && ae.d(this, (ParameterizedType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f431256f.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public Type getOwnerType() {
            return this.f431254d;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f431255e;
        }

        public int hashCode() {
            int i3;
            int hashCode = Arrays.hashCode(this.f431256f) ^ this.f431255e.hashCode();
            Type type = this.f431254d;
            if (type != null) {
                i3 = type.hashCode();
            } else {
                i3 = 0;
            }
            return hashCode ^ i3;
        }

        public String toString() {
            Type[] typeArr = this.f431256f;
            if (typeArr.length == 0) {
                return ae.u(this.f431255e);
            }
            StringBuilder sb5 = new StringBuilder((typeArr.length + 1) * 30);
            sb5.append(ae.u(this.f431255e));
            sb5.append("<");
            sb5.append(ae.u(this.f431256f[0]));
            for (int i3 = 1; i3 < this.f431256f.length; i3++) {
                sb5.append(", ");
                sb5.append(ae.u(this.f431256f[i3]));
            }
            sb5.append(">");
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class c implements WildcardType {

        /* renamed from: d, reason: collision with root package name */
        private final Type f431257d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private final Type f431258e;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        Type type = typeArr2[0];
                        type.getClass();
                        ae.b(type);
                        if (typeArr[0] == Object.class) {
                            this.f431258e = typeArr2[0];
                            this.f431257d = Object.class;
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                    Type type2 = typeArr[0];
                    type2.getClass();
                    ae.b(type2);
                    this.f431258e = null;
                    this.f431257d = typeArr[0];
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public boolean equals(Object obj) {
            if ((obj instanceof WildcardType) && ae.d(this, (WildcardType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f431258e;
            if (type != null) {
                return new Type[]{type};
            }
            return ae.f431251a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f431257d};
        }

        public int hashCode() {
            int i3;
            Type type = this.f431258e;
            if (type != null) {
                i3 = type.hashCode() + 31;
            } else {
                i3 = 1;
            }
            return i3 ^ (this.f431257d.hashCode() + 31);
        }

        public String toString() {
            if (this.f431258e != null) {
                return "? super " + ae.u(this.f431258e);
            }
            if (this.f431257d == Object.class) {
                return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            }
            return "? extends " + ae.u(this.f431257d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ResponseBody a(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer);
    }

    static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    @Nullable
    private static Class<?> c(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static boolean d(Type type, Type type2) {
        boolean z16;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            if (ownerType != ownerType2 && (ownerType == null || !ownerType.equals(ownerType2))) {
                z16 = false;
            } else {
                z16 = true;
            }
            boolean equals = parameterizedType.getRawType().equals(parameterizedType2.getRawType());
            boolean equals2 = Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            if (z16 && equals && equals2) {
                return true;
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return d(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return true;
            }
            return false;
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName())) {
            return true;
        }
        return false;
    }

    static Type e(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i3 = 0; i3 < length; i3++) {
                Class<?> cls3 = interfaces[i3];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i3];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return e(cls.getGenericInterfaces()[i3], interfaces[i3], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return e(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type f(int i3, ParameterizedType parameterizedType) {
        Type type = parameterizedType.getActualTypeArguments()[i3];
        if (type instanceof WildcardType) {
            return ((WildcardType) type).getLowerBounds()[0];
        }
        return type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type g(int i3, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i3 >= 0 && i3 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i3];
            if (type instanceof WildcardType) {
                return ((WildcardType) type).getUpperBounds()[0];
            }
            return type;
        }
        throw new IllegalArgumentException("Index " + i3 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> h(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type i(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return r(type, cls, e(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(@Nullable Type type) {
        String name;
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (j(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return j(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        if (type == null) {
            name = "null";
        } else {
            name = type.getClass().getName();
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
    }

    private static int k(Object[] objArr, Object obj) {
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (obj.equals(objArr[i3])) {
                return i3;
            }
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(Type type) {
        if (!f431252b || type != Unit.class) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException n(Method method, String str, Object... objArr) {
        return o(method, null, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException o(Method method, @Nullable Throwable th5, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + method.getDeclaringClass().getSimpleName() + "." + method.getName(), th5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException p(Method method, int i3, String str, Object... objArr) {
        return n(method, str + " (" + u.f431362b.a(method, i3) + ")", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException q(Method method, Throwable th5, int i3, String str, Object... objArr) {
        return o(method, th5, str + " (" + u.f431362b.a(method, i3) + ")", objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Type r(Type type, Class<?> cls, Type type2) {
        Type type3;
        boolean z16;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type s16 = s(type, cls, typeVariable);
            if (s16 == typeVariable) {
                return s16;
            }
            type3 = s16;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type r16 = r(type, cls, componentType);
                if (componentType != r16) {
                    return new a(r16);
                }
                return cls2;
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type r17 = r(type, cls, genericComponentType);
            if (genericComponentType != r17) {
                return new a(r17);
            }
            return genericArrayType;
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type r18 = r(type, cls, ownerType);
            if (r18 != ownerType) {
                z16 = true;
            } else {
                z16 = false;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i3 = 0; i3 < length; i3++) {
                Type r19 = r(type, cls, actualTypeArguments[i3]);
                if (r19 != actualTypeArguments[i3]) {
                    if (!z16) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z16 = true;
                    }
                    actualTypeArguments[i3] = r19;
                }
            }
            if (z16) {
                return new b(r18, parameterizedType.getRawType(), actualTypeArguments);
            }
            return parameterizedType;
        }
        boolean z17 = type3 instanceof WildcardType;
        Type type4 = type3;
        if (z17) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type r26 = r(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (r26 != lowerBounds[0]) {
                    return new c(new Type[]{Object.class}, new Type[]{r26});
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    Type r27 = r(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (r27 != upperBounds[0]) {
                        return new c(new Type[]{r27}, f431251a);
                    }
                }
            }
        }
        return type4;
    }

    private static Type s(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> c16 = c(typeVariable);
        if (c16 == null) {
            return typeVariable;
        }
        Type e16 = e(type, cls, c16);
        if (e16 instanceof ParameterizedType) {
            return ((ParameterizedType) e16).getActualTypeArguments()[k(c16.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void t(Throwable th5) {
        if (!(th5 instanceof VirtualMachineError)) {
            if (!(th5 instanceof ThreadDeath)) {
                if (!(th5 instanceof LinkageError)) {
                    return;
                } else {
                    throw ((LinkageError) th5);
                }
            }
            throw ((ThreadDeath) th5);
        }
        throw ((VirtualMachineError) th5);
    }

    static String u(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}
