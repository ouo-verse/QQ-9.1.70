package tn4;

import android.os.Bundle;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import tn4.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends TRTCCloudListener {

    /* renamed from: a, reason: collision with root package name */
    private final tn4.a f436894a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436895a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f436896b;

        a(String str, boolean z16) {
            this.f436895a = str;
            this.f436896b = z16;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserSubStreamAvailable(this.f436895a, this.f436896b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class aa implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436898a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436899b;

        aa(int i3, int i16) {
            this.f436898a = i3;
            this.f436899b = i16;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onAudioEffectFinished(this.f436898a, this.f436899b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ab implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436901a;

        ab(int i3) {
            this.f436901a = i3;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onExitRoom(this.f436901a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ac implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436903a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436904b;

        ac(int i3, String str) {
            this.f436903a = i3;
            this.f436904b = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSwitchRole(this.f436903a, this.f436904b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ad implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436906a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436907b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f436908c;

        ad(String str, int i3, String str2) {
            this.f436906a = str;
            this.f436907b = i3;
            this.f436908c = str2;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onConnectOtherRoom(this.f436906a, this.f436907b, this.f436908c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ae implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436910a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436911b;

        ae(int i3, String str) {
            this.f436910a = i3;
            this.f436911b = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onDisConnectOtherRoom(this.f436910a, this.f436911b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class af implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436913a;

        af(String str) {
            this.f436913a = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRemoteUserEnterRoom(this.f436913a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ag implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436915a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436916b;

        ag(String str, int i3) {
            this.f436915a = str;
            this.f436916b = i3;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRemoteUserLeaveRoom(this.f436915a, this.f436916b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ah implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436918a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f436919b;

        ah(String str, boolean z16) {
            this.f436918a = str;
            this.f436919b = z16;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserVideoAvailable(this.f436918a, this.f436919b);
        }
    }

    /* compiled from: P */
    /* renamed from: tn4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11303b implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436921a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f436922b;

        C11303b(String str, boolean z16) {
            this.f436921a = str;
            this.f436922b = z16;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserAudioAvailable(this.f436921a, this.f436922b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436924a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436925b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f436926c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f436927d;

        c(String str, int i3, int i16, int i17) {
            this.f436924a = str;
            this.f436925b = i3;
            this.f436926c = i16;
            this.f436927d = i17;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onFirstVideoFrame(this.f436924a, this.f436925b, this.f436926c, this.f436927d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436929a;

        d(String str) {
            this.f436929a = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onFirstAudioFrame(this.f436929a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436931a;

        e(int i3) {
            this.f436931a = i3;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSendFirstLocalVideoFrame(this.f436931a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class f implements a.InterfaceC11302a {
        f() {
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSendFirstLocalAudioFrame();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class g implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436934a;

        g(String str) {
            this.f436934a = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserEnter(this.f436934a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class h implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436936a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436937b;

        h(String str, int i3) {
            this.f436936a = str;
            this.f436937b = i3;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserExit(this.f436936a, this.f436937b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class i implements a.InterfaceC11302a {
        i() {
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onConnectionLost();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class j implements a.InterfaceC11302a {
        j() {
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onTryToReconnect();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class k implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436941a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436942b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f436943c;

        k(int i3, String str, Bundle bundle) {
            this.f436941a = i3;
            this.f436942b = str;
            this.f436943c = bundle;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onError(this.f436941a, this.f436942b, this.f436943c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class l implements a.InterfaceC11302a {
        l() {
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onConnectionRecovery();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class m implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TRTCCloudDef.TRTCSpeedTestResult f436946a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436947b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f436948c;

        m(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i3, int i16) {
            this.f436946a = tRTCSpeedTestResult;
            this.f436947b = i3;
            this.f436948c = i16;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSpeedTest(this.f436946a, this.f436947b, this.f436948c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class n implements a.InterfaceC11302a {
        n() {
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onCameraDidReady();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class o implements a.InterfaceC11302a {
        o() {
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onMicDidReady();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class p implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436952a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436953b;

        p(int i3, int i16) {
            this.f436952a = i3;
            this.f436953b = i16;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onAudioRouteChanged(this.f436952a, this.f436953b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class q implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f436955a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436956b;

        q(ArrayList arrayList, int i3) {
            this.f436955a = arrayList;
            this.f436956b = i3;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserVoiceVolume(this.f436955a, this.f436956b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class r implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436958a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436959b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f436960c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f436961d;

        r(String str, int i3, int i16, byte[] bArr) {
            this.f436958a = str;
            this.f436959b = i3;
            this.f436960c = i16;
            this.f436961d = bArr;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRecvCustomCmdMsg(this.f436958a, this.f436959b, this.f436960c, this.f436961d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class s implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436963a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f436964b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f436965c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f436966d;

        s(String str, int i3, int i16, int i17) {
            this.f436963a = str;
            this.f436964b = i3;
            this.f436965c = i16;
            this.f436966d = i17;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onMissCustomCmdMsg(this.f436963a, this.f436964b, this.f436965c, this.f436966d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class t implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f436968a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f436969b;

        t(String str, byte[] bArr) {
            this.f436968a = str;
            this.f436969b = bArr;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRecvSEIMsg(this.f436968a, this.f436969b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class u implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436971a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436972b;

        u(int i3, String str) {
            this.f436971a = i3;
            this.f436972b = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStartPublishing(this.f436971a, this.f436972b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class v implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f436974a;

        v(long j3) {
            this.f436974a = j3;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onEnterRoom(this.f436974a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class w implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436976a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436977b;

        w(int i3, String str) {
            this.f436976a = i3;
            this.f436977b = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStopPublishing(this.f436976a, this.f436977b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class x implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436979a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436980b;

        x(int i3, String str) {
            this.f436979a = i3;
            this.f436980b = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStartPublishCDNStream(this.f436979a, this.f436980b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class y implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436982a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436983b;

        y(int i3, String str) {
            this.f436982a = i3;
            this.f436983b = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStopPublishCDNStream(this.f436982a, this.f436983b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class z implements a.InterfaceC11302a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f436985a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f436986b;

        z(int i3, String str) {
            this.f436985a = i3;
            this.f436986b = str;
        }

        @Override // tn4.a.InterfaceC11302a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSetMixTranscodingConfig(this.f436985a, this.f436986b);
        }
    }

    public b(tn4.a aVar) {
        this.f436894a = aVar;
    }

    private void L(String str, Object... objArr) {
        tn4.c.a(str, objArr);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioEffectFinished(int i3, int i16) {
        L("onAudioEffectFinished", Integer.valueOf(i3), Integer.valueOf(i16));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new aa(i3, i16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioRouteChanged(int i3, int i16) {
        L("onAudioRouteChanged", Integer.valueOf(i3), Integer.valueOf(i16));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new p(i3, i16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onCameraDidReady() {
        L("onCameraDidReady", new Object[0]);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new n());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectOtherRoom(String str, int i3, String str2) {
        L("onConnectOtherRoom", str, Integer.valueOf(i3), str2);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new ad(str, i3, str2));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionLost() {
        L("onConnectionLost", new Object[0]);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new i());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionRecovery() {
        L("onConnectionRecovery", new Object[0]);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new l());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onDisConnectOtherRoom(int i3, String str) {
        L("onDisConnectOtherRoom", Integer.valueOf(i3), str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new ae(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long j3) {
        L("onEnterRoom", "\u8017\u65f6:" + j3 + "ms");
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new v(j3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int i3, String str, Bundle bundle) {
        L("onError", Integer.valueOf(i3), str, bundle);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new k(i3, str, bundle));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int i3) {
        L("onExitRoom", Integer.valueOf(i3));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new ab(i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstAudioFrame(String str) {
        L("onFirstAudioFrame", str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new d(str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(String str, int i3, int i16, int i17) {
        L("onFirstVideoFrame", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new c(str, i3, i16, i17));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMicDidReady() {
        L("onMicDidReady", new Object[0]);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new o());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMissCustomCmdMsg(String str, int i3, int i16, int i17) {
        L("onMissCustomCmdMsg", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new s(str, i3, i16, i17));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvCustomCmdMsg(String str, int i3, int i16, byte[] bArr) {
        L("onRecvCustomCmdMsg", Integer.valueOf(i3), Integer.valueOf(i16), bArr);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new r(str, i3, i16, bArr));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvSEIMsg(String str, byte[] bArr) {
        L("onRecvSEIMsg", bArr);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new t(str, bArr));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(String str) {
        L("onRemoteUserEnterRoom", str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new af(str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(String str, int i3) {
        L("onRemoteUserLeaveRoom", str, Integer.valueOf(i3));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new ag(str, i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalAudioFrame() {
        L("onSendFirstLocalAudioFrame", new Object[0]);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new f());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalVideoFrame(int i3) {
        L("onSendFirstLocalVideoFrame", Integer.valueOf(i3));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new e(i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSetMixTranscodingConfig(int i3, String str) {
        L("onSetMixTranscodingConfig", Integer.valueOf(i3), str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new z(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i3, int i16) {
        L("onSpeedTest", tRTCSpeedTestResult, Integer.valueOf(i3), Integer.valueOf(i16));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new m(tRTCSpeedTestResult, i3, i16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStartPublishCDNStream(int i3, String str) {
        L("onStartPublishCDNStream", Integer.valueOf(i3), str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new x(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStartPublishing(int i3, String str) {
        L("onStartPublishing", Integer.valueOf(i3), str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new u(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStopPublishCDNStream(int i3, String str) {
        L("onStopPublishCDNStream", Integer.valueOf(i3), str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new y(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStopPublishing(int i3, String str) {
        L("onStopPublishing", Integer.valueOf(i3), str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new w(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRole(int i3, String str) {
        L("onSwitchRole", Integer.valueOf(i3), str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new ac(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onTryToReconnect() {
        L("onTryToReconnect", new Object[0]);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new j());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(String str, boolean z16) {
        L("onUserAudioAvailable", str, Boolean.valueOf(z16));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new C11303b(str, z16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserEnter(String str) {
        L("onUserEnter", str);
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new g(str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserExit(String str, int i3) {
        L("onUserExit", str, Integer.valueOf(i3));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new h(str, i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserSubStreamAvailable(String str, boolean z16) {
        L("onUserSubStreamAvailable", str, Boolean.valueOf(z16));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new a(str, z16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(String str, boolean z16) {
        L("onUserVideoAvailable", str, Boolean.valueOf(z16));
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new ah(str, z16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i3) {
        tn4.a aVar = this.f436894a;
        if (aVar != null) {
            aVar.L(new q(arrayList, i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStatistics(TRTCStatistics tRTCStatistics) {
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onWarning(int i3, String str, Bundle bundle) {
    }
}
