package uo0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.guild.aio.input.at.utils.AtUserHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleMemberList;
import com.tencent.mobileqq.qqguildsdk.data.genc.ap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.ah;
import wh2.av;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002JL\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\"\u0010!\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Luo0/f;", "", "", "f", "", "", "ids", "", "b", "Lmqq/app/AppRuntime;", "app", "guildId", "channelId", "robotList", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "robotFilter", "count", "Lvh2/ah;", "cb", "c", "a", "J", "mStartIndex", "mRoleIdIndex", "Ljava/util/List;", "mRobotMembers", "d", "Z", "e", "()Z", "setMIsFinish", "(Z)V", "mIsFinish", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long mStartIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mRoleIdIndex = 2;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> mRobotMembers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFinish;

    private final List<Long> b(List<String> ids) {
        int collectionSizeOrDefault;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (Object obj : ids) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(Long.parseLong((String) it.next())));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(f this$0, ah cb5, boolean z16, String guildId, int i3, String str, IGProFeedMemberListRsp iGProFeedMemberListRsp) {
        boolean z17;
        boolean z18;
        boolean z19;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 == 0 && iGProFeedMemberListRsp != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList<IGProUserInfo> robotMembers = iGProFeedMemberListRsp.getRobotMembers();
            if (robotMembers != null && !robotMembers.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                ArrayList<IGProUserInfo> robotMembers2 = iGProFeedMemberListRsp.getRobotMembers();
                Intrinsics.checkNotNullExpressionValue(robotMembers2, "rsp.robotMembers");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(robotMembers2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = robotMembers2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((IGProUserInfo) it.next()).getTinyId());
                }
                this$0.mRobotMembers = arrayList2;
                ArrayList<IGProUserInfo> robotMembers3 = iGProFeedMemberListRsp.getRobotMembers();
                Intrinsics.checkNotNullExpressionValue(robotMembers3, "rsp.robotMembers");
                arrayList.addAll(robotMembers3);
            }
            List<String> list = this$0.mRobotMembers;
            if (list != null && !list.isEmpty()) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                ArrayList<IGProRoleMemberList> roleList = iGProFeedMemberListRsp.getRoleList();
                if (roleList != null) {
                    Iterator<T> it5 = roleList.iterator();
                    while (it5.hasNext()) {
                        ArrayList<IGProUserInfo> members = ((IGProRoleMemberList) it5.next()).getMembers();
                        Intrinsics.checkNotNullExpressionValue(members, "it.members");
                        arrayList.addAll(members);
                    }
                }
            } else {
                ArrayList<IGProRoleMemberList> roleList2 = iGProFeedMemberListRsp.getRoleList();
                if (roleList2 != null) {
                    Iterator<T> it6 = roleList2.iterator();
                    while (it6.hasNext()) {
                        ArrayList<IGProUserInfo> members2 = ((IGProRoleMemberList) it6.next()).getMembers();
                        Intrinsics.checkNotNullExpressionValue(members2, "it.members");
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj : members2) {
                            IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
                            List<String> list2 = this$0.mRobotMembers;
                            if (list2 != null && list2.contains(iGProUserInfo.getTinyId())) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (!z19) {
                                arrayList3.add(obj);
                            }
                        }
                        arrayList.addAll(arrayList3);
                    }
                }
            }
            QLog.i("GuildFeedUserPresenter", 1, "[fetchMemberListForFeed] Callback isFinished=" + iGProFeedMemberListRsp.getIsFinished() + ",robotMembers=" + this$0.mRobotMembers + " userList.size=" + arrayList.size() + ", isFinished: " + iGProFeedMemberListRsp.getIsFinished() + ", nextIndex: " + iGProFeedMemberListRsp.getNextIndex() + ", nextRoleIdIndex: " + iGProFeedMemberListRsp.getNextRoleIdIndex());
            cb5.a(iGProFeedMemberListRsp.getIsFinished() ^ true, arrayList);
            this$0.mStartIndex = iGProFeedMemberListRsp.getNextIndex();
            this$0.mRoleIdIndex = iGProFeedMemberListRsp.getNextRoleIdIndex();
            this$0.mIsFinish = iGProFeedMemberListRsp.getIsFinished();
            if (!z16) {
                AtUserHelper.i(guildId, arrayList);
                return;
            }
            return;
        }
        QLog.e("GuildFeedUserPresenter", 1, "[fetchMemberListForFeed] result=" + i3 + ", errMsg=" + str);
    }

    private final void f() {
        this.mStartIndex = 0L;
        this.mRoleIdIndex = 2L;
    }

    public final void c(@NotNull AppRuntime app, @NotNull final String guildId, @NotNull String channelId, @NotNull List<String> robotList, final boolean isLoadMore, boolean robotFilter, long count, @NotNull final ah cb5) {
        int i3;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(robotList, "robotList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!isLoadMore) {
            f();
        }
        IRuntimeService runtimeService = app.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
        boolean z16 = false;
        if (channelInfo != null && channelInfo.getType() == 7) {
            z16 = true;
        }
        if (z16) {
            i3 = 109;
        } else {
            i3 = 108;
        }
        ap apVar = new ap();
        apVar.k(com.tencent.guild.aio.input.at.utils.g.a(guildId, 0L));
        apVar.i(com.tencent.guild.aio.input.at.utils.g.a(channelId, 0L));
        apVar.j(count);
        apVar.m(new ArrayList<>(b(robotList)));
        apVar.l(robotFilter ? 1 : 0);
        apVar.o(i3);
        apVar.p(this.mStartIndex);
        apVar.n(this.mRoleIdIndex);
        QLog.d("GuildFeedUserPresenter", 2, "[fetchMemberListForFeed] GWGProFeedMemberListReq=" + apVar);
        iGPSService.fetchMemberListForFeed(apVar, new av() { // from class: uo0.e
            @Override // wh2.av
            public final void a(int i16, String str, IGProFeedMemberListRsp iGProFeedMemberListRsp) {
                f.d(f.this, cb5, isLoadMore, guildId, i16, str, iGProFeedMemberListRsp);
            }
        });
    }

    /* renamed from: e, reason: from getter */
    public final boolean getMIsFinish() {
        return this.mIsFinish;
    }
}
