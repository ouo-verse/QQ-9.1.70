package u64;

import com.tencent.qqnt.kernel.nativeinterface.AioConfig;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "", "b", "a", "c", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    public static final boolean a(@NotNull RobotCoreInfo robotCoreInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        AioConfig aioConfig = robotCoreInfo.aioConfig;
        if (aioConfig != null) {
            i3 = aioConfig.supportAutoTts;
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull RobotCoreInfo robotCoreInfo) {
        ArrayList<TtsInfo> arrayList;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        RobotTTSList robotTTSList = robotCoreInfo.ttsList;
        if (robotTTSList != null && (arrayList = robotTTSList.ttsList) != null) {
            return !arrayList.isEmpty();
        }
        return false;
    }

    public static final boolean c(@NotNull RobotCoreInfo robotCoreInfo) {
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        AioConfig aioConfig = robotCoreInfo.aioConfig;
        if (aioConfig == null || aioConfig.supportWideScreen != 1) {
            return false;
        }
        return true;
    }
}
