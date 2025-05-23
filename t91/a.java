package t91;

import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qqecommerce.shell.IQQEcommerceShell;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends com.tencent.mobileqq.auto.engine.enter.a {
    public a(ASPluginBean aSPluginBean) {
        super(aSPluginBean);
    }

    private void l(ASEnterBean aSEnterBean, boolean z16) {
        if (aSEnterBean != null && aSEnterBean.getAttrs() != null) {
            if (!aSEnterBean.getAttrs().containsKey("KEY_ENTER_TIME")) {
                aSEnterBean.getAttrs().put("KEY_ENTER_TIME", String.valueOf(System.currentTimeMillis()));
            }
            aSEnterBean.getAttrs().put("KEY_IS_PLUGIN_MODE", String.valueOf(z16));
            if (z16) {
                aSEnterBean.getAttrs().put("KEY_IS_PLUGIN_LOADED", String.valueOf(com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey()).x()));
            }
        }
    }

    public static boolean m() {
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("100114", new byte[0]);
        if (loadRawConfig == null || loadRawConfig.length <= 0) {
            return false;
        }
        try {
            if (new JSONObject(new String(loadRawConfig)).optInt("enter_plugin", 0) != 1) {
                return false;
            }
            return true;
        } catch (JSONException e16) {
            QLog.e("ECPluginEngineEnter", 2, "enterConfig: ", e16);
            return false;
        }
    }

    private void n(ASEnterBean aSEnterBean, boolean z16) {
        l(aSEnterBean, false);
        ((IQQEcommerceShell) QRoute.api(IQQEcommerceShell.class)).reportEnter(String.valueOf(this.f199837d.getVersionCode()), aSEnterBean.getAttrs());
        if (Boolean.TRUE.toString().equals(aSEnterBean.getAttrs().get("KEY_FORCE_SHOWLOADING"))) {
            QLog.d("ECPluginEngineEnter_" + aSEnterBean.getBusinessKey(), 1, "forceShowLoadingOnNative enterLoading page");
            h(aSEnterBean);
        }
        if (z16) {
            ((IQQEcommerceShell) QRoute.api(IQQEcommerceShell.class)).callLogicInNative(aSEnterBean.getAttrs());
        } else {
            ((IQQEcommerceShell) QRoute.api(IQQEcommerceShell.class)).callService(aSEnterBean.getAttrs());
        }
    }

    private boolean o(HashMap<String, String> hashMap) {
        String str = hashMap.get(TraeConstants.KEY_OPERATION);
        if (Boolean.TRUE.toString().equals(hashMap.get("KEY_FORCE_NATIVE")) && "LOGIC".equals(str)) {
            return true;
        }
        return false;
    }

    @Override // s91.a
    public void a(ASEnterBean aSEnterBean) {
        if (aSEnterBean != null && aSEnterBean.getAttrs() != null) {
            if (o(aSEnterBean.getAttrs())) {
                n(aSEnterBean, true);
                return;
            }
            if (!g()) {
                QLog.e("ECPluginEngineEnter", 2, "enterNativePage: ", new Exception("\u5f53\u524d\u65b9\u6cd5\u4e0d\u652f\u6301\u5728\u5b50\u8fdb\u7a0b\u8c03\u7528, attr=" + aSEnterBean.getAttrs()));
                return;
            }
            n(aSEnterBean, false);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a, s91.a
    public void b(ASEnterBean aSEnterBean) {
        if (o(aSEnterBean.getAttrs())) {
            n(aSEnterBean, true);
        } else {
            super.b(aSEnterBean);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a
    protected void d(ASEnterBean aSEnterBean) {
        l(aSEnterBean, true);
        ((IQQEcommerceShell) QRoute.api(IQQEcommerceShell.class)).reportEnter(String.valueOf(this.f199837d.getVersionCode()), aSEnterBean.getAttrs());
        ASDynamicEngine e16 = com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey());
        String str = aSEnterBean.getAttrs().get(TraeConstants.KEY_OPERATION);
        if (!e16.x() && !"LOGIC".equals(str)) {
            QLog.d("ECPluginEngineEnter_" + aSEnterBean.getBusinessKey(), 1, "hasNeverEnter plugin enterLoading page");
            h(aSEnterBean);
        }
        aSEnterBean.setStartTime(System.currentTimeMillis());
        i(aSEnterBean);
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a
    protected String e(String str, HashMap<String, String> hashMap) {
        return "";
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a
    protected String f() {
        return "com.tencent.mobileqq.qqecommerce.base.plugin.ECPluginLoadingFragment";
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a
    protected boolean j(ASEnterBean aSEnterBean) {
        return false;
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a
    protected void c(ASEnterBean aSEnterBean) {
    }
}
