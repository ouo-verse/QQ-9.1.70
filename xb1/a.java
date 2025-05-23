package xb1;

import com.tencent.gamematrix.gmcg.api.GmCgKingsHonorMidGameErrorCode;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cu;
import com.tencent.weiyun.transmission.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends wb1.a {

    /* renamed from: b, reason: collision with root package name */
    public final wb1.b f447737b;

    /* renamed from: c, reason: collision with root package name */
    private ExcitingTransferDownloaderFirstPkgRp f447738c;

    /* renamed from: d, reason: collision with root package name */
    private ExcitingTransferDownloadCompletedInfo f447739d;

    /* renamed from: e, reason: collision with root package name */
    private long f447740e;

    /* renamed from: f, reason: collision with root package name */
    private long f447741f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f447742g;

    /* renamed from: h, reason: collision with root package name */
    int f447743h;

    /* renamed from: i, reason: collision with root package name */
    int f447744i;

    /* renamed from: j, reason: collision with root package name */
    int f447745j;

    /* renamed from: k, reason: collision with root package name */
    List<Integer> f447746k;

    /* renamed from: l, reason: collision with root package name */
    Map<Integer, Integer> f447747l;

    public a(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f447737b = new wb1.b();
        this.f447738c = null;
        this.f447739d = null;
        this.f447740e = 0L;
        this.f447741f = 0L;
        this.f447742g = false;
        this.f447743h = 0;
        this.f447744i = 0;
        this.f447745j = 0;
        this.f447746k = null;
        this.f447747l = null;
    }

    private long j(long j3, int i3) {
        if (j3 == 9004) {
            return j3;
        }
        if (j3 != 0 && i3 != 0) {
            m();
            if (this.f447746k.indexOf(Integer.valueOf(i3)) >= 0) {
                return 9042L;
            }
            return i3;
        }
        l();
        if (j3 < 300) {
            int i16 = (int) j3;
            if (i16 == 0) {
                return 0L;
            }
            if (i16 != 101) {
                if (i16 == 201) {
                    return 9001L;
                }
            } else {
                return 9037L;
            }
        }
        if (!AppNetConnInfo.isNetSupport() || this.f445358a.isLogin()) {
            return 9004L;
        }
        l();
        if (this.f447747l.containsKey(Long.valueOf(j3))) {
            return this.f447747l.get(Long.valueOf(j3)).intValue();
        }
        switch ((int) j3) {
            case 501:
            case 502:
            case 503:
            case 505:
                if (k()) {
                    return 9040L;
                }
                return 9003L;
            case 504:
                return 9082L;
            case 506:
                return 9040L;
            default:
                return j3;
        }
    }

    private boolean k() {
        long c16;
        if (cu.e()) {
            c16 = cu.b();
        } else {
            c16 = cu.c();
        }
        if (this.f447737b.f445365g > c16 * 1024) {
            return true;
        }
        return false;
    }

    @Override // wb1.a
    protected String a(boolean z16) {
        if (z16) {
            return "actFileDown";
        }
        return "actPDFileDownload";
    }

    @Override // wb1.a
    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo = this.f447739d;
        if (excitingTransferDownloadCompletedInfo != null) {
            hashMap.put("serverip", String.valueOf(excitingTransferDownloadCompletedInfo.mstrLastServerHost));
            hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, String.valueOf(this.f447739d.mstrLastServerHost));
            hashMap.put("param_ftnIP", String.valueOf(this.f447739d.mstrLastServerHost));
            hashMap.put("param_retry", String.valueOf(this.f447739d.muRetryTimes));
            hashMap.put("param_FailCode", String.valueOf(j(this.f447737b.f445360b, this.f447739d.mnSrvReturnCode)));
            hashMap.put("param_fsized", String.valueOf(this.f447739d.muDownloadedSize));
            hashMap.put("param_ipStackType", String.valueOf(QFileUtils.O()));
            hashMap.put("param_realTransferType", String.valueOf(this.f447739d.muProxyType));
            ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo2 = this.f447739d;
            long j3 = excitingTransferDownloadCompletedInfo2.muTotalTimes;
            if (j3 != 0) {
                hashMap.put("param_speed", String.valueOf(((float) (excitingTransferDownloadCompletedInfo2.muDownloadedSize / 1048576)) / ((float) j3)));
            } else {
                hashMap.put("param_speed", "0");
            }
        } else {
            hashMap.put("param_FailCode", String.valueOf(this.f447737b.f445360b));
        }
        hashMap.put(ReportConstant.KEY_UUID, "");
        hashMap.put("param_MD5", "");
        hashMap.put("param_fsizeo", String.valueOf(this.f447737b.f445365g));
        hashMap.put("param_PeerUin", String.valueOf(this.f447737b.f445363e));
        hashMap.put("param_url", "");
        hashMap.put("param_rspHeader", "");
        hashMap.put("param_nSessionId", "");
        hashMap.put("param_fromType", "1");
        hashMap.put("param_V6SelectType", String.valueOf(this.f447743h));
        hashMap.put("param_ipAddrType", String.valueOf(this.f447744i));
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(this.f447745j));
        return hashMap;
    }

    @Override // wb1.a
    protected HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        wb1.b bVar = this.f447737b;
        if (bVar != null) {
            hashMap.putAll(bVar.a());
        }
        hashMap.put("param_SubReason", String.valueOf(this.f447740e));
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = this.f447738c;
        if (excitingTransferDownloaderFirstPkgRp != null) {
            hashMap.putAll(excitingTransferDownloaderFirstPkgRp.getReportData());
        }
        ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo = this.f447739d;
        if (excitingTransferDownloadCompletedInfo != null) {
            hashMap.putAll(excitingTransferDownloadCompletedInfo.getReportData());
        }
        long j3 = this.f447741f;
        if (j3 != 0) {
            hashMap.put("param_SrvRetCode", String.valueOf(j3));
        }
        hashMap.put("param_V6SelectType", String.valueOf(this.f447743h));
        hashMap.put("param_ipAddrType", String.valueOf(this.f447744i));
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(this.f447745j));
        return hashMap;
    }

    @Override // wb1.a
    public void e() {
        wb1.b bVar = this.f447737b;
        bVar.f445359a = 5L;
        this.f447740e = 3L;
        bVar.f445360b = 9004L;
        d(false);
    }

    @Override // wb1.a
    protected boolean g() {
        return true;
    }

    @Override // wb1.a
    public void i() {
        wb1.b bVar = this.f447737b;
        bVar.f445359a = 1L;
        if (this.f447742g) {
            this.f447740e = 3L;
        } else {
            this.f447740e = 2L;
        }
        bVar.f445360b = 9037L;
        d(false);
    }

    protected void l() {
        if (this.f447747l != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.f447747l = hashMap;
        hashMap.put(300, 9052);
        this.f447747l.put(301, 9052);
        this.f447747l.put(302, 9052);
        this.f447747l.put(303, 9052);
        this.f447747l.put(400, 9052);
        this.f447747l.put(304, 304);
        this.f447747l.put(305, 305);
        this.f447747l.put(306, 306);
        this.f447747l.put(307, 307);
        this.f447747l.put(308, 308);
        this.f447747l.put(401, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_DECODE_EXP));
        this.f447747l.put(402, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_HTTP_CODE_OTHER));
        this.f447747l.put(403, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_NET_CONNECT_TIMEOUT));
        this.f447747l.put(405, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_EXP_DECODER));
        this.f447747l.put(406, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_EXP_DECODER));
        this.f447747l.put(407, 9009);
        this.f447747l.put(408, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE));
        this.f447747l.put(404, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_EXP_EOF));
    }

    protected void m() {
        if (this.f447746k != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f447746k = arrayList;
        arrayList.add(-29120);
        this.f447746k.add(-29120);
        this.f447746k.add(Integer.valueOf(ErrorCode.FTN_DOWN_KEY_TOO_MANY));
        this.f447746k.add(-21122);
        this.f447746k.add(-28123);
        this.f447746k.add(-25081);
        this.f447746k.add(-28126);
        this.f447746k.add(-6101);
        this.f447746k.add(Integer.valueOf(MessageRecord.MSG_TYPE_HR_INFO));
        this.f447746k.add(Integer.valueOf(com.qq.wx.voice.util.ErrorCode.WX_TTS_ERROR_TEXT_OVER_LENGTH));
        this.f447746k.add(Integer.valueOf(GmCgKingsHonorMidGameErrorCode.AgentGameBeginFail));
        this.f447746k.add(Integer.valueOf(GmCgKingsHonorMidGameErrorCode.AgentStepRopFail));
        this.f447746k.add(-9017);
        this.f447746k.add(-2813);
    }

    public void n() {
        this.f447738c.mCSEndTime = e.K0();
    }

    public void o() {
        if (this.f447738c != null) {
            return;
        }
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
        this.f447738c = excitingTransferDownloaderFirstPkgRp;
        excitingTransferDownloaderFirstPkgRp.mCSStartTime = e.K0();
    }

    public void p(long j3) {
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = this.f447738c;
        if (excitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize != -1) {
            return;
        }
        excitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = j3;
    }

    public void q() {
        this.f447742g = true;
    }

    public void r(long j3) {
        wb1.b bVar = this.f447737b;
        bVar.f445359a = 2L;
        this.f447740e = 2L;
        bVar.f445360b = j3;
        d(false);
    }

    public void s(long j3) {
        wb1.b bVar = this.f447737b;
        bVar.f445359a = 2L;
        this.f447740e = 7L;
        this.f447741f = j3;
        bVar.f445360b = j3;
        d(false);
    }

    public void t(int i3, int i16, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete) {
        wb1.b bVar = new wb1.b();
        wb1.b bVar2 = this.f447737b;
        bVar.f445364f = bVar2.f445364f;
        bVar.f445361c = bVar2.f445361c;
        bVar.f445363e = bVar2.f445363e;
        bVar.f445362d = bVar2.f445362d;
        bVar.f445365g = bVar2.f445365g;
        bVar.f445359a = i3;
        bVar.f445360b = i16;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_V6SelectType", String.valueOf(this.f447743h));
        if (excitingTransferOneSlotComplete != null) {
            hashMap.put("param_ipAddrType", String.valueOf(QFileUtils.P(excitingTransferOneSlotComplete.mstrIp)));
        } else {
            hashMap.put("param_ipAddrType", String.valueOf(0));
        }
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(this.f447745j));
        super.h(bVar, excitingTransferOneSlotComplete, hashMap);
    }

    public void u(ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo) {
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = this.f447738c;
        excitingTransferDownloaderFirstPkgRp.mHttpFirstTime = excitingTransferDownloadCompletedInfo.muFirstRecvDataTime - excitingTransferDownloadCompletedInfo.muStartTime;
        excitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = excitingTransferDownloadCompletedInfo.muFirstRecvDataSize;
        this.f447739d = excitingTransferDownloadCompletedInfo;
    }

    public void v(int i3) {
        this.f447744i = i3;
    }

    public void w(boolean z16) {
        this.f447745j = z16 ? 1 : 0;
    }

    public void x(int i3) {
        this.f447740e = i3;
    }

    public void y(int i3) {
        this.f447743h = i3;
    }
}
