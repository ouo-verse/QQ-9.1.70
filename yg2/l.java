package yg2;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.qqexpand.widget.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.vip.tianshu.TianShuManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes36.dex */
public class l extends RecyclerView.ViewHolder {

    /* renamed from: d, reason: collision with root package name */
    private final Activity f450305d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewGroup f450306e;

    /* renamed from: f, reason: collision with root package name */
    private final ViewGroup f450307f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f450308h;

    /* renamed from: i, reason: collision with root package name */
    private final RecyclerView f450309i;

    /* renamed from: m, reason: collision with root package name */
    private final b f450310m;

    public l(View view, Activity activity) {
        super(view);
        this.f450305d = activity;
        this.f450306e = (ViewGroup) view.findViewById(R.id.root);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.content);
        this.f450307f = viewGroup;
        this.f450308h = (TextView) view.findViewById(R.id.m_w);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.lsy);
        this.f450309i = recyclerView;
        int f16 = BaseAIOUtils.f(4.0f, activity.getResources());
        int i3 = f16 * 3;
        viewGroup.setBackgroundDrawable(new com.tencent.mobileqq.structmsg.f(-1, i3, i3, f16));
        recyclerView.setItemAnimator(null);
        b bVar = new b();
        this.f450310m = bVar;
        recyclerView.setAdapter(bVar);
        o oVar = new o(activity, 0, false);
        oVar.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(oVar);
    }

    public static void d(int i3, int i16, int i17) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            str = "";
        } else {
            str = runtime.getAccount();
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.78";
        tianShuReportData.mPageId = "tianshu.78";
        tianShuReportData.mItemId = Integer.toString(i17);
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mPositionId = Integer.toString(i16);
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b extends RecyclerView.Adapter<a> {

        /* renamed from: d, reason: collision with root package name */
        private final List<MiniAppRecommInfo.MiniApp> f450316d = new ArrayList();

        public b() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f450316d.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, int i3) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo;
            MiniAppRecommInfo.MiniApp miniApp = this.f450316d.get(i3);
            aVar.b(miniApp);
            aVar.c(i3);
            if (miniApp == null || (iNTERFACE$StApiAppInfo = miniApp.f263472i) == null) {
                return;
            }
            SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(iNTERFACE$StApiAppInfo));
            simpleMiniAppConfig.launchParam.scene = 2065;
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniAppExposureData(simpleMiniAppConfig, i3);
            l.d(101, i3, miniApp.f263473m);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new a(l.this.f450305d, LayoutInflater.from(l.this.f450305d).inflate(R.layout.c9m, (ViewGroup) null, false));
        }

        public void setData(List<MiniAppRecommInfo.MiniApp> list) {
            if (list != null) {
                this.f450316d.clear();
                this.f450316d.addAll(list);
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        MiniAppRecommInfo.MiniApp f450311d;

        /* renamed from: e, reason: collision with root package name */
        int f450312e;

        /* renamed from: f, reason: collision with root package name */
        ImageView f450313f;

        /* renamed from: h, reason: collision with root package name */
        TextView f450314h;

        /* renamed from: i, reason: collision with root package name */
        private final WeakReference<Activity> f450315i;

        public a(Activity activity, View view) {
            super(view);
            this.f450315i = new WeakReference<>(activity);
            ImageView imageView = (ImageView) view.findViewById(R.id.exe);
            this.f450313f = imageView;
            if (imageView instanceof ThemeImageView) {
                ((ThemeImageView) imageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
            }
            this.f450314h = (TextView) view.findViewById(R.id.exf);
            this.f450313f.setOnClickListener(this);
            this.f450314h.setOnClickListener(this);
        }

        public void c(int i3) {
            this.f450312e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo;
            MiniAppRecommInfo.MiniApp miniApp = this.f450311d;
            if (miniApp == null || (iNTERFACE$StApiAppInfo = miniApp.f263472i) == null) {
                return;
            }
            SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(iNTERFACE$StApiAppInfo));
            simpleMiniAppConfig.launchParam.scene = 2065;
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startApp(this.f450315i.get(), simpleMiniAppConfig, null);
            l.d(102, this.f450312e, this.f450311d.f263473m);
        }

        public void b(MiniAppRecommInfo.MiniApp miniApp) {
            if (miniApp == null) {
                return;
            }
            this.f450311d = miniApp;
            this.f450313f.setImageDrawable(((IMiniAppService) QRoute.api(IMiniAppService.class)).getIcon(this.f450313f.getContext(), miniApp.f263470f, true, R.drawable.f161062ch3, 48));
            this.f450314h.setText(miniApp.f263469e);
        }
    }

    public void c(MiniAppRecommInfo miniAppRecommInfo, int i3) {
        if (miniAppRecommInfo == null) {
            return;
        }
        ViewGroup viewGroup = this.f450306e;
        viewGroup.setPadding(viewGroup.getPaddingLeft(), i3, this.f450306e.getPaddingRight(), this.f450306e.getPaddingBottom());
        this.f450308h.setText(miniAppRecommInfo.headDesc);
        this.f450310m.setData(miniAppRecommInfo.appInfoList);
    }
}
