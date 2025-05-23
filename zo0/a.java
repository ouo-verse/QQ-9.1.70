package zo0;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.ViewGroup;
import ap0.f;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.input.at.utils.h;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static yw1.a f452868i = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f452869j = false;

    /* renamed from: a, reason: collision with root package name */
    public GuildAIOInputEditText f452870a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f452871b;

    /* renamed from: c, reason: collision with root package name */
    public Context f452872c;

    /* renamed from: d, reason: collision with root package name */
    private AIOParam f452873d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f452874e;

    /* renamed from: f, reason: collision with root package name */
    private uw1.a f452875f;

    /* renamed from: g, reason: collision with root package name */
    private TextWatcher f452876g = new C11705a();

    /* renamed from: h, reason: collision with root package name */
    private h f452877h = new b();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements h {
        b() {
        }

        @Override // com.tencent.guild.aio.input.at.utils.h
        public boolean a(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4 && a.this.f452875f != null) {
                return a.this.f452875f.a(keyEvent);
            }
            return false;
        }
    }

    private void l() {
        GuildAIOInputEditText guildAIOInputEditText = this.f452870a;
        if (guildAIOInputEditText != null) {
            guildAIOInputEditText.setKeyEventPreImeListener("GuildRobotAtHelper", this.f452877h);
            this.f452870a.removeTextChangedListener(this.f452876g);
            this.f452870a.addTextChangedListener(this.f452876g);
        }
    }

    public static void m(yw1.a aVar) {
        if (f452869j) {
            aVar.onShow();
        } else {
            f452868i = aVar;
        }
    }

    public void b(CommonBotInfo commonBotInfo) {
        AIOParam aIOParam = this.f452873d;
        if (aIOParam != null && !com.tencent.guild.aio.util.a.j(aIOParam) && !com.tencent.guild.aio.util.a.l(this.f452873d)) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildRobotTag:GuildAIORobotHelper", 1, "createRobotAtObserverFromSlash, robotInfo" + commonBotInfo);
            }
            if (commonBotInfo == null) {
                QLog.w("GuildRobotTag:GuildAIORobotHelper", 1, "robotInfo is null");
                return;
            }
            if (this.f452874e == null) {
                return;
            }
            uw1.a createGuildRobotAtManager = ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).createGuildRobotAtManager((Activity) this.f452872c, this.f452871b, this.f452873d, this.f452870a, this.f452874e);
            this.f452875f = createGuildRobotAtManager;
            if (!createGuildRobotAtManager.f() && !this.f452875f.k()) {
                n();
            }
            this.f452875f.c(commonBotInfo);
            l();
            this.f452875f.d(h34.a.e(commonBotInfo));
        }
    }

    public void c(String str) {
        d(str, true, true);
    }

    public void d(String str, boolean z16, boolean z17) {
        AIOParam aIOParam = this.f452873d;
        if (aIOParam == null || com.tencent.guild.aio.util.a.j(aIOParam) || com.tencent.guild.aio.util.a.l(this.f452873d) || TextUtils.equals(str, "0") || this.f452874e == null) {
            return;
        }
        e();
        uw1.a createGuildRobotAtManager = ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).createGuildRobotAtManager((Activity) this.f452872c, this.f452871b, this.f452873d, this.f452870a, this.f452874e);
        this.f452875f = createGuildRobotAtManager;
        if (!createGuildRobotAtManager.f() && !this.f452875f.k()) {
            n();
        }
        this.f452875f.i(str);
        if (z17) {
            this.f452875f.l(this.f452870a, "", 0, z16);
        }
        l();
    }

    public void e() {
        uw1.a aVar = this.f452875f;
        if (aVar != null) {
            aVar.g();
            this.f452875f.e();
        }
    }

    public void f(CharSequence charSequence, int i3, int i16, int i17) {
        QLog.i("GuildRobotTag:GuildAIORobotHelper", 1, "onTextChanged, inputLength" + charSequence.length());
        uw1.a aVar = this.f452875f;
        if (aVar != null && !aVar.h() && !this.f452875f.j()) {
            n();
            return;
        }
        uw1.a aVar2 = this.f452875f;
        if (aVar2 != null) {
            aVar2.b(charSequence.toString());
        }
    }

    public void g(GuildAIOInputEditText guildAIOInputEditText, ViewGroup viewGroup, Context context, AIOParam aIOParam, com.tencent.aio.api.runtime.a aVar) {
        if (aIOParam != null && !com.tencent.guild.aio.util.a.j(aIOParam) && !com.tencent.guild.aio.util.a.l(aIOParam)) {
            this.f452870a = guildAIOInputEditText;
            this.f452871b = viewGroup;
            this.f452872c = context;
            this.f452873d = aIOParam;
            this.f452874e = aVar;
            if (aIOParam.n() == hn0.a.class.getName()) {
                f.articleGuildRobotAtHelper = this;
            } else {
                f.guildRobotAtHelper = this;
            }
        }
    }

    public void i() {
        AIOParam aIOParam = this.f452873d;
        if (aIOParam != null && !com.tencent.guild.aio.util.a.j(aIOParam) && !com.tencent.guild.aio.util.a.l(this.f452873d)) {
            n();
            if (this.f452873d.n() == hn0.a.class.getName()) {
                f.articleGuildRobotAtHelper = null;
            } else if (f.guildRobotAtHelper == this) {
                f.guildRobotAtHelper = null;
            }
            this.f452870a = null;
            this.f452871b = null;
            this.f452872c = null;
            this.f452873d = null;
            this.f452874e = null;
        }
    }

    public void j() {
        d(((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).getLastAtUin(this.f452870a), false, false);
        f452869j = true;
        yw1.a aVar = f452868i;
        if (aVar != null) {
            aVar.onShow();
            f452868i = null;
        }
    }

    public void k() {
        String lastAtUin = ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).getLastAtUin(this.f452870a);
        if (!TextUtils.isEmpty(lastAtUin)) {
            c(lastAtUin);
        }
    }

    public void n() {
        GuildAIOInputEditText guildAIOInputEditText = this.f452870a;
        if (guildAIOInputEditText != null) {
            guildAIOInputEditText.setKeyEventPreImeListener("GuildRobotAtHelper", null);
        }
        uw1.a aVar = this.f452875f;
        if (aVar != null) {
            aVar.g();
            this.f452875f.e();
            this.f452875f = null;
        }
        f.isSlashListeningBlocked = false;
        f.isAtListeningBlocked = false;
        f.firstSpanEnd = -1;
    }

    public void h() {
    }

    /* compiled from: P */
    /* renamed from: zo0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C11705a implements TextWatcher {
        C11705a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (a.this.f452875f != null) {
                a.this.f(charSequence, i3, i16, i17);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
