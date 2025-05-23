package u71;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\u0006H&\u00a8\u0006\u000f"}, d2 = {"Lu71/a;", "", "", "memberUin", "troopUin", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isDragonKing", "", "callback", "b", "a", "c", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface a {
    boolean a(@NotNull String troopUin);

    void b(@NotNull String memberUin, @NotNull String troopUin, @NotNull Function1<? super Boolean, Unit> callback);

    boolean c();
}
