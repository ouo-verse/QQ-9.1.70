package xx1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import xx1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f448976d;

    /* renamed from: e, reason: collision with root package name */
    public GuildUserAvatarView f448977e;

    /* renamed from: f, reason: collision with root package name */
    private final b f448978f;

    /* renamed from: h, reason: collision with root package name */
    private b.C11573b f448979h;

    public d(b bVar) {
        this.f448978f = bVar;
    }

    public void a(String str, b.C11573b c11573b) {
        this.f448979h = c11573b;
        this.f448976d.setText(c11573b.f448974c);
        this.f448977e.setTag(c11573b);
        this.f448977e.setAvatarTinyId(str, c11573b.f448973b);
    }

    public View b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f6m, (ViewGroup) null);
        inflate.setTag(this);
        inflate.findViewById(R.id.els).setOnClickListener(this);
        this.f448976d = (TextView) inflate.findViewById(R.id.xw7);
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) inflate.findViewById(R.id.xsl);
        this.f448977e = guildUserAvatarView;
        guildUserAvatarView.setLogTag("Guild.rg.GuildRoleGroupSearchItemViewHolder");
        return inflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f448978f.i(new String[]{this.f448979h.f448973b}, true);
        EventCollector.getInstance().onViewClicked(view);
    }
}
