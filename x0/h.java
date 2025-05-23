package x0;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap<String, i> f446823a = new SimpleArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final SimpleArrayMap<String, PropertyValuesHolder[]> f446824b = new SimpleArrayMap<>();

    private static void a(@NonNull h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.m(objectAnimator.getPropertyName(), i.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    @NonNull
    private PropertyValuesHolder[] b(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i3 = 0; i3 < propertyValuesHolderArr.length; i3++) {
            propertyValuesHolderArr2[i3] = propertyValuesHolderArr[i3].clone();
        }
        return propertyValuesHolderArr2;
    }

    @Nullable
    public static h c(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i3) {
        int resourceId;
        if (typedArray.hasValue(i3) && (resourceId = typedArray.getResourceId(i3, 0)) != 0) {
            return d(context, resourceId);
        }
        return null;
    }

    @Nullable
    public static h d(@NonNull Context context, @AnimatorRes int i3) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i3);
            if (loadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return e(arrayList);
        } catch (Exception e16) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i3), e16);
            return null;
        }
    }

    @NonNull
    private static h e(@NonNull List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(hVar, list.get(i3));
        }
        return hVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f446823a.equals(((h) obj).f446823a);
    }

    @NonNull
    public <T> ObjectAnimator f(@NonNull String str, @NonNull T t16, @NonNull Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t16, g(str));
        ofPropertyValuesHolder.setProperty(property);
        h(str).a(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    @NonNull
    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.f446824b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public i h(String str) {
        if (k(str)) {
            return this.f446823a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f446823a.hashCode();
    }

    public long i() {
        int size = this.f446823a.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i valueAt = this.f446823a.valueAt(i3);
            j3 = Math.max(j3, valueAt.c() + valueAt.d());
        }
        return j3;
    }

    public boolean j(String str) {
        if (this.f446824b.get(str) != null) {
            return true;
        }
        return false;
    }

    public boolean k(String str) {
        if (this.f446823a.get(str) != null) {
            return true;
        }
        return false;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f446824b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, @Nullable i iVar) {
        this.f446823a.put(str, iVar);
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f446823a + "}\n";
    }
}
