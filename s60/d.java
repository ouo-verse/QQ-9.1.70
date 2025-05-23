package s60;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.immersive.adapter.v;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment;
import com.tencent.biz.qqcircle.immersive.part.search.tab.QFSSearchMixedTabFragment;
import com.tencent.biz.qqcircle.immersive.part.search.tab.QFSSearchTagTabFragment;
import com.tencent.biz.qqcircle.immersive.part.search.tab.QFSSearchUserTabFragment;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.immersive.views.search.QFSSearchFilterBlockContainer;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.bizparts.b {
    private QFSSearchUserTabFragment C;
    private QFSPressEffectImageView F;
    private QFSSearchFilterBlockContainer G;
    private boolean H;
    private p70.d I;

    /* renamed from: d, reason: collision with root package name */
    private QFSViewPager f433377d;

    /* renamed from: e, reason: collision with root package name */
    private v f433378e;

    /* renamed from: i, reason: collision with root package name */
    private QFSSearchMixedTabFragment f433381i;

    /* renamed from: m, reason: collision with root package name */
    private QFSSearchTagTabFragment f433382m;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<i60.c> f433379f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f433380h = new ArrayList();
    private final List<QFSBaseSearchTabFragment> D = new ArrayList();
    private boolean E = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ViewPager.SimpleOnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (i3 == 0) {
                VideoReport.traversePage(d.this.f433377d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements TabLayoutCompat.j {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public void a(TabLayoutCompat.f fVar, @Nullable TabLayoutCompat.f fVar2, int i3) {
            int d16;
            boolean z16 = true;
            if (i3 == 1) {
                d dVar = d.this;
                int d17 = fVar.d();
                if (fVar2 == null) {
                    d16 = -1;
                } else {
                    d16 = fVar2.d();
                }
                dVar.X9(d17, d16);
            }
            d dVar2 = d.this;
            if (fVar.d() != d.this.f433380h.indexOf("\u7efc\u5408")) {
                z16 = false;
            }
            dVar2.E = z16;
            d.this.L9();
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public View b(ViewGroup viewGroup, int i3) {
            i60.c cVar = new i60.c(viewGroup);
            d.this.f433379f.add(cVar);
            d.this.Y9(cVar, i3);
            return cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: s60.d$d, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C11208d implements i60.a {
        C11208d() {
        }

        @Override // i60.a
        public void a() {
            d.this.f433377d.setCurrentItem(d.this.f433380h.indexOf("\u7528\u6237"));
        }
    }

    private void J9() {
        this.f433381i.th(new C11208d());
    }

    private void K9() {
        p70.d dVar = this.I;
        if (dVar != null) {
            dVar.M1();
        }
        L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9() {
        int i3;
        this.G.c();
        QFSPressEffectImageView qFSPressEffectImageView = this.F;
        if (this.E && this.H) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qFSPressEffectImageView.setVisibility(i3);
    }

    private String M9(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE;
            }
            return QCircleDaTongConstant.PageId.PG_XSJ_USER_VERTICAL_SEARCH_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_VERTICAL_SEARCH_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public i60.c N9(int i3) {
        if (this.f433379f.size() > i3) {
            return this.f433379f.get(i3);
        }
        return null;
    }

    private void O9(@NonNull u60.b bVar) {
        if (bVar.f438467a == 0) {
            this.E = true;
            this.f433377d.setCurrentItem(this.f433380h.indexOf("\u7efc\u5408"));
        }
    }

    private void P9(View view) {
        this.F = (QFSPressEffectImageView) view.findViewById(R.id.f52752an);
        this.G = (QFSSearchFilterBlockContainer) view.findViewById(R.id.f52732al);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: s60.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.T9(view2);
            }
        });
        if (this.I == null) {
            Q9();
        }
        this.G.setFilterViewModel(this.I);
        this.G.setParentFragment(getHostFragment());
        i.k(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_RESULT_FILTER_BUTTON, null, 0);
    }

    private void Q9() {
        p70.d dVar = (p70.d) getViewModel(p70.d.class);
        this.I = dVar;
        dVar.c2(getContext());
        this.I.Q1().observe(getHostFragment(), new Observer() { // from class: s60.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.U9((List) obj);
            }
        });
        this.I.U1().observe(getHostFragment(), new Observer() { // from class: s60.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.V9((Integer) obj);
            }
        });
    }

    private void R9(View view) {
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) view.findViewById(R.id.f54302eu);
        tabLayoutCompat.setTabTextColors(-16777216, -16777216);
        tabLayoutCompat.setTabMode(1);
        tabLayoutCompat.setTabGravity(1);
        tabLayoutCompat.setSelectedTabIndicatorHeight(0);
        tabLayoutCompat.setupWithViewPager(this.f433377d);
        ViewCompat.setPaddingRelative(tabLayoutCompat, 0, 0, 0, 0);
        tabLayoutCompat.setViewPagerTabEventListener(new b());
        tabLayoutCompat.f(new c());
    }

    private void S9(View view) {
        this.f433378e = new v(getHostFragment().getChildFragmentManager());
        QFSViewPager qFSViewPager = (QFSViewPager) view.findViewById(R.id.f54342ey);
        this.f433377d = qFSViewPager;
        qFSViewPager.setAdapter(this.f433378e);
        this.f433377d.setOffscreenPageLimit(3);
        this.f433377d.addOnPageChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.G.b();
        EventCollector.getInstance().onViewClicked(this.F);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9(List list) {
        boolean z16;
        if (list != null && !list.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.H = z16;
        this.G.setData(list);
        L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V9(Integer num) {
        int i3;
        QFSPressEffectImageView qFSPressEffectImageView = this.F;
        if (qFSPressEffectImageView == null) {
            return;
        }
        ie0.a f16 = ie0.a.f();
        Context context = getContext();
        if (num.intValue() == 0) {
            i3 = R.color.qui_common_icon_secondary;
        } else {
            i3 = R.color.qui_common_icon_primary;
        }
        qFSPressEffectImageView.setImageDrawable(f16.o(context, R.drawable.qui_sift, i3, 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(int i3, int i16) {
        if (i3 <= this.f433379f.size() && i3 >= 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgstp", Integer.valueOf(i3 + 1));
            hashMap.put("dt_ref_pgid", M9(i16));
            i.h(this.f433379f.get(i3).b(), "dt_clck", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y9(i60.c cVar, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TOP_TAB_TITLE, Integer.valueOf(i3));
        i.k(cVar.b(), QCircleDaTongConstant.ElementId.EM_XSJ_TOP_TAB, hashMap, cVar.hashCode());
    }

    private void Z9(QFSSearchInfo qFSSearchInfo) {
        K9();
        for (QFSBaseSearchTabFragment qFSBaseSearchTabFragment : this.D) {
            qFSBaseSearchTabFragment.rh(qFSSearchInfo);
            if (!this.E) {
                qFSBaseSearchTabFragment.loadData();
            }
        }
    }

    private void initData() {
        this.f433380h.addAll(Arrays.asList("\u7efc\u5408", "\u8bdd\u9898", "\u7528\u6237"));
        this.f433381i = new QFSSearchMixedTabFragment();
        this.f433382m = new QFSSearchTagTabFragment();
        this.C = new QFSSearchUserTabFragment();
        this.D.add(this.f433381i);
        this.D.add(this.f433382m);
        this.D.add(this.C);
        this.f433378e.d(this.D);
        this.f433378e.e(this.f433380h);
        this.f433378e.notifyDataSetChanged();
    }

    public void W9() {
        Iterator<QFSBaseSearchTabFragment> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchMultiTabResultPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("updateData".equals(str)) {
            if (obj instanceof QFSSearchInfo) {
                Z9((QFSSearchInfo) obj);
            }
        } else if ("changePageState".equals(str) && (obj instanceof u60.b)) {
            O9((u60.b) obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        P9(view);
        S9(view);
        R9(view);
        initData();
        J9();
        Bundle arguments = getHostFragment().getArguments();
        if (arguments != null) {
            Z9((QFSSearchInfo) arguments.getParcelable("data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements TabLayoutCompat.c {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void a(TabLayoutCompat.f fVar) {
            i60.c N9;
            if (fVar != null && (N9 = d.this.N9(fVar.d())) != null) {
                N9.c(true);
            }
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void b(TabLayoutCompat.f fVar) {
            i60.c N9;
            if (fVar != null && (N9 = d.this.N9(fVar.d())) != null) {
                N9.c(false);
            }
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void c(TabLayoutCompat.f fVar) {
        }
    }
}
