package sn0;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.qphone.base.util.QLog;
import in0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lsn0/a;", "Lin0/d;", "Landroid/content/Intent;", "intent", "Landroid/os/Bundle;", "extra", "Landroidx/fragment/app/FragmentManager;", "fm", "", "containerId", "Lus/a;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements d {
    @Override // in0.d
    @Nullable
    public us.a a(@Nullable Intent intent, @Nullable Bundle extra, @NotNull FragmentManager fm5, int containerId) {
        Intrinsics.checkNotNullParameter(fm5, "fm");
        if (extra == null) {
            QLog.d("GuildChosenChatFragmentCreator", 1, "create args error!");
            return null;
        }
        String string = extra.getString("guild_chosen_guild_id");
        String string2 = extra.getString("guild_chosen_channel_id");
        if (string2 != null && string != null) {
            extra.putSerializable("AIOParam_ContainerType", ContainerType.STAND_TYPE);
            AIOContact aIOContact = new AIOContact(4, string2, string, "");
            Bundle bundle = new Bundle();
            bundle.putAll(extra);
            AIOParam.a aVar = new AIOParam.a();
            String name = qn0.a.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildChosenAIOFactory::class.java.name");
            AIOParam c16 = aVar.e(name).h(new AIOSession(aIOContact)).d(0).a(bundle).c();
            new Bundle().putParcelable("aio_param", c16);
            return com.tencent.aio.main.engine.b.d(com.tencent.aio.main.engine.b.f69377a, c16, fm5, containerId, null, 8, null);
        }
        QLog.d("GuildChosenChatFragmentCreator", 1, "create aioConstants args error!");
        return null;
    }
}
