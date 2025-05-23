package we1;

import android.animation.TimeInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import java.util.ArrayList;
import we1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    final c.b f445497a;

    /* renamed from: b, reason: collision with root package name */
    final TimeInterpolator f445498b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TimeInterpolator timeInterpolator, c.b bVar) {
        this.f445497a = bVar;
        this.f445498b = timeInterpolator;
    }

    @Nullable
    public abstract GuildChannelListAnim.g a(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

    public abstract boolean b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18, ArrayList<GuildChannelListAnim.e> arrayList, ArrayList<GuildChannelListAnim.g> arrayList2);

    public abstract void c(GuildChannelListAnim.g gVar, long j3);

    public abstract void d(RecyclerView.ViewHolder viewHolder);

    public abstract void e(RecyclerView.ViewHolder viewHolder);

    public abstract void f();

    public abstract boolean g();
}
