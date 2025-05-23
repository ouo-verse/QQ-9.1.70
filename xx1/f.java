package xx1;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private final c E;
    private RoleGroupUserUIData F;
    private View G;
    private CheckBox H;
    public GuildUserAvatarView I;
    private TextView J;
    private ImageView K;
    private GuildClientIdentityView L;

    public f(View view, c cVar) {
        super(view);
        this.E = cVar;
        p(view);
    }

    private void o() {
        CheckBox checkBox = this.H;
        if (checkBox != null && checkBox.isShown() && this.H.isEnabled()) {
            this.H.setChecked(!r0.isChecked());
        }
    }

    private void p(View view) {
        View findViewById = view.findViewById(R.id.dq8);
        this.G = findViewById;
        findViewById.setOnClickListener(this);
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) view.findViewById(R.id.xsl);
        this.I = guildUserAvatarView;
        guildUserAvatarView.setLogTag("Guild.rg.GuildRoleGroupUserItemViewHolder");
        this.J = (TextView) view.findViewById(R.id.xw7);
        this.H = (CheckBox) view.findViewById(R.id.f82074fw);
        this.K = (ImageView) view.findViewById(R.id.bfq);
        int i3 = this.E.f448975m;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2 && i3 != 5) {
                if (i3 != 3 && i3 != 6 && i3 != 8) {
                    if (i3 == 7) {
                        this.H.setVisibility(8);
                        this.K.setVisibility(8);
                    }
                } else {
                    this.H.setVisibility(8);
                    this.K.setVisibility(8);
                }
            } else {
                this.H.setVisibility(8);
                this.K.setVisibility(0);
                this.K.setOnClickListener(this);
            }
        } else {
            this.H.setVisibility(0);
            this.K.setVisibility(8);
        }
        GuildClientIdentityView guildClientIdentityView = (GuildClientIdentityView) view.findViewById(R.id.xvg);
        this.L = guildClientIdentityView;
        guildClientIdentityView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.G.setSelected(false);
    }

    private void r(RoleGroupUserUIData roleGroupUserUIData, boolean z16) {
        this.H.setVisibility(0);
        this.H.setEnabled(true);
        this.H.setTag(roleGroupUserUIData);
        this.H.setOnCheckedChangeListener(this);
        this.H.setChecked(z16);
    }

    public void m(String str, RoleGroupUserUIData roleGroupUserUIData, boolean z16, @NonNull List<Object> list) {
        int i3;
        if (list.contains(1) && TextUtils.equals(this.F.getMTinyId(), roleGroupUserUIData.getMTinyId()) && ((i3 = this.E.f448975m) == 0 || i3 == 1)) {
            this.H.setChecked(z16);
            return;
        }
        this.F = roleGroupUserUIData;
        int i16 = this.E.f448975m;
        if (i16 != 0 && i16 != 1) {
            if (i16 != 2 && i16 != 5) {
                if (i16 != 3 && i16 != 8) {
                    if (i16 == 7) {
                        this.H.setVisibility(8);
                        this.K.setVisibility(8);
                    }
                } else {
                    this.H.setVisibility(8);
                    this.K.setVisibility(8);
                    this.G.setSelected(false);
                    this.G.setBackgroundResource(R.drawable.guild_drawable_ffffff_1d1d20);
                }
            } else {
                this.K.setVisibility(0);
                this.G.setSelected(false);
                this.G.setBackgroundResource(R.drawable.guild_drawable_ffffff_1d1d20);
            }
        } else {
            r(roleGroupUserUIData, z16);
        }
        this.I.setTag(roleGroupUserUIData);
        this.I.setAvatarTinyId(str, roleGroupUserUIData.getMTinyId());
        this.J.setText(roleGroupUserUIData.getMName());
        this.L.a(roleGroupUserUIData.getUserIdentity());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (!this.E.l0(compoundButton, z16)) {
            compoundButton.setChecked(false);
            compoundButton.setOnCheckedChangeListener(this);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        int i3 = this.E.f448975m;
        if (i3 != 0 && i3 != 1) {
            if ((i3 == 2 || i3 == 5) && id5 == R.id.bfq) {
                if (!QQGuildUIUtil.v()) {
                    this.G.setBackgroundResource(R.drawable.guild_setting_common_bg_selector);
                    this.G.setSelected(true);
                    new Handler().postDelayed(new Runnable() { // from class: xx1.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.this.q();
                        }
                    }, 200L);
                    this.E.m0(this.F);
                }
            } else if (i3 == 7 && !QQGuildUIUtil.v()) {
                this.E.n0(this.F);
            }
        } else {
            o();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
