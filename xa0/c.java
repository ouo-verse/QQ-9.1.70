package xa0;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.aspectj.utils.QCircleScrollMonitorConfig;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.richframework.part.QCircleMonitorProxyImpl;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.monitor.RFWMonitorManager;
import com.tencent.biz.richframework.monitor.memory.RFWBitmapMonitor;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import org.jetbrains.annotations.NotNull;
import uq3.k;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    protected final Activity f447523a;

    /* renamed from: b, reason: collision with root package name */
    private RFWBitmapMonitor f447524b;

    /* renamed from: c, reason: collision with root package name */
    private QCircleScrollMonitorConfig f447525c;

    public c(@NonNull Activity activity) {
        this.f447523a = activity;
    }

    private void c() {
        int intValue = uq3.c.X0("qqcircle", "MinKeepCachePluginVersionCode", 0).intValue();
        try {
            int e16 = k.b().e("SP_KEY_CLEAR_DOWN_PLUGIN_VERSION_CODE", 9017000);
            if (e16 < intValue) {
                QLog.i("ComponentBaseActivity", 1, "checkIsNeedClearCache:true currentVersion " + e16 + "targetVersion:" + intValue);
                CacheHelper.fileCache().clear();
                k.b().m("SP_KEY_CLEAR_DOWN_PLUGIN_VERSION_CODE", intValue);
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    private void k(@NotNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (this.f447525c == null) {
            this.f447525c = new QCircleScrollMonitorConfig();
        }
        if (!this.f447525c.isWnsMonitorEnabled() || !this.f447525c.isPackageVersionEnabled()) {
            return;
        }
        if (aSEngineTabStatusEvent.isSelected()) {
            RFWMonitorManager.instance().start(this.f447523a);
        } else {
            RFWMonitorManager.instance().stop();
        }
    }

    public void a(Configuration configuration) {
        QCircleConfigChangeEvent qCircleConfigChangeEvent = new QCircleConfigChangeEvent();
        qCircleConfigChangeEvent.configuration = configuration;
        SimpleEventBus.getInstance().dispatchEvent(qCircleConfigChangeEvent);
    }

    public void b(Configuration configuration) {
        DisplayUtil.reset();
    }

    public void d(Bundle bundle) {
        c();
        QCirclePluginGlobalInfo.h(this.f447523a);
        DisplayUtil.reset();
        com.tencent.a.d(String.valueOf(hashCode()));
        RFWMonitorManager.instance().injectProxyImpl(QCircleMonitorProxyImpl.b());
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_BLOCK_BITMAP_MEMORY_CONTROLLER, 0)) {
            RFWBitmapMonitor createDefaultMonitor = RFWBitmapMonitor.createDefaultMonitor(this.f447523a);
            this.f447524b = createDefaultMonitor;
            createDefaultMonitor.start();
        }
    }

    public void e() {
        QCirclePluginGlobalInfo.i();
        QCirclePluginGlobalInfo.Q(false);
        QCircleSkinHelper.getInstance().release();
        if (this.f447524b != null && com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_BLOCK_BITMAP_MEMORY_CONTROLLER, 0)) {
            this.f447524b.stop();
        }
    }

    public /* synthetic */ void f() {
        a.a(this);
    }

    public void g(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            k((ASEngineTabStatusEvent) simpleBaseEvent);
        }
    }

    public /* synthetic */ void h() {
        a.b(this);
    }

    public /* synthetic */ void i() {
        a.c(this);
    }

    public void j() {
        com.tencent.a.c(String.valueOf(hashCode()));
    }
}
