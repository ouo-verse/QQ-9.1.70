package zv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.remove.GuildRemoveGuildDialogViewModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a8\u0006\u0016"}, d2 = {"Lzv1/j;", "", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/GuildRemoveGuildDialogFragment;", "fragment", "", "d", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "a", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/GuildSecondaryAuthorityViewModel;", "authorityViewModel", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/GuildRemoveGuildDialogViewModel;", "guildRemoveViewModel", "c", "", "isBlack", "", "msgRevokeType", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface j {
    @NotNull
    View a(@NotNull LayoutInflater inflater, @Nullable ViewGroup container);

    void b(boolean isBlack, int msgRevokeType);

    void c(@NotNull GuildSecondaryAuthorityViewModel authorityViewModel, @NotNull GuildRemoveGuildDialogViewModel guildRemoveViewModel);

    void d(@NotNull GuildRemoveGuildDialogFragment fragment);
}
