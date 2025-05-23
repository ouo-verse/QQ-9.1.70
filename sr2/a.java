package sr2;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.tofumsg.manager.factory.b;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\u0004H&J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0010H&J!\u0010\u001a\u001a\u00020\u0004\"\b\b\u0000\u0010\u0019*\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH&\u00a8\u0006 "}, d2 = {"Lsr2/a;", "", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "aioCreate", "aioDestroy", "e", "Lcom/tencent/mobileqq/data/NewBeancurdMsg;", "newBeancurdMsg", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", "", "friendUin", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;", "a", "", "g", "i", "b", "tofuLimitMsg", "", h.F, "T", "c", "(Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;)V", "deleteTofuUUIDList", "Lcom/tencent/mobileqq/tofumsg/manager/factory/b;", "iDeleteNtDbTofuCallback", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    @NotNull
    CopyOnWriteArrayList<TofuLimitMsg> a(@NotNull QQAppInterface appInterface, @NotNull String friendUin);

    void aioCreate(@NotNull AIOParam aioParam);

    void aioDestroy();

    void b();

    <T extends TofuLimitMsg> void c(@NotNull T tofuLimitMsg);

    void d(@NotNull String friendUin, @NotNull CopyOnWriteArrayList<String> deleteTofuUUIDList, @NotNull b iDeleteNtDbTofuCallback);

    void e();

    void f(@NotNull NewBeancurdMsg newBeancurdMsg);

    int g();

    boolean h(@NotNull TofuLimitMsg tofuLimitMsg);

    void i(@NotNull NewBeancurdMsg newBeancurdMsg);
}
