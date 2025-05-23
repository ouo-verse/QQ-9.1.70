package x50;

import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QCircleBaseResPackage {

    /* renamed from: a, reason: collision with root package name */
    public int f447218a;

    /* renamed from: b, reason: collision with root package name */
    public String f447219b;

    /* renamed from: c, reason: collision with root package name */
    public String f447220c;

    /* renamed from: d, reason: collision with root package name */
    public String f447221d;

    /* renamed from: e, reason: collision with root package name */
    public String f447222e;

    /* renamed from: f, reason: collision with root package name */
    public String f447223f;

    /* renamed from: g, reason: collision with root package name */
    public String f447224g;

    /* renamed from: h, reason: collision with root package name */
    public String f447225h;

    /* renamed from: i, reason: collision with root package name */
    public String f447226i;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f447218a == bVar.f447218a && Objects.equals(this.f447219b, bVar.f447219b) && Objects.equals(this.f447220c, bVar.f447220c) && Objects.equals(this.f447223f, bVar.f447223f) && Objects.equals(this.f447221d, bVar.f447221d) && Objects.equals(this.f447222e, bVar.f447222e) && Objects.equals(this.f447224g, bVar.f447224g) && Objects.equals(this.f447225h, bVar.f447225h)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<String> getPreloadZipList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f447219b);
        arrayList.add(this.f447220c);
        arrayList.add(this.f447223f);
        arrayList.add(this.f447221d);
        arrayList.add(this.f447222e);
        arrayList.add(this.f447224g);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
    public List<QCircleActionType> getResRefreshActionTypeList() {
        return new ArrayList();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f447218a), this.f447219b, this.f447220c, this.f447223f, this.f447221d, this.f447222e, this.f447224g, this.f447225h);
    }

    @NotNull
    public String toString() {
        return "QFSMainAdConfigPackage{mTaskId=" + this.f447218a + ", mStaticPic='" + this.f447219b + "', mPagMotionPic='" + this.f447220c + "', mAPngMotionPic='" + this.f447223f + "', mFoldStaticPic='" + this.f447221d + "', mPagFoldMotionPic='" + this.f447222e + "', mAPngFoldMotionPic='" + this.f447224g + "', mJumpUrl='" + this.f447225h + "'}";
    }
}
