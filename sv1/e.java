package sv1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.manage.GuildClientManageFragment;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.qqguildsdk.data.de;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends sv1.a<rv1.a> {

    /* renamed from: e, reason: collision with root package name */
    private boolean f434831e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends BaseViewHolder {
        public LinearLayout E;
        public ImageView F;
        public TextView G;
        public ImageView H;
        public RadiusFrameLayout I;
        public Object J;

        public a(View view) {
            super(view);
            this.E = (LinearLayout) getView(R.id.wof);
            this.F = (ImageView) getView(R.id.wkb);
            this.G = (TextView) getView(R.id.x37);
            this.H = (ImageView) getView(R.id.f165448w21);
            this.I = (RadiusFrameLayout) getView(R.id.wfz);
            this.J = null;
        }
    }

    public e(boolean z16) {
        this.f434831e = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(rv1.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B(view, aVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void B(View view, @Nullable rv1.a aVar) {
        if (!QQGuildUIUtil.v() && aVar != null) {
            GuildClientManageFragment.Nh(view.getContext(), new GuildClientParams().l(String.valueOf(aVar.b())).m(aVar.d()).k(aVar.c()).j(new ArrayList()).e0("0"), 1);
        }
    }

    private void y(@NonNull a aVar, rv1.a aVar2) {
        de a16 = aVar2.a();
        if (aVar2.b() > 0 && a16 != null) {
            String app = a16.getApp();
            String view = a16.getView();
            String b16 = a16.b();
            String desc = a16.getDesc();
            String a17 = a16.a();
            String config = a16.getConfig();
            RadiusFrameLayout radiusFrameLayout = aVar.I;
            ViewGroup viewGroup = (ViewGroup) radiusFrameLayout.findViewById(R.id.f165542wk2);
            t02.a aVar3 = new t02.a(app, view, desc, b16, a17, config);
            aVar3.h(ScreenUtil.dip2px(32.0f));
            IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
            Object initArkViewContainer = iGuildFeatureAdapterApi.initArkViewContainer();
            aVar.J = initArkViewContainer;
            if (viewGroup == null) {
                ViewGroup buildArkViewContentGroup = iGuildFeatureAdapterApi.buildArkViewContentGroup(g(), initArkViewContainer, aVar3, null);
                buildArkViewContentGroup.setId(R.id.f165542wk2);
                radiusFrameLayout.addView(buildArkViewContentGroup);
                return;
            } else {
                iGuildFeatureAdapterApi.buildArkViewContentGroup(g(), initArkViewContainer, aVar3, viewGroup);
                viewGroup.setVisibility(0);
                return;
            }
        }
        QLog.e("Guild.profile.GuildProfileArchivesTitleItemProvider", 1, "initArkView error");
    }

    private void z(View view, String str, rv1.a aVar) {
        VideoReport.setElementReuseIdentifier(view, String.valueOf(aVar.b()));
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_otherapp_id", Integer.valueOf(aVar.b()));
        VideoReport.setElementParams(view, hashMap);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    public int i() {
        return 1;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    public int j() {
        return R.layout.evb;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    public BaseViewHolder o(ViewGroup viewGroup, int i3) {
        a aVar = new a(h(viewGroup, j()));
        ch.Y0(aVar.I, "em_sgrp_record", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
        return aVar;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    public void t(BaseViewHolder baseViewHolder) {
        Object obj;
        super.t(baseViewHolder);
        if ((baseViewHolder instanceof a) && (obj = ((a) baseViewHolder).J) != null) {
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).destroyArkViewContainer(obj);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull BaseViewHolder baseViewHolder, @Nullable final rv1.a aVar) {
        a aVar2 = (a) baseViewHolder;
        if (c() == null) {
            QLog.e("Guild.profile.GuildProfileArchivesTitleItemProvider", 1, "adapter is null");
            return;
        }
        if (aVar != null) {
            if (aVar.e()) {
                aVar2.I.setVisibility(0);
                y(aVar2, aVar);
            } else {
                aVar2.I.setVisibility(8);
            }
            aVar2.G.setText(aVar.d());
            v.k(aVar.c(), aVar2.F, null);
            z(aVar2.E, "em_sgrp_otherapp", aVar);
        }
        if (this.f434831e) {
            aVar2.H.setVisibility(0);
            aVar2.E.setOnClickListener(new View.OnClickListener() { // from class: sv1.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.A(aVar, view);
                }
            });
        } else {
            aVar2.H.setVisibility(8);
        }
    }
}
