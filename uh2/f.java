package uh2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.fn;
import java.util.List;
import vh2.ai;
import vh2.ak;
import vh2.bx;
import vh2.cc;
import vh2.cd;
import vh2.i;
import wh2.dv;
import xh2.q;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface f {
    void createRole(String str, @NonNull fn fnVar, @NonNull List<String> list, @NonNull i iVar);

    void deleteRole(String str, String str2, @NonNull cd cdVar);

    void fetchGuildSpeakableRoleList(String str, boolean z16, @NonNull q qVar);

    void fetchMemberListWithRole(String str, String str2, int i3, boolean z16, @NonNull ai aiVar);

    void fetchMemberRoleList(String str, String str2, String str3, int i3, @NonNull ak akVar);

    @Nullable
    IGProGuildRoleInfo getRoleInfo(String str, String str2);

    void loadMemberRoleList(String str, String str2, @NonNull bx bxVar);

    void modifyGuildSpeakableRoleList(String str, List<String> list, List<String> list2, dv dvVar);

    void setMemberRoles(String str, String str2, String str3, String str4, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cd cdVar);

    void setRoleInfo(String str, String str2, @NonNull fn fnVar, @NonNull cd cdVar);

    void setRoleOrder(String str, @NonNull List<String> list, @NonNull cd cdVar);

    void setRoleSpeakableChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cc ccVar);

    void setRoleVisibleChannels(String str, String str2, @NonNull List<String> list, @NonNull List<String> list2, @NonNull cc ccVar);
}
