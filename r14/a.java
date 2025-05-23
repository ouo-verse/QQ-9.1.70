package r14;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.robot.adelie.homepage.category.viewmodel.RecommendCardType;
import java.util.List;
import kotlin.Metadata;
import u14.b;
import u14.c;
import u14.d;
import u14.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lr14/a;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends AdapterDelegatesManager<List<? extends com.tencent.robot.adelie.homepage.category.viewmodel.a>> {
    public a() {
        addDelegate(RecommendCardType.BANNER.getValue(), new u14.a());
        addDelegate(RecommendCardType.HOT.getValue(), new c());
        addDelegate(RecommendCardType.ROLE.getValue(), new d());
        addDelegate(RecommendCardType.TOOL.getValue(), new e());
        addDelegate(RecommendCardType.REGULAR.getValue(), new b());
    }
}
