package z94;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import h94.FinishAIMakeFaceData;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s94.FaceInfoSyncData;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lz94/c;", "Lcom/tencent/mobileqq/z1/lua/b;", "Lz94/a;", "", "f", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleSyncFaceInfo", "handleFinishAiMakeFace", "Lh94/a;", "data", "g", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends com.tencent.mobileqq.z1.lua.b<z94.a> {

    /* renamed from: e, reason: collision with root package name */
    public static final c f452180e = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"z94/c$a", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "success", "", "engineInitFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements ZPlanEngineStatusUpdateListener {
        a() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            QLog.i("ZPlanNativeUIPlugin_", 1, "engineInitFinish success:" + success);
            if (success) {
                ((ICommonApi) QRoute.api(ICommonApi.class)).registerZootopiaLuaPlugin(c.f452180e);
            }
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(this, z16);
        }
    }

    static {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: z94.b
            @Override // java.lang.Runnable
            public final void run() {
                c.e();
            }
        });
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        f452180e.f();
    }

    public final void g(FinishAIMakeFaceData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = a().iterator();
        while (it.hasNext()) {
            ((z94.a) it.next()).d(data);
        }
    }

    @LuaEvent("L2N_FinishAIMakeFace")
    public final String handleFinishAiMakeFace(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanNativeUIPlugin_", 1, "handleFinishAiMakeFace " + argument.getParams());
        g(FinishAIMakeFaceData.INSTANCE.a(new JSONObject(argument.getParams())));
        return "";
    }

    @LuaEvent("L2N_SyncFaceInfo")
    public final String handleSyncFaceInfo(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanNativeUIPlugin_", 1, "handleSyncFaceInfo " + argument.getParams());
        FaceInfoSyncData a16 = FaceInfoSyncData.INSTANCE.a(new JSONObject(argument.getParams()));
        Iterator<T> it = a().iterator();
        while (it.hasNext()) {
            ((z94.a) it.next()).c(a16);
        }
        return "";
    }

    public final void f() {
        QLog.i("ZPlanNativeUIPlugin_", 1, " init");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).registerZPlanEngineStatusUpdateListener(new a());
    }
}
