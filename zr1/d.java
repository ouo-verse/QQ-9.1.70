package zr1;

import android.os.Handler;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.w;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import vh2.dg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c() {
        ((TabDataHandler) ch.j(TabDataHandler.class)).K2("GUILD", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(w wVar, int i3, String str, boolean z16) {
        if (i3 == 0) {
            e(wVar);
            return;
        }
        QLog.w("Guild.jump.GuildNavigateToTabUtil", 1, "requestOpenGuildTab failed result: " + i3 + ", errMsg: " + str + ",isGuildNewUser: " + z16);
        wVar.onFailed(i3, str);
    }

    private static void e(w wVar) {
        QCircleFrameEvent qCircleFrameEvent = new QCircleFrameEvent();
        qCircleFrameEvent.mAddTab = true;
        SimpleEventBus.getInstance().dispatchEvent(qCircleFrameEvent);
        ThreadManagerV2.excute(new Runnable() { // from class: zr1.b
            @Override // java.lang.Runnable
            public final void run() {
                d.c();
            }
        }, 160, new a(wVar), true);
    }

    public static void f(String str, final w wVar) {
        ((IGPSService) ch.R0(IGPSService.class)).setUserType(str, new dg() { // from class: zr1.a
            @Override // vh2.dg
            public final void onResult(int i3, String str2, boolean z16) {
                d.d(w.this, i3, str2, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements ThreadExcutor.IThreadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ w f453072d;

        a(w wVar) {
            this.f453072d = wVar;
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            QLog.d("Guild.jump.GuildNavigateToTabUtil", 2, "openLoadGuildTab");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final w wVar = this.f453072d;
            Objects.requireNonNull(wVar);
            uIHandlerV2.post(new Runnable() { // from class: zr1.c
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.onSuccess();
                }
            });
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
        }
    }
}
