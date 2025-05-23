package xh1;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.guild.discoveryv2.content.base.h;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import yh1.d;
import yh1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lxh1/a;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends AdapterDelegatesManager<List<? extends h>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f448007a;

    static {
        a aVar = new a();
        f448007a = aVar;
        h.Companion companion = h.INSTANCE;
        aVar.addDelegate(companion.y(), new yh1.c(companion.y()));
        aVar.addDelegate(companion.l(), new yh1.b(companion.l()));
        aVar.addDelegate(companion.B(), new e(companion.B()));
        aVar.addDelegate(companion.A(), new d(companion.A()));
        aVar.addDelegate(companion.p(), new yh1.a(companion.p()));
    }

    a() {
    }
}
