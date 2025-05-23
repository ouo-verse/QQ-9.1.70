package tq0;

import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.guild.aio.toptip.AIOTopHeightChangedEvent;
import com.tencent.guild.aio.toptip.GetAIOTopHeightMsgIntent;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tq0.c;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002J\u0010\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Ltq0/f;", "Lpn0/a;", "Ltq0/c;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Lcom/tencent/mvi/api/ability/e;", "Lcom/tencent/mvi/base/route/k;", "p", "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "l", "", "o", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends pn0.a<c, TopTipViewState> {
    private final k p(com.tencent.mvi.api.ability.e eVar) {
        return new a(eVar.b().getInt("height", 0));
    }

    @Override // pn0.a
    @NotNull
    public k l(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GetAIOTopHeightMsgIntent) {
            return p(fetchVBState(b.f437094a));
        }
        return pn0.b.f426490a;
    }

    @Override // pn0.a
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GetAIOTopHeightMsgIntent.class).getQualifiedName());
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTopHeightChangedEvent(((c.a) intent).getHeight()));
        }
    }
}
