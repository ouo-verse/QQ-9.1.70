package sj2;

import com.tencent.videocut.utils.r;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lsj2/c;", "Lsj2/d;", "", "timeUs", "a", "", "", "b", "scrollX", "perPx", "c", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "mSimpleDateFormat", "unitValue", "<init>", "(F)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat mSimpleDateFormat;

    public c(float f16) {
        super(f16);
        this.mSimpleDateFormat = new SimpleDateFormat("mm:ss", Locale.US);
    }

    @Override // sj2.d
    public float a(float timeUs) {
        return r.f384266a.e(timeUs) / getUnitValue();
    }

    @Override // sj2.d
    @NotNull
    public String b(long timeUs) {
        String format = this.mSimpleDateFormat.format(Long.valueOf(r.f384266a.d(timeUs)));
        Intrinsics.checkNotNullExpressionValue(format, "mSimpleDateFormat.format(TimeUtils.usToMs(timeUs))");
        return format;
    }

    @Override // sj2.d
    public float c(float scrollX, float perPx) {
        return (scrollX / perPx) * r.f384266a.b(getUnitValue());
    }
}
