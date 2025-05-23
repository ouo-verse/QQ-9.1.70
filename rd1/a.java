package rd1;

import android.content.Context;
import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.guild.aio.background.GuildFullBackgroundVB;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB;
import com.tencent.guild.aio.help.GuildDefaultHelperProvider;
import com.tencent.guild.aio.util.m;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.mobileqq.guild.widget.TitleBarTheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016\u00a8\u0006\u001c"}, d2 = {"Lrd1/a;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/msgservice/a;", "buildAIOMsgService", "Lys/a;", "buildActivityJumpService", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Ldt/b;", "getBottomDialogFactory", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "getPanelFactory", "", "isDebugModel", "Lcom/tencent/aio/base/log/f;", "buildAIOLogger", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H\u0016\u00a8\u0006\t"}, d2 = {"rd1/a$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "buildTitleVB", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rd1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C11129a implements f {
        C11129a() {
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            return f.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> buildInputVB() {
            return new com.tencent.mobileqq.gamecenter.qa.aio.input.b();
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            return f.a.d(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            return new com.tencent.guild.aio.title.a(TitleBarTheme.TITLE_BAR_STYLE_01);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<? extends e, ? extends TopTipViewState> buildTopTipVB() {
            return f.a.f(this);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return f.a.g(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rd1/a$b", "Lcom/tencent/aio/api/factory/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.aio.api.factory.a {
        b() {
        }

        @Override // com.tencent.aio.api.factory.a
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            return new GuildFullBackgroundVB(false, 1, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"rd1/a$c", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/aio/api/list/h;", h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "g", "Lcom/tencent/aio/api/refreshLoad/e;", "f", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements j {
        c() {
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> a() {
            return j.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int c(@NotNull Context context) {
            return j.a.d(this, context);
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> d() {
            return j.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int e(@NotNull Context context) {
            return j.a.c(this, context);
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.api.refreshLoad.e f() {
            return com.tencent.guild.aio.factory.e.f110654a;
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: g */
        public AbsMsgListVB<? extends at.b, ? extends MsgListUiState> getViewBinder() {
            return new GuildMsgListDataVB(null, 1, null);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return j.a.e(this);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.list.h b() {
            return new com.tencent.guild.aio.msglist.holder.c(null, 1, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rd1/a$d", "Lcom/tencent/aio/api/factory/e;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements com.tencent.aio.api.factory.e {
        d() {
        }

        @Override // com.tencent.aio.api.factory.e
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve2UIState> a() {
            return new com.tencent.mobileqq.gamecenter.qa.aio.reserve2.a();
        }
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.base.log.f buildAIOLogger() {
        return new m();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.msgservice.a buildAIOMsgService() {
        return ChannelAIOMsgService.f112613a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public ys.a buildActivityJumpService() {
        return zn0.a.f452788a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public f buildBusinessLevel() {
        return new C11129a();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        return new b();
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        return new GuildDefaultHelperProvider();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        return new c();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.c buildPanelArea() {
        return g.a.d(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.d buildReserve1Level() {
        return null;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        return new d();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public dt.b getBottomDialogFactory() {
        return null;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory() {
        return new kq0.a();
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        return ((IAppSetting) QRoute.api(IAppSetting.class)).debug();
    }
}
