package sv1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.guild.client.selectclient.GuildSelectClientDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends a<rv1.a> {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f434828e;

    public c(boolean z16) {
        this.f434828e = z16;
    }

    private void y(View view) {
        VideoReport.setElementId(view, "em_sgrp_add_otherapp");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", "0");
            bundle.putBoolean("is_owner", this.f434828e);
            GuildSelectClientDialogFragment.vh((QBaseActivity) view.getContext(), bundle);
            VideoReport.reportEvent("clck", view, new HashMap());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    public int i() {
        return 2;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    public int j() {
        return R.layout.eva;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    @NonNull
    public BaseViewHolder o(@NonNull ViewGroup viewGroup, int i3) {
        BaseViewHolder baseViewHolder = new BaseViewHolder(h(viewGroup, j()));
        ViewGroup viewGroup2 = (ViewGroup) baseViewHolder.getView(R.id.scs);
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: sv1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.z(view);
            }
        });
        y(viewGroup2);
        return baseViewHolder;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder baseViewHolder, rv1.a aVar) {
    }
}
