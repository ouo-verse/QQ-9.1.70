package wq3;

import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.help.d;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import com.tencent.qqnt.aio.api.IAIOFactoryExtApi;
import com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lwq3/a;", "Lcom/tencent/qqnt/aio/factory/d;", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "<init>", "()V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends com.tencent.qqnt.aio.factory.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00060\u0002H\u0016J\u0018\u0010\f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0002H\u0016\u00a8\u0006\r"}, d2 = {"wq3/a$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "buildTitleVB", "buildShortcutBarVB", "Lat/e;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "buildTopTipVB", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wq3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C11501a implements com.tencent.aio.api.factory.f {
        C11501a() {
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            return f.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> buildInputVB() {
            QRouteApi api = QRoute.api(IAIOUniversalBusinessVB.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IAIOUniversalBusinessVB::class.java)");
            return IAIOUniversalBusinessVB.a.a((IAIOUniversalBusinessVB) api, ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getC2CTempChatAdornApi(), false, 2, null);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getShortcutBarVB();
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getTitleVB();
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> buildTopTipVB() {
            return new g();
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return f.a.g(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"wq3/a$b", "Lcom/tencent/aio/api/help/d;", "", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements com.tencent.aio.api.help.d {
        b() {
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
        @Nullable
        public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a aVar) {
            return d.a.b(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @Nullable
        public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a aVar) {
            return d.a.c(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
        @Nullable
        public com.tencent.aio.main.businesshelper.e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
            return d.a.e(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
        @Nullable
        public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a aVar) {
            return d.a.f(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @Nullable
        public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper() {
            Object[] plus;
            Object[] plus2;
            com.tencent.aio.main.businesshelper.h[] lifeCycleHelper = ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider().getLifeCycleHelper();
            if (lifeCycleHelper != null) {
                com.tencent.aio.main.businesshelper.h iceBreakHelper = ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).getIceBreakHelper();
                Intrinsics.checkNotNullExpressionValue(iceBreakHelper, "api(IQCircleChatUtilApi:\u2026java).getIceBreakHelper()");
                plus = ArraysKt___ArraysJvmKt.plus(lifeCycleHelper, iceBreakHelper);
                com.tencent.aio.main.businesshelper.h[] hVarArr = (com.tencent.aio.main.businesshelper.h[]) plus;
                if (hVarArr != null) {
                    plus2 = ArraysKt___ArraysJvmKt.plus((c[]) hVarArr, new c());
                    return (com.tencent.aio.main.businesshelper.h[]) plus2;
                }
            }
            return null;
        }

        @Override // com.tencent.aio.api.help.d
        @Nullable
        public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
            return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider().getNormalHelper();
        }
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.f buildBusinessLevel() {
        return ((IAIOFactoryExtApi) QRoute.api(IAIOFactoryExtApi.class)).buildBusinessLevelCompactInputHeight(new C11501a());
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        return new b();
    }
}
