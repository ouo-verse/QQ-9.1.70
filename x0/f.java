package x0;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f extends Property<ImageView, Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f446819a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f446819a = new Matrix();
    }

    @Override // android.util.Property
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(@NonNull ImageView imageView) {
        this.f446819a.set(imageView.getImageMatrix());
        return this.f446819a;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
