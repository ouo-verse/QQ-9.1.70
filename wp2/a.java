package wp2;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements Comparable<a> {

    /* renamed from: d, reason: collision with root package name */
    private int f446024d;

    /* renamed from: e, reason: collision with root package name */
    private float f446025e;

    /* renamed from: f, reason: collision with root package name */
    private int f446026f = 0;

    public a(int i3, float f16) {
        this.f446024d = i3;
        this.f446025e = f16;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return -1;
        }
        if (aVar != this && aVar.f446024d != this.f446024d) {
            if (j() && !aVar.j()) {
                return 1;
            }
            if ((!j() && aVar.j()) || this.f446025e > aVar.i()) {
                return -1;
            }
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f446024d == ((a) obj).f446024d) {
            return true;
        }
        return false;
    }

    public int h() {
        return this.f446024d;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f446024d));
    }

    public float i() {
        return this.f446025e;
    }

    public boolean j() {
        if ((this.f446026f & 1) == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "SearchTnnNodeResult{mGroupId=" + this.f446024d + ", mScore=" + this.f446025e + ", mOpFlag=" + this.f446026f + '}';
    }
}
