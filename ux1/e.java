package ux1;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import yx1.RoleSelectItem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends com.tencent.mobileqq.guild.base.recyclerview.adapter.e<RoleSelectItem, BaseViewHolder> {
    private a V;
    private IGProChannelInfo W;
    private int X;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void Yf(View view);

        void m9(RoleSelectItem roleSelectItem, int i3, boolean z16, View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b extends BaseViewHolder {
        TextView E;
        TextView F;
        CheckBox G;
        ImageView H;
        TextView I;

        public b(View view, int i3) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.title);
            this.F = (TextView) view.findViewById(R.id.w26);
            this.G = (CheckBox) view.findViewById(R.id.ax9);
            this.H = (ImageView) view.findViewById(R.id.xdq);
            this.I = (TextView) view.findViewById(R.id.xda);
            if (i3 == 7) {
                view.setBackground(BaseApplication.getContext().getResources().getDrawable(R.drawable.qui_common_bg_bottom_light_bg));
                this.E.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.qui_common_text_primary));
                this.F.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.qui_common_text_secondary));
            }
        }
    }

    public e(a aVar, IGProChannelInfo iGProChannelInfo, int i3) {
        super(R.layout.ewb);
        this.V = aVar;
        this.W = iGProChannelInfo;
        this.X = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(RoleSelectItem roleSelectItem, b bVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (roleSelectItem.getIsEnable()) {
            this.V.m9(roleSelectItem, bVar.getAdapterPosition(), !roleSelectItem.getIsSelect(), bVar.itemView);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e
    protected BaseViewHolder L0(ViewGroup viewGroup, int i3) {
        View x06 = x0(viewGroup, R.layout.ewb);
        try {
            a aVar = this.V;
            if (aVar != null) {
                aVar.Yf(x06);
            }
        } catch (Exception e16) {
            QLog.i("GuildRoleGroupSelectDialogAdapter", 1, "callback exception: " + e16.getMessage());
        }
        return new b(x06, this.X);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public void m0(BaseViewHolder baseViewHolder, final RoleSelectItem roleSelectItem) {
        final b bVar = (b) baseViewHolder;
        bVar.E.setText(roleSelectItem.getRole().getName());
        bVar.G.setChecked(roleSelectItem.getIsSelect());
        bVar.G.setEnabled(roleSelectItem.getIsEnable());
        dy1.a aVar = dy1.a.f395200a;
        aVar.d(roleSelectItem.getRole().getColor(), roleSelectItem.getRole().getRoleType(), aVar.b(roleSelectItem.getRole().getLvRole()), bVar.H, bVar.I, bVar.itemView.getContext());
        if (roleSelectItem.getRole().u()) {
            IGProChannelInfo iGProChannelInfo = this.W;
            if (iGProChannelInfo != null && !TextUtils.isEmpty(iGProChannelInfo.getChannelName())) {
                bVar.F.setVisibility(0);
                bVar.F.setText(String.format("#%s", this.W.getChannelName()));
            } else if (this.X == 4) {
                bVar.F.setVisibility(0);
                bVar.F.setText(R.string.f156981lo);
            } else {
                bVar.F.setVisibility(8);
            }
        } else if (roleSelectItem.getRole().t()) {
            IGProChannelInfo iGProChannelInfo2 = this.W;
            if (iGProChannelInfo2 != null && !TextUtils.isEmpty(iGProChannelInfo2.getCategoryName())) {
                bVar.F.setVisibility(0);
                bVar.F.setText(this.W.getCategoryName());
            } else {
                IGProChannelInfo iGProChannelInfo3 = this.W;
                if (iGProChannelInfo3 != null && (iGProChannelInfo3.getCategoryId() == 0 || TextUtils.isEmpty(this.W.getCategoryName()))) {
                    bVar.F.setVisibility(0);
                    bVar.F.setText(R.string.f141780hl);
                } else if (this.X == 4) {
                    bVar.F.setVisibility(0);
                    bVar.F.setText(R.string.f156971ln);
                } else {
                    bVar.F.setVisibility(8);
                }
            }
        } else {
            bVar.F.setVisibility(8);
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ux1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.W0(roleSelectItem, bVar, view);
            }
        });
    }
}
