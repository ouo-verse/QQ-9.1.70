package x14;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.album.AdeliePreviewCustomization;
import com.tencent.robot.adelie.homepage.utils.d;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0002\b\fB\u001f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lx14/c;", "", "", "filePah", "e", "", "c", "Lx14/c$b;", "a", "Lx14/c$b;", "taskParam", "Lx14/a;", "b", "Lx14/a;", "f", "()Lx14/a;", "listener", "<init>", "(Lx14/c$b;Lx14/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TaskParam taskParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a<String> listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lx14/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "filePath", "b", "I", "()I", "commandId", "cosDir", "d", "reportEventName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x14.c$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class TaskParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String filePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int commandId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String cosDir;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String reportEventName;

        public TaskParam() {
            this(null, 0, null, null, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getCommandId() {
            return this.commandId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getCosDir() {
            return this.cosDir;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getReportEventName() {
            return this.reportEventName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskParam)) {
                return false;
            }
            TaskParam taskParam = (TaskParam) other;
            if (Intrinsics.areEqual(this.filePath, taskParam.filePath) && this.commandId == taskParam.commandId && Intrinsics.areEqual(this.cosDir, taskParam.cosDir) && Intrinsics.areEqual(this.reportEventName, taskParam.reportEventName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.filePath.hashCode() * 31) + this.commandId) * 31) + this.cosDir.hashCode()) * 31) + this.reportEventName.hashCode();
        }

        @NotNull
        public String toString() {
            return "TaskParam(filePath=" + this.filePath + ", commandId=" + this.commandId + ", cosDir=" + this.cosDir + ", reportEventName=" + this.reportEventName + ")";
        }

        public TaskParam(@NotNull String filePath, int i3, @NotNull String cosDir, @NotNull String reportEventName) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(cosDir, "cosDir");
            Intrinsics.checkNotNullParameter(reportEventName, "reportEventName");
            this.filePath = filePath;
            this.commandId = i3;
            this.cosDir = cosDir;
            this.reportEventName = reportEventName;
        }

        public /* synthetic */ TaskParam(String str, int i3, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 2020 : i3, (i16 & 4) != 0 ? "ugc_avatar" : str2, (i16 & 8) != 0 ? "adelie_creation_upload_avatar" : str3);
        }
    }

    public c(@NotNull TaskParam taskParam, @Nullable a<String> aVar) {
        Intrinsics.checkNotNullParameter(taskParam, "taskParam");
        this.taskParam = taskParam;
        this.listener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, AppRuntime app) {
        AppInterface appInterface;
        int i3;
        HwEngine hwEngine;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        if (!FileUtils.fileExists(this$0.taskParam.getFilePath())) {
            QLog.i("UploadAvatarTask", 1, "[upload] file not exist, path=" + this$0.taskParam.getFilePath());
            a<String> aVar = this$0.listener;
            if (aVar != null) {
                aVar.onFail(-2, "\u672c\u5730\u6587\u4ef6\u4e0d\u5b58\u5728");
                return;
            }
            return;
        }
        C11525c c11525c = new C11525c(System.currentTimeMillis(), this$0);
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        String str = new SimpleDateFormat(DateUtil.DATE_FORMAT_12, Locale.CHINA).format(new Date(System.currentTimeMillis())) + this$0.e(this$0.taskParam.getFilePath());
        String str2 = this$0.taskParam.getCosDir() + "/" + UUID.randomUUID() + "_" + str;
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str2));
        Transaction transaction = new Transaction(app.getCurrentAccountUin(), this$0.taskParam.getCommandId(), this$0.taskParam.getFilePath(), 0, MD5.getFileMd5(this$0.taskParam.getFilePath()), (ITransactionCallback) c11525c, commFileExtReq.toByteArray(), false);
        if (app instanceof AppInterface) {
            appInterface = (AppInterface) app;
        } else {
            appInterface = null;
        }
        if (appInterface != null && (hwEngine = appInterface.getHwEngine()) != null) {
            i3 = hwEngine.submitTransactionTask(transaction);
        } else {
            i3 = -1;
        }
        if (i3 != 0) {
            a<String> aVar2 = this$0.listener;
            if (aVar2 != null) {
                aVar2.onFail(i3, "submitTransactionTask fail");
            }
            QLog.e("UploadAvatarTask", 1, "submitTransactionTask failed, retCode=" + i3);
        }
    }

    private final String e(String filePah) {
        int lastIndexOf$default;
        String name = new File(filePah).getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return ".jpeg";
        }
        String substring = name.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return "." + substring;
    }

    public void c() {
        final AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: x14.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(c.this, appRuntime);
            }
        }, 64, null, true);
    }

    @Nullable
    public final a<String> f() {
        return this.listener;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016JB\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"x14/c$c", "Lcom/tencent/mobileqq/highway/api/ITransactionCallback;", "", "respData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", CacheTable.TABLE_NAME, "", "onSuccess", "onTransStart", "", "progress", "onUpdateProgress", "errn", "onFailed", "onSwitch2BackupChannel", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x14.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11525c implements ITransactionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f447065a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f447066b;

        C11525c(long j3, c cVar) {
            this.f447065a = j3;
            this.f447066b = cVar;
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onFailed(int errn, @Nullable byte[] respData, @Nullable HashMap<String, String> reportInfo) {
            Map mapOf;
            long currentTimeMillis = System.currentTimeMillis() - this.f447065a;
            QLog.e("UploadAvatarTask", 1, "onFailed, errn=" + errn + ", cost" + currentTimeMillis + ", reportInfo=" + reportInfo);
            a<String> f16 = this.f447066b.f();
            if (f16 != null) {
                f16.onFail(errn, "inner fail");
            }
            AdeliePreviewCustomization.Companion companion = AdeliePreviewCustomization.INSTANCE;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(IQQLiveUtil.UPLOAD_ERROR_CODE, String.valueOf(errn)), TuplesKt.to("upload_error_msg", String.valueOf(reportInfo)), TuplesKt.to("upload_cost_time", String.valueOf(currentTimeMillis)), TuplesKt.to("upload_pic_size", String.valueOf(companion.a().getCropSize())), TuplesKt.to("upload_pic_quality", String.valueOf(companion.a().getCompressQuality())));
            d.c(null, this.f447066b.taskParam.getReportEventName(), mapOf, 1, null);
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSuccess(@Nullable byte[] respData, @Nullable HashMap<String, String> reportInfo) {
            Map mapOf;
            try {
                long currentTimeMillis = System.currentTimeMillis() - this.f447065a;
                Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                uploadPicExtInfo.mergeFrom(respData);
                String imageUrl = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                a<String> f16 = this.f447066b.f();
                if (f16 != null) {
                    Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
                    f16.onSuccess(imageUrl);
                }
                AdeliePreviewCustomization.Companion companion = AdeliePreviewCustomization.INSTANCE;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(IQQLiveUtil.UPLOAD_ERROR_CODE, "0"), TuplesKt.to("upload_error_msg", ""), TuplesKt.to("upload_cost_time", String.valueOf(currentTimeMillis)), TuplesKt.to("upload_pic_url", imageUrl), TuplesKt.to("upload_pic_size", String.valueOf(companion.a().getCropSize())), TuplesKt.to("upload_pic_quality", String.valueOf(companion.a().getCompressQuality())));
                d.c(null, this.f447066b.taskParam.getReportEventName(), mapOf, 1, null);
                QLog.i("UploadAvatarTask", 1, "onSuccess, imageUrl=" + imageUrl + ", cost=" + currentTimeMillis);
            } catch (Exception e16) {
                QLog.e("UploadAvatarTask", 1, e16, new Object[0]);
                a<String> f17 = this.f447066b.f();
                if (f17 != null) {
                    f17.onFail(-1, "exception");
                }
                QLog.e("UploadAvatarTask", 1, "onError, cost=" + (System.currentTimeMillis() - this.f447065a));
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onTransStart() {
            QLog.i("UploadAvatarTask", 1, "onTransStart");
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSwitch2BackupChannel() {
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onUpdateProgress(int progress) {
        }
    }
}
