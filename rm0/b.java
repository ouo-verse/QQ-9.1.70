package rm0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.List;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private a D;
    private ViewGroup E;
    private d G;

    /* renamed from: d, reason: collision with root package name */
    protected ImageView f431674d;

    /* renamed from: e, reason: collision with root package name */
    protected View f431675e;

    /* renamed from: f, reason: collision with root package name */
    protected View f431676f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f431677h;

    /* renamed from: i, reason: collision with root package name */
    protected int f431678i = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f431679m = 0;
    private boolean C = false;
    protected int F = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    private static String d(GdtAd gdtAd, int i3) {
        if (gdtAd != null) {
            try {
                List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap = gdtAd.getExpMap();
                for (int i16 = 0; i16 < expMap.size(); i16++) {
                    if (expMap.get(i16).key.get() == i3) {
                        return expMap.get(i16).value.get();
                    }
                }
                return "";
            } catch (Throwable th5) {
                QLog.e("GdtMvTitleHelper", 1, "exp_map error" + th5);
                return "";
            }
        }
        return "";
    }

    private static int e(GdtAd gdtAd) {
        String d16 = d(gdtAd, 104804);
        QLog.i("GdtMvTitleHelper", 1, "getRewardVideoCloseBtnAppearSecFromExp = " + d16);
        if (TextUtils.isEmpty(d16)) {
            return 0;
        }
        try {
            return Integer.parseInt(d16);
        } catch (Exception e16) {
            QLog.i("GdtMvTitleHelper", 1, "getRewardVideoCloseBtnAppearSecFromExp error", e16);
            return 0;
        }
    }

    private void g(GdtMotiveVideoModel gdtMotiveVideoModel) {
        String str;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null && this.f431677h != null) {
            String experimentParam = gdtMotiveVideoModel.getGdtAd().getExperimentParam(GdtAd.EXP_KEY_MOTIVE_VIDEO_FEEDBACK_STYLE);
            boolean z16 = false;
            this.C = false;
            if ("1".equals(experimentParam)) {
                this.C = true;
                str = "\u4e0d\u611f\u5174\u8da3";
            } else {
                str = "";
            }
            if (this.C && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(gdtMotiveVideoModel.getGdtAd().getUrlForFeedBack()) && this.f431679m == 1) {
                z16 = true;
            }
            this.C = z16;
            if (z16) {
                this.f431677h.setText(str);
            }
            this.f431677h.setVisibility(8);
            QLog.i("GdtMvTitleHelper", 4, "feedbackParams = " + experimentParam);
        }
    }

    private void i(ViewGroup viewGroup) {
        this.G = new rm0.a();
        QLog.i("GdtMvTitleHelper", 1, "initView countDownStyle =" + this.G.toString());
        this.G.b(viewGroup, this);
    }

    public void a() {
        try {
            ViewGroup viewGroup = this.E;
            if (viewGroup == null) {
                QLog.i("GdtMvTitleHelper", 1, "fitIpadScreen bar == null");
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            if (childAt == null) {
                QLog.i("GdtMvTitleHelper", 1, "fitIpadScreen view == null");
                return;
            }
            DisplayMetrics displayMetrics = this.E.getContext().getResources().getDisplayMetrics();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            float f16 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (f16 / i3 < 0.5625f) {
                return;
            }
            layoutParams.width = (int) (i3 * 0.5625f);
            layoutParams.gravity = 1;
            childAt.setLayoutParams(layoutParams);
        } catch (Exception e16) {
            QLog.e("GdtMvTitleHelper", 1, "fitIpadScreen failed = " + e16);
        }
    }

    public void b(Activity activity, boolean z16) {
        try {
            ViewGroup viewGroup = this.E;
            if (viewGroup == null) {
                QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen bar == null");
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            LiuHaiUtils.initLiuHaiProperty(activity);
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                if (z16) {
                    layoutParams.topMargin = LiuHaiUtils.getNotchInScreenHeight(activity);
                } else {
                    layoutParams.leftMargin = LiuHaiUtils.getNotchInScreenHeight(activity);
                }
                this.E.setLayoutParams(layoutParams);
                QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen addHeight = " + layoutParams.topMargin);
            }
        } catch (Exception unused) {
            QLog.i("GdtMvTitleHelper", 1, "initView countDownStyle =" + this.f431678i);
        }
    }

    public boolean c() {
        View view = this.f431675e;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void f() {
        ImageView imageView = this.f431674d;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.f431676f;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void h(View view, a aVar, GdtMotiveVideoModel gdtMotiveVideoModel) {
        if (gdtMotiveVideoModel != null) {
            this.F = e(gdtMotiveVideoModel.getGdtAd());
        }
        this.D = aVar;
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.vmr);
        this.E = viewGroup;
        if (viewGroup == null) {
            QLog.i("GdtMvTitleHelper", 1, "bar == null");
        } else {
            i(viewGroup);
            g(gdtMotiveVideoModel);
        }
    }

    public void j(Context context, boolean z16) {
        d dVar = this.G;
        if (dVar == null) {
            QLog.i("GdtMvTitleHelper", 1, "refreshVoiceIconDrawableInner factory is null");
        } else {
            dVar.c(context, z16);
        }
    }

    public void k(int i3) {
        this.f431679m = i3;
    }

    public void l(int i3) {
        this.E.setVisibility(i3);
    }

    public void m(long j3, boolean z16) {
        View view;
        if ((z16 || j3 >= this.F) && (view = this.f431675e) != null) {
            view.setVisibility(0);
        }
    }

    public void n(long j3, long j16, long j17) {
        d dVar = this.G;
        if (dVar == null) {
            QLog.i("GdtMvTitleHelper", 1, "updateCountDown factory is null");
        } else {
            dVar.a(j3, j16, j17);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.vsj) {
            a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (id5 == R.id.vsm) {
            a aVar3 = this.D;
            if (aVar3 != null) {
                aVar3.a();
            }
        } else if (id5 == R.id.vsk && (aVar = this.D) != null) {
            aVar.c();
            this.f431677h.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
