package tx1;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {
    public static void a(Activity activity, String str, int i3, String[] strArr, Object[] objArr) {
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(str, QQGuildUIUtil.r(R.string.f1488410o), 0, 1).setSelectedIdList(strArr).setSelectedUIList(objArr).setMaxCountCanSelect(i3).setActivityRequestCode(2000));
    }

    public static void b(Activity activity, String str, String str2, int i3, String[] strArr, int i16) {
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(str, QQGuildUIUtil.r(R.string.f1488410o), 1, 5).setSelectedIdList(strArr).setRoleGroupId(str2).setMaxCountCanSelect(i3 - i16).setActivityRequestCode(2002));
    }

    public static List<a.b> c(String str, List<IGProUserInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (IGProUserInfo iGProUserInfo : list) {
            if (!ch.w0(iGProUserInfo)) {
                arrayList.add(new a.b(2, str, iGProUserInfo.getTinyId(), iGProUserInfo.getName()));
            }
        }
        return arrayList;
    }

    public static void d(Activity activity, String str, int i3, String[] strArr, Object[] objArr) {
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(str, QQGuildUIUtil.r(R.string.f154681fg), 5, 0).setSelectedIdList(strArr).setSelectedUIList(objArr).setMaxCountCanSelect(i3).setActivityRequestCode(2004));
    }

    public static void e(Activity activity, String str, String str2, int i3, boolean z16, String str3) {
        int i16;
        if (z16) {
            i16 = 8;
        } else {
            i16 = 2;
        }
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(str, str3, i16, 2).setRoleGroupId(str2).setMaxCountCanSelect(i3).setActivityRequestCode(2001));
    }

    public static void f(Activity activity, String str, String str2, int i3) {
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(str, QQGuildUIUtil.r(R.string.f154671ff), 6, 2).setRoleGroupId(str2).setMaxCountCanSelect(i3).setActivityRequestCode(2001));
    }

    public static List<a.b> g(String str, RoleGroupUserUIData[] roleGroupUserUIDataArr) {
        ArrayList arrayList = new ArrayList();
        for (RoleGroupUserUIData roleGroupUserUIData : roleGroupUserUIDataArr) {
            arrayList.add(new a.b(2, str, roleGroupUserUIData.getMTinyId(), roleGroupUserUIData.getMName()));
        }
        return arrayList;
    }
}
