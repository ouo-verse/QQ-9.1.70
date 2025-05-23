package yz1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.setting.guildsetting.data.InviteFriendUpdateEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.ep;
import com.tencent.mobileqq.qqguildsdk.data.genc.z;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo;
import com.tencent.util.QQCustomArkDialogUtil;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.dl;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007JZ\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0004j\b\u0012\u0004\u0012\u00020\u0012`\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007\u00a8\u0006\u001d"}, d2 = {"Lyz1/g;", "", "Landroid/content/Intent;", "data", "Ljava/util/ArrayList;", "Lyz1/r;", "Lkotlin/collections/ArrayList;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "d", "", "guildId", "selectedFriends", "e", "Landroid/app/Activity;", "context", "", "", "maxCount", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "requestCode", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "g", "i", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a */
    @NotNull
    public static final g f451616a = new g();

    g() {
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<InviteFriendsData> c(@NotNull Intent data) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<ResultRecord> parcelableArrayListExtra = data.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = new ArrayList();
        }
        bg bgVar = bg.f302144a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parcelableArrayListExtra, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ResultRecord resultRecord : parcelableArrayListExtra) {
            String str = resultRecord.uin;
            Intrinsics.checkNotNullExpressionValue(str, "it.uin");
            String str2 = resultRecord.name;
            Intrinsics.checkNotNullExpressionValue(str2, "it.name");
            arrayList.add(new InviteFriendsData(str, str2));
        }
        return bgVar.n(arrayList);
    }

    @JvmStatic
    public static final void d(@Nullable IGProGuildInfo guildInfo, @Nullable Intent data) {
        boolean z16;
        Integer num = null;
        if (guildInfo == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[handleSelectMemberActivityResult] guildInfo is Null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFriendInviteUtils", 1, (String) it.next(), null);
            }
            return;
        }
        if (data == null) {
            data = new Intent();
        }
        ArrayList<InviteFriendsData> c16 = c(data);
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildFriendInviteUtils", "[handleSelectMemberActivityResult] " + c16);
        }
        if (c16.isEmpty()) {
            return;
        }
        boolean z17 = false;
        if (guildInfo.getUserNum() + c16.size() <= bs.f235483a.h("105748").getGuildInviteFriendsConfBean().getGuildMemberScaleLimit()) {
            GProGuildInfo innerGuildInfo = guildInfo.getInnerGuildInfo();
            if (innerGuildInfo != null && innerGuildInfo.joinGuildOption == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || ch.l0(guildInfo)) {
                z17 = true;
            }
        }
        Logger.a d16 = Logger.f235387a.d();
        GProGuildInfo innerGuildInfo2 = guildInfo.getInnerGuildInfo();
        if (innerGuildInfo2 != null) {
            num = Integer.valueOf(innerGuildInfo2.joinGuildOption);
        }
        d16.d("GuildFriendInviteUtils", 1, "[handleSelectMemberActivityResult] joinOption:  " + num + ",  guildInfo.userNum " + guildInfo.getUserNum() + ", friendList.size " + c16.size() + ",  canDirectJoinIn\uff1a" + z17);
        if (z17) {
            String guildID = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
            e(MiscKt.l(guildID), c16);
        } else {
            String guildID2 = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID2, "guildInfo.guildID");
            i(MiscKt.l(guildID2), c16);
        }
    }

    @JvmStatic
    public static final void e(final long guildId, @NotNull final ArrayList<InviteFriendsData> selectedFriends) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(selectedFriends, "selectedFriends");
        Logger.f235387a.d().d("GuildFriendInviteUtils", 1, "[inviteJoinSingleGuild] guildId " + guildId + ", selectedFriends " + selectedFriends);
        ep epVar = new ep();
        epVar.p(JumpGuildParam.ARK_ADD_FRIENDS_MAIN_SOURCE_ID);
        epVar.q("channel_addfriend_direct");
        z zVar = new z();
        zVar.q(guildId);
        zVar.s(epVar);
        bg bgVar = bg.f302144a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedFriends, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = selectedFriends.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(MiscKt.l(((InviteFriendsData) it.next()).getUin())));
        }
        zVar.r(bgVar.n(arrayList));
        ((IGPSService) ch.R0(IGPSService.class)).inviteJoinSingleGuild(zVar, new dl() { // from class: yz1.e
            @Override // wh2.dl
            public final void a(int i3, String str, IGProJoinGuildResult iGProJoinGuildResult) {
                g.f(guildId, selectedFriends, i3, str, iGProJoinGuildResult);
            }
        });
    }

    public static final void f(long j3, ArrayList selectedFriends, int i3, String str, IGProJoinGuildResult iGProJoinGuildResult) {
        IGProSecurityResult iGProSecurityResult;
        Intrinsics.checkNotNullParameter(selectedFriends, "$selectedFriends");
        IGProSecurityResult iGProSecurityResult2 = null;
        if (iGProJoinGuildResult != null) {
            iGProSecurityResult = iGProJoinGuildResult.getSecRet();
        } else {
            iGProSecurityResult = null;
        }
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        Logger.f235387a.d().d("GuildFriendInviteUtils", 1, "[inviteJoinSingleGuild] result " + i3 + ", error " + e16);
        if (e16.f431477a == 22044) {
            i(j3, selectedFriends);
            return;
        }
        if (e16.d()) {
            ch.d1(2, R.string.f146870vc);
            SimpleEventBus.getInstance().dispatchEvent(new InviteFriendUpdateEvent());
        } else {
            BaseApplication context = BaseApplication.getContext();
            if (iGProJoinGuildResult != null) {
                iGProSecurityResult2 = iGProJoinGuildResult.getSecRet();
            }
            SecurityTipHelperKt.F(context, i3, str, iGProSecurityResult2, null, null, 48, null);
        }
    }

    @JvmStatic
    public static final void g(@NotNull Activity context, long guildId, @NotNull ArrayList<String> selectedFriends, int maxCount, int r122, int requestCode, @NotNull Bundle r142) {
        IGProGuildInfo iGProGuildInfo;
        ArrayList<String> arrayListOf;
        int size;
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedFriends, "selectedFriends");
        Intrinsics.checkNotNullParameter(r142, "extraData");
        if (guildId != 0) {
            iGProGuildInfo = ch.L(String.valueOf(guildId));
        } else {
            iGProGuildInfo = null;
        }
        com.tencent.mobileqq.guild.config.k guildInviteFriendsConfBean = bs.f235483a.h("105748").getGuildInviteFriendsConfBean();
        Logger.f235387a.d().d("GuildFriendInviteUtils", 1, "[openSelectMemberActivity] selectedFriends " + selectedFriends + ", scaleLimit:" + guildInviteFriendsConfBean.getGuildMemberScaleLimit());
        String currentUin = ch.l().getCurrentUin();
        boolean z16 = r142.getBoolean("key_invite_friend_show_confirm_dialog", true);
        int i16 = r142.getInt("key_invite_friend_title", R.string.f146910vg);
        int i17 = r142.getInt("key_invite_friend_button", R.string.f146900vf);
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, maxCount);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_ROBOT_GROUP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_MYSELF, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, r122);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_DONE_BUTTON_IN_BOTTOM, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FILTER_ROBOT, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, QQGuildUIUtil.r(i16));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, QQGuildUIUtil.r(i17));
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(currentUin);
        arrayListOf.addAll(selectedFriends);
        Unit unit = Unit.INSTANCE;
        intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayListOf);
        if (iGProGuildInfo != null) {
            size = iGProGuildInfo.getUserNum();
        } else {
            size = selectedFriends.size();
        }
        intent.putExtra("guild_current_member_number", size);
        if (z16) {
            i3 = guildInviteFriendsConfBean.getGuildMemberScaleLimit();
        } else {
            i3 = Integer.MAX_VALUE;
        }
        intent.putExtra("guild_member_scale_limit", i3);
        intent.putExtra("guild_invite_friends_dialog_title", "");
        intent.putExtra("guild_invite_friends_dialog_desc", context.getString(R.string.f146890ve));
        intent.putExtra("guild_invite_firends_dialog_right_btn", context.getString(R.string.f146850va));
        intent.putExtras(r142);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(context, intent, requestCode);
    }

    public static /* synthetic */ void h(Activity activity, long j3, ArrayList arrayList, int i3, int i16, int i17, Bundle bundle, int i18, Object obj) {
        ArrayList arrayList2;
        int i19;
        int i26;
        int i27;
        Bundle bundle2;
        if ((i18 & 4) != 0) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList;
        }
        if ((i18 & 8) != 0) {
            i19 = 100;
        } else {
            i19 = i3;
        }
        if ((i18 & 16) != 0) {
            i26 = 49;
        } else {
            i26 = i16;
        }
        if ((i18 & 32) != 0) {
            i27 = 6666;
        } else {
            i27 = i17;
        }
        if ((i18 & 64) != 0) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        g(activity, j3, arrayList2, i19, i26, i27, bundle2);
    }

    @JvmStatic
    public static final void i(long guildId, @NotNull ArrayList<InviteFriendsData> selectedFriends) {
        final com.tencent.mobileqq.guild.message.serversendarkmsg.c cVar;
        int collectionSizeOrDefault;
        long[] longArray;
        Object firstOrNull;
        String valueOf;
        Intrinsics.checkNotNullParameter(selectedFriends, "selectedFriends");
        Logger.f235387a.d().d("GuildFriendInviteUtils", 1, "[sendShareArkWithoutPreview] guildId " + guildId + ", size: " + selectedFriends.size());
        if (guildId != 0 && !selectedFriends.isEmpty()) {
            Object businessHandler = ch.l().getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getServerSendArkMsgHandlerName());
            if (businessHandler instanceof com.tencent.mobileqq.guild.message.serversendarkmsg.c) {
                cVar = (com.tencent.mobileqq.guild.message.serversendarkmsg.c) businessHandler;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedFriends, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = selectedFriends.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(MiscKt.l(((InviteFriendsData) it.next()).getUin())));
                }
                longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
                final Bundle bundle = new Bundle();
                bundle.putInt("uintype", 0);
                bundle.putLong(AppConstants.Key.GUILD_SOURCE_ID, guildId);
                bundle.putString(QQCustomArkDialogUtil.META_DATA, String.valueOf(guildId));
                bundle.putInt("businessType", 20);
                bundle.putLongArray("BATCH_C2C_UIN_LIST", longArray);
                bundle.putString("toast_success_wording", QQGuildUIUtil.r(R.string.f146840v_));
                bundle.putString("toast_failed_wording", QQGuildUIUtil.r(R.string.f146860vb));
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) selectedFriends);
                InviteFriendsData inviteFriendsData = (InviteFriendsData) firstOrNull;
                if (inviteFriendsData == null || (valueOf = inviteFriendsData.getUin()) == null) {
                    valueOf = String.valueOf(guildId);
                }
                bundle.putString("uin", valueOf);
                ThreadManagerV2.excute(new Runnable() { // from class: yz1.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.j(com.tencent.mobileqq.guild.message.serversendarkmsg.c.this, bundle);
                    }
                }, 16, null, false);
            }
        }
    }

    public static final void j(com.tencent.mobileqq.guild.message.serversendarkmsg.c arkHandler, Bundle bundle) {
        Intrinsics.checkNotNullParameter(arkHandler, "$arkHandler");
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        arkHandler.v1(bundle, "", System.currentTimeMillis(), 1);
    }
}
