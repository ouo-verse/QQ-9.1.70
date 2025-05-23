package rd0;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.biz.qrcode.logindev.NTLoginDeviceManagerHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.cq;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import tencent.im.msg.nt_register_proxy$OnlineInfo;
import tencent.im.msg.nt_register_proxy$PushParams;
import tencent.im.s2c.msgtype0x210.submsgtype0x15d.SubMsgType0x15d$OnlineDevInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g extends cq implements Manager {

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f431108e;

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<f> f431109f;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f431107d = null;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<c> f431110h = null;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends k {
        a() {
        }

        @Override // rd0.k, rd0.j
        public void a(boolean z16, @Nullable Object obj) {
            Object obj2;
            if (z16 && (obj instanceof List)) {
                try {
                    for (Object obj3 : (List) obj) {
                        Iterator it = g.this.f431109f.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                f fVar = (f) it.next();
                                if (obj3.equals(fVar.f431105j)) {
                                    fVar.f431105j = (i) obj3;
                                    break;
                                }
                            }
                        }
                    }
                    if (g.this.f431110h != null) {
                        Iterator it5 = g.this.f431110h.iterator();
                        while (it5.hasNext()) {
                            ((c) it5.next()).p0(g.this.f431109f);
                        }
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("LoginDevicesManager", 1, "onGetTrustDeviceList error : " + e16);
                    return;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGetTrustDeviceList, errCode = ");
            if (obj != null) {
                obj2 = Integer.valueOf(((Integer) obj).intValue());
            } else {
                obj2 = "";
            }
            sb5.append(obj2);
            QLog.i("LoginDevicesManager", 1, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Comparator<f> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            if (fVar.f431102g > fVar2.f431102g) {
                return 1;
            }
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void d0(List<f> list);

        void p0(List<f> list);
    }

    public g(QQAppInterface qQAppInterface) {
        this.f431108e = qQAppInterface;
        qQAppInterface.addObserver(this);
    }

    private boolean i() {
        if (this.f431107d == null) {
            this.f431107d = Boolean.valueOf(SettingCloneUtil.readValue((Context) this.f431108e.getApplication(), this.f431108e.getCurrentUin(), (String) null, AppConstants.QQSETTING_QRLOGIN_SET_MUTE, false));
        }
        return this.f431107d.booleanValue();
    }

    private synchronized void o() {
        ArrayList arrayList = new ArrayList(this.f431109f);
        if (this.f431109f != null && arrayList.size() > 1) {
            Collections.sort(arrayList, new b());
        }
        this.f431109f = new CopyOnWriteArrayList<>(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("LoginDevicesManager", 2, "sortDevicesList size: " + this.f431109f.size());
            Iterator<f> it = this.f431109f.iterator();
            while (it.hasNext()) {
                QLog.d("LoginDevicesManager", 2, "sortDevicesList after sort item: " + it.next());
            }
        }
    }

    @Override // com.tencent.mobileqq.app.cq
    protected void a(boolean z16) {
        this.f431107d = Boolean.valueOf(z16);
    }

    public synchronized int g() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f431109f;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() >= 1) {
            if (this.f431109f.size() > 1) {
                if (this.f431109f.size() == 2) {
                    ArrayList arrayList = new ArrayList(2);
                    Iterator<f> it = this.f431109f.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(it.next().f431098c));
                    }
                    if (arrayList.contains(2) && arrayList.contains(3)) {
                        return 5;
                    }
                    if (arrayList.contains(1) && arrayList.contains(3)) {
                        return 6;
                    }
                }
                return 4;
            }
            return this.f431109f.get(0).f431098c;
        }
        return 0;
    }

    public synchronized String h() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList;
        if (this.f431108e != null && (copyOnWriteArrayList = this.f431109f) != null && copyOnWriteArrayList.size() >= 1) {
            StringBuilder sb5 = new StringBuilder();
            boolean readValue = SettingCloneUtil.readValue((Context) this.f431108e.getApplication(), this.f431108e.getCurrentUin(), (String) null, AppConstants.QQSETTING_QRLOGIN_SET_MUTE, false);
            if (this.f431109f.size() == 1) {
                f fVar = this.f431109f.get(0);
                sb5.append(HardCodeUtil.qqStr(R.string.it5));
                sb5.append(" ");
                sb5.append(fVar.f431100e);
                if (readValue) {
                    sb5.append("\uff0c");
                    sb5.append(HardCodeUtil.qqStr(R.string.ive));
                }
            } else {
                sb5.append(HardCodeUtil.qqStr(R.string.it5));
                sb5.append(" ");
                Iterator<f> it = this.f431109f.iterator();
                while (it.hasNext()) {
                    sb5.append(it.next().f431100e);
                    sb5.append("\u3001");
                }
                if (readValue) {
                    sb5.replace(sb5.length() - 1, sb5.length(), "\uff0c");
                    sb5.append(HardCodeUtil.qqStr(R.string.ive));
                } else {
                    sb5.replace(sb5.length() - 1, sb5.length(), "");
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("LoginDevicesManager", 1, "getBannerTips: " + ((Object) sb5));
            }
            return sb5.toString();
        }
        return "";
    }

    public synchronized String j(Context context) {
        StringBuilder sb5;
        sb5 = new StringBuilder();
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f431109f;
        if (copyOnWriteArrayList != null) {
            Iterator<f> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().f431100e);
                sb5.append("\u3001");
            }
            sb5.deleteCharAt(sb5.lastIndexOf("\u3001"));
        }
        return context.getString(R.string.vo_, sb5.toString());
    }

    public boolean k() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f431109f;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public synchronized boolean l() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f431109f;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        Iterator<f> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (h.b(next.f431097b) && next.f431106k == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        if (k() && i()) {
            return true;
        }
        return false;
    }

    public synchronized void n(c cVar) {
        if (this.f431110h == null) {
            this.f431110h = new ArrayList<>();
        }
        if (!this.f431110h.contains(cVar)) {
            this.f431110h.add(cVar);
        }
        if (cVar != null) {
            cVar.d0(this.f431109f);
        }
    }

    @Override // mqq.manager.Manager
    public synchronized void onDestroy() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f431109f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        ArrayList<c> arrayList = this.f431110h;
        if (arrayList != null) {
            arrayList.clear();
            this.f431110h = null;
        }
        QQAppInterface qQAppInterface = this.f431108e;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this);
        }
    }

    public synchronized void p(c cVar) {
        ArrayList<c> arrayList = this.f431110h;
        if (arrayList != null) {
            arrayList.remove(cVar);
        }
    }

    public boolean q(ArrayList<SubMsgType0x15d$OnlineDevInfo> arrayList) {
        if (arrayList == null) {
            return false;
        }
        CopyOnWriteArrayList<f> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<SubMsgType0x15d$OnlineDevInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            SubMsgType0x15d$OnlineDevInfo next = it.next();
            int i3 = next.client_type.get();
            if (h.a(i3)) {
                f fVar = new f(i3, next.platform_id.get());
                fVar.f431096a = next.instance_id.get();
                if (next.dev_name.get() != null) {
                    fVar.f431104i = new String(next.dev_name.get().toByteArray(), StandardCharsets.UTF_8);
                }
                if (next.encrypt_guid.get() != null && next.app_name.get() != null) {
                    i iVar = new i();
                    iVar.f431113a = next.encrypt_guid.get().toByteArray();
                    iVar.f431114b = next.encrypt_guid_version.get();
                    iVar.f431115c = next.loginsig_appid.get();
                    iVar.f431116d = next.app_name.get().toByteArray();
                    fVar.f431105j = iVar;
                    QLog.d("LoginDevicesManager", 1, "updateDevListByOnlinePush, NTLoginApp = " + iVar);
                }
                fVar.f431106k = next.lock_status.get();
                copyOnWriteArrayList.add(fVar);
                QLog.d("LoginDevicesManager", 1, "updateDevListByOnlinePush, " + fVar);
            }
        }
        this.f431109f = copyOnWriteArrayList;
        o();
        QLog.d("LoginDevicesManager", 1, "updateDevListByOnlinePush size:", Integer.valueOf(this.f431109f.size()));
        ArrayList<c> arrayList2 = this.f431110h;
        if (arrayList2 != null) {
            Iterator<c> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                it5.next().d0(this.f431109f);
            }
        }
        if (this.f431109f.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean r(nt_register_proxy$PushParams nt_register_proxy_pushparams) {
        if (nt_register_proxy_pushparams == null || nt_register_proxy_pushparams.online_infos.get() == null) {
            return false;
        }
        CopyOnWriteArrayList<f> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (nt_register_proxy$OnlineInfo nt_register_proxy_onlineinfo : nt_register_proxy_pushparams.online_infos.get()) {
            if (nt_register_proxy_onlineinfo.online_stat.get() != 0) {
                int i3 = nt_register_proxy_onlineinfo.client_type_new.get();
                int i16 = nt_register_proxy_onlineinfo.platform_id.get();
                if (h.a(i3)) {
                    f fVar = new f(i3, i16);
                    fVar.f431096a = nt_register_proxy_onlineinfo.instance_id.get();
                    if (nt_register_proxy_onlineinfo.device_name.get() != null) {
                        fVar.f431104i = new String(nt_register_proxy_onlineinfo.device_name.get().toByteArray(), StandardCharsets.UTF_8);
                    }
                    if (nt_register_proxy_onlineinfo.encrypt_guid.get() != null && nt_register_proxy_onlineinfo.app_name.get() != null) {
                        i iVar = new i();
                        iVar.f431113a = nt_register_proxy_onlineinfo.encrypt_guid.get().toByteArray();
                        iVar.f431114b = nt_register_proxy_onlineinfo.encrypt_guid_version.get();
                        iVar.f431115c = nt_register_proxy_onlineinfo.login_sig_appid.get();
                        iVar.f431116d = nt_register_proxy_onlineinfo.app_name.get().toByteArray();
                        fVar.f431105j = iVar;
                        QLog.d("LoginDevicesManager", 1, "updateDevListByRegProxy, NTLoginApp = " + iVar);
                    }
                    fVar.f431106k = nt_register_proxy_onlineinfo.lock_status.get();
                    copyOnWriteArrayList.add(fVar);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("LoginDevicesManager", 4, "updateDevListByRegProxy, " + fVar);
                    }
                }
            }
        }
        this.f431109f = copyOnWriteArrayList;
        o();
        QLog.d("LoginDevicesManager", 1, "updateDevListByRegPrxy size:", Integer.valueOf(this.f431109f.size()));
        ArrayList<c> arrayList = this.f431110h;
        if (arrayList != null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().d0(this.f431109f);
            }
        }
        if (this.f431109f.size() <= 0) {
            return false;
        }
        return true;
    }

    public synchronized void s(long j3, int i3) {
        if (this.f431110h != null && this.f431109f.size() != 0) {
            Iterator<f> it = this.f431109f.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (j3 == next.f431096a) {
                    if (next.f431106k == i3) {
                        QLog.e("LoginDevicesManager", 1, "updateLockStatus fail lock status is same");
                        return;
                    }
                    next.f431106k = i3;
                    Iterator<c> it5 = this.f431110h.iterator();
                    while (it5.hasNext()) {
                        it5.next().d0(this.f431109f);
                    }
                    return;
                }
            }
            QLog.e("LoginDevicesManager", 1, "updateLockStatus failed not found this devItem.");
            return;
        }
        QLog.e("LoginDevicesManager", 1, "updateLockStatus mLoginDevItemList is null!!");
    }

    public void t() {
        ArrayList arrayList = new ArrayList();
        Iterator<f> it = this.f431109f.iterator();
        while (it.hasNext()) {
            f next = it.next();
            i iVar = next.f431105j;
            if (iVar != null && !iVar.b()) {
                arrayList.add(next.f431105j);
            }
        }
        if (arrayList.size() <= 0) {
            QLog.i("LoginDevicesManager", 1, "needn't updateTrustedDevice");
        } else {
            ((NTLoginDeviceManagerHandler) this.f431108e.getBusinessHandler(NTLoginDeviceManagerHandler.class.getName())).J2(arrayList, new a());
        }
    }
}
