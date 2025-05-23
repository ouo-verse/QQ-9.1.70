package tp0;

import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.ark.ark;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.guild.aio.help.GuildArkContainerHelper;
import com.tencent.guild.api.ark.IArkEnvironmentApi;
import com.tencent.guild.api.ark.IArkMultiProcApi;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends BaseArkAppContainer {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f437057a;

    /* renamed from: b, reason: collision with root package name */
    private MsgRecord f437058b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.qqnt.msg.data.a f437059c;

    /* renamed from: d, reason: collision with root package name */
    private int f437060d;

    /* renamed from: e, reason: collision with root package name */
    private ArkAppConfig f437061e;

    /* renamed from: f, reason: collision with root package name */
    protected ArkViewModelBase.Size f437062f;

    /* renamed from: g, reason: collision with root package name */
    protected WeakReference<a> f437063g;

    public a(com.tencent.aio.api.runtime.a aVar, MsgRecord msgRecord) {
        this(true, aVar, msgRecord);
    }

    public com.tencent.aio.api.runtime.a a() {
        return this.f437057a;
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void activateView(boolean z16, boolean z17) {
        boolean z18 = this.mIsActivated;
        super.activateView(z16, z17);
        if (z18 == this.mIsActivated) {
            return;
        }
        if (this.mIsActivated) {
            GuildArkContainerHelper.INSTANCE.d(this.f437057a, this.f437063g);
        } else {
            GuildArkContainerHelper.INSTANCE.c(this.f437057a, this.f437063g);
        }
    }

    public ArkAppConfig b() {
        return this.f437061e;
    }

    public com.tencent.qqnt.msg.data.a c() {
        return this.f437059c;
    }

    public ArkViewModelBase.Size d() {
        return this.f437062f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.aio.BaseArkAppContainer, com.tencent.ark.ArkViewModelBase
    public void destroy() {
        super.destroy();
        GuildArkContainerHelper.INSTANCE.e(this.f437057a, this.f437063g);
        this.f437057a = null;
        this.f437058b = null;
    }

    public int e() {
        return this.f437060d;
    }

    public WeakReference<a> f() {
        return this.f437063g;
    }

    public void g(com.tencent.aio.api.runtime.a aVar) {
        this.f437057a = aVar;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public int getChatType() {
        return 7;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public Object getContactData() {
        return this.f437058b;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public Object getMyContext() {
        return a();
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerNick() {
        MsgRecord msgRecord = this.f437058b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getPeerName());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerUid() {
        MsgRecord msgRecord = this.f437058b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getPeerUid());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerUin() {
        MsgRecord msgRecord = this.f437058b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getPeerUin());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getSenderUid() {
        MsgRecord msgRecord = this.f437058b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getSenderUid());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getSenderUin() {
        MsgRecord msgRecord = this.f437058b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getSenderUin());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getTroopUin() {
        MsgRecord msgRecord = this.f437058b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getGuildId());
        }
        return "";
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public String getViewId() {
        MsgRecord msgRecord = this.f437058b;
        if (msgRecord == null) {
            return null;
        }
        return String.valueOf(msgRecord.getMsgId());
    }

    public void h(com.tencent.qqnt.msg.data.a aVar) {
        this.f437059c = aVar;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public boolean hasContactData() {
        if (this.f437058b != null) {
            return true;
        }
        return false;
    }

    public void i(int i3, int i16) {
        this.f437062f = new ArkViewModelBase.Size(i3, i16);
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer, com.tencent.ark.ArkViewModelBase
    public boolean init(String str, String str2, String str3, String str4, String str5, String str6, float f16) {
        boolean z16 = true;
        QLog.d("ArkApp.GuildArkAppContainer", 1, "init appName=" + str + ", appView=" + str2 + ", appMinVersion=" + str3 + ", config=" + str5 + ", bizSrc=" + str6 + ", scale=" + f16);
        GuildArkContainerHelper.INSTANCE.d(this.f437057a, this.f437063g);
        ArkAppConfig arkAppConfig = new ArkAppConfig();
        this.f437061e = arkAppConfig;
        arkAppConfig.fromString(str5);
        Integer num = this.f437061e.round;
        if (num != null && num.intValue() == 0) {
            z16 = false;
        }
        this.mRoundCorner = z16;
        return super.init(str, str2, str3, str4, ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getCurrentAppConfig(), str6, f16);
    }

    @Override // com.tencent.ark.ArkViewModel, com.tencent.ark.ArkViewModelBase
    protected void initLibrary() {
        ark.MediaSetStub(((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getPlayerStubFactory());
    }

    public void j(MsgRecord msgRecord) {
        this.f437058b = msgRecord;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onRunAppFailed() {
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            ark.Application application = this.mApplication;
            if (application != null && application.GetScriptType() == 2 && !ark.Application.JSCLoaded()) {
                this.mErrorInfo.f72565msg = arkViewImplement.getView().getContext().getString(R.string.c2e);
                this.mErrorInfo.canRetry = true;
            } else {
                this.mErrorInfo.f72565msg = arkViewImplement.getView().getContext().getString(R.string.c2j);
                this.mErrorInfo.canRetry = false;
            }
        }
        super.onRunAppFailed();
    }

    public a(boolean z16, com.tencent.aio.api.runtime.a aVar, MsgRecord msgRecord) {
        super(((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getApplicationCallback(), z16 && !((IGuildArkApi) QRoute.api(IGuildArkApi.class)).isEngineDisableHardwareRendering());
        this.f437060d = 0;
        WeakReference<a> weakReference = new WeakReference<>(this);
        this.f437063g = weakReference;
        this.f437057a = aVar;
        this.f437058b = msgRecord;
        GuildArkContainerHelper.INSTANCE.d(aVar, weakReference);
        ((IArkEnvironmentApi) QRoute.api(IArkEnvironmentApi.class)).setScriptLeakCheckEnabled(true);
        ((IArkMultiProcApi) QRoute.api(IArkMultiProcApi.class)).initArkEnv();
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    public void doCloseViewEvent() {
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    public void doOpenCardViewEvent(String str, String str2) {
    }
}
