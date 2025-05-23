package ti1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalLike;
import ij1.g;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a extends DiffUtil.ItemCallback<g> {
    public boolean a(@NonNull g gVar, @NonNull g gVar2) {
        GProStFeed b16 = gVar.b();
        GProTotalLike gProTotalLike = b16.totalLike;
        int i3 = gProTotalLike.likeCount;
        boolean z16 = gProTotalLike.isClicked;
        int i16 = b16.share.sharedCount;
        int i17 = b16.commentCount;
        GProStFeed b17 = gVar2.b();
        GProTotalLike gProTotalLike2 = b17.totalLike;
        int i18 = gProTotalLike2.likeCount;
        int i19 = b17.share.sharedCount;
        int i26 = b17.commentCount;
        boolean z17 = gProTotalLike2.isClicked;
        if (i3 == i18 && i16 == i19 && i17 == i26 && z17 == z16) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    @SuppressLint({"DiffUtilEquals"})
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NonNull g gVar, @NonNull g gVar2) {
        if (e() || gVar.p() != null || gVar2.p() != null || gVar.b() != gVar2.b()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NonNull g gVar, @NonNull g gVar2) {
        boolean z16;
        if (gVar.b().idd.equals(gVar2.b().idd) && d(gVar, gVar2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedDiffUtilCallback", 2, "[areItemsTheSame] result " + z16 + ", oldItem: " + gVar.b().idd + ", oldSourceData: " + gVar.b() + ", newItem: " + gVar2.b().idd + ", newSourceData: " + gVar2.b());
        }
        return z16;
    }

    public boolean d(@NonNull g gVar, @NonNull g gVar2) {
        GProStFeed b16 = gVar.b();
        String str = b16.poster.nick;
        long j3 = b16.latestInteraction.timestamp;
        long j16 = b16.createTime;
        long j17 = b16.meta.lastModifiedTime;
        GProStFeed b17 = gVar2.b();
        String str2 = b17.poster.nick;
        long j18 = b17.latestInteraction.timestamp;
        long j19 = b17.createTime;
        long j26 = b17.meta.lastModifiedTime;
        if (TextUtils.equals(str2, str) && j3 == j18 && j16 == j19 && j17 == j26) {
            return true;
        }
        return false;
    }

    public abstract boolean e();

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    @Nullable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object getChangePayload(@NonNull g gVar, @NonNull g gVar2) {
        if (!e() && !a(gVar, gVar2)) {
            return gVar2;
        }
        return null;
    }
}
