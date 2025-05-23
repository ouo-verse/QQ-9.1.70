package yv0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.liveroom.impl.room.widget.AudienceOperationBarView;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f451279a;

    /* renamed from: b, reason: collision with root package name */
    private IQQLiveSsoProxyModule f451280b;

    /* renamed from: d, reason: collision with root package name */
    private f f451282d;

    /* renamed from: f, reason: collision with root package name */
    private ep4.d f451284f;

    /* renamed from: c, reason: collision with root package name */
    private boolean f451281c = false;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.icgame.game.liveroom.impl.room.bottombtn.a f451283e = new com.tencent.icgame.game.liveroom.impl.room.bottombtn.a();

    /* renamed from: g, reason: collision with root package name */
    private boolean f451285g = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: yv0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C11635a implements IQQLiveProxySsoObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f451286a;

        C11635a(e eVar) {
            this.f451286a = eVar;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onFail(int i3, String str) {
            QLog.e("ICGameBottomConfigModel", 1, "getBottomConfig errCode: " + i3 + ", errMsg: " + str);
            this.f451286a.fail(i3, str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onReceive(byte[] bArr) {
            if (!a.this.f451281c) {
                return;
            }
            try {
                ep4.d c16 = ep4.d.c(bArr);
                if (c16 != null) {
                    a.this.f451284f = c16;
                    a aVar = a.this;
                    aVar.f451282d = new f(aVar.f451279a, c16, a.this.f451285g);
                    this.f451286a.success(c16);
                } else {
                    QLog.e("ICGameBottomConfigModel", 1, "getBottomConfig err, rsp == null: ");
                }
            } catch (InvalidProtocolBufferNanoException e16) {
                QLog.e("ICGameBottomConfigModel", 1, "getBottomConfig parse err: " + e16);
            }
        }
    }

    public a(Context context) {
        this.f451279a = context;
    }

    public void f(View view) {
        ((ru0.a) qx0.a.b(ru0.a.class)).a(view, true, null, "em_icgame_morefunction_entrance", new HashMap());
    }

    public void g(View view, Map<String, String> map) {
        ((ru0.a) qx0.a.b(ru0.a.class)).a(view, true, null, "em_icgame_regulation", map);
    }

    public void h(long j3, int i3, e<ep4.d> eVar) {
        if (this.f451280b != null && this.f451281c) {
            QLog.i("ICGameBottomConfigModel", 1, "getBottomConfig, roomId: " + j3 + ", gameId: " + i3);
            ep4.c cVar = new ep4.c();
            cVar.f396946a = j3;
            cVar.f396947b = (long) i3;
            this.f451280b.sendQQLiveProxyReq("trpc.icggame.room_operation.RoomOperation", "GetBottomConfig", MessageNano.toByteArray(cVar), new C11635a(eVar));
            return;
        }
        QLog.e("ICGameBottomConfigModel", 1, "getBottomConfig error, ssoProxy: " + this.f451280b + ", isInRoom: " + this.f451281c);
    }

    public f i() {
        return this.f451282d;
    }

    public void j() {
        this.f451283e.f();
    }

    public boolean k() {
        if (this.f451284f == null) {
            return false;
        }
        return !r0.f396951d;
    }

    public void l() {
        ep4.d dVar = this.f451284f;
        if (dVar != null) {
            ep4.a aVar = dVar.f396948a;
            String str = aVar.f396938c;
            Float valueOf = Float.valueOf(aVar.f396939d);
            Bundle bundle = new Bundle();
            bundle.putInt("height_web_dialog", x.h(this.f451279a, (int) (x.f(this.f451279a).f185861b * valueOf.floatValue())));
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(this.f451279a, str, bundle);
        }
    }

    public void m(IQQLiveSsoProxyModule iQQLiveSsoProxyModule) {
        this.f451280b = iQQLiveSsoProxyModule;
        this.f451281c = true;
    }

    public void n(boolean z16) {
        this.f451285g = z16;
        f fVar = this.f451282d;
        if (fVar == null) {
            return;
        }
        fVar.f(this.f451279a, z16);
    }

    public boolean o() {
        return false;
    }

    public void p(Activity activity, Context context, h22.a aVar, f fVar, AudienceOperationBarView.b bVar) {
        this.f451283e.j(activity, context, aVar, fVar, bVar);
    }
}
