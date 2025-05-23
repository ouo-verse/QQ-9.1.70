package tv3;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/graphics/Bitmap;", "a", "c", "b", "avatar_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    @NotNull
    public static final Bitmap a(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(0.5f, 0.5f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(this, 0, 0,\u2026h , height, matrix ,true)");
        return createBitmap;
    }

    @NotNull
    public static final Bitmap b(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth() / 2, bitmap.getHeight());
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(this, 0, 0, width / 2, height)");
        return createBitmap;
    }

    @NotNull
    public static final Bitmap c(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        int width = bitmap.getWidth() / 2;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, width, 0, width, bitmap.getHeight());
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(this, width\u2026 2, 0, width / 2, height)");
        return createBitmap;
    }
}
