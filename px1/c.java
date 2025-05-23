package px1;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.robot.display.more.MoreRobotInfoFragment;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c implements IGProFetchGuildRobotInfoCallback {

    /* renamed from: a, reason: collision with root package name */
    private MoreRobotInfoFragment f427877a;

    public c(MoreRobotInfoFragment moreRobotInfoFragment) {
        this.f427877a = moreRobotInfoFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        this.f427877a.sh(gProGuildRobotInfoRsp);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback
    public void onFetchGuildRobotInfo(int i3, String str, final GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        if (i3 == 0 && gProGuildRobotInfoRsp != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: px1.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.b(gProGuildRobotInfoRsp);
                }
            });
        }
    }
}
