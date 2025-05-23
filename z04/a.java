package z04;

import android.app.Application;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import s04.b;
import y04.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public void a(FdLeakIssueResult fdLeakIssueResult, String str) {
        try {
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
            makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
            makeAttributes.put(ReportDataBuilder.KEY_64_BIT_FLAG, BaseInfo.is64Bit);
            makeAttributes.put("fileObj", str);
            makeAttributes.put("stage", com.tencent.rmonitor.common.lifecycle.a.f());
            makeAttributes.put("fd_count", fdLeakIssueResult.getFdCount());
            makeAttributes.put("fd_max_limit", c.l());
            makeAttributes.put("fd_threshold", com.tencent.rmonitor.fd.a.e());
            makeAttributes.put("fd_type", c.m(fdLeakIssueResult.getFdType()));
            makeAttributes.put("fd_issue_content", fdLeakIssueResult.getFdIssueContentJson());
            JSONObject jSONObject = new JSONObject();
            Iterator<FdLeakDumpResult> it = fdLeakIssueResult.getFdDumpList().iterator();
            while (it.hasNext()) {
                int dumpType = it.next().getDumpType();
                if (dumpType != 1) {
                    if (dumpType != 2) {
                        if (dumpType != 3) {
                            if (dumpType != 4) {
                                Logger.f365497g.e("FdLeakReporter", "get file name failed");
                            } else {
                                jSONObject.put("file_stacks", "fd_stacks.txt");
                            }
                        } else {
                            jSONObject.put("heap_info", "heap.hprof");
                        }
                    } else {
                        jSONObject.put("thread_info", "threads.txt");
                    }
                } else {
                    jSONObject.put("fd_info", "fd.txt");
                }
            }
            Application application = BaseInfo.app;
            UserMeta userMeta = BaseInfo.userMeta;
            JSONObject makeParam = ReportDataBuilder.makeParam(application, "memory", BuglyMonitorName.FD_ANALYZE, userMeta);
            makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
            makeParam.put(ReportDataBuilder.KEY_STACK_TYPE, 1);
            ReportData reportData = new ReportData(userMeta.uin, 1, "FdLeakAnalyzed", makeParam);
            reportData.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_WIFI);
            reportData.addFile(str, true, true);
            reportData.setShouldRecordLinkData(true);
            b.j().a(false, reportData);
            b.j().f(reportData);
            ReporterMachine.f365411g.reportNow(reportData, null);
        } catch (JSONException e16) {
            a14.c.b("FdLeakReporter", "reportAnalyzeResult failed: " + e16.getMessage());
        }
    }
}
