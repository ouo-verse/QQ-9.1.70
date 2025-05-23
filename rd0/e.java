package rd0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final List<rd0.f> f431060d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ListView f431061e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f431062f = true;

    /* renamed from: h, reason: collision with root package name */
    private f f431063h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f431064d;

        a(g gVar) {
            this.f431064d = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.j();
            e.this.s(this.f431064d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rd0.f f431066d;

        b(rd0.f fVar) {
            this.f431066d = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (e.this.f431063h != null) {
                e.this.f431063h.W(this.f431066d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f431068d;

        c(g gVar) {
            this.f431068d = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.j();
            e.this.s(this.f431068d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f431070d;

        d(g gVar) {
            this.f431070d = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.i(this.f431070d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: rd0.e$e, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class ViewOnClickListenerC11128e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f431072d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rd0.f f431073e;

        ViewOnClickListenerC11128e(g gVar, rd0.f fVar) {
            this.f431072d = gVar;
            this.f431073e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (e.this.f431063h != null) {
                e.this.f431063h.Z1(this.f431072d.f431095u, this.f431073e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface f {
        void I1(rd0.f fVar);

        void K(rd0.f fVar);

        void V0(rd0.f fVar);

        void W(rd0.f fVar);

        void Z1(CheckBox checkBox, rd0.f fVar);

        void i(rd0.f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f431075a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f431076b;

        /* renamed from: c, reason: collision with root package name */
        TextView f431077c;

        /* renamed from: d, reason: collision with root package name */
        TextView f431078d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f431079e;

        /* renamed from: f, reason: collision with root package name */
        LinearLayout f431080f;

        /* renamed from: g, reason: collision with root package name */
        LinearLayout f431081g;

        /* renamed from: h, reason: collision with root package name */
        ImageView f431082h;

        /* renamed from: i, reason: collision with root package name */
        TextView f431083i;

        /* renamed from: j, reason: collision with root package name */
        TextView f431084j;

        /* renamed from: k, reason: collision with root package name */
        LinearLayout f431085k;

        /* renamed from: l, reason: collision with root package name */
        LinearLayout f431086l;

        /* renamed from: m, reason: collision with root package name */
        ImageView f431087m;

        /* renamed from: n, reason: collision with root package name */
        ImageView f431088n;

        /* renamed from: o, reason: collision with root package name */
        LinearLayout f431089o;

        /* renamed from: p, reason: collision with root package name */
        ImageView f431090p;

        /* renamed from: q, reason: collision with root package name */
        LinearLayout f431091q;

        /* renamed from: r, reason: collision with root package name */
        ImageView f431092r;

        /* renamed from: s, reason: collision with root package name */
        ImageView f431093s;

        /* renamed from: t, reason: collision with root package name */
        LinearLayout f431094t;

        /* renamed from: u, reason: collision with root package name */
        QUICheckBox f431095u;

        public g(View view) {
            this.f431075a = (RelativeLayout) view.findViewById(R.id.vc9);
            this.f431076b = (ImageView) view.findViewById(R.id.lfm);
            this.f431077c = (TextView) view.findViewById(R.id.eli);
            this.f431078d = (TextView) view.findViewById(R.id.f164978uh4);
            this.f431079e = (ImageView) view.findViewById(R.id.f911654f);
            this.f431080f = (LinearLayout) view.findViewById(R.id.f114046s_);
            this.f431081g = (LinearLayout) view.findViewById(R.id.f114056sa);
            this.f431082h = (ImageView) view.findViewById(R.id.f114036s9);
            this.f431083i = (TextView) view.findViewById(R.id.f114066sb);
            this.f431084j = (TextView) view.findViewById(R.id.f114026s8);
            this.f431093s = (ImageView) view.findViewById(R.id.f114076sc);
            this.f431085k = (LinearLayout) view.findViewById(R.id.c_w);
            this.f431086l = (LinearLayout) view.findViewById(R.id.uyj);
            this.f431089o = (LinearLayout) view.findViewById(R.id.yut);
            this.f431091q = (LinearLayout) view.findViewById(R.id.yto);
            this.f431094t = (LinearLayout) view.findViewById(R.id.szs);
            this.f431095u = (QUICheckBox) view.findViewById(R.id.szr);
            this.f431088n = (ImageView) view.findViewById(R.id.v58);
            this.f431087m = (ImageView) view.findViewById(R.id.uyi);
            this.f431090p = (ImageView) view.findViewById(R.id.yus);
            this.f431092r = (ImageView) view.findViewById(R.id.ytn);
            ImageView imageView = this.f431088n;
            if (imageView != null) {
                imageView.setBackground(a(view.getContext()));
            }
            ImageView imageView2 = this.f431087m;
            if (imageView2 != null) {
                imageView2.setBackground(a(view.getContext()));
            }
            ImageView imageView3 = this.f431090p;
            if (imageView3 != null) {
                imageView3.setBackground(a(view.getContext()));
            }
        }

        private Drawable a(Context context) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_standard_primary));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_light));
            gradientDrawable2.setStroke(ViewUtils.dpToPx(1.0f), ContextCompat.getColorStateList(context, R.color.qui_common_border_standard));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }

        private Drawable b(Context context, Boolean bool) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            if (bool.booleanValue()) {
                gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_brand_standard));
            } else {
                gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_standard_primary));
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_light));
            gradientDrawable2.setStroke(ViewUtils.dpToPx(1.0f), ContextCompat.getColorStateList(context, R.color.qui_common_border_standard));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }

        public void c(View view, Boolean bool) {
            if (this.f431092r != null) {
                TextView textView = (TextView) view.findViewById(R.id.ytp);
                if (bool.booleanValue()) {
                    this.f431092r.setImageResource(R.drawable.jkr);
                    textView.setText(R.string.f216915zl);
                    this.f431091q.setContentDescription(view.getContext().getString(R.string.f216915zl));
                } else {
                    this.f431092r.setImageResource(R.drawable.qui_lock_off);
                    textView.setText(R.string.f216925zm);
                    this.f431091q.setContentDescription(view.getContext().getString(R.string.f216925zm));
                }
                this.f431092r.setBackground(b(view.getContext(), bool));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(@NotNull g gVar) {
        RelativeLayout relativeLayout = gVar.f431075a;
        if (relativeLayout != null && gVar.f431080f != null) {
            relativeLayout.setVisibility(0);
            gVar.f431079e.setVisibility(0);
            gVar.f431080f.setVisibility(8);
            gVar.f431093s.setVisibility(8);
            return;
        }
        com.tencent.xaction.log.b.a("LoginDevInfoAdapter", 1, "has not this layout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ListView listView = this.f431061e;
        if (listView != null) {
            int childCount = listView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f431061e.getChildAt(i3);
                g gVar = (g) childAt.getTag();
                if (gVar == null) {
                    gVar = new g(childAt);
                }
                i(gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(rd0.f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        f fVar2 = this.f431063h;
        if (fVar2 != null) {
            fVar2.I1(fVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(rd0.f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        f fVar2 = this.f431063h;
        if (fVar2 != null) {
            fVar2.V0(fVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(rd0.f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        f fVar2 = this.f431063h;
        if (fVar2 != null) {
            fVar2.i(fVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_login_device");
        hashMap.put("dt_eid", "em_bas_export_phone_album");
        VideoReport.reportEvent("clck", hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(rd0.f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        f fVar2 = this.f431063h;
        if (fVar2 != null) {
            fVar2.K(fVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(@NotNull g gVar) {
        RelativeLayout relativeLayout = gVar.f431075a;
        if (relativeLayout != null && gVar.f431080f != null) {
            relativeLayout.setVisibility(8);
            gVar.f431079e.setVisibility(8);
            gVar.f431080f.setVisibility(0);
            gVar.f431093s.setVisibility(0);
            return;
        }
        com.tencent.xaction.log.b.a("LoginDevInfoAdapter", 1, "has not this layout");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f431060d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (i3 < this.f431060d.size()) {
            return this.f431060d.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        g gVar;
        View view2;
        final rd0.f fVar = (rd0.f) getItem(i3);
        if (fVar == null) {
            view2 = view;
        } else {
            if (view == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c_t, (ViewGroup) null);
                gVar = new g(view2);
                view2.setTag(gVar);
            } else {
                gVar = (g) view.getTag();
                view2 = view;
            }
            gVar.f431075a.setOnClickListener(new a(gVar));
            gVar.f431081g.setOnClickListener(new b(fVar));
            gVar.f431089o.setOnClickListener(new View.OnClickListener() { // from class: rd0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    e.this.l(fVar, view3);
                }
            });
            gVar.f431085k.setOnClickListener(new View.OnClickListener() { // from class: rd0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    e.this.m(fVar, view3);
                }
            });
            gVar.f431086l.setOnClickListener(new View.OnClickListener() { // from class: rd0.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    e.this.n(fVar, view3);
                }
            });
            gVar.f431091q.setOnClickListener(new View.OnClickListener() { // from class: rd0.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    e.this.o(fVar, view3);
                }
            });
            gVar.f431079e.setOnClickListener(new c(gVar));
            gVar.f431093s.setOnClickListener(new d(gVar));
            gVar.f431094t.setOnClickListener(new ViewOnClickListenerC11128e(gVar, fVar));
            String a16 = fVar.a(view2.getContext());
            gVar.f431077c.setText(a16);
            gVar.f431083i.setText(a16);
            if (TextUtils.isEmpty(fVar.f431104i)) {
                gVar.f431078d.setVisibility(8);
                gVar.f431084j.setVisibility(8);
            } else {
                gVar.f431078d.setVisibility(0);
                gVar.f431084j.setVisibility(0);
                gVar.f431078d.setText(fVar.f431104i);
                gVar.f431084j.setText(fVar.f431104i);
            }
            i iVar = fVar.f431105j;
            if (iVar != null && !iVar.b() && fVar.f431105j.f431118f) {
                if (gVar.f431094t.getVisibility() != 0) {
                    gVar.f431094t.setVisibility(0);
                    ReportController.o(null, "dc00898", "", "", "0X800C453", "0X800C453", fVar.f431099d, 0, "", "", "", "");
                }
                gVar.f431095u.setChecked(fVar.f431105j.f431117e);
            } else {
                gVar.f431094t.setVisibility(8);
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(view2.getContext().getResources().getColorStateList(R.color.qui_common_feedback_normal, null));
            gradientDrawable.setShape(1);
            gVar.f431076b.setBackground(gradientDrawable);
            int i16 = fVar.f431098c;
            if (i16 == 1) {
                if (fVar.f431103h == 1029) {
                    gVar.f431082h.setImageResource(R.drawable.qui_equipment_mac);
                } else {
                    gVar.f431082h.setImageResource(R.drawable.qui_equipment_windows);
                }
                gVar.f431076b.setImageDrawable(ie0.a.f().o(view2.getContext(), R.drawable.qui_computer_pc, R.color.qui_common_icon_allwhite_primary, 1000));
                gVar.f431085k.setVisibility(0);
                if (PadUtil.a(view2.getContext()) != DeviceType.TABLET) {
                    if (gVar.f431086l.getTag() == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("dt_pgid", "pg_bas_login_device");
                        hashMap.put("dt_eid", "em_bas_export_phone_album");
                        VideoReport.reportEvent("imp", hashMap);
                        gVar.f431086l.setTag(Boolean.TRUE);
                    }
                    gVar.f431086l.setVisibility(0);
                    MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(view2.getContext(), "common_mmkv_configurations");
                    String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
                    if (!fromV2.getBoolean(currentUin + "_wifi_photo_banner_bubble", false)) {
                        com.tencent.mobileqq.widget.tip.a.r(view2.getContext()).S(gVar.f431086l).k0(0).R(0).o0("\u65e0\u9700\u6570\u636e\u7ebf\u6279\u91cf\u5bfc\u51fa").p0(view2.getContext().getColor(R.color.qui_button_text_primary)).W(view2.getContext().getColor(R.color.qui_common_bg_top_dark)).j0(10.0f, 8.0f, 10.0f, 8.0f).e0(true).T(view2.getContext().getDrawable(R.drawable.m96)).b0(5000L).s0();
                        fromV2.putBoolean(currentUin + "_wifi_photo_banner_bubble", true);
                        fromV2.apply();
                    }
                }
                if (fVar.f431106k != 0) {
                    gVar.f431091q.setVisibility(0);
                    gVar.c(view2, Boolean.valueOf(fVar.f431106k == 2));
                }
            } else if (i16 == 2) {
                gVar.f431076b.setImageDrawable(ie0.a.f().o(view2.getContext(), R.drawable.qui_pad, R.color.qui_common_icon_allwhite_primary, 1000));
                gVar.f431082h.setImageResource(R.drawable.qui_equipment_ipad);
                gVar.f431085k.setVisibility(0);
            } else if (i16 == 7) {
                gVar.f431076b.setImageDrawable(ie0.a.f().o(view2.getContext(), R.drawable.qui_phone, R.color.qui_common_icon_allwhite_primary, 1000));
                gVar.f431082h.setImageResource(R.drawable.qui_equipment_ipad);
                gVar.f431085k.setVisibility(0);
            } else if (i16 == 3) {
                gVar.f431076b.setImageDrawable(ie0.a.f().o(view2.getContext(), R.drawable.qui_watch, R.color.qui_common_icon_allwhite_primary, 1000));
                gVar.f431082h.setImageResource(R.drawable.qui_equipment_watch);
                gVar.f431085k.setVisibility(8);
            }
            if (this.f431062f && i3 == 0) {
                s(gVar);
                this.f431062f = false;
            }
            if (getCount() == 1) {
                gVar.f431080f.setLayoutParams(gVar.f431080f.getLayoutParams());
                if (gVar.f431094t.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f431094t.getLayoutParams();
                    layoutParams.topMargin = ViewUtils.dpToPx(20.0f);
                    gVar.f431094t.setLayoutParams(layoutParams);
                }
                gVar.f431093s.setVisibility(8);
            } else {
                gVar.f431080f.setLayoutParams(gVar.f431080f.getLayoutParams());
                if (gVar.f431094t.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f431094t.getLayoutParams();
                    layoutParams2.topMargin = ViewUtils.dpToPx(9.0f);
                    gVar.f431094t.setLayoutParams(layoutParams2);
                }
            }
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }

    public List<rd0.f> k() {
        return this.f431060d;
    }

    public void p(List<rd0.f> list) {
        this.f431060d.clear();
        this.f431060d.addAll(list);
        notifyDataSetChanged();
    }

    public void q(f fVar) {
        this.f431063h = fVar;
    }

    public void r(ListView listView) {
        this.f431061e = listView;
    }
}
