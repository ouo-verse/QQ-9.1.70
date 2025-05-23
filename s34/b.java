package s34;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s34.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\b\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0016R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\u001b\u0010!R\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b#\u0010\u000fR\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\"\u0010+\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Ls34/b;", "Ls34/a;", "", "getItemType", "", "getItemId", "d", "newItem", "", "c", "a", "", "b", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "troopUin", "k", "robotUin", "j", "robotName", "g", "robotAvatar", "e", h.F, "robotDesc", "", "f", "Ljava/util/List;", "i", "()Ljava/util/List;", "robotLabels", "I", "()I", "rank", "getCategoryId", "categoryId", "categoryName", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", DomainData.DOMAIN_NAME, "(Z)V", "isAdded", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> robotLabels;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int rank;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String categoryId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String categoryName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isAdded;

    public b(@NotNull String troopUin, @NotNull String robotUin, @NotNull String robotName, @NotNull String robotAvatar, @NotNull String robotDesc, @NotNull List<String> robotLabels, int i3, @NotNull String categoryId, @NotNull String categoryName, boolean z16) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(robotAvatar, "robotAvatar");
        Intrinsics.checkNotNullParameter(robotDesc, "robotDesc");
        Intrinsics.checkNotNullParameter(robotLabels, "robotLabels");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.troopUin = troopUin;
        this.robotUin = robotUin;
        this.robotName = robotName;
        this.robotAvatar = robotAvatar;
        this.robotDesc = robotDesc;
        this.robotLabels = robotLabels;
        this.rank = i3;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.isAdded = z16;
    }

    @Override // s34.a
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof b)) {
            return false;
        }
        b bVar = (b) newItem;
        if (!Intrinsics.areEqual(this.robotName, bVar.robotName) || !Intrinsics.areEqual(this.robotDesc, bVar.robotDesc) || !Intrinsics.areEqual(this.robotAvatar, bVar.robotAvatar) || this.isAdded != bVar.isAdded) {
            return false;
        }
        return true;
    }

    @Override // s34.a
    @Nullable
    public Object b(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof b)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        b bVar = (b) newItem;
        if (!Intrinsics.areEqual(this.robotName, bVar.robotName)) {
            arrayList.add(new c.RobotNamePayload(bVar.robotName));
        }
        if (!Intrinsics.areEqual(this.robotDesc, bVar.robotDesc)) {
            arrayList.add(new c.RobotDescPayload(bVar.robotDesc));
        }
        if (!Intrinsics.areEqual(this.robotAvatar, bVar.robotAvatar)) {
            arrayList.add(new c.RobotAvatarPayload(bVar.robotAvatar));
        }
        boolean z16 = this.isAdded;
        boolean z17 = bVar.isAdded;
        if (z16 != z17) {
            arrayList.add(new c.RobotAddedStatePayload(z17));
        }
        return arrayList;
    }

    @Override // s34.a
    public boolean c(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof b) && Intrinsics.areEqual(((b) newItem).robotUin, this.robotUin)) {
            return true;
        }
        return false;
    }

    @NotNull
    public a d() {
        return new b(this.troopUin, this.robotUin, this.robotName, this.robotAvatar, this.robotDesc, this.robotLabels, this.rank, this.categoryId, this.categoryName, this.isAdded);
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: f, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getRobotAvatar() {
        return this.robotAvatar;
    }

    @Override // s34.a
    @NotNull
    /* renamed from: getItemId, reason: from getter */
    public String getRobotUin() {
        return this.robotUin;
    }

    @Override // s34.a
    public int getItemType() {
        return 2;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getRobotDesc() {
        return this.robotDesc;
    }

    @NotNull
    public final List<String> i() {
        return this.robotLabels;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getRobotName() {
        return this.robotName;
    }

    @NotNull
    public final String k() {
        return this.robotUin;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsAdded() {
        return this.isAdded;
    }

    public final void n(boolean z16) {
        this.isAdded = z16;
    }
}
