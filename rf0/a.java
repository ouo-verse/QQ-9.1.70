package rf0;

import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J(\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lrf0/a;", "", "", PushClientConstants.TAG_CLASS_NAME, "methodName", "args", "returnType", "", "successVisitorMethod", "", "checkExecutionMethod", "checkExecutionMethodThrow", "CoreExperimentalMethod_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface a {
    boolean checkExecutionMethod(@NotNull String className, @NotNull String methodName, @NotNull String args, @NotNull String returnType);

    void checkExecutionMethodThrow(@NotNull String className, @NotNull String methodName, @NotNull String args, @NotNull String returnType);

    void successVisitorMethod(@NotNull String className, @NotNull String methodName, @NotNull String args, @NotNull String returnType);
}
