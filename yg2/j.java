package yg2;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.feed.b;
import com.tencent.mobileqq.qqexpand.feed.LabelInfo;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.q;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class j extends RecyclerView.ViewHolder implements View.OnClickListener {
    public LinearLayout C;
    public ImageView D;
    public ImageView E;
    public ETTextView F;
    public OldExpandVoiceView G;
    public ImageView H;
    public ImageView I;
    private final com.tencent.mobileqq.qqexpand.fragment.f J;
    private final d K;
    private VasRes L;
    private boolean M;
    private boolean N;
    private int P;
    private int Q;
    private int R;
    private final QBaseActivity S;
    private final QQAppInterface T;
    private final ExtendFriendLabelFlowLayout U;
    private c V;

    /* renamed from: d, reason: collision with root package name */
    public ExtendFriendFeedView f450297d;

    /* renamed from: e, reason: collision with root package name */
    public View f450298e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f450299f;

    /* renamed from: h, reason: collision with root package name */
    public TextView f450300h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f450301i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f450302m;

    /* JADX WARN: Multi-variable type inference failed */
    public j(View view, com.tencent.mobileqq.qqexpand.fragment.f fVar, d dVar, Activity activity) {
        super(view);
        this.M = false;
        this.N = false;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.f450297d = (ExtendFriendFeedView) view;
        this.K = dVar;
        this.J = fVar;
        QBaseActivity qBaseActivity = (QBaseActivity) activity;
        this.S = qBaseActivity;
        this.T = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.f450298e = view.findViewById(R.id.oz6);
        this.f450299f = (ImageView) view.findViewById(R.id.f163226p00);
        this.f450300h = (TextView) view.findViewById(R.id.p2d);
        this.f450301i = (ImageView) view.findViewById(R.id.f163228p02);
        this.f450302m = (TextView) view.findViewById(R.id.p28);
        this.C = (LinearLayout) view.findViewById(R.id.p07);
        this.D = (ImageView) view.findViewById(R.id.oyn);
        this.E = (ImageView) view.findViewById(R.id.oym);
        this.U = (ExtendFriendLabelFlowLayout) view.findViewById(R.id.ozc);
        this.F = (ETTextView) view.findViewById(R.id.p2c);
        this.G = (OldExpandVoiceView) view.findViewById(R.id.f163227p01);
        this.H = (ImageView) view.findViewById(R.id.oyo);
        ImageView imageView = (ImageView) view.findViewById(R.id.p2g);
        this.I = imageView;
        imageView.setOnClickListener(this);
        this.f450298e.setOnTouchListener((View.OnTouchListener) view);
        this.f450298e.setOnClickListener(this);
        this.f450299f.setOnClickListener(this);
        this.f450299f.setOnTouchListener(q.f264107a);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.G.setMode(1);
        this.G.setOnClickListener(this);
        this.G.setActivity(qBaseActivity);
        this.G.g(true);
        this.H.setOnClickListener(this);
    }

    public int c() {
        return this.P;
    }

    public int d() {
        return this.Q;
    }

    public boolean e() {
        return this.N;
    }

    public boolean f() {
        return this.M;
    }

    public void g() {
        if (this.L == null || !VasNormalToggle.VAS_BUG_113811565.isEnable(true)) {
            return;
        }
        this.L.recycle();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.J != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (view.getId() == R.id.oyn || currentTimeMillis - this.J.Oc() >= 500) {
                this.J.P9(currentTimeMillis);
                int position = getPosition();
                switch (view.getId()) {
                    case R.id.oym /* 1912930316 */:
                        this.J.Zd(position);
                        return;
                    case R.id.oyn /* 1912930317 */:
                        this.J.tc(position);
                        return;
                    case R.id.oyo /* 1912930318 */:
                        this.J.xd(position);
                        return;
                    case R.id.oz6 /* 1912930336 */:
                        this.J.Vg(position, 2);
                        return;
                    case R.id.f163226p00 /* 1912930367 */:
                        this.J.Vg(position, 1);
                        return;
                    case R.id.p2g /* 1912930458 */:
                        ff.N(view, (com.tencent.mobileqq.qqexpand.bean.feed.b) view.getTag());
                        return;
                    case R.id.f167117l01 /* 2131392901 */:
                        this.J.S5(position);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void h() {
        this.N = false;
        this.M = false;
        this.Q = 0;
        this.R = 0;
        this.P = 0;
        this.F.setFont(0, System.currentTimeMillis());
        this.f450298e.setBackground(null);
    }

    public void b(j jVar, com.tencent.mobileqq.qqexpand.bean.feed.b bVar, int i3) {
        int i16;
        String str;
        if (bVar.mIsMyFeed) {
            jVar.D.setVisibility(8);
            jVar.E.setVisibility(8);
        } else {
            jVar.D.setVisibility(0);
            jVar.E.setVisibility(0);
        }
        if (!bVar.mbAllowStrangerVote) {
            jVar.D.setVisibility(8);
        }
        jVar.G.setVisibility(TextUtils.isEmpty(bVar.mVoiceUrl) ? 8 : 0);
        jVar.f450297d.setFeedBgParams(jVar.getPosition(), bVar.mVoiceUrl, i3);
        jVar.G.setVoiceUrl(bVar.mVoiceUrl);
        jVar.G.setVoiceDuration(bVar.mVoiceDuration);
        jVar.f450299f.setImageDrawable(this.K.K7(bVar.mUin, bVar.mNickName, jVar.f450299f));
        jVar.f450300h.setText(bVar.mNickName);
        jVar.F.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(bVar.mDeclaration), 3, 24));
        jVar.F.setTextColor(-16777216);
        ImageView imageView = jVar.D;
        if (bVar.mLiked) {
            i16 = bVar.mAvailLikeCount == 0 ? R.drawable.ac_ : R.drawable.ac9;
        } else {
            i16 = R.drawable.ac8;
        }
        imageView.setImageResource(i16);
        ff.Z(bVar, jVar.I);
        jVar.I.setTag(bVar);
        h();
        ArrayList arrayList = new ArrayList();
        LabelInfo a16 = com.tencent.mobileqq.qqexpand.utils.h.a(bVar, BaseApplication.getContext());
        if (a16 != null) {
            arrayList.add(a16);
        }
        LabelInfo c16 = com.tencent.mobileqq.qqexpand.utils.h.c(bVar, BaseApplication.getContext());
        if (c16 != null) {
            arrayList.add(c16);
        }
        List<LabelInfo> b16 = com.tencent.mobileqq.qqexpand.utils.h.b(bVar, BaseApplication.getContext());
        if (b16 != null && b16.size() > 0) {
            arrayList.addAll(b16);
        }
        if (arrayList.size() > 0) {
            jVar.U.setVisibility(0);
            c cVar = jVar.V;
            if (cVar != null) {
                cVar.b();
            } else {
                jVar.V = new c(BaseApplication.getContext());
            }
            jVar.V.h(this.N);
            jVar.V.a(arrayList);
        } else {
            jVar.U.setVisibility(8);
        }
        jVar.U.setAdapter(jVar.V);
        List<b.C8313b> list = bVar.mSchoolInfos;
        if (list != null && list.size() > 0) {
            b.C8313b c8313b = bVar.mSchoolInfos.get(0);
            if (c8313b != null) {
                this.C.setVisibility(0);
                if (!TextUtils.isEmpty(c8313b.f263490c)) {
                    jVar.f450302m.setText(c8313b.f263490c);
                }
                if (c8313b.f263489b == 2) {
                    jVar.f450301i.setImageResource(R.drawable.ne8);
                } else {
                    jVar.f450301i.setImageResource(R.drawable.ne9);
                }
            } else {
                this.C.setVisibility(8);
            }
        } else {
            this.C.setVisibility(8);
        }
        if (!this.N && !this.M) {
            str = "1";
        } else {
            str = "2";
        }
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_show", "", 0, "", str);
        HashMap hashMap = new HashMap();
        hashMap.put("feed_uid", bVar.mUin);
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#voice_tab#feed", true, -1L, -1L, hashMap, true, true);
    }
}
