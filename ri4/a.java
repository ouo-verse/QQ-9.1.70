package ri4;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.utils.l;
import mqq.util.LogUtil;
import nf4.j;
import nf4.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements of4.b {

    /* renamed from: a, reason: collision with root package name */
    private int f431492a;

    /* renamed from: b, reason: collision with root package name */
    private long f431493b;

    /* renamed from: c, reason: collision with root package name */
    private String f431494c;

    /* renamed from: d, reason: collision with root package name */
    private QQCustomDialog f431495d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ri4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C11142a implements hi4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f431496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f431497b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kf4.a f431498c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ of4.a f431499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ef4.a f431500e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ nf4.a f431501f;

        /* compiled from: P */
        /* renamed from: ri4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C11143a implements nf4.a<k> {
            C11143a() {
            }

            @Override // nf4.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(k kVar) {
                C11142a c11142a = C11142a.this;
                a.this.r(kVar, c11142a.f431498c, c11142a.f431499d, c11142a.f431500e, c11142a.f431501f);
            }

            @Override // nf4.a
            public void onError(int i3, String str) {
                C11142a.this.f431500e.hideLoading();
                nf4.a aVar = C11142a.this.f431501f;
                if (aVar != null) {
                    aVar.onError(i3, str);
                }
            }
        }

        C11142a(String str, long j3, kf4.a aVar, of4.a aVar2, ef4.a aVar3, nf4.a aVar4) {
            this.f431496a = str;
            this.f431497b = j3;
            this.f431498c = aVar;
            this.f431499d = aVar2;
            this.f431500e = aVar3;
            this.f431501f = aVar4;
        }

        @Override // hi4.a
        public void a(boolean z16) {
            a.this.o(this.f431496a, this.f431497b, new C11143a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ of4.a f431504d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kf4.a f431505e;

        b(of4.a aVar, kf4.a aVar2) {
            this.f431504d = aVar;
            this.f431505e = aVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f431504d.a(this.f431505e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f431507d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ of4.a f431508e;

        c(String str, of4.a aVar) {
            this.f431507d = str;
            this.f431508e = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f431508e.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements nf4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kf4.a f431510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f431511b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f431512c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f431513d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f431514e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f431515f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f431516g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ef4.a f431517h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f431518i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f431519j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ long f431520k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ nf4.a f431521l;

        /* compiled from: P */
        /* renamed from: ri4.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C11144a implements nf4.a<j> {
            C11144a() {
            }

            @Override // nf4.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(j jVar) {
                a.this.t("smobaOneKeyLive initLiveRoomStatus - " + jVar.f420107b + ", launchId = " + jVar.f420108c);
                a.this.q().f(a.this.f431492a, d.this.f431520k, true, 0, "");
                if (TextUtils.isEmpty(jVar.f420107b)) {
                    a.this.w("\u8df3\u8f6cURL\u4e3a\u7a7a\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5");
                    d.this.f431517h.hideLoading();
                    nf4.a aVar = d.this.f431521l;
                    if (aVar != null) {
                        aVar.onSuccess(jVar);
                        return;
                    }
                    return;
                }
                a.this.f431494c = jVar.f420108c;
                ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).oneKeyLiveHandler().g(a.this.f431494c);
                d dVar = d.this;
                a.this.u(true, dVar.f431511b, jVar.f420107b, jVar, dVar.f431521l, dVar.f431517h);
            }

            @Override // nf4.a
            public void onError(int i3, String str) {
                String str2;
                a.this.s("smobaOneKeyLive initLiveRoomStatus error -" + i3 + " - " + str);
                d.this.f431517h.hideLoading();
                if (TextUtils.isEmpty(str)) {
                    str2 = "\u5f00\u64ad\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                } else {
                    str2 = str;
                }
                a.this.w(str2);
                a.this.q().f(a.this.f431492a, d.this.f431520k, false, i3, str);
                nf4.a aVar = d.this.f431521l;
                if (aVar != null) {
                    aVar.onError(i3, str2);
                }
            }
        }

        d(kf4.a aVar, int i3, String str, String str2, String str3, String str4, String str5, ef4.a aVar2, String str6, long j3, long j16, nf4.a aVar3) {
            this.f431510a = aVar;
            this.f431511b = i3;
            this.f431512c = str;
            this.f431513d = str2;
            this.f431514e = str3;
            this.f431515f = str4;
            this.f431516g = str5;
            this.f431517h = aVar2;
            this.f431518i = str6;
            this.f431519j = j3;
            this.f431520k = j16;
            this.f431521l = aVar3;
        }

        @Override // nf4.b
        public void onFailed(int i3, @Nullable String str) {
            a.this.s("smobaOneKeyLive checkGameLiveAvailable onFailed - " + str);
            this.f431517h.hideLoading();
            a.this.q().f(a.this.f431492a, this.f431520k, false, i3, str);
            nf4.a aVar = this.f431521l;
            if (aVar != null) {
                aVar.onError(i3, str);
            }
        }

        @Override // nf4.b
        public void onSuccess() {
            nf4.i p16 = a.this.p(this.f431510a, this.f431511b, this.f431512c, this.f431513d, this.f431514e, this.f431515f, this.f431516g);
            a.this.t("smobaOneKeyLive checkGameLiveAvailable onSuccess, roomTitle = " + p16.f420097b + ", cover = " + p16.f420098c);
            this.f431517h.showLoading();
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).oneKeyLiveHandler().f(a.this.f431492a, this.f431518i, this.f431519j, p16, new C11144a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements nf4.a<k> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nf4.a f431524a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f431525b;

        e(nf4.a aVar, long j3) {
            this.f431524a = aVar;
            this.f431525b = j3;
        }

        @Override // nf4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(k kVar) {
            nf4.a aVar = this.f431524a;
            if (aVar != null) {
                aVar.onSuccess(kVar);
            }
            a.this.q().g(a.this.f431492a, this.f431525b, true, 0, "");
        }

        @Override // nf4.a
        public void onError(int i3, String str) {
            nf4.a aVar = this.f431524a;
            if (aVar != null) {
                aVar.onError(i3, str);
            }
            a.this.q().g(a.this.f431492a, this.f431525b, false, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements SchemeUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ef4.a f431527a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nf4.a f431528b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f431529c;

        f(ef4.a aVar, nf4.a aVar2, j jVar) {
            this.f431527a = aVar;
            this.f431528b = aVar2;
            this.f431529c = jVar;
        }

        @Override // com.tencent.timi.game.scheme.tools.SchemeUtil.c
        public void onResult(int i3) {
            boolean z16;
            ef4.a aVar = this.f431527a;
            if (aVar != null) {
                aVar.hideLoading();
            }
            if (i3 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            a.this.t("launchGame: result = " + i3 + ", isSuccess = " + z16);
            nf4.a aVar2 = this.f431528b;
            if (aVar2 != null) {
                j jVar = this.f431529c;
                if (jVar != null) {
                    jVar.f420106a = z16;
                }
                aVar2.onSuccess(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f431531d;

        g(DialogInterface.OnClickListener onClickListener) {
            this.f431531d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.f431531d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f431533d;

        h(DialogInterface.OnClickListener onClickListener) {
            this.f431533d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.f431533d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements DialogInterface.OnDismissListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f431495d == dialogInterface) {
                a.this.f431495d = null;
            }
        }
    }

    public a(int i3) {
        this.f431492a = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nf4.i p(kf4.a aVar, int i3, String str, String str2, String str3, String str4, String str5) {
        nf4.i iVar = new nf4.i();
        iVar.f420096a = ((ll4.a) mm4.b.b(ll4.a.class)).E().uid.get();
        iVar.f420097b = str;
        iVar.f420098c = str2;
        iVar.f420104i = str3;
        iVar.f420101f = str4;
        iVar.f420102g = str5;
        iVar.f420103h = str5;
        iVar.f420105j = aVar;
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nf4.f q() {
        return ((ni4.a) mm4.b.b(ni4.a.class)).b0().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(k kVar, kf4.a aVar, @NotNull of4.a aVar2, @NotNull ef4.a aVar3, @Nullable nf4.a<k> aVar4) {
        boolean z16 = kVar.f420110b;
        int i3 = kVar.f420109a;
        String str = kVar.f420112d;
        long j3 = kVar.f420111c;
        kf4.a aVar5 = kVar.f420113e;
        nf4.e b06 = ((ni4.a) mm4.b.b(ni4.a.class)).b0();
        long c16 = b06.c();
        if (j3 != 0) {
            this.f431493b = j3;
            b06.d(j3);
        } else {
            this.f431493b = c16;
        }
        t("initQueryTimiLiveStatus success: " + i3 + ", oneKeyLiveEnable = " + z16 + ", retRoomId = " + j3 + ", rspGuildInfo = " + aVar5 + ", schemeUrl = " + str);
        aVar3.hideLoading();
        if (i3 != 0 && (1 != i3 || aVar == null || aVar5 == null || aVar.a().equals(aVar5.a()))) {
            if (1 == i3) {
                t("QQLIVE_STATUS_ON continue!");
                aVar2.b();
            } else {
                t("status init, do nothing");
            }
        } else {
            if (TextUtils.isEmpty(this.f431494c)) {
                this.f431494c = b06.i();
            }
            s("QQLIVE_STATUS_NEED_DIALOG, lastLaunchId = " + this.f431494c);
            if (!v("\u4e0a\u4e00\u573a\u6e38\u620f\u76f4\u64ad\u4ecd\u5728\u8fdb\u884c\u4e2d\uff0c\u8bf7\u7ed3\u675f\u76f4\u64ad\u540e\u91cd\u8bd5\u3002", "\u7ed3\u675f\u76f4\u64ad", new b(aVar2, aVar5), "\u6211\u77e5\u9053\u4e86", new c(str, aVar2))) {
                w("\u4e0a\u4e00\u573a\u6e38\u620f\u76f4\u64ad\u4ecd\u5728\u8fdb\u884c\u4e2d\uff0c\u8bf7\u7ed3\u675f\u76f4\u64ad\u540e\u91cd\u8bd5\u3002");
                aVar2.c();
            }
        }
        if (aVar4 != null) {
            aVar4.onSuccess(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        l.c("TgLiveTag_Manager_MainHandler", 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        l.h("TgLiveTag_Manager_MainHandler", 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z16, int i3, String str, j jVar, nf4.a<j> aVar, ef4.a aVar2) {
        SchemeUtil.g(vf4.a.b(), str, "", false, new f(aVar2, aVar, jVar));
        q().c(this.f431492a, z16, i3, "\u738b\u8005\u8363\u8000");
    }

    private boolean v(String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        g gVar;
        h hVar;
        QBaseActivity b16 = vf4.a.b();
        if (b16 != null && !b16.isFinishing()) {
            QQCustomDialog qQCustomDialog = this.f431495d;
            if (qQCustomDialog != null) {
                if (qQCustomDialog.isShowing()) {
                    this.f431495d.dismiss();
                }
                this.f431495d = null;
            }
            if (TextUtils.isEmpty(str2) && onClickListener == null) {
                gVar = null;
            } else {
                gVar = new g(onClickListener);
            }
            if (TextUtils.isEmpty(str3) && onClickListener2 == null) {
                hVar = null;
            } else {
                hVar = new h(onClickListener2);
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(b16, 230, (String) null, str, str3, str2, gVar, hVar);
            this.f431495d = createCustomDialog;
            createCustomDialog.setMessage(str);
            this.f431495d.setCancelable(false);
            this.f431495d.setOnDismissListener(new i());
            this.f431495d.show();
            return true;
        }
        s("[showTipDialog] the activity is null or is finished ");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        com.tencent.timi.game.ui.widget.f.c(str);
    }

    @Override // of4.b
    public void a(String str, long j3, kf4.a aVar, int i3, String str2, String str3, String str4, String str5, String str6, nf4.a<j> aVar2, @NotNull ef4.a aVar3) {
        if (TextUtils.isEmpty(str2)) {
            s("the room name is null");
            w("\u6807\u9898\u4e0d\u80fd\u4e3a\u7a7a");
            if (aVar2 != null) {
                aVar2.onError(-789001, "\u6807\u9898\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
            return;
        }
        t("api#startGameLive - " + str2 + " - " + str3 + ", liveAppId=" + str + ", liveUid=" + LogUtil.wrapLogUin(String.valueOf(j3)) + ", guildIdInfo = " + aVar + ", liveGameId = " + i3 + ", backScheme=" + str5 + ", shareScheme=" + str6);
        long currentTimeMillis = System.currentTimeMillis();
        aVar3.showLoading();
        ((ni4.a) mm4.b.b(ni4.a.class)).b0().e(vf4.a.b(), 101, new d(aVar, i3, str2, str3, str4, str5, str6, aVar3, str, j3, currentTimeMillis, aVar2));
        q().e(this.f431492a, true, QQLiveAnchorStreamRecordType.SCREEN.name(), i3, "\u738b\u8005\u8363\u8000");
    }

    @Override // of4.b
    public void b(String str, long j3, kf4.a aVar, @NotNull of4.a aVar2, @NotNull ef4.a aVar3, @Nullable nf4.a<k> aVar4) {
        t("api#prepare - initQueryTimiLiveStatus, liveAppId=" + str + ", liveUid=" + LogUtil.wrapLogUin(String.valueOf(j3)));
        aVar3.showLoading();
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new C11142a(str, j3, aVar, aVar2, aVar3, aVar4));
    }

    public void o(String str, long j3, nf4.a<k> aVar) {
        ((ni4.a) mm4.b.b(ni4.a.class)).b0().b(this.f431492a, str, j3, new e(aVar, System.currentTimeMillis()));
    }
}
