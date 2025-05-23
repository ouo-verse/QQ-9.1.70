package yb0;

import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import cooperation.qqcircle.relation.entitys.FriendsWrapper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import vd2.GroupInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006H\u0002J\"\u0010\r\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006H\u0002J\"\u0010\u000e\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006H\u0002J8\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u0012J.\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u001e\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00160\u0012J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\b\u00a8\u0006\u001c"}, d2 = {"Lyb0/p;", "", "", "uinType", "", tl.h.F, "", "Lcom/tencent/mobileqq/data/Groups;", "", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "groupsListMap", "", "e", "d", "f", "selectType", "searchKey", "selectedList", "Landroidx/core/util/Consumer;", "Lo20/b;", "consumer", "l", "", "i", "Lcom/tencent/mobileqq/persistence/Entity;", "g", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f450005a = new p();

    p() {
    }

    private final void d(Map<Groups, List<QFSCommentAtEntity>> groupsListMap) {
        int i3;
        Map<GroupInfo, List<Entity>> friendGroupMap = QCircleRelationGroupManager.instance().getFriendGroupMap();
        Intrinsics.checkNotNullExpressionValue(friendGroupMap, "friendGroupMap");
        for (Map.Entry<GroupInfo, List<Entity>> entry : friendGroupMap.entrySet()) {
            GroupInfo key = entry.getKey();
            List<Entity> value = entry.getValue();
            if (TextUtils.equals(key.getGroupId(), "mutual_group") && !RFSafeListUtils.isEmpty(value)) {
                ArrayList arrayList = new ArrayList();
                for (Entity entity : value) {
                    if (entity instanceof FriendsWrapper) {
                        FriendsWrapper friendsWrapper = (FriendsWrapper) entity;
                        String str = friendsWrapper.uin;
                        if (QCircleCommonUtil.isFriend(str)) {
                            i3 = 0;
                        } else {
                            i3 = 10008;
                        }
                        arrayList.add(new QFSCommentAtEntity(str, null, friendsWrapper.getFriendNickWithAlias(), friendsWrapper.authType, i3));
                    }
                }
                Groups groups = new Groups();
                groups.group_id = 1009;
                groups.group_name = com.dataline.util.j.d(key.getGroupName());
                groupsListMap.put(groups, arrayList);
            }
        }
    }

    private final void e(Map<Groups, List<QFSCommentAtEntity>> groupsListMap) {
        Map<Groups, List<Friends>> groupFriendsMap = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getGroupFriendsMap(Integer.MAX_VALUE, true, null);
        if (groupFriendsMap == null || groupFriendsMap.isEmpty()) {
            return;
        }
        for (Map.Entry<Groups, List<Friends>> entry : groupFriendsMap.entrySet()) {
            Groups key = entry.getKey();
            List<Friends> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            for (Friends friends : value) {
                arrayList.add(new QFSCommentAtEntity(friends.uin, null, friends.getFriendNickWithAlias(), 0, 0));
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            groupsListMap.put(key, arrayList);
        }
    }

    private final void f(Map<Groups, List<QFSCommentAtEntity>> groupsListMap) {
        List<TroopInfo> sortedJoinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTroopInfoFromCache();
        if (RFSafeListUtils.isEmpty(sortedJoinedTroopInfoFromCache)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (TroopInfo troopInfo : sortedJoinedTroopInfoFromCache) {
            QFSCommentAtEntity qFSCommentAtEntity = new QFSCommentAtEntity(troopInfo.troopuin, null, troopInfo.getTroopDisplayName(), 0, 1);
            if (troopInfo.isOwner()) {
                arrayList.add(qFSCommentAtEntity);
            } else if (troopInfo.isAdmin()) {
                arrayList2.add(qFSCommentAtEntity);
            } else {
                arrayList3.add(qFSCommentAtEntity);
            }
        }
        if (!arrayList.isEmpty()) {
            Groups groups = new Groups();
            groups.group_id = 1008;
            groups.group_name = com.tencent.biz.qqcircle.utils.h.a(R.string.f1905942i);
            groupsListMap.put(groups, arrayList);
        }
        if (!arrayList2.isEmpty()) {
            Groups groups2 = new Groups();
            groups2.group_id = 2008;
            groups2.group_name = com.tencent.biz.qqcircle.utils.h.a(R.string.f1906242l);
            groupsListMap.put(groups2, arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            Groups groups3 = new Groups();
            groups3.group_id = 2009;
            groups3.group_name = com.tencent.biz.qqcircle.utils.h.a(R.string.f1906142k);
            groupsListMap.put(groups3, arrayList3);
        }
    }

    private final String h(int uinType) {
        if (uinType != 0) {
            if (uinType != 1) {
                if (uinType != 10008) {
                    return "";
                }
                String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1906342m);
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_forward_mutual_follow_title)");
                return a16;
            }
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1906042j);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_forward_group_title)");
            return a17;
        }
        String a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.f195634f5);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qfs_share_friend)");
        return a18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String selectType, final Consumer consumer) {
        Intrinsics.checkNotNullParameter(selectType, "$selectType");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        int hashCode = selectType.hashCode();
        if (hashCode != 28315162) {
            if (hashCode != 919262195) {
                if (hashCode == 984839491 && selectType.equals("select_type_troops")) {
                    f450005a.f(linkedHashMap);
                }
                p pVar = f450005a;
                pVar.e(linkedHashMap);
                pVar.f(linkedHashMap);
                pVar.d(linkedHashMap);
            } else {
                if (selectType.equals("select_type_friends")) {
                    f450005a.e(linkedHashMap);
                }
                p pVar2 = f450005a;
                pVar2.e(linkedHashMap);
                pVar2.f(linkedHashMap);
                pVar2.d(linkedHashMap);
            }
        } else {
            if (selectType.equals("select_type_mutual_follow")) {
                f450005a.d(linkedHashMap);
            }
            p pVar22 = f450005a;
            pVar22.e(linkedHashMap);
            pVar22.f(linkedHashMap);
            pVar22.d(linkedHashMap);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: yb0.o
            @Override // java.lang.Runnable
            public final void run() {
                p.k(Consumer.this, linkedHashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Consumer consumer, Map groupsListMap) {
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        Intrinsics.checkNotNullParameter(groupsListMap, "$groupsListMap");
        consumer.accept(groupsListMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String str, List selectedList, Consumer consumer, Map map) {
        boolean contains$default;
        boolean contains$default2;
        String searchKey = str;
        Intrinsics.checkNotNullParameter(searchKey, "$searchKey");
        Intrinsics.checkNotNullParameter(selectedList, "$selectedList");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        if (map == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Groups groups = (Groups) entry.getKey();
            for (QFSCommentAtEntity qFSCommentAtEntity : (List) entry.getValue()) {
                String uin = qFSCommentAtEntity.uin;
                int i3 = qFSCommentAtEntity.uinType;
                if (!QFSCommentAtHelper.N(arrayList, uin, i3)) {
                    String name = qFSCommentAtEntity.b();
                    if (!TextUtils.isEmpty(name)) {
                        Intrinsics.checkNotNullExpressionValue(uin, "uin");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) uin, (CharSequence) searchKey, false, 2, (Object) null);
                        if (!contains$default) {
                            Intrinsics.checkNotNullExpressionValue(name, "name");
                            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) searchKey, false, 2, (Object) null);
                            if (contains$default2) {
                            }
                        }
                        o20.b bVar = new o20.b();
                        bVar.c(new QFSCommentAtEntity(uin, null, name, 0, i3));
                        bVar.h(f450005a.h(i3));
                        bVar.g(groups);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(selectedList);
                        bVar.d(QFSCommentAtHelper.P(arrayList2, uin, i3));
                        arrayList.add(bVar);
                        searchKey = str;
                    }
                }
            }
            searchKey = str;
        }
        consumer.accept(arrayList);
    }

    @NotNull
    public final List<Entity> g() {
        Map<GroupInfo, List<Entity>> friendGroupMap = QCircleRelationGroupManager.instance().getFriendGroupMap();
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(friendGroupMap, "friendGroupMap");
        for (Map.Entry<GroupInfo, List<Entity>> entry : friendGroupMap.entrySet()) {
            GroupInfo key = entry.getKey();
            List<Entity> entities = entry.getValue();
            if (TextUtils.equals(key.getGroupId(), "mutual_group") && !RFSafeListUtils.isEmpty(entities)) {
                Intrinsics.checkNotNullExpressionValue(entities, "entities");
                arrayList.addAll(entities);
            }
        }
        return arrayList;
    }

    public final void i(@NotNull final String selectType, @NotNull final Consumer<Map<Groups, List<QFSCommentAtEntity>>> consumer) {
        Intrinsics.checkNotNullParameter(selectType, "selectType");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: yb0.n
            @Override // java.lang.Runnable
            public final void run() {
                p.j(selectType, consumer);
            }
        });
    }

    public final void l(@NotNull String selectType, @NotNull final String searchKey, @NotNull final List<? extends QFSCommentAtEntity> selectedList, @NotNull final Consumer<List<o20.b>> consumer) {
        Intrinsics.checkNotNullParameter(selectType, "selectType");
        Intrinsics.checkNotNullParameter(searchKey, "searchKey");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        i(selectType, new Consumer() { // from class: yb0.m
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                p.m(searchKey, selectedList, consumer, (Map) obj);
            }
        });
    }
}
