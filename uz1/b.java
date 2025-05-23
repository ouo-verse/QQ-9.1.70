package uz1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nR%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R%\u0010 \u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R%\u0010#\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u00148\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R%\u0010&\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u00148\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R%\u0010)\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u00148\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010*R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u0017R\u001c\u00107\u001a\n \u0015*\u0004\u0018\u000104048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Luz1/b;", "Lef1/b;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "b2", "Z1", "", "allSwitch", "switchType", "", "U1", "switchFlag", h.f248218g, "S1", "", "mGuildId", "T1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "W1", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "publicContentLiveData", "D", "Q1", "interactFeedLiveData", "E", "getPublishFeedLiveData", "publishFeedLiveData", UserInfo.SEX_FEMALE, "getSendLiveMsgLiveData", "sendLiveMsgLiveData", "G", "getAudioVideoLiveData", "audioVideoLiveData", "H", "getFaceAuthLiveData", "faceAuthLiveData", "I", "visitorInteractAllSwitch", "J", "Z", "faceAuthSwitch", "K", "Ljava/lang/String;", "guildId", "L", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "M", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "mGProService", "<init>", "()V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends ef1.b {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> publicContentLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> interactFeedLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> publishFeedLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> sendLiveMsgLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> audioVideoLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> faceAuthLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private int visitorInteractAllSwitch;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean faceAuthSwitch;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<IGProGuildInfo> mGuildInfo;

    /* renamed from: M, reason: from kotlin metadata */
    private final IGPSService mGProService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Luz1/b$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Luz1/b;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uz1.b$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: uz1.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C11381a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f440647a;

            public C11381a(ViewModelStoreOwner viewModelStoreOwner) {
                this.f440647a = viewModelStoreOwner;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new b(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C11381a(owner)).get(b.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (b) viewModel;
        }

        Companion() {
        }
    }

    public b() {
        Boolean bool = Boolean.FALSE;
        this.publicContentLiveData = new MutableLiveData<>(bool);
        this.interactFeedLiveData = new MutableLiveData<>(bool);
        this.publishFeedLiveData = new MutableLiveData<>(bool);
        this.sendLiveMsgLiveData = new MutableLiveData<>(bool);
        this.audioVideoLiveData = new MutableLiveData<>(bool);
        this.faceAuthLiveData = new MutableLiveData<>(bool);
        this.guildId = "";
        this.mGuildInfo = new MutableLiveData<>();
        this.mGProService = (IGPSService) ch.R0(IGPSService.class);
    }

    private final int S1(int i3, int i16, boolean z16) {
        if (z16) {
            return i3 | (1 << i16);
        }
        return i3 & (~(1 << i16));
    }

    private final boolean U1(int allSwitch, int switchType) {
        if (((allSwitch >> switchType) & 1) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(int i3, b this$0, boolean z16, int i16, int i17, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.MF.Vst.GuildVisitorManageViewModel", 1, "modifyInteractAllSwitch(" + this$0.guildId + ") " + Integer.toBinaryString(this$0.visitorInteractAllSwitch) + "->" + Integer.toBinaryString(i16) + " " + i17 + " " + str);
        if (i17 == 0) {
            if (i3 == 1 || i3 == 5) {
                g.c(2, R.string.f156431k7);
            }
            this$0.visitorInteractAllSwitch = this$0.S1(this$0.visitorInteractAllSwitch, i3, z16);
        } else {
            SecurityTipHelperKt.F(ch.i(), i17, str, null, null, null, 56, null);
        }
        this$0.a2();
    }

    private final void Z1() {
        this.faceAuthLiveData.setValue(Boolean.valueOf(this.faceAuthSwitch));
    }

    private final void b2(IGProGuildInfo guildInfo) {
        this.visitorInteractAllSwitch = guildInfo.getVisitorInteractionAllSwitch();
        a2();
        this.faceAuthSwitch = guildInfo.isNeedRealNameForVisitor();
        Z1();
    }

    @NotNull
    public final MutableLiveData<Boolean> Q1() {
        return this.interactFeedLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> R1() {
        return this.publicContentLiveData;
    }

    public final void T1(@NotNull String mGuildId) {
        Integer num;
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        this.guildId = mGuildId;
        IGProGuildInfo guildInfo = this.mGProService.getGuildInfo(mGuildId);
        if (guildInfo != null) {
            this.mGuildInfo.setValue(guildInfo);
            b2(guildInfo);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            Boolean bool = null;
            if (guildInfo != null) {
                num = Integer.valueOf(guildInfo.getVisitorInteractionAllSwitch());
            } else {
                num = null;
            }
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isNeedRealNameForVisitor());
            }
            d16.d("Guild.MF.Vst.GuildVisitorManageViewModel", 2, "setGuildId " + mGuildId + " visitorInteractionAllSwitch:" + num + ", isNeedRealNameForVisitor:" + bool);
        }
    }

    public final void W1(final int switchFlag, final boolean isOpen) {
        HashMap<Integer, Integer> hashMapOf;
        final int S1 = S1(this.visitorInteractAllSwitch, switchFlag, isOpen);
        if (S1 != this.visitorInteractAllSwitch) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(47, Integer.valueOf(S1)));
            this.mGProService.batchSetIntField(this.guildId, hashMapOf, new cc() { // from class: uz1.a
                @Override // vh2.cc
                public final void onResult(int i3, String str) {
                    b.X1(switchFlag, this, isOpen, S1, i3, str);
                }
            });
        } else {
            a2();
        }
    }

    public final void a2() {
        this.publicContentLiveData.setValue(Boolean.valueOf(U1(this.visitorInteractAllSwitch, 5)));
        this.interactFeedLiveData.setValue(Boolean.valueOf(U1(this.visitorInteractAllSwitch, 1)));
        this.publishFeedLiveData.setValue(Boolean.valueOf(U1(this.visitorInteractAllSwitch, 2)));
        this.sendLiveMsgLiveData.setValue(Boolean.valueOf(U1(this.visitorInteractAllSwitch, 3)));
        this.audioVideoLiveData.setValue(Boolean.valueOf(U1(this.visitorInteractAllSwitch, 4)));
    }
}
