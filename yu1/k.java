package yu1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.aj;
import yx1.RoleSelectItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0017\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b9\u0010:J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010J\u001e\u0010\u0018\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0015j\b\u0012\u0004\u0012\u00020\u0004`\u0016J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0015j\b\u0012\u0004\u0012\u00020\u0004`\u0016J\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0015j\b\u0012\u0004\u0012\u00020\u001a`\u0016R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0015j\b\u0012\u0004\u0012\u00020\u0004`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00101\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\u00100\u00100-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\u00040\u00040%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u001d\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0&048F\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u0010048F\u00a2\u0006\u0006\u001a\u0004\b8\u00106\u00a8\u0006="}, d2 = {"Lyu1/k;", "Lef1/b;", "", "result", "", "errMsg", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleList", "", "T1", "U1", "channelId", "X1", "Lyx1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "checked", ICustomDataEditor.STRING_ARRAY_PARAM_2, "selectAll", "c2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectIds", "b2", "R1", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "S1", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "D", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "roleGroupRepository", "Landroidx/lifecycle/MutableLiveData;", "", "E", "Landroidx/lifecycle/MutableLiveData;", "_liveRoleSelectListLiveData", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "selectedRoleIds", "Le12/e;", "kotlin.jvm.PlatformType", "G", "Le12/e;", "_selectAll", "H", "_errMsg", "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "liveRoleSelectList", "Q1", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final IRoleGroupListRepository roleGroupRepository;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<RoleSelectItem>> _liveRoleSelectListLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<String> selectedRoleIds;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Boolean> _selectAll;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _errMsg;

    public k(@NotNull String guildId, @NotNull IRoleGroupListRepository roleGroupRepository) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroupRepository, "roleGroupRepository");
        this.guildId = guildId;
        this.roleGroupRepository = roleGroupRepository;
        this._liveRoleSelectListLiveData = new MutableLiveData<>();
        this.selectedRoleIds = new ArrayList<>();
        this._selectAll = new e12.e<>(Boolean.TRUE);
        this._errMsg = new MutableLiveData<>("");
    }

    private final void T1(int result, String errMsg, List<IGProGuildRoleInfo> roleList) {
        int collectionSizeOrDefault;
        Set set;
        int collectionSizeOrDefault2;
        if (result == 0) {
            ArrayList arrayList = null;
            if (roleList != null) {
                List<IGProGuildRoleInfo> list = roleList;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                for (IGProGuildRoleInfo iGProGuildRoleInfo : list) {
                    arrayList2.add(new RoleSelectItem(this.selectedRoleIds.contains(iGProGuildRoleInfo.getRoleId()), true, false, RoleGroupModel.INSTANCE.f(iGProGuildRoleInfo, null, new ArrayList(), new ArrayList())));
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                this._liveRoleSelectListLiveData.setValue(arrayList);
                ArrayList arrayList3 = arrayList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList4.add(((RoleSelectItem) it.next()).getRole().getId());
                }
                set = CollectionsKt___CollectionsKt.toSet(arrayList4);
                this.selectedRoleIds.retainAll(set);
                c2(this.selectedRoleIds.isEmpty());
                return;
            }
            return;
        }
        QLog.d("Guild.rg.SelectRoleViewModel", 1, "onFetchVisibleRoleListResult fail " + errMsg);
        if (errMsg != null) {
            this._errMsg.setValue(errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(k this$0, ri1.a error, RoleGroupListModel roleGroupListModel) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Set set;
        List<RoleGroupModel> d16;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.d()) {
            if (roleGroupListModel != null && (d16 = roleGroupListModel.d()) != null) {
                ArrayList<RoleGroupModel> arrayList2 = new ArrayList();
                for (Object obj : d16) {
                    if (!((RoleGroupModel) obj).C()) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                arrayList = new ArrayList(collectionSizeOrDefault2);
                for (RoleGroupModel roleGroupModel : arrayList2) {
                    arrayList.add(new RoleSelectItem(this$0.selectedRoleIds.contains(roleGroupModel.getId()), true, false, roleGroupModel));
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                this$0._liveRoleSelectListLiveData.setValue(arrayList);
                ArrayList arrayList3 = arrayList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList4.add(((RoleSelectItem) it.next()).getRole().getId());
                }
                set = CollectionsKt___CollectionsKt.toSet(arrayList4);
                this$0.selectedRoleIds.retainAll(set);
                this$0.c2(this$0.selectedRoleIds.isEmpty());
                return;
            }
            return;
        }
        QLog.d("Guild.rg.SelectRoleViewModel", 1, "fetchRoleGroupListWithPermission fail " + error.f431478b);
        this$0._errMsg.setValue(error.f431478b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(k this$0, int i3, String str, int i16, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T1(i3, str, arrayList);
    }

    @NotNull
    public final LiveData<List<RoleSelectItem>> P1() {
        return this._liveRoleSelectListLiveData;
    }

    @NotNull
    public final LiveData<Boolean> Q1() {
        return this._selectAll;
    }

    @NotNull
    public final ArrayList<String> R1() {
        return this.selectedRoleIds;
    }

    @NotNull
    public final ArrayList<RoleGroupModel> S1() {
        ArrayList<RoleGroupModel> arrayList = new ArrayList<>();
        List<RoleSelectItem> value = this._liveRoleSelectListLiveData.getValue();
        if (value != null) {
            for (RoleSelectItem roleSelectItem : value) {
                if (roleSelectItem.getIsSelect()) {
                    arrayList.add(roleSelectItem.getRole());
                }
            }
        }
        return arrayList;
    }

    public final void U1() {
        this.roleGroupRepository.h(new FetchRoleGroupParam(this.guildId, null, false, 115, 6, null), new com.tencent.mobileqq.guild.base.repository.h() { // from class: yu1.i
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                k.W1(k.this, aVar, (RoleGroupListModel) obj);
            }
        });
    }

    public final void X1(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
        if (channelInfo == null) {
            QLog.e("Guild.rg.SelectRoleViewModel", 1, "refreshVisibleRoleList fail to get channelInfo.");
        }
        if (channelInfo.getVisibleType() != 1) {
            iGPSService.fetchChannelVisibleRoleListWithoutLevelRole(com.tencent.guild.aio.input.at.utils.g.a(this.guildId, 0L), com.tencent.guild.aio.input.at.utils.g.a(channelId, 0L), new aj() { // from class: yu1.j
                @Override // wh2.aj
                public final void onFetchChannelVisibleRoleList(int i3, String str, int i16, ArrayList arrayList) {
                    k.Z1(k.this, i3, str, i16, arrayList);
                }
            });
        } else {
            U1();
        }
    }

    public final void a2(@NotNull RoleSelectItem item, boolean checked) {
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("Guild.rg.SelectRoleViewModel", 4, "selectRole " + item.a() + " " + checked);
        if (checked) {
            this.selectedRoleIds.add(item.a());
        } else {
            this.selectedRoleIds.remove(item.a());
        }
        List<RoleSelectItem> value = this._liveRoleSelectListLiveData.getValue();
        if (value != null) {
            for (RoleSelectItem roleSelectItem : value) {
                if (Intrinsics.areEqual(roleSelectItem.a(), item.a())) {
                    roleSelectItem.f(checked);
                }
            }
        }
        MutableLiveData<List<RoleSelectItem>> mutableLiveData = this._liveRoleSelectListLiveData;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    public final void b2(@NotNull ArrayList<String> selectIds) {
        Intrinsics.checkNotNullParameter(selectIds, "selectIds");
        this.selectedRoleIds.clear();
        this.selectedRoleIds.addAll(selectIds);
        c2(this.selectedRoleIds.isEmpty());
        List<RoleSelectItem> value = this._liveRoleSelectListLiveData.getValue();
        if (value != null) {
            for (RoleSelectItem roleSelectItem : value) {
                roleSelectItem.f(this.selectedRoleIds.contains(roleSelectItem.a()));
            }
        }
        MutableLiveData<List<RoleSelectItem>> mutableLiveData = this._liveRoleSelectListLiveData;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    public final void c2(boolean selectAll) {
        this._selectAll.setValue(Boolean.valueOf(selectAll));
    }
}
