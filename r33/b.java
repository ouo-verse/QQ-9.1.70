package r33;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qqgift.updatasystem.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.pendant.PendantBusiness;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.quickupdate.ColorScreenBusiness;
import com.tencent.mobileqq.vas.quickupdate.IntimacyDownloadBusiness;
import com.tencent.mobileqq.vas.quickupdate.PraiseDownloadBusiness;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconBusiness;
import com.tencent.mobileqq.vas.quickupdate.RingUpdateBusiness;
import com.tencent.mobileqq.vas.quickupdate.TroopEnterEffectBusiness;
import com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBridge;
import com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBusinessInject;
import com.tencent.mobileqq.vas.updatesystem.api.UpdateSystemFileCheck;
import com.tencent.mobileqq.vas.updatesystem.business.AvatarMaskBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.ColorNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.DiyVipIconDownloadBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.LikeAreaBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.PokeBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.ProfileCardBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QzoneCommentBigVipBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.SonicTemplateUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TestUpdateBusinessV2;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.XAResBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.ZipDownloadBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.f;
import com.tencent.mobileqq.vas.vipicon.NumberDownloadBusiness;
import com.tencent.mobileqq.vas.vipicon.g;
import com.tencent.mobileqq.vas.vipicon.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import sw4.h;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends rw4.a {

    /* renamed from: c, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_QQVasUpdateBusiness.yml", version = 8)
    public static ArrayList<BaseUpdateBusiness> f430676c;

    /* renamed from: d, reason: collision with root package name */
    private static final b f430677d;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList f430678e;

    static {
        ArrayList arrayList = new ArrayList();
        f430678e = arrayList;
        arrayList.add(TroopNickNameBusiness.class);
        f430678e.add(QQValueViewBusiness.class);
        f430678e.add(LikeAreaBusiness.class);
        f430678e.add(ColorNameBusiness.class);
        f430678e.add(XAResBusiness.class);
        f430678e.add(TestUpdateBusinessV2.class);
        f430678e.add(QQGiftResourceBusiness.class);
        f430678e.add(c.class);
        f430678e.add(wd3.a.class);
        f430678e.add(PendantBusiness.class);
        f430678e.add(BubbleBusiness.class);
        f430678e.add(FontBusiness.class);
        f430678e.add(ZipDownloadBusiness.class);
        f430678e.add(f.class);
        f430678e.add(com.tencent.mobileqq.vas.avatar.f.class);
        f430678e.add(DiyVipIconDownloadBusiness.class);
        f430678e.add(g.class);
        f430678e.add(k.class);
        f430678e.add(com.tencent.mobileqq.vas.lovechat.a.class);
        f430678e.add(QQLevelIconBusiness.class);
        f430678e.add(NumberDownloadBusiness.class);
        f430678e.add(IntimacyDownloadBusiness.class);
        f430678e.add(RingUpdateBusiness.class);
        f430678e.add(PraiseDownloadBusiness.class);
        f430678e.add(ColorScreenBusiness.class);
        f430678e.add(TroopEnterEffectBusiness.class);
        f430678e.add(ChatBackgroundBusiness.class);
        f430678e.add(com.tencent.mobileqq.vas.quickupdate.b.class);
        f430678e.add(com.tencent.mobileqq.vas.quickupdate.c.class);
        f430678e.add(com.tencent.mobileqq.vas.quickupdate.a.class);
        f430678e.add(com.tencent.mobileqq.vas.vipicon.a.class);
        f430678e.add(AvatarMaskBusiness.class);
        f430678e.add(com.tencent.mobileqq.zplan.nameplate.f.class);
        f430678e.add(QzoneCommentBigVipBusiness.class);
        f430678e.add(com.tencent.mobileqq.vas.updatesystem.business.g.class);
        f430678e.add(com.tencent.mobileqq.vas.updatesystem.business.a.class);
        f430678e.add(com.tencent.mobileqq.vas.updatesystem.business.b.class);
        f430678e.add(com.tencent.mobileqq.vas.liangnum.b.class);
        f430676c = new ArrayList<>();
        f430677d = new b();
    }

    public b() {
        boolean z16 = true;
        if (VasNtToggle.UPDATE_SYSTEM_FILE_CHECK.isEnable(true)) {
            if (com.tencent.mobileqq.vas.api.g.f308459b.isDebugVersion()) {
                QLog.d("UpdateSystemFileCheck", 1, "true");
            } else {
                int i3 = Calendar.getInstance().get(11);
                if (VipNtMMKV.getCommon().decodeInt("update_system_file_check", -1) != i3) {
                    QLog.d("UpdateSystemFileCheck", 1, "true");
                } else {
                    z16 = false;
                }
                VipNtMMKV.getCommon().encodeInt("update_system_file_check", i3);
            }
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: r33.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.n();
                }
            }, 64, null, false, 10000L);
        }
    }

    public static BaseUpdateBusiness[] k() {
        m();
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(1001L).booleanValue()) {
            f430676c.add(new SonicTemplateUpdateBusiness());
        }
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(15L).booleanValue()) {
            f430676c.add(new ProfileCardBusiness());
        }
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(21L).booleanValue()) {
            f430676c.add(new PokeBusiness());
        }
        try {
            List<QQVasUpdateBusiness<?>> injectList = ((IVasUpdateBusinessInject) QRoute.api(IVasUpdateBusinessInject.class)).getInjectList();
            if (injectList != null && !injectList.isEmpty()) {
                f430676c.addAll(injectList);
            }
        } catch (Exception e16) {
            QLog.w("VasUpdate_QQVasUpdateManager", 1, "add list exception", e16);
        }
        return (BaseUpdateBusiness[]) f430676c.toArray(new BaseUpdateBusiness[0]);
    }

    public static b l() {
        return f430677d;
    }

    @QAutoInitMethod
    public static void m() {
        com.tencent.mobileqq.qroute.utils.b.c(f430678e, f430676c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        UpdateSystemFileCheck updateSystemFileCheck = new UpdateSystemFileCheck();
        updateSystemFileCheck.checkLocalResMd5();
        updateSystemFileCheck.checkBusinessList(c());
    }

    @Override // rw4.a
    protected h b() {
        return com.tencent.mobileqq.vas.updatesystem.impl.g.e();
    }

    @Override // rw4.a
    public BaseUpdateBusiness[] g() {
        return k();
    }

    @Override // rw4.a
    protected BaseUpdateBusiness h() {
        return ((IVasUpdateBridge) QRoute.api(IVasUpdateBridge.class)).getNativeUpdateBusiness();
    }
}
