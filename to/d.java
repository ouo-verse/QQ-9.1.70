package to;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.proxy.feedcomponent.widget.c;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.module.report.BusinessReport;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends AsyncTask<String, Void, Object> implements com.qzone.proxy.feedcomponent.widget.c {
    public static int K;
    private ReportHandler.DownloadReportObject D;

    /* renamed from: d, reason: collision with root package name */
    private String f436999d;

    /* renamed from: e, reason: collision with root package name */
    private String f437000e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f437001f;

    /* renamed from: h, reason: collision with root package name */
    private String f437002h;

    /* renamed from: i, reason: collision with root package name */
    private c.a f437003i;

    /* renamed from: m, reason: collision with root package name */
    private Context f437004m;
    private int C = -99999;
    private String E = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DownloadFileNotExist", "\u4e0b\u8f7d\u6587\u4ef6\u4e0d\u5b58\u5728");
    private String F = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VoiceCannotPlayForMemory", "\u5b58\u50a8\u5361\u5269\u4f59\u7a7a\u95f4\u4e0d\u8db3\uff0c\u8bed\u97f3\u65e0\u6cd5\u64ad\u653e");
    private String G = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VoiceCannotPlayForStore", "\u672c\u5730\u5b58\u50a8\u8bfb\u53d6\u5931\u8d25\uff0c\u65e0\u6cd5\u6b63\u5e38\u64ad\u653e\u8bed\u97f3");
    private String H = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "FileNotExistWait", "\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u88ab\u5220\u9664\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5");
    private String I = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VoiceFileReadFail", "\u8bed\u97f3\u6587\u4ef6\u8bfb\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5");
    private String J = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5");

    public d(String str, String str2, Context context) {
        ReportHandler.DownloadReportObject downloadReportObject = new ReportHandler.DownloadReportObject();
        this.D = downloadReportObject;
        downloadReportObject.retCode = -99999;
        o(str);
        n(str2);
        m(context);
    }

    private String f(String str, String str2) {
        File file = new File(str);
        if (file.exists() && file.length() > 0) {
            if (QZLog.isColorLevel()) {
                QZLog.i("HttpLoadFileTask", 2, "doInBackground filePath exsits" + this.f437000e);
            }
            this.C = K;
            return str;
        }
        this.f437002h = this.G;
        QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground checkIsLocalUrl: url: " + str + " filePath: " + this.f437000e);
        return str2;
    }

    private boolean g(String str) {
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        this.f437002h = this.F;
        QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground checkFilePath: url: " + this.f436999d + " filePath: " + str);
        return true;
    }

    private boolean h(String str) {
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        this.f437002h = this.E;
        QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground checkUrl: url: " + str + " filePath: " + this.f437000e);
        return true;
    }

    private Executor i() {
        if (PlatformUtil.version() >= 11) {
            return AsyncTask.THREAD_POOL_EXECUTOR;
        }
        return null;
    }

    private void j(Throwable th5, ReportHandler.DownloadReportObject downloadReportObject, int i3) {
        this.C = i3;
        if (th5 != null) {
            downloadReportObject.errMsg.append(QZLog.getStackTraceString(th5));
        }
        if (downloadReportObject.startTime > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            downloadReportObject.endTime = currentTimeMillis;
            downloadReportObject.elapse = currentTimeMillis - downloadReportObject.startTime;
        }
        downloadReportObject.networkType = NetworkState.getNetworkType();
        downloadReportObject.retCode = i3;
        BusinessReport.uploadReport(downloadReportObject, 4, 1);
    }

    private void k(ReportHandler.DownloadReportObject downloadReportObject) {
        this.C = K;
        long currentTimeMillis = System.currentTimeMillis();
        downloadReportObject.endTime = currentTimeMillis;
        downloadReportObject.elapse = currentTimeMillis - downloadReportObject.startTime;
        downloadReportObject.networkType = NetworkState.getNetworkType();
        downloadReportObject.retCode = 0;
        BusinessReport.uploadReport(downloadReportObject, 4, 1);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.c
    public void a(c.a aVar) {
        this.f437003i = aVar;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.c
    public final void b() {
        Executor i3 = i();
        if (i3 != null && PlatformUtil.version() >= 11) {
            super.executeOnExecutor(i3, new String[0]);
        } else {
            super.execute(new String[0]);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.c
    public void c(String[] strArr) {
        this.f437001f = strArr;
    }

    public void m(Context context) {
        this.f437004m = context;
    }

    public void n(String str) {
        this.f437000e = str;
    }

    public void o(String str) {
        this.f436999d = str;
        this.D.setUrl(str);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        String str;
        if (obj == null) {
            if (this.f437003i != null) {
                QZLog.e("HttpLoadFileTask", "onPostExecute failed url :" + this.f436999d);
                c.a aVar = this.f437003i;
                int i3 = this.C;
                String str2 = this.f436999d;
                if (TextUtils.isEmpty(this.f437002h)) {
                    str = this.I;
                } else {
                    str = this.f437002h;
                }
                aVar.onUploadError(i3, str2, str);
                return;
            }
            return;
        }
        if (this.f437003i != null) {
            if (QZLog.isColorLevel()) {
                QZLog.i("HttpLoadFileTask", 2, "onPostExecute succeed url :" + this.f436999d);
            }
            this.f437003i.onUploadSucceed(this.f436999d, (String) obj);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (QZLog.isColorLevel()) {
            QZLog.i("HttpLoadFileTask", 2, "onPreExecute url :" + this.f436999d);
        }
        c.a aVar = this.f437003i;
        if (aVar != null) {
            aVar.onLoadFileStart();
        }
    }

    private static HttpClient d(Context context) {
        HttpClient a16 = e.a(true);
        HttpParams params = a16.getParams();
        HttpProtocolParams.setContentCharset(params, "UTF-8");
        HttpConnectionParams.setSoTimeout(params, 60000);
        return a16;
    }

    private String l(String str) {
        if (str == null) {
            str = "";
        }
        if (!str.startsWith("/")) {
            return str;
        }
        return "file://" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(22:39|(1:43)|44|45|46|47|48|49|(2:50|(1:52)(1:53))|54|(1:323)(1:58)|59|(1:61)(1:322)|62|(6:66|(1:68)(1:82)|69|(4:75|(2:76|(1:78)(1:79))|80|81)(1:73)|74|63)|(6:85|(1:87)|88|(1:90)|91|(8:93|94|95|96|97|99|100|(2:102|103)))(1:320)|319|96|97|99|100|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0434, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0632, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04f1, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04b2, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0473, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x05b1, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0630, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x05f1, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0531, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0571, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x03f5, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x03b6, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0377, code lost:
    
        if (r8 == 0) goto L297;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x027a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v81 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v100 */
    /* JADX WARN: Type inference failed for: r5v101 */
    /* JADX WARN: Type inference failed for: r5v102 */
    /* JADX WARN: Type inference failed for: r5v103 */
    /* JADX WARN: Type inference failed for: r5v104 */
    /* JADX WARN: Type inference failed for: r5v105 */
    /* JADX WARN: Type inference failed for: r5v106 */
    /* JADX WARN: Type inference failed for: r5v107 */
    /* JADX WARN: Type inference failed for: r5v108 */
    /* JADX WARN: Type inference failed for: r5v109 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v110 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r5v96 */
    /* JADX WARN: Type inference failed for: r5v97 */
    /* JADX WARN: Type inference failed for: r5v98 */
    /* JADX WARN: Type inference failed for: r5v99 */
    /* JADX WARN: Type inference failed for: r8v109 */
    /* JADX WARN: Type inference failed for: r8v111 */
    /* JADX WARN: Type inference failed for: r8v113 */
    /* JADX WARN: Type inference failed for: r8v115 */
    /* JADX WARN: Type inference failed for: r8v117 */
    /* JADX WARN: Type inference failed for: r8v119 */
    /* JADX WARN: Type inference failed for: r8v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v121 */
    /* JADX WARN: Type inference failed for: r8v123 */
    /* JADX WARN: Type inference failed for: r8v125 */
    /* JADX WARN: Type inference failed for: r8v127 */
    /* JADX WARN: Type inference failed for: r8v129 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v131 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doInBackground(String... strArr) {
        Throwable th5;
        Throwable th6;
        ByteArrayOutputStream byteArrayOutputStream;
        FileOutputStream fileOutputStream;
        Exception exc;
        IOException iOException;
        ConnectTimeoutException connectTimeoutException;
        ClientProtocolException clientProtocolException;
        NoHttpResponseException noHttpResponseException;
        SSLPeerUnverifiedException sSLPeerUnverifiedException;
        UnknownHostException unknownHostException;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        IllegalStateException illegalStateException;
        FileNotFoundException fileNotFoundException;
        String str;
        FileOutputStream fileOutputStream2;
        String str2;
        FileOutputStream fileOutputStream3;
        String str3;
        FileOutputStream fileOutputStream4;
        String str4;
        FileOutputStream fileOutputStream5;
        String str5;
        FileOutputStream fileOutputStream6;
        String str6;
        FileOutputStream fileOutputStream7;
        String str7;
        FileOutputStream fileOutputStream8;
        String str8;
        FileOutputStream fileOutputStream9;
        String str9;
        FileOutputStream fileOutputStream10;
        String str10;
        FileOutputStream fileOutputStream11;
        String str11;
        FileOutputStream fileOutputStream12;
        String str12;
        FileOutputStream fileOutputStream13;
        String str13;
        FileOutputStream fileOutputStream14;
        String lowerCase;
        FileOutputStream fileOutputStream15;
        ?? r56 = 2;
        ?? r57 = 2;
        if (QZLog.isColorLevel()) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 2, "HttpLoadFileTask doInBackground download: url: " + this.f436999d + " filePath: " + this.f437000e);
        }
        String str14 = null;
        str14 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        String str15 = null;
        str14 = null;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        InputStream inputStream4 = null;
        InputStream inputStream5 = null;
        InputStream inputStream6 = null;
        InputStream inputStream7 = null;
        InputStream inputStream8 = null;
        InputStream inputStream9 = null;
        InputStream inputStream10 = null;
        InputStream inputStream11 = null;
        InputStream inputStream12 = null;
        ?? r46 = 0;
        str14 = null;
        try {
        } catch (Throwable th7) {
            th5 = th7;
        }
        if (!h(this.f436999d) && !g(this.f437000e)) {
            if (URLUtil.isFileUrl(l(this.f436999d))) {
                return f(this.f436999d, null);
            }
            File file = new File(this.f437000e);
            if (file.exists() && file.length() > 0) {
                if (QZLog.isColorLevel()) {
                    QZLog.i("HttpLoadFileTask", 2, "doInBackground filePath exsits" + this.f437000e);
                }
                String str16 = this.f437000e;
                this.C = K;
                return str16;
            }
            if (!NetworkState.isNetSupport()) {
                j(null, this.D, -99997);
                this.f437002h = this.J;
                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground isNetworkConnected: url: " + this.f436999d + " filePath: " + this.f437000e);
                return null;
            }
            ?? isNetSupport = NetworkState.isNetSupport();
            try {
                try {
                    if (isNetSupport == 0) {
                        j(null, this.D, -99997);
                    } else {
                        try {
                            this.D.startTime = System.currentTimeMillis();
                            URI uri = new URI(this.f436999d);
                            HttpResponse execute = d(this.f437004m).execute(new HttpHost(uri.getHost(), uri.getPort(), "http"), new HttpGet(this.f436999d));
                            int statusCode = execute.getStatusLine().getStatusCode();
                            if (statusCode != 200) {
                                this.f437002h = this.H;
                                j(null, this.D, statusCode);
                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " Http\u8bf7\u6c42\u5931\u8d25 " + statusCode);
                                return null;
                            }
                            Header[] headers = execute.getHeaders("Content-Length");
                            if (headers != null && headers.length > 0) {
                                this.D.fileSize = Long.parseLong(headers[0].getValue());
                            }
                            HttpEntity entity = execute.getEntity();
                            InputStream content = entity.getContent();
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = content.read(bArr, 0, 1024);
                                        if (read <= 0) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                    String[] strArr2 = this.f437001f;
                                    boolean z16 = strArr2 != null && strArr2.length > 0;
                                    String value = entity.getContentType().getValue();
                                    if (value == null) {
                                        lowerCase = "";
                                    } else {
                                        lowerCase = value.toLowerCase();
                                    }
                                    int length = this.f437001f.length;
                                    boolean z17 = false;
                                    for (int i3 = 0; i3 < length && z16; i3++) {
                                        z17 |= lowerCase.indexOf(this.f437001f[i3]) != -1;
                                        if (lowerCase.indexOf("text/html") != -1 || lowerCase.indexOf("text/plain") != -1) {
                                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
                                            StringBuffer stringBuffer = new StringBuffer();
                                            while (true) {
                                                String readLine = bufferedReader.readLine();
                                                if (readLine == null) {
                                                    break;
                                                }
                                                stringBuffer.append(readLine);
                                            }
                                            this.f437002h = stringBuffer.toString();
                                        }
                                    }
                                    if (!z17) {
                                        File file2 = new File(this.f437000e);
                                        File parentFile = file2.getParentFile();
                                        if (!parentFile.exists()) {
                                            parentFile.mkdirs();
                                        }
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        if (file2.createNewFile()) {
                                            FileOutputStream fileOutputStream16 = new FileOutputStream(file2);
                                            try {
                                                fileOutputStream16.write(byteArrayOutputStream.toByteArray());
                                                fileOutputStream16.close();
                                                str15 = this.f437000e;
                                                k(this.D);
                                                str14 = str15;
                                                fileOutputStream15 = fileOutputStream16;
                                                content.close();
                                                byteArrayOutputStream.close();
                                                if (fileOutputStream15 != null) {
                                                    try {
                                                        fileOutputStream15.close();
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                            } catch (FileNotFoundException e16) {
                                                fileNotFoundException = e16;
                                                str13 = str15;
                                                fileOutputStream14 = fileOutputStream16;
                                                inputStream = content;
                                                r56 = str13;
                                                isNetSupport = fileOutputStream14;
                                                j(fileNotFoundException, this.D, 1);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + fileNotFoundException.getMessage(), fileNotFoundException);
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException unused2) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused3) {
                                                    }
                                                }
                                            } catch (IllegalStateException e17) {
                                                illegalStateException = e17;
                                                str12 = str15;
                                                fileOutputStream13 = fileOutputStream16;
                                                inputStream2 = content;
                                                r56 = str12;
                                                isNetSupport = fileOutputStream13;
                                                j(illegalStateException, this.D, 5);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + illegalStateException.getMessage(), illegalStateException);
                                                if (inputStream2 != null) {
                                                    try {
                                                        inputStream2.close();
                                                    } catch (IOException unused4) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused5) {
                                                    }
                                                }
                                            } catch (SocketException e18) {
                                                socketException = e18;
                                                str10 = str15;
                                                fileOutputStream11 = fileOutputStream16;
                                                inputStream4 = content;
                                                r56 = str10;
                                                isNetSupport = fileOutputStream11;
                                                j(socketException, this.D, 6);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + socketException.getMessage(), socketException);
                                                if (inputStream4 != null) {
                                                    try {
                                                        inputStream4.close();
                                                    } catch (IOException unused6) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused7) {
                                                    }
                                                }
                                            } catch (SocketTimeoutException e19) {
                                                socketTimeoutException = e19;
                                                str9 = str15;
                                                fileOutputStream10 = fileOutputStream16;
                                                inputStream5 = content;
                                                r56 = str9;
                                                isNetSupport = fileOutputStream10;
                                                j(socketTimeoutException, this.D, 7);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + socketTimeoutException.getMessage(), socketTimeoutException);
                                                if (inputStream5 != null) {
                                                    try {
                                                        inputStream5.close();
                                                    } catch (IOException unused8) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused9) {
                                                    }
                                                }
                                            } catch (UnknownHostException e26) {
                                                unknownHostException = e26;
                                                str8 = str15;
                                                fileOutputStream9 = fileOutputStream16;
                                                inputStream6 = content;
                                                r56 = str8;
                                                isNetSupport = fileOutputStream9;
                                                j(unknownHostException, this.D, 9);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + unknownHostException.getMessage(), unknownHostException);
                                                if (inputStream6 != null) {
                                                    try {
                                                        inputStream6.close();
                                                    } catch (IOException unused10) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused11) {
                                                    }
                                                }
                                            } catch (SSLPeerUnverifiedException e27) {
                                                sSLPeerUnverifiedException = e27;
                                                str7 = str15;
                                                fileOutputStream8 = fileOutputStream16;
                                                inputStream7 = content;
                                                r56 = str7;
                                                isNetSupport = fileOutputStream8;
                                                j(sSLPeerUnverifiedException, this.D, 12);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + sSLPeerUnverifiedException.getMessage(), sSLPeerUnverifiedException);
                                                if (inputStream7 != null) {
                                                    try {
                                                        inputStream7.close();
                                                    } catch (IOException unused12) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused13) {
                                                    }
                                                }
                                            } catch (NoHttpResponseException e28) {
                                                noHttpResponseException = e28;
                                                str6 = str15;
                                                fileOutputStream7 = fileOutputStream16;
                                                inputStream8 = content;
                                                r56 = str6;
                                                isNetSupport = fileOutputStream7;
                                                j(noHttpResponseException, this.D, 11);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + noHttpResponseException.getMessage(), noHttpResponseException);
                                                if (inputStream8 != null) {
                                                    try {
                                                        inputStream8.close();
                                                    } catch (IOException unused14) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused15) {
                                                    }
                                                }
                                            } catch (ClientProtocolException e29) {
                                                clientProtocolException = e29;
                                                str5 = str15;
                                                fileOutputStream6 = fileOutputStream16;
                                                inputStream9 = content;
                                                r56 = str5;
                                                isNetSupport = fileOutputStream6;
                                                j(clientProtocolException, this.D, 8);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + clientProtocolException.getMessage(), clientProtocolException);
                                                if (inputStream9 != null) {
                                                    try {
                                                        inputStream9.close();
                                                    } catch (IOException unused16) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused17) {
                                                    }
                                                }
                                            } catch (ConnectTimeoutException e36) {
                                                connectTimeoutException = e36;
                                                str4 = str15;
                                                fileOutputStream5 = fileOutputStream16;
                                                inputStream10 = content;
                                                r56 = str4;
                                                isNetSupport = fileOutputStream5;
                                                j(connectTimeoutException, this.D, 10);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + connectTimeoutException.getMessage(), connectTimeoutException);
                                                if (inputStream10 != null) {
                                                    try {
                                                        inputStream10.close();
                                                    } catch (IOException unused18) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused19) {
                                                    }
                                                }
                                            } catch (IOException e37) {
                                                iOException = e37;
                                                str3 = str15;
                                                fileOutputStream4 = fileOutputStream16;
                                                inputStream11 = content;
                                                r56 = str3;
                                                isNetSupport = fileOutputStream4;
                                                j(iOException, this.D, 2);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + iOException.getMessage(), iOException);
                                                if (inputStream11 != null) {
                                                    try {
                                                        inputStream11.close();
                                                    } catch (IOException unused20) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused21) {
                                                    }
                                                }
                                            } catch (Exception e38) {
                                                exc = e38;
                                                str2 = str15;
                                                fileOutputStream3 = fileOutputStream16;
                                                inputStream12 = content;
                                                r56 = str2;
                                                isNetSupport = fileOutputStream3;
                                                j(exc, this.D, 4);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + exc.getMessage(), exc);
                                                if (inputStream12 != null) {
                                                    try {
                                                        inputStream12.close();
                                                    } catch (IOException unused22) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused23) {
                                                    }
                                                }
                                            } catch (OutOfMemoryError e39) {
                                                outOfMemoryError = e39;
                                                str11 = str15;
                                                fileOutputStream12 = fileOutputStream16;
                                                inputStream3 = content;
                                                r56 = str11;
                                                isNetSupport = fileOutputStream12;
                                                j(outOfMemoryError, this.D, 3);
                                                QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground downLoadFile: url: " + this.f436999d + " filePath: " + this.f437000e + " " + outOfMemoryError.getMessage(), outOfMemoryError);
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (IOException unused24) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused25) {
                                                    }
                                                }
                                            } catch (Throwable th8) {
                                                th6 = th8;
                                                str = str15;
                                                fileOutputStream2 = fileOutputStream16;
                                                r46 = content;
                                                r57 = str;
                                                fileOutputStream = fileOutputStream2;
                                                if (r46 != 0) {
                                                    try {
                                                        r46.close();
                                                    } catch (IOException unused26) {
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused27) {
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                        throw th6;
                                                    } catch (Exception unused28) {
                                                        throw th6;
                                                    }
                                                }
                                                throw th6;
                                            }
                                        }
                                    } else {
                                        j(null, this.D, -1);
                                    }
                                    fileOutputStream15 = null;
                                    content.close();
                                    byteArrayOutputStream.close();
                                    if (fileOutputStream15 != null) {
                                    }
                                } catch (FileNotFoundException e46) {
                                    fileNotFoundException = e46;
                                    str13 = null;
                                    fileOutputStream14 = null;
                                } catch (IllegalStateException e47) {
                                    illegalStateException = e47;
                                    str12 = null;
                                    fileOutputStream13 = null;
                                } catch (OutOfMemoryError e48) {
                                    outOfMemoryError = e48;
                                    str11 = null;
                                    fileOutputStream12 = null;
                                } catch (SocketException e49) {
                                    socketException = e49;
                                    str10 = null;
                                    fileOutputStream11 = null;
                                } catch (SocketTimeoutException e56) {
                                    socketTimeoutException = e56;
                                    str9 = null;
                                    fileOutputStream10 = null;
                                } catch (UnknownHostException e57) {
                                    unknownHostException = e57;
                                    str8 = null;
                                    fileOutputStream9 = null;
                                } catch (SSLPeerUnverifiedException e58) {
                                    sSLPeerUnverifiedException = e58;
                                    str7 = null;
                                    fileOutputStream8 = null;
                                } catch (NoHttpResponseException e59) {
                                    noHttpResponseException = e59;
                                    str6 = null;
                                    fileOutputStream7 = null;
                                } catch (ClientProtocolException e65) {
                                    clientProtocolException = e65;
                                    str5 = null;
                                    fileOutputStream6 = null;
                                } catch (ConnectTimeoutException e66) {
                                    connectTimeoutException = e66;
                                    str4 = null;
                                    fileOutputStream5 = null;
                                } catch (IOException e67) {
                                    iOException = e67;
                                    str3 = null;
                                    fileOutputStream4 = null;
                                } catch (Exception e68) {
                                    exc = e68;
                                    str2 = null;
                                    fileOutputStream3 = null;
                                } catch (Throwable th9) {
                                    th6 = th9;
                                    str = null;
                                    fileOutputStream2 = null;
                                }
                            } catch (FileNotFoundException e69) {
                                fileNotFoundException = e69;
                                str13 = null;
                                fileOutputStream14 = null;
                                byteArrayOutputStream = null;
                            } catch (IllegalStateException e75) {
                                illegalStateException = e75;
                                str12 = null;
                                fileOutputStream13 = null;
                                byteArrayOutputStream = null;
                            } catch (OutOfMemoryError e76) {
                                outOfMemoryError = e76;
                                str11 = null;
                                fileOutputStream12 = null;
                                byteArrayOutputStream = null;
                            } catch (SocketException e77) {
                                socketException = e77;
                                str10 = null;
                                fileOutputStream11 = null;
                                byteArrayOutputStream = null;
                            } catch (SocketTimeoutException e78) {
                                socketTimeoutException = e78;
                                str9 = null;
                                fileOutputStream10 = null;
                                byteArrayOutputStream = null;
                            } catch (UnknownHostException e79) {
                                unknownHostException = e79;
                                str8 = null;
                                fileOutputStream9 = null;
                                byteArrayOutputStream = null;
                            } catch (SSLPeerUnverifiedException e85) {
                                sSLPeerUnverifiedException = e85;
                                str7 = null;
                                fileOutputStream8 = null;
                                byteArrayOutputStream = null;
                            } catch (NoHttpResponseException e86) {
                                noHttpResponseException = e86;
                                str6 = null;
                                fileOutputStream7 = null;
                                byteArrayOutputStream = null;
                            } catch (ClientProtocolException e87) {
                                clientProtocolException = e87;
                                str5 = null;
                                fileOutputStream6 = null;
                                byteArrayOutputStream = null;
                            } catch (ConnectTimeoutException e88) {
                                connectTimeoutException = e88;
                                str4 = null;
                                fileOutputStream5 = null;
                                byteArrayOutputStream = null;
                            } catch (IOException e89) {
                                iOException = e89;
                                str3 = null;
                                fileOutputStream4 = null;
                                byteArrayOutputStream = null;
                            } catch (Exception e95) {
                                exc = e95;
                                str2 = null;
                                fileOutputStream3 = null;
                                byteArrayOutputStream = null;
                            } catch (Throwable th10) {
                                th6 = th10;
                                str = null;
                                fileOutputStream2 = null;
                                byteArrayOutputStream = null;
                            }
                        } catch (FileNotFoundException e96) {
                            fileNotFoundException = e96;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (IllegalStateException e97) {
                            illegalStateException = e97;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (OutOfMemoryError e98) {
                            outOfMemoryError = e98;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (SocketException e99) {
                            socketException = e99;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (SocketTimeoutException e100) {
                            socketTimeoutException = e100;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (UnknownHostException e101) {
                            unknownHostException = e101;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (SSLPeerUnverifiedException e102) {
                            sSLPeerUnverifiedException = e102;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (NoHttpResponseException e103) {
                            noHttpResponseException = e103;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (ClientProtocolException e104) {
                            clientProtocolException = e104;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (ConnectTimeoutException e105) {
                            connectTimeoutException = e105;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (IOException e106) {
                            iOException = e106;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (Exception e107) {
                            exc = e107;
                            r56 = 0;
                            isNetSupport = 0;
                            byteArrayOutputStream = null;
                        } catch (Throwable th11) {
                            th6 = th11;
                            r57 = 0;
                            fileOutputStream = null;
                            byteArrayOutputStream = null;
                        }
                    }
                } catch (Throwable th12) {
                    th5 = th12;
                    str14 = r57;
                    j(th5, this.D, -99999);
                    QZLog.e(QZLog.TO_DEVICE_TAG, "HttpLoadFileTask doInBackground default: url: " + this.f436999d + " filePath: " + this.f437000e + " " + th5.getMessage(), th5);
                    return str14;
                }
                return str14;
            } catch (Throwable th13) {
                th6 = th13;
                r46 = str14;
                r57 = r56;
                fileOutputStream = isNetSupport;
            }
        }
        return null;
        str14 = r56;
        return str14;
    }
}
