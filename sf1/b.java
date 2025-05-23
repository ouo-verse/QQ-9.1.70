package sf1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.channel.frame.openaction.ChannelAudioOpenAction;
import com.tencent.mobileqq.guild.channel.frame.openaction.d;
import com.tencent.mobileqq.guild.channel.frame.openaction.e;
import com.tencent.mobileqq.guild.channel.frame.openaction.f;
import com.tencent.mobileqq.guild.channel.frame.openaction.g;
import com.tencent.mobileqq.guild.channel.frame.openaction.h;
import com.tencent.mobileqq.guild.channel.frame.openaction.i;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.AbsJumpExtra;
import com.tencent.mobileqq.guild.jump.model.extras.PendingTransition;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, i> f433763a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<Integer, i> f433764b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static i f433765c = new com.tencent.mobileqq.guild.channel.frame.openaction.a();

    static {
        f433763a.put(7, new d());
        f433763a.put(5, new f());
        f433763a.put(2, new ChannelAudioOpenAction());
        f433763a.put(1, new h());
        f433764b.put(Integer.valueOf(IChannelType.APP_SUB_CHANNEL_TYPE_LINK), new e());
        f433764b.put(Integer.valueOf(IChannelType.APP_SUB_CHANNEL_TYPE_SCHEDULE), new g());
        com.tencent.mobileqq.guild.channel.frame.openaction.b bVar = new com.tencent.mobileqq.guild.channel.frame.openaction.b();
        for (int i3 : com.tencent.mobileqq.guild.constant.a.chatPieApplicationIds) {
            f433764b.put(Integer.valueOf(i3), bVar);
        }
    }

    private static boolean a(JumpGuildParam jumpGuildParam) {
        if (jumpGuildParam == null || TextUtils.isEmpty(jumpGuildParam.getGuildId()) || TextUtils.isEmpty(jumpGuildParam.getChannelId())) {
            return false;
        }
        return true;
    }

    @NonNull
    private static i b(int i3) {
        i iVar = f433764b.get(Integer.valueOf(i3));
        if (iVar == null) {
            return f433765c;
        }
        return iVar;
    }

    private static int c(String str, String str2) {
        IGProChannelInfo C = ch.C(ch.m(), str, str2);
        if (C == null) {
            return 0;
        }
        return (int) C.getApplicationId();
    }

    public static boolean d(Context context, JumpGuildParam jumpGuildParam) {
        if (!a(jumpGuildParam)) {
            QLog.e("Guild.jump.GuildChannelLauncher", 1, "launchGuildChannel: params is invalid.");
            return false;
        }
        return e(context, jumpGuildParam);
    }

    private static boolean e(Context context, JumpGuildParam jumpGuildParam) {
        i iVar;
        PendingTransition pendingTransition;
        int D = ch.D(jumpGuildParam.getChannelId());
        if (jumpGuildParam.isDirectMessage()) {
            D = 1;
        }
        if (D != 6) {
            iVar = f433763a.get(Integer.valueOf(D));
        } else {
            iVar = null;
        }
        if (iVar == null) {
            int c16 = c(jumpGuildParam.getGuildId(), jumpGuildParam.getChannelId());
            QLog.d("Guild.jump.GuildChannelLauncher", 1, "openChannel applicationId: ", Integer.valueOf(c16));
            iVar = b(c16);
        }
        boolean a16 = iVar.a(context, jumpGuildParam);
        if (a16 && (pendingTransition = (PendingTransition) AbsJumpExtra.loadFrom(jumpGuildParam.extras, PendingTransition.class)) != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(pendingTransition.enterAnim, pendingTransition.exitAnim);
        }
        GuildJumpDebugUtils.a("Guild.jump.GuildChannelLauncher", "launchGuildChannel: jumpSuccess: ", jumpGuildParam);
        if (!a16) {
            QLog.e("Guild.jump.GuildChannelLauncher", 1, "launchGuildChannel: jump failed.", jumpGuildParam);
        }
        return a16;
    }
}
