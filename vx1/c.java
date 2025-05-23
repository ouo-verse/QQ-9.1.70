package vx1;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vx1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final a.InterfaceC11444a E;
    private final ImageView F;
    private final RelativeLayout G;
    private final TextView H;
    private final TextView I;
    private final View J;
    private final boolean K;
    private final View L;
    private int M;

    public c(@NonNull View view, boolean z16, a.InterfaceC11444a interfaceC11444a) {
        super(view);
        this.K = z16;
        this.E = interfaceC11444a;
        this.F = (ImageView) view.findViewById(R.id.icon);
        this.G = (RelativeLayout) view.findViewById(R.id.xd9);
        this.H = (TextView) view.findViewById(R.id.ato);
        this.I = (TextView) view.findViewById(R.id.se_);
        this.J = view.findViewById(R.id.aco);
        this.L = view.findViewById(R.id.bww);
        view.setOnClickListener(this);
    }

    public static int m() {
        return R.layout.f67;
    }

    public void l(int i3, by1.c cVar) {
        this.itemView.setTag(cVar.c());
        this.H.setText(cVar.d());
        this.I.setText(cVar.b() + "\u4eba");
        RelativeLayout relativeLayout = this.G;
        relativeLayout.setBackground(ResourcesCompat.getDrawable(relativeLayout.getResources(), R.drawable.guild_channel_item_icon_bg_skin, null));
        this.M = cVar.e();
        int i16 = 8;
        if (cVar.e() == 7) {
            this.G.setVisibility(8);
            this.L.setVisibility(0);
        } else {
            this.G.setVisibility(0);
            this.L.setVisibility(8);
        }
        GuildChannelIconUtil.o(this.F, cVar.e());
        View view = this.J;
        if (cVar.f29377a) {
            i16 = 0;
        }
        view.setVisibility(i16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && (view.getTag() instanceof String)) {
            this.E.g6((String) view.getTag(), this.H.getText().toString(), this.M);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
