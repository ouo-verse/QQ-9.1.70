package vb0;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.events.QCircleShareItemClickEvent;
import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements ShareActionSheetClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final QCircleShareInfo f441293a;

    /* renamed from: b, reason: collision with root package name */
    private final int f441294b;

    /* renamed from: c, reason: collision with root package name */
    private final int f441295c;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f441296d;

    /* renamed from: e, reason: collision with root package name */
    private final QCircleReportBean f441297e;

    /* renamed from: f, reason: collision with root package name */
    private final String f441298f;

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f441299g;

    /* renamed from: h, reason: collision with root package name */
    private final QCircleRichMediaDownLoadManager.e f441300h;

    /* renamed from: i, reason: collision with root package name */
    private final wb0.a f441301i;

    /* renamed from: j, reason: collision with root package name */
    private final FeedCloudMeta$StFeed f441302j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: vb0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterfaceOnClickListenerC11409a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC11409a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            a.this.l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f441305d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f441306e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f441307f;

        c(String str, String str2, int i3) {
            this.f441305d = str;
            this.f441306e = str2;
            this.f441307f = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.s(this.f441305d, this.f441306e, this.f441307f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.r();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f441310d;

        e(int i3) {
            this.f441310d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.t(this.f441310d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f441312d;

        f(int i3) {
            this.f441312d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.u(this.f441312d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f441314d;

        g(int i3) {
            this.f441314d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.p(this.f441314d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private QCircleShareInfo f441316a;

        /* renamed from: b, reason: collision with root package name */
        private int f441317b;

        /* renamed from: c, reason: collision with root package name */
        private int f441318c;

        /* renamed from: d, reason: collision with root package name */
        private Activity f441319d;

        /* renamed from: e, reason: collision with root package name */
        private QCircleReportBean f441320e;

        /* renamed from: f, reason: collision with root package name */
        private String f441321f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f441322g = null;

        /* renamed from: h, reason: collision with root package name */
        private QCircleRichMediaDownLoadManager.e f441323h;

        /* renamed from: i, reason: collision with root package name */
        private wb0.a f441324i;

        /* renamed from: j, reason: collision with root package name */
        private FeedCloudMeta$StFeed f441325j;

        public a k() {
            return new a(this);
        }

        public h l(Activity activity) {
            this.f441319d = activity;
            return this;
        }

        public h m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f441325j = feedCloudMeta$StFeed;
            return this;
        }

        public h n(wb0.a aVar) {
            this.f441324i = aVar;
            return this;
        }

        public h o(QCircleRichMediaDownLoadManager.e eVar) {
            this.f441323h = eVar;
            return this;
        }

        public h p(int i3) {
            this.f441317b = i3;
            return this;
        }

        public h q(int i3) {
            this.f441318c = i3;
            return this;
        }

        public h r(String str) {
            this.f441321f = str;
            return this;
        }

        public h s(byte[] bArr) {
            this.f441322g = bArr;
            return this;
        }

        public h t(QCircleReportBean qCircleReportBean) {
            this.f441320e = qCircleReportBean;
            return this;
        }

        public h u(QCircleShareInfo qCircleShareInfo) {
            this.f441316a = qCircleShareInfo;
            return this;
        }
    }

    public a(h hVar) {
        this.f441293a = hVar.f441316a;
        this.f441294b = hVar.f441317b;
        this.f441295c = hVar.f441318c;
        this.f441296d = hVar.f441319d;
        this.f441297e = hVar.f441320e;
        this.f441298f = hVar.f441321f;
        this.f441299g = hVar.f441322g;
        this.f441300h = hVar.f441323h;
        this.f441301i = hVar.f441324i;
        this.f441302j = hVar.f441325j;
    }

    private boolean h() {
        return i(46, "collect_banned_text", R.string.f188743xi);
    }

    private boolean i(int i3, String str, int i16) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f441302j;
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.opMask2.get() == null || !this.f441302j.opMask2.get().contains(Integer.valueOf(i3))) {
            return false;
        }
        QCircleToast.o(QCirclePluginUtil.getValueFromListEntry(this.f441302j.feedTextInfo.get(), str, com.tencent.biz.qqcircle.utils.h.a(i16)), 0);
        return true;
    }

    private boolean j() {
        return i(26, "share_banned_text", R.string.f195624f4);
    }

    private boolean k() {
        if (!QCirclePluginUtil.isFeedOwner(this.f441302j)) {
            return false;
        }
        cq cqVar = cq.f92752a;
        if (!cqVar.s(this.f441302j)) {
            QLog.d("QFSSharePart", 1, "[checkShareForbidIfQZoneFeedAndHost] is not feed from qzone");
            return false;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f441302j;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.opMask2.get() != null && this.f441302j.opMask2.get().contains(26)) {
            int i3 = cqVar.i(this.f441302j);
            QLog.d("QFSSharePart", 1, "[checkShareForbidIfQZoneFeedAndHost] rightFlag=" + i3);
            if (i3 == 1) {
                return false;
            }
            return true;
        }
        QLog.d("QFSSharePart", 1, "[checkShareForbidIfQZoneFeedAndHost] not has opMask2 26");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16) {
        wb0.a aVar = this.f441301i;
        if (aVar != null) {
            aVar.a(z16);
        }
    }

    private int m() {
        QCircleShareInfo qCircleShareInfo = this.f441293a;
        if (qCircleShareInfo != null) {
            int i3 = qCircleShareInfo.type;
            if (i3 == 12 || i3 == 13) {
                return 39;
            }
            return 8;
        }
        return 8;
    }

    private int o() {
        QCircleShareInfo qCircleShareInfo = this.f441293a;
        if (qCircleShareInfo != null) {
            int i3 = qCircleShareInfo.type;
            if (i3 == 12 || i3 == 13) {
                return 38;
            }
            return 4;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).x(this.f441295c).s(this.f441296d).A(this.f441297e).y(this.f441298f).C(i3).z(this.f441299g).t(this.f441301i).r(14).E();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(14));
        l(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int i3;
        if (n.j(this.f441293a.feed)) {
            i3 = 26;
        } else {
            i3 = 0;
        }
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).w(this.f441294b).x(this.f441295c).A(this.f441297e).y(this.f441298f).z(this.f441299g).t(this.f441301i).r(i3).E();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(0));
        l(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        int i3;
        if (n.j(this.f441293a.feed)) {
            i3 = 27;
        } else {
            i3 = 1;
        }
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).x(this.f441295c).s(this.f441296d).y(this.f441298f).z(this.f441299g).A(this.f441297e).t(this.f441301i).r(i3).E();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(1));
        l(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, int i3) {
        int i16;
        if (n.j(this.f441293a.feed)) {
            i16 = 28;
        } else {
            i16 = 2;
        }
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).w(this.f441294b).x(this.f441295c).A(this.f441297e).y(this.f441298f).z(this.f441299g).G(str).F(str2).H(i3).t(this.f441301i).r(i16).E();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(2));
        l(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).x(this.f441295c).s(this.f441296d).A(this.f441297e).y(this.f441298f).C(i3).z(this.f441299g).I(true).t(this.f441301i).r(3).E();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(3));
        l(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3) {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).x(this.f441295c).s(this.f441296d).A(this.f441297e).y(this.f441298f).z(this.f441299g).I(false).C(i3).t(this.f441301i).r(3).E();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(3));
        l(false);
    }

    private void v(DialogInterface.OnClickListener onClickListener) {
        DialogUtil.createCustomDialog(this.f441296d, 230, com.tencent.biz.qqcircle.utils.h.a(R.string.f194464bz), com.tencent.biz.qqcircle.utils.h.a(R.string.f194454by), com.tencent.biz.qqcircle.utils.h.a(R.string.cancel), com.tencent.biz.qqcircle.utils.h.a(R.string.f194444bx), onClickListener, new DialogInterfaceOnClickListenerC11409a()).show();
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void cancelPushDisable() {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).s(this.f441296d).x(this.f441295c).A(this.f441297e).r(12).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(12));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void cancelWatchLater() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(43).E();
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void changeFeedPermission(boolean z16) {
        int i3;
        if (z16) {
            i3 = 17;
        } else {
            i3 = 18;
        }
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).s(this.f441296d).x(this.f441295c).A(this.f441297e).D(false).r(i3).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(i3));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void collect() {
        if (h()) {
            l(false);
            return;
        }
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).A(this.f441297e).x(this.f441295c).w(this.f441294b).t(this.f441301i).r(21).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(21));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void copyContent() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(37).E();
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void copyLink() {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).s(this.f441296d).x(this.f441295c).A(this.f441297e).D(false).r(13).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(13));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void copyShortLink() {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).s(this.f441296d).x(this.f441295c).A(this.f441297e).D(false).r(41).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(41));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void createQrcode() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(31).E();
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void dataAnalyze() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).r(29).E();
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void delete() {
        int m3 = m();
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).A(this.f441297e).y(this.f441298f).x(this.f441295c).w(this.f441294b).r(m3).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(m3));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void deleteAlbum() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).A(this.f441297e).x(this.f441295c).w(this.f441294b).r(19).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(19));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void deleteHasPush() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).w(this.f441294b).x(this.f441295c).A(this.f441297e).r(9).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(9));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void editAlbum() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).A(this.f441297e).x(this.f441295c).w(this.f441294b).r(20).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(20));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void enterQCircleFloatingWindow() {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).x(this.f441295c).s(this.f441296d).A(this.f441297e).y(this.f441298f).z(this.f441299g).t(this.f441301i).r(35).E();
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void feedback() {
        Activity activity;
        QCircleShareInfo qCircleShareInfo = this.f441293a;
        if (qCircleShareInfo != null && qCircleShareInfo.feed != null && (activity = this.f441296d) != null) {
            com.tencent.biz.qqcircle.debug.b.p(activity, qCircleShareInfo);
            l(false);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(24));
        }
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void hideHim() {
        new QCircleBaseShareOperation.a().B(this.f441293a).w(this.f441294b).x(this.f441295c).A(this.f441297e).E(4).D(false).r(7).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(7));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void hideThisWork() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).w(this.f441294b).x(this.f441295c).A(this.f441297e).E(3).D(false).r(7).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(7));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void jumpQcirclePrivateMessage() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).w(this.f441294b).A(this.f441297e).r(11).E();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(11));
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void miniAppDebugOn() {
        QCircleShareInfo qCircleShareInfo = this.f441293a;
        if (qCircleShareInfo != null && qCircleShareInfo.feed != null && this.f441296d != null) {
            com.tencent.biz.qqcircle.launcher.c.x(QCircleApplication.APP.getApplicationContext());
            l(false);
        }
    }

    public wb0.a n() {
        return this.f441301i;
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void openFeedBindQQGroupPage() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(33).E();
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void openMusicAggregationPage() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(36).E();
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void promotion() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).r(32).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(32));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void pushRanComment() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(44).E();
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void report() {
        int o16 = o();
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).y(this.f441298f).A(this.f441297e).z(this.f441299g).r(o16).E();
        this.f441301i.report();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(o16));
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void save() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).w(this.f441294b).x(this.f441295c).A(this.f441297e).u(this.f441300h).t(this.f441301i).r(10).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(10));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void saveQrcode() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(30).E();
        l(false);
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void setQQProfileCover() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(40).E();
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void shareToChannel(int i3) {
        if (k()) {
            v(new g(i3));
        } else if (j()) {
            l(false);
        } else {
            p(i3);
        }
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void shareToQQ() {
        if (k()) {
            v(new b());
        } else if (j()) {
            l(false);
        } else {
            q();
        }
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void shareToQZone() {
        if (k()) {
            v(new d());
        } else if (j()) {
            l(false);
        } else {
            r();
        }
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void shareToSpecifiedFriend(String str, String str2, int i3) {
        if (k()) {
            v(new c(str, str2, i3));
        } else if (j()) {
            l(false);
        } else {
            s(str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void shareToWeChat(int i3) {
        if (k()) {
            v(new e(i3));
        } else if (j()) {
            l(false);
        } else {
            t(i3);
        }
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void shareToWeChatCircle(int i3) {
        if (k()) {
            v(new f(i3));
        } else if (j()) {
            l(false);
        } else {
            u(i3);
        }
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void showReportDisLike() {
        int i3;
        if (n.j(this.f441293a.feed)) {
            i3 = 25;
        } else {
            i3 = 5;
        }
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).w(this.f441294b).x(this.f441295c).A(this.f441297e).t(this.f441301i).r(i3).E();
        l(true);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(5));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void stick() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).A(this.f441297e).x(this.f441295c).w(this.f441294b).r(15).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(15));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void switchBarrageClose() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).v(true).A(this.f441297e).x(this.f441295c).w(this.f441294b).r(6).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(6));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void switchBarrageOpen() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).v(false).A(this.f441297e).x(this.f441295c).w(this.f441294b).r(6).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(6));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void unCollect() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).A(this.f441297e).x(this.f441295c).w(this.f441294b).t(this.f441301i).r(22).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(22));
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void unStick() {
        new QCircleBaseShareOperation.a().B(this.f441293a).s(this.f441296d).A(this.f441297e).x(this.f441295c).w(this.f441294b).r(16).E();
        l(false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleShareItemClickEvent(16));
    }

    public void w(QCircleShareInfo qCircleShareInfo) {
        int i3 = qCircleShareInfo.silentShareType;
        if (i3 != 0) {
            if (i3 == 2) {
                shareToSpecifiedFriend(qCircleShareInfo.mShareUinName, qCircleShareInfo.mShareUin, qCircleShareInfo.mShareUinType);
                return;
            }
        } else {
            shareToQQ();
        }
        QLog.d("QFSSharePart", 1, "don't support silent share type");
    }

    @Override // com.tencent.mobileqq.share.api.ShareActionSheetClickListener
    public void watchLater() {
        new QCircleBaseShareOperation.a().B(this.f441293a).A(this.f441297e).s(this.f441296d).t(this.f441301i).r(42).E();
    }
}
