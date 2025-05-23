package yo1;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lyo1/c;", "", "", "timeMs", "", "d", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "a", "channelId", "", "type", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleChannelInfo;", "channelInfo", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f450725a = new c();

    c() {
    }

    @NotNull
    public final com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b a() {
        return new a();
    }

    public final int b(long channelId, int type) {
        int i3;
        if (type == 1) {
            IGProChannelInfo channelInfo = ((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(String.valueOf(channelId));
            if (channelInfo != null) {
                i3 = channelInfo.getTextChannelSubtypeId();
            } else {
                i3 = 0;
            }
            return GuildChannelIconUtil.j(type, i3, 0, 4, null);
        }
        return GuildChannelIconUtil.j(type, 0, 0, 6, null);
    }

    public final int c(@NotNull GuildScheduleChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        return b(channelInfo.getChannelId(), channelInfo.getType());
    }

    @NotNull
    public final String d(long timeMs) {
        String format = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault()).format(new Date(timeMs));
        Intrinsics.checkNotNullExpressionValue(format, "format.format(Date(timeMs))");
        return format;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"yo1/c$a", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b {
        a() {
        }

        @Override // com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b
        @Nullable
        public RecyclerView.ItemAnimator a() {
            return new GuildChannelListAnim(new C11624a(), 3);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"yo1/c$a$a", "Lcom/tencent/mobileqq/guild/animate/subchannellist/GuildChannelListAnim$h;", "", "c", "b", "a", "onAnimEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: yo1.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C11624a implements GuildChannelListAnim.h {
            C11624a() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void a() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void b() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void c() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void onAnimEnd() {
            }
        }
    }
}
