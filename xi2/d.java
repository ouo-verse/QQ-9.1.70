package xi2;

import com.tencent.mobileqq.qqlivehall.iv.api.hippy.module.VasLiveHippyAppModule;
import com.tencent.mobileqq.qqlivehall.iv.api.hippy.module.VasLiveHippyCookieModule;
import com.tencent.mobileqq.qqlivehall.iv.api.hippy.module.VasLiveHippyDataModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\b\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00050\tH\u0016J\u001a\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f0\u00050\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lxi2/d;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "hippyEngineContext", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "getNativeModules", "", "Lcom/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModule;", "getJavaScriptModules", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "getControllers", "<init>", "()V", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d implements HippyAPIProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final VasLiveHippyAppModule d(HippyEngineContext hippyEngineContext) {
        Intrinsics.checkNotNullParameter(hippyEngineContext, "$hippyEngineContext");
        return new VasLiveHippyAppModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VasLiveHippyDataModule e(HippyEngineContext hippyEngineContext) {
        Intrinsics.checkNotNullParameter(hippyEngineContext, "$hippyEngineContext");
        return new VasLiveHippyDataModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VasLiveHippyCookieModule f(HippyEngineContext hippyEngineContext) {
        Intrinsics.checkNotNullParameter(hippyEngineContext, "$hippyEngineContext");
        return new VasLiveHippyCookieModule(hippyEngineContext);
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @NotNull
    public List<Class<? extends HippyViewController<?>>> getControllers() {
        List<Class<? extends HippyViewController<?>>> emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
        return emptyList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @NotNull
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        List<Class<? extends HippyJavaScriptModule>> emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
        return emptyList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @NotNull
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(@NotNull final HippyEngineContext hippyEngineContext) {
        Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> mutableMapOf;
        Intrinsics.checkNotNullParameter(hippyEngineContext, "hippyEngineContext");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(VasLiveHippyAppModule.class, new Provider() { // from class: xi2.a
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                VasLiveHippyAppModule d16;
                d16 = d.d(HippyEngineContext.this);
                return d16;
            }
        }), TuplesKt.to(VasLiveHippyDataModule.class, new Provider() { // from class: xi2.b
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                VasLiveHippyDataModule e16;
                e16 = d.e(HippyEngineContext.this);
                return e16;
            }
        }), TuplesKt.to(VasLiveHippyCookieModule.class, new Provider() { // from class: xi2.c
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                VasLiveHippyCookieModule f16;
                f16 = d.f(HippyEngineContext.this);
                return f16;
            }
        }));
        return mutableMapOf;
    }
}
