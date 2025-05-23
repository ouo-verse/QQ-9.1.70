package sr3;

import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qmethod.pandoraex.api.v;
import com.tencent.qmethod.pandoraex.core.w;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00032\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lsr3/b;", "", "", "c", "module", "apiName", "Lcom/tencent/qmethod/pandoraex/api/v;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "e", "d", "token", "", "a", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "tokenList", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<String> tokenList = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f434342b = new w(64);

    public final void a(@NotNull String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        this.tokenList.add(token);
    }

    public final boolean b(@NotNull String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        return this.tokenList.remove(token);
    }

    @NotNull
    public abstract String c();

    @NotNull
    public final String d(@NotNull String module, @NotNull String apiName, @NotNull v rule) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(apiName, "apiName");
        Intrinsics.checkParameterIsNotNull(rule, "rule");
        ThreadLocal<StringBuilder> threadLocal = f434342b;
        StringBuilder sb5 = threadLocal.get();
        if (sb5 == null) {
            sb5 = new StringBuilder();
        }
        sb5.append(module);
        sb5.append(apiName);
        sb5.append(rule.f343990a);
        sb5.append(rule.f343991b);
        String sb6 = sb5.toString();
        threadLocal.remove();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "builder.toString().also \u2026_LOCAL.remove()\n        }");
        return sb6;
    }

    public abstract boolean e(@NotNull String module, @NotNull String apiName, @NotNull v rule);
}
