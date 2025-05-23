package qj1;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lqj1/b;", "", "", "e", "getCommentCount", "d", "getPreferStatus", "p", "()Ljava/lang/Integer;", "", "I", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull b bVar) {
            return true;
        }
    }

    boolean A();

    @Nullable
    String I();

    int d();

    int e();

    int getCommentCount();

    int getPreferStatus();

    @Nullable
    Integer p();
}
