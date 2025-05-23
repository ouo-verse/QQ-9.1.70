package uh2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import java.util.List;
import vh2.cd;
import wh2.aj;
import xh2.i;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface d {
    void fetchChannelLiveableRoleList(String str, String str2, @NonNull xh2.g gVar);

    void fetchRoleListWithPermission(String str, int i3, @NonNull xh2.a aVar);

    void fetchRoleWithPermission(String str, String str2, int i3, @NonNull xh2.b bVar);

    @NonNull
    dx getCategoryPermission(String str, String str2);

    @NonNull
    dx getChannelPermission(String str, String str2);

    void getChannelSpeakableRoleList(String str, String str2, @NonNull i iVar);

    void getChannelVisibleRoleList(String str, String str2, @NonNull aj ajVar);

    @NonNull
    dx getGuildPermission(String str);

    void setChannelLiveableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    void setChannelSpeakableRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);

    void setChannelVisibleRoleList(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull cd cdVar);
}
