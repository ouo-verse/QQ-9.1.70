package xz2;

import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.help.d;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import com.tencent.qqnt.aio.api.IAIOFactoryExtApi;
import com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB;
import com.tencent.qqnt.aio.factory.d;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lxz2/b;", "Lcom/tencent/qqnt/aio/factory/d;", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00060\u0002H\u0016\u00a8\u0006\n"}, d2 = {"xz2/b$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "buildTitleVB", "buildShortcutBarVB", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements f {
        a() {
        }

        @Override // com.tencent.aio.api.factory.f
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            return f.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.f
        public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        public com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> buildInputVB() {
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getInputContainerVB();
        }

        @Override // com.tencent.aio.api.factory.f
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getShortcutBarVB();
        }

        @Override // com.tencent.aio.api.factory.f
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getTitleVB();
        }

        @Override // com.tencent.aio.api.factory.f
        public com.tencent.aio.base.mvvm.a<? extends e, ? extends TopTipViewState> buildTopTipVB() {
            return f.a.f(this);
        }

        @Override // com.tencent.aio.api.factory.h
        public com.tencent.aio.api.b getLayoutDelegate() {
            return f.a.g(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"xz2/b$b", "Lcom/tencent/aio/api/help/d;", "", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xz2.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11580b implements com.tencent.aio.api.help.d {
        C11580b() {
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
        public h[] getLifeCycleHelper(com.tencent.aio.api.help.a aVar) {
            return d.a.b(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        public Map<String, Function0<h>> getLifeCycleHelperCreator(com.tencent.aio.api.help.a aVar) {
            return d.a.c(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
        public com.tencent.aio.main.businesshelper.e[] getNormalHelper(com.tencent.aio.api.help.a aVar) {
            return d.a.e(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
        public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(com.tencent.aio.api.help.a aVar) {
            return d.a.f(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        public h[] getLifeCycleHelper() {
            Object[] plus;
            h[] lifeCycleHelper = ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider().getLifeCycleHelper();
            if (lifeCycleHelper == null) {
                return null;
            }
            plus = ArraysKt___ArraysJvmKt.plus((xz2.a[]) lifeCycleHelper, new xz2.a());
            return (h[]) plus;
        }

        @Override // com.tencent.aio.api.help.d
        public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
            return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider().getNormalHelper();
        }
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    public f buildBusinessLevel() {
        return ((IAIOFactoryExtApi) QRoute.api(IAIOFactoryExtApi.class)).buildBusinessLevelCompactInputHeight(new a());
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.help.c
    public com.tencent.aio.api.help.d buildHelperProvider() {
        return new C11580b();
    }
}
