package pz1;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskMemberData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlackUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.ee;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.dz;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lpz1/e;", "Lef1/b;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSearchBlackUserRsp;", "rsp", "", "P1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "O1", "keyword", "Q1", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "S1", "(Ljava/lang/String;)V", "guildId", "D", "currentKeyword", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcf1/b;", "E", "Lcom/tencent/mobileqq/guild/util/cn;", "toastEvent", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "searchListShowLiveData", "<init>", "()V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends ef1.b {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String currentKeyword;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final cn<cf1.b> toastEvent = new cn<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e>> searchListShowLiveData = new MutableLiveData<>();

    private final void P1(int result, String errMsg, IGProSearchBlackUserRsp rsp) {
        List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> listOf;
        boolean z16 = true;
        if (result != 0) {
            this.toastEvent.setValue(new cf1.b(result, errMsg));
            MutableLiveData<List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e>> mutableLiveData = this.searchListShowLiveData;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new g());
            mutableLiveData.setValue(listOf);
            Logger.f235387a.d().w("Guild.mnr.GuildRiskSearchViewModel", 1, "requestSearchResultList result: " + result + ", error: " + errMsg);
            return;
        }
        if (!Intrinsics.areEqual(this.currentKeyword, rsp.getKeyword())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<IGProBlackUserInfo> memberList = rsp.getMemberList();
        if (memberList != null && !memberList.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            arrayList.add(new g());
        } else {
            ArrayList<IGProBlackUserInfo> memberList2 = rsp.getMemberList();
            Intrinsics.checkNotNullExpressionValue(memberList2, "rsp.memberList");
            for (IGProBlackUserInfo iGProBlackUserInfo : memberList2) {
                String str = this.guildId;
                long tinyId = iGProBlackUserInfo.getTinyId();
                String nickName = iGProBlackUserInfo.getNickName();
                Intrinsics.checkNotNullExpressionValue(nickName, "it.nickName");
                String avatarUrl = iGProBlackUserInfo.getAvatarUrl();
                Intrinsics.checkNotNullExpressionValue(avatarUrl, "it.avatarUrl");
                arrayList.add(new GuildRiskMemberData(str, tinyId, nickName, avatarUrl, false, false, 48, null));
            }
        }
        this.searchListShowLiveData.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(e this$0, int i3, String errMsg, IGProSearchBlackUserRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this$0.P1(i3, errMsg, rsp);
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e>> O1() {
        return this.searchListShowLiveData;
    }

    public final void Q1(@NotNull String keyword) {
        boolean z16;
        List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> emptyList;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (Intrinsics.areEqual(this.currentKeyword, keyword)) {
            return;
        }
        this.currentKeyword = keyword;
        if (keyword.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            MutableLiveData<List<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e>> mutableLiveData = this.searchListShowLiveData;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData.setValue(emptyList);
            return;
        }
        ee eeVar = new ee();
        eeVar.j(com.tencent.guild.aio.input.at.utils.g.a(this.guildId, 0L));
        eeVar.k(this.currentKeyword);
        eeVar.l(400);
        eeVar.m(0);
        eeVar.o(1);
        eeVar.n(2);
        IRuntimeService runtimeService = M1().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).searchBlackUserFromServer(eeVar, new dz() { // from class: pz1.d
            @Override // wh2.dz
            public final void a(int i3, String str, IGProSearchBlackUserRsp iGProSearchBlackUserRsp) {
                e.R1(e.this, i3, str, iGProSearchBlackUserRsp);
            }
        });
    }

    public final void S1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }
}
