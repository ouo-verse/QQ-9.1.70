package wv1;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.audio.GuildProfileAudioComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedComponent;
import com.tencent.mobileqq.guild.profile.profilecard.game.GuildProfileGameComponent;
import com.tencent.mobileqq.guild.profile.profilecard.joined.GuildProfileJoinedComponent;
import com.tencent.mobileqq.guild.profile.profilecard.main.GuildProfileHeaderComponent;
import com.tencent.mobileqq.guild.profile.profilecard.manage.GuildProfileLiveManageComponent;
import com.tencent.mobileqq.guild.profile.profilecard.manage.GuildProfileManageComponent;
import com.tencent.mobileqq.guild.profile.profilecard.privacy.GuildProfilePrivacyComponent;
import com.tencent.mobileqq.guild.profile.profilecard.switches.GuildProfileVisibilitySwitchesComponent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    public static SparseArray<Integer> b() {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        sparseArray.put(1000, Integer.valueOf(e(24.0f)));
        sparseArray.put(1007, Integer.valueOf(e(24.0f)));
        sparseArray.put(1001, Integer.valueOf(e(24.0f)));
        sparseArray.put(1003, Integer.valueOf(e(24.0f)));
        sparseArray.put(1004, Integer.valueOf(e(24.0f)));
        sparseArray.put(1005, Integer.valueOf(e(24.0f)));
        sparseArray.put(1008, Integer.valueOf(e(24.0f)));
        return sparseArray;
    }

    public static List<Integer> c(GuildProfileData guildProfileData) {
        ArrayList arrayList = new ArrayList();
        GuildBaseProfileData guildBaseProfileData = guildProfileData.getGuildBaseProfileData();
        if (guildBaseProfileData.f() == 1 || guildBaseProfileData.f() == 3) {
            arrayList.add(1001);
        }
        if (TextUtils.equals(guildBaseProfileData.j(), guildBaseProfileData.b())) {
            arrayList.add(1009);
        }
        if (ch.i0()) {
            arrayList.add(1005);
        }
        arrayList.add(1002);
        return arrayList;
    }

    public static List<Integer> d(GuildProfileData guildProfileData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1000);
        if (guildProfileData.getGuildBaseProfileData().f() == 2) {
            arrayList.add(1004);
        }
        arrayList.add(1007);
        arrayList.add(1008);
        if (!"0".equals(guildProfileData.getGuildId())) {
            arrayList.add(1003);
        }
        return arrayList;
    }

    private static int e(float f16) {
        return ViewUtils.dip2px(f16);
    }

    public SparseArray<Class<? extends AbsGuildProfileComponent>> a() {
        SparseArray<Class<? extends AbsGuildProfileComponent>> sparseArray = new SparseArray<>();
        sparseArray.put(1000, GuildProfileHeaderComponent.class);
        sparseArray.put(1001, GuildProfileAudioComponent.class);
        sparseArray.put(1002, GuildProfileManageComponent.class);
        sparseArray.put(1004, GuildProfileLiveManageComponent.class);
        sparseArray.put(1003, GuildProfileGameComponent.class);
        sparseArray.put(1005, GuildProfilePrivacyComponent.class);
        sparseArray.put(1008, GuildProfileFeedComponent.class);
        sparseArray.put(1007, GuildProfileJoinedComponent.class);
        sparseArray.put(1009, GuildProfileVisibilitySwitchesComponent.class);
        return sparseArray;
    }
}
