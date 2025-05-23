package q3;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import r3.i;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a extends i {
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void a(@NonNull e eVar, int i3, int i16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    int b(@NonNull f fVar, boolean z16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void c(@NonNull f fVar, int i3, int i16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void f(@NonNull f fVar, int i3, int i16);

    @NonNull
    com.qqnt.widget.smartrefreshlayout.layout.constant.b getSpinnerStyle();

    @NonNull
    View getView();

    boolean isSupportHorizontalDrag();

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onHorizontalDrag(float f16, int i3, int i16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onMoving(boolean z16, float f16, int i3, int i16, int i17);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void setPrimaryColors(@ColorInt int... iArr);
}
