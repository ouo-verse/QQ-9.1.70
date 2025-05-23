package pz1;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.guild.aio.input.at.utils.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.BatchHandleRiskData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GroupSelectType;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskGroupData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskMemberData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.State;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.h;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.i;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.j;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.k;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberGroupInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.du;
import com.tencent.mobileqq.qqguildsdk.data.genc.dw;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f*\u00014\u0018\u0000 ]2\u00020\u0001:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004J\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\b0\b0\u0004J\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\n0\n0\u0004J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0014J4\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0016\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\nJ\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J\b\u0010+\u001a\u00020\u0002H\u0002J \u00100\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00112\u0006\u0010/\u001a\u00020.H\u0002J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0002J\u000f\u00105\u001a\u000204H\u0002\u00a2\u0006\u0004\b5\u00106J\b\u00107\u001a\u00020\u0002H\u0002J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002080\u001aH\u0002J\b\u0010:\u001a\u00020\u0002H\u0002R\"\u0010A\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\"\u0010I\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\n0\n0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010U\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010HR\"\u0010W\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\b0\b0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010HR\u0014\u0010Z\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006_"}, d2 = {"Lpz1/c;", "Lef1/b;", "", "initData", "Landroidx/lifecycle/MutableLiveData;", "Lpz1/f;", "kotlin.jvm.PlatformType", "Z1", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/a;", "X1", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/guild/util/cn;", "Lcf1/b;", "getToastEvent", "c2", FeedManager.LOAD_MORE, "", "account", "onAccountChanged", "onCleared", "addBlack", "", "msgRevokeType", "removeFromGuild", "selectAll", "", "", "tinyIdList", "f2", "isSearchMode", "q2", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "groupSelectType", ICustomDataEditor.NUMBER_PARAM_2, "tinyId", "isSelected", "p2", "isEditMode", "m2", "tag", "i2", "U1", SemanticAttributes.DbSystemValues.H2, "result", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRiskMemberListRsp;", "rsp", "b2", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/State;", "state", "d2", "pz1/c$c", "W1", "()Lpz1/c$c;", "o2", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "e2", "l2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "k2", "(Ljava/lang/String;)V", "guildId", "D", "reqCookie", "E", "Lcom/tencent/mobileqq/guild/util/cn;", "toastEvent", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "isSearchModeLiveData", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/i;", "G", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/i;", "loadedRiskData", "H", "Z", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "I", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/k;", "selectedMemberInfo", "J", "listShowLiveData", "K", "batchHandleRiskLiveData", "L", "Lpz1/c$c;", "guildObserver", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends ef1.b {

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isEditMode;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String reqCookie = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final cn<cf1.b> toastEvent = new cn<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isSearchModeLiveData = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private i loadedRiskData = new i();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private k selectedMemberInfo = new k(0, false, null, 7, null);

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<RiskShowData> listShowLiveData = new MutableLiveData<>(new RiskShowData(null, null, 3, null));

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<BatchHandleRiskData> batchHandleRiskLiveData = new MutableLiveData<>(new BatchHandleRiskData(false, false, null, 7, null));

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final C11046c guildObserver = W1();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f428088a;

        static {
            int[] iArr = new int[GroupSelectType.values().length];
            try {
                iArr[GroupSelectType.SELECT_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupSelectType.CANCEL_SELECT_ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f428088a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J.\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0016J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"pz1/c$c", "Loo1/a;", "", "guildId", "", "selectAll", "", "", "tinyIdList", "", ReportConstant.COSTREPORT_PREFIX, "addBlack", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pz1.c$c, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C11046c extends oo1.a {
        C11046c() {
        }

        private final void s(String guildId, boolean selectAll, List<Long> tinyIdList) {
            if (!Intrinsics.areEqual(c.this.getGuildId(), guildId)) {
                return;
            }
            c.this.loadedRiskData.h(selectAll, tinyIdList);
            c cVar = c.this;
            cVar.selectedMemberInfo = new k(cVar.loadedRiskData.getTotalNum(), false, null, 6, null);
            c.this.o2();
            c.this.l2();
            if (c.this.loadedRiskData.getCurrentState() == State.HAS_MORE) {
                c.this.loadMore();
            }
        }

        @Override // oo1.a
        public void m(@NotNull String guildId, boolean addBlack, @NotNull List<String> tinyIdList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
            List<String> list = tinyIdList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(az.d((String) it.next(), 0L)));
            }
            s(guildId, false, arrayList);
        }

        @Override // oo1.a
        public void o(long guildId, boolean addBlack, boolean selectAll, @NotNull List<Long> tinyIdList) {
            Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
            s(String.valueOf(guildId), selectAll, tinyIdList);
        }
    }

    private final void U1() {
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "addObservers");
        M1().addObserver(this.guildObserver);
    }

    private final C11046c W1() {
        return new C11046c();
    }

    private final void b2(int result, String errMsg, IGProRiskMemberListRsp rsp) {
        Set of5;
        State state;
        State state2 = State.LOADING;
        State state3 = State.LOAD_MORE;
        of5 = SetsKt__SetsKt.setOf((Object[]) new State[]{state2, state3});
        if (!of5.contains(this.loadedRiskData.getCurrentState())) {
            return;
        }
        if (result != 0) {
            this.toastEvent.setValue(new cf1.b(result, errMsg));
            if (this.loadedRiskData.getCurrentState() == state3) {
                d2(State.HAS_MORE);
                return;
            } else {
                d2(State.LOAD_FAILED);
                return;
            }
        }
        String cookie = rsp.getCookie();
        Intrinsics.checkNotNullExpressionValue(cookie, "rsp.cookie");
        this.reqCookie = cookie;
        if (this.loadedRiskData.getCurrentState() == state2) {
            this.loadedRiskData.k(rsp.getTitle());
            this.loadedRiskData.j(rsp.getSubTitle());
        }
        this.loadedRiskData.l(rsp.getTotalNum());
        this.selectedMemberInfo.h(rsp.getTotalNum());
        i iVar = this.loadedRiskData;
        if (rsp.getIsEnd()) {
            state = State.END;
        } else {
            state = State.HAS_MORE;
        }
        iVar.i(state);
        i iVar2 = this.loadedRiskData;
        String str = this.guildId;
        ArrayList<IGProRiskMemberGroupInfo> groupList = rsp.getGroupList();
        Intrinsics.checkNotNullExpressionValue(groupList, "rsp.groupList");
        iVar2.a(str, groupList);
        o2();
        l2();
    }

    private final void d2(State state) {
        this.loadedRiskData.i(state);
        RiskShowData value = this.listShowLiveData.getValue();
        if (value == null) {
            this.listShowLiveData.setValue(new RiskShowData(this.loadedRiskData.getCurrentState(), null, 2, null));
        } else if (value.getState() != this.loadedRiskData.getCurrentState()) {
            value.c(this.loadedRiskData.getCurrentState());
            this.listShowLiveData.setValue(value);
        }
    }

    private final List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> e2() {
        boolean z16;
        GroupSelectType groupSelectType;
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        if (this.loadedRiskData.getCurrentState() == State.LOADING) {
            arrayList.add(new com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.d());
            return arrayList;
        }
        String tipsTitle = this.loadedRiskData.getTipsTitle();
        int i3 = 0;
        boolean z17 = true;
        if (tipsTitle != null && tipsTitle.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String tipsSubTitle = this.loadedRiskData.getTipsSubTitle();
            if (tipsSubTitle != null && tipsSubTitle.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                String tipsTitle2 = this.loadedRiskData.getTipsTitle();
                Intrinsics.checkNotNull(tipsTitle2);
                String tipsSubTitle2 = this.loadedRiskData.getTipsSubTitle();
                Intrinsics.checkNotNull(tipsSubTitle2);
                arrayList.add(new h(tipsTitle2, tipsSubTitle2));
            }
        }
        if (this.loadedRiskData.d().isEmpty()) {
            arrayList.add(new com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.a());
            return arrayList;
        }
        if (this.isEditMode) {
            if (this.selectedMemberInfo.f()) {
                groupSelectType = GroupSelectType.CANCEL_SELECT_ALL;
            } else {
                groupSelectType = GroupSelectType.SELECT_ALL;
            }
        } else {
            groupSelectType = GroupSelectType.EMPTY_SELECT;
        }
        for (Object obj : this.loadedRiskData.d()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            j jVar = (j) obj;
            if (i3 == 0) {
                arrayList.add(GuildRiskGroupData.c(jVar.getCom.tencent.mobileqq.vas.vipav.api.VipFunCallConstants.KEY_GROUP java.lang.String(), 0L, null, groupSelectType, 3, null));
            } else {
                arrayList.add(GuildRiskGroupData.c(jVar.getCom.tencent.mobileqq.vas.vipav.api.VipFunCallConstants.KEY_GROUP java.lang.String(), 0L, null, null, 7, null));
            }
            ArrayList<GuildRiskMemberData> b16 = jVar.b();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (GuildRiskMemberData guildRiskMemberData : b16) {
                arrayList2.add(GuildRiskMemberData.c(guildRiskMemberData, null, 0L, null, null, this.selectedMemberInfo.b(guildRiskMemberData.getTinyId()), this.isEditMode, 15, null));
            }
            arrayList.addAll(arrayList2);
            i3 = i16;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(c this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "removeFromRiskMember " + i3 + ", " + str);
        if (i3 == 0) {
            str = HardCodeUtil.qqStr(R.string.f152981av);
            Intrinsics.checkNotNullExpressionValue(str, "{\n                    Ha\u2026uccess)\n                }");
        } else if (str == null) {
            str = "";
        }
        this$0.toastEvent.setValue(new cf1.b(i3, str));
    }

    private final void h2() {
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "removeObservers");
        M1().removeObserver(this.guildObserver);
    }

    private final void i2(final String tag) {
        final dw dwVar = new dw();
        dwVar.f(az.d(this.guildId, 0L));
        dwVar.e(this.reqCookie);
        IRuntimeService runtimeService = M1().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).riskMemberList(dwVar, new wh2.dw() { // from class: pz1.a
            @Override // wh2.dw
            public final void a(int i3, String str, IGProRiskMemberListRsp iGProRiskMemberListRsp) {
                c.j2(c.this, tag, dwVar, i3, str, iGProRiskMemberListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(c this$0, String tag, dw req, int i3, String errMsg, IGProRiskMemberListRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(req, "$req");
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, tag + "(" + req.c() + ", " + req.b() + "), " + i3 + ", " + errMsg);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        this$0.b2(i3, errMsg, rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2() {
        if (this.loadedRiskData.d().size() == 0) {
            this.batchHandleRiskLiveData.setValue(new BatchHandleRiskData(false, false, null, 6, null));
            return;
        }
        this.batchHandleRiskLiveData.setValue(new BatchHandleRiskData(true, this.isEditMode, this.selectedMemberInfo));
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "updateSelect:" + this.selectedMemberInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o2() {
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "updateListShow:" + this.loadedRiskData);
        this.listShowLiveData.setValue(new RiskShowData(this.loadedRiskData.getCurrentState(), e2()));
    }

    @NotNull
    public final MutableLiveData<BatchHandleRiskData> X1() {
        return this.batchHandleRiskLiveData;
    }

    @NotNull
    public final MutableLiveData<RiskShowData> Z1() {
        return this.listShowLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> a2() {
        return this.isSearchModeLiveData;
    }

    public final boolean c2() {
        State state;
        RiskShowData value = this.listShowLiveData.getValue();
        if (value != null) {
            state = value.getState();
        } else {
            state = null;
        }
        if (state == State.HAS_MORE) {
            return true;
        }
        return false;
    }

    public final void f2(boolean addBlack, int msgRevokeType, boolean removeFromGuild, boolean selectAll, @NotNull List<Long> tinyIdList) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
        Logger.a d16 = Logger.f235387a.d();
        String guildId = getGuildId();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(tinyIdList, ",", null, null, 0, null, null, 62, null);
        d16.i("Guild.mnr.GuildRiskMemberViewModel", 1, "removeFromRiskMember guildId:" + guildId + ", addBlack:" + addBlack + ", msgRevokeType:" + msgRevokeType + ", removeFromGuild:" + removeFromGuild + ", selectAll:" + selectAll + ", tinyIdList:" + joinToString$default);
        du duVar = new du();
        duVar.l(new ArrayList<>(tinyIdList));
        duVar.k(selectAll);
        duVar.h(g.a(this.guildId, 0L));
        duVar.g(addBlack);
        duVar.i(removeFromGuild);
        duVar.j(msgRevokeType);
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).Y2(duVar, new cc() { // from class: pz1.b
            @Override // vh2.cc
            public final void onResult(int i3, String str) {
                c.g2(c.this, i3, str);
            }
        });
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final cn<cf1.b> getToastEvent() {
        return this.toastEvent;
    }

    public final void initData() {
        this.loadedRiskData.i(State.LOADING);
        this.listShowLiveData.setValue(new RiskShowData(this.loadedRiskData.getCurrentState(), null, 2, null));
        i2("init");
        U1();
    }

    public final void k2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void loadMore() {
        d2(State.LOAD_MORE);
        i2(FeedManager.LOAD_MORE);
    }

    public final void m2(boolean isEditMode) {
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "updateEditMode isEditMode:" + isEditMode);
        if (this.isEditMode == isEditMode) {
            return;
        }
        this.isEditMode = isEditMode;
        if (isEditMode) {
            this.selectedMemberInfo.g();
        } else {
            this.selectedMemberInfo.i();
        }
        o2();
        l2();
    }

    public final void n2(@NotNull GroupSelectType groupSelectType) {
        Intrinsics.checkNotNullParameter(groupSelectType, "groupSelectType");
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "onGroupSelectTypeChange groupSelectType:" + groupSelectType);
        int i3 = b.f428088a[groupSelectType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                this.selectedMemberInfo.i();
                o2();
                l2();
                return;
            }
            return;
        }
        this.selectedMemberInfo.g();
        o2();
        l2();
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "onAccountChanged, " + account);
        h2();
        super.onAccountChanged(account);
        U1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        h2();
    }

    public final void p2(long tinyId, boolean isSelected) {
        Logger.f235387a.d().i("Guild.mnr.GuildRiskMemberViewModel", 1, "onMemberSelectedChanged tinyId:" + tinyId + ", isSelected:" + isSelected);
        this.selectedMemberInfo.a(tinyId, isSelected);
        o2();
        l2();
    }

    public final void q2(boolean isSearchMode) {
        this.isSearchModeLiveData.setValue(Boolean.valueOf(isSearchMode));
    }
}
