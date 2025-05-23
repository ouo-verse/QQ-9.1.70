package xv1;

import android.util.SparseArray;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f448744a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<Class<? extends AbsGuildProfileComponent>> f448745b = new SparseArray<>();

    private AbsGuildProfileComponent b(int i3, IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        AbsGuildProfileComponent absGuildProfileComponent;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildProfileComponentProducer", 2, String.format("create componentType=%s", Integer.valueOf(i3)));
        }
        try {
            absGuildProfileComponent = this.f448745b.get(i3).getConstructor(IGuildComponentController.class, GuildProfileData.class).newInstance(iGuildComponentController, guildProfileData);
        } catch (Exception e16) {
            QLog.e("Guild.profile.GuildProfileComponentProducer", 1, "create component fail.", e16);
            absGuildProfileComponent = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildProfileComponentProducer", 2, String.format("create from base component factory. component=%s", absGuildProfileComponent));
        }
        return absGuildProfileComponent;
    }

    private void c() {
        this.f448745b.clear();
        SparseArray<Class<? extends AbsGuildProfileComponent>> a16 = new wv1.a().a();
        if (a16 != null && a16.size() > 0) {
            int size = a16.size();
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = a16.keyAt(i3);
                this.f448745b.put(keyAt, a16.get(keyAt));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildProfileComponentProducer", 2, String.format("initProfileComponentArray size=%s", Integer.valueOf(this.f448745b.size())));
        }
    }

    public AbsGuildProfileComponent a(int i3, IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        if (!this.f448744a.get()) {
            this.f448744a.set(true);
            c();
        }
        return b(i3, iGuildComponentController, guildProfileData);
    }
}
