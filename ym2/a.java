package ym2;

import android.content.Context;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J0\u0010\u000f\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J&\u0010\u0016\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0002\u00a8\u0006\u0019"}, d2 = {"Lym2/a;", "", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "", "a", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedOfFiles", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appRuntime", "Lcom/tencent/qphone/base/util/BaseApplication;", "context", "b", "selectedTroopFiles", "", "d", "Landroid/content/Context;", "app", "message", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f450651a = new a();

    a() {
    }

    @JvmStatic
    public static final boolean a(@NotNull List<? extends AIOMsgItem> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Iterator<? extends AIOMsgItem> it = msgList.iterator();
        while (it.hasNext()) {
            if (it.next().getMsgRecord().msgType != 3) {
                return false;
            }
        }
        return true;
    }

    private final boolean b(ArrayList<AIOMsgItem> selectedOfFiles, QQAppInterface appRuntime, BaseApplication context) {
        if (selectedOfFiles.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<AIOMsgItem> it = selectedOfFiles.iterator();
            while (it.hasNext()) {
                AIOMsgItem next = it.next();
                MsgElement firstTypeElement = next.getFirstTypeElement(3);
                if (firstTypeElement != null) {
                    FileManagerEntity E = appRuntime.getFileManagerDataCenter().E(firstTypeElement.elementId, String.valueOf(next.getMsgRecord().peerUin), next.getMsgRecord().chatType);
                    if (E == null) {
                        QLog.e("AIOGalleryUtilsForwardPC", 1, "fileManagerDataCenter return null entity, elementId : " + firstTypeElement.elementId + ", peerUin : " + next.getMsgRecord().peerUin + ", chatType : " + next.getMsgRecord().chatType);
                    } else {
                        int i3 = E.cloudType;
                        if (i3 != 0 && i3 != 2 && E.status != 16) {
                            arrayList.add(E);
                        }
                    }
                }
            }
            if (arrayList.size() == 0) {
                QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b_p));
                return true;
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).sendFileToDataline(appRuntime, context, (FileManagerEntity) it5.next());
            }
        }
        return false;
    }

    private final void c(Context context, QQAppInterface app, AIOMsgItem message) {
        MsgElement firstTypeElement;
        FileElement fileElement;
        int intValue;
        if (message != null && app != null) {
            MsgRecord msgRecord = message.getMsgRecord();
            if (msgRecord.msgType != 3 || msgRecord.chatType != 2 || (firstTypeElement = message.getFirstTypeElement(3)) == null || (fileElement = firstTypeElement.fileElement) == null) {
                return;
            }
            long j3 = msgRecord.peerUin;
            String str = fileElement.fileUuid;
            String str2 = fileElement.fileName;
            long j16 = fileElement.fileSize;
            Integer num = fileElement.fileBizId;
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            QFileUtils.m0(app, context, j3, "", str, str2, j16, intValue);
        }
    }

    private final void d(ArrayList<AIOMsgItem> selectedTroopFiles, BaseApplication context, QQAppInterface appRuntime) {
        if (selectedTroopFiles.size() > 0) {
            Iterator<AIOMsgItem> it = selectedTroopFiles.iterator();
            while (it.hasNext()) {
                c(context, appRuntime, it.next());
            }
        }
    }

    @JvmStatic
    public static final boolean e(@Nullable List<? extends AIOMsgItem> msgList) {
        BaseApplication context;
        if (!NetworkUtil.isNetSupport(MobileQQ.sMobileQQ)) {
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b3j));
            return false;
        }
        if (msgList != null && !msgList.isEmpty()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (context = BaseApplication.getContext()) == null || !(peekAppRuntime instanceof QQAppInterface)) {
                return false;
            }
            ArrayList<AIOMsgItem> arrayList = new ArrayList<>();
            ArrayList<AIOMsgItem> arrayList2 = new ArrayList<>();
            for (AIOMsgItem aIOMsgItem : msgList) {
                MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
                if (msgRecord.msgType == 3) {
                    int i3 = msgRecord.chatType;
                    if (i3 == 2) {
                        arrayList.add(aIOMsgItem);
                    } else if (i3 == 1) {
                        arrayList2.add(aIOMsgItem);
                    }
                }
            }
            a aVar = f450651a;
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            aVar.d(arrayList, context, qQAppInterface);
            if (aVar.b(arrayList2, qQAppInterface, context)) {
                return false;
            }
            if (arrayList.size() != 0 || arrayList2.size() != 0) {
                return true;
            }
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b_q));
            return false;
        }
        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.f6q));
        return false;
    }
}
