package x23;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import v23.Node;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lx23/c;", "", "", "key", "value", "a", "Lv23/a;", "node", "c", "", "d", "stage", "", "b", "", "end", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface c {
    @NotNull
    c a(@NotNull String key, @NotNull String value);

    long b(int stage);

    @NotNull
    c c(@NotNull Node node);

    int d();

    void end();
}
