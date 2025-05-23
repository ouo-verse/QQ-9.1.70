package s64;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.helper.tts.task.RobotTtsSimpleEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Ls64/a;", "Lcom/tencent/mobileqq/qqaudio/a;", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements com.tencent.mobileqq.qqaudio.a {
    @Override // com.tencent.mobileqq.qqaudio.a
    public void a() {
        QLog.i("RobotAudioFocusProcessor", 1, "[doOnAudioFocusLoss] stop all");
        SimpleEventBus.getInstance().dispatchEvent(new RobotTtsSimpleEvent.StopAllRobotTtsSimpleEvent("RobotAudioFocusProcessor"));
    }
}
