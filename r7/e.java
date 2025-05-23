package r7;

import SLICE_UPLOAD.cnst.appid_mobilelog;
import SLICE_UPLOAD.cnst.appid_qun;
import SLICE_UPLOAD.cnst.appid_upp;
import SLICE_UPLOAD.cnst.appid_ups;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.uploader.report.BusinessReport;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheFlowerData;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.module.report.ExtendData;
import com.tencent.component.network.module.report.ReportObj;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e implements IUploadReport {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a extends c {
        @Override // com.qzone.misc.network.uploader.report.a
        protected String b() {
            if (this.f48590l) {
                return WidgetCacheFlowerData.WATER;
            }
            return ReportObj.REPORT_REFER_QQ_QUN;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b extends com.qzone.misc.network.uploader.report.a {

        /* renamed from: p, reason: collision with root package name */
        public int f430898p;

        /* renamed from: q, reason: collision with root package name */
        public int f430899q;

        /* renamed from: v, reason: collision with root package name */
        public int f430904v;

        /* renamed from: r, reason: collision with root package name */
        public String f430900r = "";

        /* renamed from: s, reason: collision with root package name */
        public long f430901s = 0;

        /* renamed from: t, reason: collision with root package name */
        public long f430902t = 0;

        /* renamed from: u, reason: collision with root package name */
        public long f430903u = 0;

        /* renamed from: w, reason: collision with root package name */
        public boolean f430905w = false;

        @Override // com.qzone.misc.network.uploader.report.a
        public boolean d() {
            return this.f430904v != 1;
        }

        @Override // com.qzone.misc.network.uploader.report.a
        public JSONObject h() throws JSONException {
            JSONObject h16 = super.h();
            h16.put("ctrlDelay", this.f430901s);
            h16.put("dataDelay", this.f430902t);
            h16.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, this.f430898p);
            h16.put("ipsrctype", this.f430899q);
            h16.put("entry", this.f430900r);
            h16.put("batchCtrlDelayPer", this.f430903u);
            h16.put(AdMetricTag.Report.TYPE, this.f430904v);
            h16.put("ipType", this.f430905w ? 1 : 0);
            return h16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class c extends b {

        /* renamed from: x, reason: collision with root package name */
        public String f430906x = "";

        @Override // r7.e.b, com.qzone.misc.network.uploader.report.a
        public JSONObject h() throws JSONException {
            JSONObject h16 = super.h();
            h16.put("upp_appid", this.f430906x);
            return h16;
        }
    }

    public static int b(TaskTypeConfig taskTypeConfig) {
        if (TaskTypeConfig.NewQunUploadTaskType.equals(taskTypeConfig)) {
            return 10;
        }
        if (TaskTypeConfig.ImageUploadTaskType.equals(taskTypeConfig)) {
            return 0;
        }
        if (TaskTypeConfig.UppUploadTaskType.equals(taskTypeConfig)) {
            return 8;
        }
        if (TaskTypeConfig.UpsUploadTaskType.equals(taskTypeConfig)) {
            return 12;
        }
        if (TaskTypeConfig.PhotoWallUploadTaskType.equals(taskTypeConfig)) {
            return 14;
        }
        if (TaskTypeConfig.MobileLogUploadTaskType.equals(taskTypeConfig)) {
            return 16;
        }
        return TaskTypeConfig.VideoUploadTaskType.equals(taskTypeConfig) ? 2 : -1;
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void onUploadReport(Report report) {
        BusinessReport.h(a(report), b(report.uploadType), 0);
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void openSessionReport(int i3, String str, String str2, int i16) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.CommandId, "uploader.opensession");
        statistic.setValue(WnsKeys.ToUIN, Long.valueOf(LoginData.getInstance().getUin()));
        statistic.setValue(WnsKeys.Qua, QUA.getQUA3());
        statistic.setValue(WnsKeys.ServerIP, str2);
        statistic.setValue(WnsKeys.Port, Integer.valueOf(i16));
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        statistic.setValue(WnsKeys.Detail, str);
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        statisticCollector.put(statistic);
        statisticCollector.forceReport();
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void batchComplete() {
        BusinessReport.i(0, 0);
        BusinessReport.i(10, 0);
        BusinessReport.i(8, 0);
        BusinessReport.i(12, 0);
        BusinessReport.i(14, 0);
        BusinessReport.i(2, 0);
    }

    public static b a(Report report) {
        String str;
        if (report == null) {
            return null;
        }
        ExtendData extendData = new ExtendData();
        if (!TextUtils.isEmpty(report.filePath)) {
            str = new String(report.filePath);
        } else {
            str = "the path of upload file is empty";
        }
        extendData.put(5, str);
        Map<String, String> map = report.transfer;
        if (map != null) {
            String str2 = map.get("task_state");
            if (!TextUtils.isEmpty(str2)) {
                extendData.put(8, str2);
            }
            String str3 = map.get(FSUploadConst.KEY_REFER);
            if (!TextUtils.isEmpty(str3)) {
                extendData.put(9, str3);
            }
        }
        b bVar = new b();
        int b16 = b(report.uploadType);
        if (b16 == 0) {
            bVar = new b();
            bVar.f48589k = "photo";
        } else if (b16 == 8) {
            bVar = new c();
            bVar.f48589k = appid_upp.value;
        } else if (b16 == 10) {
            bVar = new a();
            bVar.f48589k = appid_qun.value;
        } else if (b16 == 12) {
            bVar = new b();
            bVar.f48589k = appid_ups.value;
        } else if (b16 == 14) {
            bVar = new b();
            bVar.f48589k = "photowall";
        } else if (b16 == 16) {
            bVar = new b();
            bVar.f48589k = appid_mobilelog.value;
        }
        bVar.f48581c = report.serverIp;
        bVar.f430898p = report.retry;
        bVar.f430899q = report.ipsrctype;
        bVar.f48584f = report.flowId;
        bVar.f48579a = report.networkType;
        bVar.f48580b = report.retCode;
        bVar.f48582d = report.fileSize;
        long j3 = report.startTime;
        bVar.f48587i = j3;
        long j16 = report.endTime;
        bVar.f48588j = j16;
        bVar.f48583e = j16 - j3;
        StringBuilder sb5 = bVar.f48585g;
        String str4 = report.errMsg;
        if (str4 == null) {
            str4 = "";
        }
        sb5.append(str4);
        bVar.f48586h = extendData;
        bVar.f430900r = report.entry;
        bVar.f430901s = report.ctrlEnd - report.ctrlStart;
        bVar.f430902t = report.dataEnd - report.dataStart;
        bVar.f430904v = report.reportType;
        bVar.f430905w = report.isIPV6;
        return bVar;
    }

    @Override // com.tencent.upload.uinterface.IUploadReport
    public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder, TaskTypeConfig taskTypeConfig) {
    }
}
