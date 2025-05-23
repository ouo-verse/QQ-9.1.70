package uq;

import android.os.Bundle;
import com.google.gson.JsonIOException;
import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.zplan.servlet.api.IZplanFilamentResourceDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends QIPCModule {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: uq.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11362b implements IAEMultiDownloadCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f439782a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EIPCModule f439783b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f439784c;

        C11362b(Bundle bundle, EIPCModule eIPCModule, int i3) {
            this.f439782a = bundle;
            this.f439783b = eIPCModule;
            this.f439784c = i3;
        }

        @Override // com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack
        public void onAEMultiDownloadFinish(AEResInfo aEResInfo, boolean z16, int i3) {
            ms.a.f(IAECameraGetInfoServer.NAME, "bundle download finish" + aEResInfo.agentType);
            this.f439782a.putSerializable("KEY_RES_AGENT_TYPE", aEResInfo);
            this.f439782a.putInt("KEY_RES_ERROR_TYPE", i3);
            this.f439782a.putBoolean("KEY_RES_EXIT_STATUS", z16);
            EIPCModule eIPCModule = this.f439783b;
            if (eIPCModule != null) {
                eIPCModule.callbackResult(this.f439784c, EIPCResult.createSuccessResult(this.f439782a));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public static b f439786a = new b();
    }

    public b() {
        super(IAECameraGetInfoServer.NAME);
    }

    public static b b() {
        return c.f439786a;
    }

    private EIPCResult c() {
        ShortVideoResourceManager.s(getAppInterface(), null);
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private EIPCResult e(HashMap<String, String> hashMap) {
        HashMap<String, String> avatarResource = ((IZplanFilamentResourceDownloader) QRoute.api(IZplanFilamentResourceDownloader.class)).getAvatarResource(hashMap);
        Bundle bundle = new Bundle();
        bundle.putSerializable("avatar_resource", avatarResource);
        return EIPCResult.createSuccessResult(bundle);
    }

    private EIPCResult f(String str) {
        String avatarInfo = ((IZplanFilamentResourceDownloader) QRoute.api(IZplanFilamentResourceDownloader.class)).getAvatarInfo(str);
        Bundle bundle = new Bundle();
        bundle.putString("avatar_character_info_json_string", avatarInfo);
        return EIPCResult.createSuccessResult(bundle);
    }

    private EIPCResult g() {
        String str;
        try {
            str = FilamentFeatureUtil.f106409g.F().toString();
        } catch (JsonIOException unused) {
            ms.a.c(IAECameraGetInfoServer.NAME, "[handleGetFilamentTemplateConfig] fail to get json string");
            str = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("zplan_lite_res_url_template_json_string", str);
        return EIPCResult.createSuccessResult(bundle);
    }

    private QQAppInterface getAppInterface() {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return null;
    }

    private EIPCResult h() {
        AEResManager.J().k0();
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private EIPCResult i() {
        AEResManager.J().l0();
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private EIPCResult k() {
        ms.a.f(IAECameraGetInfoServer.NAME, " handleSyncAeResWrapperMap");
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_RESP_COMMON_DATA_KEY", AEResManager.J().G());
        return EIPCResult.createSuccessResult(bundle);
    }

    void d() {
        AEResManager.J().n0();
    }

    void j(EIPCModule eIPCModule, int i3) {
        ms.a.f("PreCheckAERes", "bundle download [onCall] action=ACTION_DOWNLOAD_AE_RES_CALLBACK, handlePreDownloadEditorEssentials");
        Bundle bundle = new Bundle();
        bundle.putString("action_type", "ACTION_PRE_DOWNLOAD_EDITOR_ESSENTIALS");
        AEResManager.J().m0(new C11362b(bundle, eIPCModule, i3));
    }

    void l(EIPCModule eIPCModule, String str, int i3) {
        ms.a.f("PreCheckAERes", "bundle download [onCall] action=ACTION_DOWNLOAD_AE_RES_CALLBACK, agentType=" + str);
        Bundle bundle = new Bundle();
        bundle.putString("action_type", "ACTION_DOWNLOAD_AE_RES_CALLBACK");
        if (str != null) {
            AEResManager.J().w0(str, new a(str, bundle, eIPCModule, i3), false);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (getAppInterface() == null) {
            return null;
        }
        if ("ACTION_GET_ENV_INFO".equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("KEY_ENV_INFO", "ProdEnv");
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(bundle2);
            callbackResult(i3, createSuccessResult);
            return createSuccessResult;
        }
        if ("ACTION_SEND_GIF".equals(str)) {
            QQAppInterface qQAppInterface = BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface ? (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime() : null;
            if (qQAppInterface == null) {
                return null;
            }
            SessionWrap sessionWrap = new SessionWrap(bundle.getString("curFriendUin"), bundle.getString("curFriendNick"), bundle.getInt("curType"), bundle.getString("troopUin"));
            CameraEmoticonInfo cameraEmoticonInfo = new CameraEmoticonInfo();
            String string = bundle.getString(AECameraConstants.ARG_GIF_PATH);
            cameraEmoticonInfo.path = string;
            cameraEmoticonInfo.url = string;
            cameraEmoticonInfo.contextKey = bundle.getString(AppConstants.Key.FORWARD_SUMMARY_EXTRA, "");
            cameraEmoticonInfo.templateId = bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "");
            cameraEmoticonInfo.send(qQAppInterface, BaseApplication.getContext(), null, sessionWrap.a());
            return null;
        }
        if ("ACTION_DOWNLOAD_AE_RES".equals(str)) {
            String string2 = bundle.getString("KEY_RES_AGENTTYPE");
            boolean z16 = bundle.getBoolean("KEY_RES_PRIORITY");
            ms.a.f("PreCheckAERes", "[onCall] action=ACTION_DOWNLOAD_AE_RES, agentType=" + string2 + " highPriority " + z16);
            if (string2 == null) {
                return null;
            }
            if (z16) {
                AEResManager.J().x0(string2, null, false);
            } else {
                AEResManager.J().w0(string2, null, false);
            }
            return EIPCResult.createSuccessResult(new Bundle());
        }
        if ("ACTION_DOWNLOAD_AE_RES_CALLBACK".equals(str)) {
            l(this, bundle.getString("KEY_RES_AGENTTYPE"), i3);
        } else {
            if ("ACTION_SYNC_AE_RES_WRAPPER_MAP".equals(str)) {
                return k();
            }
            if ("ACTION_PRE_DOWNLOAD_ALL_ESSENTIALS".equals(str)) {
                return h();
            }
            if ("ACTION_PRE_DOWNLOAD_ALL_NON_ESSENTIALS".equals(str)) {
                return i();
            }
            if ("ACTION_PRE_DOWNLOAD_SDK_ESSENTIALS".equals(str)) {
                d();
                return null;
            }
            if ("ACTION_DOWNLOAD_AVCODEC".equals(str)) {
                return c();
            }
            if ("ACTION_FILAMENT_GET_TEMPLATE_CONFIG".equals(str)) {
                return g();
            }
            if ("ACTION_FILAMENT_GET_AVATAR_INFO".equals(str)) {
                String str2 = (String) bundle.getSerializable("avatar_uni");
                ms.a.f(IAECameraGetInfoServer.NAME, "handleGetFilamenAvatarInfo uni " + str2);
                return f(str2);
            }
            if ("ACTION_FILAMENT_GET_AVATAR_RESOURCE_PATH".equals(str)) {
                return e((HashMap) bundle.getSerializable("avatar_resource"));
            }
            if ("ACTION_PRE_DOWNLOAD_EDITOR_ESSENTIALS".equals(str)) {
                j(this, i3);
            } else if ("ACTION_PRE_DOWNLOAD_QQ_SYS_EMOJI_APNG".equals(str)) {
                QQSysAndEmojiResMgr.getInstance().refreshConfig();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f439777d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f439778e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ EIPCModule f439779f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f439780h;

        a(String str, Bundle bundle, EIPCModule eIPCModule, int i3) {
            this.f439777d = str;
            this.f439778e = bundle;
            this.f439779f = eIPCModule;
            this.f439780h = i3;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
            if (this.f439777d.equals(aEResInfo.agentType)) {
                ms.a.f(IAECameraGetInfoServer.NAME, "bundle download finish" + aEResInfo.agentType);
                this.f439778e.putString("KEY_RES_AGENT_TYPE", aEResInfo.agentType);
                this.f439778e.putInt("KEY_RES_ERROR_TYPE", i3);
                EIPCModule eIPCModule = this.f439779f;
                if (eIPCModule != null) {
                    eIPCModule.callbackResult(this.f439780h, EIPCResult.createSuccessResult(this.f439778e));
                }
                AEResManager.J().p0(this);
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        }
    }
}
