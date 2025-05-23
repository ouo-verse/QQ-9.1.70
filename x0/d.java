package x0;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d extends Property<ViewGroup, Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final Property<ViewGroup, Float> f446816a = new d("childrenAlpha");

    d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f16 = (Float) viewGroup.getTag(R.id.zh_);
        if (f16 != null) {
            return f16;
        }
        return Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f16) {
        float floatValue = f16.floatValue();
        viewGroup.setTag(R.id.zh_, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            viewGroup.getChildAt(i3).setAlpha(floatValue);
        }
    }
}
