package x42;

import android.graphics.Paint;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lx42/d;", "", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "shadowHeight", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "()Landroid/graphics/Paint;", "paint", "", "I", "()I", NodeProps.SHADOW_COLOR, "<init>", "(FLandroid/graphics/Paint;I)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float shadowHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int shadowColor;

    public d(float f16, @NotNull Paint paint, int i3) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.shadowHeight = f16;
        this.paint = paint;
        this.shadowColor = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Paint getPaint() {
        return this.paint;
    }

    /* renamed from: b, reason: from getter */
    public final int getShadowColor() {
        return this.shadowColor;
    }

    /* renamed from: c, reason: from getter */
    public final float getShadowHeight() {
        return this.shadowHeight;
    }
}
