package tb0;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleKeyVolumeChangeEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleVolumeMuteChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n`\u000bH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ltb0/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qcircle/api/event/QCircleKeyVolumeChangeEvent;", "event", "", "a", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "e", "Z", "mIsMute", "mute", "b", "()Z", "c", "(Z)V", "isMute", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f435779d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsMute;

    static {
        a aVar = new a();
        f435779d = aVar;
        mIsMute = f.e();
        SimpleEventBus.getInstance().registerReceiver(aVar);
        QLog.d("QFSDefaultMuteController", 1, "<init> mIsMute=" + mIsMute);
    }

    a() {
    }

    private final void a(QCircleKeyVolumeChangeEvent event) {
        int curVolume = event.getCurVolume();
        boolean z16 = true;
        if (!f.f()) {
            QLog.d("QFSDefaultMuteController", 1, "[handleKeyVolumeChangeEvent] false: enableDefaultMuteFromWNS false, return");
            return;
        }
        if (!f.e()) {
            return;
        }
        if (!QCirclePluginUtil.isInQCircleNew()) {
            QLog.d("QFSDefaultMuteController", 1, "[handleKeyVolumeChangeEvent] false: isInQCircleNew false, return");
            return;
        }
        if (b()) {
            if (event.getKeyCode() != 24) {
                z16 = false;
            }
            if (z16) {
                c(false);
                return;
            }
            return;
        }
        if (curVolume == 0) {
            c(true);
        }
    }

    public final boolean b() {
        return mIsMute;
    }

    public final void c(boolean z16) {
        mIsMute = z16;
        SimpleEventBus.getInstance().dispatchEvent(new QCircleVolumeMuteChangeEvent(z16));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleKeyVolumeChangeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
        if (simpleBaseEvent instanceof QCircleKeyVolumeChangeEvent) {
            a((QCircleKeyVolumeChangeEvent) simpleBaseEvent);
        }
    }
}
