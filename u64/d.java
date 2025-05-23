package u64;

import com.tencent.qqnt.kernel.nativeinterface.AioConfig;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "", "d", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "a", "e", "c", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    public static final boolean a(@NotNull RobotFeature robotFeature) {
        Intrinsics.checkNotNullParameter(robotFeature, "<this>");
        if (robotFeature.autoTts != 0) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull GroupRobotProfile groupRobotProfile) {
        int i3;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        AioConfig aioConfig = groupRobotProfile.aioConfig;
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

    public static final boolean c(@NotNull GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        AioConfig aioConfig = groupRobotProfile.aioConfig;
        if (aioConfig == null || aioConfig.supportNewInteraction != 1) {
            return false;
        }
        return true;
    }

    public static final boolean d(@NotNull GroupRobotProfile groupRobotProfile) {
        ArrayList<TtsInfo> arrayList;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        RobotTTSList robotTTSList = groupRobotProfile.ttsList;
        if (robotTTSList != null && (arrayList = robotTTSList.ttsList) != null) {
            return !arrayList.isEmpty();
        }
        return false;
    }

    public static final boolean e(@NotNull GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        AioConfig aioConfig = groupRobotProfile.aioConfig;
        if (aioConfig == null || aioConfig.supportWideScreen != 1) {
            return false;
        }
        return true;
    }
}
