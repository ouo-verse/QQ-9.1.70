package q13;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q13.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016JH\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lq13/a;", "Lq13/d;", "", "c", "", "appId", "itemId", "Lq13/d$a;", "observer", "b", "", "itemType", "appid", "pageId", "moduleId", "actionId", "actionValue", "", "operTime", "a", "Lq13/d;", "getInstance", "()Lq13/d;", "setInstance", "(Lq13/d;)V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f428208a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_DressSetUtil.yml", version = 1)
    @Nullable
    private static d instance;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f428210c;

    static {
        ArrayList arrayList = new ArrayList();
        f428210c = arrayList;
        arrayList.add(c.class);
        a aVar = new a();
        f428208a = aVar;
        aVar.c();
    }

    a() {
    }

    @Override // q13.d
    public void a(@NotNull String itemId, @NotNull String itemType, @NotNull String appid, @NotNull String pageId, @NotNull String moduleId, int actionId, int actionValue, long operTime) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(appid, "appid");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        d dVar = instance;
        if (dVar != null) {
            dVar.a(itemId, itemType, appid, pageId, moduleId, actionId, actionValue, operTime);
        }
    }

    @Override // q13.d
    public void b(int appId, int itemId, @NotNull d.a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        d dVar = instance;
        if (dVar != null) {
            dVar.b(appId, itemId, observer);
        }
    }

    @QAutoInitMethod
    public final void c() {
        instance = (d) com.tencent.mobileqq.qroute.utils.b.a(f428210c);
    }
}
