package v44;

import android.graphics.Bitmap;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IRobotShareLimitCallBack;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareLimitReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareLimitRsp;
import com.tencent.robot.data.RobotShareState;
import com.tencent.util.UiThreadUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u001c\u0010\u000f\u001a\u00020\u00052\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f\u00a8\u0006\u0012"}, d2 = {"Lv44/c;", "", "", "icon", "msg", "", "g", "", WadlProxyConsts.PARAM_FILENAME, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "f", "Lkotlin/Function1;", "Lcom/tencent/robot/data/RobotShareState;", "callback", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f440966a = new c();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final Function1 function1, int i3, String str, RobotShareLimitRsp robotShareLimitRsp) {
        int i16;
        final RobotShareState robotShareState;
        if (robotShareLimitRsp != null) {
            i16 = robotShareLimitRsp.limitResult;
        } else {
            i16 = 0;
        }
        QLog.d("robot.qr.RobotQRUtils", 1, "queryRobotShareState result " + i3 + ", errMsg " + str + ",limitResult " + i16);
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    robotShareState = RobotShareState.NORMAL;
                } else {
                    robotShareState = RobotShareState.LIMIT;
                }
            } else {
                robotShareState = RobotShareState.BANNED;
            }
        } else {
            robotShareState = RobotShareState.NORMAL;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: v44.b
            @Override // java.lang.Runnable
            public final void run() {
                c.e(Function1.this, robotShareState);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 function1, RobotShareState shareState) {
        Intrinsics.checkNotNullParameter(shareState, "$shareState");
        if (function1 != null) {
            function1.invoke(shareState);
        }
    }

    public final void c(@Nullable final Function1<? super RobotShareState, Unit> callback) {
        IRuntimeService iRuntimeService;
        ac robotService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (robotService = iKernelService.getRobotService()) != null) {
            robotService.fetchRobotShareLimit(new RobotShareLimitReq(1), new IRobotShareLimitCallBack() { // from class: v44.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotShareLimitCallBack
                public final void onResult(int i3, String str, RobotShareLimitRsp robotShareLimitRsp) {
                    c.d(Function1.this, i3, str, robotShareLimitRsp);
                }
            });
        }
    }

    @Nullable
    public final String f(@NotNull String fileName, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (bitmap != null && !bitmap.isRecycled()) {
            File file = new File(VFSAssistantUtils.getSDKPrivatePath("cache/"));
            if (!file.canWrite()) {
                QLog.e("robot.qr.RobotQRUtils", 1, "getSDKPrivatePath cache can't write!");
                return "";
            }
            file.mkdirs();
            File file2 = new File(file.getAbsolutePath(), fileName);
            String absolutePath = file2.getAbsolutePath();
            if (file2.exists()) {
                file2.delete();
            }
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedOutputStream, null);
                    return absolutePath;
                } finally {
                }
            } catch (Throwable th5) {
                QLog.e("robot.qr.RobotQRUtils", 1, "saveTempImage io error " + th5);
            }
        }
        return "";
    }

    public final void g(int icon, int msg2) {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        QQToast.makeText(context, icon, msg2, 1).show();
    }
}
