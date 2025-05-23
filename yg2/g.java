package yg2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.component.banner.BusinessADBannerData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.FeedBannerItemGradientLinearLayout;
import com.tencent.mobileqq.qqexpand.widget.TabLayout;
import com.tencent.mobileqq.qqexpand.widget.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends RecyclerView.ViewHolder {

    /* renamed from: d, reason: collision with root package name */
    private TextView f450280d;

    /* renamed from: e, reason: collision with root package name */
    private n f450281e;

    /* renamed from: f, reason: collision with root package name */
    private final c f450282f;

    /* renamed from: h, reason: collision with root package name */
    private String f450283h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f450284i;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements TabLayout.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f450285a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f450286b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f450287c;

        a(ArrayList arrayList, int i3, int i16) {
            this.f450285a = arrayList;
            this.f450286b = i3;
            this.f450287c = i16;
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.TabLayout.a
        public View a(int i3) {
            int count = getCount();
            View inflate = View.inflate(g.this.itemView.getContext(), count <= d() ? R.layout.czt : R.layout.czu, null);
            g.this.g(inflate, (f) this.f450285a.get(i3), i3, count);
            g.this.l((f) this.f450285a.get(i3), i3, "0X800A9B0");
            HashMap hashMap = new HashMap();
            if (i3 == 0) {
                hashMap.put(BusinessADBannerData.KEY_BANNER_APPID, "1");
            } else {
                hashMap.put(BusinessADBannerData.KEY_BANNER_APPID, String.valueOf(((f) this.f450285a.get(i3)).f450271b));
            }
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#" + g.this.f450283h + "#banner", true, -1L, -1L, hashMap, true, true);
            return inflate;
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.TabLayout.a
        public int b() {
            return this.f450286b;
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.TabLayout.a
        public Rect c(int i3) {
            Rect rect = new Rect(0, 0, 0, 0);
            int count = getCount();
            if (count > 1) {
                if (i3 == 0) {
                    int i16 = this.f450287c;
                    rect.right = i16;
                    rect.left = i16 * 2;
                } else if (i3 == count - 1) {
                    int i17 = this.f450287c;
                    rect.left = i17;
                    rect.right = i17 * 2;
                } else {
                    int i18 = this.f450287c;
                    rect.right = i18;
                    rect.left = i18;
                }
            } else if (count == 1) {
                int i19 = this.f450287c * 2;
                rect.right = i19;
                rect.left = i19;
            }
            return rect;
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.TabLayout.a
        public int d() {
            return 2;
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.TabLayout.a
        public int getCount() {
            return this.f450285a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f450289d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FrameLayout f450290e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f450291f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TextView f450292h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ f f450293i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f450294m;

        b(View view, FrameLayout frameLayout, TextView textView, TextView textView2, f fVar, int i3) {
            this.f450289d = view;
            this.f450290e = frameLayout;
            this.f450291f = textView;
            this.f450292h = textView2;
            this.f450293i = fVar;
            this.f450294m = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f450289d.setVisibility(0);
                this.f450290e.setAlpha(0.5f);
                this.f450291f.setAlpha(0.5f);
                this.f450292h.setAlpha(0.5f);
            } else if (actionMasked == 1) {
                this.f450289d.setVisibility(4);
                this.f450290e.setAlpha(1.0f);
                this.f450291f.setAlpha(1.0f);
                this.f450292h.setAlpha(1.0f);
                g.this.j(this.f450293i, this.f450294m);
            } else if (actionMasked == 3) {
                this.f450289d.setVisibility(4);
                this.f450290e.setAlpha(1.0f);
                this.f450291f.setAlpha(1.0f);
                this.f450292h.setAlpha(1.0f);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface c {
        void Kg();
    }

    public g(View view, c cVar) {
        super(view);
        this.f450283h = "school_tab";
        this.f450284i = true;
        this.f450282f = cVar;
    }

    private void f(FrameLayout frameLayout, int i3) {
        int dip2px;
        n nVar = this.f450281e;
        if (nVar != null) {
            nVar.h();
        }
        n nVar2 = new n(i3 == 1 ? 4 : i3 <= 2 ? 2 : 3);
        this.f450281e = nVar2;
        if (nVar2.f() != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (i3 == 1) {
                layoutParams.bottomMargin = ViewUtils.dip2px(20.0f);
                layoutParams.topMargin = ViewUtils.dip2px(16.0f);
            } else {
                if (i3 <= 2) {
                    dip2px = ViewUtils.dip2px(16.0f);
                } else {
                    dip2px = ViewUtils.dip2px(22.0f);
                }
                layoutParams.bottomMargin = dip2px;
                layoutParams.topMargin = dip2px;
            }
            layoutParams.gravity = i3 != 1 ? 5 : 3;
            frameLayout.addView(this.f450281e.f(), layoutParams);
        }
    }

    private void i(Context context, f fVar) {
        if (fVar != null && context != null) {
            String str = fVar.f450277h;
            int i3 = fVar.f450270a;
            if (QLog.isColorLevel()) {
                QLog.d("FeedBannerViewHolder", 2, "parse banner jumpUrl " + str + ", type =" + i3);
            }
            if (i3 == 0) {
                c cVar = this.f450282f;
                if (cVar != null) {
                    cVar.Kg();
                    return;
                }
                return;
            }
            if (i3 == 1) {
                if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.itemView.getContext(), str, 2065, null);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not scheme ");
                        return;
                    }
                    return;
                }
            }
            if (i3 == 2) {
                if (TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.e("FeedBannerViewHolder", 2, "web jumpUrl is null ");
                        return;
                    }
                    return;
                } else {
                    Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str);
                    context.startActivity(intent);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not support ");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("FeedBannerViewHolder", 2, "jumpUrl bannerTabItem or context null ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(f fVar, int i3) {
        l(fVar, i3, "0X800A9B1");
        HashMap hashMap = new HashMap();
        if (i3 == 0) {
            hashMap.put(BusinessADBannerData.KEY_BANNER_APPID, "1");
        } else {
            hashMap.put(BusinessADBannerData.KEY_BANNER_APPID, String.valueOf(fVar.f450271b));
        }
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#" + this.f450283h + "#banner", true, -1L, -1L, hashMap, true, true);
        i(this.itemView.getContext(), fVar);
    }

    public void destroy() {
        n nVar = this.f450281e;
        if (nVar != null) {
            nVar.h();
        }
    }

    public void h(com.tencent.mobileqq.qqexpand.bean.feed.b bVar, int i3) {
        if (bVar instanceof e) {
            View view = this.itemView;
            if (view instanceof TabLayout) {
                TabLayout tabLayout = (TabLayout) view;
                tabLayout.setPadding(tabLayout.getPaddingLeft(), i3, tabLayout.getPaddingRight(), tabLayout.getPaddingBottom());
                ArrayList<f> arrayList = ((e) bVar).f450269d;
                ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
                int size = arrayList.size();
                int dip2px = ViewUtils.dip2px(size == 1 ? 122 : size == 2 ? 108 : 168);
                if (layoutParams != null) {
                    layoutParams.height = i3 + dip2px;
                }
                tabLayout.b().setMinimumHeight(dip2px);
                tabLayout.a(new a(arrayList, ViewUtils.dip2px(120.0f), ViewUtils.dip2px(4.0f)));
            }
        }
    }

    public void k(f fVar) {
        ArrayList<String> arrayList;
        String str;
        TextView textView = this.f450280d;
        if (textView != null && (str = fVar.f450273d) != null) {
            textView.setText(str);
        }
        n nVar = this.f450281e;
        if (nVar == null || (arrayList = fVar.f450279j) == null) {
            return;
        }
        nVar.i(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, f fVar, int i3, int i16) {
        float dip2px = ViewUtils.dip2px(5.0f);
        ((RoundCorneredRelativeLayout) view).setRadius(dip2px, dip2px, dip2px, dip2px);
        ImageView imageView = (ImageView) view.findViewById(R.id.ozy);
        TextView textView = (TextView) view.findViewById(R.id.p1t);
        TextView textView2 = (TextView) view.findViewById(R.id.p1q);
        if (!TextUtils.isEmpty(fVar.f450272c)) {
            textView.setText(fVar.f450272c);
        }
        if (!TextUtils.isEmpty(fVar.f450273d)) {
            textView2.setText(fVar.f450273d);
        }
        ((FeedBannerItemGradientLinearLayout) view.findViewById(R.id.ozr)).b(ViewUtils.dip2px(i16 == 1 ? 24 : i16 == 2 ? 22 : 40), fVar.f450275f, fVar.f450276g);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ozz);
        if (this.f450284i && fVar.f450270a == 0) {
            imageView.setVisibility(8);
            this.f450280d = textView2;
            Drawable drawable = view.getContext().getResources().getDrawable(R.drawable.geu);
            drawable.setBounds(ViewUtils.dip2px(1.0f), 0, ViewUtils.dip2px(7.0f), ViewUtils.dip2px(6.0f));
            textView2.setCompoundDrawablePadding(ViewUtils.dip2px(3.0f));
            textView2.setCompoundDrawables(drawable, null, null, null);
            if (i16 == 2) {
                ((ViewGroup.MarginLayoutParams) textView2.getLayoutParams()).rightMargin = ViewUtils.dip2px(80.0f);
            } else if (i16 == 1) {
                textView.setTextSize(25.0f);
                textView2.setTextSize(12.0f);
                textView2.setPadding(0, ViewUtils.dip2px(2.0f), 0, 0);
                view.findViewById(R.id.oyf).setVisibility(0);
            }
            f(frameLayout, i16);
            k(fVar);
        } else if (fVar.f450274e != null) {
            try {
                ColorDrawable colorDrawable = new ColorDrawable(0);
                ColorDrawable colorDrawable2 = new ColorDrawable(0);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = colorDrawable;
                obtain.mFailedDrawable = colorDrawable2;
                obtain.mUseApngImage = true;
                obtain.mMemoryCacheKeySuffix = "useAPNG";
                imageView.setImageDrawable(URLDrawable.getDrawable(new URL(fVar.f450274e), obtain));
            } catch (MalformedURLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FeedBannerViewHolder", 2, "setImageUrl error " + e16.toString());
                }
            }
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.oyv);
        Drawable createFromPath = Drawable.createFromPath(com.tencent.mobileqq.qqexpand.utils.c.a(i16));
        if (createFromPath != null) {
            imageView2.setImageDrawable(createFromPath);
        }
        view.setOnTouchListener(new b(view.findViewById(R.id.p0u), frameLayout, textView, textView2, fVar, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(f fVar, int i3, String str) {
        if (fVar == null || fVar.f450270a == 0) {
            return;
        }
        String str2 = fVar.f450272c;
        String str3 = i3 + "";
        ReportController.o(null, "dc00898", "", "", "qq_kuolie", str, 0, 0, str3, "", fVar.f450271b + ";" + str2, fVar.f450273d);
    }
}
