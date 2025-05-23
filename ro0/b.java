package ro0;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.input.at.utils.AtUserHelper;
import com.tencent.guild.aio.input.at.utils.j;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.aio.util.n;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so0.e;
import tl.h;
import to0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b,\u0010-J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J&\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J&\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010(R\u0011\u0010+\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b%\u0010*\u00a8\u0006."}, d2 = {"Lro0/b;", "", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "before", "count", "", "c", "i", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "editText", "Landroid/view/ViewGroup;", "inputContainer", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "d", "after", "b", "g", "a", "f", "", h.F, "Lze1/b;", "Lze1/b;", "mAtPanel", "Lmo0/a;", "Lmo0/a;", "mAtPanelCallback", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "mEditText", "Landroid/view/ViewGroup;", "mInputContainer", "e", "Landroid/content/Context;", "mContext", "Lcom/tencent/aio/data/AIOParam;", "mAIOParam", "()Z", "isShowing", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ze1.b mAtPanel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private mo0.a mAtPanelCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAIOInputEditText mEditText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mInputContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOParam mAIOParam;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ro0/b$b", "Lcom/tencent/guild/aio/input/at/utils/h;", "Landroid/view/KeyEvent;", "event", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ro0.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C11150b implements com.tencent.guild.aio.input.at.utils.h {
        C11150b() {
        }

        @Override // com.tencent.guild.aio.input.at.utils.h
        public boolean a(@Nullable KeyEvent event) {
            if (event != null) {
                b bVar = b.this;
                if (event.getKeyCode() == 4) {
                    return bVar.h();
                }
                return false;
            }
            return false;
        }
    }

    private final void c(CharSequence s16, int start, int before, int count) {
        int i3;
        Editable editable;
        int lastIndexOf$default;
        boolean z16;
        GuildAIOInputEditText guildAIOInputEditText = this.mEditText;
        boolean z17 = false;
        if (guildAIOInputEditText != null) {
            i3 = guildAIOInputEditText.getSelectionStart();
        } else {
            i3 = 0;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = this.mEditText;
        Editable editable2 = null;
        if (guildAIOInputEditText2 != null) {
            editable = guildAIOInputEditText2.getEditableText();
        } else {
            editable = null;
        }
        int c16 = e.c(editable, i3);
        int i16 = i3 - 1;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(s16, '\n', i16, false, 4, (Object) null);
        if (lastIndexOf$default > c16) {
            c16 = -1;
        }
        if (count == 1 && (s16.charAt(start) == '\uff20' || s16.charAt(start) == '@')) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (count == 0 && i3 > 0 && ((s16.charAt(i16) == '\uff20' || s16.charAt(i16) == '@') && c16 > 0)) {
            z17 = true;
        }
        i();
        int h16 = so0.c.h(this.mEditText);
        if (QLog.isColorLevel()) {
            QLog.d("GuildAtHelper", 2, "selectIndex =" + i3 + " isFirstAddAt=" + z16 + " isFirstBackAt=" + z17 + " max=" + c16 + " lastSpanAt=" + h16 + " mAtPanel=mAtPanel");
        }
        if (h16 < c16 && c16 >= 0 && this.mAtPanel != null) {
            GuildAIOInputEditText guildAIOInputEditText3 = this.mEditText;
            if (guildAIOInputEditText3 != null) {
                editable2 = guildAIOInputEditText3.getText();
            }
            String substring = String.valueOf(editable2).substring(c16 + 1, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            mo0.a aVar = this.mAtPanelCallback;
            if (aVar != null) {
                aVar.n(substring);
            }
            ze1.b bVar = this.mAtPanel;
            if (bVar != null) {
                bVar.j(substring, this.mInputContainer);
                return;
            }
            return;
        }
        if (this.mAtPanel != null) {
            h();
        }
    }

    private final void i() {
        String str;
        int i3;
        Context context;
        Context context2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        IRuntimeService runtimeService = appInterface.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        AIOParam aIOParam = this.mAIOParam;
        if (aIOParam != null) {
            str = com.tencent.guild.aio.util.a.b(aIOParam);
        } else {
            str = null;
        }
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str);
        if (channelInfo != null) {
            i3 = channelInfo.getType();
        } else {
            i3 = 0;
        }
        int i16 = i3;
        if (i16 != 0 && i16 != 2 && i16 != 5) {
            if (this.mAtPanel == null) {
                n.b(channelInfo, "GuildAtHelper");
                AIOParam aIOParam2 = this.mAIOParam;
                if (aIOParam2 != null) {
                    String g16 = com.tencent.guild.aio.util.a.g(aIOParam2);
                    String b16 = com.tencent.guild.aio.util.a.b(aIOParam2);
                    GuildAIOInputEditText guildAIOInputEditText = this.mEditText;
                    if (guildAIOInputEditText != null) {
                        context = guildAIOInputEditText.getContext();
                    } else {
                        context = null;
                    }
                    Activity activity = (Activity) context;
                    GuildAIOInputEditText guildAIOInputEditText2 = this.mEditText;
                    if (guildAIOInputEditText2 != null) {
                        context2 = guildAIOInputEditText2.getContext();
                    } else {
                        context2 = null;
                    }
                    this.mAtPanel = (ze1.b) j.a(new xe1.b(g16, b16, i16, activity, context2, appInterface, 0, xe1.b.h("pg_sgrp_aio", "")));
                }
                ze1.b bVar = this.mAtPanel;
                if (bVar != null) {
                    bVar.f("");
                }
                mo0.a aVar = new mo0.a(this.mAtPanel, this.mContext, this.mEditText);
                this.mAtPanelCallback = aVar;
                ze1.b bVar2 = this.mAtPanel;
                if (bVar2 != null) {
                    bVar2.k(aVar);
                }
            }
            GuildAIOInputEditText guildAIOInputEditText3 = this.mEditText;
            if (guildAIOInputEditText3 != null) {
                guildAIOInputEditText3.setKeyEventPreImeListener("GuildAtHelper", new C11150b());
            }
        }
    }

    public final void b(@NotNull CharSequence s16, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s16, "s");
        if (QLog.isColorLevel()) {
            QLog.d("GuildAtHelper", 2, " beforeTextChanged:  start=" + start + " after=" + after + " count=" + count);
        }
        mo0.a aVar = this.mAtPanelCallback;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.l() && QLog.isColorLevel()) {
                QLog.d("GuildAtHelper", 2, "beforeTextChanged guildAtPanel spanChange");
            }
        }
    }

    public final void d(@NotNull GuildAIOInputEditText editText, @NotNull ViewGroup inputContainer, @NotNull Context context, @NotNull AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(inputContainer, "inputContainer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        this.mEditText = editText;
        this.mInputContainer = inputContainer;
        this.mContext = context;
        this.mAIOParam = aioParam;
    }

    public final boolean e() {
        ze1.b bVar = this.mAtPanel;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            if (!bVar.a()) {
                ze1.b bVar2 = this.mAtPanel;
                Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type com.tencent.guild.aio.input.at.quickAt.middleware.GuildAtPanelImpl");
                if (((d) bVar2).u()) {
                }
            }
            return true;
        }
        return false;
    }

    public final void f() {
        ze1.b bVar = this.mAtPanel;
        if (bVar != null) {
            j.d(bVar);
        }
        AtUserHelper.b();
        GuildAIOInputEditText guildAIOInputEditText = this.mEditText;
        if (guildAIOInputEditText != null) {
            guildAIOInputEditText.setKeyEventPreImeListener("GuildAtHelper", null);
        }
        this.mAtPanel = null;
        this.mAtPanelCallback = null;
        this.mEditText = null;
        this.mInputContainer = null;
        this.mContext = null;
        this.mAIOParam = null;
    }

    public final void g(@NotNull CharSequence s16, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s16, "s");
        if (this.mEditText != null) {
            mo0.a aVar = this.mAtPanelCallback;
            if (aVar != null) {
                Intrinsics.checkNotNull(aVar);
                if (aVar.l()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GuildAtHelper", 2, "guildAtPanel spanChange");
                        return;
                    }
                    return;
                }
            }
            c(s16, start, before, count);
        }
    }

    public final boolean h() {
        boolean z16;
        ze1.b bVar = this.mAtPanel;
        if (bVar != null) {
            z16 = bVar.a();
            bVar.dismiss();
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildAtHelper", 4, "tryDismissPanel: realDismiss = " + z16);
        }
        return z16;
    }

    public final void a() {
    }
}
